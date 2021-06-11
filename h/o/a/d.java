package h.o.a;

import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes8.dex */
public final class d<T, R> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f71703e;

    /* renamed from: f  reason: collision with root package name */
    public final int f71704f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71705g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i2) {
        this.f71703e = onSubscribeCombineLatest$LatestCoordinator;
        this.f71704f = i2;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        request(j);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f71705g) {
            return;
        }
        this.f71705g = true;
        this.f71703e.combine(null, this.f71704f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f71705g) {
            h.r.c.j(th);
            return;
        }
        this.f71703e.onError(th);
        this.f71705g = true;
        this.f71703e.combine(null, this.f71704f);
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f71705g) {
            return;
        }
        this.f71703e.combine(NotificationLite.h(t), this.f71704f);
    }
}
