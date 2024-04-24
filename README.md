# CSC-207: Mini-Project 9: Bit trees and Braille
Author: Trung Le

## Summary
This project explores the representation of binary information and the application of binary tree for encoding and decoding Braille symbols. Using the data structure `BitTree`, the application allows users to convert text from ASCII to Braille and from Braille to both ASCII and Unicode representations.

## How to compile and run
- Compile the Java files into the `bin` directory by typing this command to the terminal:
```bash
javac -d bin src/*.java
```
- Run the application by typing this command to the terminal: 
```bash
java -cp bin BrailleASCII [mode] [input]
```
Where `[mode]` is either braille, ascii, or unicode, depending on the desired output format, and `[input]` is the string you wish to convert.

## Attribution

I would like to thank Professor Rebelsky for his instructions and guidance, especially on his Q&A section and test suite.