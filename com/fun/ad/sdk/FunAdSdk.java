package com.fun.ad.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ao9;
import com.baidu.tieba.bn9;
import com.baidu.tieba.ct9;
import com.baidu.tieba.dt9;
import com.baidu.tieba.et9;
import com.baidu.tieba.ht9;
import com.baidu.tieba.ln9;
import com.baidu.tieba.ps9;
import com.baidu.tieba.yn9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes7.dex */
public final class FunAdSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PLATFORM_AM = "am";
    public static final String PLATFORM_AX = "ax";
    public static final String PLATFORM_BAIDU = "baidu";
    public static final String PLATFORM_BZ = "bz";
    public static final String PLATFORM_CJ = "cj";
    public static final String PLATFORM_CM = "cm";
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_HW = "hw";
    public static final String PLATFORM_JY = "jy";
    @Deprecated
    public static final String PLATFORM_KDS = "kds";
    public static final String PLATFORM_KS = "ks";
    public static final String PLATFORM_MAX = "max";
    public static final String PLATFORM_MB = "mb";
    public static final String PLATFORM_MH = "mh";
    public static final String PLATFORM_MM = "mm";
    public static final String PLATFORM_OPPO = "oppo";
    public static final String PLATFORM_OW = "ow";
    public static final String PLATFORM_PG = "pg";
    public static final String PLATFORM_SIG = "sig";
    public static final String PLATFORM_TA = "ta";
    public static final String PLATFORM_VIVO = "vivo";
    public static ct9 a;
    public static FunAdConfig b;
    public static RewardEnv c;
    public static Set<String> d;
    public static Set<Pair<String, String>> e;
    public static volatile boolean f;
    public static volatile boolean g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface SdkInitializeCallback {
        void onComplete();

        void onModulesInitComplete();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2111271532, "Lcom/fun/ad/sdk/FunAdSdk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2111271532, "Lcom/fun/ad/sdk/FunAdSdk;");
                return;
            }
        }
        d = Collections.unmodifiableSet(new HashSet());
        e = Collections.unmodifiableSet(new HashSet());
        f = false;
        g = false;
    }

    public FunAdSdk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(boolean z, Set<Pair<String, String>> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65538, null, z, set) == null) {
            HashSet hashSet = new HashSet(e);
            if (z) {
                hashSet.addAll(set);
            } else {
                hashSet.removeAll(set);
            }
            e = Collections.unmodifiableSet(hashSet);
        }
    }

    public static void addForbiddenAid(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, pair) == null) || pair == null || e.contains(pair)) {
            return;
        }
        HashSet hashSet = new HashSet(1);
        hashSet.add(pair);
        a(true, hashSet);
    }

    public static void addForbiddenAid(Set<Pair<String, String>> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, set) == null) {
            a(true, set);
        }
    }

    public static ct9 getAdCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a : (ct9) invokeV.objValue;
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? b.appContext : (Context) invokeV.objValue;
    }

    public static Set<String> getForbiddenPlatforms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? d : (Set) invokeV.objValue;
    }

    public static FunAdConfig getFunAdConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? b : (FunAdConfig) invokeV.objValue;
    }

    public static RewardEnv getRewardEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? c : (RewardEnv) invokeV.objValue;
    }

    public static Set<Pair<String, String>> getsForbiddenAids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? e : (Set) invokeV.objValue;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, funAdConfig, funAdCallback)) == null) ? init(funAdConfig, funAdCallback, null) : invokeLL.booleanValue;
    }

    public static boolean isForBidShowInstalledApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? g : invokeV.booleanValue;
    }

    public static boolean isLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            FunAdConfig funAdConfig = b;
            return funAdConfig != null && funAdConfig.logEnabled;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSdkInitializeComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) ? ln9.h : invokeV.booleanValue;
    }

    public static void removeForbiddenAid(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, null, pair) == null) && e.contains(pair)) {
            HashSet hashSet = new HashSet(1);
            hashSet.add(pair);
            a(false, hashSet);
        }
    }

    public static void removeForbiddenAid(Set<Pair<String, String>> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, set) == null) {
            a(false, set);
        }
    }

    public static void setForBidShowInstalledApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65560, null, z) == null) {
            g = z;
        }
    }

    public static void setForbiddenPlatforms(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, set) == null) {
            if (set == null) {
                set = new HashSet<>();
            }
            d = Collections.unmodifiableSet(set);
        }
    }

    public static void setRewardEnv(RewardEnv rewardEnv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, rewardEnv) == null) {
            c = rewardEnv;
        }
    }

    public static double getARPU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            dt9.a.getClass();
            return yn9.m() + ao9.a();
        }
        return invokeV.doubleValue;
    }

    public static FunAdFactory getAdFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f) {
                return ln9.f;
            }
            throw new RuntimeException("FunAdSdk not initialized, please call init first.");
        }
        return (FunAdFactory) invokeV.objValue;
    }

    public static boolean getPersonalRecommendStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            FunAdConfig funAdConfig = b;
            if (funAdConfig == null) {
                LogPrinter.e("It's not suggest get this status before init!", new Object[0]);
                return yn9.b.getBoolean("key_psn_rec_s", true);
            }
            return funAdConfig.runtimeAdConfig.personalRecommendStatus;
        }
        return invokeV.booleanValue;
    }

    public static double getARPU(String str) {
        InterceptResult invokeL;
        double d2;
        bn9 bn9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            Double d3 = dt9.a.a.get(str);
            if (d3 != null) {
                d2 = d3.doubleValue();
            } else {
                d2 = -2.0d;
            }
            if (d2 == -2.0d) {
                Map<String, Double> map = ln9.a;
                Double d4 = null;
                if (!TextUtils.isEmpty(str)) {
                    Map<String, Double> map2 = ln9.a;
                    Double d5 = map2.get(str);
                    if (d5 == null) {
                        map2.clear();
                        ps9 ps9Var = ln9.e;
                        synchronized (ps9Var) {
                            bn9Var = ps9Var.a;
                        }
                        if (bn9Var == null) {
                            LogPrinter.d("No adConfig found now.", new Object[0]);
                        } else {
                            HashMap hashMap = new HashMap();
                            for (Ssp ssp : bn9Var.a) {
                                for (Ssp.Pid pid : ssp.pids) {
                                    hashMap.put(pid.pid, Double.valueOf(pid.basePrice));
                                    if (pid.pid.equals(str)) {
                                        d5 = Double.valueOf(pid.basePrice);
                                    }
                                }
                            }
                            ln9.a.putAll(hashMap);
                            LogPrinter.d("No target basePrice found for pid:%s", str);
                        }
                    }
                    d4 = d5;
                }
                if (d4 == null) {
                    return -1.0d;
                }
                return d4.doubleValue() / 1000.0d;
            }
            return d2;
        }
        return invokeL.doubleValue;
    }

    public static String getBaiduCustomUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            SharedPreferences sharedPreferences = yn9.b;
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

    public static String getPlatformId(String str) {
        InterceptResult invokeL;
        bn9 bn9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            Map<String, Double> map = ln9.a;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ps9 ps9Var = ln9.e;
            synchronized (ps9Var) {
                bn9Var = ps9Var.a;
            }
            if (bn9Var == null) {
                LogPrinter.d("No adConfig found now.", new Object[0]);
                return null;
            }
            for (Ssp ssp : bn9Var.a) {
                if (ssp.type.equals(str)) {
                    return ssp.sspId;
                }
            }
            LogPrinter.d("No target ssp found for platform:%s", str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback, SdkInitializeCallback sdkInitializeCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, funAdConfig, funAdCallback, sdkInitializeCallback)) == null) {
            if (funAdConfig != null) {
                if (funAdConfig.userId != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        if (f) {
                            if (b.logEnabled) {
                                LogPrinter.e("Please don't init FunAdSdk duplicated.", new Object[0]);
                            }
                            return false;
                        }
                        b = funAdConfig;
                        FunRuntimeAdConfig funRuntimeAdConfig = funAdConfig.runtimeAdConfig;
                        SharedPreferences sharedPreferences = yn9.b;
                        funRuntimeAdConfig.personalRecommendStatus = sharedPreferences.getBoolean("key_psn_rec_s", true);
                        b.moduleInitManager.setCallBack(sdkInitializeCallback);
                        Flavors.PLUGIN_RC.init(b.appContext);
                        if (sharedPreferences.getLong("key_flt", 0L) <= 0) {
                            sharedPreferences.edit().putLong("key_flt", System.currentTimeMillis()).apply();
                        }
                        if (funAdCallback != null) {
                            if (funAdCallback instanceof ct9) {
                                a = (ct9) funAdCallback;
                            } else {
                                a = new ct9(funAdCallback) { // from class: com.fun.ad.sdk.FunAdSdk.1
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

                                    @Override // com.baidu.tieba.ct9
                                    public void onAdClicked(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, pid) == null) {
                                            this.a.onAdClicked(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.ct9
                                    public void onAdClose(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pid) == null) {
                                            this.a.onAdClose(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.ct9
                                    public void onAdLoad(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, pid) == null) {
                                            this.a.onAdLoad(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.ct9
                                    public void onAdLoadError(Ssp.Pid pid, int i, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLIL(1048579, this, pid, i, str) == null) {
                                            this.a.onAdLoadError(pid.type, pid.pid, pid.ssp.sspId, i, str);
                                        }
                                    }

                                    @Override // com.baidu.tieba.ct9
                                    public void onAdLoaded(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048580, this, pid) == null) {
                                            this.a.onAdLoaded(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.ct9
                                    public void onAdShow(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048581, this, pid) == null) {
                                            this.a.onAdShow(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.ct9
                                    public void onAdShowError(Ssp.Pid pid, int i, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLIL(1048582, this, pid, i, str) == null) {
                                            this.a.onAdShowError(pid.type, pid.pid, pid.ssp.sspId, i, str);
                                        }
                                    }

                                    @Override // com.baidu.tieba.ct9
                                    public void onRewardedVideo(Ssp.Pid pid, boolean z, int i) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeCommon(1048583, this, new Object[]{pid, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                                            this.a.onRewardedVideo(pid.type, pid.pid, pid.ssp.sspId, z, i);
                                        }
                                    }
                                };
                            }
                        }
                        ht9.a aVar = ht9.a;
                        ht9.b = System.currentTimeMillis();
                        ht9.c = SystemClock.currentThreadTimeMillis();
                        f = true;
                        ln9.c = sdkInitializeCallback;
                        ln9.e(true);
                        et9 et9Var = ln9.f;
                        Flavors.CPM_AWARE.init();
                        ht9.a aVar2 = ht9.a;
                        aVar2.c = System.currentTimeMillis() - ht9.b;
                        aVar2.d = SystemClock.currentThreadTimeMillis() - ht9.c;
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

    public static void setPersonalRecommendStatus(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65562, null, z) == null) {
            FunAdConfig funAdConfig = b;
            if (funAdConfig != null) {
                funAdConfig.runtimeAdConfig.updatePersonalRecommendStatus(z);
                yn9.b.edit().putBoolean("key_psn_rec_s", z).apply();
                return;
            }
            throw new RuntimeException("Settings for this status must after the init method!");
        }
    }
}
