package com.kascend.cstvsdk.interfaces;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes4.dex */
public interface SimpleCallback {
    void onFailure(int i, String str, Object obj);

    void onStart();

    void onSuccess();
}
