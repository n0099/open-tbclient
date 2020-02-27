package com.kascend.cstvsdk.interfaces;

import android.support.annotation.Keep;
import kotlin.h;
@Keep
@h
/* loaded from: classes5.dex */
public interface Callback<T> {
    void onFailure(int i, String str, Object obj);

    void onStart();

    void onSuccess(T t);
}
