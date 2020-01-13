package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class h {
    public static final Object O(Throwable th) {
        q.j(th, com.baidu.fsg.base.statistics.b.k);
        return new Result.Failure(th);
    }

    public static final void bP(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
