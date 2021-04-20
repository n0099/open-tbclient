package io.reactivex.internal.subscriptions;

import f.b.x.c.d;
import g.d.c;
/* loaded from: classes7.dex */
public enum EmptySubscription implements d<Object> {
    INSTANCE;

    public static void complete(c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th, c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    @Override // g.d.d
    public void cancel() {
    }

    @Override // f.b.x.c.f
    public void clear() {
    }

    @Override // f.b.x.c.f
    public boolean isEmpty() {
        return true;
    }

    @Override // f.b.x.c.f
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // f.b.x.c.f
    public Object poll() {
        return null;
    }

    @Override // g.d.d
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // f.b.x.c.c
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
