package com.kwad.sdk.core.b.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.ad.splashscreen.preload.SplashPreloadManager;
/* loaded from: classes5.dex */
public final class bb {
    @InvokeBy(invokerClass = cz.class, methodId = "registerHolder")
    public static void a() {
        cz.a().put(SplashPreloadManager.PreLoadPara.class, new ef());
        cz.a().put(com.kwad.components.ad.splashscreen.local.c.class, new ez());
        cz.a().put(SplashMonitorInfo.class, new fa());
        cz.a().put(SplashPreloadManager.PreLoadItem.class, new ee());
        cz.a().put(com.kwad.components.ad.splashscreen.local.a.class, new ey());
        cz.a().put(SplashSkipViewModel.class, new fb());
    }
}
