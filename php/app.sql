-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 09, 2024 at 05:53 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `app`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `name_ur` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`, `name_ur`) VALUES
(1, 'All', ''),
(2, 'Smartphones', ''),
(3, 'Headphones', ''),
(4, 'Laptops', ''),
(5, 'Gaming Mouse', ''),
(6, 'Airbuds', '');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `category_id` int(11) NOT NULL,
  `price` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `created_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `category_id`, `price`, `image`, `description`, `created_date`) VALUES
(1, 'Samsung Note 23', 2, '250000', 'samsung.jpg', 'Galaxy S23 Ultra · 200MP camera, the highest resolution on a phone · Our fastest mobile processor ever** · Advanced Nightography · Built-in S Pen with camera', '2024-01-09 20:52:18'),
(2, 'iPhone 15', 2, '500000', 'iphone.jpg', 'iPhone 15 and iPhone 15 Plus. Dynamic Island. 48MP Main camera with 2x Telephoto. All-day battery life. USB-C. 6.1” and 6.7” sizes.', '2024-01-09 20:54:01'),
(3, 'Asus Zephyrus G16', 4, '450000', 'asus.jpg', 'Power, precision, and elegance define the 2024 Zephyrus G16. Thinner and sleeker than ever before, the Zephyrus G16 still has the same sense of style ', '2024-01-09 20:56:55'),
(4, 'HP Omen 2023', 4, '350000', 'hp_omen.jpg', 'OMEN TRANSCEND 16 INCH INTEL GAMING LAPTOP · Up to WQXGA (2560 x 1600), OLED, 240 Hz, 1 ms response time, 16” display · Up to Intel® Core™ 9-14900HX', '2024-01-09 20:56:55'),
(5, 'Razor Gaming Mouse', 5, '15000', 'mouse.png', 'Razor Gaming Mouse 8 Buttons 75 DPI', '2024-01-09 20:58:55');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  `created_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `phone`, `password`, `is_deleted`, `created_date`) VALUES
(1, 'ali', 'ali@demo.com', '02106404', '12345', 0, '2023-12-12 21:03:07'),
(2, 'usman', 'usman@demo.com', '10541321032', '12345', 0, '2023-12-12 17:15:19'),
(3, 'usman', 'usman@demo.com', '10541321032', '12345', 0, '2023-12-12 17:15:32'),
(4, 'furqan', 'furqan@demo.com', '0310634634', 'leofurqan', 0, '2023-12-12 17:39:51'),
(5, 'furqan', 'furqan@demo.com', '0310634634', 'leofurqan', 1, '2023-12-12 17:40:08'),
(6, 'waqas', 'waqas@gmail.com', '03210460464', '11223344', 0, '2023-12-12 17:47:18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
