package com.kwad.components.ad.reward.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.p;
/* loaded from: classes10.dex */
public final class a {
    public static k qs = new k("rewardSkipType", 0);
    public static k qt = new k("rewardActiveAppTaskMinSecond", 15);
    public static k qu = new k("rewardContentDetainType", 0);
    public static d qv = new d("forceGetAudioFocus", false);
    public static p qw = new p("rewardSkipTips", "");
    public static p qx = new p("fullscreenSkipTips", "");
    public static k qy = new k("ecRewardAdOrderSwitch", 0);
    public static k qz = new k("ecRewardAdFanSwitch", 0);
    public static k qA = new k("ecRewardAdKwaishopStyle", 0);
    public static k qB = new k("xdtCouponShowDuration", 3000);
    public static k qC = new k("jinniuCloseDialogStyle", 1);
    public static g qD = new g("interactionTimeInRewardedVideo", 0.0f);
    public static d qE = new d("autoJumpInRewardedVideo", false);
    public static k qF = new k("advanceJumpDirectDeliveryMaxCount", 0);
    public static d qG = new d("advanceJumpDirectDeliverySwitch", false);
    public static k qH = new k("shortVideoFollowRewardPlayStyle", 0);
    public static d qI = new d("enableRewardLayoutOptimise", false);
    public static d qJ = new d("enableFullscreenLayoutOptimise", false);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
