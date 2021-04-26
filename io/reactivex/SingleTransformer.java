package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes7.dex */
public interface SingleTransformer<Upstream, Downstream> {
    @NonNull
    SingleSource<Downstream> apply(@NonNull Single<Upstream> single);
}
