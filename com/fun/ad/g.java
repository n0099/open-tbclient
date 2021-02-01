package com.fun.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.parser.JSONLexer;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdType;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.win.opensdk.PBInitialize;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Boolean> f7781a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static String f7782b;
    public static String c;
    public static String d;
    public static String e;

    public static String a(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1900686778:
                if (str.equals(FunAdType.JY_NATIVE)) {
                    c2 = 24;
                    break;
                }
                break;
            case -1377301807:
                if (str.equals(FunAdType.KS_NATIVE_EXPRESS)) {
                    c2 = '\r';
                    break;
                }
                break;
            case -1303381232:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS2)) {
                    c2 = 19;
                    break;
                }
                break;
            case -1291455752:
                if (str.equals(FunAdType.KS_FULLSCREEN_VIDEO)) {
                    c2 = 14;
                    break;
                }
                break;
            case -1263692214:
                if (str.equals(FunAdType.CSJ_INTERACTION_EXPRESS)) {
                    c2 = 5;
                    break;
                }
                break;
            case -1187931233:
                if (str.equals(FunAdType.KS_NATIVE)) {
                    c2 = 11;
                    break;
                }
                break;
            case -1106926588:
                if (str.equals(FunAdType.KS_REWARD_VIDEO)) {
                    c2 = 15;
                    break;
                }
                break;
            case -1031178769:
                if (str.equals(FunAdType.KS_SPLASH)) {
                    c2 = '\f';
                    break;
                }
                break;
            case -950004865:
                if (str.equals(FunAdType.CSJ_NATIVE_EXPRESS)) {
                    c2 = 7;
                    break;
                }
                break;
            case -942661506:
                if (str.equals(FunAdType.GDT_SPLASH)) {
                    c2 = 23;
                    break;
                }
                break;
            case -596233886:
                if (str.equals(FunAdType.GDT_NATIVE_EXPRESS)) {
                    c2 = 18;
                    break;
                }
                break;
            case -39027267:
                if (str.equals(FunAdType.JY_REWARD_VIDEO)) {
                    c2 = JSONLexer.EOI;
                    break;
                }
                break;
            case 114133351:
                if (str.equals(FunAdType.GDT_UNIFIED_BANNER)) {
                    c2 = 16;
                    break;
                }
                break;
            case 125016359:
                if (str.equals(FunAdType.GDT_UNIFIED_INTERSTITIAL)) {
                    c2 = 20;
                    break;
                }
                break;
            case 347930415:
                if (str.equals(FunAdType.CSJ_SPLASH_EXPRESS)) {
                    c2 = '\n';
                    break;
                }
                break;
            case 425812868:
                if (str.equals(FunAdType.GDT_NATIVE_UNIFIED)) {
                    c2 = 17;
                    break;
                }
                break;
            case 543046357:
                if (str.equals(FunAdType.GDT_REWARD_VIDEO)) {
                    c2 = 22;
                    break;
                }
                break;
            case 556489085:
                if (str.equals(FunAdType.CSJ_BANNER_NATIVE)) {
                    c2 = 6;
                    break;
                }
                break;
            case 647173702:
                if (str.equals(FunAdType.CSJ_INTERACTION)) {
                    c2 = 4;
                    break;
                }
                break;
            case 1168375858:
                if (str.equals(FunAdType.CSJ_REWARD_VIDEO)) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1319012390:
                if (str.equals(FunAdType.CSJ_FULLSCREEN_VIDEO)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1328722634:
                if (str.equals(FunAdType.CSJ_BANNER_EXPRESS)) {
                    c2 = 1;
                    break;
                }
                break;
            case 1578961350:
                if (str.equals(FunAdType.CSJ_BANNER)) {
                    c2 = 0;
                    break;
                }
                break;
            case 1872382491:
                if (str.equals(FunAdType.JY_INTERSTITIAL)) {
                    c2 = 25;
                    break;
                }
                break;
            case 1922685617:
                if (str.equals(FunAdType.CSJ_NATIVE)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1990506825:
                if (str.equals(FunAdType.GDT_FULLSCREEN_VIDEO)) {
                    c2 = 21;
                    break;
                }
                break;
            case 2079438081:
                if (str.equals(FunAdType.CSJ_SPLASH)) {
                    c2 = '\t';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case '\b':
            case '\t':
            case '\n':
                return e;
            case 11:
            case '\f':
            case '\r':
            case 14:
            case 15:
                return d;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                return c;
            case 24:
            case 25:
            case 26:
                return f7782b;
            default:
                return null;
        }
    }

    public static void a() {
        try {
            Class.forName("com.win.opensdk.PBInitialize");
        } catch (ClassNotFoundException e2) {
            Log.e("FunAdSdk", "SDK依赖性错误：请在build.gradle里正确集成win-norm-xxx-release-xxx.aar");
        }
        try {
            Class.forName("com.qq.e.ads.nativ.NativeUnifiedADDataAdapter");
        } catch (ClassNotFoundException e3) {
            Log.e("FunAdSdk", "SDK依赖性错误：请在build.gradle里正确集成GDTSDK.unionNormal.xxx.aar");
        }
        try {
            Class.forName("com.kwad.sdk.api.KsAdSDK");
        } catch (ClassNotFoundException e4) {
            Log.e("FunAdSdk", "SDK依赖性错误：请在build.gradle里正确集成ks_adsdk-xxx.aar");
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
        } catch (ClassNotFoundException e5) {
            Log.e("FunAdSdk", "SDK依赖性错误：请在build.gradle里正确集成open_ad_sdk.aar");
        }
        Log.e("FunAdSdk", "=================SDK_VERSION = 2.4.3");
    }

    public static void a(FunAdConfig funAdConfig, List<ar> list) {
        Boolean bool;
        for (ar arVar : list) {
            m.a("AdSdkInitializer init platform type: " + arVar.f7758b + ", id: " + arVar.f7757a);
            String str = arVar.f7757a;
            if (!TextUtils.isEmpty(str) && ((bool = f7781a.get(str)) == null || !bool.booleanValue())) {
                f7781a.put(str, true);
                String str2 = arVar.f7758b;
                char c2 = 65535;
                int hashCode = str2.hashCode();
                if (hashCode != 3407) {
                    if (hashCode != 3432) {
                        if (hashCode != 98810) {
                            if (hashCode == 102199 && str2.equals(FunAdSdk.PLATFORM_GDT)) {
                                c2 = 2;
                            }
                        } else if (str2.equals(FunAdSdk.PLATFORM_CSJ)) {
                            c2 = 0;
                        }
                    } else if (str2.equals(FunAdSdk.PLATFORM_KS)) {
                        c2 = 1;
                    }
                } else if (str2.equals(FunAdSdk.PLATFORM_JY)) {
                    c2 = 3;
                }
                switch (c2) {
                    case 0:
                        Context appContext = funAdConfig.getAppContext();
                        e = str;
                        TTAdSdk.init(appContext, new TTAdConfig.Builder().appId(str).useTextureView(funAdConfig.isUseTextureView()).appName(funAdConfig.getAppName()).titleBarTheme(funAdConfig.getTitleBarTheme()).allowShowNotify(false).allowShowPageWhenScreenLock(true).debug(false).directDownloadNetworkType(4, 1).supportMultiProcess(funAdConfig.isSupportMultiProcess()).asyncInit(funAdConfig.isAsyncInit()).build());
                        continue;
                    case 1:
                        Context appContext2 = funAdConfig.getAppContext();
                        d = str;
                        KsAdSDK.init(appContext2, new SdkConfig.Builder().appId(str).appName(funAdConfig.getAppName()).showNotification(false).debug(false).canReadICCID(true).canReadNearbyWifiList(true).canReadMacAddress(true).build());
                        continue;
                    case 2:
                        Context appContext3 = funAdConfig.getAppContext();
                        c = str;
                        GDTADManager.getInstance().initWith(appContext3, str);
                        GlobalSetting.setChannel(3);
                        continue;
                    case 3:
                        Context appContext4 = funAdConfig.getAppContext();
                        f7782b = str;
                        PBInitialize.init(appContext4, str);
                        continue;
                }
            }
        }
    }
}
