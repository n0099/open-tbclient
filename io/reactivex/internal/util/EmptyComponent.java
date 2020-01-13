package io.reactivex.internal.util;

import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.u;
import io.reactivex.y;
/* loaded from: classes5.dex */
public enum EmptyComponent implements io.reactivex.c, io.reactivex.disposables.b, j<Object>, m<Object>, u<Object>, y<Object>, org.a.d {
    INSTANCE;

    public static <T> org.a.c<T> asSubscriber() {
        return INSTANCE;
    }

    public static <T> u<T> asObserver() {
        return INSTANCE;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return true;
    }

    @Override // org.a.d
    public void request(long j) {
    }

    @Override // org.a.d
    public void cancel() {
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        bVar.dispose();
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(org.a.d dVar) {
        dVar.cancel();
    }

    @Override // org.a.c
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        io.reactivex.e.a.onError(th);
    }

    @Override // io.reactivex.c
    public void onComplete() {
    }

    @Override // io.reactivex.m
    public void onSuccess(Object obj) {
    }
}
