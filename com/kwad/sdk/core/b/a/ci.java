package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;
/* loaded from: classes10.dex */
public final class ci {
    @InvokeBy(invokerClass = fr.class, methodId = "registerHolder")
    public static void Cp() {
        fr.Cq().put(com.kwad.components.ad.splashscreen.local.a.class, new ja());
        fr.Cq().put(SplashWebMonitorInfo.class, new ji());
        fr.Cq().put(SplashMonitorInfo.class, new jb());
        fr.Cq().put(SplashPreloadManager.PreLoadItem.class, new ht());
        fr.Cq().put(SplashSkipViewModel.class, new jf());
    }
}
