package io.reactivex.internal.disposables;

import f.b.i;
import f.b.o;
import f.b.r;
import f.b.x.c.b;
/* loaded from: classes7.dex */
public enum EmptyDisposable implements b<Object> {
    INSTANCE,
    NEVER;

    public static void complete(o<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onComplete();
    }

    public static void error(Throwable th, o<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onError(th);
    }

    @Override // f.b.x.c.f
    public void clear() {
    }

    @Override // f.b.t.b
    public void dispose() {
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this == INSTANCE;
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
    public Object poll() throws Exception {
        return null;
    }

    @Override // f.b.x.c.c
    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(i<?> iVar) {
        iVar.onSubscribe(INSTANCE);
        iVar.onComplete();
    }

    public static void error(Throwable th, f.b.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    public static void complete(f.b.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th, r<?> rVar) {
        rVar.onSubscribe(INSTANCE);
        rVar.onError(th);
    }

    public static void error(Throwable th, i<?> iVar) {
        iVar.onSubscribe(INSTANCE);
        iVar.onError(th);
    }
}
