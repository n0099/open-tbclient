package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes9.dex */
public interface CompletableTransformer {
    @NonNull
    CompletableSource apply(@NonNull Completable completable);
}
