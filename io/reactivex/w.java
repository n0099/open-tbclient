package io.reactivex;
/* loaded from: classes6.dex */
public abstract class w<T> implements aa<T> {
    protected abstract void b(y<? super T> yVar);

    @Override // io.reactivex.aa
    public final void a(y<? super T> yVar) {
        io.reactivex.internal.functions.a.n(yVar, "subscriber is null");
        y<? super T> a2 = io.reactivex.d.a.a(this, yVar);
        io.reactivex.internal.functions.a.n(a2, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            b(a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.N(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
