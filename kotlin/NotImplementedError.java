package kotlin;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String str) {
        super(str);
        q.m(str, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i, o oVar) {
        this((i & 1) != 0 ? "An operation is not implemented." : str);
    }
}
