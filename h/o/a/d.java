package h.o.a;

import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes7.dex */
public final class d<T, R> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f67708e;

    /* renamed from: f  reason: collision with root package name */
    public final int f67709f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67710g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i) {
        this.f67708e = onSubscribeCombineLatest$LatestCoordinator;
        this.f67709f = i;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        request(j);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f67710g) {
            return;
        }
        this.f67710g = true;
        this.f67708e.combine(null, this.f67709f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f67710g) {
            h.r.c.j(th);
            return;
        }
        this.f67708e.onError(th);
        this.f67710g = true;
        this.f67708e.combine(null, this.f67709f);
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f67710g) {
            return;
        }
        this.f67708e.combine(NotificationLite.g(t), this.f67709f);
    }
}
