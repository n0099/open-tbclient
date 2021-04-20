package h.q;

import h.k;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes7.dex */
public final class b implements h.c, k {

    /* renamed from: e  reason: collision with root package name */
    public final h.c f68984e;

    /* renamed from: f  reason: collision with root package name */
    public k f68985f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68986g;

    public b(h.c cVar) {
        this.f68984e = cVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f68986g || this.f68985f.isUnsubscribed();
    }

    @Override // h.c
    public void onCompleted() {
        if (this.f68986g) {
            return;
        }
        this.f68986g = true;
        try {
            this.f68984e.onCompleted();
        } catch (Throwable th) {
            h.m.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // h.c
    public void onError(Throwable th) {
        h.r.c.j(th);
        if (this.f68986g) {
            return;
        }
        this.f68986g = true;
        try {
            this.f68984e.onError(th);
        } catch (Throwable th2) {
            h.m.a.e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // h.c
    public void onSubscribe(k kVar) {
        this.f68985f = kVar;
        try {
            this.f68984e.onSubscribe(this);
        } catch (Throwable th) {
            h.m.a.e(th);
            kVar.unsubscribe();
            onError(th);
        }
    }

    @Override // h.k
    public void unsubscribe() {
        this.f68985f.unsubscribe();
    }
}
