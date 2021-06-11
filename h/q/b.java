package h.q;

import h.k;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes8.dex */
public final class b implements h.c, k {

    /* renamed from: e  reason: collision with root package name */
    public final h.c f71973e;

    /* renamed from: f  reason: collision with root package name */
    public k f71974f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71975g;

    public b(h.c cVar) {
        this.f71973e = cVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f71975g || this.f71974f.isUnsubscribed();
    }

    @Override // h.c
    public void onCompleted() {
        if (this.f71975g) {
            return;
        }
        this.f71975g = true;
        try {
            this.f71973e.onCompleted();
        } catch (Throwable th) {
            h.m.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // h.c
    public void onError(Throwable th) {
        h.r.c.j(th);
        if (this.f71975g) {
            return;
        }
        this.f71975g = true;
        try {
            this.f71973e.onError(th);
        } catch (Throwable th2) {
            h.m.a.e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // h.c
    public void onSubscribe(k kVar) {
        this.f71974f = kVar;
        try {
            this.f71973e.onSubscribe(this);
        } catch (Throwable th) {
            h.m.a.e(th);
            kVar.unsubscribe();
            onError(th);
        }
    }

    @Override // h.k
    public void unsubscribe() {
        this.f71974f.unsubscribe();
    }
}
