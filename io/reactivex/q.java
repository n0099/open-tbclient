package io.reactivex;
/* loaded from: classes6.dex */
public abstract class q<T> implements t<T> {
    protected abstract void a(u<? super T> uVar);

    public static int eJU() {
        return g.eJU();
    }

    @Override // io.reactivex.t
    public final void subscribe(u<? super T> uVar) {
        io.reactivex.internal.functions.a.n(uVar, "observer is null");
        try {
            u<? super T> a2 = io.reactivex.d.a.a(this, uVar);
            io.reactivex.internal.functions.a.n(a2, "Plugin returned null Observer");
            a(a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.N(th);
            io.reactivex.d.a.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
