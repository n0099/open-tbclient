package com.google.common.util.concurrent;
/* loaded from: classes6.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
