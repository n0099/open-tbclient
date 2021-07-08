package com.fun.ad.sdk;

import a.a.a.a.a;
import a.a.a.a.f;
import a.a.a.a.j;
import a.a.a.a.m;
import a.a.a.a.y.d;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class FunAdSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_JY = "jy";
    public static final String PLATFORM_KS = "ks";
    public static FunAdCallback funAdCallback;
    public static boolean isAdSdkInitialized;
    public static FunAdConfig sFunAdConfig;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface SdkInitializeCallback {
        void onComplete();
    }

    public FunAdSdk() {
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

    public static FunAdCallback getAdCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? funAdCallback : (FunAdCallback) invokeV.objValue;
    }

    public static FunAdFactory getAdFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            f fVar = f.f1026c;
            return fVar == null ? new f() : fVar;
        }
        return (FunAdFactory) invokeV.objValue;
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sFunAdConfig.appContext : (Context) invokeV.objValue;
    }

    public static FunAdConfig getFunAdConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sFunAdConfig : (FunAdConfig) invokeV.objValue;
    }

    public static String getPlatformId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? j.a(str) : (String) invokeL.objValue;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, funAdConfig, funAdCallback2)) == null) ? init(funAdConfig, funAdCallback2, null) : invokeLL.booleanValue;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback2, SdkInitializeCallback sdkInitializeCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, funAdConfig, funAdCallback2, sdkInitializeCallback)) == null) {
            if (funAdConfig != null) {
                if (funAdConfig.userId != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        if (isAdSdkInitialized) {
                            if (sFunAdConfig.logEnabled) {
                                d.b("Please don't init FunAdSdk duplicated.", new Object[0]);
                            }
                            return false;
                        }
                        sFunAdConfig = funAdConfig;
                        funAdCallback = funAdCallback2;
                        m.a();
                        m.f1085c = System.currentTimeMillis();
                        m.f1089g = SystemClock.currentThreadTimeMillis();
                        try {
                            Class.forName("com.win.opensdk.PBInitialize");
                        } catch (ClassNotFoundException unused) {
                            a.a("SDK依赖性错误：请在build.gradle里正确集成win-norm-xxx-release-xxx.aar");
                        }
                        try {
                            Class.forName("com.qq.e.ads.nativ.NativeUnifiedADDataAdapter");
                        } catch (ClassNotFoundException unused2) {
                            a.a("SDK依赖性错误：请在build.gradle里正确集成GDTSDK.unionNormal.xxx.aar");
                        }
                        try {
                            Class.forName("com.kwad.sdk.api.KsAdSDK");
                        } catch (ClassNotFoundException unused3) {
                            a.a("SDK依赖性错误：请在build.gradle里正确集成ks_adsdk-xxx.aar");
                        }
                        try {
                            Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
                        } catch (ClassNotFoundException unused4) {
                            a.a("SDK依赖性错误：请在build.gradle里正确集成open_ad_sdk.aar");
                        }
                        try {
                            Class.forName("com.fun.openid.sdk.FunOpenIDSdk");
                        } catch (ClassNotFoundException unused5) {
                            a.a("SDK依赖性错误：请在build.gradle里正确集成fun_openid_sdk_xxx.aar");
                        }
                        m.f1083a.f1092a = System.currentTimeMillis() - m.f1085c;
                        m.f1083a.f1093b = SystemClock.currentThreadTimeMillis() - m.f1089g;
                        j.f1048b = sdkInitializeCallback;
                        j.a(true);
                        isAdSdkInitialized = true;
                        m.f1083a.f1096e = System.currentTimeMillis() - m.f1084b;
                        m.f1083a.f1097f = SystemClock.currentThreadTimeMillis() - m.f1088f;
                        return true;
                    }
                    throw new IllegalStateException("This method could only be called on main thread.");
                }
                throw new IllegalArgumentException("FunAdConfig.userId must not be null!");
            }
            throw new IllegalArgumentException("FunAdConfig must not be null!");
        }
        return invokeLLL.booleanValue;
    }

    public static boolean isLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            FunAdConfig funAdConfig = sFunAdConfig;
            return funAdConfig != null && funAdConfig.logEnabled;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSdkInitializeComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? j.f1052f : invokeV.booleanValue;
    }
}
