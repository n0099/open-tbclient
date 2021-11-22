package com.google.common.util.concurrent;
/* loaded from: classes11.dex */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
