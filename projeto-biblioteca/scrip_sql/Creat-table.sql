-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Gerencial
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Gerencial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Gerencial` DEFAULT CHARACTER SET utf8 ;
USE `Gerencial` ;

-- -----------------------------------------------------
-- Table `Gerencial`.`USUARIO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gerencial`.`USUARIO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `data_cadastro` DATE NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Gerencial`.`LIVROS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gerencial`.`LIVROS` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(50) NOT NULL,
  `autor` VARCHAR(50) NOT NULL,
  `isbn` VARCHAR(30) NOT NULL,
  `data_publicacao` DATE NOT NULL,
  `categoria` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Gerencial`.`EMPRESTIMO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Gerencial`.`EMPRESTIMO` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` INT NOT NULL,
  `livro_id` INT NOT NULL,
  `data_emprestimo` DATE NOT NULL,
  `data_devolucao` DATE NOT NULL,
  `status` CHAR(1) NOT NULL,
  `usuarios_id` INT NOT NULL,
  `livros_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_EMPRESTIMO_USUARIO_idx` (`usuario_id` ASC),
  INDEX `fk_EMPRESTIMO_LIVROS_idx` (`livro_id` ASC),
  CONSTRAINT `fk_EMPRESTIMO_USUARIO`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `Gerencial`.`USUARIO` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_EMPRESTIMO_LIVROS`
    FOREIGN KEY (`livros_id`)
    REFERENCES `Gerencial`.`LIVROS` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
