package io.reactivex;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;
@Experimental
/* loaded from: classes2.dex */
public interface CompletableConverter<R> {
    @NonNull
    R apply(@NonNull Completable completable);
}
