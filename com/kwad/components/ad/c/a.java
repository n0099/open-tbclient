package com.kwad.components.ad.c;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.config.item.o;
/* loaded from: classes10.dex */
public final class a {
    public static o aF = new o("kwaiLogoUrl", null);
    public static o aG = new o("attentionTips", "去关注TA");
    public static o aH = new o("viewHomeTips", "查看TA的主页");
    public static o aI = new o("buyNowTips", "立即抢购");

    @InvokeBy(invokerClass = d.class, methodId = "initConfigList")
    public static void init() {
    }
}
