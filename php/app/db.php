<?php
$host = "localhost";
$user = "root";
$password = "";
$db = "app";

$conn = mysqli_connect($host, $user, $password, $db);

if (!$conn) {
    die("DB Connection failed!!");
}

?>