package io.reactivex;
/* loaded from: classes7.dex */
public abstract class k<T> implements o<T> {
    protected abstract void b(m<? super T> mVar);

    @Override // io.reactivex.o
    public final void a(m<? super T> mVar) {
        io.reactivex.internal.functions.a.k(mVar, "observer is null");
        m<? super T> a = io.reactivex.e.a.a(this, mVar);
        io.reactivex.internal.functions.a.k(a, "observer returned by the RxJavaPlugins hook is null");
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
