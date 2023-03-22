package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
/* loaded from: classes9.dex */
public final class SingleModuleClassResolver implements ModuleClassResolver {
    public JavaDescriptorResolver resolver;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver
    public ClassDescriptor resolveClass(JavaClass javaClass) {
        JavaDescriptorResolver javaDescriptorResolver = this.resolver;
        if (javaDescriptorResolver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resolver");
        }
        return javaDescriptorResolver.resolveClass(javaClass);
    }

    public final void setResolver(JavaDescriptorResolver javaDescriptorResolver) {
        this.resolver = javaDescriptorResolver;
    }
}
