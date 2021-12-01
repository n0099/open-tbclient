package com.google.common.util.concurrent;
/* loaded from: classes2.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
