package kotlin.reflect.jvm.internal.calls;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u001e\u0010\u0004\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00008@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/Caller;", "", "getArity", "(Lkotlin/reflect/jvm/internal/calls/Caller;)I", "arity", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class CallerKt {
    public static final int getArity(Caller<?> caller) {
        return caller.getParameterTypes().size();
    }
}
