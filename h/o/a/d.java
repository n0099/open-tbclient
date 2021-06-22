package h.o.a;

import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes8.dex */
public final class d<T, R> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f71807e;

    /* renamed from: f  reason: collision with root package name */
    public final int f71808f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71809g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i2) {
        this.f71807e = onSubscribeCombineLatest$LatestCoordinator;
        this.f71808f = i2;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        request(j);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f71809g) {
            return;
        }
        this.f71809g = true;
        this.f71807e.combine(null, this.f71808f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f71809g) {
            h.r.c.j(th);
            return;
        }
        this.f71807e.onError(th);
        this.f71809g = true;
        this.f71807e.combine(null, this.f71808f);
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f71809g) {
            return;
        }
        this.f71807e.combine(NotificationLite.h(t), this.f71808f);
    }
}
