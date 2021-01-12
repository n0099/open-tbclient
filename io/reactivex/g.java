package io.reactivex;

import io.reactivex.internal.subscribers.StrictSubscriber;
/* loaded from: classes5.dex */
public abstract class g<T> implements org.a.b<T> {
    static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    protected abstract void a(org.a.c<? super T> cVar);

    public static int eHO() {
        return BUFFER_SIZE;
    }

    public final <R> g<R> a(io.reactivex.b.h<? super T, ? extends R> hVar) {
        io.reactivex.internal.functions.a.m(hVar, "mapper is null");
        return io.reactivex.d.a.a(new io.reactivex.internal.operators.flowable.b(this, hVar));
    }

    @Override // org.a.b
    public final void subscribe(org.a.c<? super T> cVar) {
        if (cVar instanceof j) {
            a((j) ((j) cVar));
            return;
        }
        io.reactivex.internal.functions.a.m(cVar, "s is null");
        a((j) new StrictSubscriber(cVar));
    }

    public final void a(j<? super T> jVar) {
        io.reactivex.internal.functions.a.m(jVar, "s is null");
        try {
            org.a.c<? super T> a2 = io.reactivex.d.a.a(this, jVar);
            io.reactivex.internal.functions.a.m(a2, "Plugin returned null Subscriber");
            a(a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.O(th);
            io.reactivex.d.a.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
