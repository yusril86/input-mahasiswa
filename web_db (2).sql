-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2019 at 11:03 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `web_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `akademik`
--

CREATE TABLE `akademik` (
  `id` int(5) NOT NULL,
  `tahun` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akademik`
--

INSERT INTO `akademik` (`id`, `tahun`) VALUES
(1, '2017/2018'),
(2, '2018/2019');

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `id` int(11) NOT NULL,
  `nama` varchar(80) NOT NULL,
  `nim` varchar(40) NOT NULL,
  `kelas` varchar(50) NOT NULL,
  `semester` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `gambar` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`id`, `nama`, `nim`, `kelas`, `semester`, `status`, `gambar`) VALUES
(1, 'Febrian', '21728007', 'A', 'V', 'lunas', ''),
(2, 'Yusril', '217280035', 'A', 'V', 'lunas', ''),
(3, 'Walda', '217280026', 'A', 'V', 'lunas', '');

-- --------------------------------------------------------

--
-- Table structure for table `data_b`
--

CREATE TABLE `data_b` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `nim` int(30) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `semester` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_b`
--

INSERT INTO `data_b` (`id`, `nama`, `nim`, `kelas`, `semester`, `status`) VALUES
(1, 'Taufik', 21728004, 'B', 'I', 'lunas'),
(2, 'wawan', 217280012, 'B', 'IV', 'lunas'),
(3, 'dewi', 217280121, 'B', 'IV', 'lunas'),
(4, 'Marko', 21728001, 'B', 'III', 'lunas'),
(5, 'tes', 218200, 'B', 'III', 'lunas'),
(6, 'Yusril', 217280001, 'B', 'IV', 'lunas'),
(7, 'Irfan', 217280056, 'B', 'I', 'lunas'),
(8, 'nomo', 217280045, 'B', 'I', 'lunas');

-- --------------------------------------------------------

--
-- Table structure for table `data_c`
--

CREATE TABLE `data_c` (
  `id` int(11) NOT NULL,
  `nama` varchar(80) NOT NULL,
  `nim` int(11) NOT NULL,
  `kelas` varchar(50) NOT NULL,
  `semester` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_c`
--

INSERT INTO `data_c` (`id`, `nama`, `nim`, `kelas`, `semester`, `status`) VALUES
(1, 'Zul', 21728033, 'C', 'IV', 'lunas'),
(2, 'Didi', 21728016, 'C', 'IV', 'lunas'),
(3, 'YUSRIL', 21728011, 'C', 'IV', 'lunas'),
(4, 'malik', 217280145, 'D', 'V', 'lunas');

-- --------------------------------------------------------

--
-- Table structure for table `data_d`
--

CREATE TABLE `data_d` (
  `id` int(11) NOT NULL,
  `nama` varchar(80) NOT NULL,
  `nim` int(40) NOT NULL,
  `semester` varchar(50) NOT NULL,
  `kelas` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_d`
--

INSERT INTO `data_d` (`id`, `nama`, `nim`, `semester`, `kelas`, `status`) VALUES
(1, 'sepul', 217280165, 'IV', 'D', 'lunas'),
(2, 'irfan', 217280, 'IV', 'D', 'lunas'),
(3, 'Wandik', 217280157, 'IV', 'D', 'lunas');

-- --------------------------------------------------------

--
-- Table structure for table `data_e`
--

CREATE TABLE `data_e` (
  `id` int(11) NOT NULL,
  `nama` varchar(80) NOT NULL,
  `nim` int(40) NOT NULL,
  `kelas` varchar(50) NOT NULL,
  `semester` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_e`
--

INSERT INTO `data_e` (`id`, `nama`, `nim`, `kelas`, `semester`, `status`) VALUES
(1, 'awang', 21728033, 'E', 'IV', 'lunas'),
(2, 'Rahman', 21728026, 'E', 'IV', 'lunas'),
(3, 'Cungkalik', 217280200, 'E', 'VI', 'lunas'),
(4, 'm', 0, 'A', 'I', 'lunas');

-- --------------------------------------------------------

--
-- Table structure for table `instruktur`
--

CREATE TABLE `instruktur` (
  `id` int(11) NOT NULL,
  `dosen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instruktur`
--

INSERT INTO `instruktur` (`id`, `dosen`) VALUES
(1, 'Mail'),
(2, 'Mughaffir Yunus'),
(3, 'Ferdiansyah'),
(4, 'Untung Suwardoyo');

-- --------------------------------------------------------

--
-- Table structure for table `matkul`
--

CREATE TABLE `matkul` (
  `id` int(11) NOT NULL,
  `mata_kul` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matkul`
--

INSERT INTO `matkul` (`id`, `mata_kul`) VALUES
(1, 'PBO'),
(2, 'Pemrograman Web');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_login`
--

CREATE TABLE `tbl_login` (
  `id` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_login`
--

INSERT INTO `tbl_login` (`id`, `user`, `pass`) VALUES
(1, 'admin', 'admin'),
(2, 'admin', 'yusril'),
(3, 'febrian', 'admin'),
(5, 'yusril', '1234'),
(6, 'masuk', 'enter'),
(7, 'asas', 'aaaa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akademik`
--
ALTER TABLE `akademik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_b`
--
ALTER TABLE `data_b`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_c`
--
ALTER TABLE `data_c`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_d`
--
ALTER TABLE `data_d`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_e`
--
ALTER TABLE `data_e`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `instruktur`
--
ALTER TABLE `instruktur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `matkul`
--
ALTER TABLE `matkul`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_login`
--
ALTER TABLE `tbl_login`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akademik`
--
ALTER TABLE `akademik`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `data`
--
ALTER TABLE `data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `data_b`
--
ALTER TABLE `data_b`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `data_c`
--
ALTER TABLE `data_c`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `data_d`
--
ALTER TABLE `data_d`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `data_e`
--
ALTER TABLE `data_e`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `instruktur`
--
ALTER TABLE `instruktur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `matkul`
--
ALTER TABLE `matkul`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_login`
--
ALTER TABLE `tbl_login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
