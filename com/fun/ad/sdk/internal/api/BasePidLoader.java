package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.g7c;
import com.baidu.tieba.k7c;
import com.baidu.tieba.l1c;
import com.baidu.tieba.l7c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.q7c;
import com.baidu.tieba.s7c;
import com.baidu.tieba.x1c;
import com.baidu.tieba.z1c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdRevenueCallback;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class BasePidLoader<A> implements PidLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int IGNORE_ERR_CODE;
    public final List<q7c> a;
    public final BasePidLoader<A>.FunAdCallbackWrapper b;
    public final FunAdType c;
    public int d;
    public final boolean isSupportCaching;
    public final boolean isSupportNativeAd;
    public final boolean isSupportSplashAd;
    public final AdRipper mAdRipper;
    public final Deque<PidLoaderSession<A>> mAdSession;
    public final Ssp.Pid mPid;

    /* renamed from: com.fun.ad.sdk.internal.api.BasePidLoader$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
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
            k7c adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClicked(this.a.mPid);
        }

        public void onAdClose() {
            k7c adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClose(this.a.mPid);
        }

        public void onAdLoad() {
            k7c adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoad(this.a.mPid);
        }

        public void onAdLoadError(int i, String str) {
            k7c adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoadError(this.a.mPid, i, str);
        }

        public void onAdLoaded() {
            k7c adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            BasePidLoader basePidLoader = this.a;
            adCallback.onAdLoaded(basePidLoader.mPid, basePidLoader.getBiddingOrBasePrices());
        }

        public void onAdShow(double d) {
            k7c adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Double.valueOf(d)}) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShow(this.a.mPid, d);
        }

        public void onAdShowError(int i, String str) {
            k7c adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShowError(this.a.mPid, i, str);
        }

        public void onRewardedVideo(boolean z, int i) {
            k7c adCallback;
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

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(Object obj) {
        destroyInternal(obj);
        this.mAdRipper.destroy(obj);
    }

    public final PidLoaderSession<A> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PidLoaderSession<A> lastSession = getLastSession();
            if (lastSession == null || !lastSession.isWaitFill()) {
                return null;
            }
            return lastSession;
        }
        return (PidLoaderSession) invokeV.objValue;
    }

    public final void a(A a, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a, map) == null) {
            Ssp.Pid pid = this.mPid;
            map.put("rvn", String.valueOf(!pid.isBidding ? FunAdSdk.getARPU(pid.pid) : getAdBiddingPrices(a) / 1000.0d));
            map.put(MapBundleKey.MapObjKey.OBJ_BID, String.valueOf(this.mPid.isBidding));
        }
    }

    public final boolean a(RCInterceptor rCInterceptor, A a) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rCInterceptor, a)) == null) {
            if (rCInterceptor != null) {
                if (rCInterceptor.shouldInterceptShow(rCInterceptor.needRipper() ? getRippedAdInternal(a) : null)) {
                    onError("rc");
                    destroy(true);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void addListener(q7c q7cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, q7cVar) == null) || q7cVar == null) {
            return;
        }
        synchronized (this.a) {
            this.a.add(q7cVar);
        }
    }

    public final PidLoaderSession<A> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Iterator<PidLoaderSession<A>> descendingIterator = this.mAdSession.descendingIterator();
            while (descendingIterator.hasNext()) {
                PidLoaderSession<A> next = descendingIterator.next();
                if (next.hasAvailableAd()) {
                    return next;
                }
            }
            return null;
        }
        return (PidLoaderSession) invokeV.objValue;
    }

    public final String buildExtra(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        JSONObject env;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, context, str, str2, str3)) == null) {
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
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("app_ext", str3);
                }
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public final A c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PidLoaderSession<A> b = b();
            if (b == null) {
                return null;
            }
            return b.pollAd();
        }
        return (A) invokeV.objValue;
    }

    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pid)) == null) ? BaseAdRipper.FAKE_AD_RIPPER : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                destroy(false);
            }
        }
    }

    public abstract void destroyInternal(A a);

    public o7c generateSubAidInfo(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, a)) == null) ? new o7c() : (o7c) invokeL.objValue;
    }

    public double getAdBiddingPrices(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, a)) == null) {
            return 0.0d;
        }
        return invokeL.doubleValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            PidLoaderSession<A> lastSession = getLastSession();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c : (FunAdType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public double getBiddingOrBasePrices() {
        InterceptResult invokeV;
        A peekAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Ssp.Pid pid = this.mPid;
            if (pid.isBidding) {
                PidLoaderSession<A> b = b();
                if (b == null || (peekAd = b.peekAd()) == null) {
                    return -1.0d;
                }
                return getAdBiddingPrices(peekAd);
            }
            return l7c.a(pid.pid) * 1000.0d;
        }
        return invokeV.doubleValue;
    }

    public PidLoaderSession<A> getLastSession() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mAdSession.peekLast() : (PidLoaderSession) invokeV.objValue;
    }

    public long getLid(PidLoaderSession<A> pidLoaderSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pidLoaderSession)) == null) {
            if (pidLoaderSession != null) {
                return pidLoaderSession.getLid();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public SidSessionMeta getLoadMeta(PidLoaderSession<A> pidLoaderSession) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, pidLoaderSession)) == null) {
            SidSessionMeta loadSidSessionMeta = pidLoaderSession != null ? pidLoaderSession.getLoadSidSessionMeta() : null;
            return loadSidSessionMeta == null ? new SidSessionMeta("", 0) : loadSidSessionMeta;
        }
        return (SidSessionMeta) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunNativeAd2 getNativeAd2(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, context, str)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.mAdSession.isEmpty()) {
                        return null;
                    }
                    A c = c();
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
    public FunNativeAd getNativeAdInternal(Context context, String str, A a) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, context, str, a)) == null) {
            return null;
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    public FunNativeAd2 getNativeAdInternal2(Context context, String str, A a) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, context, str, a)) == null) {
            return null;
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public Ssp.Pid getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mPid : (Ssp.Pid) invokeV.objValue;
    }

    public double getRevenue(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, a)) == null) ? this.mPid.basePrice / 1000.0d : invokeL.doubleValue;
    }

    public final RippedAd getRippedAdInternal(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, a)) == null) ? this.mAdRipper.getRippedAd(a) : (RippedAd) invokeL.objValue;
    }

    public PidLoaderSession<A> getSession(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, a)) == null) {
            Iterator<PidLoaderSession<A>> descendingIterator = this.mAdSession.descendingIterator();
            while (descendingIterator.hasNext()) {
                PidLoaderSession<A> next = descendingIterator.next();
                if (next.isIncludeAd(a)) {
                    return next;
                }
            }
            return null;
        }
        return (PidLoaderSession) invokeL.objValue;
    }

    public SidSessionMeta getShowMeta(A a, PidLoaderSession<A> pidLoaderSession) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, a, pidLoaderSession)) == null) {
            SidSessionMeta showSidSessionMeta = pidLoaderSession != null ? pidLoaderSession.getShowSidSessionMeta(a) : null;
            return showSidSessionMeta == null ? new SidSessionMeta("", 0) : showSidSessionMeta;
        }
        return (SidSessionMeta) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final o7c getSubAidInfo() {
        InterceptResult invokeV;
        A peekAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PidLoaderSession<A> b = b();
            if (b == null || (peekAd = b.peekAd()) == null) {
                return null;
            }
            return generateSubAidInfo(peekAd);
        }
        return (o7c) invokeV.objValue;
    }

    public final String getTid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
            int nextInt = new Random().nextInt();
            return MD5Utils.getMD5String(l1c.c() + str + this.mPid.pid + nextInt);
        }
        return (String) invokeL.objValue;
    }

    public boolean isAdAvailable(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, a)) == null) ? a != null : invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean load(Context context, FunAdSlot funAdSlot, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048608, this, context, funAdSlot, sidSessionMeta)) == null) {
            synchronized (this) {
                if (a() != null) {
                    z = false;
                } else {
                    Iterator<PidLoaderSession<A>> it = this.mAdSession.iterator();
                    while (it.hasNext()) {
                        if (it.next().shouldBeRemoved()) {
                            it.remove();
                        }
                    }
                    this.mAdSession.add(new PidLoaderSession<>(sidSessionMeta, new PidLoaderSession.AdDestroyListener() { // from class: com.baidu.tieba.i1c
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

    public void onAdClicked(A a, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, a, map) == null) {
            this.b.onAdClicked();
            synchronized (this.a) {
                for (q7c q7cVar : this.a) {
                    q7cVar.a(Flavors.CALL_BACK_AWARE.needRipper() ? this.mAdRipper.getRippedAd(a) : null, map);
                }
            }
        }
    }

    public void onAdClose(A a, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, a, map) == null) {
            this.b.onAdClose();
            synchronized (this.a) {
                if (map == null) {
                    map = new HashMap<>();
                }
                a((BasePidLoader<A>) a, map);
                for (q7c q7cVar : this.a) {
                    q7cVar.a(map);
                }
            }
        }
    }

    public void onAdError(A a, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048612, this, a, i, str) == null) {
            this.b.onAdShowError(i, str);
            synchronized (this.a) {
                for (q7c q7cVar : this.a) {
                    q7cVar.b(i, str);
                }
            }
        }
    }

    public final void onAdLoaded(A a, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048613, this, a, strArr) == null) || a(Flavors.PLUGIN_RC.shouldIntercept(this.mPid.pid, getAdType()), (RCInterceptor) a)) {
            return;
        }
        PidLoaderSession<A> a2 = a();
        boolean z = false;
        if (a2 == null) {
            LogPrinter.e("WaitFillSession not found when onAdLoaded(A)", new Object[0]);
        } else {
            z = a2.cacheOrDestroy(a, this.isSupportCaching);
        }
        if (z) {
            onLoaded(a, a2, strArr);
        } else {
            onError("m_el");
        }
    }

    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048616, this, i, str) == null) {
            PidLoaderSession<A> a = a();
            if (a == null) {
                LogPrinter.e("WaitFillSession not found when onError", new Object[0]);
            } else {
                a.markTerminated();
            }
            this.b.onAdLoadError(i, str);
            synchronized (this.a) {
                for (q7c q7cVar : this.a) {
                    q7cVar.a(i, str);
                }
            }
        }
    }

    public void onError(A a, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048617, this, a, i, str) == null) {
            PidLoaderSession<A> a2 = a();
            if (a2 == null) {
                LogPrinter.e("WaitFillSession not found when onError", new Object[0]);
            } else {
                a2.markTerminated();
            }
            this.b.onAdLoadError(i, str);
            synchronized (this.a) {
                for (q7c q7cVar : this.a) {
                    q7cVar.a(i, str);
                }
            }
        }
    }

    public void onError(A a, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, a, str) == null) {
            onError(a, -975312468, str);
        }
    }

    public void onError(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            onError(-975312468, str);
        }
    }

    public void onLoadStart(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, funAdSlot) == null) {
            this.b.onAdLoad();
            synchronized (this.a) {
                for (q7c q7cVar : this.a) {
                    q7cVar.b();
                }
            }
        }
    }

    public void onLoaded(A a, PidLoaderSession<A> pidLoaderSession, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048621, this, a, pidLoaderSession, strArr) == null) {
            this.b.onAdLoaded();
            synchronized (this.a) {
                for (q7c q7cVar : this.a) {
                    q7cVar.a();
                }
            }
        }
    }

    public void onRewardedVideo(A a, boolean z, int i, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{a, Boolean.valueOf(z), Integer.valueOf(i), map}) == null) {
            this.b.onRewardedVideo(z, i);
            synchronized (this.a) {
                if (map == null) {
                    map = new HashMap<>();
                }
                a((BasePidLoader<A>) a, map);
                for (q7c q7cVar : this.a) {
                    q7cVar.a(z, i, map);
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void removeListener(q7c q7cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, q7cVar) == null) || q7cVar == null) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(q7cVar);
        }
    }

    public void setAdBiddingResult(A a, String str, double d, double d2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{a, str, Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void setBiddingResult(String str, double d, double d2, int i) {
        PidLoaderSession<A> b;
        A peekAd;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{str, Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i)}) == null) && this.mPid.isBidding) {
            int i2 = this.d;
            if (i2 == 0 || i2 == 1) {
                this.d = 0;
            } else if (((i2 == 2 || i2 == 3) && i != 1) || (b = b()) == null || (peekAd = b.peekAd()) == null) {
            } else {
                this.d = i;
                setAdBiddingResult(peekAd, str, d, d2, i == 1, i);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean show(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048626, this, activity, viewGroup, str, sidSessionMeta)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.mAdSession.isEmpty()) {
                        return false;
                    }
                    A c = c();
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

    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, A a) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048627, this, activity, viewGroup, str, a)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, SidSessionMeta sidSessionMeta) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048628, this, activity, viewGroup, str, sidSessionMeta)) == null) {
            synchronized (this) {
                if (this.isSupportSplashAd) {
                    if (isLoaded()) {
                        if (this.mAdSession.isEmpty()) {
                            return null;
                        }
                        A c = c();
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

    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, A a) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048629, this, activity, viewGroup, str, a)) == null) {
            if (showInternal(activity, viewGroup, str, a)) {
                return new g7c();
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes9.dex */
    public class SelectImpl implements PidLoaderSession.ISelect<A> {
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
        public boolean selected(A a) {
            InterceptResult invokeL;
            RippedAd rippedAd;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a)) == null) {
                if (!this.a && this.b.isAdAvailable(a)) {
                    PluginRC pluginRC = Flavors.PLUGIN_RC;
                    BasePidLoader basePidLoader = this.b;
                    RCInterceptor shouldIntercept = pluginRC.shouldIntercept(basePidLoader.mPid.pid, basePidLoader.getAdType());
                    if (shouldIntercept == null) {
                        return true;
                    }
                    if (shouldIntercept.needRipper()) {
                        rippedAd = this.b.getRippedAdInternal(a);
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

    public final String buildOsExtra(String str, String str2, Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, str, str2, map)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pid", this.mPid.pid);
                jSONObject.put("userId", FunAdSdk.getFunAdConfig().userId);
                jSONObject.put("app_sign", SignatureMd5Utils.getSignatureMd5(FunAdSdk.getAppContext()));
                jSONObject.put("pkg", FunAdSdk.getAppContext().getPackageName());
                jSONObject.put("tk", FunAdSdk.getFunAdConfig().userId);
                jSONObject.put("ts", str2);
                jSONObject.put("tid", str);
                jSONObject.put("uuid", FunAdSdk.getAppUuid());
                jSONObject.put("appV", HostAppInfo.getAppVersionCode());
                jSONObject.put("sdkV", HostAppInfo.getSdkVersionCode());
                if (map != null) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                LogPrinter.e("Error, build os extra fail : %s.", e.getMessage());
            }
            String jSONObject2 = jSONObject.toString();
            byte[] bytes = "9723n8zlaw01whdh87kn98Zqlnculsjhd8oqwken".getBytes();
            int length = bytes.length;
            int min = Math.min((int) Math.cbrt(length), 35);
            StringBuilder sb = new StringBuilder(jSONObject2);
            StringBuilder sb2 = new StringBuilder();
            int i = 1;
            for (int i2 = 0; i2 < 3; i2++) {
                int nextInt = new Random().nextInt(min) + 1;
                i *= nextInt;
                sb2.append(Integer.toString(nextInt, 36));
            }
            sb.insert(5, (CharSequence) sb2);
            int length2 = sb.length();
            byte[] bytes2 = sb.toString().getBytes();
            byte[] bArr = new byte[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                if (i3 > 4 && i3 < 8) {
                    bArr[i3] = bytes2[i3];
                } else {
                    bArr[i3] = (byte) (bytes[(i3 + i) % length] ^ bytes2[i3]);
                }
            }
            String encodeToString = Base64.encodeToString(bArr, 2);
            try {
                return URLEncoder.encode(encodeToString, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                LogPrinter.e(e2);
                return encodeToString;
            }
        }
        return (String) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void destroy(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.isSupportCaching && !z) {
                z2 = false;
            } else {
                z2 = true;
            }
            Iterator<PidLoaderSession<A>> it = this.mAdSession.iterator();
            while (it.hasNext()) {
                PidLoaderSession<A> next = it.next();
                if (next != null) {
                    next.destroyAd(z2);
                    if (next.shouldBeRemoved()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            synchronized (this) {
                PidLoaderSession<A> b = b();
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

    public final void onAdLoaded(List<A> list) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, list) == null) {
            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.mPid.pid, getAdType());
            Iterator<A> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (a(shouldIntercept, (RCInterceptor) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                return;
            }
            A a = null;
            PidLoaderSession<A> a2 = a();
            if (a2 == null) {
                LogPrinter.e("WaitFillSession not found when onAdLoaded(List<A>)", new Object[0]);
                z2 = false;
            } else {
                z2 = false;
                for (A a3 : list) {
                    if (a2.cacheOrDestroy(a3, this.isSupportCaching)) {
                        if (a == null) {
                            a = a3;
                        }
                        z2 = true;
                    }
                }
            }
            if (z2) {
                onLoaded(a, a2, new String[0]);
            } else {
                onError("m_el");
            }
        }
    }

    public void onAdShow(A a, Map<String, String> map) {
        double d;
        double biddingOrBasePrices;
        RippedAd rippedAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, a, map) == null) {
            Ssp.Pid pid = this.mPid;
            String str = pid.pid;
            double d2 = pid.basePrice;
            s7c s7cVar = l7c.a;
            if (TextUtils.isEmpty(str)) {
                LogPrinter.e("update ad cpm show price error : pid null", new Object[0]);
            } else {
                s7c s7cVar2 = l7c.a;
                synchronized (s7cVar2) {
                    Double d3 = s7cVar2.a.get(str);
                    if (d3 != null) {
                        d = d3.doubleValue();
                    } else {
                        d = -2.0d;
                    }
                    if (d == -2.0d) {
                        double d4 = d2 / 1000.0d;
                        int i = z1c.a.getInt(str, 0);
                        LogPrinter.d("show count for no cpm ad:" + i, new Object[0]);
                        SharedPreferences.Editor editor = z1c.b;
                        editor.putInt(str, i + 1);
                        if (d4 == 0.0d) {
                            editor.apply();
                        } else {
                            editor.putLong(str + "_", Double.doubleToRawLongBits(z1c.b(str) + d4));
                            double a2 = z1c.a();
                            LogPrinter.d("update PriceByBasePrice", new Object[0]);
                            editor.putLong("key_price_by_baseprice", Double.doubleToRawLongBits(a2 + d4));
                            editor.apply();
                        }
                    } else {
                        LogPrinter.d("update totalPrice", new Object[0]);
                        x1c.d(x1c.n() + d);
                    }
                }
            }
            if (this.mPid.isBidding) {
                biddingOrBasePrices = getAdBiddingPrices(a);
            } else {
                biddingOrBasePrices = getBiddingOrBasePrices();
            }
            this.b.onAdShow(biddingOrBasePrices);
            FunAdRevenueCallback revenueCallback = FunAdSdk.getRevenueCallback();
            if (revenueCallback != null) {
                revenueCallback.onRevenueCallback(this.mPid.pid, getRevenue(a));
            }
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(MapBundleKey.MapObjKey.OBJ_BID, String.valueOf(this.mPid.isBidding));
            map.put("rvn", String.valueOf(biddingOrBasePrices));
            map.put("type", this.mPid.type);
            synchronized (this.a) {
                for (q7c q7cVar : this.a) {
                    if (Flavors.CALL_BACK_AWARE.needRipper()) {
                        rippedAd = this.mAdRipper.getRippedAd(a);
                    } else {
                        rippedAd = null;
                    }
                    q7cVar.b(rippedAd, map);
                }
            }
        }
    }
}
