package com.kwad.sdk.export.proxy;

import android.content.Context;
import android.os.Bundle;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public interface AdJumpProxy {
    boolean handleAdWebViewJump(Context context, String str, AdTemplate adTemplate, Bundle bundle);

    boolean handleUserInfoJump(Context context, AdInfo.AdvertiserInfo advertiserInfo, Bundle bundle);
}
