package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;
/* loaded from: classes9.dex */
public final class IsKPropertyCheck implements Check {
    public static final IsKPropertyCheck INSTANCE = new IsKPropertyCheck();
    public static final String description = description;
    public static final String description = description;

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return description;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor functionDescriptor) {
        ValueParameterDescriptor secondParameter = functionDescriptor.getValueParameters().get(1);
        ReflectionTypes.Companion companion = ReflectionTypes.Companion;
        Intrinsics.checkExpressionValueIsNotNull(secondParameter, "secondParameter");
        KotlinType createKPropertyStarType = companion.createKPropertyStarType(DescriptorUtilsKt.getModule(secondParameter));
        if (createKPropertyStarType != null) {
            KotlinType type = secondParameter.getType();
            Intrinsics.checkExpressionValueIsNotNull(type, "secondParameter.type");
            return TypeUtilsKt.isSubtypeOf(createKPropertyStarType, TypeUtilsKt.makeNotNullable(type));
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }
}
