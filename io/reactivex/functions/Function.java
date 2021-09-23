package io.reactivex.functions;

import io.reactivex.annotations.NonNull;
/* loaded from: classes10.dex */
public interface Function<T, R> {
    R apply(@NonNull T t) throws Exception;
}
