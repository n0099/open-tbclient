package com.google.common.util.concurrent;
/* loaded from: classes2.dex */
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(I i2) throws Exception;
}
