package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\"!\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00008À\u0002@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/KClass;", "", "getQualifiedOrSimpleName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "qualifiedOrSimpleName", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class KClassesImplKt {
    public static final String getQualifiedOrSimpleName(KClass<?> qualifiedOrSimpleName) {
        Intrinsics.checkNotNullParameter(qualifiedOrSimpleName, "$this$qualifiedOrSimpleName");
        return qualifiedOrSimpleName.getQualifiedName();
    }
}
