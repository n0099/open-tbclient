package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JavaDescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
/* loaded from: classes10.dex */
public final class FieldOverridabilityCondition implements ExternalOverridabilityCondition {
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.BOTH;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    public ExternalOverridabilityCondition.Result isOverridable(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, ClassDescriptor classDescriptor) {
        if ((callableDescriptor2 instanceof PropertyDescriptor) && (callableDescriptor instanceof PropertyDescriptor)) {
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor2;
            PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor;
            if (!Intrinsics.areEqual(propertyDescriptor.getName(), propertyDescriptor2.getName())) {
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
            if (JavaDescriptorUtilKt.isJavaField(propertyDescriptor) && JavaDescriptorUtilKt.isJavaField(propertyDescriptor2)) {
                return ExternalOverridabilityCondition.Result.OVERRIDABLE;
            }
            if (!JavaDescriptorUtilKt.isJavaField(propertyDescriptor) && !JavaDescriptorUtilKt.isJavaField(propertyDescriptor2)) {
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
            return ExternalOverridabilityCondition.Result.INCOMPATIBLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
    }
}
