package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
/* loaded from: classes7.dex */
public final class e extends io.reactivex.g<Object> implements io.reactivex.internal.a.e<Object> {
    public static final io.reactivex.g<Object> mSj = new e();

    private e() {
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Object> cVar) {
        EmptySubscription.complete(cVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
