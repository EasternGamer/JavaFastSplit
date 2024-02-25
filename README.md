# JavaFastSplit
A simple and quick String splitter for Java
Does not make use of REGEX and can be up to 100 times faster, and at worst, equivalent. It will depend on string complexity and splitter complexity, character set (ASCII and UTF8 etc.).

## Why?
The reason why is a little nerdy. It should be faster than other implementations available on Github since they all go character by character, which, honestly is fine, but String#indexOf has an intrinsic candidate marked method of finding a character index, and String#substring directly makes use of the internal byte array of a String object so it should just be plain faster than their versions.
