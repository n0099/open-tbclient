package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dm9;
import com.baidu.tieba.fl9;
import com.baidu.tieba.fm9;
import com.baidu.tieba.gr9;
import com.baidu.tieba.hr9;
import com.baidu.tieba.ir9;
import com.baidu.tieba.ml9;
import com.baidu.tieba.nl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.RewardEnv;
import com.fun.ad.sdk.internal.api.BasePidLoader;
import com.fun.ad.sdk.internal.api.PidLoaderSession;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.PluginRC;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.MD5Utils;
import com.fun.ad.sdk.internal.api.utils.SignatureMd5Utils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class BasePidLoader implements PidLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int IGNORE_ERR_CODE;
    public final List a;
    public final FunAdCallbackWrapper b;
    public final FunAdType c;
    public int d;
    public final boolean isSupportCaching;
    public final boolean isSupportNativeAd;
    public final boolean isSupportSplashAd;
    public final AdRipper mAdRipper;
    public final Deque mAdSession;
    public final Ssp.Pid mPid;

    /* renamed from: com.fun.ad.sdk.internal.api.BasePidLoader$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class FunAdCallbackWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BasePidLoader a;

        public FunAdCallbackWrapper(BasePidLoader basePidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basePidLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = basePidLoader;
        }

        public /* synthetic */ FunAdCallbackWrapper(BasePidLoader basePidLoader, AnonymousClass1 anonymousClass1) {
            this(basePidLoader);
        }

        public void onAdClicked() {
            hr9 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClicked(this.a.mPid);
        }

        public void onAdClose() {
            hr9 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClose(this.a.mPid);
        }

        public void onAdLoad() {
            hr9 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoad(this.a.mPid);
        }

        public void onAdLoadError(int i, String str) {
            hr9 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoadError(this.a.mPid, i, str);
        }

        public void onAdLoaded() {
            hr9 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoaded(this.a.mPid);
        }

        public void onAdShow() {
            hr9 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShow(this.a.mPid);
        }

        public void onAdShowError(int i, String str) {
            hr9 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShowError(this.a.mPid, i, str);
        }

        public void onRewardedVideo(boolean z, int i) {
            hr9 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onRewardedVideo(this.a.mPid, z, i);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePidLoader(FunAdType funAdType, Ssp.Pid pid) {
        this(funAdType, pid, true, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public BasePidLoader(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.IGNORE_ERR_CODE = -975312468;
        this.a = new ArrayList();
        this.b = new FunAdCallbackWrapper(this, null);
        this.mAdSession = new ArrayDeque();
        this.d = 0;
        if (pid == null) {
            throw new IllegalArgumentException();
        }
        this.c = funAdType;
        this.mPid = pid;
        this.isSupportCaching = z;
        this.isSupportNativeAd = z2;
        this.isSupportSplashAd = z3;
        this.mAdRipper = createAdRipper(pid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        destroyInternal(obj);
        this.mAdRipper.destroy(obj);
    }

    public final PidLoaderSession a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PidLoaderSession lastSession = getLastSession();
            if (lastSession == null || !lastSession.isWaitFill()) {
                return null;
            }
            return lastSession;
        }
        return (PidLoaderSession) invokeV.objValue;
    }

    public final boolean a(RCInterceptor rCInterceptor, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rCInterceptor, obj)) == null) {
            if (rCInterceptor != null) {
                if (rCInterceptor.shouldInterceptShow(rCInterceptor.needRipper() ? getRippedAdInternal(obj) : null)) {
                    onError(0, "abandon by client");
                    destroy(true);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void addListener(fl9 fl9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fl9Var) == null) || fl9Var == null) {
            return;
        }
        synchronized (this.a) {
            this.a.add(fl9Var);
        }
    }

    public final PidLoaderSession b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Iterator descendingIterator = this.mAdSession.descendingIterator();
            while (descendingIterator.hasNext()) {
                PidLoaderSession pidLoaderSession = (PidLoaderSession) descendingIterator.next();
                if (pidLoaderSession.hasAvailableAd()) {
                    return pidLoaderSession;
                }
            }
            return null;
        }
        return (PidLoaderSession) invokeV.objValue;
    }

    public final String buildExtra(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        JSONObject env;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                RewardEnv rewardEnv = FunAdSdk.getRewardEnv();
                if (rewardEnv != null && (env = rewardEnv.getEnv()) != null) {
                    jSONObject.put("aaa", env);
                }
                jSONObject.put("pid", this.mPid.pid);
                jSONObject.put("userId", FunAdSdk.getFunAdConfig().userId);
                jSONObject.put("app_sign", SignatureMd5Utils.getSignatureMd5(context));
                jSONObject.put("ts", str2);
                jSONObject.put("tid", str);
                jSONObject.put("pkg", context.getPackageName());
                jSONObject.put("appV", HostAppInfo.getAppVersionCode());
                jSONObject.put("sdkV", HostAppInfo.getSdkVersionCode());
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public final Object c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            PidLoaderSession b = b();
            if (b == null) {
                return null;
            }
            return b.pollAd();
        }
        return invokeV.objValue;
    }

    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pid)) == null) ? BaseAdRipper.FAKE_AD_RIPPER : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                destroy(false);
            }
        }
    }

    public abstract void destroyInternal(Object obj);

    public double getAdBiddingPrices(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            return 0.0d;
        }
        return invokeL.doubleValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            PidLoaderSession lastSession = getLastSession();
            if (lastSession == null) {
                return 0;
            }
            return lastSession.getFreeAdCount();
        }
        return invokeV.intValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunAdType getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c : (FunAdType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public double getBiddingOrBasePrices() {
        InterceptResult invokeV;
        Object peekAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Ssp.Pid pid = this.mPid;
            if (pid.isBidding) {
                PidLoaderSession b = b();
                if (b == null || (peekAd = b.peekAd()) == null) {
                    return -1.0d;
                }
                return getAdBiddingPrices(peekAd);
            }
            return pid.basePrice;
        }
        return invokeV.doubleValue;
    }

    public PidLoaderSession getLastSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (PidLoaderSession) this.mAdSession.peekLast() : (PidLoaderSession) invokeV.objValue;
    }

    public long getLid(PidLoaderSession pidLoaderSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, pidLoaderSession)) == null) {
            if (pidLoaderSession != null) {
                return pidLoaderSession.getLid();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public SidSessionMeta getLoadMeta(PidLoaderSession pidLoaderSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pidLoaderSession)) == null) {
            SidSessionMeta loadSidSessionMeta = pidLoaderSession != null ? pidLoaderSession.getLoadSidSessionMeta() : null;
            return loadSidSessionMeta == null ? new SidSessionMeta("", 0) : loadSidSessionMeta;
        }
        return (SidSessionMeta) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunNativeAd2 getNativeAd2(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, str)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.mAdSession.isEmpty()) {
                        return null;
                    }
                    Object c = c();
                    if (c == null) {
                        return null;
                    }
                    return getNativeAdInternal2(context, str, c);
                }
                return null;
            }
        }
        return (FunNativeAd2) invokeLL.objValue;
    }

    @Deprecated
    public FunNativeAd getNativeAdInternal(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, context, str, obj)) == null) {
            return null;
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    public FunNativeAd2 getNativeAdInternal2(Context context, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, context, str, obj)) == null) {
            return null;
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public Ssp.Pid getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mPid : (Ssp.Pid) invokeV.objValue;
    }

    public final RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) ? this.mAdRipper.getRippedAd(obj) : (RippedAd) invokeL.objValue;
    }

    public PidLoaderSession getSession(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, obj)) == null) {
            Iterator descendingIterator = this.mAdSession.descendingIterator();
            while (descendingIterator.hasNext()) {
                PidLoaderSession pidLoaderSession = (PidLoaderSession) descendingIterator.next();
                if (pidLoaderSession.isIncludeAd(obj)) {
                    return pidLoaderSession;
                }
            }
            return null;
        }
        return (PidLoaderSession) invokeL.objValue;
    }

    public SidSessionMeta getShowMeta(Object obj, PidLoaderSession pidLoaderSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, obj, pidLoaderSession)) == null) {
            SidSessionMeta showSidSessionMeta = pidLoaderSession != null ? pidLoaderSession.getShowSidSessionMeta(obj) : null;
            return showSidSessionMeta == null ? new SidSessionMeta("", 0) : showSidSessionMeta;
        }
        return (SidSessionMeta) invokeLL.objValue;
    }

    public final String getTid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            int nextInt = new Random().nextInt();
            return MD5Utils.getMD5String(ml9.c() + str + this.mPid.pid + nextInt);
        }
        return (String) invokeL.objValue;
    }

    public boolean isAdAvailable(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, obj)) == null) ? obj != null : invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean load(Context context, FunAdSlot funAdSlot, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, context, funAdSlot, sidSessionMeta)) == null) {
            synchronized (this) {
                if (a() != null) {
                    z = false;
                } else {
                    Iterator it = this.mAdSession.iterator();
                    while (it.hasNext()) {
                        if (((PidLoaderSession) it.next()).shouldBeRemoved()) {
                            it.remove();
                        }
                    }
                    this.mAdSession.add(new PidLoaderSession(sidSessionMeta, new PidLoaderSession.AdDestroyListener() { // from class: com.baidu.tieba.hl9
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.fun.ad.sdk.internal.api.PidLoaderSession.AdDestroyListener
                        public final void onDestroy(Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                                BasePidLoader.this.a(obj);
                            }
                        }
                    }));
                    this.d = 4;
                    loadInternal(context, funAdSlot);
                    z = true;
                }
            }
            return z;
        }
        return invokeLLL.booleanValue;
    }

    public abstract void loadInternal(Context context, FunAdSlot funAdSlot);

    public void onAdClicked(Object obj, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, obj, strArr) == null) {
            this.b.onAdClicked();
            synchronized (this.a) {
                for (fl9 fl9Var : this.a) {
                    fl9Var.b(Flavors.CALL_BACK_AWARE.needRipper() ? this.mAdRipper.getRippedAd(obj) : null, strArr);
                }
            }
        }
    }

    public void onAdClose(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, obj) == null) {
            this.b.onAdClose();
            synchronized (this.a) {
                for (fl9 fl9Var : this.a) {
                    fl9Var.a();
                }
            }
        }
    }

    public void onAdError(Object obj, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048607, this, obj, i, str) == null) {
            this.b.onAdShowError(i, str);
            synchronized (this.a) {
                for (fl9 fl9Var : this.a) {
                    fl9Var.b(i, str);
                }
            }
        }
    }

    public final void onAdLoaded(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, obj) == null) || a(Flavors.PLUGIN_RC.shouldIntercept(this.mPid.pid, getAdType()), obj)) {
            return;
        }
        PidLoaderSession a = a();
        boolean z = false;
        if (a == null) {
            LogPrinter.e("WaitFillSession not found when onAdLoaded(A)", new Object[0]);
        } else {
            z = a.cacheOrDestroy(obj, this.isSupportCaching);
        }
        if (z) {
            onLoaded(obj, a);
        } else {
            onError("m_el");
        }
    }

    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048611, this, i, str) == null) {
            PidLoaderSession a = a();
            if (a == null) {
                LogPrinter.e("WaitFillSession not found when onError", new Object[0]);
            } else {
                a.markTerminated();
            }
            this.b.onAdLoadError(i, str);
            synchronized (this.a) {
                for (fl9 fl9Var : this.a) {
                    fl9Var.a(i, str);
                }
            }
        }
    }

    public void onError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            onError(-975312468, str);
        }
    }

    public void onLoadStart(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, funAdSlot) == null) {
            this.b.onAdLoad();
            synchronized (this.a) {
                for (fl9 fl9Var : this.a) {
                    fl9Var.c();
                }
            }
        }
    }

    public void onLoaded(Object obj, PidLoaderSession pidLoaderSession) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, obj, pidLoaderSession) == null) {
            this.b.onAdLoaded();
            synchronized (this.a) {
                for (fl9 fl9Var : this.a) {
                    fl9Var.b();
                }
            }
        }
    }

    public void onRewardedVideo(Object obj, boolean z, int i, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{obj, Boolean.valueOf(z), Integer.valueOf(i), strArr}) == null) {
            this.b.onRewardedVideo(z, i);
            synchronized (this.a) {
                for (fl9 fl9Var : this.a) {
                    fl9Var.a(z, i, strArr);
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void removeListener(fl9 fl9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, fl9Var) == null) || fl9Var == null) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(fl9Var);
        }
    }

    public void setAdBiddingResult(Object obj, double d, double d2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{obj, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void setBiddingResult(double d, double d2, int i) {
        PidLoaderSession b;
        Object peekAd;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i)}) == null) && this.mPid.isBidding) {
            int i2 = this.d;
            if (i2 == 0 || i2 == 1) {
                this.d = 0;
            } else if (((i2 == 2 || i2 == 3) && i != 1) || (b = b()) == null || (peekAd = b.peekAd()) == null) {
            } else {
                this.d = i;
                setAdBiddingResult(peekAd, d, d2, i == 1, i);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean show(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048619, this, activity, viewGroup, str, sidSessionMeta)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.mAdSession.isEmpty()) {
                        return false;
                    }
                    Object c = c();
                    if (c == null) {
                        return false;
                    }
                    getSession(c).setShowSidSessionMeta(c, sidSessionMeta);
                    return showInternal(activity, viewGroup, str, c);
                }
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048620, this, activity, viewGroup, str, obj)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048621, this, activity, viewGroup, str, sidSessionMeta)) == null) {
            synchronized (this) {
                if (this.isSupportSplashAd) {
                    if (isLoaded()) {
                        if (this.mAdSession.isEmpty()) {
                            return null;
                        }
                        Object c = c();
                        if (c == null) {
                            return null;
                        }
                        getSession(c).setShowSidSessionMeta(c, sidSessionMeta);
                        return showSplashInternal(activity, viewGroup, str, c);
                    }
                    return null;
                }
                return null;
            }
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, Object obj) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048622, this, activity, viewGroup, str, obj)) == null) {
            if (showInternal(activity, viewGroup, str, obj)) {
                return new gr9();
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class SelectImpl implements PidLoaderSession.ISelect {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ BasePidLoader b;

        public SelectImpl(BasePidLoader basePidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {basePidLoader};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = basePidLoader;
        }

        @Override // com.fun.ad.sdk.internal.api.PidLoaderSession.ISelect
        public boolean selected(Object obj) {
            InterceptResult invokeL;
            RippedAd rippedAd;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (!this.a && this.b.isAdAvailable(obj)) {
                    PluginRC pluginRC = Flavors.PLUGIN_RC;
                    BasePidLoader basePidLoader = this.b;
                    RCInterceptor shouldIntercept = pluginRC.shouldIntercept(basePidLoader.mPid.pid, basePidLoader.getAdType());
                    if (shouldIntercept == null) {
                        return true;
                    }
                    if (shouldIntercept.needRipper()) {
                        rippedAd = this.b.getRippedAdInternal(obj);
                    } else {
                        rippedAd = null;
                    }
                    if (!shouldIntercept.shouldInterceptShow(rippedAd)) {
                        return true;
                    }
                    this.a = true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void destroy(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (this.isSupportCaching && !z) {
                z2 = false;
            } else {
                z2 = true;
            }
            Iterator it = this.mAdSession.iterator();
            while (it.hasNext()) {
                PidLoaderSession pidLoaderSession = (PidLoaderSession) it.next();
                if (pidLoaderSession != null) {
                    pidLoaderSession.destroyAd(z2);
                    if (pidLoaderSession.shouldBeRemoved()) {
                    }
                }
                it.remove();
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            synchronized (this) {
                PidLoaderSession b = b();
                boolean z = false;
                if (b == null) {
                    return false;
                }
                SelectImpl selectImpl = new SelectImpl(this);
                boolean iteratorAvailableAd = b.iteratorAvailableAd(selectImpl);
                if (selectImpl.a) {
                    destroy(true);
                } else {
                    z = iteratorAvailableAd;
                }
                return z;
            }
        }
        return invokeV.booleanValue;
    }

    public final void onAdLoaded(List list) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.mPid.pid, getAdType());
            Iterator it = list.iterator();
            while (true) {
                z = false;
                if (it.hasNext()) {
                    if (a(shouldIntercept, it.next())) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                return;
            }
            Object obj = null;
            PidLoaderSession a = a();
            if (a == null) {
                LogPrinter.e("WaitFillSession not found when onAdLoaded(List<A>)", new Object[0]);
            } else {
                for (Object obj2 : list) {
                    if (a.cacheOrDestroy(obj2, this.isSupportCaching)) {
                        if (obj == null) {
                            obj = obj2;
                        }
                        z = true;
                    }
                }
            }
            if (z) {
                onLoaded(obj, a);
            } else {
                onError("m_el");
            }
        }
    }

    public void onAdShow(Object obj, String... strArr) {
        double d;
        RippedAd rippedAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, obj, strArr) == null) {
            Ssp.Pid pid = this.mPid;
            String str = pid.pid;
            double d2 = pid.basePrice;
            nl9 nl9Var = ir9.a;
            if (TextUtils.isEmpty(str)) {
                LogPrinter.e("update ad cpm show price error : pid null", new Object[0]);
            } else {
                nl9 nl9Var2 = ir9.a;
                synchronized (nl9Var2) {
                    Double d3 = (Double) nl9Var2.a.get(str);
                    if (d3 != null) {
                        d = d3.doubleValue();
                    } else {
                        d = -2.0d;
                    }
                    if (d == -2.0d) {
                        double d4 = d2 / 1000.0d;
                        int i = fm9.a.getInt(str, 0);
                        LogPrinter.d("show count for no cpm ad:" + i, new Object[0]);
                        SharedPreferences.Editor editor = fm9.b;
                        editor.putInt(str, i + 1);
                        if (d4 == 0.0d) {
                            editor.apply();
                        } else {
                            editor.putLong(str + "_", Double.doubleToRawLongBits(fm9.b(str) + d4));
                            double a = fm9.a();
                            LogPrinter.d("update PriceByBasePrice", new Object[0]);
                            editor.putLong("key_price_by_baseprice", Double.doubleToRawLongBits(a + d4));
                            editor.apply();
                        }
                    } else {
                        LogPrinter.d("update totalPrice", new Object[0]);
                        dm9.d(dm9.m() + d);
                    }
                }
            }
            this.b.onAdShow();
            synchronized (this.a) {
                for (fl9 fl9Var : this.a) {
                    if (Flavors.CALL_BACK_AWARE.needRipper()) {
                        rippedAd = this.mAdRipper.getRippedAd(obj);
                    } else {
                        rippedAd = null;
                    }
                    fl9Var.c(rippedAd, strArr);
                }
            }
        }
    }
}
