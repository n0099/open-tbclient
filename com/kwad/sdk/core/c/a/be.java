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
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> f65215a;
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
        f65215a = hashMap;
        hashMap.put(h.a.class, new ax());
        f65215a.put(com.kwad.sdk.core.response.model.a.class, new an());
        f65215a.put(n.a.class, new s());
        f65215a.put(PhotoInfo.WallpaperInfo.class, new cv());
        f65215a.put(AdInfo.AdSplashInfo.class, new l());
        f65215a.put(AdStyleInfo.AdBrowseInfo.class, new g());
        f65215a.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new bn());
        f65215a.put(NewsInfo.class, new bl());
        f65215a.put(com.kwad.sdk.collector.a.e.class, new cc());
        f65215a.put(SceneImpl.class, new cb());
        f65215a.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new aj());
        f65215a.put(AdStyleInfo.PlayEndInfo.class, new bt());
        f65215a.put(com.kwad.sdk.core.webview.b.a.d.class, new ce());
        f65215a.put(n.a.class, new ab());
        f65215a.put(AvatarGuiderConfigItem.AvatarGuiderConfig.class, new w());
        f65215a.put(DownloadParams.class, new ak());
        f65215a.put(AdInfo.PlayableStyleInfo.class, new bu());
        f65215a.put(TabInfo.class, new ci());
        f65215a.put(PhotoInfo.VideoInfo.class, new cq());
        f65215a.put(SplashPreloadManager.PreLoadPara.class, new bx());
        f65215a.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new b());
        f65215a.put(com.kwad.sdk.core.g.a.k.class, new ch());
        f65215a.put(AdStyleInfo.FeedAdInfo.class, new aq());
        f65215a.put(ReportAction.a.class, new aa());
        f65215a.put(com.kwad.sdk.core.webview.b.a.c.class, new bs());
        f65215a.put(URLPackage.class, new cm());
        f65215a.put(AdInfo.AdAggregateInfo.class, new e());
        f65215a.put(a.C1950a.class, new ap());
        f65215a.put(l.a.class, new bb());
        f65215a.put(ReportAction.LiveLogInfo.class, new bg());
        f65215a.put(h.a.class, new u());
        f65215a.put(AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo.class, new au());
        f65215a.put(PhotoInfo.CoverInfo.class, new af());
        f65215a.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new am());
        f65215a.put(com.kwad.sdk.core.webview.b.a.a.class, new ac());
        f65215a.put(a.C1956a.class, new c());
        f65215a.put(HotspotInfo.class, new av());
        f65215a.put(HotspotListData.class, new aw());
        f65215a.put(NewsInfo.ImageInfo.class, new ay());
        f65215a.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new ai());
        f65215a.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new ah());
        f65215a.put(n.b.class, new t());
        f65215a.put(com.kwad.sdk.core.webview.b.a.f.class, new ct());
        f65215a.put(PhotoInfo.class, new bq());
        f65215a.put(AggregatePageEntranceInfo.class, new r());
        f65215a.put(PhotoInfo.BaseInfo.class, new y());
        f65215a.put(r.a.class, new cu());
        f65215a.put(AdInfo.AdvertiserInfo.class, new q());
        f65215a.put(SplashPreloadManager.PreLoadItem.class, new bw());
        f65215a.put(SdkConfigData.TemplateConfigMap.class, new ck());
        f65215a.put(PhotoComment.class, new bp());
        f65215a.put(com.kwad.sdk.core.g.a.g.class, new bh());
        f65215a.put(ActivityInfo.class, new d());
        f65215a.put(PhotoShareInfo.ShareUrlInfo.class, new cd());
        f65215a.put(PhotoInfo.PhotoAd.class, new bo());
        f65215a.put(l.b.class, new bc());
        f65215a.put(InsertScreenConfigItem.InsertScreenConfig.class, new az());
        f65215a.put(PhotoInfo.AuthorInfo.class, new v());
        f65215a.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new p());
        f65215a.put(AdInfo.AdBaseInfo.class, new f());
        f65215a.put(PreloadData.class, new by());
        f65215a.put(AdInfo.AdTrackInfo.class, new o());
        f65215a.put(AdStyleInfo.BannerAdInfo.class, new x());
        f65215a.put(com.kwad.sdk.core.webview.b.a.b.class, new bk());
        f65215a.put(AdInfo.MaterialSize.class, new bj());
        f65215a.put(com.kwad.sdk.core.g.a.c.class, new z());
        f65215a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new ba());
        f65215a.put(AppStatusRules.UploadConfig.class, new cn());
        f65215a.put(SdkConfigData.TemplateConfig.class, new cj());
        f65215a.put(VideoPlayerStatus.class, new cr());
        f65215a.put(SdkConfigData.CouponActiveConfig.class, new ad());
        f65215a.put(ReportAction.class, new bz());
        f65215a.put(g.a.class, new co());
        f65215a.put(AdStyleInfo.PlayDetailInfo.class, new br());
        f65215a.put(com.kwad.sdk.collector.a.f.class, new cf());
        f65215a.put(com.kwad.sdk.core.response.model.b.class, new bv());
        f65215a.put(LiveInfo.User.class, new cp());
        f65215a.put(AdInfo.AdConversionInfo.class, new h());
        f65215a.put(AdInfo.AdPreloadInfo.class, new k());
        f65215a.put(AdInfo.DownloadSafeInfo.class, new al());
        f65215a.put(LiveInfo.class, new bf());
        f65215a.put(AdStyleInfo.class, new m());
        f65215a.put(com.kwad.sdk.collector.a.d.class, new ao());
        f65215a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new bi());
        f65215a.put(LiveInfo.CoverThumbnailUrl.class, new ag());
        f65215a.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new cw());
        f65215a.put(AdTemplate.class, new n());
        f65215a.put(WebCardVideoPositionHandler.VideoPosition.class, new cs());
        f65215a.put(AdInfo.class, new i());
        f65215a.put(t.a.class, new bd());
        f65215a.put(k.a.class, new ae());
        f65215a.put(com.kwad.sdk.core.webview.b.a.e.class, new cg());
        f65215a.put(AdInfo.H5Config.class, new ar());
        f65215a.put(LiveInfo.User.HeadUrl.class, new as());
        f65215a.put(AdInfo.AdMaterialInfo.class, new j());
        f65215a.put(ReportInfo.class, new ca());
        f65215a.put(PageInfo.class, new bm());
        f65215a.put(ABParams.class, new a());
        f65215a.put(HomeApkBannerData.class, new at());
        f65215a.put(PhotoInfo.TubeEpisode.class, new cl());
    }

    public static com.kwad.sdk.core.d a(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? f65215a.get(cls) : (com.kwad.sdk.core.d) invokeL.objValue;
    }
}
