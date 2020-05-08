package kotlin;

import kotlin.Result;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class i {
    public static final Object R(Throwable th) {
        q.j(th, com.baidu.fsg.base.statistics.b.k);
        return new Result.Failure(th);
    }

    public static final void bA(Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
