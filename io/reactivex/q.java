package io.reactivex;
/* loaded from: classes4.dex */
public abstract class q<T> implements t<T> {
    protected abstract void a(u<? super T> uVar);

    public static int dDL() {
        return g.dDL();
    }

    @Override // io.reactivex.t
    public final void subscribe(u<? super T> uVar) {
        io.reactivex.internal.functions.a.h(uVar, "observer is null");
        try {
            u<? super T> a = io.reactivex.d.a.a(this, uVar);
            io.reactivex.internal.functions.a.h(a, "Plugin returned null Observer");
            a(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.I(th);
            io.reactivex.d.a.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
