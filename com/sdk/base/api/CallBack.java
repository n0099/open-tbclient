package com.sdk.base.api;
/* loaded from: classes6.dex */
public interface CallBack<T> {
    void onFailed(int i2, int i3, String str, String str2);

    void onSuccess(int i2, String str, int i3, T t, String str2);
}
