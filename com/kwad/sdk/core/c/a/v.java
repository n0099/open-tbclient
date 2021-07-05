package com.kwad.sdk.core.c.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
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
/* loaded from: classes7.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.c> f35915a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-555813932, "Lcom/kwad/sdk/core/c/a/v;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-555813932, "Lcom/kwad/sdk/core/c/a/v;");
                return;
            }
        }
        HashMap hashMap = new HashMap(32);
        f35915a = hashMap;
        hashMap.put(CDNUrl.class, new j());
        f35915a.put(ProfileGuideConfigItem.ProfileGuideConfig.class, new ab());
        f35915a.put(g.a.class, new ae());
        f35915a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new u());
        f35915a.put(SplashPreloadManager.PreLoadPara.class, new aa());
        f35915a.put(EmotionPackage.class, new q());
        f35915a.put(o.a.class, new k());
        f35915a.put(AdInfo.AdBaseInfo.class, new c());
        f35915a.put(AdStyleInfo.FeedAdInfo.class, new s());
        f35915a.put(AdInfo.DownloadSafeInfo.class, new m());
        f35915a.put(l.b.class, new i());
        f35915a.put(AdInfo.MaterialSize.class, new y());
        f35915a.put(AdInfo.AdMaterialInfo.class, new e());
        f35915a.put(SdkConfigData.TemplateConfigMap.class, new ad());
        f35915a.put(p.a.class, new ag());
        f35915a.put(com.kwad.sdk.core.g.a.g.class, new w());
        f35915a.put(DownloadParams.class, new l());
        f35915a.put(a.C0442a.class, new b());
        f35915a.put(HomeApkBannerData.class, new t());
        f35915a.put(SplashPreloadManager.PreLoadItem.class, new z());
        f35915a.put(ABParams.class, new a());
        f35915a.put(WebCardVideoPositionHandler.VideoPosition.class, new af());
        f35915a.put(EmotionInfo.class, new p());
        f35915a.put(AdInfo.AdPreloadInfo.class, new f());
        f35915a.put(EmotionCode.class, new o());
        f35915a.put(b.a.class, new r());
        f35915a.put(l.a.class, new h());
        f35915a.put(AdInfo.AdConversionInfo.class, new d());
        f35915a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new x());
        f35915a.put(EmotionAuthor.class, new n());
        f35915a.put(AdInfo.AdSplashInfo.class, new g());
        f35915a.put(SdkConfigData.TemplateConfig.class, new ac());
    }

    public static <T extends com.kwad.sdk.core.response.a.a> com.kwad.sdk.core.c<T> a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, t)) == null) ? f35915a.get(t.getClass()) : (com.kwad.sdk.core.c) invokeL.objValue;
    }
}
