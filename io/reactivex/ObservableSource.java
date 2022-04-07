package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes8.dex */
public interface ObservableSource<T> {
    void subscribe(@NonNull Observer<? super T> observer);
}
