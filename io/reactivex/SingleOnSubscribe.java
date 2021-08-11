package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes10.dex */
public interface SingleOnSubscribe<T> {
    void subscribe(@NonNull SingleEmitter<T> singleEmitter) throws Exception;
}
