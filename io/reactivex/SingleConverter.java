package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
@Experimental
/* loaded from: classes10.dex */
public interface SingleConverter<T, R> {
    @NonNull
    R apply(@NonNull Single<T> single);
}
