package com.kwad.sdk.components;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes7.dex */
public interface a {
    Class getComponentsType();

    void init(Context context, SdkConfig sdkConfig);

    int priority();
}
