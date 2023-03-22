package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
/* loaded from: classes9.dex */
public final class EmptyPackageFragmentDescriptor extends PackageFragmentDescriptorImpl {
    public EmptyPackageFragmentDescriptor(ModuleDescriptor moduleDescriptor, FqName fqName) {
        super(moduleDescriptor, fqName);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public MemberScope.Empty getMemberScope() {
        return MemberScope.Empty.INSTANCE;
    }
}
