package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes2.dex */
public interface CompletableTransformer {
    @NonNull
    CompletableSource apply(@NonNull Completable completable);
}
