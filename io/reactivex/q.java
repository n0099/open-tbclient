package io.reactivex;
/* loaded from: classes5.dex */
public abstract class q<T> implements t<T> {
    protected abstract void a(u<? super T> uVar);

    public static int eKe() {
        return g.eKe();
    }

    @Override // io.reactivex.t
    public final void subscribe(u<? super T> uVar) {
        io.reactivex.internal.functions.a.m(uVar, "observer is null");
        try {
            u<? super T> a2 = io.reactivex.d.a.a(this, uVar);
            io.reactivex.internal.functions.a.m(a2, "Plugin returned null Observer");
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
