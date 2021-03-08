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
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.c> f6013a = new HashMap(32);

    static {
        f6013a.put(CDNUrl.class, new j());
        f6013a.put(ProfileGuideConfigItem.ProfileGuideConfig.class, new ab());
        f6013a.put(g.a.class, new ae());
        f6013a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new u());
        f6013a.put(SplashPreloadManager.PreLoadPara.class, new aa());
        f6013a.put(EmotionPackage.class, new q());
        f6013a.put(o.a.class, new k());
        f6013a.put(AdInfo.AdBaseInfo.class, new c());
        f6013a.put(AdStyleInfo.FeedAdInfo.class, new s());
        f6013a.put(AdInfo.DownloadSafeInfo.class, new m());
        f6013a.put(l.b.class, new i());
        f6013a.put(AdInfo.MaterialSize.class, new y());
        f6013a.put(AdInfo.AdMaterialInfo.class, new e());
        f6013a.put(SdkConfigData.TemplateConfigMap.class, new ad());
        f6013a.put(p.a.class, new ag());
        f6013a.put(com.kwad.sdk.core.g.a.g.class, new w());
        f6013a.put(DownloadParams.class, new l());
        f6013a.put(a.C1127a.class, new b());
        f6013a.put(HomeApkBannerData.class, new t());
        f6013a.put(SplashPreloadManager.PreLoadItem.class, new z());
        f6013a.put(ABParams.class, new a());
        f6013a.put(WebCardVideoPositionHandler.VideoPosition.class, new af());
        f6013a.put(EmotionInfo.class, new p());
        f6013a.put(AdInfo.AdPreloadInfo.class, new f());
        f6013a.put(EmotionCode.class, new o());
        f6013a.put(b.a.class, new r());
        f6013a.put(l.a.class, new h());
        f6013a.put(AdInfo.AdConversionInfo.class, new d());
        f6013a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new x());
        f6013a.put(EmotionAuthor.class, new n());
        f6013a.put(AdInfo.AdSplashInfo.class, new g());
        f6013a.put(SdkConfigData.TemplateConfig.class, new ac());
    }

    public static <T extends com.kwad.sdk.core.response.a.a> com.kwad.sdk.core.c<T> a(T t) {
        return f6013a.get(t.getClass());
    }
}
