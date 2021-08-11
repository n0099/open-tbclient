package com.google.common.util.concurrent;
/* loaded from: classes10.dex */
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(I i2) throws Exception;
}
