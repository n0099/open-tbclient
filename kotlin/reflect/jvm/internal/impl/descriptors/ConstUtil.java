package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.JvmStatic;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes2.dex */
public final class ConstUtil {
    public static final ConstUtil INSTANCE = new ConstUtil();

    @JvmStatic
    public static final boolean canBeUsedForConstVal(KotlinType kotlinType) {
        return ConstUtilKt.canBeUsedForConstVal(kotlinType);
    }
}
