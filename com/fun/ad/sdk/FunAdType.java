package com.fun.ad.sdk;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class FunAdType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BAIDU_FEED = "baiduFeed";
    public static final String BAIDU_NATIVE_CPU = "baiduNativeCpu";
    public static final String BAIDU_SPLASH = "baiduSplash";
    public static final String CSJ_BANNER_EXPRESS = "csjBannerExpress";
    public static final String CSJ_BANNER_NATIVE = "csjBannerNative";
    public static final String CSJ_DRAW_VIDEO = "csjDrawVideo";
    public static final String CSJ_FULLSCREEN_VIDEO = "csjFullscreenVideo";
    public static final String CSJ_INTERACTION_EXPRESS = "csjInterstitialExpress";
    public static final String CSJ_INTERSITIAL_2 = "csjInterstitial2";
    public static final String CSJ_NATIVE = "csjNative";
    public static final String CSJ_NATIVE_EXPRESS = "csjNativeExpress";
    public static final String CSJ_REWARD_VIDEO = "csjRewardVideo";
    public static final String CSJ_SPLASH = "csjSplash";
    public static final String CSJ_SPLASH_EXPRESS = "csjSplashExpress";
    public static final String GDT_FULLSCREEN_VIDEO = "gdtFullscreenVideo";
    public static final String GDT_NATIVE_EXPRESS = "gdtNativeExpress";
    public static final String GDT_NATIVE_EXPRESS2 = "gdtNativeExpress2";
    public static final String GDT_NATIVE_UNIFIED = "gdtNativeUnified";
    public static final String GDT_REWARD_VIDEO = "gdtRewardVideo";
    public static final String GDT_SPLASH = "gdtSplash";
    public static final String GDT_UNIFIED_BANNER = "gdtUnifiedBanner";
    public static final String GDT_UNIFIED_INTERSTITIAL = "gdtUnifiedInterstitial";
    public static final String JY_INTERSTITIAL = "jyInterstitial";
    public static final String JY_NATIVE = "jyNative";
    public static final String JY_REWARD_VIDEO = "jyRewardVideo";
    public static final String JY_SPLASH = "jySplash";
    public static final String KS_DRAW_VIDEO = "ksDrawVideo";
    public static final String KS_FULLSCREEN_VIDEO = "ksFullscreenVideo";
    public static final String KS_INTERSTITIAL_EXPRESS = "ksInterstitialExpress";
    public static final String KS_NATIVE = "ksNative";
    public static final String KS_NATIVE_EXPRESS = "ksNativeExpress";
    public static final String KS_REWARD_VIDEO = "ksRewardVideo";
    public static final String KS_SPLASH = "ksSplash";
    public transient /* synthetic */ FieldHolder $fh;

    public FunAdType() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
