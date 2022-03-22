package com.fun.ad.sdk.internal.api.flavor;

import android.content.Context;
import com.fun.ad.sdk.FunAdType;
/* loaded from: classes6.dex */
public interface PluginRC {
    void init(Context context);

    RCInterceptor shouldIntercept(String str, FunAdType funAdType);
}
