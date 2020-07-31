package com.kascend.cstvsdk.interfaces;

import android.support.annotation.Keep;
import kotlin.h;
@Keep
@h
/* loaded from: classes6.dex */
public interface SimpleCallback {
    void onFailure(int i, String str, Object obj);

    void onStart();

    void onSuccess();
}
