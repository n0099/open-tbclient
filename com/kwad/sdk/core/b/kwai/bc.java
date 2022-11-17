package com.kwad.sdk.core.b.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
/* loaded from: classes8.dex */
public final class bc {
    @InvokeBy(invokerClass = dd.class, methodId = "registerHolder")
    public static void tl() {
        dd.tm().put(SplashSkipViewModel.class, new fj());
        dd.tm().put(com.kwad.components.ad.splashscreen.local.a.class, new fg());
        dd.tm().put(com.kwad.components.ad.splashscreen.local.c.class, new fh());
    }
}
