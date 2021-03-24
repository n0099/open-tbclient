package io.reactivex.internal.util;

import f.a.a0.a;
import f.a.b;
import f.a.g;
import f.a.i;
import f.a.o;
import f.a.r;
import g.d.c;
import g.d.d;
/* loaded from: classes7.dex */
public enum EmptyComponent implements g<Object>, o<Object>, i<Object>, r<Object>, b, d, f.a.t.b {
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

    @Override // f.a.t.b
    public void dispose() {
    }

    @Override // f.a.t.b
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

    @Override // f.a.o
    public void onSubscribe(f.a.t.b bVar) {
        bVar.dispose();
    }

    @Override // f.a.i
    public void onSuccess(Object obj) {
    }

    @Override // g.d.d
    public void request(long j) {
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        dVar.cancel();
    }
}
