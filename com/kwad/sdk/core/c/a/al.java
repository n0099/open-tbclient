package com.kwad.sdk.core.c.a;

import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.ProfileGuideConfigItem;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.g.a.h;
import com.kwad.sdk.core.preload.SplashPreloadManager;
import com.kwad.sdk.core.report.b;
import com.kwad.sdk.core.report.o;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PhotoComment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.PhotoShareInfo;
import com.kwad.sdk.core.response.model.PreloadData;
import com.kwad.sdk.core.response.model.ReportInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.sdk.core.webview.jshandler.a;
import com.kwad.sdk.core.webview.jshandler.g;
import com.kwad.sdk.core.webview.jshandler.l;
import com.kwad.sdk.core.webview.jshandler.o;
import com.kwad.sdk.core.webview.jshandler.p;
import com.kwad.sdk.home.download.HomeApkBannerData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class al {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.c> f32077a;

    static {
        HashMap hashMap = new HashMap(71);
        f32077a = hashMap;
        hashMap.put(AdStyleInfo.class, new j());
        f32077a.put(AdInfo.AdTrackInfo.class, new l());
        f32077a.put(AdTemplate.class, new k());
        f32077a.put(h.a.class, new q());
        f32077a.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new bt());
        f32077a.put(SplashPreloadManager.PreLoadPara.class, new az());
        f32077a.put(p.a.class, new ak());
        f32077a.put(AdInfo.class, new f());
        f32077a.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new m());
        f32077a.put(WebCardVideoPositionHandler.VideoPosition.class, new br());
        f32077a.put(LiveInfo.CoverThumbnailUrl.class, new w());
        f32077a.put(SplashPreloadManager.PreLoadItem.class, new ay());
        f32077a.put(AdInfo.AdPreloadInfo.class, new h());
        f32077a.put(ReportInfo.class, new bc());
        f32077a.put(o.a.class, new u());
        f32077a.put(PhotoComment.class, new at());
        f32077a.put(AdInfo.DownloadSafeInfo.class, new aa());
        f32077a.put(AdInfo.AdvertiserInfo.class, new n());
        f32077a.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new ab());
        f32077a.put(com.kwad.sdk.collector.a.d.class, new ad());
        f32077a.put(URLPackage.class, new bl());
        f32077a.put(com.kwad.sdk.collector.a.e.class, new be());
        f32077a.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new b());
        f32077a.put(PhotoInfo.class, new au());
        f32077a.put(AdStyleInfo.PlayEndInfo.class, new aw());
        f32077a.put(com.kwad.sdk.collector.a.f.class, new bg());
        f32077a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new ao());
        f32077a.put(PhotoInfo.AuthorInfo.class, new r());
        f32077a.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new y());
        f32077a.put(VideoPlayerStatus.class, new bq());
        f32077a.put(com.kwad.sdk.core.g.a.c.class, new t());
        f32077a.put(AdInfo.AdConversionInfo.class, new e());
        f32077a.put(AdInfo.AdMaterialInfo.class, new g());
        f32077a.put(SdkConfigData.TemplateConfigMap.class, new bi());
        f32077a.put(AdInfo.MaterialSize.class, new ap());
        f32077a.put(LiveInfo.User.HeadUrl.class, new ag());
        f32077a.put(DownloadParams.class, new z());
        f32077a.put(AdStyleInfo.PlayEndInfo.HorizontalPatchAdInfo.class, new ai());
        f32077a.put(l.a.class, new o());
        f32077a.put(PhotoInfo.PhotoAd.class, new as());
        f32077a.put(PhotoShareInfo.ShareUrlInfo.class, new bf());
        f32077a.put(l.b.class, new p());
        f32077a.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new ar());
        f32077a.put(ProfileGuideConfigItem.ProfileGuideConfig.class, new bb());
        f32077a.put(TrendInfo.class, new bj());
        f32077a.put(PhotoInfo.BaseInfo.class, new s());
        f32077a.put(PhotoInfo.CoverInfo.class, new v());
        f32077a.put(HomeApkBannerData.class, new ah());
        f32077a.put(a.C0373a.class, new c());
        f32077a.put(b.a.class, new ae());
        f32077a.put(PageInfo.class, new aq());
        f32077a.put(SceneImpl.class, new bd());
        f32077a.put(PhotoInfo.TubeEpisode.class, new bk());
        f32077a.put(LiveInfo.class, new am());
        f32077a.put(AdInfo.PlayableStyleInfo.class, new ax());
        f32077a.put(g.a.class, new bn());
        f32077a.put(o.a.class, new bs());
        f32077a.put(SdkConfigData.TemplateConfig.class, new bh());
        f32077a.put(AdStyleInfo.PlayDetailInfo.class, new av());
        f32077a.put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new aj());
        f32077a.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new x());
        f32077a.put(com.kwad.sdk.core.g.a.g.class, new an());
        f32077a.put(com.kwad.sdk.core.response.model.a.class, new ac());
        f32077a.put(LiveInfo.User.class, new bo());
        f32077a.put(PhotoInfo.VideoInfo.class, new bp());
        f32077a.put(AppStatusRules.UploadConfig.class, new bm());
        f32077a.put(ABParams.class, new a());
        f32077a.put(AdInfo.AdBaseInfo.class, new d());
        f32077a.put(AdStyleInfo.FeedAdInfo.class, new af());
        f32077a.put(PreloadData.class, new ba());
        f32077a.put(AdInfo.AdSplashInfo.class, new i());
    }

    public static com.kwad.sdk.core.c a(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        return f32077a.get(cls);
    }
}
