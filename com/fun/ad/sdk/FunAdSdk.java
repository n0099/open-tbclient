package com.fun.ad.sdk;

import a.a.a.a.e;
import a.a.a.a.f;
import a.a.a.a.l;
import a.a.a.a.q;
import a.a.a.a.s.c;
import a.a.a.a.s.h;
import a.a.a.a.v.b;
import a.a.a.a.v.d;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
    public static e funAdCallback;
    public static boolean isAdSdkInitialized;
    public static FunAdConfig sFunAdConfig;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface SdkInitializeCallback {
        void onComplete();
    }

    /* loaded from: classes5.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FunAdCallback f32871a;

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
            this.f32871a = funAdCallback;
        }

        @Override // a.a.a.a.e
        public void onAdClicked(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f32871a.onAdClicked(aVar.f1362d, aVar.f1361c, aVar.l.f1357b);
            }
        }

        @Override // a.a.a.a.e
        public void onAdClose(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f32871a.onAdClose(aVar.f1362d, aVar.f1361c, aVar.l.f1357b);
            }
        }

        @Override // a.a.a.a.e
        public void onAdLoad(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.f32871a.onAdLoad(aVar.f1362d, aVar.f1361c, aVar.l.f1357b);
            }
        }

        @Override // a.a.a.a.e
        public void onAdLoadError(h.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, aVar, i2, str) == null) {
                this.f32871a.onAdLoadError(aVar.f1362d, aVar.f1361c, aVar.l.f1357b, i2, str);
            }
        }

        @Override // a.a.a.a.e
        public void onAdLoaded(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
                this.f32871a.onAdLoaded(aVar.f1362d, aVar.f1361c, aVar.l.f1357b);
            }
        }

        @Override // a.a.a.a.e
        public void onAdShow(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
                this.f32871a.onAdShow(aVar.f1362d, aVar.f1361c, aVar.l.f1357b);
            }
        }

        @Override // a.a.a.a.e
        public void onAdShowError(h.a aVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048582, this, aVar, i2, str) == null) {
                this.f32871a.onAdShowError(aVar.f1362d, aVar.f1361c, aVar.l.f1357b, i2, str);
            }
        }

        @Override // a.a.a.a.e
        public void onRewardedVideo(h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
                this.f32871a.onRewardedVideo(aVar.f1362d, aVar.f1361c, aVar.l.f1357b);
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

    public static e getAdCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? funAdCallback : (e) invokeV.objValue;
    }

    public static FunAdFactory getAdFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            f fVar = f.f1025c;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? c.a(str) : (String) invokeL.objValue;
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
                        if (b.f1396b.getLong("key_flt", 0L) <= 0) {
                            b.f1396b.edit().putLong("key_flt", System.currentTimeMillis()).apply();
                        }
                        initFunAdCallback(funAdCallback2);
                        l.a();
                        l.f1077c = System.currentTimeMillis();
                        l.f1081g = SystemClock.currentThreadTimeMillis();
                        try {
                            Class.forName("com.win.opensdk.PBInitialize");
                        } catch (ClassNotFoundException unused) {
                            q.a("SDK依赖性错误：请在build.gradle里正确集成win-norm-xxx-release-xxx.aar");
                        }
                        try {
                            Class.forName("com.qq.e.ads.nativ.NativeUnifiedADDataAdapter");
                        } catch (ClassNotFoundException unused2) {
                            q.a("SDK依赖性错误：请在build.gradle里正确集成GDTSDK.unionNormal.xxx.aar");
                        }
                        try {
                            Class.forName("com.kwad.sdk.api.KsAdSDK");
                        } catch (ClassNotFoundException unused3) {
                            q.a("SDK依赖性错误：请在build.gradle里正确集成ks_adsdk-xxx.aar");
                        }
                        try {
                            Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
                        } catch (ClassNotFoundException unused4) {
                            q.a("SDK依赖性错误：请在build.gradle里正确集成open_ad_sdk.aar");
                        }
                        try {
                            Class.forName("com.fun.openid.sdk.FunOpenIDSdk");
                        } catch (ClassNotFoundException unused5) {
                            q.a("SDK依赖性错误：请在build.gradle里正确集成fun_openid_sdk_xxx.aar");
                        }
                        l.f1075a.f1084a = System.currentTimeMillis() - l.f1077c;
                        l.f1075a.f1085b = SystemClock.currentThreadTimeMillis() - l.f1081g;
                        c.f1327b = sdkInitializeCallback;
                        c.a(true);
                        isAdSdkInitialized = true;
                        l.f1075a.f1088e = System.currentTimeMillis() - l.f1076b;
                        l.f1075a.f1089f = SystemClock.currentThreadTimeMillis() - l.f1080f;
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
        if (funAdCallback2 instanceof e) {
            funAdCallback = (e) funAdCallback2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c.f1331f : invokeV.booleanValue;
    }
}
