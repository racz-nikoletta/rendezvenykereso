<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['fullname']) && isset($_POST['foodType']) && isset($_POST['foodName']) && isset($_POST['foodAttributes']) && isset($_POST['foodSauce']) && isset($_POST['orderDate'])) {
    if ($db->dbConnect()) {
        if ($db->orderFood("orders", $_POST['fullname'], $_POST['foodType'], $_POST['foodName'], $_POST['foodAttributes'], $_POST['foodSauce'], $_POST['orderDate'])) {
            echo "Order Success";
        } else echo "Order Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>