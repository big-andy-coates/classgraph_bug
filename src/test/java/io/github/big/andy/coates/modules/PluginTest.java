package io.github.big.andy.coates.modules;


import org.junit.jupiter.api.Test;

import java.lang.module.ModuleReader;
import java.lang.module.ModuleReference;
import java.lang.module.ResolvedModule;
import java.util.Optional;

class PluginTest {

    @Test
    void shouldNotThrow() throws Exception {
        final Module module = PluginTest.class.getModule();
        final ModuleLayer layer = module.getLayer();
        final Optional<ResolvedModule> resolvedModule = layer.configuration().findModule("module.plugin.bug");
        final ModuleReference reference = resolvedModule.orElseThrow().reference();
        final ModuleReader reader = reference.open();

        // this line throws:
        reader.list();
    }
}
