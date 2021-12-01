package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes3.dex */
public interface MaybeOnSubscribe<T> {
    void subscribe(@NonNull MaybeEmitter<T> maybeEmitter) throws Exception;
}
