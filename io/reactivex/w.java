package io.reactivex;
/* loaded from: classes7.dex */
public abstract class w<T> implements aa<T> {
    protected abstract void b(y<? super T> yVar);

    @Override // io.reactivex.aa
    public final void a(y<? super T> yVar) {
        io.reactivex.internal.functions.a.k(yVar, "subscriber is null");
        y<? super T> a = io.reactivex.e.a.a(this, yVar);
        io.reactivex.internal.functions.a.k(a, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            b(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
