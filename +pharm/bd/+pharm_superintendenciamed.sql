-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: +pharm
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.10-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `superintendenciamed`
--

DROP TABLE IF EXISTS `superintendenciamed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `superintendenciamed` (
  `idsuperintendenciaMed` int(11) NOT NULL AUTO_INCREMENT,
  `nome_medicamento` varchar(45) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `confirmacao` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_medicamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`idsuperintendenciaMed`),
  KEY `fk_id_usuario_idx` (`id_usuario`),
  KEY `fk_id_medicamento_idx` (`id_medicamento`),
  CONSTRAINT `fk_id_medicamento` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamentos` (`idmedicamentos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `cadastro` (`idcadastro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `superintendenciamed`
--

LOCK TABLES `superintendenciamed` WRITE;
/*!40000 ALTER TABLE `superintendenciamed` DISABLE KEYS */;
INSERT INTO `superintendenciamed` VALUES (1,NULL,NULL,'10:10:00',0,NULL,NULL),(2,'Multigrip',NULL,NULL,1,5,1),(3,'dipirona','2017-12-04','20:25:21',1,5,5),(4,'dipirona','2017-12-04','21:19:51',1,5,5),(5,'Multigrip','2017-12-04','21:20:05',1,5,1),(6,'Multigrip','2005-12-17','20:32:31',1,5,1);
/*!40000 ALTER TABLE `superintendenciamed` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-05 21:38:41
