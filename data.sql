-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 31 Jul 2019 pada 08.41
-- Versi server: 10.1.39-MariaDB
-- Versi PHP: 7.3.5

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
-- Struktur dari tabel `data`
--

CREATE TABLE `data` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nim` int(11) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `semester` varchar(30) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `data`
--

INSERT INTO `data` (`id`, `nama`, `nim`, `kelas`, `semester`, `status`) VALUES
(1, 'Febrian', 217280007, 'A', 'IV', 'lunas'),
(2, 'walda', 217280026, 'A', 'IV', 'lunas'),
(3, 'Baso', 217280009, 'A', 'I', 'lunas'),
(4, 'n', 217280007, 'A', 'IV', 'lunas'),
(5, 'Baso rompe', 217280009, 'A', 'I', 'lunas'),
(6, 'Baso rompe', 217280009, 'C', 'I', 'lunas'),
(7, 'riski', 888, 'F', 'VI', 'belum'),
(8, 'riski', 888, 'F', 'VI', 'belum'),
(9, 'didi', 217280060, 'A', 'IV', 'lunas'),
(10, 'ghg', 55, 'A', 'I', 'lunas'),
(11, 'hh', 55, 'A', 'I', 'lunas');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `data`
--
ALTER TABLE `data`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
