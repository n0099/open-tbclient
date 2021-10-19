package com.fun.ad.sdk;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import b.a.a.a.f;
import b.a.a.a.g;
import b.a.a.a.m;
import b.a.a.a.r;
import b.a.a.a.u.c;
import b.a.a.a.u.h;
import b.a.a.a.x.b;
import b.a.a.a.x.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class FunAdSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_JY = "jy";
    public static final String PLATFORM_KS = "ks";
    public static f funAdCallback;
    public static boolean isAdSdkInitialized;
    public static FunAdConfig sFunAdConfig;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface SdkInitializeCallback {
        void onComplete();
    }

    /* loaded from: classes9.dex */
    public class a implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdCallback f70294a;

        public a(FunAdCallback funAdCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {funAdCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70294a = funAdCallback;
        }

        @Override // b.a.a.a.f
        public void onAdClicked(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f70294a.onAdClicked(aVar.f1449d, aVar.f1448c, aVar.l.f1444b);
            }
        }

        @Override // b.a.a.a.f
        public void onAdClose(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f70294a.onAdClose(aVar.f1449d, aVar.f1448c, aVar.l.f1444b);
            }
        }

        @Override // b.a.a.a.f
        public void onAdLoad(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.f70294a.onAdLoad(aVar.f1449d, aVar.f1448c, aVar.l.f1444b);
            }
        }

        @Override // b.a.a.a.f
        public void onAdLoadError(h.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, aVar, i2, str) == null) {
                this.f70294a.onAdLoadError(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, i2, str);
            }
        }

        @Override // b.a.a.a.f
        public void onAdLoaded(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f70294a.onAdLoaded(aVar.f1449d, aVar.f1448c, aVar.l.f1444b);
            }
        }

        @Override // b.a.a.a.f
        public void onAdShow(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
                this.f70294a.onAdShow(aVar.f1449d, aVar.f1448c, aVar.l.f1444b);
            }
        }

        @Override // b.a.a.a.f
        public void onAdShowError(h.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048582, this, aVar, i2, str) == null) {
                this.f70294a.onAdShowError(aVar.f1449d, aVar.f1448c, aVar.l.f1444b, i2, str);
            }
        }

        @Override // b.a.a.a.f
        public void onRewardedVideo(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                this.f70294a.onRewardedVideo(aVar.f1449d, aVar.f1448c, aVar.l.f1444b);
            }
        }
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

    public static f getAdCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? funAdCallback : (f) invokeV.objValue;
    }

    public static FunAdFactory getAdFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            g gVar = g.f1067c;
            return gVar == null ? new g() : gVar;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? c.b(str) : (String) invokeL.objValue;
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
                                d.f("Please don't init FunAdSdk duplicated.", new Object[0]);
                            }
                            return false;
                        }
                        sFunAdConfig = funAdConfig;
                        if (b.f1484b.getLong("key_flt", 0L) <= 0) {
                            b.f1484b.edit().putLong("key_flt", System.currentTimeMillis()).apply();
                        }
                        initFunAdCallback(funAdCallback2);
                        m.a();
                        m.f1133c = System.currentTimeMillis();
                        m.f1137g = SystemClock.currentThreadTimeMillis();
                        try {
                            Class.forName("com.win.opensdk.PBInitialize");
                        } catch (ClassNotFoundException unused) {
                            r.h("SDK依赖性错误：请在build.gradle里正确集成win-norm-xxx-release-xxx.aar");
                        }
                        try {
                            Class.forName("com.qq.e.ads.nativ.NativeUnifiedADDataAdapter");
                        } catch (ClassNotFoundException unused2) {
                            r.h("SDK依赖性错误：请在build.gradle里正确集成GDTSDK.unionNormal.xxx.aar");
                        }
                        try {
                            Class.forName("com.kwad.sdk.api.KsAdSDK");
                        } catch (ClassNotFoundException unused3) {
                            r.h("SDK依赖性错误：请在build.gradle里正确集成ks_adsdk-xxx.aar");
                        }
                        try {
                            Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
                        } catch (ClassNotFoundException unused4) {
                            r.h("SDK依赖性错误：请在build.gradle里正确集成open_ad_sdk.aar");
                        }
                        try {
                            Class.forName("com.fun.openid.sdk.FunOpenIDSdk");
                        } catch (ClassNotFoundException unused5) {
                            r.h("SDK依赖性错误：请在build.gradle里正确集成fun_openid_sdk_xxx.aar");
                        }
                        m.f1131a.f1140a = System.currentTimeMillis() - m.f1133c;
                        m.f1131a.f1141b = SystemClock.currentThreadTimeMillis() - m.f1137g;
                        c.f1414b = sdkInitializeCallback;
                        c.d(true);
                        isAdSdkInitialized = true;
                        m.f1131a.f1144e = System.currentTimeMillis() - m.f1132b;
                        m.f1131a.f1145f = SystemClock.currentThreadTimeMillis() - m.f1136f;
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

    public static void initFunAdCallback(FunAdCallback funAdCallback2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, funAdCallback2) == null) || funAdCallback2 == null) {
            return;
        }
        if (funAdCallback2 instanceof f) {
            funAdCallback = (f) funAdCallback2;
        } else {
            funAdCallback = new a(funAdCallback2);
        }
    }

    public static boolean isLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            FunAdConfig funAdConfig = sFunAdConfig;
            return funAdConfig != null && funAdConfig.logEnabled;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSdkInitializeComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.f1418f : invokeV.booleanValue;
    }
}
