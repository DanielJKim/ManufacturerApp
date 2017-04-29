DROP TABLE WINEONLY;
DROP TABLE TYPEOFAPPLICATION;
DROP TABLE ORIGIN;
DROP TABLE FORMS;
DROP TABLE USERS;

CREATE TABLE USERS
(
  USER_ID varchar(255) PRIMARY KEY NOT NULL,
  AUTHENTICATION int NOT NULL,
  USERNAME varchar(20) NOT NULL,
  PASSWORD varchar(20) NOT NULL,
  EMAIL varchar(255) NOT NULL,
  PHONE_NO varchar(20) NOT NULL,
  FIRST_NAME varchar(20) NOT NULL,
  MIDDLE_INITIAL varchar(255),
  LAST_NAME varchar(20) NOT NULL
);
CREATE UNIQUE INDEX USERS_USERNAME_UINDEX ON USERS (USERNAME);
CREATE UNIQUE INDEX USERS_EMAIL_UINDEX ON USERS (EMAIL);

CREATE TABLE FORMS
(
  TTB_ID varchar(255) PRIMARY KEY NOT NULL,
  REP_ID varchar(255),
  PERMIT_NO varchar(255) NOT NULL,
  SOURCE varchar(8) NOT NULL,
  SERIAL_NO varchar(255) NOT NULL,
  ALCOHOL_TYPE varchar(255) NOT NULL,
  BRAND_NAME varchar(255) NOT NULL,
  FANCIFUL_NAME varchar(255),
  ALCOHOL_CONTENT float(52),
  APPLICANT_STREET varchar(255),
  APPLICANT_CITY varchar(255) NOT NULL,
  APPLICANT_ZIP varchar(255) NOT NULL,
  APPLICANT_STATE varchar(255) NOT NULL,
  APPLICANT_COUNTRY varchar(255) NOT NULL,
  MAILING_ADDRESS varchar(255),
  FORMULA varchar(255),
  PHONE_NO varchar(20),
  EMAIL varchar(255) NOT NULL,
  LABEL_TEXT varchar(511),
  LABEL_IMAGE varchar(255),
  SUBMIT_DATE date NOT NULL,
  SIGNATURE varchar(255) NOT NULL,
  STATUS varchar(30) NOT NULL,
  AGENT_ID varchar(255),
  APPLICANT_ID varchar(255) NOT NULL,
  APPROVED_DATE date,
  EXPIRATION_DATE date,
  APPROVAL_COMMENTS varchar(511),
  CONSTRAINT FORMS_USERS_AGENT_ID_FK FOREIGN KEY (AGENT_ID) REFERENCES USERS (USER_ID),
  CONSTRAINT FORMS_USERS_APPLICANT_ID_FK FOREIGN KEY (APPLICANT_ID) REFERENCES USERS (USER_ID)
);

CREATE TABLE TYPEOFAPPLICATION
(
  TTB_ID varchar(255) PRIMARY KEY NOT NULL,
  OPTION_NO int NOT NULL,
  OPTION_DESCRIPTION varchar(255),
  CONSTRAINT TYPEOFAPPLICATION_FORMS_TTB_ID_FK FOREIGN KEY (TTB_ID) REFERENCES FORMS (TTB_ID)
);
CREATE UNIQUE INDEX TYPEOFAPPLICATION_OPTION_NO_UINDEX ON TYPEOFAPPLICATION (TTB_ID, OPTION_NO);

CREATE TABLE WINEONLY
(
  TTB_ID varchar(255) PRIMARY KEY NOT NULL,
  VINTAGE_YEAR varchar(4) NOT NULL,
  PH_LEVEL int NOT NULL,
  GRAPE_VARIETALS varchar(255),
  WINE_APPELLATION varchar(255)
);

CREATE TABLE ORIGIN
(
  ORIGIN_CODE char(2) PRIMARY KEY NOT NULL,
  DESCRIPTION varchar(50) NOT NULL
);
insert into ORIGIN values('0','AMERICAN');
insert into ORIGIN values('1','CALIFORNIA');
insert into ORIGIN values('2','NEW YORK');
insert into ORIGIN values('3','NEW JERSEY');
insert into ORIGIN values('4','ILLINOIS');
insert into ORIGIN values('5','VIRGINIA');
insert into ORIGIN values('6','MICHIGAN');
insert into ORIGIN values('7','WASHINGTON');
insert into ORIGIN values('8','GEORGIA');
insert into ORIGIN values('9','OHIO');
insert into ORIGIN values('10','ALABAMA');
insert into ORIGIN values('11','ARIZONA');
insert into ORIGIN values('12','ARKANSAS');
insert into ORIGIN values('13','COLORADO');
insert into ORIGIN values('14','CONNECTICUT');
insert into ORIGIN values('15','DELAWARE');
insert into ORIGIN values('16','FLORIDA');
insert into ORIGIN values('17','HAWAII');
insert into ORIGIN values('18','IDAHO');
insert into ORIGIN values('19','INDIANA');
insert into ORIGIN values('20','IOWA');
insert into ORIGIN values('21','KANSAS');
insert into ORIGIN values('22','KENTUCKY');
insert into ORIGIN values('23','LOUISIANA');
insert into ORIGIN values('24','MAINE');
insert into ORIGIN values('25','MARYLAND');
insert into ORIGIN values('26','MASSACHUSETTS');
insert into ORIGIN values('27','MINNESOTA');
insert into ORIGIN values('28','MISSISSIPPI');
insert into ORIGIN values('29','MISSOURI');
insert into ORIGIN values('30','MONTANA');
insert into ORIGIN values('31','NEBRASKA');
insert into ORIGIN values('32','NEVADA');
insert into ORIGIN values('33','NEW HAMPSHIRE');
insert into ORIGIN values('34','NEW MEXICO');
insert into ORIGIN values('35','NORTH CAROLINA');
insert into ORIGIN values('36','NORTH DAKOTA');
insert into ORIGIN values('37','OKLAHOMA');
insert into ORIGIN values('38','OREGON');
insert into ORIGIN values('39','PENNSYLVANIA');
insert into ORIGIN values('3A','MONACO');
insert into ORIGIN values('40','RHODE ISLAND');
insert into ORIGIN values('41','SOUTH CAROLINA');
insert into ORIGIN values('42','SOUTH DAKOTA');
insert into ORIGIN values('43','TENNESSEE');
insert into ORIGIN values('44','TEXAS');
insert into ORIGIN values('45','UTAH');
insert into ORIGIN values('46','VERMONT');
insert into ORIGIN values('47','WEST VIRGINIA');
insert into ORIGIN values('48','WISCONSIN');
insert into ORIGIN values('49','WYOMING');
insert into ORIGIN values('4A','PUERTO RICO');
insert into ORIGIN values('4B','VIRGIN ISLANDS, US');
insert into ORIGIN values('4C','BERMUDA');
insert into ORIGIN values('4D','DOMINICAN REPUBLIC');
insert into ORIGIN values('4E','ALASKA');
insert into ORIGIN values('4F','NICARAGUA');
insert into ORIGIN values('4G','BAHAMAS');
insert into ORIGIN values('4H','BARBADOS');
insert into ORIGIN values('4I','CURACAO');
insert into ORIGIN values('4J','KENYA');
insert into ORIGIN values('4K','DISTRICT OF COLUMBIA');
insert into ORIGIN values('4L','KOSOVO');
insert into ORIGIN values('4M','ERITREA');
insert into ORIGIN values('4N','CAMBODIA');
insert into ORIGIN values('4P','ARUBA');
insert into ORIGIN values('4R','TANZANIA');
insert into ORIGIN values('4S','UGANDA');
insert into ORIGIN values('4U','GREAT BRITAIN');
insert into ORIGIN values('4V','TAHITI');
insert into ORIGIN values('4W','FIJI');
insert into ORIGIN values('4X','CABO VERDE, REPUBLIC OF');
insert into ORIGIN values('4Y','ANTIGUA AND BARBUDA');
insert into ORIGIN values('4Z','TIBET');
insert into ORIGIN values('50','ITALY');
insert into ORIGIN values('51','FRANCE');
insert into ORIGIN values('52','SPAIN');
insert into ORIGIN values('53','GERMANY');
insert into ORIGIN values('54','PORTUGAL');
insert into ORIGIN values('55','DENMARK');
insert into ORIGIN values('56','ISRAEL');
insert into ORIGIN values('57','GREECE');
insert into ORIGIN values('58','YUGOSLAVIA');
insert into ORIGIN values('59','JAPAN');
insert into ORIGIN values('5A','EL SALVADOR');
insert into ORIGIN values('5B','SWEDEN');
insert into ORIGIN values('5C','NORWAY');
insert into ORIGIN values('5D','SOUTH KOREA');
insert into ORIGIN values('5E','IRELAND');
insert into ORIGIN values('5F','LEBANON');
insert into ORIGIN values('5G','THAILAND');
insert into ORIGIN values('5H','ICELAND');
insert into ORIGIN values('5I','INDIA');
insert into ORIGIN values('5J','JAMAICA');
insert into ORIGIN values('5K','SCOTLAND');
insert into ORIGIN values('5L','HONDURAS');
insert into ORIGIN values('5M','GUATEMALA');
insert into ORIGIN values('5N','HAITI');
insert into ORIGIN values('5O','SLOVAK REPUBLIC');
insert into ORIGIN values('5P','GUYANA');
insert into ORIGIN values('5Q','ETHIOPIA');
insert into ORIGIN values('5R','SINGAPORE');
insert into ORIGIN values('5S','PHILIPPINES');
insert into ORIGIN values('5T','GRENADA');
insert into ORIGIN values('5U','ZIMBABWE');
insert into ORIGIN values('5V','NIGERIA');
insert into ORIGIN values('5W','IVORY COAST');
insert into ORIGIN values('5Y','CZECH REPUBLIC');
insert into ORIGIN values('5Z','VIETNAM');
insert into ORIGIN values('60','ALBANIA');
insert into ORIGIN values('61','ALGERIA');
insert into ORIGIN values('62','ARGENTINA');
insert into ORIGIN values('63','AUSTRALIA');
insert into ORIGIN values('64','AUSTRIA');
insert into ORIGIN values('65','BELGIUM');
insert into ORIGIN values('66','BOLIVIA');
insert into ORIGIN values('67','BRAZIL');
insert into ORIGIN values('68','BULGARIA');
insert into ORIGIN values('69','CANADA');
insert into ORIGIN values('6A','ARMENIA');
insert into ORIGIN values('6B','AZERBAIJAN');
insert into ORIGIN values('6C','BELARUS');
insert into ORIGIN values('6D','ESTONIA');
insert into ORIGIN values('6E','GEORGIA');
insert into ORIGIN values('6F','KAZAKHSTAN');
insert into ORIGIN values('6G','KYRGYZSTAN');
insert into ORIGIN values('6H','LATVIA');
insert into ORIGIN values('6I','LITHUANIA');
insert into ORIGIN values('6J','MOLDOVA');
insert into ORIGIN values('6K','RUSSIA OR THE RUSSIAN FEDERATION');
insert into ORIGIN values('6L','TAJIKISTAN');
insert into ORIGIN values('6M','TURKMENISTAN');
insert into ORIGIN values('6N','UKRAINE');
insert into ORIGIN values('6O','UZBEKISTAN');
insert into ORIGIN values('6P','ENGLAND');
insert into ORIGIN values('6Q','WALES');
insert into ORIGIN values('6R','THE CHANNEL ISLANDS');
insert into ORIGIN values('6S','THE ISLES OF WIGHT & MAN');
insert into ORIGIN values('6T','SCILLY ISLANDS');
insert into ORIGIN values('6U','HEBRIDES');
insert into ORIGIN values('6V','ORKNEY & SHETLAND ISLANDS');
insert into ORIGIN values('6W','NORTHERN IRELAND');
insert into ORIGIN values('6X','SLOVENIA');
insert into ORIGIN values('6Y','CROATIA');
insert into ORIGIN values('6Z','COSTA RICA');
insert into ORIGIN values('70','CHILE');
insert into ORIGIN values('71','COLOMBIA');
insert into ORIGIN values('72','CYPRUS');
insert into ORIGIN values('73','CZECHOSLOVAKIA');
insert into ORIGIN values('74','EGYPT');
insert into ORIGIN values('75','HUNGARY');
insert into ORIGIN values('77','JORDAN');
insert into ORIGIN values('78','LIBERIA');
insert into ORIGIN values('79','LUXEMBOURG');
insert into ORIGIN values('7A','ECUADOR');
insert into ORIGIN values('7B','INDONESIA');
insert into ORIGIN values('7C','REPUBLIC OF SAN MARINO');
insert into ORIGIN values('7D','BELIZE');
insert into ORIGIN values('7E','PANAMA');
insert into ORIGIN values('7F','MARTINIQUE');
insert into ORIGIN values('7G','MACEDONIA');
insert into ORIGIN values('7H','GHANA');
insert into ORIGIN values('7J','SOMOA');
insert into ORIGIN values('7K','TRINIDAD/TOBAGO');
insert into ORIGIN values('7L','CAMEROON');
insert into ORIGIN values('7M','SAINT MARTIN, NETH ANTILLES');
insert into ORIGIN values('7P','SERBIA AND MONTENEGRO');
insert into ORIGIN values('7Q','ANGUILLA (BWI)');
insert into ORIGIN values('7R','GUADELOUPE');
insert into ORIGIN values('7T','WEST INDIES');
insert into ORIGIN values('7U','SRI LANKA (FORMERLY KNOWN AS CEYLON)');
insert into ORIGIN values('7V','NEPAL');
insert into ORIGIN values('7W','SAINT LUCIA');
insert into ORIGIN values('7X','REUNION');
insert into ORIGIN values('7Y','MONGOLIA');
insert into ORIGIN values('7Z','MYANMAR');
insert into ORIGIN values('80','MALTA');
insert into ORIGIN values('81','MEXICO');
insert into ORIGIN values('82','MOROCCO');
insert into ORIGIN values('83','NETHERLANDS');
insert into ORIGIN values('84','NEW ZEALAND');
insert into ORIGIN values('85','PERU');
insert into ORIGIN values('86','ROMANIA');
insert into ORIGIN values('87','SWITZERLAND');
insert into ORIGIN values('89','TUNISIA');
insert into ORIGIN values('8A','TAIWAN');
insert into ORIGIN values('8B','ST. VINCENT AND THE GRENADINES');
insert into ORIGIN values('8C','LAO PDR OR LAOS');
insert into ORIGIN values('8D','NAMIBIA');
insert into ORIGIN values('8E','BOSNIA-HERZEGOVINA');
insert into ORIGIN values('8F','PARAQUAY');
insert into ORIGIN values('8G','ZAMBIA');
insert into ORIGIN values('8H','MAURITIUS');
insert into ORIGIN values('8I','SINT MAARTEN');
insert into ORIGIN values('8J','WEST BANK');
insert into ORIGIN values('8K','BENIN');
insert into ORIGIN values('8L','LIECHTENSTEIN');
insert into ORIGIN values('90','TURKEY');
insert into ORIGIN values('91','SOUTH AFRICA (UNION OF)');
insert into ORIGIN values('92','UNITED KINGDOM');
insert into ORIGIN values('93','URUGUAY');
insert into ORIGIN values('94','U.S.S.R.');
insert into ORIGIN values('95','VENEZUELA');
insert into ORIGIN values('96','CHINA');
insert into ORIGIN values('97','FINLAND');
insert into ORIGIN values('98','EEC/EU (TTB USE ONLY)');
insert into ORIGIN values('99','POLAND');
insert into ORIGIN values('9A','CAYMAN ISLANDS');
insert into ORIGIN values('9B','CABO VERDE');
insert into ORIGIN values('9C','DEMOCRATIC REPUBLIC OF THE CONGO');
insert into ORIGIN values('9D','SENEGAL');
insert into ORIGIN values('9E','MADAGASCAR, REPUBLIC OF');
insert into ORIGIN values('9F','SURINAME, REPUBLIC OF');
insert into ORIGIN values('9G','GABON');
insert into ORIGIN values('9H','SAN MARINO');
insert into ORIGIN values('9I','BHUTAN/KINGDOM OF BHUTAN');
insert into ORIGIN values('HK','HONG KONG');
insert into ORIGIN values('MC','MUTIPLE COUNTRIES');
