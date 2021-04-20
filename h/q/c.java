package h.q;

import h.j;
import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
/* loaded from: classes7.dex */
public class c<T> extends j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final j<? super T> f68987e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f68988f;

    public c(j<? super T> jVar) {
        super(jVar);
        this.f68987e = jVar;
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public void b(Throwable th) {
        h.r.f.c().b().a(th);
        try {
            this.f68987e.onError(th);
            try {
                unsubscribe();
            } catch (Throwable th2) {
                h.r.c.j(th2);
                throw new OnErrorFailedException(th2);
            }
        } catch (OnErrorNotImplementedException e2) {
            try {
                unsubscribe();
                throw e2;
            } catch (Throwable th3) {
                h.r.c.j(th3);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th, th3)));
            }
        } catch (Throwable th4) {
            h.r.c.j(th4);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th, th4)));
            } catch (Throwable th5) {
                h.r.c.j(th5);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th, th4, th5)));
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    @Override // h.e
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (this.f68988f) {
            return;
        }
        this.f68988f = true;
        try {
            this.f68987e.onCompleted();
            try {
                unsubscribe();
            } finally {
            }
        } catch (Throwable th) {
            try {
                h.m.a.e(th);
                h.r.c.j(th);
                throw new OnCompletedFailedException(th.getMessage(), th);
            } catch (Throwable th2) {
                try {
                    unsubscribe();
                    throw th2;
                } finally {
                }
            }
        }
    }

    @Override // h.e
    public void onError(Throwable th) {
        h.m.a.e(th);
        if (this.f68988f) {
            return;
        }
        this.f68988f = true;
        b(th);
    }

    @Override // h.e
    public void onNext(T t) {
        try {
            if (this.f68988f) {
                return;
            }
            this.f68987e.onNext(t);
        } catch (Throwable th) {
            h.m.a.f(th, this);
        }
    }
}
