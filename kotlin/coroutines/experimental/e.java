package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.h;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes10.dex */
public final class e implements d {
    public static final e pSm = new e();

    private e() {
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.n(cVar, "key");
        return null;
    }

    @Override // kotlin.coroutines.experimental.d
    public <R> R fold(R r, m<? super R, ? super d.b, ? extends R> mVar) {
        q.n(mVar, "operation");
        return r;
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.n(cVar, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
