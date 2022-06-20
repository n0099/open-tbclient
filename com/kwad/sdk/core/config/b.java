package com.kwad.sdk.core.config;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
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
/* loaded from: classes5.dex */
public class b {
    public static volatile SdkConfigData a;
    public static volatile SdkConfigData.TemplateConfig b;
    public static volatile SdkConfigData.TemplateConfig c;
    public static volatile SdkConfigData.TemplateConfig d;
    public static volatile SdkConfigData.TemplateConfig e;
    public static volatile SdkConfigData.TemplateConfig f;
    public static volatile SdkConfigData.TemplateConfig g;
    public static SdkConfigData.TemplateConfig h;
    public static SdkConfigData.TemplateConfig i;
    public static SdkConfigData.TemplateConfig j;
    public static boolean k;
    public static boolean l;
    public static boolean m;
    public static boolean n;

    /* loaded from: classes5.dex */
    public static class a {
        public static j a = new j("ecKwaiBtnSwitch", 1);
        public static j b = new j("fitNavigationBarSwitch", 1);
        public static j c = new j("ecTopJumpToKwai", 1);
        public static j d = new j("toolbarSwitch", 1);
        public static j e = new j("likeButtonSwitch", 1);
        public static j f = new j("moreButtonSwitch", 1);
        public static j g = new j("commentButtonSwitch", 1);
        public static j h = new j("seekBarSwitch", 59);
        public static j i = new j("videoCacheSwitch", 0);
        public static j j = new j("trendDynamicEffect", 0);
        public static j k = new j("homePlaySpeedTime", 90);
        public static j l = new j("homePlayCompleteType", 0);
        public static j m = new j("replayTubeEpisode", 0);
        public static j n = new j("batchReportCatchLimit", 20);
        public static j o = new j("preloadSwitch", 1);
        public static j p = new j("rewardTopBarNewStyle", 0);
        public static j q = new j("convertEnableStrongPatch", 0);
        public static j r = new j("liveSwitch", 0);
        public static j s = new j("showAdComment", 0);
        public static j t = new j("authorProfileSwitch", 1);
        public static j u = new j("exceptionCollectorSwitch", 1);
        public static j v = new j("mediaPlayerLogReport", 0);
        public static j w = new j("slideLeftSwitch", 0);
        public static j x = new j("tabRefresh", 0);
        public static j y = new j("backRefreshSwitch", 0);
        public static j z = new j("mobileNetTipSwitch", 0);
        public static j A = new j("relatedSwitch", 0);
        public static j B = new j("closeDelaySeconds", 0);
        public static j C = new j("bannerAdGapTime", 60);
        public static j D = new j("bannerAdShowCount", 3);
        public static j E = new j("rewardFullClickSwitch", 0);
        public static j F = new j("didCopySwitch", 1);
        public static j G = new j("slideCoverSwitch", 0);
        public static j H = new j("profileAdSwitch", 0);
        public static j I = new j("mediaControlPlaySwitch", 1);
        public static j J = new j("entrySwipeJumpIndex", 4);
        public static j K = new j("mediaPlayerActionSwitch", 0);
        public static j L = new j("showBlurBackground", 0);
        public static j M = new j("enableHodor", 0);
        public static j N = new j("preloadVideoCache", 0);
        public static j O = new j("formAdExitInterceptSwitch", 0);
        public static j P = new j("adLeaveConfirmSwitch", 0);
        public static j Q = new j("dynamicPicAdRewardSwitch", 0);
        public static j R = new j("adFrontPageSwitch", 0);
        public static j S = new j("entryGifFullShowAnimation", 0);
        public static j T = new j("aggregatePageStyle", 0);
        public static j U = new j("speedLimitSwitch", 1);
        public static j V = new j("remindInstallActivateSwitch", 0);
        public static j W = new j("enableMultiVideoCoding", 0);
        public static j X = new j("speedLimitThreshold", 200);
        public static j Y = new j("splashTimeOutMilliSecond", 5000);
        public static j Z = new j("middleEndcardShowTime", 0);
        public static j aa = new j("guideStyle", 0);
        public static j ab = new j("dynamicFirstAppearPos", 2);
        public static j ac = new j("dynamicAppearGapPos", 3);
        public static j ad = new j("backPatchIntervalMills", 10000);
        public static j ae = new j("avatarGuiderSwitch", 1);
        public static j af = new j("patchAdCarouselCount", 5);
        public static j ag = new j("stayBackShowSwitch", 0);
        public static j ah = new j("stayTabShowSwitch", 0);
        public static j ai = new j("stayPlayNextPhoto", 0);
        public static j aj = new j("stayRealShowCount", 1);
        public static l ak = new l("stayShowInterval", 30000L);
        public static l al = new l("guideShowTime", 5000L);
        public static l am = new l("deviceInfoDisableConfig", 0L);
        public static l an = new l("validClickConvertTime", 1000L);
        public static d ao = new d("playerEnable", false);
        public static d ap = new d("dynamicEnable", false);
        public static d aq = new d("emotionEnable", true);
        public static d ar = new d("entryConvButtonAnimSwitch", false);
        public static d as = new d("patchAdCarouselSwitch", false);
        public static d at = new d("entryCoverConvertSwitch", false);
        public static d au = new d("couponActiveEnable", false);
        public static d av = new d("drawAdPlayEndToNextVideo", false);
        public static d aw = new d("drawAdPlayEndToWebPage", false);
        public static d ax = new d("drawAdPlayEndToNextVideoFirst", false);
        public static d ay = new d("forceGetAudioFocus", false);
        public static d az = new d("dataFlowAutoStartSwitch", false);
        public static d aA = new d("interstitialAutoStartSwitch", false);
        public static j aB = new j("interstitialStyle", 0);
        public static j aC = new j("interstitialAdSkipCloseType", 0);
        public static j aD = new j("interstitialAdSkipCloseArea", 0);
        public static j aE = new j("interstitialPlayableTime", 999);
        public static j aF = new j("insertScreenAdAutoCloseTime", 0);
        public static g aG = new g("homePlaySpeed", 0.0f);
        public static q aH = new q("webpSoUrlV7a", "");
        public static q aI = new q("webpSoUrlV8a", "");
        public static q aJ = new q("tkSoUrlV7a", "");
        public static q aK = new q("tkSoUrlV8a", "");
        public static k aL = new k("playerConfig", null);
        public static r aM = new r("pkgNameList", new ArrayList(0));
        public static r aN = new r("hostList", new ArrayList(0));
        public static TipsConfigItem aO = new TipsConfigItem();
        public static m aP = new m();
        public static o aQ = new o();
        public static com.kwad.sdk.core.config.item.c aR = new com.kwad.sdk.core.config.item.c();
        public static AvatarGuiderConfigItem aS = new AvatarGuiderConfigItem();
        public static InstallActivateReminderConfigItem aT = new InstallActivateReminderConfigItem();
        public static n aU = new n("realtimeReportActions", "");
        public static j aV = new j("mediaShareButtonSwitch", 0);
        public static e aW = new e("mediaShareButton", "私信好友");
        public static p aX = new p();
        public static j aY = new j("rewardAdVideoPreCacheSize", 800);
        public static j aZ = new j("playableCloseSeconds", 0);
        public static j ba = new j("playableAutoPlayEnable", 1);
        public static j bb = new j("horizontalAutoPlayEnable", 0);
        public static j bc = new j("horizontalAutoPlayNextEnable", 0);
        public static j bd = new j("hybridEnable", 1);
        public static j be = new j("formAdLeftSlideSwitch", 0);
        public static j bf = new j("preloadPhotoShareSwitch", 1);
        public static j bg = new j("forceActivateAfterInstalled", 0);
        public static j bh = new j("appInstallNoticeSecond", 0);
        public static j bi = new j("watermarkKwaiIdSwitch", 0);
        public static j bj = new j("insertScreenV2Switch", 0);
        public static j bk = new j("insertScreenAutoPlaySwitch", 0);
        public static i bl = new i("insertScreenV2ShowConfig");
        public static j bm = new j("entrySwipeStyle", 0);
        public static j bn = new j("entrySwipeInteraction", 0);
        public static j bo = new j("environmentDetectEnable", 0);
        public static j bp = new j("simCardInfoEnable", 0);
        public static j bq = new j("baseStationEnable", 0);
        public static j br = new j("sensorEventEnable", 0);
        public static j bs = new j("sensorEventEnable2", 0);
        public static q bt = new q("fullscreenSkipTips", "");
        public static q bu = new q("h5PreloadActionPercent", "");
        public static q bv = new q("rewardSkipTips", "");
        public static j bw = new j("fullscreenSkipType", 0);
        public static j bx = new j("rewardSkipConfirmSwitch", 1);
        public static j by = new j("shieldAuthorSwitch", 0);
        public static j bz = new j("fullscreenSkipShowTime", 5);
        public static j bA = new j("rewardSkipType", 0);
        public static j bB = new j("lpAutoDownloadApkSwitch", 1);
        public static j bC = new j("autoDownloadUrlSwitch", 0);
        public static d bD = new d("refreshEntryPhotoSwitch", true);
        public static j bE = new j("refreshEntryLimit", 5);
        public static j bF = new j("insertScreenAdType", 0);
        public static q bG = new q("relatedTitle", "");
        public static q bH = new q("appStatusSoUrlV7a", "");
        public static q bI = new q("appStatusSoUrlV8a", "");
        public static q bJ = new q("appStatusSoVersion", "");
        public static j bK = new j("appStatusNativeImpl", 1);
        public static j bL = new j("relatedRequestTimes", 0);
        public static j bM = new j("relatedClickJumpMode", 0);
        public static j bN = new j("deeplinkCheckSwitch", -3);
        public static d bO = new d("deeplinkWindowSwitch", false);
        public static h bP = new h();
        public static j bQ = new j("interstitialAdSkipShowTime", 5);
        public static q bR = new q("interstitialAdSkipTips", "跳过");
        public static j bS = new j("interstitialAdSkipType", 0);
        public static j bT = new j("interstitialAdBackPressSwitch", 0);
        public static j bU = new j("interstitialAdFullClick", 1);
        public static q bV = new q("splashVplusEnterHomeTips", "");
        public static j bW = new j("splashVplusEnterHomeSeconds", 0);
        public static f bX = new f("foldItemContent", Double.valueOf(2.0d));
        public static j bY = new j("reEnterItemContentPos", 1);
        public static j bZ = new j("networkRecorderSampling", 100);
        public static j ca = new j("kwaiAppVersionSwitch", 1);
        public static q cb = new q(TTDownloadField.TT_USERAGENT, com.kwad.sdk.core.network.k.b());
        public static q cc = new q("loginUrl", null);
        public static d cd = new d("personalRecommend", false);
        public static j ce = new j("forceActivate", 0);
        public static j cf = new j("remindOpen", -1);
        public static j cg = new j("biddingLogSwitch", 0);
        public static g ch = new g("interactionTimeInRewardedVideo", 0.0f);
        public static g ci = new g("commercialLogReportRate", 0.01f);
        public static j cj = new j("splashVideoDisplaySecond", 5);
        public static q ck = new q("splashTimerTips", "");
        public static d cl = new d("viewVisibleCheckLegacy", false);
        public static j cm = new j("rewardActiveAppTaskMinSecond", 15);

        /* renamed from: cn  reason: collision with root package name */
        public static j f1067cn = new j("viewLandingPageTaskDuration", 15);
        public static q co = new q("splashBtnText", "点击跳过详情页或第三方应用");
        public static q cp = new q("kwaiLogoUrl", null);
        public static q cq = new q("attentionTips", "去关注TA");
        public static q cr = new q("viewHomeTips", "查看TA的主页");
        public static q cs = new q("buyNowTips", "立即抢购");
        public static q ct = new q("liveAdActionDesc", "进入直播间购买");
        public static d cu = new d("dispatch_temp_detach", false);
        public static j cv = new j("ecRewardAdOrderSwitch", 0);
        public static j cw = new j("ecRewardAdFanSwitch", 0);
        public static j cx = new j("ecRewardAdOrderColorSwitch", 0);
        public static j cy = new j("ecRewardAdFanColorSwitch", 0);
        public static j cz = new j("interstitialAdClickShutDown", 0);
        public static j cA = new j("xdtCouponShowDuration", 3000);
        public static j cB = new j("shakeCountDaily", 3);

        public static void a() {
        }
    }

    public static boolean A() {
        return a.W.a().intValue() == 1;
    }

    public static int B() {
        return a.X.a().intValue();
    }

    public static int C() {
        return a.aY.a().intValue();
    }

    public static boolean D() {
        return a.O.a().intValue() == 1;
    }

    public static boolean E() {
        return a.P.a().intValue() == 1;
    }

    public static boolean F() {
        return a.ay.a().booleanValue();
    }

    public static boolean G() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_KSPLAYER_HODOR");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.M.a().intValue() == 1;
    }

    public static int H() {
        return a.aZ.a().intValue();
    }

    public static boolean I() {
        return a.ba.a().intValue() == 1;
    }

    public static boolean J() {
        return a.bd.a().intValue() == 1;
    }

    public static boolean K() {
        return a.bg.a().intValue() == 1;
    }

    public static int L() {
        return a.bh.a().intValue();
    }

    public static boolean M() {
        return a.bo.a().intValue() == 1;
    }

    public static boolean N() {
        return a.bp.a().intValue() == 1;
    }

    public static boolean O() {
        return a.bs.a().intValue() == 1;
    }

    public static int P() {
        return a.bw.a().intValue();
    }

    public static long Q() {
        return a.bz.a().intValue() * 1000;
    }

    public static boolean R() {
        return a.bx.a().intValue() == 1;
    }

    public static int S() {
        return a.bA.a().intValue();
    }

    public static String T() {
        return a.bt.a();
    }

    public static String U() {
        return a.bu.a();
    }

    public static String V() {
        return a.bv.a();
    }

    public static boolean W() {
        return a.bq.a().intValue() == 1;
    }

    public static long X() {
        return a.an.a().longValue();
    }

    public static long Y() {
        return a.am.a().longValue();
    }

    public static boolean Z() {
        return a.bB.a().intValue() == 1;
    }

    public static int a(AdInfo adInfo) {
        int intValue = a.aE.a().intValue();
        if (com.kwad.sdk.core.response.a.a.P(adInfo)) {
            return Math.min(intValue, com.kwad.sdk.core.response.a.a.b(adInfo));
        }
        if (intValue > 60) {
            return 60;
        }
        return intValue;
    }

    public static int a(boolean z) {
        return Color.parseColor(z ? "#FFFF4906" : "#FFFE3666");
    }

    public static SdkConfigData.TemplateConfig a() {
        return b;
    }

    @WorkerThread
    public static SdkConfigData.TemplateConfig a(Context context, @Nullable SdkConfigData.TemplateConfig templateConfig, @Nullable SdkConfigData.TemplateConfig templateConfig2, @NonNull String str, @NonNull String str2) {
        if (templateConfig == null) {
            return null;
        }
        boolean exists = a(context, str2).exists();
        if ((templateConfig2 == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(templateConfig2.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
            a(context, templateConfig, str, str2);
        }
        return templateConfig;
    }

    public static synchronized File a(Context context, String str) {
        File file;
        synchronized (b.class) {
            file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), str);
        }
        return file;
    }

    @Nullable
    public static String a(Context context) {
        SdkConfigData.TemplateConfig templateConfig = j;
        if (templateConfig != null) {
            return templateConfig.h5Url;
        }
        return null;
    }

    @WorkerThread
    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            if (((e != null && f(context).exists() && (TextUtils.isEmpty(templateConfig.h5Checksum) || templateConfig.h5Checksum.equals(e.h5Checksum))) ? false : true) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_interact_page_dialog_tips_template_config", "interact_page_dialog_tips.html");
            }
        }
        e = templateConfig;
    }

    public static void a(final Context context, final SdkConfigData.TemplateConfig templateConfig, final String str, final String str2) {
        com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml preload=" + templateConfig.toJson() + " key=" + str + " fileName=" + str2);
        if (at.a(templateConfig.h5Url)) {
            return;
        }
        com.kwad.sdk.utils.i.a(new Runnable() { // from class: com.kwad.sdk.core.config.b.1
            @Override // java.lang.Runnable
            public void run() {
                String str3 = SdkConfigData.TemplateConfig.this.h5Url;
                File file = new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE);
                if (!file.exists() && !file.mkdir()) {
                    com.kwad.sdk.core.d.a.a("SdkConfigManager", "make template cache dir failed");
                    return;
                }
                File file2 = new File(file, "cache_" + str2);
                if (!com.kwad.sdk.core.diskcache.a.c.a(file2, str3)) {
                    com.kwad.sdk.core.report.d.a(str3, com.ksad.download.c.b.a(context) ? "1" : "2");
                    com.kwad.sdk.utils.q.c(file2);
                    return;
                }
                DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_md5_check");
                boolean booleanValue = a2 != null ? ((Boolean) a2.getValue()).booleanValue() : true;
                String b2 = com.kwad.sdk.utils.c.b(file2);
                if (b2 != null && b2.length() > 10) {
                    b2 = b2.substring(0, 10);
                }
                if (booleanValue && !TextUtils.isEmpty(SdkConfigData.TemplateConfig.this.h5Checksum) && !TextUtils.isEmpty(b2) && !b2.equalsIgnoreCase(SdkConfigData.TemplateConfig.this.h5Checksum)) {
                    com.kwad.sdk.core.report.d.a(str3, "3");
                    com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml md5 check failed");
                    com.kwad.sdk.utils.q.c(file2);
                    return;
                }
                File file3 = new File(file, str2);
                if (file3.exists()) {
                    com.kwad.sdk.utils.q.c(file3);
                }
                file2.renameTo(new File(file, str2));
                context.getSharedPreferences(str, 0).edit().putString("KEY_TEMPLATE_DATA", SdkConfigData.TemplateConfig.this.toJson().toString()).apply();
            }
        });
    }

    public static void a(Context context, SdkConfigData sdkConfigData) {
        b(context, sdkConfigData.splashConfig);
        c(context, sdkConfigData.templateConfigMap.downloadPopWindowConfig);
        d(context, sdkConfigData.templateConfigMap.insertScreenTemplateConfig);
        a(context, sdkConfigData.templateConfigMap.interactPageDialogTipsConfig);
        e(context, sdkConfigData.templateConfigMap.couponOpenConfig);
        f(context, sdkConfigData.templateConfigMap.couponInfoConfig);
        h = a(context, sdkConfigData.templateConfigMap.downloadLandingPageConfig, h, "ksadsdk_download_landing_page_config", "download_landing_page.html");
        i = a(context, sdkConfigData.templateConfigMap.secDownloadPopWindowConfig, i, "ksadsdk_sec_download_pop_window_config", "sec_download_pop_window.html");
        j = sdkConfigData.templateConfigMap.rewardReflowConfig;
    }

    public static void a(SdkConfigData sdkConfigData) {
        a = sdkConfigData;
    }

    public static boolean a(long j2) {
        return (j2 & a.am.a().longValue()) != 0;
    }

    public static int aA() {
        return a.f1067cn.a().intValue();
    }

    public static String aB() {
        return a.co.a();
    }

    public static boolean aC() {
        return a.cz.a().intValue() == 1;
    }

    public static String aD() {
        return a.cr.a();
    }

    public static String aE() {
        return a.cs.a();
    }

    public static String aF() {
        return a.cp.a();
    }

    public static String aG() {
        return a.cq.a();
    }

    public static int aH() {
        int intValue = a.cw.a().intValue();
        if (intValue != 1) {
            return intValue != 2 ? 0 : 2;
        }
        return 1;
    }

    public static boolean aI() {
        return a.cv.a().intValue() == 1;
    }

    @ColorInt
    public static int aJ() {
        return a(!(a.cy.a().intValue() == 1));
    }

    public static boolean aK() {
        return a.cy.a().intValue() == 1;
    }

    @ColorInt
    public static int aL() {
        return a(!(a.cx.a().intValue() == 1));
    }

    public static boolean aM() {
        return a.cx.a().intValue() == 1;
    }

    public static long aN() {
        return a.cA.a().intValue();
    }

    public static int aO() {
        return a.cB.a().intValue();
    }

    public static SdkConfigData aP() {
        return a;
    }

    public static boolean aa() {
        return a.bC.a().intValue() == 1;
    }

    public static String ab() {
        return a.bP.d();
    }

    public static String ac() {
        return a.bP.e();
    }

    public static String ad() {
        return a.bH.a();
    }

    public static String ae() {
        return a.bI.a();
    }

    public static int af() {
        return a.bN.a().intValue();
    }

    public static boolean ag() {
        return a.bO.a().booleanValue();
    }

    public static String ah() {
        return a.bJ.a();
    }

    public static boolean ai() {
        return a.bK.a().intValue() == 1;
    }

    public static int aj() {
        return a.bQ.a().intValue();
    }

    public static boolean ak() {
        return a.bU.a().intValue() == 1;
    }

    public static boolean al() {
        return a.bT.a().intValue() == 1;
    }

    public static String am() {
        return a.bV.a();
    }

    public static String an() {
        return a.cb.a();
    }

    public static int ao() {
        return a.bW.a().intValue();
    }

    public static boolean ap() {
        int intValue = a.bZ.a().intValue();
        if (intValue <= 0) {
            return false;
        }
        if (!l) {
            k = new Random().nextFloat() < 1.0f / ((float) intValue);
            l = true;
        }
        return k;
    }

    public static boolean aq() {
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

    public static boolean ar() {
        return a.ca.a().intValue() == 1;
    }

    public static int as() {
        return a.cj.a().intValue();
    }

    public static String at() {
        return a.ck.a();
    }

    public static boolean au() {
        return a.ce.a().intValue() == 1;
    }

    public static int av() {
        return a.cf.a().intValue();
    }

    public static float aw() {
        return a.ch.a().floatValue();
    }

    public static boolean ax() {
        return a.cg.a().intValue() == 1;
    }

    public static boolean ay() {
        return a.cl.a().booleanValue();
    }

    public static int az() {
        return a.cm.a().intValue();
    }

    public static SdkConfigData.TemplateConfig b(Context context, String str) {
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

    public static String b() {
        SdkConfigData.TemplateConfig templateConfig = i;
        return templateConfig != null ? templateConfig.h5Url : "";
    }

    @WorkerThread
    public static void b(Context context) {
        com.kwad.sdk.core.d.a.a("SdkConfigManager", "load");
        a.a();
        com.kwad.sdk.core.config.a.b(context);
        b = b(context, "ksadsdk_splash_template_config");
        c = b(context, "ksadsdk_download_pop_window_config");
        d = b(context, "ksadsdk_insert_screen_config");
        e = b(context, "ksadsdk_interact_page_dialog_tips_template_config");
        f = b(context, "ksadsdk_coupon_open_config");
        g = b(context, "ksadsdk_coupon_info_config");
        h = b(context, "ksadsdk_download_landing_page_config");
        i = b(context, "ksadsdk_sec_download_pop_window_config");
        j = b(context, "ksadsdk_reward_reflow_config");
    }

    @WorkerThread
    public static void b(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null && ((b == null || !e(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(b.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
            a(context, templateConfig, "ksadsdk_splash_template_config", "feed_splash.html");
        }
        b = templateConfig;
    }

    public static SdkConfigData.TemplateConfig c() {
        return c;
    }

    public static synchronized File c(Context context) {
        File file;
        synchronized (b.class) {
            file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "pop_wind.html");
        }
        return file;
    }

    @WorkerThread
    public static void c(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            boolean exists = c(context).exists();
            if ((c == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(c.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_download_pop_window_config", "pop_wind.html");
            }
        }
        c = templateConfig;
    }

    public static synchronized File d(Context context) {
        File file;
        synchronized (b.class) {
            file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "insert_screen.html");
        }
        return file;
    }

    public static String d() {
        if (e != null) {
            return e.h5Url;
        }
        return null;
    }

    @WorkerThread
    public static void d(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            boolean exists = d(context).exists();
            if ((d == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(d.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_insert_screen_config", "insert_screen.html");
            }
        }
        d = templateConfig;
    }

    public static SdkConfigData.TemplateConfig e() {
        return h;
    }

    public static synchronized File e(Context context) {
        File file;
        synchronized (b.class) {
            file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "feed_splash.html");
        }
        return file;
    }

    @WorkerThread
    public static void e(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            boolean exists = g(context).exists();
            if ((f == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_coupon_open_config", "coupon_open.html");
            }
        }
        f = templateConfig;
    }

    public static synchronized File f(Context context) {
        File file;
        synchronized (b.class) {
            file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "interact_page_dialog_tips.html");
        }
        return file;
    }

    public static List<String> f() {
        return a.aM.a();
    }

    @WorkerThread
    public static void f(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            boolean exists = h(context).exists();
            if ((g == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(g.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_coupon_info_config", "coupon_info.html");
                c.a().a(templateConfig.h5Url, "coupon_info.html");
            }
        }
        g = templateConfig;
    }

    public static synchronized File g(Context context) {
        File file;
        synchronized (b.class) {
            file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "coupon_open.html");
        }
        return file;
    }

    public static String g() {
        return a.aL.a();
    }

    public static synchronized File h(Context context) {
        File file;
        synchronized (b.class) {
            file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "coupon_info.html");
        }
        return file;
    }

    public static boolean h() {
        return false;
    }

    public static int i() {
        int intValue = a.Y.a().intValue();
        if (intValue > 0) {
            return intValue;
        }
        return 5000;
    }

    public static synchronized File i(Context context) {
        File file;
        synchronized (b.class) {
            file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "download_landing_page.html");
        }
        return file;
    }

    public static int j() {
        Integer num;
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_BATCH_MAXNUM");
        return (a2 == null || (num = (Integer) a2.getValue()) == null) ? a.n.a().intValue() : num.intValue();
    }

    public static boolean k() {
        return a.p.a().intValue() != 0;
    }

    public static boolean l() {
        return a.u.a().intValue() != 0;
    }

    public static boolean m() {
        return a.v.a().intValue() == 0;
    }

    public static boolean n() {
        return a.ap.a().booleanValue();
    }

    public static boolean o() {
        return a.az.a().booleanValue();
    }

    public static boolean p() {
        return a.aA.a().booleanValue();
    }

    public static int q() {
        return a.aB.a().intValue();
    }

    public static boolean r() {
        return a.aC.a().intValue() == 1;
    }

    public static int s() {
        return a.aD.a().intValue();
    }

    public static int t() {
        return a.B.a().intValue();
    }

    public static boolean u() {
        return a.K.a().intValue() == 1;
    }

    public static String v() {
        return a.aH.a();
    }

    public static String w() {
        return a.aI.a();
    }

    public static String x() {
        return a.aJ.a();
    }

    public static String y() {
        return a.aK.a();
    }

    public static boolean z() {
        return a.U.a().intValue() == 1;
    }
}
