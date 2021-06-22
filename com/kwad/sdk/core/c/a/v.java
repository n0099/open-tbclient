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
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.c> f34152a;

    static {
        HashMap hashMap = new HashMap(32);
        f34152a = hashMap;
        hashMap.put(CDNUrl.class, new j());
        f34152a.put(ProfileGuideConfigItem.ProfileGuideConfig.class, new ab());
        f34152a.put(g.a.class, new ae());
        f34152a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new u());
        f34152a.put(SplashPreloadManager.PreLoadPara.class, new aa());
        f34152a.put(EmotionPackage.class, new q());
        f34152a.put(o.a.class, new k());
        f34152a.put(AdInfo.AdBaseInfo.class, new c());
        f34152a.put(AdStyleInfo.FeedAdInfo.class, new s());
        f34152a.put(AdInfo.DownloadSafeInfo.class, new m());
        f34152a.put(l.b.class, new i());
        f34152a.put(AdInfo.MaterialSize.class, new y());
        f34152a.put(AdInfo.AdMaterialInfo.class, new e());
        f34152a.put(SdkConfigData.TemplateConfigMap.class, new ad());
        f34152a.put(p.a.class, new ag());
        f34152a.put(com.kwad.sdk.core.g.a.g.class, new w());
        f34152a.put(DownloadParams.class, new l());
        f34152a.put(a.C0398a.class, new b());
        f34152a.put(HomeApkBannerData.class, new t());
        f34152a.put(SplashPreloadManager.PreLoadItem.class, new z());
        f34152a.put(ABParams.class, new a());
        f34152a.put(WebCardVideoPositionHandler.VideoPosition.class, new af());
        f34152a.put(EmotionInfo.class, new p());
        f34152a.put(AdInfo.AdPreloadInfo.class, new f());
        f34152a.put(EmotionCode.class, new o());
        f34152a.put(b.a.class, new r());
        f34152a.put(l.a.class, new h());
        f34152a.put(AdInfo.AdConversionInfo.class, new d());
        f34152a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new x());
        f34152a.put(EmotionAuthor.class, new n());
        f34152a.put(AdInfo.AdSplashInfo.class, new g());
        f34152a.put(SdkConfigData.TemplateConfig.class, new ac());
    }

    public static <T extends com.kwad.sdk.core.response.a.a> com.kwad.sdk.core.c<T> a(T t) {
        return f34152a.get(t.getClass());
    }
}
