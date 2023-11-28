package com.kwad.sdk.service.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes10.dex */
public interface f {
    boolean aF(AdTemplate adTemplate);

    String getApiVersion();

    int getApiVersionCode();

    String getAppId();

    String getAppName();

    Context getContext();

    boolean getIsExternal();

    String getSDKVersion();

    boolean hasInitFinish();

    boolean isPersonalRecommend();

    boolean isProgrammaticRecommend();

    boolean oA();

    com.kwad.sdk.core.response.b.g tt();

    String yh();

    com.kwad.sdk.core.b yi();

    List<AdTemplate> yj();
}
