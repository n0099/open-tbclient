package com.fun.ad.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.cl9;
import com.repackage.df9;
import com.repackage.kf9;
import com.repackage.pf9;
import com.repackage.qk9;
import com.repackage.rf9;
import com.repackage.xk9;
import com.repackage.yk9;
import com.repackage.zk9;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes4.dex */
public final class FunAdSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLATFORM_BAIDU = "baidu";
    public static final String PLATFORM_CJ = "cj";
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_JY = "jy";
    @Deprecated
    public static final String PLATFORM_KDS = "kds";
    public static final String PLATFORM_KS = "ks";
    public static final String PLATFORM_MB = "mb";
    public static final String PLATFORM_SIG = "sig";
    public static xk9 a;
    public static FunAdConfig b;
    public static volatile boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface SdkInitializeCallback {
        void onComplete();
    }

    public FunAdSdk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static double getARPU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            yk9.a.getClass();
            return pf9.i() + rf9.a();
        }
        return invokeV.doubleValue;
    }

    public static xk9 getAdCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a : (xk9) invokeV.objValue;
    }

    public static FunAdFactory getAdFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c) {
                return kf9.f;
            }
            throw new RuntimeException("FunAdSdk not initialized, please call init first.");
        }
        return (FunAdFactory) invokeV.objValue;
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? b.appContext : (Context) invokeV.objValue;
    }

    public static String getBaiduCustomUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            SharedPreferences sharedPreferences = pf9.b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? b : (FunAdConfig) invokeV.objValue;
    }

    public static String getPlatformId(String str) {
        InterceptResult invokeL;
        df9 df9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            Map<String, Double> map = kf9.a;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            qk9 qk9Var = kf9.e;
            synchronized (qk9Var) {
                df9Var = qk9Var.a;
            }
            if (df9Var == null) {
                LogPrinter.d("No adConfig found now.", new Object[0]);
                return null;
            }
            for (Ssp ssp : df9Var.a) {
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, funAdConfig, funAdCallback)) == null) ? init(funAdConfig, funAdCallback, null) : invokeLL.booleanValue;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback, SdkInitializeCallback sdkInitializeCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, funAdConfig, funAdCallback, sdkInitializeCallback)) == null) {
            if (funAdConfig != null) {
                if (funAdConfig.userId != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        if (c) {
                            if (b.logEnabled) {
                                LogPrinter.e("Please don't init FunAdSdk duplicated.", new Object[0]);
                            }
                            return false;
                        }
                        b = funAdConfig;
                        Flavors.PLUGIN_RC.init(b.appContext);
                        SharedPreferences sharedPreferences = pf9.b;
                        if (sharedPreferences.getLong("key_flt", 0L) <= 0) {
                            sharedPreferences.edit().putLong("key_flt", System.currentTimeMillis()).apply();
                        }
                        if (funAdCallback != null) {
                            if (funAdCallback instanceof xk9) {
                                a = (xk9) funAdCallback;
                            } else {
                                a = new xk9(funAdCallback) { // from class: com.fun.ad.sdk.FunAdSdk.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ FunAdCallback a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {funAdCallback};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.a = funAdCallback;
                                    }

                                    @Override // com.repackage.xk9
                                    public void onAdClicked(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, pid) == null) {
                                            this.a.onAdClicked(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.repackage.xk9
                                    public void onAdClose(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pid) == null) {
                                            this.a.onAdClose(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.repackage.xk9
                                    public void onAdLoad(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, pid) == null) {
                                            this.a.onAdLoad(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.repackage.xk9
                                    public void onAdLoadError(Ssp.Pid pid, int i, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLIL(1048579, this, pid, i, str) == null) {
                                            this.a.onAdLoadError(pid.type, pid.pid, pid.ssp.sspId, i, str);
                                        }
                                    }

                                    @Override // com.repackage.xk9
                                    public void onAdLoaded(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048580, this, pid) == null) {
                                            this.a.onAdLoaded(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.repackage.xk9
                                    public void onAdShow(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048581, this, pid) == null) {
                                            this.a.onAdShow(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.repackage.xk9
                                    public void onAdShowError(Ssp.Pid pid, int i, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLIL(1048582, this, pid, i, str) == null) {
                                            this.a.onAdShowError(pid.type, pid.pid, pid.ssp.sspId, i, str);
                                        }
                                    }

                                    @Override // com.repackage.xk9
                                    public void onRewardedVideo(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048583, this, pid) == null) {
                                            this.a.onRewardedVideo(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }
                                };
                            }
                        }
                        cl9.a aVar = cl9.a;
                        cl9.b = System.currentTimeMillis();
                        cl9.c = SystemClock.currentThreadTimeMillis();
                        c = true;
                        kf9.c = sdkInitializeCallback;
                        kf9.e(true);
                        zk9 zk9Var = kf9.f;
                        Flavors.CPM_AWARE.init();
                        cl9.a aVar2 = cl9.a;
                        aVar2.c = System.currentTimeMillis() - cl9.b;
                        aVar2.d = SystemClock.currentThreadTimeMillis() - cl9.c;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            FunAdConfig funAdConfig = b;
            return funAdConfig != null && funAdConfig.logEnabled;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSdkInitializeComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? kf9.h : invokeV.booleanValue;
    }

    public static double getARPU(String str) {
        InterceptResult invokeL;
        df9 df9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Double d = yk9.a.a.get(str);
            double doubleValue = d != null ? d.doubleValue() : -2.0d;
            if (doubleValue == -2.0d) {
                Map<String, Double> map = kf9.a;
                Double d2 = null;
                if (!TextUtils.isEmpty(str)) {
                    Map<String, Double> map2 = kf9.a;
                    Double d3 = map2.get(str);
                    if (d3 == null) {
                        map2.clear();
                        qk9 qk9Var = kf9.e;
                        synchronized (qk9Var) {
                            df9Var = qk9Var.a;
                        }
                        if (df9Var == null) {
                            LogPrinter.d("No adConfig found now.", new Object[0]);
                        } else {
                            HashMap hashMap = new HashMap();
                            for (Ssp ssp : df9Var.a) {
                                for (Ssp.Pid pid : ssp.pids) {
                                    hashMap.put(pid.pid, Double.valueOf(pid.basePrice));
                                    if (pid.pid.equals(str)) {
                                        d3 = Double.valueOf(pid.basePrice);
                                    }
                                }
                            }
                            kf9.a.putAll(hashMap);
                            LogPrinter.d("No target basePrice found for pid:%s", str);
                        }
                    }
                    d2 = d3;
                }
                if (d2 == null) {
                    return -1.0d;
                }
                return d2.doubleValue() / 1000.0d;
            }
            return doubleValue;
        }
        return invokeL.doubleValue;
    }
}
