package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes10.dex */
public interface CompletableTransformer {
    @NonNull
    CompletableSource apply(@NonNull Completable completable);
}
