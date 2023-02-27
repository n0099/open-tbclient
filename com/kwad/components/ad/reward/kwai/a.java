package com.kwad.components.ad.reward.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.config.item.o;
/* loaded from: classes8.dex */
public final class a {
    public static j nR = new j("rewardSkipType", 0);
    public static j nS = new j("rewardActiveAppTaskMinSecond", 15);
    public static j nT = new j("rewardContentDetainType", 0);
    public static d nU = new d("forceGetAudioFocus", false);
    public static o nV = new o("rewardSkipTips", "");
    public static o nW = new o("fullscreenSkipTips", "");
    public static j nX = new j("ecRewardAdOrderSwitch", 0);
    public static j nY = new j("ecRewardAdFanSwitch", 0);
    public static j nZ = new j("ecRewardAdKwaishopStyle", 0);
    public static j oa = new j("xdtCouponShowDuration", 3000);
    public static j ob = new j("jinniuCloseDialogStyle", 1);
    public static f oc = new f("interactionTimeInRewardedVideo", 0.0f);
    public static d od = new d("autoJumpInRewardedVideo", false);
    public static j oe = new j("advanceJumpDirectDeliveryMaxCount", 0);
    public static d of = new d("rewardReflowPageShowSwitch", false);
    public static d og = new d("advanceJumpDirectDeliverySwitch", false);
    public static j oh = new j("shortVideoFollowRewardPlayStyle", 0);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
