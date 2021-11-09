package com.fun.ad.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.g.c;
import b.g.e;
import b.g.h;
import b.g.t0;
import b.g.u0;
import b.g.v;
import b.g.z;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.UUID;
/* loaded from: classes11.dex */
public final class FunAdSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLATFORM_BAIDU = "baidu";
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_JY = "jy";
    public static final String PLATFORM_KDS = "kds";
    public static final String PLATFORM_KS = "ks";

    /* renamed from: a  reason: collision with root package name */
    public static t0 f62723a;

    /* renamed from: b  reason: collision with root package name */
    public static FunAdConfig f62724b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f62725c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
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

    public static t0 getAdCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f62723a : (t0) invokeV.objValue;
    }

    public static FunAdFactory getAdFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f62725c) {
                return h.f31161e;
            }
            throw new RuntimeException("FunAdSdk not initialized, please call init first.");
        }
        return (FunAdFactory) invokeV.objValue;
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f62724b.appContext : (Context) invokeV.objValue;
    }

    public static String getBaiduCustomUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            SharedPreferences sharedPreferences = v.f31248b;
            String string = sharedPreferences.getString("key_bd_tk", null);
            if (TextUtils.isEmpty(string)) {
                String substring = UUID.randomUUID().toString().replace("-", "").substring(0, 16);
                sharedPreferences.edit().putString("key_bd_tk", substring).apply();
                return substring;
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public static FunAdConfig getFunAdConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f62724b : (FunAdConfig) invokeV.objValue;
    }

    public static String getPlatformId(String str) {
        InterceptResult invokeL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            Handler handler = h.f31157a;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            z zVar = h.f31160d;
            synchronized (zVar) {
                cVar = zVar.f31278a;
            }
            if (cVar == null) {
                LogPrinter.d("No adConfig found now.", new Object[0]);
                return null;
            }
            for (Ssp ssp : cVar.f31125a) {
                if (ssp.type.equals(str)) {
                    return ssp.sspId;
                }
            }
            LogPrinter.d("No target ssp found for platform:%s", str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, funAdConfig, funAdCallback)) == null) ? init(funAdConfig, funAdCallback, null) : invokeLL.booleanValue;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback, SdkInitializeCallback sdkInitializeCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, funAdConfig, funAdCallback, sdkInitializeCallback)) == null) {
            if (funAdConfig != null) {
                if (funAdConfig.userId != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        if (f62725c) {
                            if (f62724b.logEnabled) {
                                LogPrinter.e("Please don't init FunAdSdk duplicated.", new Object[0]);
                            }
                            return false;
                        }
                        f62724b = funAdConfig;
                        SharedPreferences sharedPreferences = v.f31248b;
                        if (sharedPreferences.getLong("key_flt", 0L) <= 0) {
                            sharedPreferences.edit().putLong("key_flt", System.currentTimeMillis()).apply();
                        }
                        if (funAdCallback != null) {
                            if (funAdCallback instanceof t0) {
                                f62723a = (t0) funAdCallback;
                            } else {
                                f62723a = new t0(funAdCallback) { // from class: com.fun.ad.sdk.FunAdSdk.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ FunAdCallback f62726a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {funAdCallback};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f62726a = funAdCallback;
                                    }

                                    @Override // b.g.t0
                                    public void onAdClicked(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, pid) == null) {
                                            this.f62726a.onAdClicked(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // b.g.t0
                                    public void onAdClose(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pid) == null) {
                                            this.f62726a.onAdClose(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // b.g.t0
                                    public void onAdLoad(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, pid) == null) {
                                            this.f62726a.onAdLoad(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // b.g.t0
                                    public void onAdLoadError(Ssp.Pid pid, int i2, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLIL(1048579, this, pid, i2, str) == null) {
                                            this.f62726a.onAdLoadError(pid.type, pid.pid, pid.ssp.sspId, i2, str);
                                        }
                                    }

                                    @Override // b.g.t0
                                    public void onAdLoaded(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048580, this, pid) == null) {
                                            this.f62726a.onAdLoaded(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // b.g.t0
                                    public void onAdShow(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048581, this, pid) == null) {
                                            this.f62726a.onAdShow(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // b.g.t0
                                    public void onAdShowError(Ssp.Pid pid, int i2, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLIL(1048582, this, pid, i2, str) == null) {
                                            this.f62726a.onAdShowError(pid.type, pid.pid, pid.ssp.sspId, i2, str);
                                        }
                                    }

                                    @Override // b.g.t0
                                    public void onRewardedVideo(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048583, this, pid) == null) {
                                            this.f62726a.onRewardedVideo(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }
                                };
                            }
                        }
                        e.a aVar = e.f31129a;
                        e.f31130b = System.currentTimeMillis();
                        e.f31131c = SystemClock.currentThreadTimeMillis();
                        f62725c = true;
                        h.f31158b = sdkInitializeCallback;
                        h.e(true);
                        u0 u0Var = h.f31161e;
                        e.a aVar2 = e.f31129a;
                        aVar2.f31134c = System.currentTimeMillis() - e.f31130b;
                        aVar2.f31135d = SystemClock.currentThreadTimeMillis() - e.f31131c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            FunAdConfig funAdConfig = f62724b;
            return funAdConfig != null && funAdConfig.logEnabled;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSdkInitializeComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? h.f31163g : invokeV.booleanValue;
    }
}
