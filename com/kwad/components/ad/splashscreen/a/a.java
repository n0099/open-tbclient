package com.kwad.components.ad.splashscreen.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.config.item.o;
/* loaded from: classes9.dex */
public final class a {
    public static j yl = new j("splashTimeOutMilliSecond", 5000);
    public static j ym = new j("splashVplusEnterHomeSeconds", 0);
    public static o yn = new o("splashTimerTips", "");
    public static o yo = new o("splashBtnText", "点击跳过详情页或第三方应用");
    public static o yp = new o("splashVplusEnterHomeTips", "");
    public static j yq = new j("shakeCountDaily", 3);
    public static j yr = new j("rotateCountDaily", 3);
    public static j ys = new j("gestureCountDaily", 5);
    public static d yt = new d("splashCropSwitch", true);

    @InvokeBy(invokerClass = com.kwad.sdk.core.config.d.class, methodId = "initConfigList")
    public static void init() {
    }
}
