package h.q;

import h.k;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes7.dex */
public final class b implements h.c, k {

    /* renamed from: e  reason: collision with root package name */
    public final h.c f67969e;

    /* renamed from: f  reason: collision with root package name */
    public k f67970f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67971g;

    public b(h.c cVar) {
        this.f67969e = cVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f67971g || this.f67970f.isUnsubscribed();
    }

    @Override // h.c
    public void onCompleted() {
        if (this.f67971g) {
            return;
        }
        this.f67971g = true;
        try {
            this.f67969e.onCompleted();
        } catch (Throwable th) {
            h.m.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // h.c
    public void onError(Throwable th) {
        h.r.c.j(th);
        if (this.f67971g) {
            return;
        }
        this.f67971g = true;
        try {
            this.f67969e.onError(th);
        } catch (Throwable th2) {
            h.m.a.e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // h.c
    public void onSubscribe(k kVar) {
        this.f67970f = kVar;
        try {
            this.f67969e.onSubscribe(this);
        } catch (Throwable th) {
            h.m.a.e(th);
            kVar.unsubscribe();
            onError(th);
        }
    }

    @Override // h.k
    public void unsubscribe() {
        this.f67970f.unsubscribe();
    }
}
