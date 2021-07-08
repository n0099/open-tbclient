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
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> f34171a;
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
        f34171a = hashMap;
        hashMap.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new aj());
        f34171a.put(com.kwad.sdk.core.g.a.g.class, new bh());
        f34171a.put(n.a.class, new s());
        f34171a.put(PhotoInfo.class, new bq());
        f34171a.put(TabInfo.class, new ci());
        f34171a.put(h.a.class, new ax());
        f34171a.put(a.C0421a.class, new ap());
        f34171a.put(ReportAction.a.class, new aa());
        f34171a.put(com.kwad.sdk.core.g.a.c.class, new z());
        f34171a.put(AdInfo.H5Config.class, new ar());
        f34171a.put(com.kwad.sdk.core.webview.b.a.c.class, new bs());
        f34171a.put(ReportAction.LiveLogInfo.class, new bg());
        f34171a.put(PhotoShareInfo.ShareUrlInfo.class, new cd());
        f34171a.put(AppStatusRules.UploadConfig.class, new cn());
        f34171a.put(com.kwad.sdk.core.webview.b.a.e.class, new cg());
        f34171a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new ba());
        f34171a.put(SplashPreloadManager.PreLoadItem.class, new bw());
        f34171a.put(com.kwad.sdk.core.response.model.a.class, new an());
        f34171a.put(PageInfo.class, new bm());
        f34171a.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new cw());
        f34171a.put(ReportAction.class, new bz());
        f34171a.put(HotspotListData.class, new aw());
        f34171a.put(NewsInfo.class, new bl());
        f34171a.put(WebCardVideoPositionHandler.VideoPosition.class, new cs());
        f34171a.put(AdInfo.AdAggregateInfo.class, new e());
        f34171a.put(ABParams.class, new a());
        f34171a.put(AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo.class, new au());
        f34171a.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new bn());
        f34171a.put(l.a.class, new bb());
        f34171a.put(LiveInfo.CoverThumbnailUrl.class, new ag());
        f34171a.put(LiveInfo.User.HeadUrl.class, new as());
        f34171a.put(AdInfo.AdTrackInfo.class, new o());
        f34171a.put(AdInfo.AdSplashInfo.class, new l());
        f34171a.put(SceneImpl.class, new cb());
        f34171a.put(AggregatePageEntranceInfo.class, new r());
        f34171a.put(AvatarGuiderConfigItem.AvatarGuiderConfig.class, new w());
        f34171a.put(com.kwad.sdk.core.response.model.b.class, new bv());
        f34171a.put(LiveInfo.User.class, new cp());
        f34171a.put(PhotoInfo.AuthorInfo.class, new v());
        f34171a.put(DownloadParams.class, new ak());
        f34171a.put(LiveInfo.class, new bf());
        f34171a.put(AdStyleInfo.BannerAdInfo.class, new x());
        f34171a.put(VideoPlayerStatus.class, new cr());
        f34171a.put(InsertScreenConfigItem.InsertScreenConfig.class, new az());
        f34171a.put(com.kwad.sdk.core.g.a.k.class, new ch());
        f34171a.put(AdTemplate.class, new n());
        f34171a.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new ah());
        f34171a.put(g.a.class, new co());
        f34171a.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new p());
        f34171a.put(com.kwad.sdk.collector.a.d.class, new ao());
        f34171a.put(AdInfo.AdConversionInfo.class, new h());
        f34171a.put(AdInfo.class, new i());
        f34171a.put(AdStyleInfo.FeedAdInfo.class, new aq());
        f34171a.put(PhotoInfo.CoverInfo.class, new af());
        f34171a.put(com.kwad.sdk.core.webview.b.a.d.class, new ce());
        f34171a.put(AdStyleInfo.AdBrowseInfo.class, new g());
        f34171a.put(PreloadData.class, new by());
        f34171a.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new am());
        f34171a.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new ai());
        f34171a.put(ActivityInfo.class, new d());
        f34171a.put(PhotoInfo.TubeEpisode.class, new cl());
        f34171a.put(SdkConfigData.TemplateConfigMap.class, new ck());
        f34171a.put(AdInfo.AdBaseInfo.class, new f());
        f34171a.put(com.kwad.sdk.core.webview.b.a.b.class, new bk());
        f34171a.put(PhotoComment.class, new bp());
        f34171a.put(URLPackage.class, new cm());
        f34171a.put(r.a.class, new cu());
        f34171a.put(com.kwad.sdk.collector.a.e.class, new cc());
        f34171a.put(k.a.class, new ae());
        f34171a.put(ReportInfo.class, new ca());
        f34171a.put(AdStyleInfo.PlayDetailInfo.class, new br());
        f34171a.put(com.kwad.sdk.collector.a.f.class, new cf());
        f34171a.put(HomeApkBannerData.class, new at());
        f34171a.put(h.a.class, new u());
        f34171a.put(AdInfo.AdvertiserInfo.class, new q());
        f34171a.put(AdInfo.MaterialSize.class, new bj());
        f34171a.put(PhotoInfo.VideoInfo.class, new cq());
        f34171a.put(SdkConfigData.CouponActiveConfig.class, new ad());
        f34171a.put(l.b.class, new bc());
        f34171a.put(AdInfo.PlayableStyleInfo.class, new bu());
        f34171a.put(AdStyleInfo.PlayEndInfo.class, new bt());
        f34171a.put(PhotoInfo.BaseInfo.class, new y());
        f34171a.put(com.kwad.sdk.core.webview.b.a.a.class, new ac());
        f34171a.put(n.b.class, new t());
        f34171a.put(HotspotInfo.class, new av());
        f34171a.put(SplashPreloadManager.PreLoadPara.class, new bx());
        f34171a.put(PhotoInfo.WallpaperInfo.class, new cv());
        f34171a.put(t.a.class, new bd());
        f34171a.put(AdInfo.AdMaterialInfo.class, new j());
        f34171a.put(com.kwad.sdk.core.webview.b.a.f.class, new ct());
        f34171a.put(a.C0427a.class, new c());
        f34171a.put(SdkConfigData.TemplateConfig.class, new cj());
        f34171a.put(AdInfo.AdPreloadInfo.class, new k());
        f34171a.put(AdInfo.DownloadSafeInfo.class, new al());
        f34171a.put(n.a.class, new ab());
        f34171a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new bi());
        f34171a.put(AdStyleInfo.class, new m());
        f34171a.put(PhotoInfo.PhotoAd.class, new bo());
        f34171a.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new b());
        f34171a.put(NewsInfo.ImageInfo.class, new ay());
    }

    public static com.kwad.sdk.core.d a(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? f34171a.get(cls) : (com.kwad.sdk.core.d) invokeL.objValue;
    }
}
