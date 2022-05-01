<?php

$servername = "localhost";
$username = "root";
$password = "";
$database = "vizsga";

$conn = new mysqli($servername, $username, $password, $database);
 

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
 

$heroes = array(); 
 

$sql = "SELECT id, nev FROM rendezvenyek;";
 

$stmt = $conn->prepare($sql);
 

$stmt->execute();
 

$stmt->bind_result($id, $nev);
 

while($stmt->fetch()){
 
 
 $temp = [
 'id'=>$id,
 'nev'=>$nev
 ];
 

 array_push($heroes, $temp);
}
 

echo json_encode($heroes);
 
