package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public final class ByteValue extends IntegerValueConstant<Byte> {
    public ByteValue(byte b) {
        super(Byte.valueOf(b));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        SimpleType byteType = moduleDescriptor.getBuiltIns().getByteType();
        Intrinsics.checkExpressionValueIsNotNull(byteType, "module.builtIns.byteType");
        return byteType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public String toString() {
        return ((int) getValue().byteValue()) + ".toByte()";
    }
}
