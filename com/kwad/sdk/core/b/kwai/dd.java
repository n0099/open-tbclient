package com.kwad.sdk.core.b.kwai;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
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
/* loaded from: classes9.dex */
public final class dd {
    public static Map<Class<? extends com.kwad.sdk.core.response.kwai.a>, com.kwad.sdk.core.d> XD;

    static {
        HashMap hashMap = new HashMap();
        XD = hashMap;
        hashMap.put(AdInfo.AdBaseInfo.class, new g());
        XD.put(AdInfo.MaterialSize.class, new dm());
        XD.put(AdInfo.ComplianceInfo.class, new ay());
        XD.put(AdMatrixInfo.AggregationCardInfo.class, new af());
        XD.put(AdStyleInfo.AdBrowseInfo.class, new i());
        XD.put(com.kwad.sdk.e.kwai.b.class, new dv());
        XD.put(AdProductInfo.class, new w());
        XD.put(TemplateConfig.class, new fq());
        XD.put(AdMatrixInfo.FullPageActionBarInfo.class, new cf());
        XD.put(WebViewCommercialMsg.class, new ge());
        XD.put(AdInfo.AdvertiserInfo.class, new ae());
        XD.put(AdMatrixInfo.SplashInfo.class, new ff());
        XD.put(AdTemplate.class, new ab());
        XD.put(AdInfo.AdRewardInfo.class, new x());
        XD.put(AdProductInfo.SpikeInfo.class, new fb());
        XD.put(AdInfo.AdFeedInfo.class, new m());
        XD.put(AdInfo.AdStyleConfInfo.class, new z());
        XD.put(AdMatrixInfo.Styles.class, new fn());
        XD.put(com.kwad.sdk.core.request.model.b.class, new bn());
        XD.put(AdInfo.UnDownloadRegionConf.class, new fw());
        XD.put(VideoPlayerStatus.class, new ga());
        XD.put(AdInfo.class, new p());
        XD.put(com.kwad.sdk.e.kwai.a.class, new du());
        XD.put(StatusInfo.SplashStyleControl.class, new fl());
        XD.put(AdMatrixInfo.AdInteractionInfo.class, new r());
        XD.put(AdMatrixInfo.InterstitialCardInfo.class, new cw());
        XD.put(AdInfo.FullScreenVideoInfo.class, new ch());
        XD.put(AdMatrixInfo.TemplateData.class, new fs());
        XD.put(AdMatrixInfo.MatrixTemplate.class, new dn());
        XD.put(AdInfo.AdMaterialInfo.class, new t());
        XD.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new ad());
        XD.put(AdInfo.UnDownloadConf.class, new fv());
        XD.put(com.kwad.sdk.core.request.model.f.class, new fo());
        XD.put(HttpDnsInfo.IpInfo.class, new cz());
        XD.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new bk());
        XD.put(PhotoInfo.VideoInfo.class, new fy());
        XD.put(AdMatrixInfo.class, new u());
        XD.put(AdStyleInfo.FeedAdInfo.class, new ca());
        XD.put(SceneImpl.class, new eu());
        XD.put(AdMatrixInfo.DownloadTexts.class, new bs());
        XD.put(AdMatrixInfo.RotateInfo.class, new es());
        XD.put(WebViewLoadMsg.class, new gf());
        XD.put(AdStyleInfo.class, new aa());
        XD.put(StatusInfo.class, new fm());
        XD.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new gg());
        XD.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new dl());
        XD.put(AdMatrixInfo.SplashSlideInfo.class, new fk());
        XD.put(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo.class, new dh());
        XD.put(AdStyleInfo.PlayDetailInfo.class, new ed());
        XD.put(AdMatrixInfo.BottomBannerInfo.class, new ap());
        XD.put(StatusInfo.SplashAdInfo.class, new fd());
        XD.put(CouponInfo.class, new bh());
        XD.put(PageInfo.class, new dx());
        XD.put(AdStyleInfo.ExtraDisplayInfo.class, new bz());
        XD.put(AdMatrixInfo.RotateDegreeInfo.class, new er());
        XD.put(PhotoInfo.class, new eb());
        XD.put(AdInfo.AdTrackInfo.class, new ac());
        XD.put(SDKInitMsg.class, new et());
        XD.put(com.kwad.sdk.core.network.j.class, new dq());
        XD.put(com.kwad.sdk.internal.api.b.class, new fe());
        XD.put(AdMatrixInfo.ActionBarInfoNew.class, new c());
        XD.put(AdStyleInfo.PlayEndInfo.class, new ef());
        XD.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new bv());
        XD.put(AdMatrixInfo.BaseMatrixTemplate.class, new ao());
        XD.put(AdInfo.AdInsertScreenInfo.class, new q());
        XD.put(com.kwad.sdk.core.network.k.class, new dr());
        XD.put(AdInfo.AdConversionInfo.class, new j());
        XD.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new dz());
        XD.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new b());
        XD.put(com.kwad.sdk.internal.api.a.class, new s());
        XD.put(AdInfo.DownloadSafeInfo.class, new bq());
        XD.put(AdMatrixInfo.FullScreenInfo.class, new cg());
        XD.put(com.kwad.sdk.utils.a.a.class, new dg());
        XD.put(HybridLoadMsg.class, new cq());
        XD.put(HttpDnsInfo.class, new cp());
        XD.put(AdMatrixInfo.AdDataV2.class, new l());
        XD.put(AdMatrixInfo.ShakeInfo.class, new ev());
        XD.put(PhotoInfo.BaseInfo.class, new an());
        XD.put(AdInfo.AdSplashInfo.class, new y());
        XD.put(AdMatrixInfo.SplashActionBarInfo.class, new fc());
        XD.put(AdInfo.AdAggregateInfo.class, new f());
        XD.put(AdInfo.SmallAppJumpInfo.class, new fa());
        XD.put(AdInfo.AdPreloadInfo.class, new v());
        XD.put(AdStyleInfo.PlayDetailInfo.DrawAdInfo.class, new bt());
        XD.put(AdMatrixInfo.EndCardInfo.class, new bu());
        XD.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new bm());
        XD.put(AdStyleInfo.PlayDetailInfo.PatchEcInfo.class, new ea());
        XD.put(AdInfo.H5Config.class, new ck());
        XD.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new bl());
        XD.put(AdStyleInfo.ExposeTagInfo.class, new bx());
        XD.put(URLPackage.class, new fu());
        XD.put(AdInfo.PlayableStyleInfo.class, new ei());
        XD.put(AdMatrixInfo.MerchantLiveReservationInfo.class, new Cdo());
        XD.put(ABParams.class, new a());
        tl();
    }

    public static com.kwad.sdk.core.d getHolder(Class<? extends com.kwad.sdk.core.response.kwai.a> cls) {
        return XD.get(cls);
    }

    @ForInvoker(methodId = "registerHolder")
    public static void tl() {
        az.tl();
        ba.tl();
        bb.tl();
        bc.tl();
        bd.tl();
        be.tl();
        bf.tl();
        cb.tl();
        cc.tl();
        cd.tl();
        ce.tl();
    }

    public static Map<Class<? extends com.kwad.sdk.core.response.kwai.a>, com.kwad.sdk.core.d> tm() {
        return XD;
    }
}
