package h.o.a;

import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes7.dex */
public final class d<T, R> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f68447e;

    /* renamed from: f  reason: collision with root package name */
    public final int f68448f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68449g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i2) {
        this.f68447e = onSubscribeCombineLatest$LatestCoordinator;
        this.f68448f = i2;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        request(j);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68449g) {
            return;
        }
        this.f68449g = true;
        this.f68447e.combine(null, this.f68448f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f68449g) {
            h.r.c.j(th);
            return;
        }
        this.f68447e.onError(th);
        this.f68449g = true;
        this.f68447e.combine(null, this.f68448f);
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f68449g) {
            return;
        }
        this.f68447e.combine(NotificationLite.h(t), this.f68448f);
    }
}
