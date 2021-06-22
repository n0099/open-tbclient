package kotlin.reflect;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\u0004\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"", "T", "Lkotlin/reflect/KClass;", "value", "cast", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KClasses")
/* loaded from: classes8.dex */
public final class KClasses {
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T cast(KClass<T> cast, Object obj) {
        Intrinsics.checkNotNullParameter(cast, "$this$cast");
        if (cast.isInstance(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
        throw new ClassCastException("Value cannot be cast to " + cast.getQualifiedName());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T safeCast(KClass<T> safeCast, Object obj) {
        Intrinsics.checkNotNullParameter(safeCast, "$this$safeCast");
        if (safeCast.isInstance(obj)) {
            if (obj != 0) {
                return obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
        return null;
    }
}
