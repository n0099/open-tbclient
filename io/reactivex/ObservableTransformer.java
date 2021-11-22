package io.reactivex;

import io.reactivex.annotations.NonNull;
/* loaded from: classes2.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    @NonNull
    ObservableSource<Downstream> apply(@NonNull Observable<Upstream> observable);
}
