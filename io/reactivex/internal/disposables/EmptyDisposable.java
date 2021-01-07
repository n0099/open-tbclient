package io.reactivex.internal.disposables;

import io.reactivex.m;
import io.reactivex.u;
import io.reactivex.y;
/* loaded from: classes5.dex */
public enum EmptyDisposable implements io.reactivex.internal.a.b<Object> {
    INSTANCE,
    NEVER;

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    public static void complete(u<?> uVar) {
        uVar.onSubscribe(INSTANCE);
        uVar.onComplete();
    }

    public static void complete(m<?> mVar) {
        mVar.onSubscribe(INSTANCE);
        mVar.onComplete();
    }

    public static void error(Throwable th, u<?> uVar) {
        uVar.onSubscribe(INSTANCE);
        uVar.onError(th);
    }

    public static void complete(io.reactivex.c cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th, io.reactivex.c cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    public static void error(Throwable th, y<?> yVar) {
        yVar.onSubscribe(INSTANCE);
        yVar.onError(th);
    }

    public static void error(Throwable th, m<?> mVar) {
        mVar.onSubscribe(INSTANCE);
        mVar.onError(th);
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.a.f
    public Object poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
    }

    @Override // io.reactivex.internal.a.c
    public int requestFusion(int i) {
        return i & 2;
    }
}
