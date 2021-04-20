package io.reactivex.internal.util;

import f.b.a0.a;
import f.b.b;
import f.b.g;
import f.b.i;
import f.b.o;
import f.b.r;
import g.d.c;
import g.d.d;
/* loaded from: classes7.dex */
public enum EmptyComponent implements g<Object>, o<Object>, i<Object>, r<Object>, b, d, f.b.t.b {
    INSTANCE;

    public static <T> o<T> asObserver() {
        return INSTANCE;
    }

    public static <T> c<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // g.d.d
    public void cancel() {
    }

    @Override // f.b.t.b
    public void dispose() {
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return true;
    }

    @Override // g.d.c
    public void onComplete() {
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        a.f(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
    }

    @Override // f.b.o
    public void onSubscribe(f.b.t.b bVar) {
        bVar.dispose();
    }

    @Override // f.b.i
    public void onSuccess(Object obj) {
    }

    @Override // g.d.d
    public void request(long j) {
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        dVar.cancel();
    }
}
