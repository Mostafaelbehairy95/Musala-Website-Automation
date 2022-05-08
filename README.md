# Musala-Website-Automation

## Needed configuration before Run
1. Eclipse IDE
2. Java 8 JDK + JRE
3. TestNg plugin in Eclipse
4. Install Chrome browser
5. Install Firefox browser

## Guide To Understand how it works
### There are two packages in this path <src\main\java> that are important to run this project
1. Common package -> That contain

    * BaseTest class that have basic setup to be able to start testing
    * ExtractionProperties class that reads data from config file
    * ReadDataExcel class (data driven) that helps you to read data from Excel sheet
    * config.properties that's file contains basic configuration data

2. MusalaSoftPOM -> The below classes these have webelment location + functions that used to locate webelment or perform specific task
 
    * Careers
    * Company
    * Contactus
    * HomePage
    * JobApplication
    * JoinUs
    * SingleJobPage

### Also You can find Test Cases in this path src\test\java\TestCases. They four test cases that are listed below.
* ContactUsTCs
* CompanyTcs  
* JoinUsTcs
* DisplayPositionbylocation

### There Some files which are needed to run Test Suite like
1. in folder BrowserDriver you can find Google webdriver and Firefox Webdriver.

        Note: The webdriver of browser should be the same version of installed browser
2. In folder DataSheet you can find 

    * Excel sheet that's used during run testing for ContactUsTCs + JoinUsTcs
    * CV that's used during run testing for JoinUST


## Run Test
1. Open testng.xml
2. Right click on it
3. Run As Testng suite

        Note: The test will be run on Chrome Browser if you want to run it on fireFox you can change Parameter in testng.xml from chrome -> fireFox

## Run Report
[Once CLICK here you will be Redirect to TEST REPORT](https://htmlpreview.github.io/?https://github.com/Mostafaelbehairy95/Musala-Website-Automation/blob/master/test-output/emailable-report.html)
