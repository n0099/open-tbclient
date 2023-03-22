package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public final class FloatValue extends ConstantValue<Float> {
    public FloatValue(float f) {
        super(Float.valueOf(f));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        SimpleType floatType = moduleDescriptor.getBuiltIns().getFloatType();
        Intrinsics.checkExpressionValueIsNotNull(floatType, "module.builtIns.floatType");
        return floatType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().floatValue() + ".toFloat()";
    }
}
