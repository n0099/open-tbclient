package io.reactivex.internal.subscriptions;

import io.reactivex.internal.a.d;
import org.a.c;
/* loaded from: classes5.dex */
public enum EmptySubscription implements d<Object> {
    INSTANCE;

    @Override // org.a.d
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // org.a.d
    public void cancel() {
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public static void error(Throwable th, c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    public static void complete(c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    @Override // io.reactivex.internal.a.g
    public Object poll() {
        return null;
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.a.g
    public void clear() {
    }

    @Override // io.reactivex.internal.a.c
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
