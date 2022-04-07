# Modules PLugin bug

Demonstrates bug in [Gradle Modules Plugin](https://github.com/java9-modularity/gradle-modules-plugin) v1.8.10.

## To recreate the bug:

Execute [ClassGraphBugTest](src/test/java/io/github/big/andy/coates/modules/PluginTest.java) or
`gradle` and the code should build and the test fail.

## Cause

An exception is thrown from `PatchedModuleReader`'s `list` method is invoked as there are `ExplodedResourceFinder` instances 
for a directory that don't exist.  The three resource folders are:

* build/classes/java/test
* build/resources/main
* build/resources/test

In this case the two resource directories don't exist. Either not existing causes the test to fail.

## Workaround

Simple, just have at least one resource and one test-resource.

You can prove this by creating a file locally in `src/main/resources` and `src/test/resources`, and re-running the test.