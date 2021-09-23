package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes10.dex */
public interface MaybeOnSubscribe<T> {
    void subscribe(@NonNull MaybeEmitter<T> maybeEmitter) throws Exception;
}
