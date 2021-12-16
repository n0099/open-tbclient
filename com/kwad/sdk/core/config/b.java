package com.kwad.sdk.core.config;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.core.config.item.AvatarGuiderConfigItem;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.e;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.i;
import com.kwad.sdk.core.config.item.j;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.config.item.m;
import com.kwad.sdk.core.config.item.n;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.config.item.q;
import com.kwad.sdk.core.config.item.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.at;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile SdkConfigData a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f57807b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f57808c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f57809d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f57810e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f57811f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f57812g;

    /* renamed from: h  reason: collision with root package name */
    public static SdkConfigData.TemplateConfig f57813h;

    /* renamed from: i  reason: collision with root package name */
    public static SdkConfigData.TemplateConfig f57814i;

    /* renamed from: j  reason: collision with root package name */
    public static SdkConfigData.TemplateConfig f57815j;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f57816k;
    public static boolean l;
    public static boolean m;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static j A;
        public static j B;
        public static j C;
        public static j D;
        public static j E;
        public static j F;
        public static j G;
        public static j H;
        public static j I;
        public static j J;
        public static j K;
        public static j L;
        public static j M;
        public static j N;
        public static j O;
        public static j P;
        public static j Q;
        public static j R;
        public static j S;
        public static j T;
        public static j U;
        public static j V;
        public static j W;
        public static j X;
        public static j Y;
        public static j Z;
        public static j a;
        public static d aA;
        public static j aB;
        public static j aC;
        public static j aD;
        public static j aE;
        public static j aF;
        public static g aG;
        public static q aH;
        public static q aI;
        public static q aJ;
        public static q aK;
        public static k aL;
        public static r aM;
        public static r aN;
        public static TipsConfigItem aO;
        public static m aP;
        public static o aQ;
        public static com.kwad.sdk.core.config.item.c aR;
        public static AvatarGuiderConfigItem aS;
        public static InstallActivateReminderConfigItem aT;
        public static n aU;
        public static j aV;
        public static e aW;
        public static p aX;
        public static j aY;
        public static j aZ;
        public static j aa;
        public static j ab;
        public static j ac;
        public static j ad;
        public static j ae;
        public static j af;
        public static j ag;
        public static j ah;
        public static j ai;
        public static j aj;
        public static l ak;
        public static l al;
        public static l am;
        public static l an;
        public static d ao;
        public static d ap;
        public static d aq;
        public static d ar;
        public static d as;
        public static d at;
        public static d au;
        public static d av;
        public static d aw;
        public static d ax;
        public static d ay;
        public static d az;

        /* renamed from: b  reason: collision with root package name */
        public static j f57820b;
        public static j bA;
        public static j bB;
        public static j bC;
        public static d bD;
        public static j bE;
        public static j bF;
        public static q bG;
        public static q bH;
        public static q bI;
        public static q bJ;
        public static j bK;
        public static j bL;
        public static j bM;
        public static j bN;
        public static d bO;
        public static h bP;
        public static j bQ;
        public static q bR;
        public static j bS;
        public static j bT;
        public static j bU;
        public static q bV;
        public static j bW;
        public static f bX;
        public static j bY;
        public static j bZ;
        public static j ba;
        public static j bb;
        public static j bc;
        public static j bd;
        public static j be;
        public static j bf;
        public static j bg;
        public static j bh;
        public static j bi;
        public static j bj;
        public static j bk;
        public static i bl;
        public static j bm;
        public static j bn;
        public static j bo;
        public static j bp;
        public static j bq;
        public static j br;
        public static j bs;
        public static q bt;
        public static q bu;
        public static q bv;
        public static j bw;
        public static j bx;
        public static j by;
        public static j bz;

        /* renamed from: c  reason: collision with root package name */
        public static j f57821c;
        public static j cA;
        public static j cB;
        public static j ca;
        public static q cb;
        public static q cc;
        public static d cd;
        public static j ce;
        public static j cf;
        public static j cg;
        public static g ch;
        public static g ci;
        public static j cj;
        public static q ck;
        public static d cl;
        public static j cm;

        /* renamed from: cn  reason: collision with root package name */
        public static j f57822cn;
        public static q co;
        public static q cp;
        public static q cq;
        public static q cr;
        public static q cs;
        public static q ct;
        public static d cu;
        public static j cv;
        public static j cw;
        public static j cx;
        public static j cy;
        public static j cz;

        /* renamed from: d  reason: collision with root package name */
        public static j f57823d;

        /* renamed from: e  reason: collision with root package name */
        public static j f57824e;

        /* renamed from: f  reason: collision with root package name */
        public static j f57825f;

        /* renamed from: g  reason: collision with root package name */
        public static j f57826g;

        /* renamed from: h  reason: collision with root package name */
        public static j f57827h;

        /* renamed from: i  reason: collision with root package name */
        public static j f57828i;

        /* renamed from: j  reason: collision with root package name */
        public static j f57829j;

        /* renamed from: k  reason: collision with root package name */
        public static j f57830k;
        public static j l;
        public static j m;
        public static j n;
        public static j o;
        public static j p;
        public static j q;
        public static j r;
        public static j s;
        public static j t;
        public static j u;
        public static j v;
        public static j w;
        public static j x;
        public static j y;
        public static j z;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1487046804, "Lcom/kwad/sdk/core/config/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1487046804, "Lcom/kwad/sdk/core/config/b$a;");
                    return;
                }
            }
            a = new j("ecKwaiBtnSwitch", 1);
            f57820b = new j("fitNavigationBarSwitch", 1);
            f57821c = new j("ecTopJumpToKwai", 1);
            f57823d = new j("toolbarSwitch", 1);
            f57824e = new j("likeButtonSwitch", 1);
            f57825f = new j("moreButtonSwitch", 1);
            f57826g = new j("commentButtonSwitch", 1);
            f57827h = new j("seekBarSwitch", 59);
            f57828i = new j("videoCacheSwitch", 0);
            f57829j = new j("trendDynamicEffect", 0);
            f57830k = new j("homePlaySpeedTime", 90);
            l = new j("homePlayCompleteType", 0);
            m = new j("replayTubeEpisode", 0);
            n = new j("batchReportCatchLimit", 20);
            o = new j("preloadSwitch", 1);
            p = new j("rewardTopBarNewStyle", 0);
            q = new j("convertEnableStrongPatch", 0);
            r = new j("liveSwitch", 0);
            s = new j("showAdComment", 0);
            t = new j("authorProfileSwitch", 1);
            u = new j("exceptionCollectorSwitch", 1);
            v = new j("mediaPlayerLogReport", 0);
            w = new j("slideLeftSwitch", 0);
            x = new j("tabRefresh", 0);
            y = new j("backRefreshSwitch", 0);
            z = new j("mobileNetTipSwitch", 0);
            A = new j("relatedSwitch", 0);
            B = new j("closeDelaySeconds", 0);
            C = new j("bannerAdGapTime", 60);
            D = new j("bannerAdShowCount", 3);
            E = new j("rewardFullClickSwitch", 0);
            F = new j("didCopySwitch", 1);
            G = new j("slideCoverSwitch", 0);
            H = new j("profileAdSwitch", 0);
            I = new j("mediaControlPlaySwitch", 1);
            J = new j("entrySwipeJumpIndex", 4);
            K = new j("mediaPlayerActionSwitch", 0);
            L = new j("showBlurBackground", 0);
            M = new j("enableHodor", 0);
            N = new j("preloadVideoCache", 0);
            O = new j("formAdExitInterceptSwitch", 0);
            P = new j("adLeaveConfirmSwitch", 0);
            Q = new j("dynamicPicAdRewardSwitch", 0);
            R = new j("adFrontPageSwitch", 0);
            S = new j("entryGifFullShowAnimation", 0);
            T = new j("aggregatePageStyle", 0);
            U = new j("speedLimitSwitch", 1);
            V = new j("remindInstallActivateSwitch", 0);
            W = new j("enableMultiVideoCoding", 0);
            X = new j("speedLimitThreshold", 200);
            Y = new j("splashTimeOutMilliSecond", 5000);
            Z = new j("middleEndcardShowTime", 0);
            aa = new j("guideStyle", 0);
            ab = new j("dynamicFirstAppearPos", 2);
            ac = new j("dynamicAppearGapPos", 3);
            ad = new j("backPatchIntervalMills", 10000);
            ae = new j("avatarGuiderSwitch", 1);
            af = new j("patchAdCarouselCount", 5);
            ag = new j("stayBackShowSwitch", 0);
            ah = new j("stayTabShowSwitch", 0);
            ai = new j("stayPlayNextPhoto", 0);
            aj = new j("stayRealShowCount", 1);
            ak = new l("stayShowInterval", 30000L);
            al = new l("guideShowTime", 5000L);
            am = new l("deviceInfoDisableConfig", 0L);
            an = new l("validClickConvertTime", 1000L);
            ao = new d("playerEnable", false);
            ap = new d("dynamicEnable", false);
            aq = new d("emotionEnable", true);
            ar = new d("entryConvButtonAnimSwitch", false);
            as = new d("patchAdCarouselSwitch", false);
            at = new d("entryCoverConvertSwitch", false);
            au = new d("couponActiveEnable", false);
            av = new d("drawAdPlayEndToNextVideo", false);
            aw = new d("drawAdPlayEndToWebPage", false);
            ax = new d("drawAdPlayEndToNextVideoFirst", false);
            ay = new d("forceGetAudioFocus", false);
            az = new d("dataFlowAutoStartSwitch", false);
            aA = new d("interstitialAutoStartSwitch", false);
            aB = new j("interstitialStyle", 0);
            aC = new j("interstitialAdSkipCloseType", 0);
            aD = new j("interstitialAdSkipCloseArea", 0);
            aE = new j("interstitialPlayableTime", 999);
            aF = new j("insertScreenAdAutoCloseTime", 0);
            aG = new g("homePlaySpeed", 0.0f);
            aH = new q("webpSoUrlV7a", "");
            aI = new q("webpSoUrlV8a", "");
            aJ = new q("tkSoUrlV7a", "");
            aK = new q("tkSoUrlV8a", "");
            aL = new k("playerConfig", null);
            aM = new r("pkgNameList", new ArrayList(0));
            aN = new r("hostList", new ArrayList(0));
            aO = new TipsConfigItem();
            aP = new m();
            aQ = new o();
            aR = new com.kwad.sdk.core.config.item.c();
            aS = new AvatarGuiderConfigItem();
            aT = new InstallActivateReminderConfigItem();
            aU = new n("realtimeReportActions", "");
            aV = new j("mediaShareButtonSwitch", 0);
            aW = new e("mediaShareButton", "私信好友");
            aX = new p();
            aY = new j("rewardAdVideoPreCacheSize", 800);
            aZ = new j("playableCloseSeconds", 0);
            ba = new j("playableAutoPlayEnable", 1);
            bb = new j("horizontalAutoPlayEnable", 0);
            bc = new j("horizontalAutoPlayNextEnable", 0);
            bd = new j("hybridEnable", 1);
            be = new j("formAdLeftSlideSwitch", 0);
            bf = new j("preloadPhotoShareSwitch", 1);
            bg = new j("forceActivateAfterInstalled", 0);
            bh = new j("appInstallNoticeSecond", 0);
            bi = new j("watermarkKwaiIdSwitch", 0);
            bj = new j("insertScreenV2Switch", 0);
            bk = new j("insertScreenAutoPlaySwitch", 0);
            bl = new i("insertScreenV2ShowConfig");
            bm = new j("entrySwipeStyle", 0);
            bn = new j("entrySwipeInteraction", 0);
            bo = new j("environmentDetectEnable", 0);
            bp = new j("simCardInfoEnable", 0);
            bq = new j("baseStationEnable", 0);
            br = new j("sensorEventEnable", 0);
            bs = new j("sensorEventEnable2", 0);
            bt = new q("fullscreenSkipTips", "");
            bu = new q("h5PreloadActionPercent", "");
            bv = new q("rewardSkipTips", "");
            bw = new j("fullscreenSkipType", 0);
            bx = new j("rewardSkipConfirmSwitch", 1);
            by = new j("shieldAuthorSwitch", 0);
            bz = new j("fullscreenSkipShowTime", 5);
            bA = new j("rewardSkipType", 0);
            bB = new j("lpAutoDownloadApkSwitch", 1);
            bC = new j("autoDownloadUrlSwitch", 0);
            bD = new d("refreshEntryPhotoSwitch", true);
            bE = new j("refreshEntryLimit", 5);
            bF = new j("insertScreenAdType", 0);
            bG = new q("relatedTitle", "");
            bH = new q("appStatusSoUrlV7a", "");
            bI = new q("appStatusSoUrlV8a", "");
            bJ = new q("appStatusSoVersion", "");
            bK = new j("appStatusNativeImpl", 1);
            bL = new j("relatedRequestTimes", 0);
            bM = new j("relatedClickJumpMode", 0);
            bN = new j("deeplinkCheckSwitch", -3);
            bO = new d("deeplinkWindowSwitch", false);
            bP = new h();
            bQ = new j("interstitialAdSkipShowTime", 5);
            bR = new q("interstitialAdSkipTips", "跳过");
            bS = new j("interstitialAdSkipType", 0);
            bT = new j("interstitialAdBackPressSwitch", 0);
            bU = new j("interstitialAdFullClick", 1);
            bV = new q("splashVplusEnterHomeTips", "");
            bW = new j("splashVplusEnterHomeSeconds", 0);
            bX = new f("foldItemContent", Double.valueOf(2.0d));
            bY = new j("reEnterItemContentPos", 1);
            bZ = new j("networkRecorderSampling", 100);
            ca = new j("kwaiAppVersionSwitch", 1);
            cb = new q(TTDownloadField.TT_USERAGENT, com.kwad.sdk.core.network.k.b());
            cc = new q("loginUrl", null);
            cd = new d("personalRecommend", false);
            ce = new j("forceActivate", 0);
            cf = new j("remindOpen", -1);
            cg = new j("biddingLogSwitch", 0);
            ch = new g("interactionTimeInRewardedVideo", 0.0f);
            ci = new g("commercialLogReportRate", 0.01f);
            cj = new j("splashVideoDisplaySecond", 5);
            ck = new q("splashTimerTips", "");
            cl = new d("viewVisibleCheckLegacy", false);
            cm = new j("rewardActiveAppTaskMinSecond", 15);
            f57822cn = new j("viewLandingPageTaskDuration", 15);
            co = new q("splashBtnText", "点击跳过详情页或第三方应用");
            cp = new q("kwaiLogoUrl", null);
            cq = new q("attentionTips", "去关注TA");
            cr = new q("viewHomeTips", "查看TA的主页");
            cs = new q("buyNowTips", "立即抢购");
            ct = new q("liveAdActionDesc", "进入直播间购买");
            cu = new d("dispatch_temp_detach", false);
            cv = new j("ecRewardAdOrderSwitch", 0);
            cw = new j("ecRewardAdFanSwitch", 0);
            cx = new j("ecRewardAdOrderColorSwitch", 0);
            cy = new j("ecRewardAdFanColorSwitch", 0);
            cz = new j("interstitialAdClickShutDown", 0);
            cA = new j("xdtCouponShowDuration", 3000);
            cB = new j("shakeCountDaily", 3);
        }

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            }
        }
    }

    public static boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a.W.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.X.a().intValue() : invokeV.intValue;
    }

    public static int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.aY.a().intValue() : invokeV.intValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.O.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.P.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? a.ay.a().booleanValue() : invokeV.booleanValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_KSPLAYER_HODOR");
            return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.M.a().intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public static int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.aZ.a().intValue() : invokeV.intValue;
    }

    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.ba.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.bd.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a.bg.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.bh.a().intValue() : invokeV.intValue;
    }

    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a.bo.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? a.bp.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a.bs.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? a.bw.a().intValue() : invokeV.intValue;
    }

    public static long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? a.bz.a().intValue() * 1000 : invokeV.longValue;
    }

    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? a.bx.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? a.bA.a().intValue() : invokeV.intValue;
    }

    public static String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? a.bt.a() : (String) invokeV.objValue;
    }

    public static String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? a.bu.a() : (String) invokeV.objValue;
    }

    public static String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? a.bv.a() : (String) invokeV.objValue;
    }

    public static boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? a.bq.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? a.an.a().longValue() : invokeV.longValue;
    }

    public static long Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? a.am.a().longValue() : invokeV.longValue;
    }

    public static boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? a.bB.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, adInfo)) == null) {
            int intValue = a.aE.a().intValue();
            if (com.kwad.sdk.core.response.a.a.P(adInfo)) {
                return Math.min(intValue, com.kwad.sdk.core.response.a.a.b(adInfo));
            }
            if (intValue > 60) {
                return 60;
            }
            return intValue;
        }
        return invokeL.intValue;
    }

    public static int a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65563, null, z)) == null) {
            return Color.parseColor(z ? "#FFFF4906" : "#FFFE3666");
        }
        return invokeZ.intValue;
    }

    public static SdkConfigData.TemplateConfig a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? f57807b : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    @WorkerThread
    public static SdkConfigData.TemplateConfig a(Context context, @Nullable SdkConfigData.TemplateConfig templateConfig, @Nullable SdkConfigData.TemplateConfig templateConfig2, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65565, null, context, templateConfig, templateConfig2, str, str2)) == null) {
            if (templateConfig == null) {
                return null;
            }
            boolean exists = a(context, str2).exists();
            if ((templateConfig2 == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(templateConfig2.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, str, str2);
            }
            return templateConfig;
        }
        return (SdkConfigData.TemplateConfig) invokeLLLLL.objValue;
    }

    public static synchronized File a(Context context, String str) {
        InterceptResult invokeLL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, context, str)) == null) {
            synchronized (b.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), str);
            }
            return file;
        }
        return (File) invokeLL.objValue;
    }

    @Nullable
    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, context)) == null) {
            SdkConfigData.TemplateConfig templateConfig = f57815j;
            if (templateConfig != null) {
                return templateConfig.h5Url;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @WorkerThread
    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                if (((f57810e != null && f(context).exists() && (TextUtils.isEmpty(templateConfig.h5Checksum) || templateConfig.h5Checksum.equals(f57810e.h5Checksum))) ? false : true) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_interact_page_dialog_tips_template_config", "interact_page_dialog_tips.html");
                }
            }
            f57810e = templateConfig;
        }
    }

    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65569, null, context, templateConfig, str, str2) == null) {
            com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml preload=" + templateConfig.toJson() + " key=" + str + " fileName=" + str2);
            if (at.a(templateConfig.h5Url)) {
                return;
            }
            com.kwad.sdk.utils.i.a(new Runnable(templateConfig, context, str2, str) { // from class: com.kwad.sdk.core.config.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SdkConfigData.TemplateConfig a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f57817b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f57818c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f57819d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {templateConfig, context, str2, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = templateConfig;
                    this.f57817b = context;
                    this.f57818c = str2;
                    this.f57819d = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str3 = this.a.h5Url;
                        File file = new File(this.f57817b.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE);
                        if (!file.exists() && !file.mkdir()) {
                            com.kwad.sdk.core.d.a.a("SdkConfigManager", "make template cache dir failed");
                            return;
                        }
                        File file2 = new File(file, "cache_" + this.f57818c);
                        if (!com.kwad.sdk.core.diskcache.a.c.a(file2, str3)) {
                            com.kwad.sdk.core.report.d.a(str3, com.ksad.download.c.b.a(this.f57817b) ? "1" : "2");
                            com.kwad.sdk.utils.q.c(file2);
                            return;
                        }
                        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_md5_check");
                        boolean booleanValue = a2 != null ? ((Boolean) a2.getValue()).booleanValue() : true;
                        String b2 = com.kwad.sdk.utils.c.b(file2);
                        if (b2 != null && b2.length() > 10) {
                            b2 = b2.substring(0, 10);
                        }
                        if (booleanValue && !TextUtils.isEmpty(this.a.h5Checksum) && !TextUtils.isEmpty(b2) && !b2.equalsIgnoreCase(this.a.h5Checksum)) {
                            com.kwad.sdk.core.report.d.a(str3, "3");
                            com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml md5 check failed");
                            com.kwad.sdk.utils.q.c(file2);
                            return;
                        }
                        File file3 = new File(file, this.f57818c);
                        if (file3.exists()) {
                            com.kwad.sdk.utils.q.c(file3);
                        }
                        file2.renameTo(new File(file, this.f57818c));
                        this.f57817b.getSharedPreferences(this.f57819d, 0).edit().putString("KEY_TEMPLATE_DATA", this.a.toJson().toString()).apply();
                    }
                }
            });
        }
    }

    public static void a(Context context, SdkConfigData sdkConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, context, sdkConfigData) == null) {
            b(context, sdkConfigData.splashConfig);
            c(context, sdkConfigData.templateConfigMap.downloadPopWindowConfig);
            d(context, sdkConfigData.templateConfigMap.insertScreenTemplateConfig);
            a(context, sdkConfigData.templateConfigMap.interactPageDialogTipsConfig);
            e(context, sdkConfigData.templateConfigMap.couponOpenConfig);
            f(context, sdkConfigData.templateConfigMap.couponInfoConfig);
            f57813h = a(context, sdkConfigData.templateConfigMap.downloadLandingPageConfig, f57813h, "ksadsdk_download_landing_page_config", "download_landing_page.html");
            f57814i = a(context, sdkConfigData.templateConfigMap.secDownloadPopWindowConfig, f57814i, "ksadsdk_sec_download_pop_window_config", "sec_download_pop_window.html");
            f57815j = sdkConfigData.templateConfigMap.rewardReflowConfig;
        }
    }

    public static void a(SdkConfigData sdkConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, sdkConfigData) == null) {
            a = sdkConfigData;
        }
    }

    public static boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65572, null, j2)) == null) ? (j2 & a.am.a().longValue()) != 0 : invokeJ.booleanValue;
    }

    public static int aA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? a.f57822cn.a().intValue() : invokeV.intValue;
    }

    public static String aB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? a.co.a() : (String) invokeV.objValue;
    }

    public static boolean aC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? a.cz.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static String aD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? a.cr.a() : (String) invokeV.objValue;
    }

    public static String aE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? a.cs.a() : (String) invokeV.objValue;
    }

    public static String aF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? a.cp.a() : (String) invokeV.objValue;
    }

    public static String aG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? a.cq.a() : (String) invokeV.objValue;
    }

    public static int aH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            int intValue = a.cw.a().intValue();
            if (intValue != 1) {
                return intValue != 2 ? 0 : 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public static boolean aI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? a.cv.a().intValue() == 1 : invokeV.booleanValue;
    }

    @ColorInt
    public static int aJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            return a(!(a.cy.a().intValue() == 1));
        }
        return invokeV.intValue;
    }

    public static boolean aK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? a.cy.a().intValue() == 1 : invokeV.booleanValue;
    }

    @ColorInt
    public static int aL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            return a(!(a.cx.a().intValue() == 1));
        }
        return invokeV.intValue;
    }

    public static boolean aM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? a.cx.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static long aN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? a.cA.a().intValue() : invokeV.longValue;
    }

    public static int aO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? a.cB.a().intValue() : invokeV.intValue;
    }

    public static SdkConfigData aP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? a : (SdkConfigData) invokeV.objValue;
    }

    public static boolean aa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? a.bC.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static String ab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) ? a.bP.d() : (String) invokeV.objValue;
    }

    public static String ac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? a.bP.e() : (String) invokeV.objValue;
    }

    public static String ad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65592, null)) == null) ? a.bH.a() : (String) invokeV.objValue;
    }

    public static String ae() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65593, null)) == null) ? a.bI.a() : (String) invokeV.objValue;
    }

    public static int af() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? a.bN.a().intValue() : invokeV.intValue;
    }

    public static boolean ag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65595, null)) == null) ? a.bO.a().booleanValue() : invokeV.booleanValue;
    }

    public static String ah() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) ? a.bJ.a() : (String) invokeV.objValue;
    }

    public static boolean ai() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) ? a.bK.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int aj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) ? a.bQ.a().intValue() : invokeV.intValue;
    }

    public static boolean ak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) ? a.bU.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean al() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) ? a.bT.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static String am() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) ? a.bV.a() : (String) invokeV.objValue;
    }

    public static String an() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) ? a.cb.a() : (String) invokeV.objValue;
    }

    public static int ao() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) ? a.bW.a().intValue() : invokeV.intValue;
    }

    public static boolean ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            int intValue = a.bZ.a().intValue();
            if (intValue <= 0) {
                return false;
            }
            if (!l) {
                f57816k = new Random().nextFloat() < 1.0f / ((float) intValue);
                l = true;
            }
            return f57816k;
        }
        return invokeV.booleanValue;
    }

    public static boolean aq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) {
            float floatValue = a.ci.a().floatValue();
            if (floatValue <= 0.0f) {
                return false;
            }
            if (!m) {
                m = true;
                n = new Random().nextFloat() < floatValue;
            }
            return n;
        }
        return invokeV.booleanValue;
    }

    public static boolean ar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) ? a.ca.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int as() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) ? a.cj.a().intValue() : invokeV.intValue;
    }

    public static String at() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) ? a.ck.a() : (String) invokeV.objValue;
    }

    public static boolean au() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) ? a.ce.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int av() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) ? a.cf.a().intValue() : invokeV.intValue;
    }

    public static float aw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) ? a.ch.a().floatValue() : invokeV.floatValue;
    }

    public static boolean ax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) ? a.cg.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean ay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) ? a.cl.a().booleanValue() : invokeV.booleanValue;
    }

    public static int az() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) ? a.cm.a().intValue() : invokeV.intValue;
    }

    public static SdkConfigData.TemplateConfig b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65615, null, context, str)) == null) {
            SdkConfigData.TemplateConfig templateConfig = new SdkConfigData.TemplateConfig();
            String string = context.getSharedPreferences(str, 0).getString("KEY_TEMPLATE_DATA", "");
            if (!at.a(string)) {
                try {
                    templateConfig.parseJson(new JSONObject(string));
                } catch (JSONException unused) {
                }
            }
            return templateConfig;
        }
        return (SdkConfigData.TemplateConfig) invokeLL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) {
            SdkConfigData.TemplateConfig templateConfig = f57814i;
            return templateConfig != null ? templateConfig.h5Url : "";
        }
        return (String) invokeV.objValue;
    }

    @WorkerThread
    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65617, null, context) == null) {
            com.kwad.sdk.core.d.a.a("SdkConfigManager", "load");
            a.a();
            com.kwad.sdk.core.config.a.b(context);
            f57807b = b(context, "ksadsdk_splash_template_config");
            f57808c = b(context, "ksadsdk_download_pop_window_config");
            f57809d = b(context, "ksadsdk_insert_screen_config");
            f57810e = b(context, "ksadsdk_interact_page_dialog_tips_template_config");
            f57811f = b(context, "ksadsdk_coupon_open_config");
            f57812g = b(context, "ksadsdk_coupon_info_config");
            f57813h = b(context, "ksadsdk_download_landing_page_config");
            f57814i = b(context, "ksadsdk_sec_download_pop_window_config");
            f57815j = b(context, "ksadsdk_reward_reflow_config");
        }
    }

    @WorkerThread
    public static void b(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65618, null, context, templateConfig) == null) {
            if (templateConfig != null && ((f57807b == null || !e(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f57807b.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
                a(context, templateConfig, "ksadsdk_splash_template_config", "feed_splash.html");
            }
            f57807b = templateConfig;
        }
    }

    public static SdkConfigData.TemplateConfig c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65619, null)) == null) ? f57808c : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File c(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65620, null, context)) == null) {
            synchronized (b.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "pop_wind.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void c(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65621, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = c(context).exists();
                if ((f57808c == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f57808c.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_download_pop_window_config", "pop_wind.html");
                }
            }
            f57808c = templateConfig;
        }
    }

    public static synchronized File d(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65622, null, context)) == null) {
            synchronized (b.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "insert_screen.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65623, null)) == null) {
            if (f57810e != null) {
                return f57810e.h5Url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @WorkerThread
    public static void d(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65624, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = d(context).exists();
                if ((f57809d == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f57809d.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_insert_screen_config", "insert_screen.html");
                }
            }
            f57809d = templateConfig;
        }
    }

    public static SdkConfigData.TemplateConfig e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) ? f57813h : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File e(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65626, null, context)) == null) {
            synchronized (b.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "feed_splash.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void e(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65627, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = g(context).exists();
                if ((f57811f == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f57811f.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_coupon_open_config", "coupon_open.html");
                }
            }
            f57811f = templateConfig;
        }
    }

    public static synchronized File f(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65628, null, context)) == null) {
            synchronized (b.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "interact_page_dialog_tips.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static List<String> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) ? a.aM.a() : (List) invokeV.objValue;
    }

    @WorkerThread
    public static void f(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65630, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = h(context).exists();
                if ((f57812g == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f57812g.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_coupon_info_config", "coupon_info.html");
                    c.a().a(templateConfig.h5Url, "coupon_info.html");
                }
            }
            f57812g = templateConfig;
        }
    }

    public static synchronized File g(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65631, null, context)) == null) {
            synchronized (b.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "coupon_open.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) ? a.aL.a() : (String) invokeV.objValue;
    }

    public static synchronized File h(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65633, null, context)) == null) {
            synchronized (b.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "coupon_info.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65634, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65635, null)) == null) {
            int intValue = a.Y.a().intValue();
            if (intValue > 0) {
                return intValue;
            }
            return 5000;
        }
        return invokeV.intValue;
    }

    public static synchronized File i(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65636, null, context)) == null) {
            synchronized (b.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "download_landing_page.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static int j() {
        InterceptResult invokeV;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65637, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_BATCH_MAXNUM");
            return (a2 == null || (num = (Integer) a2.getValue()) == null) ? a.n.a().intValue() : num.intValue();
        }
        return invokeV.intValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65638, null)) == null) ? a.p.a().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65639, null)) == null) ? a.u.a().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65640, null)) == null) ? a.v.a().intValue() == 0 : invokeV.booleanValue;
    }

    public static boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65641, null)) == null) ? a.ap.a().booleanValue() : invokeV.booleanValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65642, null)) == null) ? a.az.a().booleanValue() : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65643, null)) == null) ? a.aA.a().booleanValue() : invokeV.booleanValue;
    }

    public static int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65644, null)) == null) ? a.aB.a().intValue() : invokeV.intValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65645, null)) == null) ? a.aC.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65646, null)) == null) ? a.aD.a().intValue() : invokeV.intValue;
    }

    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65647, null)) == null) ? a.B.a().intValue() : invokeV.intValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65648, null)) == null) ? a.K.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65649, null)) == null) ? a.aH.a() : (String) invokeV.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65650, null)) == null) ? a.aI.a() : (String) invokeV.objValue;
    }

    public static String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65651, null)) == null) ? a.aJ.a() : (String) invokeV.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65652, null)) == null) ? a.aK.a() : (String) invokeV.objValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65653, null)) == null) ? a.U.a().intValue() == 1 : invokeV.booleanValue;
    }
}
