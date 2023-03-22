package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public final class ModuleDependenciesImpl implements ModuleDependencies {
    public final List<ModuleDescriptorImpl> allDependencies;
    public final List<ModuleDescriptorImpl> expectedByDependencies;
    public final Set<ModuleDescriptorImpl> modulesWhoseInternalsAreVisible;

    public ModuleDependenciesImpl(List<ModuleDescriptorImpl> list, Set<ModuleDescriptorImpl> set, List<ModuleDescriptorImpl> list2) {
        this.allDependencies = list;
        this.modulesWhoseInternalsAreVisible = set;
        this.expectedByDependencies = list2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public List<ModuleDescriptorImpl> getAllDependencies() {
        return this.allDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public List<ModuleDescriptorImpl> getExpectedByDependencies() {
        return this.expectedByDependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies
    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return this.modulesWhoseInternalsAreVisible;
    }
}
