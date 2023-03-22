package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public interface TypeAliasDescriptor extends ClassifierDescriptorWithTypeParameters {
    ClassDescriptor getClassDescriptor();

    SimpleType getExpandedType();

    SimpleType getUnderlyingType();
}
