package com.kwad.sdk.core.c.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.AvatarGuiderConfigItem;
import com.kwad.sdk.core.config.item.InsertScreenConfigItem;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.g.a.h;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.report.ReportAction;
import com.kwad.sdk.core.report.a;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AggregatePageEntranceInfo;
import com.kwad.sdk.core.response.model.HotspotInfo;
import com.kwad.sdk.core.response.model.HotspotListData;
import com.kwad.sdk.core.response.model.NewsInfo;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.PhotoShareInfo;
import com.kwad.sdk.core.response.model.PreloadData;
import com.kwad.sdk.core.response.model.ReportInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TabInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.g;
import com.kwad.sdk.core.webview.jshandler.k;
import com.kwad.sdk.core.webview.jshandler.l;
import com.kwad.sdk.core.webview.jshandler.n;
import com.kwad.sdk.core.webview.jshandler.r;
import com.kwad.sdk.core.webview.jshandler.t;
import com.kwad.sdk.home.download.HomeApkBannerData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class be {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> f64302a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-50380567, "Lcom/kwad/sdk/core/c/a/be;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-50380567, "Lcom/kwad/sdk/core/c/a/be;");
                return;
            }
        }
        HashMap hashMap = new HashMap(100);
        f64302a = hashMap;
        hashMap.put(h.a.class, new ax());
        f64302a.put(com.kwad.sdk.core.response.model.a.class, new an());
        f64302a.put(n.a.class, new s());
        f64302a.put(PhotoInfo.WallpaperInfo.class, new cv());
        f64302a.put(AdInfo.AdSplashInfo.class, new l());
        f64302a.put(AdStyleInfo.AdBrowseInfo.class, new g());
        f64302a.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new bn());
        f64302a.put(NewsInfo.class, new bl());
        f64302a.put(com.kwad.sdk.collector.a.e.class, new cc());
        f64302a.put(SceneImpl.class, new cb());
        f64302a.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new aj());
        f64302a.put(AdStyleInfo.PlayEndInfo.class, new bt());
        f64302a.put(com.kwad.sdk.core.webview.b.a.d.class, new ce());
        f64302a.put(n.a.class, new ab());
        f64302a.put(AvatarGuiderConfigItem.AvatarGuiderConfig.class, new w());
        f64302a.put(DownloadParams.class, new ak());
        f64302a.put(AdInfo.PlayableStyleInfo.class, new bu());
        f64302a.put(TabInfo.class, new ci());
        f64302a.put(PhotoInfo.VideoInfo.class, new cq());
        f64302a.put(SplashPreloadManager.PreLoadPara.class, new bx());
        f64302a.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new b());
        f64302a.put(com.kwad.sdk.core.g.a.k.class, new ch());
        f64302a.put(AdStyleInfo.FeedAdInfo.class, new aq());
        f64302a.put(ReportAction.a.class, new aa());
        f64302a.put(com.kwad.sdk.core.webview.b.a.c.class, new bs());
        f64302a.put(URLPackage.class, new cm());
        f64302a.put(AdInfo.AdAggregateInfo.class, new e());
        f64302a.put(a.C1910a.class, new ap());
        f64302a.put(l.a.class, new bb());
        f64302a.put(ReportAction.LiveLogInfo.class, new bg());
        f64302a.put(h.a.class, new u());
        f64302a.put(AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo.class, new au());
        f64302a.put(PhotoInfo.CoverInfo.class, new af());
        f64302a.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new am());
        f64302a.put(com.kwad.sdk.core.webview.b.a.a.class, new ac());
        f64302a.put(a.C1916a.class, new c());
        f64302a.put(HotspotInfo.class, new av());
        f64302a.put(HotspotListData.class, new aw());
        f64302a.put(NewsInfo.ImageInfo.class, new ay());
        f64302a.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new ai());
        f64302a.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new ah());
        f64302a.put(n.b.class, new t());
        f64302a.put(com.kwad.sdk.core.webview.b.a.f.class, new ct());
        f64302a.put(PhotoInfo.class, new bq());
        f64302a.put(AggregatePageEntranceInfo.class, new r());
        f64302a.put(PhotoInfo.BaseInfo.class, new y());
        f64302a.put(r.a.class, new cu());
        f64302a.put(AdInfo.AdvertiserInfo.class, new q());
        f64302a.put(SplashPreloadManager.PreLoadItem.class, new bw());
        f64302a.put(SdkConfigData.TemplateConfigMap.class, new ck());
        f64302a.put(PhotoComment.class, new bp());
        f64302a.put(com.kwad.sdk.core.g.a.g.class, new bh());
        f64302a.put(ActivityInfo.class, new d());
        f64302a.put(PhotoShareInfo.ShareUrlInfo.class, new cd());
        f64302a.put(PhotoInfo.PhotoAd.class, new bo());
        f64302a.put(l.b.class, new bc());
        f64302a.put(InsertScreenConfigItem.InsertScreenConfig.class, new az());
        f64302a.put(PhotoInfo.AuthorInfo.class, new v());
        f64302a.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new p());
        f64302a.put(AdInfo.AdBaseInfo.class, new f());
        f64302a.put(PreloadData.class, new by());
        f64302a.put(AdInfo.AdTrackInfo.class, new o());
        f64302a.put(AdStyleInfo.BannerAdInfo.class, new x());
        f64302a.put(com.kwad.sdk.core.webview.b.a.b.class, new bk());
        f64302a.put(AdInfo.MaterialSize.class, new bj());
        f64302a.put(com.kwad.sdk.core.g.a.c.class, new z());
        f64302a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new ba());
        f64302a.put(AppStatusRules.UploadConfig.class, new cn());
        f64302a.put(SdkConfigData.TemplateConfig.class, new cj());
        f64302a.put(VideoPlayerStatus.class, new cr());
        f64302a.put(SdkConfigData.CouponActiveConfig.class, new ad());
        f64302a.put(ReportAction.class, new bz());
        f64302a.put(g.a.class, new co());
        f64302a.put(AdStyleInfo.PlayDetailInfo.class, new br());
        f64302a.put(com.kwad.sdk.collector.a.f.class, new cf());
        f64302a.put(com.kwad.sdk.core.response.model.b.class, new bv());
        f64302a.put(LiveInfo.User.class, new cp());
        f64302a.put(AdInfo.AdConversionInfo.class, new h());
        f64302a.put(AdInfo.AdPreloadInfo.class, new k());
        f64302a.put(AdInfo.DownloadSafeInfo.class, new al());
        f64302a.put(LiveInfo.class, new bf());
        f64302a.put(AdStyleInfo.class, new m());
        f64302a.put(com.kwad.sdk.collector.a.d.class, new ao());
        f64302a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new bi());
        f64302a.put(LiveInfo.CoverThumbnailUrl.class, new ag());
        f64302a.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new cw());
        f64302a.put(AdTemplate.class, new n());
        f64302a.put(WebCardVideoPositionHandler.VideoPosition.class, new cs());
        f64302a.put(AdInfo.class, new i());
        f64302a.put(t.a.class, new bd());
        f64302a.put(k.a.class, new ae());
        f64302a.put(com.kwad.sdk.core.webview.b.a.e.class, new cg());
        f64302a.put(AdInfo.H5Config.class, new ar());
        f64302a.put(LiveInfo.User.HeadUrl.class, new as());
        f64302a.put(AdInfo.AdMaterialInfo.class, new j());
        f64302a.put(ReportInfo.class, new ca());
        f64302a.put(PageInfo.class, new bm());
        f64302a.put(ABParams.class, new a());
        f64302a.put(HomeApkBannerData.class, new at());
        f64302a.put(PhotoInfo.TubeEpisode.class, new cl());
    }

    public static com.kwad.sdk.core.d a(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? f64302a.get(cls) : (com.kwad.sdk.core.d) invokeL.objValue;
    }
}
