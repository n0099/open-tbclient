package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
/* loaded from: classes10.dex */
public final class dx {
    @InvokeBy(invokerClass = fr.class, methodId = "registerHolder")
    public static void Cp() {
        fr.Cq().put(com.kwad.sdk.crash.model.b.class, new dl());
        fr.Cq().put(BlockEvent.a.class, new kb());
        fr.Cq().put(BlockEvent.class, new bp());
        fr.Cq().put(com.kwad.sdk.crash.online.monitor.a.a.class, new bo());
        fr.Cq().put(com.kwad.sdk.crash.online.monitor.a.c.class, new gk());
        fr.Cq().put(AnrReason.class, new ay());
        fr.Cq().put(com.kwad.sdk.crash.online.monitor.block.d.class, new bq());
        fr.Cq().put(com.kwad.sdk.crash.online.monitor.a.b.class, new dp());
        fr.Cq().put(com.kwad.sdk.crash.a.class, new cp());
    }
}
