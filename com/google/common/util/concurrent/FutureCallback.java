package com.google.common.util.concurrent;
/* loaded from: classes11.dex */
public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(V v);
}
