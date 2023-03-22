package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public interface ModuleDependencies {
    List<ModuleDescriptorImpl> getAllDependencies();

    List<ModuleDescriptorImpl> getExpectedByDependencies();

    Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible();
}
