package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes7.dex */
public interface ObservableOnSubscribe<T> {
    void subscribe(@NonNull ObservableEmitter<T> observableEmitter) throws Exception;
}
