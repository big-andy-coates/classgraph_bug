# ClassGraph bug

Demonstrates bug in [Class Graph](https://github.com/classgraph/classgraph) v4.8.143.

The bug is only encountered when testing a Java Module, i.e. 
a module with a [module-info.java](src/main/java/module-info.java) file & when running from the module path. The latter
is achieved via the `org.javamodularity.moduleplugin` Gradle plugin.

## To recreate the bug:

Execute [ClassGraphBugTest](src/test/java/io/github/big/andy/coates/classgraph/ClassGraphBugTest.java) or
`gradle` and the code should build and the test fail.

## Cause

An exception is thrown when `PatchedModuleReader`'s `list` method is invoked and there is an `ExplodedResourceFinder` 
for a directory that doesn't exist.  The three resource folders are:

* build/classes/java/test
* build/resources/main
* build/resources/test

In this case the two resource directories don't exist. Either not existing causes the test to fail.

## Workaround

Simple, just have at least one resource and one test-resource, and of course at least one class.

You can prove this by creating a file locally in `src/main/resources` and `src/test/resources`, and re-running the test.