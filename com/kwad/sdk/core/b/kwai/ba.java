package com.kwad.sdk.core.b.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.m;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
/* loaded from: classes5.dex */
public final class ba {
    @InvokeBy(invokerClass = cz.class, methodId = "registerHolder")
    public static void a() {
        cz.a().put(RewardMonitorInfo.class, new ei());
        cz.a().put(com.kwad.components.ad.reward.model.b.class, new al());
        cz.a().put(m.c.class, new av());
    }
}
