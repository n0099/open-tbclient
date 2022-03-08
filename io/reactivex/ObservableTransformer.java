package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes8.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    @NonNull
    ObservableSource<Downstream> apply(@NonNull Observable<Upstream> observable);
}
