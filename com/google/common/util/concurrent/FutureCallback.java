package com.google.common.util.concurrent;
/* loaded from: classes2.dex */
public interface FutureCallback<V> {
    void onFailure(Throwable th);

    void onSuccess(V v);
}
