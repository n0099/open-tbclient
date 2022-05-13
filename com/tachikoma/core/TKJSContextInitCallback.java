package com.tachikoma.core;

import com.tachikoma.core.bridge.TKJSContext;
/* loaded from: classes7.dex */
public interface TKJSContextInitCallback {
    void onError(String str);

    void onSuccess(TKJSContext tKJSContext);
}
