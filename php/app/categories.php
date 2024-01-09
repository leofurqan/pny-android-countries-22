<?php
include "db.php";

$query = "SELECT * FROM categories";
$result = mysqli_query($conn, $query);
$categories = array();

while($category = mysqli_fetch_assoc($result)) {
    $categories[] = $category;
}

echo json_encode(array(
    'status' => TRUE,
    'categories' => $categories
));