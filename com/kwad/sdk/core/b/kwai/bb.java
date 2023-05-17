package com.kwad.sdk.core.b.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.b.e;
import com.kwad.components.ad.reward.l;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.components.ad.reward.monitor.RewardWebViewInfo;
/* loaded from: classes9.dex */
public final class bb {
    @InvokeBy(invokerClass = dd.class, methodId = "registerHolder")
    public static void tl() {
        dd.tm().put(com.kwad.components.ad.reward.e.b.class, new eo());
        dd.tm().put(RewardMonitorInfo.class, new ep());
        dd.tm().put(RewardWebViewInfo.class, new eq());
        dd.tm().put(e.a.class, new by());
        dd.tm().put(com.kwad.components.ad.reward.b.b.class, new df());
        dd.tm().put(com.kwad.components.ad.reward.model.b.class, new al());
        dd.tm().put(l.c.class, new aw());
    }
}
