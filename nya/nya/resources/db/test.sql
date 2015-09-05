/*
Navicat MySQL Data Transfer

Source Server         : nn
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-09-05 16:17:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `vid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cvideoid` (`vid`),
  KEY `cuserid` (`uid`),
  CONSTRAINT `cuserid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `cvideoid` FOREIGN KEY (`vid`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', 'a', '1', '1');
INSERT INTO `comment` VALUES ('2', 'b', '2', '1');
INSERT INTO `comment` VALUES ('3', 'c', '3', '1');

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `commentid` (`cid`),
  KEY `csusrid` (`uid`),
  CONSTRAINT `commentid` FOREIGN KEY (`cid`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `csusrid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', 'aa', '1', '1');
INSERT INTO `comments` VALUES ('2', 'aaa', '1', '1');

-- ----------------------------
-- Table structure for `danmu`
-- ----------------------------
DROP TABLE IF EXISTS `danmu`;
CREATE TABLE `danmu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(100) DEFAULT NULL,
  `vid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `videoid` (`vid`),
  KEY `userid` (`uid`),
  CONSTRAINT `userid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `videoid` FOREIGN KEY (`vid`) REFERENCES `video` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of danmu
-- ----------------------------
INSERT INTO `danmu` VALUES ('1', 'aaa', '1', '1');
INSERT INTO `danmu` VALUES ('2', 'bbb', '2', '1');
INSERT INTO `danmu` VALUES ('3', 'ccc', '3', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '532000181@qq.com', '1', '2015-09-02 22:44:44');

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `videoname` varchar(100) DEFAULT NULL,
  `videoinr` varchar(100) DEFAULT NULL,
  `playnum` int(11) DEFAULT NULL,
  `collectnum` int(11) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vuserid` (`uid`),
  CONSTRAINT `vuserid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '【AMV】秋山澪x折木奉太郎的爱情故事', '【AMV】秋山澪x折木奉太郎的爱情故事', '111', '111', '0001.jpg', '2015-09-02 22:45:32', '1');
INSERT INTO `video` VALUES ('2', '【催泪MAD】感谢你的陪伴,感谢你给予我一生的感动——致你一首优美的诗', '【催泪MAD】感谢你的陪伴,感谢你给予我一生的感动——致你一首优美的诗', '222', '222', '0002.jpg', '2015-09-02 22:47:55', '1');
INSERT INTO `video` VALUES ('3', '【综漫】好喜欢你，但是，再见了', '【综漫】好喜欢你，但是，再见了', '333', '333', '0003.jpg', '2015-09-02 22:49:51', '1');
