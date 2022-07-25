package com.kwad.sdk.service.kwai;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public interface d {
    boolean G(AdTemplate adTemplate);

    String getApiVersion();

    int getApiVersionCode();

    String getAppId();

    String getAppName();

    Context getContext();

    boolean getIsExternal();

    String getSDKVersion();

    SdkConfig getSdkConfig();

    boolean isDebugLogEnable();

    boolean isPersonalRecommend();

    boolean isProgrammaticRecommend();

    com.kwad.sdk.core.response.a.e lw();
}
