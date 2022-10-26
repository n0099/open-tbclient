package io.reactivex;
/* loaded from: classes8.dex */
public interface Emitter {
    void onComplete();

    void onError(Throwable th);

    void onNext(Object obj);
}
