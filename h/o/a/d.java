package h.o.a;

import rx.internal.operators.NotificationLite;
import rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator;
/* loaded from: classes7.dex */
public final class d<T, R> extends h.j<T> {

    /* renamed from: e  reason: collision with root package name */
    public final OnSubscribeCombineLatest$LatestCoordinator<T, R> f68720e;

    /* renamed from: f  reason: collision with root package name */
    public final int f68721f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68722g;

    public d(OnSubscribeCombineLatest$LatestCoordinator<T, R> onSubscribeCombineLatest$LatestCoordinator, int i) {
        this.f68720e = onSubscribeCombineLatest$LatestCoordinator;
        this.f68721f = i;
        request(onSubscribeCombineLatest$LatestCoordinator.bufferSize);
    }

    public void b(long j) {
        request(j);
    }

    @Override // h.e
    public void onCompleted() {
        if (this.f68722g) {
            return;
        }
        this.f68722g = true;
        this.f68720e.combine(null, this.f68721f);
    }

    @Override // h.e
    public void onError(Throwable th) {
        if (this.f68722g) {
            h.r.c.j(th);
            return;
        }
        this.f68720e.onError(th);
        this.f68722g = true;
        this.f68720e.combine(null, this.f68721f);
    }

    @Override // h.e
    public void onNext(T t) {
        if (this.f68722g) {
            return;
        }
        this.f68720e.combine(NotificationLite.h(t), this.f68721f);
    }
}
