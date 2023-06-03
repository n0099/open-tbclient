package com.fun.ad.sdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import java.util.HashMap;
/* loaded from: classes9.dex */
public final class FunAdType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ADX_INTERSTITIAL = "adxInterstitial";
    public static final String ADX_NATIVE_TEMPLATE_MEDIUM = "adxNativeTemplateMedium";
    public static final String ADX_NATIVE_TEMPLATE_SMALL = "adxNativeTemplateSmall";
    public static final String ADX_NATIVE_UNIFIED = "adxNativeUnified";
    public static final String ADX_SPLASH = "adxSplash";
    public static final String AM_INTERSTITIAL = "amInterstitial";
    public static final String AM_NATIVE_TEMPLATE_MEDIUM = "amNativeTemplateMedium";
    public static final String AM_NATIVE_TEMPLATE_SMALL = "amNativeTemplateSmall";
    public static final String AM_NATIVE_UNIFIED = "amNativeUnified";
    public static final String AM_SPLASH = "amSplash";
    public static final String AX_FULLSCREEN_VIDEO = "axFullScreenVideo";
    public static final String AX_INTERSTITIAL = "axInterstitial";
    public static final String AX_REWARD_VIDEO = "axRewardVideo";
    public static final String BAIDU_EXPRESS_INTERSTITIAL = "baiduExpressInterstitial";
    public static final String BAIDU_FEED = "baiduFeed";
    public static final String BAIDU_FEED_EXPRESS = "baiduFeedExpress";
    public static final String BAIDU_FULLSCREEN_VIDEO = "baiduFullScreenVideo";
    public static final String BAIDU_NATIVE_CPU = "baiduNativeCpu";
    public static final String BAIDU_REWARD_VIDEO = "baiduRewardVideo";
    public static final String BAIDU_SPLASH = "baiduSplash";
    public static final String BIGO_INTERSTITIAL = "bigoInterstitial";
    public static final String BIGO_NATIVE_UNIFIED = "bigoNativeUnified";
    public static final String BIGO_REWARD_VIDEO = "bigoRewardVideo";
    public static final String BZ_FEED_EXPRESS = "bzFeedExpress";
    public static final String BZ_SPLASH = "bzSplash";
    public static final String CJ_BANNER = "cjBanner";
    public static final String CJ_FULLSCREEN_VIDEO = "cjFullScreenVideo";
    public static final String CJ_INTERSTITIAL = "cjInterstitial";
    public static final String CJ_NATIVE = "cjNative";
    public static final String CJ_REWARD_VIDEO = "cjRewardVideo";
    public static final String CJ_SPLASH = "cjSplash";
    public static final String CM_SPLASH = "cmSplash";
    public static final String CSJ_BANNER_EXPRESS = "csjBannerExpress";
    public static final String CSJ_BANNER_NATIVE = "csjBannerNative";
    public static final String CSJ_DRAW_NATIVE = "csjDrawNative";
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
    public static final String GM_FULLSCREEN = "gmFullscreenVideo";
    public static final String GM_INTERSTITIAL = "gmInterstitial";
    public static final String GM_INTERSTITIALFULL = "gmInterstitialfull";
    public static final String GM_NATIVE = "gmNative";
    public static final String GM_NATIVE_EXPRESS = "gmNativeExpress";
    public static final String GM_REWARD = "gmRewardVideo";
    public static final String HW_BANNER = "hwBanner";
    public static final String HW_INTERSTITIAL = "hwInterstitial";
    public static final String HW_NATIVE = "hwNative";
    public static final String HW_REWARD_VIDEO = "hwRewardVideo";
    public static final String IS_BANNER = "isBanner";
    public static final String IS_INTERSTITIAL = "isInterstitial";
    public static final String IS_REWARD = "isRewardVideo";
    public static final String JY_DRAW_VIDEO = "jyDrawVideo";
    public static final String JY_INTERSTITIAL = "jyInterstitial";
    public static final String JY_NATIVE = "jyNative";
    public static final String JY_REWARD_VIDEO = "jyRewardVideo";
    public static final String JY_SPLASH = "jySplash";
    public static final String KDS_DRAW_VIDEO = "kdsDrawVideo";
    public static final String KDS_FULLSCREEN_VIDEO = "kdsFullscreenVideo";
    public static final String KDS_NATIVE_VIDEO = "kdsNativeVideo";
    public static final String KDS_REWARD_VIDEO = "kdsRewardVideo";
    public static final String KDS_REWARD_VIDEO2 = "kdsRewardVideo2";
    public static final String KS_DRAW_VIDEO = "ksDrawVideo";
    public static final String KS_FULLSCREEN_VIDEO = "ksFullscreenVideo";
    public static final String KS_INTERSTITIAL_EXPRESS = "ksInterstitialExpress";
    public static final String KS_NATIVE = "ksNative";
    public static final String KS_NATIVE_EXPRESS = "ksNativeExpress";
    public static final String KS_REWARD_VIDEO = "ksRewardVideo";
    public static final String KS_SPLASH = "ksSplash";
    public static final String MAX_BANNER = "maxBanner";
    public static final String MAX_INTERSTITIAL = "maxInterstitial";
    public static final String MAX_NATIVE = "maxNative";
    public static final String MAX_NATIVE_TEMPLATE = "maxNativeTemplate";
    public static final String MAX_REWARD_VIDEO = "maxRewardVideo";
    public static final String MB_INTERSTITIAL = "mbInterstitial";
    public static final String MB_INTERSTITIAL2 = "mbInterstitial2";
    public static final String MB_REWARD_VIDEO = "mbRewardVideo";
    public static final String MB_SPLASH = "mbSplash";
    public static final String MH_NATIVE = "mhNative";
    public static final String MH_REWARD_VIDEO = "mhRewardVideo";
    public static final String MM_BANNER = "mmBanner";
    public static final String MM_INTERSTITIAL = "mmInterstitial";
    public static final String MM_NATIVE = "mmNative";
    public static final String MM_NATIVE_EXPRESS = "mmNativeExpress";
    public static final String MM_NATIVE_VIDEO = "mmNativeVideo";
    public static final String MM_REWARD_VIDEO = "mmRewardVideo";
    public static final String OPPO_BANNER = "oppoBanner";
    public static final String OPPO_FULLSCREEN_VIDEO = "oppoFullscreenVideo";
    public static final String OPPO_INTERSTITIAL = "oppoInterstitial";
    public static final String OPPO_NATIVE = "oppoNative";
    public static final String OPPO_NATIVE_EXPRESS = "oppoNativeExpress";
    public static final String OPPO_REWARD_VIDEO = "oppoRewardVideo";
    public static final String OW_FULLSCREEN_VIDEO = "owFullscreenVideo";
    public static final String OW_INTERSTITIAL = "owInterstitial";
    public static final String OW_NATIVE = "owNative";
    public static final String OW_REWARD_VIDEO = "owRewardVideo";
    public static final String OW_SPLASH = "owSplash";
    public static final String PG_INTERSTITIAL = "pgInterstitial";
    public static final String PG_NATIVE = "pgNative";
    public static final String PG_SPlASH = "pgSplash";
    public static final String SIG_INTERSTITIAL = "sigInterstitial";
    public static final String SIG_REWARD_VIDEO = "sigRewardVideo";
    public static final String SIG_SPLASH = "sigSplash";
    public static final String TA_INTERSTITIAL = "taInterstitial";
    public static final String TA_MATERIAL_INTERSTITIAL = "taMaterialInterstitial";
    public static final String TOBID_INTERSTITIAL = "tobidInterstitial";
    public static final String TOBID_NATIVE = "tobidNative";
    public static final String TOBID_REWARD_VIDEO = "tobidRewardVideo";
    public static final String VIVO_BANNER = "vivoBanner";
    public static final String VIVO_FULLSCREEN = "vivoFullscreenVideo";
    public static final String VIVO_INTERSTITIAL = "vivoInterstitial";
    public static final String VIVO_NATIVE = "vivoNative";
    public static final String VIVO_NATIVE_EXPRESS = "vivoNativeExpress";
    public static final String VIVO_REWARD = "vivoRewardVideo";
    public static final HashMap<String, FunAdType> a;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final AdType c;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class AdType {
        public static /* synthetic */ Interceptable $ic;
        public static final AdType BANNER;
        public static final AdType DRAW;
        public static final AdType FULL_SCREEN;
        public static final AdType INTERSTITIAL;
        public static final AdType NATIVE;
        public static final AdType REWARD;
        public static final AdType SPLASH;
        public static final /* synthetic */ AdType[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-841063809, "Lcom/fun/ad/sdk/FunAdType$AdType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-841063809, "Lcom/fun/ad/sdk/FunAdType$AdType;");
                    return;
                }
            }
            AdType adType = new AdType("BANNER", 0);
            BANNER = adType;
            AdType adType2 = new AdType("SPLASH", 1);
            SPLASH = adType2;
            AdType adType3 = new AdType("FULL_SCREEN", 2);
            FULL_SCREEN = adType3;
            AdType adType4 = new AdType("INTERSTITIAL", 3);
            INTERSTITIAL = adType4;
            AdType adType5 = new AdType(Constant.TYPE_NATIVE, 4);
            NATIVE = adType5;
            AdType adType6 = new AdType("REWARD", 5);
            REWARD = adType6;
            AdType adType7 = new AdType("DRAW", 6);
            DRAW = adType7;
            a = new AdType[]{adType, adType2, adType3, adType4, adType5, adType6, adType7};
        }

        public AdType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AdType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AdType) Enum.valueOf(AdType.class, str) : (AdType) invokeL.objValue;
        }

        public static AdType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AdType[]) a.clone() : (AdType[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1026463350, "Lcom/fun/ad/sdk/FunAdType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1026463350, "Lcom/fun/ad/sdk/FunAdType;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public FunAdType(String str, AdType adType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, adType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = str;
        this.c = adType;
    }

    public static FunAdType obtainType(Ssp.Pid pid, AdType adType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pid, adType)) == null) {
            HashMap<String, FunAdType> hashMap = a;
            FunAdType funAdType = hashMap.get(pid.type);
            if (funAdType != null) {
                return funAdType;
            }
            FunAdType funAdType2 = new FunAdType(pid.ssp.type, adType);
            hashMap.put(pid.type, funAdType2);
            return funAdType2;
        }
        return (FunAdType) invokeLL.objValue;
    }

    public AdType getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (AdType) invokeV.objValue;
    }

    public String getPlatform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
    }
}
