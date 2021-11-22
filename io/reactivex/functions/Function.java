package io.reactivex.functions;

import io.reactivex.annotations.NonNull;
/* loaded from: classes2.dex */
public interface Function<T, R> {
    R apply(@NonNull T t) throws Exception;
}
