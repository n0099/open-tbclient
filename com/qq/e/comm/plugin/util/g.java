package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import android.widget.ImageView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
/* loaded from: classes15.dex */
public class g {
    public static String a(com.qq.e.comm.plugin.ad.e eVar) {
        String str;
        switch (eVar) {
            case SPLASH:
                str = "splashAdLogo_";
                break;
            case NATIVEUNIFIEDAD:
                str = "nativeAdLogo_";
                break;
            case UNIFIED_INTERSTITIAL_FULLSCREEN:
            case REWARDVIDEOAD:
                str = "rewardAdLogo_";
                break;
            default:
                str = "nativeAdLogo_";
                break;
        }
        SM sm = GDTADManager.getInstance().getSM();
        String string = sm != null ? sm.getString(str + "logo") : null;
        if (TextUtils.isEmpty(string)) {
            switch (eVar) {
                case SPLASH:
                    return "http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkSplashAdLogo.png";
                case NATIVEUNIFIEDAD:
                    return "http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkNativeAdLogo.png";
                case UNIFIED_INTERSTITIAL_FULLSCREEN:
                case REWARDVIDEOAD:
                    return "http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkRewardAdLogo.png";
                default:
                    return "http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkNativeAdLogo.png";
            }
        }
        return string;
    }

    public static void a(ImageView imageView) {
        com.qq.e.comm.plugin.p.a.a().a("http://imgcache.qq.com/qzone/biz/gdt/dev/sdk/cdn/resources/common/SdkRewardBrowseAdLogo.png", imageView);
    }

    public static void a(ImageView imageView, com.qq.e.comm.plugin.ad.e eVar) {
        String a2 = a(eVar);
        if (imageView == null || TextUtils.isEmpty(a2)) {
            return;
        }
        com.qq.e.comm.plugin.p.a.a().a(a2, imageView);
    }
}
