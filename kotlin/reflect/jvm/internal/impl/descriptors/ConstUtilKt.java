package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
/* loaded from: classes9.dex */
public final class ConstUtilKt {
    public static final boolean canBeUsedForConstVal(KotlinType kotlinType) {
        if (((!KotlinBuiltIns.isPrimitiveType(kotlinType) && !UnsignedTypes.INSTANCE.isUnsignedType(kotlinType)) || TypeUtils.isNullableType(kotlinType)) && !KotlinBuiltIns.isString(kotlinType)) {
            return false;
        }
        return true;
    }
}
