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
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.c> f33433a;

    static {
        HashMap hashMap = new HashMap(32);
        f33433a = hashMap;
        hashMap.put(CDNUrl.class, new j());
        f33433a.put(ProfileGuideConfigItem.ProfileGuideConfig.class, new ab());
        f33433a.put(g.a.class, new ae());
        f33433a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new u());
        f33433a.put(SplashPreloadManager.PreLoadPara.class, new aa());
        f33433a.put(EmotionPackage.class, new q());
        f33433a.put(o.a.class, new k());
        f33433a.put(AdInfo.AdBaseInfo.class, new c());
        f33433a.put(AdStyleInfo.FeedAdInfo.class, new s());
        f33433a.put(AdInfo.DownloadSafeInfo.class, new m());
        f33433a.put(l.b.class, new i());
        f33433a.put(AdInfo.MaterialSize.class, new y());
        f33433a.put(AdInfo.AdMaterialInfo.class, new e());
        f33433a.put(SdkConfigData.TemplateConfigMap.class, new ad());
        f33433a.put(p.a.class, new ag());
        f33433a.put(com.kwad.sdk.core.g.a.g.class, new w());
        f33433a.put(DownloadParams.class, new l());
        f33433a.put(a.C0394a.class, new b());
        f33433a.put(HomeApkBannerData.class, new t());
        f33433a.put(SplashPreloadManager.PreLoadItem.class, new z());
        f33433a.put(ABParams.class, new a());
        f33433a.put(WebCardVideoPositionHandler.VideoPosition.class, new af());
        f33433a.put(EmotionInfo.class, new p());
        f33433a.put(AdInfo.AdPreloadInfo.class, new f());
        f33433a.put(EmotionCode.class, new o());
        f33433a.put(b.a.class, new r());
        f33433a.put(l.a.class, new h());
        f33433a.put(AdInfo.AdConversionInfo.class, new d());
        f33433a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new x());
        f33433a.put(EmotionAuthor.class, new n());
        f33433a.put(AdInfo.AdSplashInfo.class, new g());
        f33433a.put(SdkConfigData.TemplateConfig.class, new ac());
    }

    public static <T extends com.kwad.sdk.core.response.a.a> com.kwad.sdk.core.c<T> a(T t) {
        return f33433a.get(t.getClass());
    }
}
