package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes9.dex */
public final class ReflectKotlinClassFinderKt {
    public static final String toRuntimeFqName(ClassId classId) {
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "relativeClassName.asString()");
        String replace$default = StringsKt__StringsJVMKt.replace$default(asString, (char) IStringUtil.EXTENSION_SEPARATOR, '$', false, 4, (Object) null);
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(packageFqName, "packageFqName");
        if (!packageFqName.isRoot()) {
            return classId.getPackageFqName() + IStringUtil.EXTENSION_SEPARATOR + replace$default;
        }
        return replace$default;
    }
}
