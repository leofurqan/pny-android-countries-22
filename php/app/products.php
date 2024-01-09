<?php
include "db.php";

$category_id = $_GET['category_id'];

if($category_id == "1") {
    $query = "SELECT * FROM products";
} else {
    $query = "SELECT * FROM products WHERE category_id = '$category_id'";
}

$result = mysqli_query($conn, $query);
$products = array();


while($row = mysqli_fetch_assoc($result)) {
    $products[] = $row;
}

echo json_encode(array(
    'status' => TRUE,
    'products' => $products
));