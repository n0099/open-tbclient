package h.o.a;

import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes7.dex */
public final class d<T, R> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f67724e;

    /* renamed from: f  reason: collision with root package name */
    public final int f67725f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67726g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i2) {
        this.f67724e = onSubscribeCombineLatest$LatestCoordinator;
        this.f67725f = i2;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        request(j);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f67726g) {
            return;
        }
        this.f67726g = true;
        this.f67724e.combine(null, this.f67725f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f67726g) {
            h.r.c.j(th);
            return;
        }
        this.f67724e.onError(th);
        this.f67726g = true;
        this.f67724e.combine(null, this.f67725f);
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f67726g) {
            return;
        }
        this.f67724e.combine(NotificationLite.h(t), this.f67725f);
    }
}
