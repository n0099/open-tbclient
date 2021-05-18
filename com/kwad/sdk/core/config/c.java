package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.ProfileGuideConfigItem;
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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.v;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f32080a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f32081b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f32082c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f32083d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f32084e;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static f f32089a = new f("toolbarSwitch", 1);

        /* renamed from: b  reason: collision with root package name */
        public static f f32090b = new f("likeButtonSwitch", 1);

        /* renamed from: c  reason: collision with root package name */
        public static f f32091c = new f("moreButtonSwitch", 1);

        /* renamed from: d  reason: collision with root package name */
        public static f f32092d = new f("commentButtonSwitch", 1);

        /* renamed from: e  reason: collision with root package name */
        public static f f32093e = new f("seekBarSwitch", 59);

        /* renamed from: f  reason: collision with root package name */
        public static f f32094f = new f("videoCacheSwitch", 0);

        /* renamed from: g  reason: collision with root package name */
        public static f f32095g = new f("trendDynamicEffect", 0);

        /* renamed from: h  reason: collision with root package name */
        public static f f32096h = new f("homePlaySpeedTime", 90);

        /* renamed from: i  reason: collision with root package name */
        public static f f32097i = new f("homePlayCompleteType", 0);
        public static f j = new f("replayTubeEpisode", 0);
        public static f k = new f("batchReportCatchLimit", 20);
        public static f l = new f("preloadSwitch", 1);
        public static f m = new f("rewardTopBarNewStyle", 0);
        public static f n = new f("convertEnableStrongPatch", 0);
        public static f o = new f("liveSwitch", 0);
        public static f p = new f("showAdComment", 0);
        public static f q = new f("authorProfileSwitch", 1);
        public static f r = new f("exceptionCollectorSwitch", 1);
        public static f s = new f("mediaPlayerLogReport", 0);
        public static f t = new f("slideLeftSwitch", 0);
        public static f u = new f("tabRefresh", 0);
        public static f v = new f("backRefreshSwitch", 0);
        public static f w = new f("mobileNetTipSwitch", 0);
        public static f x = new f("relatedSwitch", 0);
        public static f y = new f("closeDelaySeconds", 0);
        public static f z = new f("rewardFullClickSwitch", 0);
        public static f A = new f("didCopySwitch", 1);
        public static f B = new f("slideCoverSwitch", 0);
        public static f C = new f("profileAdSwitch", 0);
        public static f D = new f("mediaControlPlaySwitch", 1);
        public static f E = new f("entrySwipeJumpIndex", 4);
        public static f F = new f("mediaPlayerActionSwitch", 0);
        public static f G = new f("showBlurBackground", 0);
        public static f H = new f("enableHodor", 0);
        public static f I = new f("preloadVideoCache", 0);
        public static f J = new f("formAdExitInterceptSwitch", 0);
        public static f K = new f("adLeaveConfirmSwitch", 0);
        public static f L = new f("adFrontPageSwitch", 0);
        public static f M = new f("speedLimitSwitch", 1);
        public static f N = new f("remindInstallActivateSwitch", 0);
        public static f O = new f("enableMultiVideoCoding", 0);
        public static f P = new f("speedLimitThreshold", 200);
        public static f Q = new f("splashTimeOutMilliSecond", 5000);
        public static f R = new f("middleEndcardShowTime", 0);
        public static f S = new f("guideStyle", 0);
        public static f T = new f("backPatchIntervalMills", 10000);
        public static h U = new h("guideShowTime", 5000L);
        public static h V = new h("deviceInfoDisableConfig", 0L);
        public static com.kwad.sdk.core.config.item.c W = new com.kwad.sdk.core.config.item.c("playerEnable", false);
        public static com.kwad.sdk.core.config.item.c X = new com.kwad.sdk.core.config.item.c("dynamicEnable", false);
        public static com.kwad.sdk.core.config.item.c Y = new com.kwad.sdk.core.config.item.c("emotionEnable", true);
        public static e Z = new e("homePlaySpeed", 0.0f);
        public static l aa = new l("webpSoUrlV7a", "");
        public static l ab = new l("webpSoUrlV8a", "");
        public static g ac = new g("playerConfig", null);
        public static m ad = new m("pkgNameList", new ArrayList(0));
        public static m ae = new m("hostList", new ArrayList(0));
        public static TipsConfigItem af = new TipsConfigItem();
        public static i ag = new i();
        public static n ah = new n();
        public static com.kwad.sdk.core.config.item.b ai = new com.kwad.sdk.core.config.item.b();
        public static ProfileGuideConfigItem aj = new ProfileGuideConfigItem();
        public static InstallActivateReminderConfigItem ak = new InstallActivateReminderConfigItem();
        public static j al = new j("realtimeReportActions", "");
        public static f am = new f("mediaShareButtonSwitch", 0);
        public static d an = new d("mediaShareButton", "私信好友");
        public static k ao = new k();
        public static f ap = new f("rewardAdVideoPreCacheSize", 800);
        public static f aq = new f("playableCloseSeconds", 0);
        public static f ar = new f("playableAutoPlayEnable", 1);
        public static f as = new f("formAdLeftSlideSwitch", 0);
        public static f at = new f("preloadPhotoShareSwitch", 1);
        public static f au = new f("forceActivateAfterInstalled", 0);
        public static f av = new f("splashFullClickSwitch", 1);
        public static f aw = new f("watermarkKwaiIdSwitch", 0);
        public static f ax = new f("entrySwipeStyle", 0);
        public static f ay = new f("entrySwipeInteraction", 0);
        public static f az = new f("environmentDetectEnable", 0);
        public static f aA = new f("simCardInfoEnable", 0);
        public static f aB = new f("baseStationEnable", 0);
        public static f aC = new f("sensorEventEnable", 0);
        public static l aD = new l("fullscreenSkipTips", "");
        public static l aE = new l("rewardSkipTips", "");
        public static f aF = new f("fullscreenSkipType", 0);
        public static f aG = new f("rewardSkipShowTime", 5);
        public static f aH = new f("fullscreenSkipShowTime", 5);
        public static f aI = new f("rewardSkipType", 0);
        public static f aJ = new f("lpAutoDownloadApkSwitch", 1);
        public static f aK = new f("autoDownloadUrlSwitch", 0);

        public static void a() {
        }
    }

    public static boolean A() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_KSPLAYER_HODOR");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.H.b().intValue() == 1;
    }

    public static int B() {
        return a.aq.b().intValue();
    }

    public static boolean C() {
        return a.ar.b().intValue() == 1;
    }

    public static boolean D() {
        return a.au.b().intValue() == 1;
    }

    public static boolean E() {
        return a.av.b().intValue() == 1;
    }

    public static boolean F() {
        return a.az.b().intValue() == 1;
    }

    public static boolean G() {
        return a.aA.b().intValue() == 1;
    }

    public static boolean H() {
        return a.aC.b().intValue() == 1;
    }

    public static int I() {
        return a.aF.b().intValue();
    }

    public static long J() {
        return a.aH.b().intValue() * 1000;
    }

    public static long K() {
        return a.aG.b().intValue() * 1000;
    }

    public static int L() {
        return a.aI.b().intValue();
    }

    public static String M() {
        return a.aD.b();
    }

    public static String N() {
        return a.aE.b();
    }

    public static boolean O() {
        return a.aB.b().intValue() == 1;
    }

    public static boolean P() {
        return a.aJ.b().intValue() == 1;
    }

    public static boolean Q() {
        return a.aK.b().intValue() == 1;
    }

    public static SdkConfigData.TemplateConfig a() {
        return f32080a;
    }

    public static SdkConfigData.TemplateConfig a(Context context, String str) {
        SdkConfigData.TemplateConfig templateConfig = new SdkConfigData.TemplateConfig();
        String string = context.getSharedPreferences(str, 0).getString("KEY_TEMPLATE_DATA", "");
        if (!ag.a(string)) {
            try {
                templateConfig.parseJson(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return templateConfig;
    }

    @WorkerThread
    public static void a(Context context) {
        com.kwad.sdk.core.d.a.a("SdkConfigManager", "load");
        a.a();
        b.b(context);
        f32080a = a(context, "ksadsdk_template_config");
        f32081b = a(context, "ksadsdk_splash_template_config");
        f32082c = a(context, "ksadsdk_mini_card_template_config");
    }

    @WorkerThread
    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            if ((f32084e == null || !f(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f32084e.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_reward_middle_endcard_template_config", "reward_middle_endcard.html");
            }
            f32084e = templateConfig;
        }
    }

    public static void a(final Context context, final SdkConfigData.TemplateConfig templateConfig, final String str, final String str2) {
        com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml preload=" + templateConfig.toJson() + " key=" + str + " fileName=" + str2);
        com.kwad.sdk.utils.f.a(new Runnable() { // from class: com.kwad.sdk.core.config.c.1
            @Override // java.lang.Runnable
            public void run() {
                String str3 = SdkConfigData.TemplateConfig.this.h5Url;
                File file = new File(context.getCacheDir(), "template");
                if (!file.exists() && !file.mkdir()) {
                    com.kwad.sdk.core.d.a.a("SdkConfigManager", "make template cache dir failed");
                    return;
                }
                File file2 = new File(file, "cache_" + str2);
                if (!com.kwad.sdk.core.diskcache.b.c.a(file2, str3)) {
                    com.kwad.sdk.core.report.e.a(str3, com.ksad.download.d.b.a(context) ? "1" : "2");
                    return;
                }
                String b2 = com.kwad.sdk.utils.c.b(file2);
                if (TextUtils.isEmpty(SdkConfigData.TemplateConfig.this.h5Checksum)) {
                    return;
                }
                if (b2 != null && b2.length() > 10) {
                    String substring = b2.substring(0, 10);
                    com.kwad.sdk.core.d.a.a("SdkConfigManager", "file_md5 =  " + substring + "; server_md5 =  " + SdkConfigData.TemplateConfig.this.h5Checksum);
                    if (!substring.equalsIgnoreCase(SdkConfigData.TemplateConfig.this.h5Checksum)) {
                        com.kwad.sdk.core.report.e.a(str3, "3");
                        com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml md5 check failed");
                        return;
                    }
                }
                com.kwad.sdk.core.diskcache.b.c.a(file2, new File(file, str2));
                context.getSharedPreferences(str, 0).edit().putString("KEY_TEMPLATE_DATA", SdkConfigData.TemplateConfig.this.toJson().toString()).apply();
            }
        });
    }

    public static void a(Context context, SdkConfigData sdkConfigData) {
        b(context, sdkConfigData.templateConfig);
        c(context, sdkConfigData.splashConfig);
        d(context, sdkConfigData.rewardMiniCardConfig);
        e(context, sdkConfigData.templateConfigMap.downloadPopWindowConfig);
        a(context, sdkConfigData.rewardMiddleEndcardConfig);
    }

    public static boolean a(long j) {
        return (j & a.V.b().longValue()) != 0;
    }

    public static boolean a(AdInfo adInfo, Context context) {
        if (a.R.b().intValue() > 0 && s() <= com.kwad.sdk.core.response.b.a.b(adInfo)) {
            return !com.kwad.sdk.core.response.b.a.a(adInfo, context) && (com.kwad.sdk.core.response.b.a.e(adInfo) > com.kwad.sdk.core.response.b.a.d(adInfo)) && v.e(context);
        }
        return false;
    }

    public static SdkConfigData.TemplateConfig b() {
        return f32081b;
    }

    public static synchronized File b(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "pop_wind.html");
        }
        return file;
    }

    @WorkerThread
    public static void b(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            if ((f32080a == null || !c(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f32080a.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_template_config", "feed.html");
            }
            f32080a = templateConfig;
        }
    }

    public static SdkConfigData.TemplateConfig c() {
        return f32082c != null ? f32082c : new SdkConfigData.TemplateConfig();
    }

    public static synchronized File c(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "feed.html");
        }
        return file;
    }

    @WorkerThread
    public static void c(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null && ((f32081b == null || !d(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f32081b.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
            a(context, templateConfig, "ksadsdk_splash_template_config", "feed_splash.html");
        }
        f32081b = templateConfig;
    }

    public static SdkConfigData.TemplateConfig d() {
        return f32083d;
    }

    public static synchronized File d(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "feed_splash.html");
        }
        return file;
    }

    @WorkerThread
    public static void d(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null && ((f32082c == null || !e(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f32082c.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
            a(context, templateConfig, "ksadsdk_mini_card_template_config", "mini_card.html");
        }
        f32082c = templateConfig;
    }

    public static synchronized File e(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "mini_card.html");
        }
        return file;
    }

    public static List<String> e() {
        return a.ad.b();
    }

    @WorkerThread
    public static void e(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            boolean exists = b(context).exists();
            if ((f32083d == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f32083d.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_download_pop_window_config", "pop_wind.html");
            }
        }
        f32083d = templateConfig;
    }

    public static synchronized File f(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "reward_middle_endcard.html");
        }
        return file;
    }

    public static String f() {
        return a.ac.b();
    }

    public static boolean g() {
        if (com.kwad.sdk.d.f33109a == 1) {
            return false;
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_PLAYER_TYPE");
        return ((Boolean) (a2 != null ? a2.getValue() : a.W.b())).booleanValue();
    }

    public static int h() {
        int intValue = a.Q.b().intValue();
        if (intValue > 0) {
            return intValue;
        }
        return 5000;
    }

    public static int i() {
        Integer num;
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_BATCH_MAXNUM");
        return (a2 == null || (num = (Integer) a2.getValue()) == null) ? a.k.b().intValue() : num.intValue();
    }

    @NonNull
    public static List<String> j() {
        return a.ae.b();
    }

    public static boolean k() {
        return a.m.b().intValue() != 0;
    }

    public static boolean l() {
        return a.r.b().intValue() != 0;
    }

    public static boolean m() {
        return a.s.b().intValue() == 0;
    }

    public static boolean n() {
        return a.X.b().booleanValue();
    }

    public static SdkConfigData.TemplateConfig o() {
        return f32084e;
    }

    public static int p() {
        return a.y.b().intValue();
    }

    public static boolean q() {
        return a.z.b().intValue() == 1;
    }

    public static boolean r() {
        return a.F.b().intValue() == 1;
    }

    public static int s() {
        return a.R.b().intValue();
    }

    public static String t() {
        return a.aa.b();
    }

    public static String u() {
        return a.ab.b();
    }

    public static boolean v() {
        return a.M.b().intValue() == 1;
    }

    public static boolean w() {
        return a.O.b().intValue() == 1;
    }

    public static int x() {
        return a.P.b().intValue();
    }

    public static int y() {
        return a.ap.b().intValue();
    }

    public static boolean z() {
        return a.J.b().intValue() == 1;
    }
}
