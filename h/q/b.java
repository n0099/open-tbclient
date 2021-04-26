package h.q;

import h.k;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes7.dex */
public final class b implements h.c, k {

    /* renamed from: e  reason: collision with root package name */
    public final h.c f67994e;

    /* renamed from: f  reason: collision with root package name */
    public k f67995f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67996g;

    public b(h.c cVar) {
        this.f67994e = cVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f67996g || this.f67995f.isUnsubscribed();
    }

    @Override // h.c
    public void onCompleted() {
        if (this.f67996g) {
            return;
        }
        this.f67996g = true;
        try {
            this.f67994e.onCompleted();
        } catch (Throwable th) {
            h.m.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // h.c
    public void onError(Throwable th) {
        h.r.c.j(th);
        if (this.f67996g) {
            return;
        }
        this.f67996g = true;
        try {
            this.f67994e.onError(th);
        } catch (Throwable th2) {
            h.m.a.e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // h.c
    public void onSubscribe(k kVar) {
        this.f67995f = kVar;
        try {
            this.f67994e.onSubscribe(this);
        } catch (Throwable th) {
            h.m.a.e(th);
            kVar.unsubscribe();
            onError(th);
        }
    }

    @Override // h.k
    public void unsubscribe() {
        this.f67995f.unsubscribe();
    }
}
