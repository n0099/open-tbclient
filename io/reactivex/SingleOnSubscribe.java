package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes9.dex */
public interface SingleOnSubscribe<T> {
    void subscribe(@NonNull SingleEmitter<T> singleEmitter) throws Exception;
}
