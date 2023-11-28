package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.feed.monitor.FeedErrorInfo;
import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.ad.feed.monitor.FeedWebViewInfo;
/* loaded from: classes10.dex */
public final class ce {
    @InvokeBy(invokerClass = fr.class, methodId = "registerHolder")
    public static void Cp() {
        fr.Cq().put(FeedPageInfo.a.class, new ge());
        fr.Cq().put(FeedWebViewInfo.class, new dv());
        fr.Cq().put(FeedPageInfo.class, new dt());
        fr.Cq().put(FeedErrorInfo.class, new dr());
    }
}
