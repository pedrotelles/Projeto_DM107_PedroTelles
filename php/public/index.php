<?php
    use \Psr\Http\Message\ServerRequestInterface as Request;
    use \Psr\Http\Message\ResponseInterface as Response;
    require '../vendor/autoload.php';
    $config['displayErrorDetails'] = true;
    $config['addContentLengthHeader'] = false;
    $config['db']['host'] = "127.0.0.1";
    $config['db']['port'] = "3307";
    $config['db']['user'] = "root";
    $config['db']['pass'] = "";
    $config['db']['dbname'] = "posdm107";
    $app = new \Slim\App(["config" => $config]);
    $container = $app->getContainer();
    
    $container['db'] = function ($c) {
        $dbConfig = $c['config']['db'];
        $pdo = new PDO("mysql:host=" . $dbConfig['host'] .";port=".$dbConfig['port'] .";dbname=".$dbConfig['dbname'],$dbConfig['user'], $dbConfig['pass']);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_ASSOC);
        $db = new NotORM($pdo);
        return $db;
    };
    function getCredentials($db){
        
                $usuarios = array();
                foreach($db->usuario() as $usuario){
                
                        $usuarios[$usuario['usuario']] = $usuario["senha"];
                            
                }
                return $usuarios;
    }
    $app->add(new \Slim\Middleware\HttpBasicAuthentication([
        "users" => getCredentials($container['db'])
    ]));

    

    $app->put('/api/entrega/{id}', function (Request $request, Response $response) {
       
        $idTarefa = $request->getAttribute("id");
        $form = $request->getParsedBody();
        

        $entregaD = $this->db->entregas->where("id = ?",$idTarefa)->fetch();
        if ($entregaD !== false && isset($form["cpf"]) && isset($form["nome"]) && isset($form["dataHoraEntrega"])) {
            $entrega = array(
                "cpf" => $form["cpf"],
                "nome" => $form["nome"],
                "dataHoraEntrega" => $form["dataHoraEntrega"]
            );
            $result = $entregaD->update($entrega);
            return $response->withStatus(204);
        } 
		elseif ($entregaD !== false && (!isset($form["cpf"]) || !isset($form["nome"]) || !isset($form["dataHoraEntrega"]))) 
        {
			if(!isset($form["cpf"])){
				echo ("Campo obrigatório: cpf. Digite esse campo novamente.\n\n");
			}
			if(!isset($form["nome"])){
				echo ("Campo obrigatório: nome. Digite esse campo novamente.\n\n");
			}
			if(!isset($form["dataHoraEntrega"])){
				echo ("Campo obrigatório: data e hora da entrega. Digite esse campo novamente.\n\n");
			}
			return $response->withStatus(400);
		}
		else {
            return $response->withStatus(404);
        }
        
    });

    $app->delete('/api/entrega/{id}', function (Request $request, Response $response) {
        
         $idTarefa = $request->getAttribute("id");
         
         
 
         $entregaD = $this->db->entregas->where("id = ?",$idTarefa)->fetch();
         if ($entregaD !== false ) {
             
             $result = $entregaD->delete();
             echo $result;
         } else {
             return $response->withStatus(404);
         }
         
     });

    
    $app->run();
?>