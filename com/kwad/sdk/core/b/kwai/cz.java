package com.kwad.sdk.core.b.kwai;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.TemplateConfig;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class cz {
    public static Map<Class<? extends com.kwad.sdk.core.response.kwai.a>, com.kwad.sdk.core.d> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(PageInfo.class, new dr());
        a.put(AdInfo.FullScreenVideoInfo.class, new cf());
        a.put(AdMatrixInfo.FullScreenInfo.class, new ce());
        a.put(AdStyleInfo.ExtraDisplayInfo.class, new bx());
        a.put(AdMatrixInfo.EndCardInfo.class, new bt());
        a.put(AdInfo.DownloadSafeInfo.class, new bp());
        a.put(AdTemplate.class, new ab());
        a.put(AdInfo.ComplianceInfo.class, new ax());
        a.put(com.kwad.sdk.e.kwai.a.class, new Cdo());
        a.put(ABParams.class, new a());
        a.put(AdInfo.AdInsertScreenInfo.class, new q());
        a.put(AdInfo.AdFeedInfo.class, new m());
        a.put(URLPackage.class, new fm());
        a.put(AdStyleInfo.AdBrowseInfo.class, new i());
        a.put(AdInfo.UnDownloadConf.class, new fn());
        a.put(AdMatrixInfo.RotateInfo.class, new ek());
        a.put(AdStyleInfo.FeedAdInfo.class, new by());
        a.put(AdMatrixInfo.AdInteractionInfo.class, new r());
        a.put(AdMatrixInfo.FullPageActionBarInfo.class, new cd());
        a.put(AdMatrixInfo.RotateDegreeInfo.class, new ej());
        a.put(WebViewLoadMsg.class, new fv());
        a.put(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo.class, new db());
        a.put(com.kwad.sdk.core.network.i.class, new dk());
        a.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new df());
        a.put(AdMatrixInfo.BaseMatrixTemplate.class, new an());
        a.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new dt());
        a.put(AdStyleInfo.PlayDetailInfo.PatchEcInfo.class, new du());
        a.put(SceneImpl.class, new em());
        a.put(AdInfo.AdSplashInfo.class, new y());
        a.put(PhotoInfo.VideoInfo.class, new fq());
        a.put(AdStyleInfo.ExposeTagInfo.class, new bw());
        a.put(AdInfo.AdAggregateInfo.class, new f());
        a.put(StatusInfo.SplashAdInfo.class, new ev());
        a.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new bk());
        a.put(AdInfo.UnDownloadRegionConf.class, new fo());
        a.put(com.kwad.sdk.internal.api.b.class, new ew());
        a.put(AdMatrixInfo.class, new u());
        a.put(com.kwad.sdk.core.request.model.f.class, new fg());
        a.put(TemplateConfig.class, new fi());
        a.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new bu());
        a.put(AdMatrixInfo.DownloadTexts.class, new br());
        a.put(com.kwad.sdk.e.kwai.b.class, new dp());
        a.put(AdInfo.AdBaseInfo.class, new g());
        a.put(AdMatrixInfo.SplashActionBarInfo.class, new eu());
        a.put(AdMatrixInfo.BottomBannerInfo.class, new ao());
        a.put(AdMatrixInfo.MatrixTemplate.class, new dh());
        a.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new b());
        a.put(AdInfo.AdPreloadInfo.class, new v());
        a.put(AdMatrixInfo.AggregationCardInfo.class, new af());
        a.put(AdMatrixInfo.InterstitialCardInfo.class, new ct());
        a.put(AdMatrixInfo.SplashSlideInfo.class, new fc());
        a.put(HttpDnsInfo.class, new cn());
        a.put(AdMatrixInfo.TemplateData.class, new fk());
        a.put(VideoPlayerStatus.class, new fr());
        a.put(AdInfo.AdConversionInfo.class, new j());
        a.put(AdInfo.AdStyleConfInfo.class, new z());
        a.put(AdStyleInfo.class, new aa());
        a.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new bj());
        a.put(AdMatrixInfo.AdDataV2.class, new l());
        a.put(com.kwad.sdk.core.network.j.class, new dl());
        a.put(AdInfo.class, new p());
        a.put(AdMatrixInfo.ActionBarInfoNew.class, new c());
        a.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new fw());
        a.put(PhotoInfo.class, new dv());
        a.put(AdStyleInfo.PlayEndInfo.class, new dz());
        a.put(AdMatrixInfo.SplashInfo.class, new ex());
        a.put(AdInfo.H5Config.class, new ci());
        a.put(AdInfo.SmallAppJumpInfo.class, new es());
        a.put(AdProductInfo.SpikeInfo.class, new et());
        a.put(AdStyleInfo.PlayDetailInfo.DrawAdInfo.class, new bs());
        a.put(AdInfo.MaterialSize.class, new dg());
        a.put(AdInfo.AdTrackInfo.class, new ac());
        a.put(AdProductInfo.class, new w());
        a.put(AdInfo.PlayableStyleInfo.class, new ec());
        a.put(AdInfo.AdRewardInfo.class, new x());
        a.put(SDKInitMsg.class, new el());
        a.put(StatusInfo.class, new fe());
        a.put(AdMatrixInfo.ShakeInfo.class, new en());
        a.put(HttpDnsInfo.IpInfo.class, new cv());
        a.put(StatusInfo.SplashStyleControl.class, new fd());
        a.put(AdStyleInfo.PlayDetailInfo.class, new dx());
        a.put(HybridLoadMsg.class, new co());
        a.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new bl());
        a.put(AdInfo.AdMaterialInfo.class, new t());
        a.put(AdMatrixInfo.Styles.class, new ff());
        a.put(CouponInfo.class, new bg());
        a.put(PhotoInfo.BaseInfo.class, new am());
        a.put(AdMatrixInfo.MerchantLiveReservationInfo.class, new di());
        a.put(com.kwad.sdk.internal.api.a.class, new s());
        a.put(com.kwad.sdk.core.request.model.b.class, new bm());
        a.put(AdInfo.AdvertiserInfo.class, new ae());
        a.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new ad());
        b();
    }

    public static com.kwad.sdk.core.d a(Class<? extends com.kwad.sdk.core.response.kwai.a> cls) {
        return a.get(cls);
    }

    public static Map<Class<? extends com.kwad.sdk.core.response.kwai.a>, com.kwad.sdk.core.d> a() {
        return a;
    }

    @ForInvoker(methodId = "registerHolder")
    public static void b() {
        ay.a();
        az.a();
        ba.a();
        bb.a();
        bc.a();
        bd.a();
        be.a();
        bz.a();
        ca.a();
        cb.a();
        cc.a();
    }
}
