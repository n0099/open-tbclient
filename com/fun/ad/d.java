package com.fun.ad;

import android.content.Context;
import androidx.annotation.Nullable;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdPluginCallback;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes14.dex */
public final class d {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7776b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = true;
    public static boolean g;
    public static boolean h;
    public static long i;
    public static b pEu = new a();

    /* loaded from: classes14.dex */
    public static class a implements b {
        public void a(String str, String str2) {
            FunAdPluginCallback adPluginCallback = FunAdSdk.getAdPluginCallback();
            if (adPluginCallback != null) {
                adPluginCallback.onAdParsed(str, str2);
            }
        }

        public void a(String str, String str2, String str3) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                adCallback.onAdClose(str, str3, str2, g.a(str2));
            }
            bq.k(FunAdSdk.getAppContext(), str, str2, str3);
        }

        public void a(String str, String str2, String str3, int i, String str4) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                adCallback.onAdLoadError(str, str3, str2, g.a(str2), i, str4);
            }
        }

        public void a(String str, String str2, String str3, @Nullable String str4, @Nullable String str5) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                adCallback.onAdClicked(str, str3, str2, g.a(str2));
            }
            bq.a(FunAdSdk.getAppContext(), str, str2, str3);
        }

        public void b(String str, String str2, String str3) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                adCallback.onAdLoad(str, str3, str2, g.a(str2));
            }
        }

        public void c(String str, String str2, String str3) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                adCallback.onAdLoaded(str, str3, str2, g.a(str2));
            }
        }

        public void d(String str, String str2, String str3) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                adCallback.onAdShow(str, str3, str2, g.a(str2));
            }
            bq.j(FunAdSdk.getAppContext(), str, str2, str3);
        }

        public void e(String str, String str2, String str3) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                adCallback.onRewardedVideo(str, str3, str2, g.a(str2));
            }
        }

        public void e(String str, String str2, String str3, int i, String str4) {
            FunAdCallback adCallback = FunAdSdk.getAdCallback();
            if (adCallback != null) {
                adCallback.onAdShowError(str, str3, str2, g.a(str2), i, str4);
            }
        }
    }

    /* loaded from: classes14.dex */
    public interface b {
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String a(String str) {
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 3407) {
            if (hashCode != 3432) {
                if (hashCode != 98810) {
                    if (hashCode == 102199 && str.equals(FunAdSdk.PLATFORM_GDT)) {
                        c2 = 1;
                    }
                } else if (str.equals(FunAdSdk.PLATFORM_CSJ)) {
                    c2 = 0;
                }
            } else if (str.equals(FunAdSdk.PLATFORM_KS)) {
                c2 = 2;
            }
        } else if (str.equals(FunAdSdk.PLATFORM_JY)) {
            c2 = 3;
        }
        switch (c2) {
            case 0:
                return g.e;
            case 1:
                return g.c;
            case 2:
                return g.d;
            case 3:
                return g.f7780b;
            default:
                return null;
        }
    }

    public static void a(FunAdConfig funAdConfig) {
        f7776b = funAdConfig.isVideoSoundEnable();
        c = funAdConfig.isVideoDataFlowAutoStart();
        d = funAdConfig.isReportAdMaterials();
        e = funAdConfig.isLogEnabled();
        f = funAdConfig.isUseCloudAdConfiguration();
        g = funAdConfig.isFilterDuplicatedAd();
        h = funAdConfig.isFilterDeepLinkAd();
        i = funAdConfig.getAdExpiredTimeInterval();
    }
}
