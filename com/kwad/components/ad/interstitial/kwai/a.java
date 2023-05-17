package com.kwad.components.ad.interstitial.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.j;
/* loaded from: classes9.dex */
public final class a {
    public static j fJ = new j("interstitialAdSkipCloseType", 0);
    public static j fK = new j("interstitialAdSkipCloseArea", 0);
    public static j fL = new j("interstitialAdFullClick", 1);
    public static j fM = new j("interstitialAdBackPressSwitch", 0);
    public static j fN = new j("interstitialPlayableTime", 999);
    public static j fO = new j("interstitialAdClickShutDown", 0);
    public static d fP = new d("interstitialAutoStartSwitch", false);
    public static j fQ = new j("ecInterstitialAdOrderSwitch", 0);
    public static j fR = new j("interstitialCycleAggregateMaxCount", 3);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
