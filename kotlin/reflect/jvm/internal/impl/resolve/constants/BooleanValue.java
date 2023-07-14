package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes2.dex */
public final class BooleanValue extends ConstantValue<Boolean> {
    public BooleanValue(boolean z) {
        super(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        SimpleType booleanType = moduleDescriptor.getBuiltIns().getBooleanType();
        Intrinsics.checkExpressionValueIsNotNull(booleanType, "module.builtIns.booleanType");
        return booleanType;
    }
}
