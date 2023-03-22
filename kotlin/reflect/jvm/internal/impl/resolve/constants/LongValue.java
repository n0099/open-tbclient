package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public final class LongValue extends IntegerValueConstant<Long> {
    public LongValue(long j) {
        super(Long.valueOf(j));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        SimpleType longType = moduleDescriptor.getBuiltIns().getLongType();
        Intrinsics.checkExpressionValueIsNotNull(longType, "module.builtIns.longType");
        return longType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return getValue().longValue() + ".toLong()";
    }
}
