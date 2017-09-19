-- MySQL dump 10.13  Distrib 5.6.37, for Linux (x86_64)
--
-- Host: localhost    Database: hardwork
-- ------------------------------------------------------
-- Server version	5.6.37

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
-- Table structure for table `bringInfo`
--

DROP TABLE IF EXISTS `bringInfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bringInfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `people` char(8) NOT NULL,
  `time` datetime NOT NULL,
  `title` varchar(30) NOT NULL,
  `type` varchar(10) NOT NULL,
  `location` varchar(50) NOT NULL,
  `worktime` varchar(30) NOT NULL,
  `workplace` varchar(50) NOT NULL,
  `pay` varchar(8) NOT NULL,
  `deadline` date NOT NULL,
  `sex` varchar(2) NOT NULL,
  `grade` varchar(10) NOT NULL,
  `place` varchar(10) NOT NULL,
  `need` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bringInfo`
--

LOCK TABLES `bringInfo` WRITE;
/*!40000 ALTER TABLE `bringInfo` DISABLE KEYS */;
INSERT INTO `bringInfo` VALUES (2,'5','5','2017-09-17 09:35:36','5555','5','5','5','543','55','2017-09-06','男','色彩对比','5','55'),(3,'123','123','2017-09-17 09:56:47','123','123','123','123','123','123','2017-09-13','男','123','123','13'),(4,'1','1','2017-09-17 10:19:05','1','1','1','1','1','1','2017-09-13','男','1','11','11'),(5,'1','11','2017-09-17 10:38:11','1','1','1','1','1','1','2017-09-15','男','1','1','1'),(6,'1','1','2017-09-17 10:41:08','1','1','1','1','1','1','2017-09-26','男','1','1','11'),(7,'666','66','2017-09-17 10:48:20','66','66','66','66','66','66','2017-09-14','男','665','55','55'),(8,'1124112421412','453','2017-09-17 10:55:47','阿法士大夫','45','45','453','456','456','2017-09-17','不限','453','56','543'),(10,'宋代的风格','553','2017-09-17 11:10:38','规划面积','从的vfgnh','苏打粉阁和','色彩的vfb','所担任法国','岁的vfbh','2017-09-26','男','635','53','53'),(11,'210','1','2017-09-17 11:25:06','21','102','10','10','10','41','2017-09-17','女','1','1','1'),(12,'5','55','2017-09-17 12:21:21','5','5','5','5','543','5242','2017-09-20','男','563','5','5'),(13,'123','111','2017-09-17 12:23:31','123','123','123','123','123','123','2017-09-12','男','11','11','11'),(14,'123','123','2017-09-17 12:23:59','123','123','123','123','123','123','2017-09-21','女','12','13','123'),(15,'1','1','2017-09-17 12:35:22','121313','1','1','1','1','1','2017-09-21','不限','1','1','1');
/*!40000 ALTER TABLE `bringInfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(10) NOT NULL,
  `userName` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `phoneNumber` varchar(11) NOT NULL,
  `qq` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('123','123','qgzx123456','123','123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-17 12:47:42
