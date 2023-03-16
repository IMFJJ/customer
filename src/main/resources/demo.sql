/*
 Navicat Premium Data Transfer

 Source Server         : 百度云
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : 106.13.201.153:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 16/03/2023 23:02:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_bankstatement
-- ----------------------------
DROP TABLE IF EXISTS `s_bankstatement`;
CREATE TABLE `s_bankstatement`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '流水编号',
  `amount` decimal(17, 2) NULL DEFAULT NULL COMMENT '交易金额',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '交易日期',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '付款人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_s_bankstatement_name`(`name`) USING BTREE COMMENT '付款人索引'
) ENGINE = InnoDB AUTO_INCREMENT = 15728401 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '银行流水表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_customer
-- ----------------------------
DROP TABLE IF EXISTS `s_customer`;
CREATE TABLE `s_customer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户名称',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  FULLTEXT INDEX `idx_s_customer_name`(`name`) WITH PARSER `ngram`
) ENGINE = InnoDB AUTO_INCREMENT = 1000101 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for s_customer_rel
-- ----------------------------
DROP TABLE IF EXISTS `s_customer_rel`;
CREATE TABLE `s_customer_rel`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `parent_id` int(0) NOT NULL COMMENT '父类客户id',
  `child_id` int(0) NULL DEFAULT NULL COMMENT '子客户id',
  `child_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '子客户名称(适当冗余,增加查询性能)',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_s_customer_rel_parent_id_child_id`(`parent_id`, `child_id`) USING BTREE COMMENT '父子客户联合索引'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '父子客户关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Procedure structure for create_s_bankstatement
-- ----------------------------
DROP PROCEDURE IF EXISTS `create_s_bankstatement`;
delimiter ;;
CREATE PROCEDURE `create_s_bankstatement`()
begin
declare v_cnt decimal (10)  default 0 ; 

dd:loop            

			INSERT INTO s_bankstatement( `amount`,  `name`) select rand()*10000,`name` from s_customer;
            
        commit;                     
        set v_cnt = v_cnt+1 ;                            
            if  v_cnt = 73 then leave dd;                           
            end if;          
        end loop dd ; 
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for create_s_custom
-- ----------------------------
DROP PROCEDURE IF EXISTS `create_s_custom`;
delimiter ;;
CREATE PROCEDURE `create_s_custom`()
begin
declare v_cnt decimal (10)  default 0 ; 
    declare family_str varchar (600) default '赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄麴家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲邰从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍舄璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庾终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查後荆红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于单于太叔申屠公孙仲孙轩辕令狐钟离宇文长孙慕容鲜于闾丘司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓跋夹谷宰父谷梁晋楚闫法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟';
		    declare name_str varchar (128) default '伟杰佳敏嘉梦琪忆柳之桃慕青问兰尔岚元香初夏沛菡傲珊曼文乐菱痴珊恨玉惜文香寒新柔语蓉海安蓉涵柏水桃醉蓝春儿语琴从彤傲晴语兰又菱碧彤元霜怜梦紫寒妙彤曼易南紫翠雨寒易烟如萱若伟杰佳敏静嘉南寻真晓亦向珊慕灵以蕊寻雁映无疆子蹄更封于乌程欧余山之阳';
    declare full_name varchar(255) default '';

    declare rand_num int DEFAULT 0;

dd:loop            

			set full_name ='';
      -- 随机取姓氏
	    set full_name = concat(full_name, SUBSTR(family_str, floor(1+rand()*559), 1));
	    -- 随机取名字
	    set full_name = concat(full_name, SUBSTR(name_str, floor(1+rand()*117), 1));
			-- 名字是否为双字
			set rand_num = rand()*10;
			
			IF rand_num > 5 THEN 
			set full_name = concat(full_name, SUBSTR(name_str, floor(1+rand()*117), 1));
			END IF;
	   insert  into s_customer(`name`) values         
        (full_name)
                ;                   
        commit;                     
        set v_cnt = v_cnt+1 ;                            
            if  v_cnt = 1000000 then leave dd;                           
            end if;          
        end loop dd ; 
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for create_s_custom_rel
-- ----------------------------
DROP PROCEDURE IF EXISTS `create_s_custom_rel`;
delimiter ;;
CREATE PROCEDURE `create_s_custom_rel`()
begin
declare v_cnt decimal (10)  default 0 ; 


dd:loop            

	   INSERT INTO s_customer_rel( `parent_id`, `child_id`,`child_name`) select floor(id/5000)+1,id,`name` from s_customer;
                 
        set v_cnt = v_cnt+1 ;                            
            if  v_cnt = 120 then leave dd;                           
            end if;          
        end loop dd ; 
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
