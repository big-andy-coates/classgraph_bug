package io.github.big.andy.coates.classgraph;


import io.github.classgraph.ClassGraph;
import org.junit.jupiter.api.Test;

class ClassGraphBugTest {

    @Test
    void shouldNotThrow() {
        new ClassGraph()
                .verbose()
                .scan();
    }
}
