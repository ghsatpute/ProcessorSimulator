# The Processor Simulator 

![Java CI with Maven](https://github.com/ghsatpute/ProcessorSimulator/workflows/Java%20CI%20with%20Maven/badge.svg)


I came across [this blogspot](http://megalomaniacbore.blogspot.com/2014/04/virtual-cpu-in-c-4001-cpu.html),
and I wanted to simulate the physical processor in Java, mostly because I 
just wanted to refresh my _Computer Organization_ knowledge. 

Why Java?
Many would find it absurd to write processor simulator in Java, 
while writing it in C or C++ somewhat sane (the blogspot author implemented in C++).
I think there is not any diference (_at least_, as of now), 
and it's a simulator, so probably doesn't matter. I indeed came across some
issues like Java doesn't support unsigned integers etc but I think it 
doesn't matter. Will see if I need to change the language in the future. 

Also, I used maven for packaging, I didn't wanted to bog down by other complexities,
 I just wanted to focus on simulation rather than anything else. 
 
 # Op codes 
 Currently the processor following operations 
 * LOAD0: 
 
   This is two byte instruction, where first byte is opcode `1` followed by a 
   memory location. This loads contents in memory location in `register0`.   
 * LOAD1: 
  
   This is same as `LOAD0` but just loads the content in `register1`
 * ADD 
    
   This is one byte opcode. This opcode adds content of `register0` and `register1`
    and stores it into `register0`
 * STORE 
 
   This is two byte opcode. This stores the content of `register0` into memory location 
   given in second byte
 
 * PRINT 
   
   Now, this one would be really weird opcode but have this to look into a memory. This 
   one is two byte opcode, second byte represents memory from which content would be 
   loaded into `register0` and printed to the stdout. 
  
 * HALT 
    
    This tells CPU that program is complete. 
    
# Example programs
#### Program to add two numbers and print to the screen 
```
 1;         // LOAD0        <- 1 is opcode for LOAD0
 11;        // 11           <- 11 is data
 2;         // LOAD1        <- 2 is opcode for LOAD1 
 22;        // 22           <- 22 is data
 3;         // ADD
 4;         // STORE
 6;         // 6            <- address where result is stored
 5;         // PRINT
 6;         // 6            <- address from where result should be printed
 0;         // HALT

```
