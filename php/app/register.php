<?php
include "db.php";

if (!empty($_POST['username']) && !empty($_POST['email']) && !empty($_POST['phone']) && !empty($_POST['password'])) {
    $username = $_POST['username'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];
    $password = $_POST['password'];
    $date = date('Y-m-d H:i:s');

    $query = "INSERT INTO users(username, email, phone, password, created_date) VALUES ('$username', '$email', '$phone', '$password', '$date')";
    $result = mysqli_query($conn, $query);

    if ($result) {
        echo json_encode(array(
            'status' => TRUE,
            'message' => "User created successfully"
        ));
    } else {
        echo json_encode(array(
            'status' => FALSE,
            'message' => "Something went wrong"
        ));
    }
} else {
    echo json_encode(array(
        'status' => FALSE,
        'message' => "Invalid Request"
    ));
}
