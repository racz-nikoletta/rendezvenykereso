-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Máj 01. 18:34
-- Kiszolgáló verziója: 10.4.22-MariaDB
-- PHP verzió: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `vizsga`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `felhasznalok`
--

CREATE TABLE `felhasznalok` (
  `lastname` varchar(255) COLLATE utf8_german2_ci NOT NULL,
  `firstname` varchar(255) COLLATE utf8_german2_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_german2_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_german2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

--
-- A tábla adatainak kiíratása `felhasznalok`
--

INSERT INTO `felhasznalok` (`lastname`, `firstname`, `email`, `password`) VALUES
('racz', 'niki', 'a', '$2y$10$S133G8OYe4Bhtu6vImPfHuZxMU1AIVqsfYW868s9pKv/I.k7y36Pu');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `rendezvenyek`
--

CREATE TABLE `rendezvenyek` (
  `id` int(11) NOT NULL,
  `nev` varchar(255) COLLATE utf8_german2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_german2_ci;

--
-- A tábla adatainak kiíratása `rendezvenyek`
--

INSERT INTO `rendezvenyek` (`id`, `nev`) VALUES
(1, 'Karacsonyi vasar'),
(2, 'SZIN'),
(3, 'Diotoro'),
(4, 'Regesztortenetek'),
(5, 'Egytemi Nyiltnapok'),
(6, 'Metronom Jazz koncert'),
(7, 'MineCinema'),
(8, 'Anyak napi musical'),
(9, 'Campus fesztival'),
(10, 'Regisegvasar');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `felhasznalok`
--
ALTER TABLE `felhasznalok`
  ADD UNIQUE KEY `email` (`email`);

--
-- A tábla indexei `rendezvenyek`
--
ALTER TABLE `rendezvenyek`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `rendezvenyek`
--
ALTER TABLE `rendezvenyek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
