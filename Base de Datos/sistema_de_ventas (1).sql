-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-07-2022 a las 09:44:49
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema_de_ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigo_cliente` int(11) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `NIT` int(11) DEFAULT NULL,
  `correo` varchar(250) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`codigo_cliente`, `nombre`, `NIT`, `correo`, `genero`) VALUES
(1, 'Alexander', 123456789, 'alex@gmail.com', 'm');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo_producto` int(11) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `descripcion` varchar(250) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo_producto`, `nombre`, `descripcion`, `cantidad`, `precio`) VALUES
(1, 'Toallas', 'Toallas sanitarias', 90, 10),
(2, 'Cortinas', 'Tcortinas de casa', 100, 50),
(3, 'Mesas', 'Mesas familiares', 800, 600),
(4, 'Escritorios', 'Escritorios de trabajo', 900, 545),
(5, 'Energy Drink', 'Cremin and Sons', 36, 291),
(6, 'Oil - Grapeseed Oil', 'Bednar, King and Kilback', 94, 697),
(7, 'Tuna - Salad Premix', 'Green and Sons', 44, 692),
(8, 'Pails With Lids', 'Jakubowski-Kling', 37, 906),
(9, 'Sparkling Wine - Rose, Freixenet', 'Schowalter-Morissette', 46, 443),
(10, 'Milk - Skim', 'Graham, Miller and Weissnat', 100, 259),
(11, 'Herb Du Provence - Primerba', 'Emard, Haag and Larkin', 39, 100),
(12, 'Cookies - Englishbay Wht', 'Keebler, Bogisich and Mann', 56, 621),
(13, 'Coffee Cup 8oz 5338cd', 'Simonis-Mohr', 2, 777),
(14, 'Lettuce - Boston Bib', 'Cremin-Hintz', 11, 987),
(15, 'Noodles - Cellophane, Thin', 'Skiles, Block and Konopelski', 66, 570),
(16, 'Mushroom - King Eryingii', 'Kilback, Goyette and Padberg', 64, 5),
(17, 'Tortillas - Flour, 8', 'Mohr and Sons', 38, 774),
(18, 'Chevere Logs', 'Macejkovic, Heathcote and Keeling', 37, 401),
(19, 'Tea - Decaf Lipton', 'Ledner-Abshire', 2, 363),
(20, 'Lettuce - Iceberg', 'Osinski-Runolfsdottir', 9, 83),
(21, 'Chips Potato Salt Vinegar 43g', 'Mueller, Moen and Kirlin', 41, 978),
(22, 'Mushroom - Oyster, Fresh', 'Hudson-Beahan', 44, 962),
(23, 'Peas - Pigeon, Dry', 'Jakubowski, Morissette and Kulas', 35, 877),
(24, 'Gatorade - Xfactor Berry', 'Kassulke-Hand', 79, 840),
(25, 'Smoked Tongue', 'Haley LLC', 30, 667),
(26, 'Carrots - Mini, Stem On', 'Gislason, Runolfsson and Murazik', 35, 192),
(27, 'Cake - Pancake', 'Barrows Inc', 53, 501),
(28, 'Sauce - Vodka Blush', 'Torp, Howe and Daniel', 30, 382),
(29, 'Rice - Wild', 'Grant-Leffler', 13, 970),
(30, 'Rolled Oats', 'Ward and Sons', 26, 348),
(31, 'Miso - Soy Bean Paste', 'Leffler Inc', 28, 526),
(32, 'Parsley Italian - Fresh', 'McCullough-Trantow', 86, 950),
(33, 'Carroway Seed', 'Cummerata and Sons', 32, 993),
(34, 'Beef - Bresaola', 'Jones LLC', 79, 789),
(35, 'Sausage - Blood Pudding', 'Bailey, Powlowski and Hermiston', 53, 287),
(36, 'Sausage - Blood Pudding', 'Morissette and Sons', 27, 905),
(37, 'Appetizer - Mango Chevre', 'Bruen LLC', 73, 859),
(38, 'Squeeze Bottle', 'Barton and Sons', 27, 692),
(39, 'Ham - Virginia', 'Schowalter-Anderson', 62, 392),
(40, 'Wine - Riesling Dr. Pauly', 'Wyman-Ritchie', 40, 634),
(41, 'Pastrami', 'Kutch, Roberts and Koelpin', 92, 145),
(42, 'Mince Meat - Filling', 'Crooks-Olson', 75, 597),
(43, 'Mushroom - Crimini', 'Lockman, Hansen and Maggio', 20, 972),
(44, 'Cookie Double Choco', 'Ryan LLC', 93, 130),
(45, 'Pear - Packum', 'Ledner Inc', 2, 539),
(46, 'Peach - Halves', 'VonRueden, Langworth and Ebert', 42, 604),
(47, 'Radish - Black, Winter, Organic', 'Stiedemann, Jerde and Kilback', 45, 87),
(48, 'Beets - Candy Cane, Organic', 'Walsh-Walter', 13, 314),
(49, 'Juice - Propel Sport', 'Jast-Bogan', 2, 862),
(50, 'Island Oasis - Banana Daiquiri', 'Kessler Inc', 33, 490),
(51, 'Bread - White, Unsliced', 'Morar, Leuschke and Lehner', 77, 931),
(52, 'Wine - Pinot Noir Stoneleigh', 'Keebler Inc', 83, 635),
(53, 'Cake - Dulce De Leche', 'Daniel-Glover', 15, 348),
(54, 'Bay Leaf Fresh', 'Koelpin Group', 19, 392),
(55, 'Beer - Camerons Auburn', 'Osinski Group', 23, 679),
(56, 'Potatoes - Yukon Gold, 80 Ct', 'Will-Hackett', 78, 644),
(57, 'Soap - Hand Soap', 'Rempel-Romaguera', 10, 568),
(58, 'Broom - Angled', 'Johnston, Gleason and Beatty', 82, 562),
(59, 'Milk - Chocolate 500ml', 'Hayes-Harvey', 62, 264),
(60, 'Chickhen - Chicken Phyllo', 'Bayer-Nolan', 95, 653),
(61, 'Ecolab - Solid Fusion', 'Durgan, Welch and Leffler', 75, 941),
(62, 'Relish', 'Hegmann, Rau and Thiel', 73, 172),
(63, 'Beef Striploin Aaa', 'Maggio-Schiller', 50, 157),
(64, 'Chicken - Livers', 'Hoppe-Mann', 12, 750),
(65, 'Pepsi - Diet, 355 Ml', 'O\'Conner and Sons', 39, 277),
(66, 'Yoplait Drink', 'Heidenreich, Braun and Kiehn', 24, 684),
(67, 'Table Cloth 81x81 Colour', 'Huel and Sons', 37, 901),
(68, 'Bandage - Fexible 1x3', 'Kihn Group', 17, 970),
(69, 'Egg - Salad Premix', 'Anderson, Spencer and Legros', 30, 520),
(70, 'Garbage Bag - Clear', 'Bergstrom, Witting and Lubowitz', 82, 585),
(71, 'Bread - Dark Rye', 'VonRueden Inc', 34, 575),
(72, 'Wine - Rosso Del Veronese Igt', 'Mohr-McDermott', 20, 600),
(73, 'Pheasants - Whole', 'Waters Inc', 4, 117),
(74, 'Cookie Dough - Chunky', 'Ondricka, Hauck and Runolfsdottir', 38, 665),
(75, 'Soup Campbells Split Pea And Ham', 'Heidenreich Inc', 83, 811),
(76, 'Coconut - Creamed, Pure', 'Huel and Sons', 11, 34),
(77, 'Pastry - Chocolate Chip Muffin', 'Schuster-Runte', 39, 211),
(78, 'Bagel - Everything', 'Tremblay, Goldner and Gislason', 77, 945),
(79, 'Potatoes - Yukon Gold, 80 Ct', 'Rogahn and Sons', 6, 399),
(80, 'Stainless Steel Cleaner Vision', 'Russel, Ruecker and Stehr', 82, 694),
(81, 'Squash - Pepper', 'Osinski and Sons', 20, 396),
(82, 'Pork - Back Ribs', 'Kertzmann, Abshire and Terry', 98, 343),
(83, 'Wine - White, Riesling, Henry Of', 'Schuster-Dach', 5, 763),
(84, 'Barramundi', 'Hodkiewicz Group', 57, 331),
(85, 'Sesame Seed', 'Sauer, Murray and Haag', 64, 820),
(86, 'Vol Au Vents', 'Sanford and Sons', 66, 552),
(87, 'Sauce - Thousand Island', 'Runte Inc', 49, 281),
(88, 'Sambuca - Opal Nera', 'Reinger LLC', 56, 950),
(89, 'Soup Campbells Split Pea And Ham', 'Ondricka-Johns', 37, 196),
(90, 'Lettuce - Lolla Rosa', 'Moore, Kshlerin and Hand', 26, 811),
(91, 'Extract - Lemon', 'Lynch, Douglas and Dickens', 95, 981),
(92, 'Bread - Sour Batard', 'Cartwright-Jacobson', 86, 581),
(93, 'Juice - Grapefruit, 341 Ml', 'Grant, Hermiston and Kohler', 11, 542),
(94, 'Shrimp - Black Tiger 16/20', 'Brown, Gerhold and Stracke', 53, 667),
(95, 'Table Cloth 81x81 White', 'Murray-Homenick', 58, 190),
(96, 'Chocolate - Dark Callets', 'Skiles-Lang', 71, 207),
(97, 'Garlic Powder', 'Hills-Morar', 12, 897),
(98, 'C - Plus, Orange', 'Runolfsdottir LLC', 91, 52),
(99, 'Sproutsmustard Cress', 'Kohler, Mitchell and Stiedemann', 1, 625),
(100, 'Bread - Sour Sticks With Onion', 'Klocko and Sons', 96, 157),
(101, 'Chocolate - Unsweetened', 'Klein-Kuvalis', 90, 539),
(102, 'Tomatoes - Roma', 'Parisian-Bauch', 24, 532),
(103, 'Crab Brie In Phyllo', 'Auer Inc', 68, 180),
(104, 'Chocolate Liqueur - Godet White', 'Beier-Kautzer', 13, 445),
(105, 'Veal Inside - Provimi', 'VonRueden-Zulauf', 27, 537),
(106, 'Muffin - Mix - Strawberry Rhubarb', 'Luettgen-Beer', 55, 167),
(107, 'Pork - Butt, Boneless', 'Bruen-Friesen', 82, 572),
(108, 'Mushroom - Shitake, Dry', 'Bartoletti Group', 19, 198),
(109, 'Tomatillo', 'Batz Inc', 15, 597),
(110, 'Crab Meat Claw Pasteurise', 'Olson-Cruickshank', 62, 971),
(111, 'Soup - French Can Pea', 'Witting Inc', 14, 96),
(112, 'Shichimi Togarashi Peppeers', 'Dietrich-Lang', 24, 794),
(113, 'Halibut - Whole, Fresh', 'Gottlieb-Friesen', 4, 166),
(114, 'Apricots Fresh', 'Tremblay, Halvorson and Reinger', 77, 974),
(115, 'Cake - Box Window 10x10x2.5', 'Koss-Littel', 1, 776),
(116, 'Russian Prince', 'Bernhard, Skiles and Green', 55, 211),
(117, 'Appetizer - Sausage Rolls', 'Considine LLC', 30, 34),
(118, 'Mushroom - Chanterelle, Dry', 'Marquardt and Sons', 90, 785),
(119, 'Vacuum Bags 12x16', 'Smitham-Quitzon', 32, 341),
(120, 'Wine - Maipo Valle Cabernet', 'Kihn, Cartwright and Cummings', 44, 861),
(121, 'Dc - Sakura Fu', 'Nikolaus-Moore', 16, 863),
(122, 'Chicken - Base, Ultimate', 'Rolfson and Sons', 38, 873),
(123, 'Lid - Translucent, 3.5 And 6 Oz', 'Hammes-Olson', 99, 369),
(124, '7up Diet, 355 Ml', 'Jones, Abbott and Hirthe', 91, 53),
(125, 'Coffee - Cafe Moreno', 'Spencer, Cruickshank and Kihn', 68, 796),
(126, 'Tea - Orange Pekoe', 'Treutel, Connelly and Gibson', 10, 530),
(127, 'Turkey - Oven Roast Breast', 'Mraz, Herman and Bogisich', 83, 833),
(128, 'Pecan Raisin - Tarts', 'Brakus-Kassulke', 75, 107),
(129, 'Beef - Shank', 'Cummerata-Wiegand', 83, 89),
(130, 'Oil - Olive Bertolli', 'Smitham-Torphy', 20, 138),
(131, 'Bagelers - Cinn / Brown', 'Douglas Inc', 37, 379),
(132, 'Taro Root', 'Gutkowski, Nicolas and Bahringer', 74, 392),
(133, 'Ecolab - Hobart Washarm End Cap', 'Bayer, Johns and Breitenberg', 52, 272),
(134, 'Calvados - Boulard', 'Deckow and Sons', 32, 793),
(135, 'Cut Wakame - Hanawakaba', 'Auer LLC', 87, 220),
(136, 'Mushroom - Trumpet, Dry', 'Hegmann-Baumbach', 41, 483),
(137, 'Cookies - Assorted', 'Macejkovic, Pouros and Kuhn', 11, 978),
(138, 'Jolt Cola - Red Eye', 'Shields LLC', 97, 576),
(139, 'Marsala - Sperone, Fine, D.o.c.', 'Hoeger and Sons', 13, 315),
(140, 'Mikes Hard Lemonade', 'Nienow LLC', 47, 367),
(141, 'Bandage - Flexible Neon', 'Jast-Barton', 58, 484),
(142, 'Longos - Assorted Sandwich', 'Runte-Erdman', 13, 758),
(143, 'Tomatoes - Yellow Hot House', 'Herman Inc', 19, 554),
(144, 'Huck White Towels', 'Gutmann-Lebsack', 20, 215),
(145, 'Tart - Lemon', 'Yundt-VonRueden', 12, 439),
(146, 'Cheese - Parmesan Grated', 'Kshlerin-Kunze', 26, 304),
(147, 'Shiratamako - Rice Flour', 'Bailey Inc', 24, 45),
(148, 'Wheat - Soft Kernal Of Wheat', 'Durgan-Ritchie', 76, 278),
(149, 'Beef - Bones, Marrow', 'Rolfson LLC', 89, 894),
(150, 'Coriander - Seed', 'Schmitt, Ritchie and Ortiz', 74, 750),
(151, 'Tea - Mint', 'Stehr and Sons', 69, 704),
(152, 'Lid Tray - 12in Dome', 'Stark, Padberg and Pouros', 71, 333),
(153, 'Beef - Flank Steak', 'Balistreri-Ryan', 55, 624),
(154, 'Cheese - La Sauvagine', 'Weissnat, Nicolas and Parker', 20, 872);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE `sucursales` (
  `codigo_sucursal` int(11) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `correo` varchar(250) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`codigo_sucursal`, `nombre`, `direccion`, `correo`, `telefono`) VALUES
(1, 'Wisoky-Bergnaum', '71818 Meadow Vale Way', 'swoodeson0@imgur.com', '2462328'),
(2, 'Douglas-Larson', '044 Independence Alley', 'rmadge1@newyorker.com', '2456609'),
(3, 'Metz-Reinger', '279 Larry Lane', 'jitskovitz2@friendfeed.com', '2495630'),
(4, 'Kreiger and Sons', '8 Novick Lane', 'eboraston3@apache.org', '2400192'),
(5, 'Jaskolski Inc', '333 Bartelt Circle', 'rheinreich4@nsw.gov.au', '2495829'),
(6, 'Dickinson-Schoen', '34 Delaware Way', 'afuster5@unblog.fr', '2402859'),
(7, 'Hermiston-Brekke', '47391 Rowland Road', 'bsegot6@abc.net.au', '2415390'),
(8, 'Schamberger, Shields and Corwin', '9552 Sommers Point', 'ehartburn7@about.me', '2433697'),
(9, 'Harvey Group', '3730 Sundown Plaza', 'ctrees8@fema.gov', '2442938'),
(10, 'Deckow-Walter', '62 Troy Street', 'jpim9@altervista.org', '2463599'),
(11, 'Bednar and Sons', '07 Texas Pass', 'clevisa@linkedin.com', '2452281'),
(12, 'McCullough Group', '898 Elka Center', 'dtronib@dailymail.co.uk', '2437791'),
(13, 'Harris, McKenzie and Hintz', '66403 Morningstar Hill', 'gfoldc@amazonaws.com', '2480766'),
(14, 'Volkman-Kuphal', '29 Leroy Alley', 'wdayleyd@tinypic.com', '2467424'),
(15, 'Rogahn, Bins and Wintheiser', '80988 Ridgeview Hill', 'fjanoute@ycombinator.com', '2414941'),
(16, 'Collier-Kulas', '86 Heath Plaza', 'jyounglovef@nymag.com', '2446769'),
(17, 'Johnston and Sons', '0261 Nancy Trail', 'pharlingg@tinypic.com', '2479013'),
(18, 'Macejkovic-VonRueden', '09 Lillian Hill', 'mespinhah@jiathis.com', '2429016'),
(19, 'Bailey Group', '3586 Amoth Crossing', 'wgerriti@bloomberg.com', '2495423'),
(20, 'Shields-Dickens', '64597 Walton Center', 'lwishamj@google.com.au', '2480490'),
(21, 'Mayer, Roob and Wiza', '0 Manitowish Way', 'pbernardeschik@dion.ne.jp', '2421944'),
(22, 'O\'Reilly LLC', '516 Forest Dale Crossing', 'sbirkinshawl@geocities.jp', '2498929'),
(23, 'Stokes-Aufderhar', '8370 Texas Hill', 'mpykem@clickbank.net', '2460801'),
(24, 'Hettinger-Erdman', '400 Pankratz Circle', 'pciobutaron@virginia.edu', '2489219'),
(25, 'Schinner and Sons', '6114 Marquette Trail', 'ciacoboo@studiopress.com', '2451359'),
(26, 'Abshire and Sons', '76776 Service Avenue', 'hwillersonp@list-manage.com', '2471588'),
(27, 'Kautzer, Parker and Parker', '3 Thompson Avenue', 'jbalsdoneq@cornell.edu', '2422883'),
(28, 'Greenfelder-Gerhold', '63383 Stoughton Terrace', 'ialdenr@omniture.com', '2415828'),
(29, 'Daniel Group', '792 Golf Court', 'sbailes@bloglovin.com', '2400128'),
(30, 'Waelchi, Johnston and King', '07014 Pepper Wood Terrace', 'kroskellyt@icq.com', '2473716'),
(31, 'Weimann-Gutmann', '4815 Florence Way', 'avinnicombeu@nps.gov', '2421796'),
(32, 'Runte-Jacobs', '98 Oxford Pass', 'bdumbletonv@amazon.com', '2413952'),
(33, 'Gutmann LLC', '71 Bultman Place', 'bsawneyw@mozilla.org', '2402369'),
(34, 'Harris-Heaney', '6 Leroy Alley', 'eocarranx@facebook.com', '2464910'),
(35, 'Dach LLC', '5736 Chive Lane', 'ccurtissy@google.de', '2477835'),
(36, 'Bogisich, Torphy and Lakin', '37 Service Avenue', 'blauxmannz@prweb.com', '2472322'),
(37, 'Kuhn, Douglas and Davis', '20 Lotheville Court', 'erenachowski10@networkadvertising.org', '2489525'),
(38, 'Bechtelar Inc', '02429 Atwood Place', 'jkillock11@yandex.ru', '2417564'),
(39, 'Thompson-Kemmer', '2226 Rigney Pass', 'ccruz12@bigcartel.com', '2457869'),
(40, 'Reilly, Hansen and DuBuque', '6282 Swallow Parkway', 'goscollee13@xinhuanet.com', '2491745');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE `vendedores` (
  `codigo_vendedor` int(11) NOT NULL,
  `nombre` varchar(250) DEFAULT NULL,
  `caja` int(11) DEFAULT NULL,
  `ventas` int(11) DEFAULT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`codigo_vendedor`, `nombre`, `caja`, `ventas`, `genero`, `password`) VALUES
(1, 'Maria', 278, 233, 'f', 'GHAJSHSH676777999'),
(2, 'Alejandro', 278, 233, 'm', 'gghfghjJHTYVGU67'),
(3, 'Cristina', 200, 233, 'f', 'hsdhahjahdhajh77'),
(4, 'Katrinka', 101, 0, 'm', 'af579a200b74797b3e78822bf28c2985'),
(5, 'Katleen', 102, 0, 'm', 'e3699d375ded04880e3166dc55f89fde'),
(6, 'Felizio', 103, 0, 'm', '379094cd2c69562f8b8305439b49a613'),
(7, 'Arnie', 104, 0, 'f', '808cb3e29688a78c56610d2a457e5ee4'),
(8, 'Edwin', 105, 0, 'f', '4a562ffc4813726d83d0acdd854fc87d'),
(9, 'Laurens', 106, 0, 'f', '1a7417ff18ee9bfe6f04233dd7ec6908'),
(10, 'Allianora', 107, 0, 'm', '3910f2c2fc6b5bce7ed4d739ae576928'),
(11, 'Johnnie', 108, 0, 'f', 'e1d6c5af6076cb6f1d21833b017f7acf'),
(12, 'Kala', 109, 0, 'm', '08621114b828e2910eb45cc0f1d5c11e'),
(13, 'Terrijo', 110, 0, 'm', '5713177c9d4678186b4f52fc58adfca7'),
(14, 'Broderick', 111, 0, 'f', 'f00c4e0dbd8e53f198d650fc877d51c5'),
(15, 'Junia', 112, 0, 'm', '8623116fdaf6cec4a6f34cfdf33e8875'),
(16, 'Myrah', 113, 0, 'm', 'e6ce0d8beebbcb4a35ceeb81d0fa993a'),
(17, 'Wendeline', 114, 0, 'm', 'bebbd8a4c3b2f1498bf9ccd567e9390c'),
(18, 'Malcolm', 115, 0, 'm', 'b24449675845d066d0b8b0823c8125e7'),
(19, 'Otis', 116, 0, 'm', 'cc75ca180881baa4d6fa02673e247891'),
(20, 'Sanford', 117, 0, 'm', '47a30d30bcbe2a852751dbcc6f846a48'),
(21, 'Bar', 118, 0, 'm', 'c635b159445bf65eaf68805aafbfe449'),
(22, 'Dulcia', 119, 0, 'm', '971203006ee3988df71c8dce120ed62d'),
(23, 'Lynelle', 120, 0, 'm', 'e380d864596c236b46e7e9297598bd91'),
(24, 'Thane', 121, 0, 'f', '12802dee624dc4382cc761ee16e9049c'),
(25, 'Hadria', 122, 0, 'f', '7b633fbc7a79639ca0ed9e86b3d7b850'),
(26, 'Jeth', 123, 0, 'm', 'dbf829de0fc6d960acf642256df6f1c8'),
(27, 'Ax', 124, 0, 'm', '81bf16e8e61c76f20631f228b5d6401a'),
(28, 'Ray', 125, 0, 'm', '0b618c0b08706e9a9d772681cc2b3dc6'),
(29, 'Saree', 126, 0, 'f', '658d752708031c70773697d141142449'),
(30, 'Milton', 127, 0, 'f', 'dc5fc071ee4b9ba79be9bea97caddd07'),
(31, 'Brietta', 128, 0, 'm', '3a7297da824766aa2c82ec069f26a010'),
(32, 'Edgardo', 129, 0, 'm', 'd3a54d3e32661d11afa91973eef2722d'),
(33, 'Celle', 130, 0, 'f', '90f2c3b376c855119f2811c7b6dee4b8'),
(34, 'Vonni', 131, 0, 'f', '537a4aa90cb5d278383dc20480b50ff3'),
(35, 'Audry', 132, 0, 'f', '1b12e7f99a35c37335faa6e5741f5c90'),
(36, 'Quintus', 133, 0, 'm', '4047a9a71734daf75cb41224bbbc1a19'),
(37, 'Jammie', 134, 0, 'f', '3ec9f4dfec574f3f635d732154039a6c'),
(38, 'Sigismondo', 135, 0, 'm', 'da1355be7bdc9425517ad8538a482f46'),
(39, 'Woodrow', 136, 0, 'f', 'c2eb78603e380ffcbf0497769bc98dc3'),
(40, 'Armand', 137, 0, 'm', '355051380edb5c9244f554838c9f4a89'),
(41, 'Carce', 138, 0, 'm', '78a95632af796ae18e14fcf1fdd11d66'),
(42, 'Damaris', 139, 0, 'm', 'e53a099f23001a619d25b2a9b599f959'),
(43, 'Libbi', 140, 0, 'm', 'd9cf17bb063d02833d29ff57b758b390'),
(44, 'Graham', 141, 0, 'f', '3aff260ed01bffcba608c6c257ff00d0'),
(45, 'Ollie', 142, 0, 'f', '3783fae4fdd6a76d89d0b5447005e398'),
(46, 'Beilul', 143, 0, 'f', '9a6975c26306024b52ef9bdc424d3762'),
(47, 'Carolee', 144, 0, 'm', 'ae4aa109f05d219f8bd850bf9935804f'),
(48, 'Valery', 145, 0, 'm', '4c34647a7ed1a7b28cc562ab6dd20462'),
(49, 'Alicia', 146, 0, 'm', '9c5708196bbd77fe1ba8537c4f10549f'),
(50, 'Selle', 147, 0, 'f', '4938e4734869370fff8d8bc45b5724ab'),
(51, 'Cindra', 148, 0, 'm', '2dabed5d8187b21e7f27a3b51e78f811'),
(52, 'Loni', 149, 0, 'm', '8cb0fa8a996dcc419d26ff6ce93d930d'),
(53, 'Ferdinanda', 150, 0, 'm', '28aa1efcc938a79f1c2e31c141fa8a0e'),
(54, 'Giovanni', 151, 0, 'f', '8e3b0e39cead27a75f0028e40985ae60'),
(55, 'Gawen', 152, 0, 'm', '65b98fc90a2773ce06d1fb519724d858'),
(56, 'Violette', 153, 0, 'm', '488327b472479ec1d64832f598aba6b3'),
(57, 'Raquel', 154, 0, 'm', '0cc38b30d6b459aa8af76f80903c77b7'),
(58, 'Pandora', 155, 0, 'm', 'ed2e3c5093ad48e6d363dcca82b638dc'),
(59, 'Marve', 156, 0, 'f', '0b5da12265fbc8f8fe4b7fb23e5e2ede'),
(60, 'Lenee', 157, 0, 'm', 'a5a3315897837a34aa79dd97ad3ee02f'),
(61, 'Marji', 158, 0, 'f', 'b0c42e005f4de11d0a5ca5aad4a5555b'),
(62, 'Conrado', 159, 0, 'f', 'f0ee3620173aa54d11328256c38cc683'),
(63, 'Lynde', 160, 0, 'm', '65d2ddb1b56fe5ec4b38b402ca16b73a'),
(64, 'Sisely', 161, 0, 'f', 'd6c68bd59350e2617f234b2d7f59cf4a'),
(65, 'Willey', 162, 0, 'm', 'e6f0027ae1f1b58c2da9e69e62c71736'),
(66, 'Sharl', 163, 0, 'f', 'c6fd527bb12eb3856a0411ed336eaf2b'),
(67, 'Hannis', 164, 0, 'f', '904939a4e50127dd07ac3d2541c73b36'),
(68, 'Allen', 165, 0, 'm', 'e4f02800e8548231ed1286308d96cdd5'),
(69, 'Kelwin', 166, 0, 'f', '44482ee6b509d272b1925949f1852603'),
(70, 'Zerk', 167, 0, 'f', 'f99762b13703eea5e319cca1eaac127f'),
(71, 'Talbot', 168, 0, 'm', 'f0078ef07d7a2f6e5c9f5c77159f725e'),
(72, 'Jacqueline', 169, 0, 'm', 'ec69a1852cf95015ce35064e388d33ec'),
(73, 'Nessy', 170, 0, 'f', '4240134fc5caf45b704c0890e436dd79'),
(74, 'Hale', 171, 0, 'm', '55c9bf05407cbcc3bffab11ac7e4446f'),
(75, 'Garrick', 172, 0, 'm', '2d68f7b560d13a6712d80a108ca1f8c1'),
(76, 'Davidde', 173, 0, 'm', '461112211122bbe7d90bd165020c82aa'),
(77, 'Leonardo', 174, 0, 'f', '755a29fb7f3dabf4fd336044cb7d62b1'),
(78, 'Wolfy', 175, 0, 'f', '45a47b2f5bfc837647c6594a59f4d805'),
(79, 'Skippie', 176, 0, 'f', 'b5dffbc6db7f1e2e423a0143f28d22fb'),
(80, 'Corena', 177, 0, 'm', '808e4755f6cbf1c309c7ad98f4b5b29e'),
(81, 'Charmion', 178, 0, 'f', '386672a6e4b02e57c5e625d59032e582'),
(82, 'Mariellen', 179, 0, 'f', '46f8c0b68d0e90e0fe3325f5643cb87d'),
(83, 'Ashlee', 180, 0, 'm', 'f588c60a846001ae87e7097fd867c3f7'),
(84, 'Kristofer', 181, 0, 'f', '2eecb18f63bee4c8a538ec416a6141e9'),
(85, 'Darla', 182, 0, 'm', '0407f1aa8ea5610c74a3d4af76dc829c'),
(86, 'Bonny', 183, 0, 'f', '214106164783f06a87c5ce821509f726'),
(87, 'Regine', 184, 0, 'f', '1b5754f569a58dc1892399a912e22624'),
(88, 'Tracee', 185, 0, 'm', 'd8579be1141d7c7f94d36370ae6c67b5'),
(89, 'Hughie', 186, 0, 'm', '440df97463838b9c72c324163483a9b0'),
(90, 'Cobbie', 187, 0, 'm', '8a1e546e415fac80847b0b7afca27de5'),
(91, 'Monika', 188, 0, 'f', 'de604080d59e9aaba2abe49a52307fd8'),
(92, 'Ramsay', 189, 0, 'm', '97cf3fb8407ab58a5c36a4a458f85c92'),
(93, 'Oralie', 190, 0, 'f', '2305fd6fdd58b2f150fb97ee0730d839'),
(94, 'Kenneth', 191, 0, 'f', 'e0b451fed2fa27425f0cb0127875e702'),
(95, 'Marylynne', 192, 0, 'm', '42d1553dd50e3be2aac5835f8d02ddbf'),
(96, 'Rochelle', 193, 0, 'm', '66a887f853d2da94f5e19c0eeaa23561'),
(97, 'Anica', 194, 0, 'm', 'bccf08da8970c46e49a85d80c5bed840'),
(98, 'Stan', 195, 0, 'f', '87b2ca87df3bc9d5ccd64559dfaf1f77'),
(99, 'Donnie', 196, 0, 'f', '1b8e51668faa9a248221ea87167a11e9'),
(100, 'Jenna', 197, 0, 'f', 'dba9d9cfc7b71f1fb8f26a60c647f5b8'),
(101, 'Colene', 198, 0, 'm', '5af50bd1ab2f8dbed5686054d38e71b4'),
(102, 'Marlo', 199, 0, 'm', '9aecdb2f7d4436ba872ef0d3c57e2e90'),
(103, 'Saloma', 200, 0, 'f', 'fc6484e281d657239d285c6309b76be7'),
(104, 'Karalynn', 201, 0, 'f', 'ba9ebe0aa142e32901ef9693e3a52789'),
(105, 'Dacy', 202, 0, 'm', 'ff89124980ca9c31f8fd2ed3e72d699e'),
(106, 'Kendra', 203, 0, 'm', '271edba0b010d7f22b26649bb521ef65'),
(107, 'Hildegarde', 204, 0, 'm', '1b84b09290e11fd4535092c008a39fe4'),
(108, 'Sutherlan', 205, 0, 'm', 'a87ddd1a1ec6c87ae7bb89af69e3e104'),
(109, 'June', 206, 0, 'f', '55defb39ee0e3dc520491c8412aaaeae'),
(110, 'Meggy', 207, 0, 'm', 'c4b228b4a9153b6278ad1c059435db39'),
(111, 'Cristina', 208, 0, 'm', '8b585ad88c49ade548db400a44d1fbb9'),
(112, 'Colly', 209, 0, 'f', 'c569030152d65384b8a71e3d8ce40ed8'),
(113, 'Alexandro', 210, 0, 'f', 'df948f2d1bae50d0eeaa8a5fdebfe76d'),
(114, 'Zolly', 211, 0, 'f', '98e6814eb53d31652746dfdd79b47e6f'),
(115, 'Roberto', 212, 0, 'm', '0e953fb33f13da839e6cb44f97e89e4a'),
(116, 'Claudette', 213, 0, 'f', 'd513db1be9de0c405caf62b46776ad1f'),
(117, 'Candide', 214, 0, 'm', '5eb23261de475a87f42c500f6fce46cd'),
(118, 'Zorah', 215, 0, 'm', '1e833bae1d8bc8d51e0fdd38bad6a85e'),
(119, 'Nancee', 216, 0, 'f', '1ea1b6d03c329589341f6ddc9b92f402'),
(120, 'Kory', 217, 0, 'f', '8428a5b0c001973f484d0559a0625ebc'),
(121, 'Stanislaus', 218, 0, 'f', '36b81ada0bc09a364278824d3e41fb51'),
(122, 'Orran', 219, 0, 'f', 'cfc5da281830a381d79abcc58c0f944a'),
(123, 'Margery', 220, 0, 'm', '28c3b7f7fd95b2cfed8b353e8666c843'),
(124, 'Etta', 221, 0, 'm', '684f9b919c68ffb894f8565959eeb93e');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo_cliente`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo_producto`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`codigo_sucursal`);

--
-- Indices de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`codigo_vendedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `codigo_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `codigo_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=155;

--
-- AUTO_INCREMENT de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  MODIFY `codigo_sucursal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `codigo_vendedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=125;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
