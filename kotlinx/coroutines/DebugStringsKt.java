package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00048@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00048@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "toDebugString", "(Lkotlin/coroutines/Continuation;)Ljava/lang/String;", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "classSimpleName", "getHexAddress", "hexAddress", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class DebugStringsKt {
    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(Continuation<?> continuation) {
        String m713constructorimpl;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            m713constructorimpl = Result.m713constructorimpl(continuation + '@' + getHexAddress(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m713constructorimpl = Result.m713constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m716exceptionOrNullimpl(m713constructorimpl) != null) {
            m713constructorimpl = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) m713constructorimpl;
    }
}
