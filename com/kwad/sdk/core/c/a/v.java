package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.ProfileGuideConfigItem;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.g;
import com.kwad.sdk.core.webview.jshandler.l;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.emotion.model.CDNUrl;
import com.kwad.sdk.emotion.model.EmotionAuthor;
import com.kwad.sdk.emotion.model.EmotionCode;
import com.kwad.sdk.emotion.model.EmotionInfo;
import com.kwad.sdk.emotion.model.EmotionPackage;
import com.kwad.sdk.home.download.HomeApkBannerData;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.c> f34054a;

    static {
        HashMap hashMap = new HashMap(32);
        f34054a = hashMap;
        hashMap.put(CDNUrl.class, new j());
        f34054a.put(ProfileGuideConfigItem.ProfileGuideConfig.class, new ab());
        f34054a.put(g.a.class, new ae());
        f34054a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new u());
        f34054a.put(SplashPreloadManager.PreLoadPara.class, new aa());
        f34054a.put(EmotionPackage.class, new q());
        f34054a.put(o.a.class, new k());
        f34054a.put(AdInfo.AdBaseInfo.class, new c());
        f34054a.put(AdStyleInfo.FeedAdInfo.class, new s());
        f34054a.put(AdInfo.DownloadSafeInfo.class, new m());
        f34054a.put(l.b.class, new i());
        f34054a.put(AdInfo.MaterialSize.class, new y());
        f34054a.put(AdInfo.AdMaterialInfo.class, new e());
        f34054a.put(SdkConfigData.TemplateConfigMap.class, new ad());
        f34054a.put(p.a.class, new ag());
        f34054a.put(com.kwad.sdk.core.g.a.g.class, new w());
        f34054a.put(DownloadParams.class, new l());
        f34054a.put(a.C0395a.class, new b());
        f34054a.put(HomeApkBannerData.class, new t());
        f34054a.put(SplashPreloadManager.PreLoadItem.class, new z());
        f34054a.put(ABParams.class, new a());
        f34054a.put(WebCardVideoPositionHandler.VideoPosition.class, new af());
        f34054a.put(EmotionInfo.class, new p());
        f34054a.put(AdInfo.AdPreloadInfo.class, new f());
        f34054a.put(EmotionCode.class, new o());
        f34054a.put(b.a.class, new r());
        f34054a.put(l.a.class, new h());
        f34054a.put(AdInfo.AdConversionInfo.class, new d());
        f34054a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new x());
        f34054a.put(EmotionAuthor.class, new n());
        f34054a.put(AdInfo.AdSplashInfo.class, new g());
        f34054a.put(SdkConfigData.TemplateConfig.class, new ac());
    }

    public static <T extends com.kwad.sdk.core.response.a.a> com.kwad.sdk.core.c<T> a(T t) {
        return f34054a.get(t.getClass());
    }
}
