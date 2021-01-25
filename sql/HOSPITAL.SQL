DROP DATABASE IF EXISTS hospital;

CREATE DATABASE IF NOT EXISTS hospital;
USE hospital;
# -----------------------------------------------------------------------------
#       TABLE : MEDICAMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MEDICAMENT
 (
   IDTRAITEMENT INTEGER(200) NOT NULL AUTO_INCREMENT ,
   IDF INTEGER(200) NOT NULL  ,
   MEDICAMENT CHAR(255) NOT NULL  ,
   POSOLOGIE CHAR(32) NOT NULL  
   , PRIMARY KEY (IDTRAITEMENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE MEDICAMENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_MEDICAMENT_FEUILLE_DE_SOINS
     ON MEDICAMENT (IDF ASC);

# -----------------------------------------------------------------------------
#       TABLE : MEDECIN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MEDECIN
 (
   MATEMPLOYE CHAR(32) NOT NULL  ,
   IDPERSONNE INTEGER(5) NOT NULL  ,
   TYPECONTRAT CHAR(32) NULL  ,
   DERNIERDIPLOME CHAR(32) NOT NULL  ,
   TYPEUSER CHAR(32) NOT NULL  ,
   NOMS CHAR(32) NOT NULL  ,
   PRENOMS CHAR(32) NOT NULL  ,
   NUMCNI CHAR(32) NULL  ,
   DATENAISS DATE NOT NULL  ,
   LIEUNAISS CHAR(32) NOT NULL  ,
   VILLAGEDEORIG CHAR(32) NOT NULL  ,
   ADRESSE CHAR(32) NOT NULL  ,
   GENRE CHAR(32) NOT NULL  ,
   TELEPHONE VARCHAR(128) NULL  ,
   STATUTMAT CHAR(32) NOT NULL  
   , PRIMARY KEY (MATEMPLOYE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE MEDECIN
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_MEDECIN_PERSONNES
     ON MEDECIN (IDPERSONNE ASC);

# -----------------------------------------------------------------------------
#       TABLE : EXAMEN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EXAMEN
 (
   IDPARA BIGINT(4) NOT NULL  ,
   IDF INTEGER(200) NOT NULL  ,
   CATEGORIE CHAR(32) NOT NULL  ,
   NOM CHAR(32) NOT NULL  
   , PRIMARY KEY (IDPARA) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE EXAMEN
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_EXAMEN_FEUILLE_DE_SOINS
     ON EXAMEN (IDF ASC);

# -----------------------------------------------------------------------------
#       TABLE : FEUILLE_DE_SOINS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FEUILLE_DE_SOINS
 (
   IDF INTEGER(200) NOT NULL AUTO_INCREMENT ,
   IDPATIENT INTEGER(2) NOT NULL  ,
   DATECONSULTATION DATETIME NOT NULL  ,
   MOTIFCONSULTATION CHAR(32) NOT NULL  ,
   TENSION CHAR(32) NOT NULL  ,
   POULS CHAR(32) NOT NULL  ,
   FREQUENCECARD CHAR(32) NOT NULL  ,
   TAILLE DECIMAL(3,2) NOT NULL  ,
   POID DECIMAL(10,2) NOT NULL  ,
   TEMPERATURE DECIMAL(10,2) NOT NULL  ,
   DIAPRINCIPAL CHAR(255) NOT NULL  ,
   DIADIFFERENTIEL VARCHAR(255) NOT NULL  ,
   RESUME VARCHAR(255) NOT NULL  ,
   PATHOLOGIE CHAR(32) NOT NULL  ,
   ETATGENERAL CHAR(255) NOT NULL  ,
   EXAMENPHYSIQUE CHAR(255) NOT NULL  ,
   DATE DATE NOT NULL  
   , PRIMARY KEY (IDF) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE FEUILLE_DE_SOINS
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_FEUILLE_DE_SOINS_PATIENT
     ON FEUILLE_DE_SOINS (IDPATIENT ASC);

# -----------------------------------------------------------------------------
#       TABLE : PATIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PATIENT
 (
   IDPATIENT INTEGER(2) NOT NULL  ,
   IDG CHAR(32) NULL  ,
   IDPERSONNE INTEGER(5) NOT NULL  ,
   NOMS CHAR(32) NOT NULL  ,
   PRENOMS CHAR(32) NOT NULL  ,
   NUMCNI CHAR(32) NULL  ,
   DATENAISS DATE NOT NULL  ,
   LIEUNAISS CHAR(32) NOT NULL  ,
   VILLAGEDEORIG CHAR(32) NOT NULL  ,
   ADRESSE CHAR(32) NOT NULL  ,
   GENRE CHAR(32) NOT NULL  ,
   TELEPHONE VARCHAR(128) NULL  ,
   STATUTMAT CHAR(32) NOT NULL  
   , PRIMARY KEY (IDPATIENT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PATIENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PATIENT_GENERALISTE
     ON PATIENT (IDG ASC);

CREATE  INDEX I_FK_PATIENT_PERSONNES
     ON PATIENT (IDPERSONNE ASC);

# -----------------------------------------------------------------------------
#       TABLE : GENERALISTE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS GENERALISTE
 (
   IDG CHAR(32) NOT NULL  ,
   MATEMPLOYE CHAR(32) NOT NULL  ,
   TYPECONTRAT CHAR(32) NULL  ,
   DERNIERDIPLOME CHAR(32) NOT NULL  ,
   TYPEUSER CHAR(32) NOT NULL  ,
   NOMS CHAR(32) NOT NULL  ,
   PRENOMS CHAR(32) NOT NULL  ,
   NUMCNI CHAR(32) NULL  ,
   DATENAISS DATE NOT NULL  ,
   LIEUNAISS CHAR(32) NOT NULL  ,
   VILLAGEDEORIG CHAR(32) NOT NULL  ,
   ADRESSE CHAR(32) NOT NULL  ,
   GENRE CHAR(32) NOT NULL  ,
   TELEPHONE VARCHAR(128) NULL  ,
   STATUTMAT CHAR(32) NOT NULL  
   , PRIMARY KEY (IDG) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE GENERALISTE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_GENERALISTE_MEDECIN
     ON GENERALISTE (MATEMPLOYE ASC);

# -----------------------------------------------------------------------------
#       TABLE : SPECIALISTE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SPECIALISTE
 (
   IDS CHAR(32) NOT NULL  ,
   MATEMPLOYE CHAR(32) NOT NULL  ,
   TYPECONTRAT CHAR(32) NULL  ,
   DERNIERDIPLOME CHAR(32) NOT NULL  ,
   TYPEUSER CHAR(32) NOT NULL  ,
   NOMS CHAR(32) NOT NULL  ,
   PRENOMS CHAR(32) NOT NULL  ,
   NUMCNI CHAR(32) NULL  ,
   DATENAISS DATE NOT NULL  ,
   LIEUNAISS CHAR(32) NOT NULL  ,
   VILLAGEDEORIG CHAR(32) NOT NULL  ,
   ADRESSE CHAR(32) NOT NULL  ,
   GENRE CHAR(32) NOT NULL  ,
   TELEPHONE VARCHAR(128) NULL  ,
   STATUTMAT CHAR(32) NOT NULL  
   , PRIMARY KEY (IDS) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE SPECIALISTE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_SPECIALISTE_MEDECIN
     ON SPECIALISTE (MATEMPLOYE ASC);

# -----------------------------------------------------------------------------
#       TABLE : REMBOURSEMENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REMBOURSEMENT
 (
   IDR CHAR(32) NOT NULL  ,
   IDF INTEGER(200) NOT NULL  ,
   MONTANT CHAR(32) NOT NULL  
   , PRIMARY KEY (IDR) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE REMBOURSEMENT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_REMBOURSEMENT_FEUILLE_DE_SOINS
     ON REMBOURSEMENT (IDF ASC);

# -----------------------------------------------------------------------------
#       TABLE : PERSONNES
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PERSONNES
 (
   IDPERSONNE INTEGER(5) NOT NULL  ,
   NOMS CHAR(32) NOT NULL  ,
   PRENOMS CHAR(32) NOT NULL  ,
   NUMCNI CHAR(32) NULL  ,
   DATENAISS DATE NOT NULL  ,
   LIEUNAISS CHAR(32) NOT NULL  ,
   VILLAGEDEORIG CHAR(32) NOT NULL  ,
   ADRESSE CHAR(32) NOT NULL  ,
   GENRE CHAR(32) NOT NULL  ,
   TELEPHONE VARCHAR(128) NULL  ,
   STATUTMAT CHAR(32) NOT NULL  
   , PRIMARY KEY (IDPERSONNE) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE MEDICAMENT 
  ADD FOREIGN KEY FK_MEDICAMENT_FEUILLE_DE_SOINS (IDF)
      REFERENCES FEUILLE_DE_SOINS (IDF) ;


ALTER TABLE MEDECIN 
  ADD FOREIGN KEY FK_MEDECIN_PERSONNES (IDPERSONNE)
      REFERENCES PERSONNES (IDPERSONNE) ;


ALTER TABLE EXAMEN 
  ADD FOREIGN KEY FK_EXAMEN_FEUILLE_DE_SOINS (IDF)
      REFERENCES FEUILLE_DE_SOINS (IDF) ;


ALTER TABLE FEUILLE_DE_SOINS 
  ADD FOREIGN KEY FK_FEUILLE_DE_SOINS_PATIENT (IDPATIENT)
      REFERENCES PATIENT (IDPATIENT) ;


ALTER TABLE PATIENT 
  ADD FOREIGN KEY FK_PATIENT_GENERALISTE (IDG)
      REFERENCES GENERALISTE (IDG) ;


ALTER TABLE PATIENT 
  ADD FOREIGN KEY FK_PATIENT_PERSONNES (IDPERSONNE)
      REFERENCES PERSONNES (IDPERSONNE) ;


ALTER TABLE GENERALISTE 
  ADD FOREIGN KEY FK_GENERALISTE_MEDECIN (MATEMPLOYE)
      REFERENCES MEDECIN (MATEMPLOYE) ;


ALTER TABLE SPECIALISTE 
  ADD FOREIGN KEY FK_SPECIALISTE_MEDECIN (MATEMPLOYE)
      REFERENCES MEDECIN (MATEMPLOYE) ;


ALTER TABLE REMBOURSEMENT 
  ADD FOREIGN KEY FK_REMBOURSEMENT_FEUILLE_DE_SOINS (IDF)
      REFERENCES FEUILLE_DE_SOINS (IDF) ;

