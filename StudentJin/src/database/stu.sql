/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : stu

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-06-14 13:36:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aId` int(11) NOT NULL,
  `apw` varchar(20) NOT NULL,
  PRIMARY KEY (`aId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '123');
INSERT INTO `admin` VALUES ('2', '123');

-- ----------------------------
-- Table structure for `class`
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `cId` int(11) NOT NULL,
  `cname` varchar(20) NOT NULL,
  `ctea` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`cId`),
  KEY `cname` (`cname`),
  KEY `ctea` (`ctea`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`cname`) REFERENCES `profess` (`pname`) ON UPDATE CASCADE,
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`ctea`) REFERENCES `teacher` (`tname`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', 'computer', 'zheng');
INSERT INTO `class` VALUES ('2', 'computer', 'xu');
INSERT INTO `class` VALUES ('3', 'IEEE', 'wang');

-- ----------------------------
-- Table structure for `infor`
-- ----------------------------
DROP TABLE IF EXISTS `infor`;
CREATE TABLE `infor` (
  `Id` int(11) NOT NULL,
  `stuId` varchar(20) NOT NULL,
  `name` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `class` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `profess` varchar(20) DEFAULT NULL,
  `depart` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `grade` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `bir` datetime DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `QQ` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `state` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `password` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `depart` (`depart`),
  KEY `stuId` (`stuId`),
  KEY `infor_ibfk_1` (`profess`),
  KEY `name` (`name`),
  CONSTRAINT `infor_ibfk_2` FOREIGN KEY (`depart`) REFERENCES `profess` (`pdepart`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of infor
-- ----------------------------
INSERT INTO `infor` VALUES ('1', '11', 'jin', '2', 'computer', 'xinxi', 'man', '3', '2019-06-01 16:45:47', '123', '123', 'in', '123');
INSERT INTO `infor` VALUES ('2', '12', 'weng', '2', 'computer', 'xinxi', 'man', '1', '2019-06-03 16:46:34', '123', '1111', 'in', '123');
INSERT INTO `infor` VALUES ('3', '13', 'test', '2', '0', 'xinxi', 'man', '1', '1997-01-01 00:00:00', '123', '123', 'in', '123');

-- ----------------------------
-- Table structure for `kecheng`
-- ----------------------------
DROP TABLE IF EXISTS `kecheng`;
CREATE TABLE `kecheng` (
  `keId` int(11) NOT NULL,
  `kename` varchar(20) CHARACTER SET latin1 NOT NULL,
  `keroom` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `ketea` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`keId`),
  KEY `kename` (`kename`),
  KEY `ketea` (`ketea`),
  CONSTRAINT `kecheng_ibfk_1` FOREIGN KEY (`ketea`) REFERENCES `teacher` (`tname`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kecheng
-- ----------------------------
INSERT INTO `kecheng` VALUES ('1', 'data', '10301', 'wang');
INSERT INTO `kecheng` VALUES ('2', 'html', '3n123', 'xu');

-- ----------------------------
-- Table structure for `ke_pro`
-- ----------------------------
DROP TABLE IF EXISTS `ke_pro`;
CREATE TABLE `ke_pro` (
  `kpId` int(11) NOT NULL,
  `kpname` varchar(20) CHARACTER SET latin1 NOT NULL,
  `kpdepart` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `kpprofess` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`kpId`),
  KEY `kpname` (`kpname`),
  KEY `kpdepart` (`kpdepart`),
  CONSTRAINT `ke_pro_ibfk_1` FOREIGN KEY (`kpname`) REFERENCES `kecheng` (`kename`) ON UPDATE CASCADE,
  CONSTRAINT `ke_pro_ibfk_2` FOREIGN KEY (`kpdepart`) REFERENCES `profess` (`pdepart`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ke_pro
-- ----------------------------
INSERT INTO `ke_pro` VALUES ('1', 'data', 'xinxi', 'computer');
INSERT INTO `ke_pro` VALUES ('2', 'html', 'xinxi', 'computer');

-- ----------------------------
-- Table structure for `ke_stu`
-- ----------------------------
DROP TABLE IF EXISTS `ke_stu`;
CREATE TABLE `ke_stu` (
  `kskeId` int(11) NOT NULL,
  `kskename` varchar(20) CHARACTER SET latin1 NOT NULL,
  `ksstuId` int(11) NOT NULL,
  `ksstuname` varchar(20) CHARACTER SET latin1 NOT NULL,
  `ksscore` int(5) DEFAULT NULL,
  PRIMARY KEY (`kskeId`,`ksstuId`),
  KEY `kskename` (`kskename`),
  CONSTRAINT `ke_stu_ibfk_1` FOREIGN KEY (`kskename`) REFERENCES `kecheng` (`kename`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ke_stu
-- ----------------------------
INSERT INTO `ke_stu` VALUES ('1', 'data', '11', 'jin', '93');
INSERT INTO `ke_stu` VALUES ('1', 'data', '12', 'zheng', null);
INSERT INTO `ke_stu` VALUES ('2', 'html', '11', 'jin', '91');

-- ----------------------------
-- Table structure for `operate`
-- ----------------------------
DROP TABLE IF EXISTS `operate`;
CREATE TABLE `operate` (
  `id` int(11) NOT NULL,
  `stuId` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `operate` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operate
-- ----------------------------
INSERT INTO `operate` VALUES ('1', '1', '2019-06-01 16:50:12', 'delete');

-- ----------------------------
-- Table structure for `profess`
-- ----------------------------
DROP TABLE IF EXISTS `profess`;
CREATE TABLE `profess` (
  `pId` int(11) NOT NULL,
  `pname` varchar(20) NOT NULL,
  `pdepart` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`pId`),
  KEY `pname` (`pname`),
  KEY `pdepart` (`pdepart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profess
-- ----------------------------
INSERT INTO `profess` VALUES ('1', 'computer', 'xinxi');
INSERT INTO `profess` VALUES ('2', 'psycho', 'liyuan');
INSERT INTO `profess` VALUES ('3', 'IEEE', 'jixie');

-- ----------------------------
-- Table structure for `qinshi`
-- ----------------------------
DROP TABLE IF EXISTS `qinshi`;
CREATE TABLE `qinshi` (
  `qId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `qnum` int(5) NOT NULL,
  PRIMARY KEY (`qId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qinshi
-- ----------------------------
INSERT INTO `qinshi` VALUES ('9-501', '4');
INSERT INTO `qinshi` VALUES ('9-503', '3');

-- ----------------------------
-- Table structure for `qin_stu`
-- ----------------------------
DROP TABLE IF EXISTS `qin_stu`;
CREATE TABLE `qin_stu` (
  `qsqinId` varchar(20) CHARACTER SET latin1 NOT NULL,
  `qsstuId` int(11) NOT NULL,
  `qsstuname` varchar(20) CHARACTER SET latin1 NOT NULL,
  `qsscore` int(5) DEFAULT NULL,
  PRIMARY KEY (`qsqinId`,`qsstuId`),
  KEY `qsstuname` (`qsstuname`),
  CONSTRAINT `qin_stu_ibfk_1` FOREIGN KEY (`qsqinId`) REFERENCES `qinshi` (`qId`) ON UPDATE CASCADE,
  CONSTRAINT `qin_stu_ibfk_2` FOREIGN KEY (`qsstuname`) REFERENCES `infor` (`name`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qin_stu
-- ----------------------------
INSERT INTO `qin_stu` VALUES ('9-503', '11', 'weng', '95');
INSERT INTO `qin_stu` VALUES ('9-503', '12', 'jin', '92');

-- ----------------------------
-- Table structure for `stu_score`
-- ----------------------------
DROP TABLE IF EXISTS `stu_score`;
CREATE TABLE `stu_score` (
  `ssstuId` int(11) NOT NULL,
  `ssstuname` varchar(20) CHARACTER SET latin1 NOT NULL,
  `sskename` varchar(20) CHARACTER SET latin1 NOT NULL,
  `ssscore` int(5) DEFAULT NULL,
  PRIMARY KEY (`ssstuId`,`sskename`),
  KEY `ssstuname` (`ssstuname`),
  KEY `sskename` (`sskename`),
  CONSTRAINT `stu_score_ibfk_1` FOREIGN KEY (`ssstuname`) REFERENCES `infor` (`name`) ON UPDATE CASCADE,
  CONSTRAINT `stu_score_ibfk_2` FOREIGN KEY (`sskename`) REFERENCES `kecheng` (`kename`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_score
-- ----------------------------
INSERT INTO `stu_score` VALUES ('11', 'jin', 'data', '90');
INSERT INTO `stu_score` VALUES ('12', 'weng', 'data', '90');
INSERT INTO `stu_score` VALUES ('12', 'weng', 'html', '85');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tId` int(11) NOT NULL,
  `tname` varchar(20) CHARACTER SET latin1 NOT NULL,
  `tdepart` varchar(20) NOT NULL,
  `tpw` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`tId`),
  KEY `tname` (`tname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('21', 'zheng', 'xinxi', '123');
INSERT INTO `teacher` VALUES ('22', 'xu', 'xinxi', '123');
INSERT INTO `teacher` VALUES ('23', 'weng', 'xinxi', '123');
INSERT INTO `teacher` VALUES ('24', 'wang', 'jixie', '123');
