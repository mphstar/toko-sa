-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2021 at 03:57 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tokosa`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id_akun` int(8) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id_akun`, `username`, `password`) VALUES
(10032101, 'admin', 'admin'),
(10032102, 'mphstar', '123'),
(10032103, 'nabilla', '12345'),
(10032104, 'test', '123'),
(10032105, 'fathur', '12345'),
(10032106, 'bintang', '123'),
(10032107, 'khairatuz', '123'),
(10032108, 'subaru', '123'),
(10032109, 'naruto', '12345'),
(10032110, 'sasuke', '123');

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(5) NOT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `id_kategori` varchar(5) NOT NULL,
  `harga_satuan` int(9) DEFAULT NULL,
  `stok` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama`, `id_kategori`, `harga_satuan`, `stok`) VALUES
('BR100', 'RINSO ANTI NODA 900G', 'KR101', 15000, 150),
('BR101', 'ATTACK EASY 900G', 'KR101', 16500, 117),
('BR102', 'ATTACK SOFTENER 900G', 'KR101', 18000, 88),
('BR103', 'ATTACK MAXIMIZER 900G', 'KR101', 18000, 20),
('BR104', 'ATTACK MAXIMIZER 900G', 'KR101', 18000, 54),
('BR105', 'SURF CLEAN FRESH 900G', 'KR101', 12500, 85),
('BR106', 'BIMOLI 2 LT', 'KR102', 25000, 17),
('BR107', 'BIMOLI 1 LT', 'KR102', 13000, 10),
('BR108', 'FILMA 2 LT', 'KR102', 22285, 33),
('BR109', 'FILMA 1 LT', 'KR102', 11633, 47),
('BR111', 'SUN LIGHT JERUK NIPIS 400ML', 'KR103', 5000, 197),
('BR112', 'SUN LIGHT JERUK NIPIS 200ML', 'KR103', 2500, 177),
('BR113', 'SUPER PELL PINE ESSENCE 800ML', 'KR104', 6000, 70),
('BR114', 'SUPER PELL CHERRY RED 800ML', 'KR104', 6000, 99),
('BR115', 'PEPSODENT WHITENING 190G', 'KR105', 8500, 120),
('BR116', 'PEPSODENT HERBAL 190G', 'KR105', 9000, 60),
('BR117', 'PEPSODENT GIGI BERLUBANG 190G', 'KR105', 6500, 120),
('BR118', 'CLOSE UP MENTHOL 160G', 'KR105', 8000, 38),
('BR119', 'CLOSE UP MILK CALSIUM 160G', 'KR105', 8500, 35),
('BR120', 'PEPSODENT STAWBERRY BUBBLE 50G', 'KR105', 4000, 28),
('BR121', 'CUSSON KID ORANGE 45G', 'KR105', 3000, 20),
('BR149', 'Beng - Beng ', 'KR106', 1000, 80),
('BR150', 'Cheetos', 'KR106', 2000, 996),
('BR151', 'JetZ', 'KR106', 1000, 50),
('BR152', 'FitCips', 'KR106', 1000, 1000),
('BR153', 'TikTak', 'KR106', 500, 200),
('BR154', 'Goriorio', 'KR106', 500, 200),
('BR155', 'Nabati ', 'KR106', 1000, 100),
('BR156', 'Ring', 'KR106', 1000, 96),
('BR157', 'Gary', 'KR106', 1000, 50),
('BR158', 'SIP', 'KR106', 1000, 100),
('BR159', 'MIe Kremezz', 'KR106', 1000, 80),
('BR160', 'Piatos', 'KR106', 1000, 100),
('BR161', 'French Fries', 'KR106', 1000, 100),
('BR162', 'Balls', 'KR106', 1000, 100),
('BR163', 'Mikako', 'KR106', 1000, 200),
('BR169', 'Bulpoin', 'KR107', 3000, 15),
('BR170', 'Pensil', 'KR107', 3000, 47),
('BR171', 'Penghapus', 'KR107', 1000, 20),
('BR172', 'Pengaris', 'KR107', 3000, 16),
('BR173', 'Buku ', 'KR107', 4000, 18),
('BR174', 'Pencil Warna', 'KR107', 10000, 100),
('BR175', 'TIP EX', 'KR107', 3500, 7),
('BR176', 'Paper Clip', 'KR107', 1000, 965),
('BR177', 'Tempat Alat tulis', 'KR107', 5000, 8),
('BR178', 'Stabillo', 'KR107', 3000, 50),
('BR180', 'Gunting', 'KR107', 3500, 10),
('BR181', 'Orotan ', 'KR107', 3000, 50),
('BR182', 'Spidol', 'KR107', 2000, 55),
('BR183', 'Solasi', 'KR107', 4000, 27),
('BR184', 'Binder', 'KR107', 5000, 30),
('BR201', 'Cap kaki tiga larutan', 'KR108', 5000, 197),
('BR202', 'Adem sari', 'KR108', 5500, 80),
('BR203', 'Fanta', 'KR108', 13000, 148),
('BR204', 'Guava', 'KR108', 2800, 100),
('BR205', 'Coca cola', 'KR108', 12, 50),
('BR206', 'Pororo strawberry', 'KR108', 14, 80),
('BR207', 'Sprite', 'KR108', 15, 90),
('BR208', 'Kratingdaeng', 'KR108', 6000, 130),
('BR209', 'Big lime', 'KR108', 20, 45),
('BR210', 'floridina', 'KR108', 3500, 200),
('BR211', 'Yupi', 'KR109', 500, 50);

-- --------------------------------------------------------

--
-- Table structure for table `detail_akun`
--

CREATE TABLE `detail_akun` (
  `username` varchar(20) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nohp` varchar(13) NOT NULL,
  `jenis_kelamin` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `id_roles` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_akun`
--

INSERT INTO `detail_akun` (`username`, `nama`, `email`, `nohp`, `jenis_kelamin`, `alamat`, `id_roles`) VALUES
('admin', '123', 'admin', '082111112222', 'Laki laki', 'Sumbersari', 'RLS100'),
('bintang', 'Mphstar', 'bintang@mphstar.com', '0895393933040', 'Laki laki', 'Jl panjaitan', 'RLS200'),
('fathur', 'fathurrahman', 'fathur@gmail.com', '082111112222', 'Laki laki', 'jember', 'RLS100'),
('khairatuz', 'khairatuz zahro', 'khairatuz@gmail.com', '082133332222', 'Perempuan', 'Situbondo', 'RLS100'),
('mphstar', 'Bintang malindo eka putra', 'Bintang@mphstar.com', '0895393933040', 'Laki laki', 'JL Panjaitan Gg 10 No 50', 'RLS100'),
('nabilla', 'nabilla', 'nabilla@gmail.com', '08211124123', 'Perempuan', 'situbondo', 'RLS100'),
('naruto', 'uzumaki naruto', 'naruto@gmail.com', '082232122222', 'Laki laki', 'Konoha', 'RLS200'),
('sasuke', 'uchiha sasuke', 'sasuke@gmail.com', '082132211111', 'Laki laki', 'Konoha', 'RLS200'),
('subaru', 'subaru', 'subaru@gmail.com', '085122311222', 'Laki laki', 'Yogyakarta', 'RLS100'),
('test', 'aaa', 'aaa@aaa', '1234', 'Laki laki', 'aaaaaaa', 'RLS100');

-- --------------------------------------------------------

--
-- Table structure for table `detail_barang`
--

CREATE TABLE `detail_barang` (
  `id_transaksi` varchar(5) NOT NULL,
  `id_barang` varchar(5) DEFAULT NULL,
  `jumlah` int(5) DEFAULT NULL,
  `subTotal` int(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_barang`
--

INSERT INTO `detail_barang` (`id_transaksi`, `id_barang`, `jumlah`, `subTotal`) VALUES
('TR103', 'BR107', 3, 39000),
('TR104', 'BR107', 2, 26000),
('TR104', 'BR108', 3, 66855),
('TR105', 'BR106', 3, 75000),
('TR106', 'BR109', 1, 11633),
('TR107', 'BR203', 2, 26000),
('TR108', 'BR101', 3, 49500),
('TR109', 'BR106', 1, 25000),
('TR110', 'BR172', 1, 3000),
('TR111', 'BR180', 3, 10500),
('TR112', 'BR182', 3, 6000),
('TR113', 'BR150', 4, 8000),
('TR114', 'BR156', 4, 4000),
('TR115', 'BR208', 20, 120000),
('TR116', 'BR111', 3, 15000),
('TR117', 'BR118', 2, 16000),
('TR118', 'BR107', 3, 39000),
('TR118', 'BR108', 2, 44570),
('TR118', 'BR173', 2, 8000),
('TR119', 'BR108', 2, 44570),
('TR120', 'BR202', 10, 55000),
('TR120', 'BR159', 20, 20000),
('TR121', 'BR149', 20, 20000),
('TR121', 'BR202', 10, 55000),
('TR121', 'BR209', 5, 100),
('TR121', 'BR207', 10, 150),
('TR122', 'BR107', 3, 39000),
('TR123', 'BR108', 2, 44570),
('TR125', 'BR106', 3, 75000),
('TR125', 'BR169', 5, 15000),
('TR125', 'BR201', 3, 15000),
('TR126', 'BR208', 20, 120000),
('TR127', 'BR107', 2, 26000),
('TR127', 'BR172', 3, 9000),
('TR128', 'BR109', 3, 34899),
('TR129', 'BR176', 4, 4000),
('TR130', 'BR183', 3, 12000),
('TR131', 'BR176', 7, 7000),
('TR132', 'BR106', 1, 25000),
('TR133', 'BR106', 30, 750000),
('TR134', 'BR103', 60, 1080000),
('TR135', 'BR107', 3, 39000),
('TR136', 'BR176', 20, 20000),
('TR136', 'BR182', 42, 84000),
('TR137', 'BR109', 10, 116330),
('TR138', 'BR106', 2, 50000),
('TR138', 'BR176', 4, 4000),
('TR139', 'BR109', 3, 34899);

--
-- Triggers `detail_barang`
--
DELIMITER $$
CREATE TRIGGER `update stok` AFTER INSERT ON `detail_barang` FOR EACH ROW BEGIN
UPDATE barang SET stok=stok-new.jumlah
WHERE id_barang = new.id_barang;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` varchar(5) NOT NULL,
  `kategori` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `kategori`) VALUES
('KR102', ' MINYAK GORENG'),
('KR107', 'ATS'),
('KR101', 'DETERGEN'),
('KR106', 'MAKANAN RINGAN'),
('KR108', 'MINUMAN'),
('KR105', 'PASTA GIGI'),
('KR104', 'PEMBERSIH LANTAI'),
('KR109', 'Permen'),
('KR103', 'SABUN CUCI PIRING');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id_roles` varchar(6) NOT NULL,
  `jenis_roles` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id_roles`, `jenis_roles`) VALUES
('RLS100', 'admin'),
('RLS200', 'kasir');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(5) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `tanggal` date NOT NULL,
  `totalHarga` int(9) NOT NULL,
  `totalBayar` int(9) NOT NULL,
  `totalKembalian` int(9) NOT NULL,
  `voucher` int(6) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `username`, `tanggal`, `totalHarga`, `totalBayar`, `totalKembalian`, `voucher`) VALUES
('TR103', 'mphstar', '2021-12-07', 39000, 40000, 1000, 0),
('TR104', 'bintang', '2021-12-08', 92855, 100000, 7145, 0),
('TR105', 'mphstar', '2021-12-08', 75000, 100000, 25000, 0),
('TR106', 'mphstar', '2021-12-08', 11633, 15000, 3367, 0),
('TR107', 'mphstar', '2021-12-08', 26000, 30000, 4000, 0),
('TR108', 'mphstar', '2021-12-08', 44498, 50000, 5502, 5002),
('TR109', 'mphstar', '2021-12-08', 25000, 25000, 0, 0),
('TR110', 'mphstar', '2021-12-08', 3000, 3000, 0, 0),
('TR111', 'mphstar', '2021-12-08', 10500, 11000, 500, 0),
('TR112', 'mphstar', '2021-12-08', 6000, 7000, 1000, 0),
('TR113', 'mphstar', '2021-12-08', 8000, 10000, 2000, 0),
('TR114', 'mphstar', '2021-12-08', 4000, 5000, 1000, 0),
('TR115', 'mphstar', '2021-12-08', 120000, 130000, 10000, 0),
('TR116', 'mphstar', '2021-12-08', 15000, 20000, 5000, 0),
('TR117', 'mphstar', '2021-12-08', 16000, 20000, 4000, 0),
('TR118', 'mphstar', '2021-12-09', 91570, 100000, 8430, 0),
('TR119', 'mphstar', '2021-12-09', 44570, 50000, 5430, 0),
('TR120', 'mphstar', '2021-12-10', 75000, 100000, 25000, 0),
('TR121', 'mphstar', '2021-12-10', 75250, 100000, 24750, 0),
('TR122', 'mphstar', '2021-12-10', 39000, 40000, 1000, 0),
('TR123', 'mphstar', '2021-12-10', 44570, 50000, 5430, 0),
('TR125', 'mphstar', '2021-12-13', 105000, 120000, 15000, 0),
('TR126', 'mphstar', '2021-12-14', 120000, 130000, 10000, 0),
('TR127', 'mphstar', '2021-12-14', 35000, 40000, 5000, 0),
('TR128', 'mphstar', '2021-12-14', 34899, 40000, 5101, 0),
('TR129', 'mphstar', '2021-12-14', 4000, 5000, 1000, 0),
('TR130', 'mphstar', '2021-12-14', 12000, 13000, 1000, 0),
('TR131', 'mphstar', '2021-12-14', 7000, 10000, 3000, 0),
('TR132', 'mphstar', '2021-12-14', 25000, 50000, 25000, 0),
('TR133', 'mphstar', '2021-12-15', 745000, 800000, 55000, 5000),
('TR134', 'mphstar', '2021-12-15', 1080000, 1100000, 20000, 0),
('TR135', 'mphstar', '2021-12-15', 29000, 30000, 1000, 10000),
('TR136', 'bintang', '2021-12-15', 104000, 120000, 16000, 0),
('TR137', 'mphstar', '2021-12-15', 106330, 110000, 3670, 10000),
('TR138', 'sasuke', '2021-12-15', 54000, 60000, 6000, 0),
('TR139', 'mphstar', '2021-12-15', 34899, 40000, 5101, 0);

--
-- Triggers `transaksi`
--
DELIMITER $$
CREATE TRIGGER `Hapus data detail barang` BEFORE DELETE ON `transaksi` FOR EACH ROW BEGIN
DELETE FROM detail_barang
WHERE id_transaksi=old.id_transaksi;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `voucher`
--

CREATE TABLE `voucher` (
  `id_voucher` varchar(9) NOT NULL,
  `nilai` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `voucher`
--

INSERT INTO `voucher` (`id_voucher`, `nilai`) VALUES
('GAD12345', 50000),
('LMN123', 5000),
('RSA321', 20000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id_akun`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `barang_ibfk_1` (`id_kategori`);

--
-- Indexes for table `detail_akun`
--
ALTER TABLE `detail_akun`
  ADD PRIMARY KEY (`username`),
  ADD KEY `id_roles` (`id_roles`);

--
-- Indexes for table `detail_barang`
--
ALTER TABLE `detail_barang`
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `detail_barang_ibfk_1` (`id_barang`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`),
  ADD UNIQUE KEY `kategori` (`kategori`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_roles`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `transaksi_ibfk_2` (`username`);

--
-- Indexes for table `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`id_voucher`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON UPDATE CASCADE;

--
-- Constraints for table `detail_akun`
--
ALTER TABLE `detail_akun`
  ADD CONSTRAINT `detail_akun_ibfk_2` FOREIGN KEY (`id_roles`) REFERENCES `roles` (`id_roles`),
  ADD CONSTRAINT `detail_akun_ibfk_3` FOREIGN KEY (`username`) REFERENCES `akun` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_barang`
--
ALTER TABLE `detail_barang`
  ADD CONSTRAINT `detail_barang_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `detail_barang` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`username`) REFERENCES `detail_akun` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
