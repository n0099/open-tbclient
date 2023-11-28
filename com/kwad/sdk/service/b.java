package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.d;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class b {
    public static final Map<Class<?>, Class<?>> aMt = new HashMap();
    public static final Map<Class<?>, Class<?>> aMu = new HashMap();
    public static boolean aMv = false;
    public static boolean aMw = false;

    public static synchronized void Ji() {
        synchronized (b.class) {
            if (aMv) {
                return;
            }
            Jj();
            aMv = true;
        }
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    public static void Jj() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        com.kwad.components.core.page.a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        d.register();
        com.kwad.components.core.r.a.a.register();
        FileDownloadServiceProxy.register();
        com.kwad.sdk.collector.b.a.register();
        a.register();
    }

    public static synchronized void Jk() {
        synchronized (b.class) {
            if (aMw) {
                return;
            }
            Jl();
            aMw = true;
        }
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    public static void Jl() {
        KSAdVideoPlayConfigImpl.register();
        com.kwad.components.core.internal.api.d.register();
        VideoPlayConfigImpl.register();
        com.kwad.components.core.p.b.register();
        SceneImpl.register();
    }

    public static void init() {
        Ji();
        Jk();
    }

    public static void a(Class<?> cls, Class<?> cls2) {
        aMt.put(cls, cls2);
    }

    public static void b(Class cls, Class cls2) {
        aMu.put(cls, cls2);
    }

    public static Class<?> g(Class<?> cls) {
        Ji();
        return aMt.get(cls);
    }

    public static Class<?> h(Class<?> cls) {
        Jk();
        return aMu.get(cls);
    }
}
