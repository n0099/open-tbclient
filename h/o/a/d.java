package h.o.a;

import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes7.dex */
public final class d<T, R> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f68404e;

    /* renamed from: f  reason: collision with root package name */
    public final int f68405f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68406g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i2) {
        this.f68404e = onSubscribeCombineLatest$LatestCoordinator;
        this.f68405f = i2;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        request(j);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68406g) {
            return;
        }
        this.f68406g = true;
        this.f68404e.combine(null, this.f68405f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f68406g) {
            h.r.c.j(th);
            return;
        }
        this.f68404e.onError(th);
        this.f68406g = true;
        this.f68404e.combine(null, this.f68405f);
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f68406g) {
            return;
        }
        this.f68404e.combine(NotificationLite.h(t), this.f68405f);
    }
}
