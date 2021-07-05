package com.kwad.sdk.core.config;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f35918a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f35919b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f35920c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f35921d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile SdkConfigData.TemplateConfig f35922e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static e A;
        public static e B;
        public static e C;
        public static e D;
        public static e E;
        public static e F;
        public static e G;
        public static e H;
        public static e I;
        public static e J;
        public static e K;
        public static e L;
        public static e M;
        public static e N;
        public static e O;
        public static g P;
        public static com.kwad.sdk.core.config.item.c Q;
        public static com.kwad.sdk.core.config.item.c R;
        public static com.kwad.sdk.core.config.item.c S;
        public static d T;
        public static j U;
        public static j V;
        public static f W;
        public static k X;
        public static k Y;
        public static TipsConfigItem Z;

        /* renamed from: a  reason: collision with root package name */
        public static e f35927a;
        public static h aa;
        public static com.kwad.sdk.core.config.item.b ab;
        public static ProfileGuideConfigItem ac;
        public static InstallActivateReminderConfigItem ad;
        public static i ae;
        public static e af;
        public static e ag;

        /* renamed from: b  reason: collision with root package name */
        public static e f35928b;

        /* renamed from: c  reason: collision with root package name */
        public static e f35929c;

        /* renamed from: d  reason: collision with root package name */
        public static e f35930d;

        /* renamed from: e  reason: collision with root package name */
        public static e f35931e;

        /* renamed from: f  reason: collision with root package name */
        public static e f35932f;

        /* renamed from: g  reason: collision with root package name */
        public static e f35933g;

        /* renamed from: h  reason: collision with root package name */
        public static e f35934h;

        /* renamed from: i  reason: collision with root package name */
        public static e f35935i;
        public static e j;
        public static e k;
        public static e l;
        public static e m;
        public static e n;
        public static e o;
        public static e p;
        public static e q;
        public static e r;
        public static e s;
        public static e t;
        public static e u;
        public static e v;
        public static e w;
        public static e x;
        public static e y;
        public static e z;
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
            f35927a = new e("toolbarSwitch", 1);
            f35928b = new e("likeButtonSwitch", 1);
            f35929c = new e("moreButtonSwitch", 1);
            f35930d = new e("commentButtonSwitch", 1);
            f35931e = new e("seekBarSwitch", 59);
            f35932f = new e("videoCacheSwitch", 0);
            f35933g = new e("trendDynamicEffect", 0);
            f35934h = new e("homePlaySpeedTime", 90);
            f35935i = new e("homePlayCompleteType", 0);
            j = new e("replayTubeEpisode", 0);
            k = new e("batchReportCatchLimit", 20);
            l = new e("preloadSwitch", 1);
            m = new e("rewardTopBarNewStyle", 0);
            n = new e("convertEnableStrongPatch", 0);
            o = new e("liveSwitch", 0);
            p = new e("showAdComment", 0);
            q = new e("authorProfileSwitch", 1);
            r = new e("exceptionCollectorSwitch", 1);
            s = new e("mediaPlayerLogReport", 0);
            t = new e("slideLeftSwitch", 0);
            u = new e("tabRefresh", 0);
            v = new e("backRefreshSwitch", 0);
            w = new e("mobileNetTipSwitch", 0);
            x = new e("relatedSwitch", 0);
            y = new e("closeDelaySeconds", 0);
            z = new e("rewardFullClickSwitch", 0);
            A = new e("didCopySwitch", 1);
            B = new e("slideCoverSwitch", 0);
            C = new e("profileAdSwitch", 0);
            D = new e("entrySwipeJumpIndex", 4);
            E = new e("profileGuideSwitch", 1);
            F = new e("mediaPlayerActionSwitch", 0);
            G = new e("showBlurBackground", 0);
            H = new e("enableHodor", 0);
            I = new e("preloadVideoCache", 0);
            J = new e("speedLimitSwitch", 1);
            K = new e("remindInstallActivateSwitch", 0);
            L = new e("speedLimitThreshold", 200);
            M = new e("splashTimeOutMilliSecond", 5000);
            N = new e("middleEndcardShowTime", 0);
            O = new e("guideStyle", 0);
            P = new g("guideShowTime", 5000L);
            Q = new com.kwad.sdk.core.config.item.c("playerEnable", false);
            R = new com.kwad.sdk.core.config.item.c("dynamicEnable", false);
            S = new com.kwad.sdk.core.config.item.c("emotionEnable", true);
            T = new d("homePlaySpeed", 0.0f);
            U = new j("webpSoUrlV7a", "");
            V = new j("webpSoUrlV8a", "");
            W = new f("playerConfig", null);
            X = new k("pkgNameList", new ArrayList(0));
            Y = new k("hostList", new ArrayList(0));
            Z = new TipsConfigItem();
            aa = new h();
            ab = new com.kwad.sdk.core.config.item.b();
            ac = new ProfileGuideConfigItem();
            ad = new InstallActivateReminderConfigItem();
            ae = new i("realtimeReportActions", "");
            af = new e("rewardAdVideoPreCacheSize", 800);
            ag = new e("formAdLeftSlideSwitch", 0);
        }

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            }
        }
    }

    public static boolean A() {
        InterceptResult invokeV;
        com.kwad.sdk.plugin.d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_LIVE_ENABLE");
            if (a2 != null) {
                return ((Boolean) a2.getValue()).booleanValue();
            }
            if (a.o.b().intValue() == 0 || (dVar = (com.kwad.sdk.plugin.d) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.d.class)) == null) {
                return false;
            }
            return dVar.c();
        }
        return invokeV.booleanValue;
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.q.b().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? D() != 0 : invokeV.booleanValue;
    }

    public static int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_COMMENT_AD_TYPE");
            return ((Integer) (a2 != null ? a2.getValue() : a.p.b())).intValue();
        }
        return invokeV.intValue;
    }

    public static boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? a.r.b().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? a.s.b().intValue() == 0 : invokeV.booleanValue;
    }

    public static boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_SLID_LEFT_ENABLE");
            return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.t.b().intValue() != 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a.u.b().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? a.v.b().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_4g_TIPENABLE");
            return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.w.b().intValue() != 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? a.R.b().booleanValue() : invokeV.booleanValue;
    }

    public static boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? a.S.b().booleanValue() : invokeV.booleanValue;
    }

    public static SdkConfigData.TemplateConfig M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f35922e : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? a.x.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? a.x.b().intValue() == 2 : invokeV.booleanValue;
    }

    public static int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? a.y.b().intValue() : invokeV.intValue;
    }

    public static boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? a.z.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? a.A.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? a.B.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? a.C.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? a.F.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? a.G.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? a.N.b().intValue() : invokeV.intValue;
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            TipsConfigItem.TipConfigData b2 = a.Z.b();
            if (b2 != null) {
                return b2.isShowTips();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) ? a.E.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? a.U.b() : (String) invokeV.objValue;
    }

    public static int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65562, null, j)) == null) {
            for (com.kwad.sdk.core.response.model.b bVar : a.aa.b()) {
                if (bVar != null && bVar.f36571a == j) {
                    return bVar.f36572b;
                }
            }
            return 0;
        }
        return invokeJ.intValue;
    }

    public static SdkConfigData.TemplateConfig a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) ? f35918a : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static SdkConfigData.TemplateConfig a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, context, str)) == null) {
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
        return (SdkConfigData.TemplateConfig) invokeLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            TipsConfigItem.TipConfigData b2 = a.Z.b();
            return b2 != null ? b2.getTips(str) : "";
        }
        return (String) invokeL.objValue;
    }

    @WorkerThread
    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, context) == null) {
            com.kwad.sdk.core.d.a.a("SdkConfigManager", "load");
            a.a();
            b.b(context);
            f35918a = a(context, "ksadsdk_template_config");
            f35919b = a(context, "ksadsdk_splash_template_config");
            f35920c = a(context, "ksadsdk_mini_card_template_config");
        }
    }

    @WorkerThread
    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65567, null, context, templateConfig) == null) || templateConfig == null) {
            return;
        }
        if ((f35922e == null || !f(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f35922e.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
            a(context, templateConfig, "ksadsdk_reward_middle_endcard_template_config", "reward_middle_endcard.html");
        }
        f35922e = templateConfig;
    }

    public static void a(Context context, SdkConfigData.TemplateConfig templateConfig, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65568, null, context, templateConfig, str, str2) == null) {
            com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml preload=" + templateConfig.toJson() + " key=" + str + " fileName=" + str2);
            com.kwad.sdk.utils.f.a(new Runnable(templateConfig, context, str2, str) { // from class: com.kwad.sdk.core.config.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SdkConfigData.TemplateConfig f35923a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f35924b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f35925c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f35926d;

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
                    this.f35923a = templateConfig;
                    this.f35924b = context;
                    this.f35925c = str2;
                    this.f35926d = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str3 = this.f35923a.h5Url;
                        File file = new File(this.f35924b.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE);
                        if (!file.exists() && !file.mkdir()) {
                            com.kwad.sdk.core.d.a.a("SdkConfigManager", "make template cache dir failed");
                            return;
                        }
                        File file2 = new File(file, "cache_" + this.f35925c);
                        if (!com.kwad.sdk.core.diskcache.b.c.a(file2, str3)) {
                            com.kwad.sdk.core.report.e.a(str3, com.ksad.download.d.b.a(this.f35924b) ? "1" : "2");
                            return;
                        }
                        String b2 = com.kwad.sdk.utils.c.b(file2);
                        if (TextUtils.isEmpty(this.f35923a.h5Checksum)) {
                            return;
                        }
                        if (b2 != null && b2.length() > 10) {
                            String substring = b2.substring(0, 10);
                            com.kwad.sdk.core.d.a.a("SdkConfigManager", "file_md5 =  " + substring + "; server_md5 =  " + this.f35923a.h5Checksum);
                            if (!substring.equalsIgnoreCase(this.f35923a.h5Checksum)) {
                                com.kwad.sdk.core.report.e.a(str3, "3");
                                com.kwad.sdk.core.d.a.a("SdkConfigManager", "loadConfigHtml md5 check failed");
                                return;
                            }
                        }
                        com.kwad.sdk.core.diskcache.b.c.a(file2, new File(file, this.f35925c));
                        this.f35924b.getSharedPreferences(this.f35926d, 0).edit().putString("KEY_TEMPLATE_DATA", this.f35923a.toJson().toString()).apply();
                    }
                }
            });
        }
    }

    public static void a(Context context, SdkConfigData sdkConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, context, sdkConfigData) == null) {
            b(context, sdkConfigData.templateConfig);
            c(context, sdkConfigData.splashConfig);
            d(context, sdkConfigData.rewardMiniCardConfig);
            e(context, sdkConfigData.templateConfigMap.downloadPopWindowConfig);
            a(context, sdkConfigData.rewardMiddleEndcardConfig);
        }
    }

    public static boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65570, null, adInfo)) == null) ? a.N.b().intValue() > 0 && W() <= com.kwad.sdk.core.response.b.a.b(adInfo) : invokeL.booleanValue;
    }

    public static String aa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? a.V.b() : (String) invokeV.objValue;
    }

    public static boolean ab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? a.J.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean ac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_REMIND_INSTALL_ACTIVATE_ENABLE");
            return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.K.b().intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public static int ad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? a.L.b().intValue() : invokeV.intValue;
    }

    public static int ae() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? a.af.b().intValue() : invokeV.intValue;
    }

    public static boolean af() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? a.ag.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean ag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_KSPLAYER_HODOR");
            return a2 != null ? ((Boolean) a2.getValue()).booleanValue() : a.H.b().intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public static int ah() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_PRELOAD_VIDEO_CACHE");
            int intValue = ((Integer) (a2 != null ? a2.getValue() : a.I.b())).intValue();
            com.kwad.sdk.core.d.a.a("SdkConfigManager", "getPreloadVideoCache value=" + intValue);
            return intValue;
        }
        return invokeV.intValue;
    }

    public static long ai() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? a.P.b().longValue() : invokeV.longValue;
    }

    public static boolean aj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) ? a.O.b().intValue() == 0 : invokeV.booleanValue;
    }

    public static boolean ak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? a.O.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static boolean al() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? a.O.b().intValue() == 2 : invokeV.booleanValue;
    }

    public static int am() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) ? a.f35927a.b().intValue() : invokeV.intValue;
    }

    public static int an() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? a.f35928b.b().intValue() : invokeV.intValue;
    }

    public static SdkConfigData.TemplateConfig b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? f35919b : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File b(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, context)) == null) {
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
        if (!(interceptable == null || interceptable.invokeLL(65587, null, context, templateConfig) == null) || templateConfig == null) {
            return;
        }
        if ((f35918a == null || !c(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f35918a.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
            a(context, templateConfig, "ksadsdk_template_config", "feed.html");
        }
        f35918a = templateConfig;
    }

    public static SdkConfigData.TemplateConfig c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) ? f35920c != null ? f35920c : new SdkConfigData.TemplateConfig() : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File c(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "feed.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void c(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65590, null, context, templateConfig) == null) {
            if (templateConfig != null && ((f35919b == null || !d(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f35919b.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
                a(context, templateConfig, "ksadsdk_splash_template_config", "feed_splash.html");
            }
            f35919b = templateConfig;
        }
    }

    public static SdkConfigData.TemplateConfig d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? f35921d : (SdkConfigData.TemplateConfig) invokeV.objValue;
    }

    public static synchronized File d(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "feed_splash.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void d(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65593, null, context, templateConfig) == null) {
            if (templateConfig != null && ((f35920c == null || !e(context).exists() || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f35920c.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url))) {
                a(context, templateConfig, "ksadsdk_mini_card_template_config", "mini_card.html");
            }
            f35920c = templateConfig;
        }
    }

    public static synchronized File e(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "mini_card.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    @WorkerThread
    public static void e(Context context, SdkConfigData.TemplateConfig templateConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65595, null, context, templateConfig) == null) {
            if (templateConfig != null) {
                boolean exists = b(context).exists();
                if ((f35921d == null || !exists || (!TextUtils.isEmpty(templateConfig.h5Checksum) && !templateConfig.h5Checksum.equals(f35921d.h5Checksum))) && !TextUtils.isEmpty(templateConfig.h5Url)) {
                    a(context, templateConfig, "ksadsdk_download_pop_window_config", "pop_wind.html");
                }
            }
            f35921d = templateConfig;
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65596, null)) == null) ? am() == 1 : invokeV.booleanValue;
    }

    public static synchronized File f(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, context)) == null) {
            synchronized (c.class) {
                file = new File(new File(context.getCacheDir(), MediaTrackConfig.AE_IMPORT_TEMPLATE), "reward_middle_endcard.html");
            }
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65598, null)) == null) ? an() == 1 : invokeV.booleanValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) ? a.f35929c.b().intValue() : invokeV.intValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65600, null)) == null) ? g() == 1 : invokeV.booleanValue;
    }

    public static int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65601, null)) == null) ? a.f35930d.b().intValue() : invokeV.intValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) ? i() == 1 : invokeV.booleanValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) ? a.D.b().intValue() : invokeV.intValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65604, null)) == null) ? a.f35932f.b().intValue() == 2 : invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65605, null)) == null) ? a.l.b().intValue() == 1 : invokeV.booleanValue;
    }

    public static List<String> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65606, null)) == null) ? a.X.b() : (List) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65607, null)) == null) ? a.W.b() : (String) invokeV.objValue;
    }

    public static boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            if (com.kwad.sdk.d.f37023a == 1) {
                return false;
            }
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_PLAYER_TYPE");
            return ((Boolean) (a2 != null ? a2.getValue() : a.Q.b())).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static float q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) ? a.T.b().floatValue() : invokeV.floatValue;
    }

    public static int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65610, null)) == null) ? a.f35934h.b().intValue() : invokeV.intValue;
    }

    public static int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, null)) == null) {
            int intValue = a.M.b().intValue();
            if (intValue > 0) {
                return intValue;
            }
            return 5000;
        }
        return invokeV.intValue;
    }

    public static int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65612, null)) == null) ? a.f35935i.b().intValue() : invokeV.intValue;
    }

    public static int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65613, null)) == null) ? a.j.b().intValue() : invokeV.intValue;
    }

    public static int v() {
        InterceptResult invokeV;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65614, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_BATCH_MAXNUM");
            return (a2 == null || (num = (Integer) a2.getValue()) == null) ? a.k.b().intValue() : num.intValue();
        }
        return invokeV.intValue;
    }

    @NonNull
    public static List<String> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65615, null)) == null) ? a.Y.b() : (List) invokeV.objValue;
    }

    public static int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65616, null)) == null) {
            DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.g.a(DevelopMangerPlugin.class)).a("KEY_TREND_UI_TYPE");
            return ((Integer) (a2 != null ? a2.getValue() : a.f35933g.b())).intValue();
        }
        return invokeV.intValue;
    }

    public static boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65617, null)) == null) ? a.m.b().intValue() != 0 : invokeV.booleanValue;
    }

    public static boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65618, null)) == null) ? a.n.b().intValue() != 0 : invokeV.booleanValue;
    }
}
