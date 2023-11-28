package com.kwad.components.ad.splashscreen.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.p;
/* loaded from: classes10.dex */
public final class a {
    public static k CL = new k("splashTimeOutMilliSecond", 5000);
    public static p CM = new p("splashTimerTips", "");
    public static p CN = new p("splashBtnText", "点击跳转详情页或第三方应用");
    public static d CO = new d("splashCropNewSwitch", true);
    public static d CP = new d("splashAdLoadProcessChange", false);
    public static k CQ = new k("splashMaterialDownloadTimeMs", 500);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
