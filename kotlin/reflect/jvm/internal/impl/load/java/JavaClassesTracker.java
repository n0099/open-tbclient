package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
/* loaded from: classes2.dex */
public interface JavaClassesTracker {

    /* loaded from: classes2.dex */
    public static final class Default implements JavaClassesTracker {
        public static final Default INSTANCE = new Default();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
        public void reportClass(JavaClassDescriptor javaClassDescriptor) {
        }
    }

    void reportClass(JavaClassDescriptor javaClassDescriptor);
}
