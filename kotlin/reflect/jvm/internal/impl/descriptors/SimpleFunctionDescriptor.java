package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
/* loaded from: classes9.dex */
public interface SimpleFunctionDescriptor extends FunctionDescriptor {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder();
}
