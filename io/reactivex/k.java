package io.reactivex;
/* loaded from: classes17.dex */
public abstract class k<T> implements o<T> {
    protected abstract void b(m<? super T> mVar);

    @Override // io.reactivex.o
    public final void a(m<? super T> mVar) {
        io.reactivex.internal.functions.a.l(mVar, "observer is null");
        m<? super T> a2 = io.reactivex.e.a.a(this, mVar);
        io.reactivex.internal.functions.a.l(a2, "observer returned by the RxJavaPlugins hook is null");
        try {
            b(a2);
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
