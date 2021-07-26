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
/* loaded from: classes6.dex */
public class be {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> f34360a;
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
        f34360a = hashMap;
        hashMap.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new aj());
        f34360a.put(com.kwad.sdk.core.g.a.g.class, new bh());
        f34360a.put(n.a.class, new s());
        f34360a.put(PhotoInfo.class, new bq());
        f34360a.put(TabInfo.class, new ci());
        f34360a.put(h.a.class, new ax());
        f34360a.put(a.C0423a.class, new ap());
        f34360a.put(ReportAction.a.class, new aa());
        f34360a.put(com.kwad.sdk.core.g.a.c.class, new z());
        f34360a.put(AdInfo.H5Config.class, new ar());
        f34360a.put(com.kwad.sdk.core.webview.b.a.c.class, new bs());
        f34360a.put(ReportAction.LiveLogInfo.class, new bg());
        f34360a.put(PhotoShareInfo.ShareUrlInfo.class, new cd());
        f34360a.put(AppStatusRules.UploadConfig.class, new cn());
        f34360a.put(com.kwad.sdk.core.webview.b.a.e.class, new cg());
        f34360a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new ba());
        f34360a.put(SplashPreloadManager.PreLoadItem.class, new bw());
        f34360a.put(com.kwad.sdk.core.response.model.a.class, new an());
        f34360a.put(PageInfo.class, new bm());
        f34360a.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new cw());
        f34360a.put(ReportAction.class, new bz());
        f34360a.put(HotspotListData.class, new aw());
        f34360a.put(NewsInfo.class, new bl());
        f34360a.put(WebCardVideoPositionHandler.VideoPosition.class, new cs());
        f34360a.put(AdInfo.AdAggregateInfo.class, new e());
        f34360a.put(ABParams.class, new a());
        f34360a.put(AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo.class, new au());
        f34360a.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new bn());
        f34360a.put(l.a.class, new bb());
        f34360a.put(LiveInfo.CoverThumbnailUrl.class, new ag());
        f34360a.put(LiveInfo.User.HeadUrl.class, new as());
        f34360a.put(AdInfo.AdTrackInfo.class, new o());
        f34360a.put(AdInfo.AdSplashInfo.class, new l());
        f34360a.put(SceneImpl.class, new cb());
        f34360a.put(AggregatePageEntranceInfo.class, new r());
        f34360a.put(AvatarGuiderConfigItem.AvatarGuiderConfig.class, new w());
        f34360a.put(com.kwad.sdk.core.response.model.b.class, new bv());
        f34360a.put(LiveInfo.User.class, new cp());
        f34360a.put(PhotoInfo.AuthorInfo.class, new v());
        f34360a.put(DownloadParams.class, new ak());
        f34360a.put(LiveInfo.class, new bf());
        f34360a.put(AdStyleInfo.BannerAdInfo.class, new x());
        f34360a.put(VideoPlayerStatus.class, new cr());
        f34360a.put(InsertScreenConfigItem.InsertScreenConfig.class, new az());
        f34360a.put(com.kwad.sdk.core.g.a.k.class, new ch());
        f34360a.put(AdTemplate.class, new n());
        f34360a.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new ah());
        f34360a.put(g.a.class, new co());
        f34360a.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new p());
        f34360a.put(com.kwad.sdk.collector.a.d.class, new ao());
        f34360a.put(AdInfo.AdConversionInfo.class, new h());
        f34360a.put(AdInfo.class, new i());
        f34360a.put(AdStyleInfo.FeedAdInfo.class, new aq());
        f34360a.put(PhotoInfo.CoverInfo.class, new af());
        f34360a.put(com.kwad.sdk.core.webview.b.a.d.class, new ce());
        f34360a.put(AdStyleInfo.AdBrowseInfo.class, new g());
        f34360a.put(PreloadData.class, new by());
        f34360a.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new am());
        f34360a.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new ai());
        f34360a.put(ActivityInfo.class, new d());
        f34360a.put(PhotoInfo.TubeEpisode.class, new cl());
        f34360a.put(SdkConfigData.TemplateConfigMap.class, new ck());
        f34360a.put(AdInfo.AdBaseInfo.class, new f());
        f34360a.put(com.kwad.sdk.core.webview.b.a.b.class, new bk());
        f34360a.put(PhotoComment.class, new bp());
        f34360a.put(URLPackage.class, new cm());
        f34360a.put(r.a.class, new cu());
        f34360a.put(com.kwad.sdk.collector.a.e.class, new cc());
        f34360a.put(k.a.class, new ae());
        f34360a.put(ReportInfo.class, new ca());
        f34360a.put(AdStyleInfo.PlayDetailInfo.class, new br());
        f34360a.put(com.kwad.sdk.collector.a.f.class, new cf());
        f34360a.put(HomeApkBannerData.class, new at());
        f34360a.put(h.a.class, new u());
        f34360a.put(AdInfo.AdvertiserInfo.class, new q());
        f34360a.put(AdInfo.MaterialSize.class, new bj());
        f34360a.put(PhotoInfo.VideoInfo.class, new cq());
        f34360a.put(SdkConfigData.CouponActiveConfig.class, new ad());
        f34360a.put(l.b.class, new bc());
        f34360a.put(AdInfo.PlayableStyleInfo.class, new bu());
        f34360a.put(AdStyleInfo.PlayEndInfo.class, new bt());
        f34360a.put(PhotoInfo.BaseInfo.class, new y());
        f34360a.put(com.kwad.sdk.core.webview.b.a.a.class, new ac());
        f34360a.put(n.b.class, new t());
        f34360a.put(HotspotInfo.class, new av());
        f34360a.put(SplashPreloadManager.PreLoadPara.class, new bx());
        f34360a.put(PhotoInfo.WallpaperInfo.class, new cv());
        f34360a.put(t.a.class, new bd());
        f34360a.put(AdInfo.AdMaterialInfo.class, new j());
        f34360a.put(com.kwad.sdk.core.webview.b.a.f.class, new ct());
        f34360a.put(a.C0429a.class, new c());
        f34360a.put(SdkConfigData.TemplateConfig.class, new cj());
        f34360a.put(AdInfo.AdPreloadInfo.class, new k());
        f34360a.put(AdInfo.DownloadSafeInfo.class, new al());
        f34360a.put(n.a.class, new ab());
        f34360a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new bi());
        f34360a.put(AdStyleInfo.class, new m());
        f34360a.put(PhotoInfo.PhotoAd.class, new bo());
        f34360a.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new b());
        f34360a.put(NewsInfo.ImageInfo.class, new ay());
    }

    public static com.kwad.sdk.core.d a(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? f34360a.get(cls) : (com.kwad.sdk.core.d) invokeL.objValue;
    }
}
