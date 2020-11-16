package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes9.dex */
public final class i {
    public static final Object P(Throwable th) {
        q.n(th, "exception");
        return new Result.Failure(th);
    }

    public static final void bT(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
