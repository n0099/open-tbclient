package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes8.dex */
public interface CompletableTransformer {
    @NonNull
    CompletableSource apply(@NonNull Completable completable);
}
