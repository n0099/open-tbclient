package com.sdk.base.api;
/* loaded from: classes5.dex */
public interface CallBack<T> {
    void onFailed(int i, int i2, String str, String str2);

    void onSuccess(int i, String str, int i2, T t, String str2);
}
