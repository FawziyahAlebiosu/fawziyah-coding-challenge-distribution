# fawziyah-coding-challenge-distribution
Instructions to Run & Compile
- ensure you have Java 7 or greater installed on your computer
- download this repo
- if you have Junit on your computer, navigate to the test/java/com/example/fawziyahnprcodingchallenge folder
    - run the class in the ```AppTest.java``` file
- if you don't have Junit installed, navigate to the src/main/java/com/example/fawziyahnprcodingchallenge folder
    - run the main method in the ```emailValidator.java``` class.

Assumptions
- this algorithm assumes that the user wants the sorted version of the emails added to the input file provided. 
    -  the unsorted emails are not deleted however! instead the sorted emails are added below dotted lines and marked as sorted and validated
-  this algorithm does not consider email addresses with quotation marks in them as valid. it also does not consider email addresses without the ```@``` symbol before the domain as valid.
-  this algorithm is able to handle empty files
-  this algorithm needs the user to include a line with "end" to indicate which line to stop the validation process.
