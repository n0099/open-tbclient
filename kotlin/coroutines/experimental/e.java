package kotlin.coroutines.experimental;

import kotlin.coroutines.experimental.d;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.q;
/* loaded from: classes5.dex */
public final class e implements d {
    public static final e nBs = new e();

    private e() {
    }

    @Override // kotlin.coroutines.experimental.d
    public <E extends d.b> E a(d.c<E> cVar) {
        q.j(cVar, "key");
        return null;
    }

    @Override // kotlin.coroutines.experimental.d
    public <R> R fold(R r, m<? super R, ? super d.b, ? extends R> mVar) {
        q.j(mVar, "operation");
        return r;
    }

    @Override // kotlin.coroutines.experimental.d
    public d b(d.c<?> cVar) {
        q.j(cVar, "key");
        return this;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
