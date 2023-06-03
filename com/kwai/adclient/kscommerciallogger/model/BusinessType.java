package com.kwai.adclient.kscommerciallogger.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class BusinessType {
    public static final /* synthetic */ BusinessType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BusinessType AD_DRAW;
    public static final BusinessType AD_FEED;
    public static final BusinessType AD_FULLSCREEN;
    public static final BusinessType AD_INTERSTITIAL;
    public static final BusinessType AD_NATIVE;
    public static final BusinessType AD_REWARD;
    public static final BusinessType AD_SDK_INIT;
    public static final BusinessType AD_SPLASH;
    public static final BusinessType AD_WEBVIEW;
    public static final BusinessType CU_FEED;
    public static final BusinessType CU_FEED_SLIDE;
    public static final BusinessType CU_HORIZONTAL_FEED;
    public static final BusinessType CU_HOTSPOT_ENTRY;
    public static final BusinessType CU_HOTSPOT_SLIDE;
    public static final BusinessType CU_IMAGE_TEXT_DETAIL;
    public static final BusinessType CU_IMAGE_TEXT_FEED;
    public static final BusinessType CU_PROFILE;
    public static final BusinessType CU_PROFILE_SLIDE;
    public static final BusinessType CU_SLIDE;
    public static final BusinessType CU_VIDEO_DETAIL;
    public static final BusinessType CU_WALLPAPER_FEED;
    public static final BusinessType CU_WALLPAPER_SLIDE;
    public static final BusinessType EU_LIVE_REPLAY;
    public static final BusinessType EU_LIVE_SLIDE;
    public static final BusinessType OTHER;
    public static final BusinessType TACHIKOMA;
    public static final BusinessType WEB_CACHE;
    public transient /* synthetic */ FieldHolder $fh;
    public String value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-954864850, "Lcom/kwai/adclient/kscommerciallogger/model/BusinessType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-954864850, "Lcom/kwai/adclient/kscommerciallogger/model/BusinessType;");
                return;
            }
        }
        TACHIKOMA = new BusinessType("TACHIKOMA", 0, "TACHIKOMA");
        AD_SPLASH = new BusinessType("AD_SPLASH", 1, "AD_SPLASH");
        AD_INTERSTITIAL = new BusinessType("AD_INTERSTITIAL", 2, "AD_INTERSTITIAL");
        AD_FULLSCREEN = new BusinessType("AD_FULLSCREEN", 3, "AD_FULLSCREEN");
        AD_REWARD = new BusinessType("AD_REWARD", 4, "AD_REWARD");
        AD_FEED = new BusinessType("AD_FEED", 5, "AD_FEED");
        AD_NATIVE = new BusinessType("AD_NATIVE", 6, "AD_NATIVE");
        AD_DRAW = new BusinessType("AD_DRAW", 7, "AD_DRAW");
        CU_SLIDE = new BusinessType("CU_SLIDE", 8, "CU_SLIDE");
        CU_PROFILE = new BusinessType("CU_PROFILE", 9, "CU_PROFILE");
        CU_PROFILE_SLIDE = new BusinessType("CU_PROFILE_SLIDE", 10, "CU_PROFILE_SLIDE");
        CU_FEED = new BusinessType("CU_FEED", 11, "CU_FEED");
        CU_FEED_SLIDE = new BusinessType("CU_FEED_SLIDE", 12, "CU_FEED_SLIDE");
        CU_HOTSPOT_ENTRY = new BusinessType("CU_HOTSPOT_ENTRY", 13, "CU_HOTSPOT_ENTRY");
        CU_HOTSPOT_SLIDE = new BusinessType("CU_HOTSPOT_SLIDE", 14, "CU_HOTSPOT_SLIDE");
        CU_HORIZONTAL_FEED = new BusinessType("CU_HORIZONTAL_FEED", 15, "CU_HORIZONTAL_FEED");
        CU_VIDEO_DETAIL = new BusinessType("CU_VIDEO_DETAIL", 16, "CU_VIDEO_DETAIL");
        CU_IMAGE_TEXT_FEED = new BusinessType("CU_IMAGE_TEXT_FEED", 17, "CU_IMAGE_TEXT_FEED");
        CU_IMAGE_TEXT_DETAIL = new BusinessType("CU_IMAGE_TEXT_DETAIL", 18, "CU_IMAGE_TEXT_DETAIL");
        CU_WALLPAPER_FEED = new BusinessType("CU_WALLPAPER_FEED", 19, "CU_WALLPAPER_FEED");
        CU_WALLPAPER_SLIDE = new BusinessType("CU_WALLPAPER_SLIDE", 20, "CU_WALLPAPER_SLIDE");
        EU_LIVE_SLIDE = new BusinessType("EU_LIVE_SLIDE", 21, "EU_LIVE_SLIDE");
        EU_LIVE_REPLAY = new BusinessType("EU_LIVE_REPLAY", 22, "EU_LIVE_REPLAY");
        WEB_CACHE = new BusinessType("WEB_CACHE", 23, "WEB_CACHE");
        AD_SDK_INIT = new BusinessType("AD_SDK_INIT", 24, "AD_SDK_INIT");
        AD_WEBVIEW = new BusinessType("AD_WEBVIEW", 25, "AD_WEBVIEW");
        BusinessType businessType = new BusinessType("OTHER", 26, "OTHER");
        OTHER = businessType;
        $VALUES = new BusinessType[]{TACHIKOMA, AD_SPLASH, AD_INTERSTITIAL, AD_FULLSCREEN, AD_REWARD, AD_FEED, AD_NATIVE, AD_DRAW, CU_SLIDE, CU_PROFILE, CU_PROFILE_SLIDE, CU_FEED, CU_FEED_SLIDE, CU_HOTSPOT_ENTRY, CU_HOTSPOT_SLIDE, CU_HORIZONTAL_FEED, CU_VIDEO_DETAIL, CU_IMAGE_TEXT_FEED, CU_IMAGE_TEXT_DETAIL, CU_WALLPAPER_FEED, CU_WALLPAPER_SLIDE, EU_LIVE_SLIDE, EU_LIVE_REPLAY, WEB_CACHE, AD_SDK_INIT, AD_WEBVIEW, businessType};
    }

    public BusinessType(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.value = str2;
    }

    public static BusinessType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BusinessType) Enum.valueOf(BusinessType.class, str) : (BusinessType) invokeL.objValue;
    }

    public static BusinessType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BusinessType[]) $VALUES.clone() : (BusinessType[]) invokeV.objValue;
    }
}
