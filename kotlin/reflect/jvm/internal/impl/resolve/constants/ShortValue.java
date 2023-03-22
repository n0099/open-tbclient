package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public final class ShortValue extends IntegerValueConstant<Short> {
    public ShortValue(short s) {
        super(Short.valueOf(s));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        SimpleType shortType = moduleDescriptor.getBuiltIns().getShortType();
        Intrinsics.checkExpressionValueIsNotNull(shortType, "module.builtIns.shortType");
        return shortType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return ((int) getValue().shortValue()) + ".toShort()";
    }
}
