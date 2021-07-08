package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.AvatarGuiderConfigItem;
import com.kwad.sdk.core.config.item.InsertScreenConfigItem;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.TipsConfigItem;
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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.an;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile SdkConfigData f34174a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f34175b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f34176c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f34177d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f34178e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f34179f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f34180g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f34181h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f34182i;
    public static volatile SdkConfigData.TemplateConfig j;
    public static volatile SdkConfigData.TemplateConfig k;
    public static volatile SdkConfigData.TemplateConfig l;
    public static boolean m;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static i A;
        public static i B;
        public static i C;
        public static i D;
        public static i E;
        public static i F;
        public static i G;
        public static i H;
        public static i I;
        public static i J;
        public static i K;
        public static i L;
        public static i M;
        public static i N;
        public static i O;
        public static i P;
        public static i Q;
        public static i R;
        public static i S;
        public static i T;
        public static i U;
        public static i V;
        public static i W;
        public static i X;
        public static i Y;
        public static i Z;

        /* renamed from: a  reason: collision with root package name */
        public static i f34187a;
        public static InstallActivateReminderConfigItem aA;
        public static m aB;
        public static i aC;
        public static e aD;
        public static o aE;
        public static i aF;
        public static i aG;
        public static i aH;
        public static i aI;
        public static i aJ;
        public static i aK;
        public static i aL;
        public static i aM;
        public static i aN;
        public static InsertScreenConfigItem aO;
        public static i aP;
        public static i aQ;
        public static i aR;
        public static i aS;
        public static i aT;
        public static i aU;
        public static i aV;
        public static p aW;
        public static p aX;
        public static i aY;
        public static i aZ;
        public static k aa;
        public static k ab;
        public static com.kwad.sdk.core.config.item.d ac;
        public static com.kwad.sdk.core.config.item.d ad;
        public static com.kwad.sdk.core.config.item.d ae;
        public static com.kwad.sdk.core.config.item.d af;
        public static com.kwad.sdk.core.config.item.d ag;
        public static com.kwad.sdk.core.config.item.d ah;
        public static com.kwad.sdk.core.config.item.d ai;
        public static com.kwad.sdk.core.config.item.d aj;
        public static com.kwad.sdk.core.config.item.d ak;
        public static com.kwad.sdk.core.config.item.d al;
        public static com.kwad.sdk.core.config.item.d am;
        public static g an;
        public static p ao;
        public static p ap;
        public static p aq;
        public static p ar;
        public static j as;
        public static q at;
        public static q au;
        public static TipsConfigItem av;
        public static l aw;
        public static n ax;
        public static com.kwad.sdk.core.config.item.c ay;
        public static AvatarGuiderConfigItem az;

        /* renamed from: b  reason: collision with root package name */
        public static i f34188b;
        public static i bA;
        public static i bB;
        public static i bC;
        public static p bD;
        public static i bE;
        public static com.kwad.sdk.core.config.item.d bF;
        public static i ba;
        public static i bb;
        public static i bc;
        public static i bd;
        public static com.kwad.sdk.core.config.item.d be;
        public static i bf;
        public static p bg;
        public static p bh;
        public static p bi;
        public static p bj;
        public static i bk;
        public static i bl;
        public static i bm;
        public static h bn;
        public static i bo;
        public static p bp;
        public static i bq;
        public static i br;
        public static i bs;
        public static p bt;
        public static i bu;
        public static f bv;
        public static i bw;
        public static i bx;
        public static p by;
        public static com.kwad.sdk.core.config.item.d bz;

        /* renamed from: c  reason: collision with root package name */
        public static i f34189c;

        /* renamed from: d  reason: collision with root package name */
        public static i f34190d;

        /* renamed from: e  reason: collision with root package name */
        public static i f34191e;

        /* renamed from: f  reason: collision with root package name */
        public static i f34192f;

        /* renamed from: g  reason: collision with root package name */
        public static i f34193g;

        /* renamed from: h  reason: collision with root package name */
        public static i f34194h;

        /* renamed from: i  reason: collision with root package name */
        public static i f34195i;
        public static i j;
        public static i k;
        public static i l;
        public static i m;
        public static i n;
        public static i o;
        public static i p;
        public static i q;
        public static i r;
        public static i s;
        public static i t;
        public static i u;
        public static i v;
        public static i w;
        public static i x;
        public static i y;
        public static i z;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1487076595, "Lcom/kwad/sdk/core/config/c$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1487076595, "Lcom/kwad/sdk/core/config/c$a;");
                    return;
                }
            }
            f34187a = new i("fitNavigationBarSwitch", 1);
            f34188b = new i("toolbarSwitch", 1);
            f34189c = new i("likeButtonSwitch", 1);
            f34190d = new i("moreButtonSwitch", 1);
            f34191e = new i("commentButtonSwitch", 1);
            f34192f = new i("seekBarSwitch", 59);
            f34193g = new i("videoCacheSwitch", 0);
            f34194h = new i("trendDynamicEffect", 0);
            f34195i = new i("homePlaySpeedTime", 90);
            j = new i("homePlayCompleteType", 0);
            k = new i("replayTubeEpisode", 0);
            l = new i("batchReportCatchLimit", 20);
            m = new i("preloadSwitch", 1);
            n = new i("rewardTopBarNewStyle", 0);
            o = new i("convertEnableStrongPatch", 0);
            p = new i("liveSwitch", 0);
            q = new i("showAdComment", 0);
            r = new i("authorProfileSwitch", 1);
            s = new i("exceptionCollectorSwitch", 1);
            t = new i("mediaPlayerLogReport", 0);
            u = new i("slideLeftSwitch", 0);
            v = new i("tabRefresh", 0);
            w = new i("backRefreshSwitch", 0);
            x = new i("mobileNetTipSwitch", 0);
            y = new i("relatedSwitch", 0);
            z = new i("closeDelaySeconds", 0);
            A = new i("bannerAdAppearTimes", 0);
            B = new i("rewardFullClickSwitch", 0);
            C = new i("didCopySwitch", 1);
            D = new i("slideCoverSwitch", 0);
            E = new i("profileAdSwitch", 0);
            F = new i("mediaControlPlaySwitch", 1);
            G = new i("entrySwipeJumpIndex", 4);
            H = new i("mediaPlayerActionSwitch", 0);
            I = new i("showBlurBackground", 0);
            J = new i("enableHodor", 0);
            K = new i("preloadVideoCache", 0);
            L = new i("formAdExitInterceptSwitch", 0);
            M = new i("adLeaveConfirmSwitch", 0);
            N = new i("adFrontPageSwitch", 0);
            O = new i("entryGifFullShowAnimation", 0);
            P = new i("speedLimitSwitch", 1);
            Q = new i("remindInstallActivateSwitch", 0);
            R = new i("enableMultiVideoCoding", 0);
            S = new i("speedLimitThreshold", 200);
            T = new i("splashTimeOutMilliSecond", 5000);
            U = new i("middleEndcardShowTime", 0);
            V = new i("guideStyle", 0);
            W = new i("dynamicFirstAppearPos", 2);
            X = new i("dynamicAppearGapPos", 3);
            Y = new i("backPatchIntervalMills", 10000);
            Z = new i("avatarGuiderSwitch", 1);
            aa = new k("guideShowTime", 5000L);
            ab = new k("deviceInfoDisableConfig", 0L);
            ac = new com.kwad.sdk.core.config.item.d("playerEnable", false);
            ad = new com.kwad.sdk.core.config.item.d("dynamicEnable", false);
            ae = new com.kwad.sdk.core.config.item.d("emotionEnable", true);
            af = new com.kwad.sdk.core.config.item.d("entryConvButtonAnimSwitch", false);
            ag = new com.kwad.sdk.core.config.item.d("entryCoverConvertSwitch", false);
            ah = new com.kwad.sdk.core.config.item.d("couponActiveEnable", false);
            ai = new com.kwad.sdk.core.config.item.d("aggregateAdOpen", false);
            aj = new com.kwad.sdk.core.config.item.d("drawAdPlayEndToNextVideo", false);
            ak = new com.kwad.sdk.core.config.item.d("drawAdPlayEndToWebPage", false);
            al = new com.kwad.sdk.core.config.item.d("drawAdPlayEndToNextVideoFirst", false);
            am = new com.kwad.sdk.core.config.item.d("dataFlowAutoStartSwitch", false);
            an = new g("homePlaySpeed", 0.0f);
            ao = new p("webpSoUrlV7a", "");
            ap = new p("webpSoUrlV8a", "");
            aq = new p("tkSoUrlV7a", "");
            ar = new p("tkSoUrlV8a", "");
            as = new j("playerConfig", null);
            at = new q("pkgNameList", new ArrayList(0));
            au = new q("hostList", new ArrayList(0));
            av = new TipsConfigItem();
            aw = new l();
            ax = new n();
            ay = new com.kwad.sdk.core.config.item.c();
            az = new AvatarGuiderConfigItem();
            aA = new InstallActivateReminderConfigItem();
            aB = new m("realtimeReportActions", "");
            aC = new i("mediaShareButtonSwitch", 0);
            aD = new e("mediaShareButton", "私信好友");
            aE = new o();
            aF = new i("rewardAdVideoPreCacheSize", 800);
            aG = new i("playableCloseSeconds", 0);
            aH = new i("playableAutoPlayEnable", 1);
            aI = new i("formAdLeftSlideSwitch", 0);
            aJ = new i("preloadPhotoShareSwitch", 1);
            aK = new i("forceActivateAfterInstalled", 0);
            aL = new i("splashFullClickSwitch", 1);
            aM = new i("appInstallNoticeSecond", 0);
            aN = new i("watermarkKwaiIdSwitch", 0);
            aO = new InsertScreenConfigItem();
            aP = new i("entrySwipeStyle", 0);
            aQ = new i("entrySwipeInteraction", 0);
            aR = new i("environmentDetectEnable", 0);
            aS = new i("simCardInfoEnable", 0);
            aT = new i("baseStationEnable", 0);
            aU = new i("sensorEventEnable", 0);
            aV = new i("sensorEventEnable2", 0);
            aW = new p("fullscreenSkipTips", "");
            aX = new p("rewardSkipTips", "");
            aY = new i("fullscreenSkipType", 0);
            aZ = new i("rewardSkipShowTime", 5);
            ba = new i("fullscreenSkipShowTime", 5);
            bb = new i("rewardSkipType", 0);
            bc = new i("lpAutoDownloadApkSwitch", 1);
            bd = new i("autoDownloadUrlSwitch", 0);
            be = new com.kwad.sdk.core.config.item.d("refreshEntryPhotoSwitch", true);
            bf = new i("refreshEntryLimit", 5);
            bg = new p("relatedTitle", "");
            bh = new p("appStatusSoUrlV7a", "");
            bi = new p("appStatusSoUrlV8a", "");
            bj = new p("appStatusSoVersion", "");
            bk = new i("appStatusNativeImpl", 1);
            bl = new i("relatedRequestTimes", 0);
            bm = new i("relatedClickJumpMode", 0);
            bn = new h();
            bo = new i("interstitialAdSkipShowTime", 5);
            bp = new p("interstitialAdSkipTips", "跳过");
            bq = new i("interstitialAdSkipType", 0);
            br = new i("interstitialAdBackPressSwitch", 0);
            bs = new i("interstitialAdFullClick", 1);
            bt = new p("splashVplusEnterHomeTips", "");
            bu = new i("splashVplusEnterHomeSeconds", 0);
            bv = new f("foldItemContent", Double.valueOf(2.0d));
            bw = new i("reEnterItemContentPos", 1);
            bx = new i("networkRecorderSampling", 100);
            by = new p("loginUrl", null);
            bz = new com.kwad.sdk.core.config.item.d("personalRecommend", false);
            bA = new i("forceActivate", 0);
            bB = new i("remindOpen", -1);
            bC = new i("splashVideoDisplaySecond", 5);
            bD = new p("splashTimerTips", "倒计时");
            bE = new i("rewardVerifyMinDuration", 30);
            bF = new com.kwad.sdk.core.config.item.d("viewVisibleCheckLegacy", false);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a.R.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.S.a().intValue() : invokeV.intValue;
    }

    public static int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.aF.a().intValue() : invokeV.intValue;
    }

    public static boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.L.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.M.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_KSPLAYER_HODOR");
            return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.J.a().intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public static int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? a.aG.a().intValue() : invokeV.intValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.aH.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.aK.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? a.aL.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a.aM.a().intValue() : invokeV.intValue;
    }

    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.aR.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? a.aS.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? a.aV.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a.aY.a().intValue() : invokeV.intValue;
    }

    public static long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? a.ba.a().intValue() * 1000 : invokeV.longValue;
    }

    public static long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? a.aZ.a().intValue() * 1000 : invokeV.longValue;
    }

    public static int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? a.bb.a().intValue() : invokeV.intValue;
    }

    public static String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? a.aW.a() : (String) invokeV.objValue;
    }

    public static String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? a.aX.a() : (String) invokeV.objValue;
    }

    public static boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? a.aT.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? a.bc.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? a.bd.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? a.bn.d() : (String) invokeV.objValue;
    }

    public static String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? a.bn.e() : (String) invokeV.objValue;
    }

    public static String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? a.bh.a() : (String) invokeV.objValue;
    }

    public static SdkConfigData.TemplateConfig a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) ? f34175b : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static SdkConfigData.TemplateConfig a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, str)) == null) {
            SdkConfigData.TemplateConfig templateConfig = new SdkConfigData.TemplateConfig();
            String string = context.getSharedPreferences(str, 0).getString("KEY_TEMPLATE_DATA", "");
            if (!an.a(string)) {
                try {
                    templateConfig.parseJson(new JSONObject(string));
                } catch (JSONException unused) {
                }
            }
            return templateConfig;
        }
        return (SdkConfigData.TemplateConfig) invokeLL.objValue;
    }

    @WorkerThread
    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, context) == null) {
            com.kwad.sdk.core.d.a.a("SdkConfigManager", "load");
            a.a();
            b.b(context);
            f34175b = a(context, "ksadsdk_template_config");
            f34176c = a(context, "ksadsdk_splash_template_config");
            f34177d = a(context, "ksadsdk_mini_card_template_config");
            f34180g = a(context, "ksadsdk_interact_page_template_config");
        }
    }

    @WorkerThread
    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65565, null, context, templateConfig) == null) || templateConfig == null) {
            return;
        }
        if ((l == null || !h(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(l.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
            a(context, templateConfig, "ksadsdk_reward_middle_endcard_template_config", "reward_middle_endcard.html");
        }
        l = templateConfig;
    }

    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65566, null, context, templateConfig, str, str2) == null) {
            com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml preload=" + templateConfig.toJson() + " key=" + str + " fileName=" + str2);
            if (an.a(templateConfig.h5Url)) {
                return;
            }
            com.kwad.sdk.utils.g.a(new Runnable(templateConfig, context, str2, str) { // from class: com.kwad.sdk.core.config.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SdkConfigData.TemplateConfig f34183a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f34184b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f34185c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f34186d;

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
                    this.f34183a = templateConfig;
                    this.f34184b = context;
                    this.f34185c = str2;
                    this.f34186d = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str3 = this.f34183a.h5Url;
                        File file = new File(this.f34184b.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE);
                        if (!file.exists() && !file.mkdir()) {
                            com.kwad.sdk.core.d.a.a("SdkConfigManager", "make template cache dir failed");
                            return;
                        }
                        File file2 = new File(file, "cache_" + this.f34185c);
                        if (!com.kwad.sdk.core.diskcache.b.c.a(file2, str3)) {
                            com.kwad.sdk.core.report.d.a(str3, com.ksad.download.d.b.a(this.f34184b) ? "1" : "2");
                            return;
                        }
                        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_md5_check");
                        boolean booleanValue = a2 != null ? ((Boolean) a2.getValue()).booleanValue() : false;
                        String b2 = com.kwad.sdk.utils.c.b(file2);
                        if (!booleanValue) {
                            if (TextUtils.isEmpty(this.f34183a.h5Checksum)) {
                                return;
                            }
                            if (b2 != null && b2.length() > 10) {
                                String substring = b2.substring(0, 10);
                                com.kwad.sdk.core.d.a.a("SdkConfigManager", "file_md5 =  " + substring + "; server_md5 =  " + this.f34183a.h5Checksum);
                                if (!substring.equalsIgnoreCase(this.f34183a.h5Checksum)) {
                                    com.kwad.sdk.core.report.d.a(str3, "3");
                                    com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml md5 check failed");
                                    return;
                                }
                            }
                        }
                        com.kwad.sdk.core.diskcache.b.c.a(file2, new File(file, this.f34185c));
                        this.f34184b.getSharedPreferences(this.f34186d, 0).edit().putString("KEY_TEMPLATE_DATA", this.f34183a.toJson().toString()).apply();
                    }
                }
            });
        }
    }

    public static void a(Context context, SdkConfigData sdkConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, context, sdkConfigData) == null) {
            d(context, sdkConfigData.templateConfig);
            e(context, sdkConfigData.splashConfig);
            f(context, sdkConfigData.rewardMiniCardConfig);
            g(context, sdkConfigData.templateConfigMap.downloadPopWindowConfig);
            h(context, sdkConfigData.templateConfigMap.insertScreenTemplateConfig);
            i(context, sdkConfigData.templateConfigMap.interstitialAdConfig);
            a(context, sdkConfigData.rewardMiddleEndcardConfig);
            b(context, sdkConfigData.templateConfigMap.interactPageConfig);
            c(context, sdkConfigData.templateConfigMap.interactPageDialogTipsConfig);
            j(context, sdkConfigData.templateConfigMap.couponOpenConfig);
            k(context, sdkConfigData.templateConfigMap.couponInfoConfig);
        }
    }

    public static void a(SdkConfigData sdkConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, sdkConfigData) == null) {
            f34174a = sdkConfigData;
        }
    }

    public static boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65569, null, j2)) == null) ? (j2 & a.ab.a().longValue()) != 0 : invokeJ.booleanValue;
    }

    public static boolean a(AdInfo adInfo, Context context) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65570, null, adInfo, context)) == null) {
            if (com.kwad.sdk.core.response.b.a.N(adInfo) > 0 && com.kwad.sdk.core.response.b.a.N(adInfo) <= com.kwad.sdk.core.response.b.a.b(adInfo)) {
                return !com.kwad.sdk.core.response.b.a.a(adInfo, context) && (com.kwad.sdk.core.response.b.a.e(adInfo) > com.kwad.sdk.core.response.b.a.d(adInfo)) && ab.e(context);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String aa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? a.bi.a() : (String) invokeV.objValue;
    }

    public static String ab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? a.bj.a() : (String) invokeV.objValue;
    }

    public static boolean ac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? a.bk.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int ad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? a.bo.a().intValue() : invokeV.intValue;
    }

    public static String ae() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? a.bp.a() : (String) invokeV.objValue;
    }

    public static boolean af() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? a.bs.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean ag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? a.br.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static String ah() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? a.bt.a() : (String) invokeV.objValue;
    }

    public static int ai() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? a.bu.a().intValue() : invokeV.intValue;
    }

    public static boolean aj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            int intValue = a.bx.a().intValue();
            if (intValue <= 0) {
                return false;
            }
            if (!n) {
                m = new Random().nextFloat() < 1.0f / ((float) intValue);
                n = true;
            }
            return m;
        }
        return invokeV.booleanValue;
    }

    public static int ak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? a.bC.a().intValue() : invokeV.intValue;
    }

    public static String al() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            String a2 = a.bD.a();
            return an.a(a2) ? "倒计时" : a2;
        }
        return (String) invokeV.objValue;
    }

    public static boolean am() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? a.bA.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static int an() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? a.bB.a().intValue() : invokeV.intValue;
    }

    public static int ao() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? a.bE.a().intValue() : invokeV.intValue;
    }

    public static boolean ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? a.bF.a().booleanValue() : invokeV.booleanValue;
    }

    public static SdkConfigData aq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) ? f34174a : (SdkConfigData) invokeV.objValue;
    }

    public static SdkConfigData.TemplateConfig b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? f34176c : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File b(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "pop_wind.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void b(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65590, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                if (((f34180g != null && i(context).exists() && (TextUtils.isEmpty(templateConfig.h5Checksum) || templateConfig.h5Checksum.equals(f34180g.h5Checksum))) ? false : true) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_interact_page_template_config", "interact_page.html");
                }
            }
            f34180g = templateConfig;
        }
    }

    public static SdkConfigData.TemplateConfig c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? f34177d != null ? f34177d : new SdkConfigData.TemplateConfig() : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File c(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "insert_screen.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void c(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65593, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                if (((f34181h != null && j(context).exists() && (TextUtils.isEmpty(templateConfig.h5Checksum) || templateConfig.h5Checksum.equals(f34180g.h5Checksum))) ? false : true) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_interact_page_dialog_tips_template_config", "interact_page_dialog_tips.html");
                }
            }
            f34181h = templateConfig;
        }
    }

    public static SdkConfigData.TemplateConfig d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65594, null)) == null) ? f34178e : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File d(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "interstitial_ad.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void d(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65596, null, context, templateConfig) == null) || templateConfig == null) {
            return;
        }
        if ((f34175b == null || !e(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f34175b.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
            a(context, templateConfig, "ksadsdk_template_config", "feed.html");
        }
        f34175b = templateConfig;
    }

    public static SdkConfigData.TemplateConfig e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65597, null)) == null) ? f34182i : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File e(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65598, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "feed.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void e(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65599, null, context, templateConfig) == null) {
            if (templateConfig != null && ((f34176c == null || !f(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f34176c.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
                a(context, templateConfig, "ksadsdk_splash_template_config", "feed_splash.html");
            }
            f34176c = templateConfig;
        }
    }

    public static synchronized File f(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65600, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "feed_splash.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) {
            if (f34180g != null) {
                return f34180g.h5Url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @WorkerThread
    public static void f(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65602, null, context, templateConfig) == null) {
            if (templateConfig != null && ((f34177d == null || !g(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f34177d.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
                a(context, templateConfig, "ksadsdk_mini_card_template_config", "mini_card.html");
            }
            f34177d = templateConfig;
        }
    }

    public static synchronized File g(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65603, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "mini_card.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) {
            if (f34181h != null) {
                return f34181h.h5Url;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @WorkerThread
    public static void g(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65605, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = b(context).exists();
                if ((f34178e == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f34178e.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_download_pop_window_config", "pop_wind.html");
                }
            }
            f34178e = templateConfig;
        }
    }

    public static synchronized File h(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "reward_middle_endcard.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void h(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65607, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = c(context).exists();
                if ((f34179f == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f34179f.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_download_pop_window_config", "insert_screen.html");
                }
            }
            f34179f = templateConfig;
        }
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            if (f34180g == null) {
                return false;
            }
            return f34180g.notEmpty();
        }
        return invokeV.booleanValue;
    }

    public static synchronized File i(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65609, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "interact_page.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static List<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) ? a.at.a() : (List) invokeV.objValue;
    }

    @WorkerThread
    public static void i(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65611, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = d(context).exists();
                if ((f34182i == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f34182i.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_download_pop_window_config", "interstitial_ad.html");
                }
            }
            f34182i = templateConfig;
        }
    }

    public static synchronized File j(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "interact_page_dialog_tips.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) ? a.as.a() : (String) invokeV.objValue;
    }

    @WorkerThread
    public static void j(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65614, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = k(context).exists();
                if ((j == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(j.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_coupon_open_config", "coupon_open.html");
                }
            }
            j = templateConfig;
        }
    }

    public static synchronized File k(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "coupon_open.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void k(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65616, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = l(context).exists();
                if ((k == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(k.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_coupon_info_config", "coupon_info.html");
                    d.a().a(templateConfig.h5Url, "coupon_info.html");
                }
            }
            k = templateConfig;
        }
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) {
            if (com.kwad.sdk.d.f35393a == 1) {
                return false;
            }
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_PLAYER_TYPE");
            return ((Boolean) (a2 != null ? a2.getValue() : a.ac.a())).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) {
            int intValue = a.T.a().intValue();
            if (intValue > 0) {
                return intValue;
            }
            return 5000;
        }
        return invokeV.intValue;
    }

    public static synchronized File l(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65619, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "coupon_info.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static int m() {
        InterceptResult invokeV;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65620, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_BATCH_MAXNUM");
            return (a2 == null || (num = (Integer) a2.getValue()) == null) ? a.l.a().intValue() : num.intValue();
        }
        return invokeV.intValue;
    }

    @NonNull
    public static List<String> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65621, null)) == null) ? a.au.a() : (List) invokeV.objValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65622, null)) == null) ? a.n.a().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65623, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_AGGREGATE_AD_OPEN");
            return ((Boolean) (a2 != null ? a2.getValue() : a.ai.a())).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65624, null)) == null) ? a.s.a().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65625, null)) == null) ? a.t.a().intValue() == 0 : invokeV.booleanValue;
    }

    public static boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65626, null)) == null) ? a.ad.a().booleanValue() : invokeV.booleanValue;
    }

    public static boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65627, null)) == null) ? a.am.a().booleanValue() : invokeV.booleanValue;
    }

    public static SdkConfigData.TemplateConfig u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65628, null)) == null) ? l : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65629, null)) == null) ? a.z.a().intValue() : invokeV.intValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65630, null)) == null) ? a.H.a().intValue() == 1 : invokeV.booleanValue;
    }

    public static String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65631, null)) == null) ? a.ao.a() : (String) invokeV.objValue;
    }

    public static String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65632, null)) == null) ? a.ap.a() : (String) invokeV.objValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65633, null)) == null) ? a.P.a().intValue() == 1 : invokeV.booleanValue;
    }
}
