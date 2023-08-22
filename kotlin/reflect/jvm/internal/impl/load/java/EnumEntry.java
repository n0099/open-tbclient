package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
/* loaded from: classes2.dex */
public final class EnumEntry extends JavaDefaultValue {
    public final ClassDescriptor descriptor;

    public EnumEntry(ClassDescriptor classDescriptor) {
        super(null);
        this.descriptor = classDescriptor;
    }
}
