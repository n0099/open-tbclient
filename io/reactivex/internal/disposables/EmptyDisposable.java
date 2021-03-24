package io.reactivex.internal.disposables;

import f.a.i;
import f.a.o;
import f.a.r;
import f.a.x.c.b;
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

    @Override // f.a.x.c.f
    public void clear() {
    }

    @Override // f.a.t.b
    public void dispose() {
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // f.a.x.c.f
    public boolean isEmpty() {
        return true;
    }

    @Override // f.a.x.c.f
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // f.a.x.c.f
    public Object poll() throws Exception {
        return null;
    }

    @Override // f.a.x.c.c
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

    public static void error(Throwable th, f.a.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    public static void complete(f.a.b bVar) {
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
