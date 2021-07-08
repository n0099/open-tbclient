package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes9.dex */
public interface MaybeSource<T> {
    void subscribe(@NonNull MaybeObserver<? super T> maybeObserver);
}
