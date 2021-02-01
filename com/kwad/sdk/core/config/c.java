package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.utils.ag;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile SdkConfigData.TemplateConfig f9047a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile SdkConfigData.TemplateConfig f9048b;
    private static volatile SdkConfigData.TemplateConfig c;
    private static volatile SdkConfigData.TemplateConfig d;
    private static volatile SdkConfigData.TemplateConfig e;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static e f9051a = new e("toolbarSwitch", 1);

        /* renamed from: b  reason: collision with root package name */
        public static e f9052b = new e("likeButtonSwitch", 1);
        public static e c = new e("moreButtonSwitch", 1);
        public static e d = new e("commentButtonSwitch", 1);
        public static e e = new e("seekBarSwitch", 59);
        public static e f = new e("videoCacheSwitch", 0);
        public static e g = new e("trendDynamicEffect", 0);
        public static e h = new e("homePlaySpeedTime", 90);
        public static e i = new e("homePlayCompleteType", 0);
        public static e j = new e("replayTubeEpisode", 0);
        public static e k = new e("batchReportCatchLimit", 20);
        public static e l = new e("preloadSwitch", 1);
        public static e m = new e("rewardTopBarNewStyle", 0);
        public static e n = new e("convertEnableStrongPatch", 0);
        public static e o = new e("liveSwitch", 0);
        public static e p = new e("showAdComment", 0);
        public static e q = new e("authorProfileSwitch", 1);
        public static e r = new e("exceptionCollectorSwitch", 1);
        public static e s = new e("mediaPlayerLogReport", 0);
        public static e t = new e("slideLeftSwitch", 0);
        public static e u = new e("tabRefresh", 0);
        public static e v = new e("backRefreshSwitch", 0);
        public static e w = new e("mobileNetTipSwitch", 0);
        public static e x = new e("relatedSwitch", 0);
        public static e y = new e("closeDelaySeconds", 0);
        public static e z = new e("rewardFullClickSwitch", 0);
        public static e A = new e("didCopySwitch", 1);
        public static e B = new e("slideCoverSwitch", 0);
        public static e C = new e("profileAdSwitch", 0);
        public static e D = new e("entrySwipeJumpIndex", 4);
        public static e E = new e("profileGuideSwitch", 1);
        public static e F = new e("mediaPlayerActionSwitch", 0);
        public static e G = new e("showBlurBackground", 0);
        public static e H = new e("enableHodor", 0);
        public static e I = new e("preloadVideoCache", 0);
        public static e J = new e("speedLimitSwitch", 1);
        public static e K = new e("remindInstallActivateSwitch", 0);
        public static e L = new e("speedLimitThreshold", 200);
        public static e M = new e("splashTimeOutMilliSecond", 5000);
        public static e N = new e("middleEndcardShowTime", 0);
        public static e O = new e("guideStyle", 0);
        public static g P = new g("guideShowTime", 5000L);
        public static com.kwad.sdk.core.config.item.c Q = new com.kwad.sdk.core.config.item.c("playerEnable", false);
        public static com.kwad.sdk.core.config.item.c R = new com.kwad.sdk.core.config.item.c("dynamicEnable", false);
        public static com.kwad.sdk.core.config.item.c S = new com.kwad.sdk.core.config.item.c("emotionEnable", true);
        public static d T = new d("homePlaySpeed", 0.0f);
        public static j U = new j("webpSoUrlV7a", "");
        public static j V = new j("webpSoUrlV8a", "");
        public static f W = new f("playerConfig", null);
        public static k X = new k("pkgNameList", new ArrayList(0));
        public static k Y = new k("hostList", new ArrayList(0));
        public static TipsConfigItem Z = new TipsConfigItem();
        public static h aa = new h();
        public static com.kwad.sdk.core.config.item.b ab = new com.kwad.sdk.core.config.item.b();
        public static ProfileGuideConfigItem ac = new ProfileGuideConfigItem();
        public static InstallActivateReminderConfigItem ad = new InstallActivateReminderConfigItem();
        public static i ae = new i("realtimeReportActions", "");
        public static e af = new e("rewardAdVideoPreCacheSize", 800);
        public static e ag = new e("formAdLeftSlideSwitch", 0);

        public static void a() {
        }
    }

    public static boolean A() {
        com.kwad.sdk.plugin.d dVar;
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_LIVE_ENABLE");
        if (a2 != null) {
            return ((Boolean) a2.getValue()).booleanValue();
        }
        if (a.o.b().intValue() == 0 || (dVar = (com.kwad.sdk.plugin.d) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.d.class)) == null) {
            return false;
        }
        return dVar.c();
    }

    public static boolean B() {
        return a.q.b().intValue() != 0;
    }

    public static boolean C() {
        return D() != 0;
    }

    public static int D() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_COMMENT_AD_TYPE");
        return a2 != null ? ((Integer) a2.getValue()).intValue() : a.p.b().intValue();
    }

    public static boolean E() {
        return a.r.b().intValue() != 0;
    }

    public static boolean F() {
        return a.s.b().intValue() == 0;
    }

    public static boolean G() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_SLID_LEFT_ENABLE");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.t.b().intValue() != 0;
    }

    public static boolean H() {
        return a.u.b().intValue() != 0;
    }

    public static boolean I() {
        return a.v.b().intValue() != 0;
    }

    public static boolean J() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_4g_TIPENABLE");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.w.b().intValue() != 0;
    }

    public static boolean K() {
        return a.R.b().booleanValue();
    }

    public static boolean L() {
        return a.S.b().booleanValue();
    }

    public static SdkConfigData.TemplateConfig M() {
        return e;
    }

    public static boolean N() {
        return a.x.b().intValue() == 1;
    }

    public static boolean O() {
        return a.x.b().intValue() == 2;
    }

    public static int P() {
        return a.y.b().intValue();
    }

    public static boolean Q() {
        return a.z.b().intValue() == 1;
    }

    public static boolean R() {
        return a.A.b().intValue() == 1;
    }

    public static boolean S() {
        return a.B.b().intValue() == 1;
    }

    public static boolean T() {
        return a.C.b().intValue() == 1;
    }

    public static boolean U() {
        return a.F.b().intValue() == 1;
    }

    public static boolean V() {
        return a.G.b().intValue() == 1;
    }

    public static int W() {
        return a.N.b().intValue();
    }

    public static boolean X() {
        TipsConfigItem.TipConfigData b2 = a.Z.b();
        if (b2 != null) {
            return b2.isShowTips();
        }
        return true;
    }

    public static boolean Y() {
        return a.E.b().intValue() == 1;
    }

    public static String Z() {
        return a.U.b();
    }

    public static int a(long j) {
        for (com.kwad.sdk.core.response.model.b bVar : a.aa.b()) {
            if (bVar != null && bVar.f9434a == j) {
                return bVar.f9435b;
            }
        }
        return 0;
    }

    public static SdkConfigData.TemplateConfig a() {
        return f9047a;
    }

    private static SdkConfigData.TemplateConfig a(Context context, String str) {
        SdkConfigData.TemplateConfig templateConfig = new SdkConfigData.TemplateConfig();
        String string = context.getSharedPreferences(str, 0).getString("KEY_TEMPLATE_DATA", "");
        if (!ag.a(string)) {
            try {
                templateConfig.parseJson(new JSONObject(string));
            } catch (JSONException e2) {
            }
        }
        return templateConfig;
    }

    public static String a(String str) {
        TipsConfigItem.TipConfigData b2 = a.Z.b();
        return b2 != null ? b2.getTips(str) : "";
    }

    @WorkerThread
    public static void a(Context context) {
        com.kwad.sdk.core.d.a.a("SdkConfigManager", TrackLoadSettingsAtom.TYPE);
        a.a();
        b.b(context);
        f9047a = a(context, "ksadsdk_template_config");
        f9048b = a(context, "ksadsdk_splash_template_config");
        c = a(context, "ksadsdk_mini_card_template_config");
    }

    @WorkerThread
    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            if ((e == null || !f(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(e.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_reward_middle_endcard_template_config", "reward_middle_endcard.html");
            }
            e = templateConfig;
        }
    }

    private static void a(final Context context, final SdkConfigData.TemplateConfig templateConfig, final String str, final String str2) {
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

    public static boolean a(AdInfo adInfo) {
        return a.N.b().intValue() > 0 && W() <= com.kwad.sdk.core.response.b.a.b(adInfo);
    }

    public static String aa() {
        return a.V.b();
    }

    public static boolean ab() {
        return a.J.b().intValue() == 1;
    }

    public static boolean ac() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_REMIND_INSTALL_ACTIVATE_ENABLE");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.K.b().intValue() == 1;
    }

    public static int ad() {
        return a.L.b().intValue();
    }

    public static int ae() {
        return a.af.b().intValue();
    }

    public static boolean af() {
        return a.ag.b().intValue() == 1;
    }

    public static boolean ag() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_KSPLAYER_HODOR");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.H.b().intValue() == 1;
    }

    public static int ah() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_PRELOAD_VIDEO_CACHE");
        int intValue = a2 != null ? ((Integer) a2.getValue()).intValue() : a.I.b().intValue();
        com.kwad.sdk.core.d.a.a("SdkConfigManager", "getPreloadVideoCache value=" + intValue);
        return intValue;
    }

    public static long ai() {
        return a.P.b().longValue();
    }

    public static boolean aj() {
        return a.O.b().intValue() == 0;
    }

    public static boolean ak() {
        return a.O.b().intValue() == 1;
    }

    public static boolean al() {
        return a.O.b().intValue() == 2;
    }

    private static int am() {
        return a.f9051a.b().intValue();
    }

    private static int an() {
        return a.f9052b.b().intValue();
    }

    public static SdkConfigData.TemplateConfig b() {
        return f9048b;
    }

    public static synchronized File b(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "pop_wind.html");
        }
        return file;
    }

    @WorkerThread
    private static void b(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            if ((f9047a == null || !c(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f9047a.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_template_config", "feed.html");
            }
            f9047a = templateConfig;
        }
    }

    public static SdkConfigData.TemplateConfig c() {
        return c != null ? c : new SdkConfigData.TemplateConfig();
    }

    public static synchronized File c(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "feed.html");
        }
        return file;
    }

    @WorkerThread
    private static void c(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null && ((f9048b == null || !d(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f9048b.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
            a(context, templateConfig, "ksadsdk_splash_template_config", "feed_splash.html");
        }
        f9048b = templateConfig;
    }

    public static SdkConfigData.TemplateConfig d() {
        return d;
    }

    public static synchronized File d(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "feed_splash.html");
        }
        return file;
    }

    @WorkerThread
    private static void d(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null && ((c == null || !e(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(c.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
            a(context, templateConfig, "ksadsdk_mini_card_template_config", "mini_card.html");
        }
        c = templateConfig;
    }

    public static synchronized File e(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "mini_card.html");
        }
        return file;
    }

    @WorkerThread
    private static void e(Context context, SdkConfigData.TemplateConfig templateConfig) {
        if (templateConfig != null) {
            boolean exists = b(context).exists();
            if ((d == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(d.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                a(context, templateConfig, "ksadsdk_download_pop_window_config", "pop_wind.html");
            }
        }
        d = templateConfig;
    }

    public static boolean e() {
        return am() == 1;
    }

    public static synchronized File f(Context context) {
        File file;
        synchronized (c.class) {
            file = new File(new File(context.getCacheDir(), "template"), "reward_middle_endcard.html");
        }
        return file;
    }

    public static boolean f() {
        return an() == 1;
    }

    public static int g() {
        return a.c.b().intValue();
    }

    public static boolean h() {
        return g() == 1;
    }

    public static int i() {
        return a.d.b().intValue();
    }

    public static boolean j() {
        return i() == 1;
    }

    public static int k() {
        return a.D.b().intValue();
    }

    public static boolean l() {
        return a.f.b().intValue() == 2;
    }

    public static boolean m() {
        return a.l.b().intValue() == 1;
    }

    public static List<String> n() {
        return a.X.b();
    }

    public static String o() {
        return a.W.b();
    }

    public static boolean p() {
        if (com.kwad.sdk.d.f9671a == 1) {
            return false;
        }
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_PLAYER_TYPE");
        return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.Q.b().booleanValue();
    }

    public static float q() {
        return a.T.b().floatValue();
    }

    public static int r() {
        return a.h.b().intValue();
    }

    public static int s() {
        int intValue = a.M.b().intValue();
        if (intValue > 0) {
            return intValue;
        }
        return 5000;
    }

    public static int t() {
        return a.i.b().intValue();
    }

    public static int u() {
        return a.j.b().intValue();
    }

    public static int v() {
        Integer num;
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_BATCH_MAXNUM");
        return (a2 == null || (num = (Integer) a2.getValue()) == null) ? a.k.b().intValue() : num.intValue();
    }

    @NonNull
    public static List<String> w() {
        return a.Y.b();
    }

    public static int x() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_TREND_UI_TYPE");
        return a2 != null ? ((Integer) a2.getValue()).intValue() : a.g.b().intValue();
    }

    public static boolean y() {
        return a.m.b().intValue() != 0;
    }

    public static boolean z() {
        return a.n.b().intValue() != 0;
    }
}
