package com.kascend.cstvsdk.interfaces;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes4.dex */
public interface Callback<T> {
    void onFailure(int i, String str, Object obj);

    void onStart();

    void onSuccess(T t);
}
