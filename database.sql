-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2018 at 03:35 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lnwsus`
--

-- --------------------------------------------------------

--
-- Table structure for table `name`
--

CREATE TABLE `name` (
  `idname` int(11) NOT NULL,
  `name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `name`
--

INSERT INTO `name` (`idname`, `name`) VALUES
(1, 'Lnwsus'),
(2, 'Lnwsus'),
(3, 'Lnwsus'),
(4, 'Lnwsus'),
(5, 'Lnwsus'),
(6, 'Lnwsus'),
(7, 'Lnwsus'),
(8, 'Lnwsus'),
(9, 'Lnwsus'),
(10, 'Lnwsus'),
(11, 'Lnwsus'),
(12, 'Lnwsus');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `idscore` int(11) NOT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`idscore`, `score`) VALUES
(1, 100),
(2, 100),
(3, 100),
(4, 100),
(5, 100),
(6, 100),
(7, 100),
(8, 100),
(9, 100),
(10, 100),
(11, 100),
(12, 100);

-- --------------------------------------------------------

--
-- Table structure for table `showall`
--

CREATE TABLE `showall` (
  `idshowall` int(11) NOT NULL,
  `idname` int(11) DEFAULT NULL,
  `idscore` int(11) DEFAULT NULL,
  `idtime` int(11) DEFAULT NULL,
  `idtotal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `showall`
--

INSERT INTO `showall` (`idshowall`, `idname`, `idscore`, `idtime`, `idtotal`) VALUES
(1, 1, 1, 1, 1),
(2, 2, 2, 2, 2),
(3, 3, 3, 3, 3),
(4, 4, 4, 4, 4),
(5, 5, 5, 5, 5),
(6, 6, 6, 6, 6),
(7, 7, 7, 7, 7),
(8, 8, 8, 8, 8),
(9, 9, 9, 9, 9),
(10, 10, 10, 10, 10),
(11, 11, 11, 11, 11),
(12, 12, 12, 12, 12);

-- --------------------------------------------------------

--
-- Table structure for table `time`
--

CREATE TABLE `time` (
  `idtime` int(11) NOT NULL,
  `time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `time`
--

INSERT INTO `time` (`idtime`, `time`) VALUES
(1, 10),
(2, 10),
(3, 10),
(4, 10),
(5, 10),
(6, 10),
(7, 10),
(8, 10),
(9, 10),
(10, 10),
(11, 10),
(12, 10);

-- --------------------------------------------------------

--
-- Table structure for table `total`
--

CREATE TABLE `total` (
  `idtotal` int(11) NOT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `total`
--

INSERT INTO `total` (`idtotal`, `total`) VALUES
(1, 1000),
(2, 1000),
(3, 1000),
(4, 1000),
(5, 1000),
(6, 1000),
(7, 1000),
(8, 1000),
(9, 1000),
(10, 1000),
(11, 1000),
(12, 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `name`
--
ALTER TABLE `name`
  ADD PRIMARY KEY (`idname`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`idscore`);

--
-- Indexes for table `showall`
--
ALTER TABLE `showall`
  ADD PRIMARY KEY (`idshowall`),
  ADD KEY `idname` (`idname`),
  ADD KEY `idscore` (`idscore`),
  ADD KEY `idtime` (`idtime`),
  ADD KEY `idtotal` (`idtotal`);

--
-- Indexes for table `time`
--
ALTER TABLE `time`
  ADD PRIMARY KEY (`idtime`);

--
-- Indexes for table `total`
--
ALTER TABLE `total`
  ADD PRIMARY KEY (`idtotal`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `showall`
--
ALTER TABLE `showall`
  ADD CONSTRAINT `showall_ibfk_1` FOREIGN KEY (`idname`) REFERENCES `name` (`idname`),
  ADD CONSTRAINT `showall_ibfk_2` FOREIGN KEY (`idscore`) REFERENCES `score` (`idscore`),
  ADD CONSTRAINT `showall_ibfk_3` FOREIGN KEY (`idtime`) REFERENCES `time` (`idtime`),
  ADD CONSTRAINT `showall_ibfk_4` FOREIGN KEY (`idtotal`) REFERENCES `total` (`idtotal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
