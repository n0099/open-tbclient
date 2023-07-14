package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes2.dex */
public final class NullValue extends ConstantValue<Void> {
    public NullValue() {
        super(null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        SimpleType nullableNothingType = moduleDescriptor.getBuiltIns().getNullableNothingType();
        Intrinsics.checkExpressionValueIsNotNull(nullableNothingType, "module.builtIns.nullableNothingType");
        return nullableNothingType;
    }
}
