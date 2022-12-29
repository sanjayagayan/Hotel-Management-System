-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2020 at 09:36 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `add_employee`
--

CREATE TABLE `add_employee` (
  `ID` int(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Designation` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Account_No` int(20) NOT NULL,
  `Contact_No` int(10) NOT NULL,
  `Salary` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `add_employee`
--

INSERT INTO `add_employee` (`ID`, `Name`, `Designation`, `Address`, `Email`, `Account_No`, `Contact_No`, `Salary`) VALUES
(1200, 'Chamika', 'Miss', 'Anuradhapura', 'Chami@gmail.com', 13213215, 712115886, 50000),
(1300, 'Chariii', 'cvbn', 'Sayalaa', 'chari@gmail.com', 31213132, 704855961, 30000),
(1600, 'sanju', 'senner', 'mumbai', 'sanju@gmail.com', 13213545, 778596245, 60000),
(2100, 'vishmi', 'miss', 'kalthota', 'vishmi@gmail.com', 2132132, 785426231, 56000),
(2300, 'sachith', 'Dicla', 'Nowaththa', 'Sachith@gmail.com', 9658745, 758469562, 60000);

-- --------------------------------------------------------

--
-- Table structure for table `home`
--

CREATE TABLE `home` (
  `Customer_Ref` int(5) NOT NULL,
  `First_Name` varchar(10) NOT NULL,
  `Sur_Name` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Mobile_No` int(10) NOT NULL,
  `Nationality` varchar(10) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `ID_No` varchar(10) NOT NULL,
  `Check_In` date NOT NULL,
  `Check_out` date NOT NULL,
  `Room_No` int(5) NOT NULL,
  `Room_Type` varchar(8) NOT NULL,
  `Bed_Type` varchar(8) NOT NULL,
  `Rate` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `home`
--

INSERT INTO `home` (`Customer_Ref`, `First_Name`, `Sur_Name`, `Address`, `Mobile_No`, `Nationality`, `Gender`, `ID_No`, `Check_In`, `Check_out`, `Room_No`, `Room_Type`, `Bed_Type`, `Rate`) VALUES
(3, 'chamith', 'Rathnayaka', 'Marapana', 712458963, 'English', 'Male', '971512962v', '2020-03-01', '2020-03-05', 312, 'AC', 'Double', 3000),
(6, 'Sanju', 'mahesh', 'Kadawatha', 712115778, 'Sinhaa', 'Male', '31321322v', '2020-05-07', '2020-05-17', 50, 'NON AC', 'Single', 1000),
(11, 'sanjaya', 'gayan', 'marapana', 715128962, 'sinhala', 'Male', '971512896v', '2020-05-05', '2020-05-08', 100, 'AC', 'Family', 2000),
(13, 'sanjana', 'adhikari', 'colombo', 715129632, 'Sri Lanka', 'Female', '971635845v', '2019-05-16', '2019-05-17', 56, 'NON AC', 'Single', 2000),
(15, 'chaminda', 'sandaruwan', 'nivithigala', 768455123, 'Sri Lanka', 'Male', '984562230v', '2020-08-04', '2020-09-08', 45, 'AC', 'Single', 2100),
(17, 'zimam', 'suwith', 'trinco', 784526231, 'Muslim', 'Male', '971845623v', '2020-05-01', '2020-05-31', 54, 'AC', 'Double', 2300),
(18, 'queen', 'wishwa', 'hatton', 784526231, 'hindu', 'Female', '974845623v', '2019-05-05', '2019-05-26', 45, 'NON AC', 'Single', 23100),
(19, 'nimmi', 'sayuru', 'vinweel', 785263526, 'spanish', 'Female', '974526321v', '2021-05-08', '2021-05-16', 456, 'AC', 'Single', 120000),
(22, 'chathuuu', 'sayuru', 'vinweel', 785263526, 'spanish', 'Female', '974526321v', '2021-05-08', '2021-05-16', 456, 'AC', 'Single', 120000),
(23, 'sanjana', 'chimmi', 'Kalthota', 708459564, 'Sri Lanka', 'Female', '971512896v', '2020-05-17', '2020-05-27', 132, 'AC', 'Single', 1000),
(24, 'Sewwandi', 'Adhikari', 'Awissawella', 778459564, 'Sri Lanka', 'Select', '789456123v', '2020-05-01', '2020-05-09', 123, 'AC', 'Double', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `Room_No` int(5) NOT NULL,
  `Bed_Type` varchar(10) NOT NULL,
  `Room_Type` varchar(10) NOT NULL,
  `Room_Price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`Room_No`, `Bed_Type`, `Room_Type`, `Room_Price`) VALUES
(123, 'Double', 'AC', 5000),
(124, 'Single', 'NON/AC', 500),
(128, 'double', 'AC', 2000),
(129, 'single', 'NONAC', 3000),
(130, 'single', 'AC', 4000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `add_employee`
--
ALTER TABLE `add_employee`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `home`
--
ALTER TABLE `home`
  ADD PRIMARY KEY (`Customer_Ref`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`Room_No`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `home`
--
ALTER TABLE `home`
  MODIFY `Customer_Ref` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
