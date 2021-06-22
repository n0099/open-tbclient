package h.q;

import h.k;
import rx.exceptions.CompositeException;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
/* loaded from: classes8.dex */
public final class b implements h.c, k {

    /* renamed from: e  reason: collision with root package name */
    public final h.c f72077e;

    /* renamed from: f  reason: collision with root package name */
    public k f72078f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f72079g;

    public b(h.c cVar) {
        this.f72077e = cVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return this.f72079g || this.f72078f.isUnsubscribed();
    }

    @Override // h.c
    public void onCompleted() {
        if (this.f72079g) {
            return;
        }
        this.f72079g = true;
        try {
            this.f72077e.onCompleted();
        } catch (Throwable th) {
            h.m.a.e(th);
            throw new OnCompletedFailedException(th);
        }
    }

    @Override // h.c
    public void onError(Throwable th) {
        h.r.c.j(th);
        if (this.f72079g) {
            return;
        }
        this.f72079g = true;
        try {
            this.f72077e.onError(th);
        } catch (Throwable th2) {
            h.m.a.e(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    @Override // h.c
    public void onSubscribe(k kVar) {
        this.f72078f = kVar;
        try {
            this.f72077e.onSubscribe(this);
        } catch (Throwable th) {
            h.m.a.e(th);
            kVar.unsubscribe();
            onError(th);
        }
    }

    @Override // h.k
    public void unsubscribe() {
        this.f72078f.unsubscribe();
    }
}
