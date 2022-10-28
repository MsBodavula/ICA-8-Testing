# ICA-8-Testing

In men's public toilets with urinals, there is this unwritten rule that you leave at least one urinal free between you and 
the next person peeing. For example if there are 3 urinals and one person is already peeing in the left one, you will 
choose the urinal on the right and not the one in the middle. That means that a maximum of 3 people can pee at the 
same time on public toilets with 5 urinals when following this rule (Only 2 if the first person pees into urinal 2 or 4).

goodString() is used to check if the user passed input is combination of only 1's and 0's or not

countUrinals() will count the number of available urinals from the given input string( available urinals are those, when filled will have vacancies on there left and right )

availabilityFromFileData() function will read the input data from urinal.dat file and if the file contains data other than -1 and if the data is combination of 1's and 0's then countUrinals() will caluclate the available urinals for each input and write the output to rule(x).txt, where x can be null or any int depending on the existance of rule files in the directory, i.e if rul.txt exists in directory, rule1.txt will be created , if rule1.txt exists, then rule2.txt will be created and so on.

If the input file doesn't have any valid strings then no output file will be created. Message will be displayed to the user

Input file (urinal.dat) should be in the same folder where text files and urinals.java are located.

Output files will be generated in the same folder of input files. 
