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
/* loaded from: classes10.dex */
public class be {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> f71295a;
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
        f71295a = hashMap;
        hashMap.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new aj());
        f71295a.put(com.kwad.sdk.core.g.a.g.class, new bh());
        f71295a.put(n.a.class, new s());
        f71295a.put(PhotoInfo.class, new bq());
        f71295a.put(TabInfo.class, new ci());
        f71295a.put(h.a.class, new ax());
        f71295a.put(a.C1994a.class, new ap());
        f71295a.put(ReportAction.a.class, new aa());
        f71295a.put(com.kwad.sdk.core.g.a.c.class, new z());
        f71295a.put(AdInfo.H5Config.class, new ar());
        f71295a.put(com.kwad.sdk.core.webview.b.a.c.class, new bs());
        f71295a.put(ReportAction.LiveLogInfo.class, new bg());
        f71295a.put(PhotoShareInfo.ShareUrlInfo.class, new cd());
        f71295a.put(AppStatusRules.UploadConfig.class, new cn());
        f71295a.put(com.kwad.sdk.core.webview.b.a.e.class, new cg());
        f71295a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new ba());
        f71295a.put(SplashPreloadManager.PreLoadItem.class, new bw());
        f71295a.put(com.kwad.sdk.core.response.model.a.class, new an());
        f71295a.put(PageInfo.class, new bm());
        f71295a.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new cw());
        f71295a.put(ReportAction.class, new bz());
        f71295a.put(HotspotListData.class, new aw());
        f71295a.put(NewsInfo.class, new bl());
        f71295a.put(WebCardVideoPositionHandler.VideoPosition.class, new cs());
        f71295a.put(AdInfo.AdAggregateInfo.class, new e());
        f71295a.put(ABParams.class, new a());
        f71295a.put(AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo.class, new au());
        f71295a.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new bn());
        f71295a.put(l.a.class, new bb());
        f71295a.put(LiveInfo.CoverThumbnailUrl.class, new ag());
        f71295a.put(LiveInfo.User.HeadUrl.class, new as());
        f71295a.put(AdInfo.AdTrackInfo.class, new o());
        f71295a.put(AdInfo.AdSplashInfo.class, new l());
        f71295a.put(SceneImpl.class, new cb());
        f71295a.put(AggregatePageEntranceInfo.class, new r());
        f71295a.put(AvatarGuiderConfigItem.AvatarGuiderConfig.class, new w());
        f71295a.put(com.kwad.sdk.core.response.model.b.class, new bv());
        f71295a.put(LiveInfo.User.class, new cp());
        f71295a.put(PhotoInfo.AuthorInfo.class, new v());
        f71295a.put(DownloadParams.class, new ak());
        f71295a.put(LiveInfo.class, new bf());
        f71295a.put(AdStyleInfo.BannerAdInfo.class, new x());
        f71295a.put(VideoPlayerStatus.class, new cr());
        f71295a.put(InsertScreenConfigItem.InsertScreenConfig.class, new az());
        f71295a.put(com.kwad.sdk.core.g.a.k.class, new ch());
        f71295a.put(AdTemplate.class, new n());
        f71295a.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new ah());
        f71295a.put(g.a.class, new co());
        f71295a.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new p());
        f71295a.put(com.kwad.sdk.collector.a.d.class, new ao());
        f71295a.put(AdInfo.AdConversionInfo.class, new h());
        f71295a.put(AdInfo.class, new i());
        f71295a.put(AdStyleInfo.FeedAdInfo.class, new aq());
        f71295a.put(PhotoInfo.CoverInfo.class, new af());
        f71295a.put(com.kwad.sdk.core.webview.b.a.d.class, new ce());
        f71295a.put(AdStyleInfo.AdBrowseInfo.class, new g());
        f71295a.put(PreloadData.class, new by());
        f71295a.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new am());
        f71295a.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new ai());
        f71295a.put(ActivityInfo.class, new d());
        f71295a.put(PhotoInfo.TubeEpisode.class, new cl());
        f71295a.put(SdkConfigData.TemplateConfigMap.class, new ck());
        f71295a.put(AdInfo.AdBaseInfo.class, new f());
        f71295a.put(com.kwad.sdk.core.webview.b.a.b.class, new bk());
        f71295a.put(PhotoComment.class, new bp());
        f71295a.put(URLPackage.class, new cm());
        f71295a.put(r.a.class, new cu());
        f71295a.put(com.kwad.sdk.collector.a.e.class, new cc());
        f71295a.put(k.a.class, new ae());
        f71295a.put(ReportInfo.class, new ca());
        f71295a.put(AdStyleInfo.PlayDetailInfo.class, new br());
        f71295a.put(com.kwad.sdk.collector.a.f.class, new cf());
        f71295a.put(HomeApkBannerData.class, new at());
        f71295a.put(h.a.class, new u());
        f71295a.put(AdInfo.AdvertiserInfo.class, new q());
        f71295a.put(AdInfo.MaterialSize.class, new bj());
        f71295a.put(PhotoInfo.VideoInfo.class, new cq());
        f71295a.put(SdkConfigData.CouponActiveConfig.class, new ad());
        f71295a.put(l.b.class, new bc());
        f71295a.put(AdInfo.PlayableStyleInfo.class, new bu());
        f71295a.put(AdStyleInfo.PlayEndInfo.class, new bt());
        f71295a.put(PhotoInfo.BaseInfo.class, new y());
        f71295a.put(com.kwad.sdk.core.webview.b.a.a.class, new ac());
        f71295a.put(n.b.class, new t());
        f71295a.put(HotspotInfo.class, new av());
        f71295a.put(SplashPreloadManager.PreLoadPara.class, new bx());
        f71295a.put(PhotoInfo.WallpaperInfo.class, new cv());
        f71295a.put(t.a.class, new bd());
        f71295a.put(AdInfo.AdMaterialInfo.class, new j());
        f71295a.put(com.kwad.sdk.core.webview.b.a.f.class, new ct());
        f71295a.put(a.C2000a.class, new c());
        f71295a.put(SdkConfigData.TemplateConfig.class, new cj());
        f71295a.put(AdInfo.AdPreloadInfo.class, new k());
        f71295a.put(AdInfo.DownloadSafeInfo.class, new al());
        f71295a.put(n.a.class, new ab());
        f71295a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new bi());
        f71295a.put(AdStyleInfo.class, new m());
        f71295a.put(PhotoInfo.PhotoAd.class, new bo());
        f71295a.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new b());
        f71295a.put(NewsInfo.ImageInfo.class, new ay());
    }

    public static com.kwad.sdk.core.d a(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? f71295a.get(cls) : (com.kwad.sdk.core.d) invokeL.objValue;
    }
}
