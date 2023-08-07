package com.kwad.components.ad.fullscreen.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.j;
/* loaded from: classes10.dex */
public final class a {
    public static j ej = new j("fullscreenSkipType", 0);
    public static j ek = new j("fullscreenSkipShowTime", 5);
    public static j el = new j("fullScreenShakeMaxCount", 0);

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
