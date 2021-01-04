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
/* loaded from: classes5.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.c> f9341a = new HashMap(32);

    static {
        f9341a.put(CDNUrl.class, new j());
        f9341a.put(ProfileGuideConfigItem.ProfileGuideConfig.class, new ab());
        f9341a.put(g.a.class, new ae());
        f9341a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new u());
        f9341a.put(SplashPreloadManager.PreLoadPara.class, new aa());
        f9341a.put(EmotionPackage.class, new q());
        f9341a.put(o.a.class, new k());
        f9341a.put(AdInfo.AdBaseInfo.class, new c());
        f9341a.put(AdStyleInfo.FeedAdInfo.class, new s());
        f9341a.put(AdInfo.DownloadSafeInfo.class, new m());
        f9341a.put(l.b.class, new i());
        f9341a.put(AdInfo.MaterialSize.class, new y());
        f9341a.put(AdInfo.AdMaterialInfo.class, new e());
        f9341a.put(SdkConfigData.TemplateConfigMap.class, new ad());
        f9341a.put(p.a.class, new ag());
        f9341a.put(com.kwad.sdk.core.g.a.g.class, new w());
        f9341a.put(DownloadParams.class, new l());
        f9341a.put(a.C1080a.class, new b());
        f9341a.put(HomeApkBannerData.class, new t());
        f9341a.put(SplashPreloadManager.PreLoadItem.class, new z());
        f9341a.put(ABParams.class, new a());
        f9341a.put(WebCardVideoPositionHandler.VideoPosition.class, new af());
        f9341a.put(EmotionInfo.class, new p());
        f9341a.put(AdInfo.AdPreloadInfo.class, new f());
        f9341a.put(EmotionCode.class, new o());
        f9341a.put(b.a.class, new r());
        f9341a.put(l.a.class, new h());
        f9341a.put(AdInfo.AdConversionInfo.class, new d());
        f9341a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new x());
        f9341a.put(EmotionAuthor.class, new n());
        f9341a.put(AdInfo.AdSplashInfo.class, new g());
        f9341a.put(SdkConfigData.TemplateConfig.class, new ac());
    }

    public static <T extends com.kwad.sdk.core.response.a.a> com.kwad.sdk.core.c<T> a(T t) {
        return f9341a.get(t.getClass());
    }
}
