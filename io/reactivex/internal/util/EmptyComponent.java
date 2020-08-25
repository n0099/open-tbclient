package io.reactivex.internal.util;

import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.u;
import io.reactivex.y;
/* loaded from: classes7.dex */
public enum EmptyComponent implements io.reactivex.c, io.reactivex.disposables.b, j<Object>, m<Object>, u<Object>, y<Object>, org.b.d {
    INSTANCE;

    public static <T> org.b.c<T> asSubscriber() {
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

    @Override // org.b.d
    public void request(long j) {
    }

    @Override // org.b.d
    public void cancel() {
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        bVar.dispose();
    }

    @Override // io.reactivex.j, org.b.c
    public void onSubscribe(org.b.d dVar) {
        dVar.cancel();
    }

    @Override // org.b.c
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
