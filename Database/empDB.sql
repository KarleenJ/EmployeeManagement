-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema employeedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema employeedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `employeedb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `employeedb` ;

-- -----------------------------------------------------
-- Table `employeedb`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employeedb`.`departments` (
  `deptId` INT(11) NOT NULL AUTO_INCREMENT,
  `deptName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`deptId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `employeedb`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `employeedb`.`employees` (
  `empId` INT(11) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `deptId` INT(11) NULL DEFAULT NULL,
  `startDate` DATE NOT NULL,
  `endDate` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`empId`),
  INDEX `deptId_idx` (`deptId` ASC) VISIBLE,
  CONSTRAINT `FK_deptId`
    FOREIGN KEY (`deptId`)
    REFERENCES `employeedb`.`departments` (`deptId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
