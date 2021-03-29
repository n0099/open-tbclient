package h.o.a;

import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes7.dex */
public final class d<T, R> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f67713e;

    /* renamed from: f  reason: collision with root package name */
    public final int f67714f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67715g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i) {
        this.f67713e = onSubscribeCombineLatest$LatestCoordinator;
        this.f67714f = i;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        request(j);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f67715g) {
            return;
        }
        this.f67715g = true;
        this.f67713e.combine(null, this.f67714f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f67715g) {
            h.r.c.j(th);
            return;
        }
        this.f67713e.onError(th);
        this.f67715g = true;
        this.f67713e.combine(null, this.f67714f);
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f67715g) {
            return;
        }
        this.f67713e.combine(NotificationLite.h(t), this.f67714f);
    }
}
