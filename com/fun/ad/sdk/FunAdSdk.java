package com.fun.ad.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bfb;
import com.baidu.tieba.elb;
import com.baidu.tieba.flb;
import com.baidu.tieba.glb;
import com.baidu.tieba.jfb;
import com.baidu.tieba.jlb;
import com.baidu.tieba.lfb;
import com.baidu.tieba.mfb;
import com.baidu.tieba.teb;
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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes9.dex */
public final class FunAdSdk {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CLICK_BY_CLIENT = 1;
    public static final int CLICK_BY_NONE = -1;
    public static final int CLICK_BY_USER = 0;
    public static final String PLATFORM_ADX = "adx";
    public static final String PLATFORM_AM = "am";
    public static final String PLATFORM_AX = "ax";
    public static final String PLATFORM_BAIDU = "baidu";
    public static final String PLATFORM_BIGO = "bigo";
    public static final String PLATFORM_BZ = "bz";
    public static final String PLATFORM_CJ = "cj";
    public static final String PLATFORM_CM = "cm";
    public static final String PLATFORM_CSJ = "csj";
    public static final String PLATFORM_GDT = "gdt";
    public static final String PLATFORM_GROMORE = "gromore";
    public static final String PLATFORM_HW = "hw";
    public static final String PLATFORM_IS = "is";
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
    public static final String PLATFORM_TOBID = "tobid";
    public static final String PLATFORM_VIVO = "vivo";
    public static elb a;
    public static FunAdConfig b;
    public static RewardEnv c;
    public static volatile RCRippedAdFieldInfo d;
    public static Set<String> e;
    public static Set<Pair<String, String>> f;
    public static volatile int g;
    public static volatile boolean h;
    public static volatile boolean i;
    public static int j;
    public static volatile FunAdRevenueCallback k;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
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
        e = Collections.unmodifiableSet(new HashSet());
        f = Collections.unmodifiableSet(new HashSet());
        g = -1;
        h = false;
        i = false;
        j = 0;
    }

    public FunAdSdk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(boolean z, Set<Pair<String, String>> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65538, null, z, set) == null) {
            HashSet hashSet = new HashSet(f);
            if (z) {
                hashSet.addAll(set);
            } else {
                hashSet.removeAll(set);
            }
            f = Collections.unmodifiableSet(hashSet);
        }
    }

    public static void addForbiddenAid(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, pair) == null) || pair == null || f.contains(pair)) {
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

    public static double getARPU(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? flb.a(str) : invokeL.doubleValue;
    }

    public static elb getAdCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? a : (elb) invokeV.objValue;
    }

    public static Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? b.appContext : (Context) invokeV.objValue;
    }

    public static int getAppUuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? j : invokeV.intValue;
    }

    public static int getClickTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? g : invokeV.intValue;
    }

    public static Set<String> getForbiddenPlatforms() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? e : (Set) invokeV.objValue;
    }

    public static FunAdConfig getFunAdConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? b : (FunAdConfig) invokeV.objValue;
    }

    public static RCRippedAdFieldInfo getRcRippedFieldInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) ? d : (RCRippedAdFieldInfo) invokeV.objValue;
    }

    public static FunAdRevenueCallback getRevenueCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? k : (FunAdRevenueCallback) invokeV.objValue;
    }

    public static RewardEnv getRewardEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? c : (RewardEnv) invokeV.objValue;
    }

    public static Set<Pair<String, String>> getsForbiddenAids() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) ? f : (Set) invokeV.objValue;
    }

    public static boolean init(FunAdConfig funAdConfig, FunAdCallback funAdCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, funAdConfig, funAdCallback)) == null) ? init(funAdConfig, funAdCallback, null) : invokeLL.booleanValue;
    }

    public static boolean isForBidShowInstalledApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) ? i : invokeV.booleanValue;
    }

    public static boolean isLogEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            FunAdConfig funAdConfig = b;
            return funAdConfig != null && funAdConfig.logEnabled;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSdkInitializeComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) ? bfb.i : invokeV.booleanValue;
    }

    public static void removeForbiddenAid(Pair<String, String> pair) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65562, null, pair) == null) && f.contains(pair)) {
            HashSet hashSet = new HashSet(1);
            hashSet.add(pair);
            a(false, hashSet);
        }
    }

    public static void removeForbiddenAid(Set<Pair<String, String>> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, set) == null) {
            a(false, set);
        }
    }

    public static void setAppUuid(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            j = i2;
        }
    }

    public static void setClickTarget(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65565, null, i2) == null) {
            g = i2;
        }
    }

    public static void setForBidShowInstalledApp(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65566, null, z) == null) {
            i = z;
        }
    }

    public static void setForbiddenPlatforms(Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, set) == null) {
            if (set == null) {
                set = new HashSet<>();
            }
            e = Collections.unmodifiableSet(set);
        }
    }

    public static void setRcRippedFieldInfo(RCRippedAdFieldInfo rCRippedAdFieldInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65569, null, rCRippedAdFieldInfo) == null) {
            d = rCRippedAdFieldInfo;
        }
    }

    public static void setRcUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, str) == null) {
            FunAdConfig funAdConfig = b;
            if (funAdConfig != null) {
                funAdConfig.runtimeAdConfig.setRcUserId(str);
            } else {
                LogPrinter.e("Settings for the userId must after the init method!", new Object[0]);
            }
        }
    }

    public static void setRevenueCallback(FunAdRevenueCallback funAdRevenueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, funAdRevenueCallback) == null) {
            if (funAdRevenueCallback == null) {
                LogPrinter.e("Set revenue callback failed, callback is null.", new Object[0]);
            } else {
                k = funAdRevenueCallback;
            }
        }
    }

    public static void setRewardEnv(RewardEnv rewardEnv) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, rewardEnv) == null) {
            c = rewardEnv;
        }
    }

    public static double getARPU() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            flb.a.getClass();
            return jfb.n() + lfb.a();
        }
        return invokeV.doubleValue;
    }

    public static FunAdFactory getAdFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (h) {
                return bfb.g;
            }
            throw new RuntimeException("FunAdSdk not initialized, please call init first.");
        }
        return (FunAdFactory) invokeV.objValue;
    }

    public static boolean getPersonalRecommendStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            FunAdConfig funAdConfig = b;
            if (funAdConfig == null) {
                LogPrinter.e("It's not suggest get this status before init!", new Object[0]);
                return jfb.b.getBoolean("key_psn_rec_s", true);
            }
            return funAdConfig.runtimeAdConfig.personalRecommendStatus;
        }
        return invokeV.booleanValue;
    }

    public static String getBaiduCustomUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            SharedPreferences sharedPreferences = jfb.b;
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
        teb tebVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            Map<String, Double> map = bfb.a;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            mfb mfbVar = bfb.f;
            synchronized (mfbVar) {
                tebVar = mfbVar.a;
            }
            if (tebVar == null) {
                LogPrinter.d("No adConfig found now.", new Object[0]);
                return null;
            }
            for (Ssp ssp : tebVar.a) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65558, null, funAdConfig, funAdCallback, sdkInitializeCallback)) == null) {
            if (funAdConfig != null) {
                if (funAdConfig.userId != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        if (h) {
                            if (b.logEnabled) {
                                LogPrinter.e("Please don't init FunAdSdk duplicated.", new Object[0]);
                            }
                            return false;
                        }
                        b = funAdConfig;
                        FunRuntimeAdConfig funRuntimeAdConfig = funAdConfig.runtimeAdConfig;
                        SharedPreferences sharedPreferences = jfb.b;
                        funRuntimeAdConfig.personalRecommendStatus = sharedPreferences.getBoolean("key_psn_rec_s", true);
                        b.moduleInitManager.setCallBack(sdkInitializeCallback);
                        Flavors.PLUGIN_RC.init(b.appContext);
                        if (sharedPreferences.getLong("key_flt", 0L) <= 0) {
                            sharedPreferences.edit().putLong("key_flt", System.currentTimeMillis()).apply();
                        }
                        if (funAdCallback != null) {
                            if (funAdCallback instanceof elb) {
                                a = (elb) funAdCallback;
                            } else {
                                a = new elb(funAdCallback) { // from class: com.fun.ad.sdk.FunAdSdk.1
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
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.a = funAdCallback;
                                    }

                                    @Override // com.baidu.tieba.elb
                                    public void onAdClicked(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, pid) == null) {
                                            this.a.onAdClicked(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.elb
                                    public void onAdClose(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pid) == null) {
                                            this.a.onAdClose(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.elb
                                    public void onAdLoad(Ssp.Pid pid) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, pid) == null) {
                                            this.a.onAdLoad(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.elb
                                    public void onAdLoadError(Ssp.Pid pid, int i2, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLIL(1048579, this, pid, i2, str) == null) {
                                            this.a.onAdLoadError(pid.type, pid.pid, pid.ssp.sspId, i2, str);
                                        }
                                    }

                                    @Override // com.baidu.tieba.elb
                                    public void onAdLoaded(Ssp.Pid pid, double d2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeCommon(1048580, this, new Object[]{pid, Double.valueOf(d2)}) == null) {
                                            this.a.onAdLoaded(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.elb
                                    public void onAdShow(Ssp.Pid pid, double d2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{pid, Double.valueOf(d2)}) == null) {
                                            this.a.onAdShow(pid.type, pid.pid, pid.ssp.sspId);
                                        }
                                    }

                                    @Override // com.baidu.tieba.elb
                                    public void onAdShowError(Ssp.Pid pid, int i2, String str) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeLIL(1048582, this, pid, i2, str) == null) {
                                            this.a.onAdShowError(pid.type, pid.pid, pid.ssp.sspId, i2, str);
                                        }
                                    }

                                    @Override // com.baidu.tieba.elb
                                    public void onRewardedVideo(Ssp.Pid pid, boolean z, int i2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeCommon(1048583, this, new Object[]{pid, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                                            this.a.onRewardedVideo(pid.type, pid.pid, pid.ssp.sspId, z, i2);
                                        }
                                    }
                                };
                            }
                        }
                        jlb.a aVar = jlb.a;
                        jlb.b = System.currentTimeMillis();
                        jlb.c = SystemClock.currentThreadTimeMillis();
                        h = true;
                        bfb.d = sdkInitializeCallback;
                        bfb.f(true);
                        glb glbVar = bfb.g;
                        Flavors.CPM_AWARE.init();
                        jlb.a aVar2 = jlb.a;
                        aVar2.c = System.currentTimeMillis() - jlb.b;
                        aVar2.d = SystemClock.currentThreadTimeMillis() - jlb.c;
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
        if (interceptable == null || interceptable.invokeZ(65568, null, z) == null) {
            FunAdConfig funAdConfig = b;
            if (funAdConfig != null) {
                funAdConfig.runtimeAdConfig.updatePersonalRecommendStatus(z);
                jfb.b.edit().putBoolean("key_psn_rec_s", z).apply();
                return;
            }
            throw new RuntimeException("Settings for this status must after the init method!");
        }
    }
}
