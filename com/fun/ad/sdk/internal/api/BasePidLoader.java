package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.d.g0;
import c.d.h0;
import c.d.i0;
import c.d.n0;
import c.d.o;
import c.d.p0;
import c.d.q;
import com.baidu.android.imsdk.internal.Constants;
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
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.MD5Utils;
import com.fun.ad.sdk.internal.api.utils.SignatureMd5Utils;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class BasePidLoader<A> implements PidLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<n0> a;

    /* renamed from: b  reason: collision with root package name */
    public final List<A> f38597b;

    /* renamed from: c  reason: collision with root package name */
    public final Deque<A> f38598c;

    /* renamed from: d  reason: collision with root package name */
    public final BasePidLoader<A>.FunAdCallbackWrapper f38599d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38600e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f38601f;

    /* renamed from: g  reason: collision with root package name */
    public RippedAd f38602g;

    /* renamed from: h  reason: collision with root package name */
    public final FunAdType f38603h;
    public boolean isAdLoading;
    public final boolean isSupportCaching;
    public final boolean isSupportNativeAd;
    public final boolean isSupportSplashAd;
    public final AdRipper mAdRipper;
    public final Ssp.Pid mPid;
    public final AdReporter mReporter;

    /* renamed from: com.fun.ad.sdk.internal.api.BasePidLoader$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
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
            h0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClicked(this.a.mPid);
        }

        public void onAdClose() {
            h0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClose(this.a.mPid);
        }

        public void onAdLoad() {
            h0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoad(this.a.mPid);
        }

        public void onAdLoadError(int i, String str) {
            h0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoadError(this.a.mPid, i, str);
        }

        public void onAdLoaded() {
            h0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoaded(this.a.mPid);
        }

        public void onAdShow() {
            h0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShow(this.a.mPid);
        }

        public void onAdShowError(int i, String str) {
            h0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShowError(this.a.mPid, i, str);
        }

        public void onRewardedVideo() {
            h0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onRewardedVideo(this.a.mPid);
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePidLoader(FunAdType funAdType, Ssp.Pid pid, boolean z) {
        this(funAdType, pid, z, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePidLoader(FunAdType funAdType, Ssp.Pid pid, boolean z, boolean z2) {
        this(funAdType, pid, z, z2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {funAdType, pid, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((FunAdType) objArr2[0], (Ssp.Pid) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), ((Boolean) objArr2[4]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
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
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f38597b = new ArrayList();
        this.f38598c = new ArrayDeque();
        this.f38599d = new FunAdCallbackWrapper(this, null);
        this.f38600e = true;
        this.f38601f = true;
        this.mReporter = new AdReporter();
        if (pid == null) {
            throw new IllegalArgumentException();
        }
        this.f38603h = funAdType;
        this.mPid = pid;
        this.isSupportCaching = z;
        this.isSupportNativeAd = z2;
        this.isSupportSplashAd = z3;
        this.mAdRipper = createAdRipper(pid);
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void addListener(n0 n0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, n0Var) == null) || n0Var == null) {
            return;
        }
        synchronized (this.a) {
            this.a.add(n0Var);
        }
    }

    public String buildExtra(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pid", this.mPid.pid);
                jSONObject.put("userId", FunAdSdk.getFunAdConfig().userId);
                jSONObject.put("app_sign", SignatureMd5Utils.getSignatureMd5(context));
                jSONObject.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, str2);
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

    public final void cacheOrDestroyAd(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a) == null) {
            if (this.isSupportCaching || !this.f38600e) {
                this.f38598c.add(a);
            } else {
                destroyInternal(a);
            }
        }
    }

    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, pid)) == null) ? BaseAdRipper.FAKE_AD_RIPPER : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                destroy(false);
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void destroy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f38600e = true;
            this.f38602g = null;
            Iterator<A> it = this.f38597b.iterator();
            while (it.hasNext()) {
                A next = it.next();
                destroyInternal(next);
                this.mAdRipper.destroy(next);
                it.remove();
            }
            if (!this.isSupportCaching || z) {
                Iterator<A> it2 = this.f38598c.iterator();
                while (it2.hasNext()) {
                    A next2 = it2.next();
                    destroyInternal(next2);
                    this.mAdRipper.destroy(next2);
                    it2.remove();
                }
            }
        }
    }

    public abstract void destroyInternal(A a);

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public int getAdCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38598c.size() : invokeV.intValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public FunAdType getAdType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f38603h : (FunAdType) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, str)) == null) {
            synchronized (this) {
                if (this.isSupportNativeAd) {
                    if (isLoaded()) {
                        if (this.f38598c.isEmpty()) {
                            return null;
                        }
                        this.f38602g = null;
                        A pollFirst = this.f38598c.pollFirst();
                        if (pollFirst == null) {
                            return null;
                        }
                        this.f38597b.add(pollFirst);
                        return getNativeAdInternal(context, str, pollFirst);
                    }
                    return null;
                }
                return null;
            }
        }
        return (FunNativeAd) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunNativeAd2 getNativeAd2(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, context, str)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.f38598c.isEmpty()) {
                        return null;
                    }
                    this.f38602g = null;
                    A peekFirst = this.f38598c.peekFirst();
                    if (peekFirst == null) {
                        this.f38598c.removeFirst();
                        return null;
                    }
                    FunNativeAd2 nativeAdInternal2 = getNativeAdInternal2(context, str, peekFirst);
                    if (nativeAdInternal2 == null) {
                        return null;
                    }
                    this.f38598c.removeFirst();
                    this.f38597b.add(peekFirst);
                    return nativeAdInternal2;
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, str, a)) == null) {
            return null;
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    public FunNativeAd2 getNativeAdInternal2(Context context, String str, A a) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, context, str, a)) == null) {
            return null;
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public Ssp.Pid getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mPid : (Ssp.Pid) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized RippedAd getRippedAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                if (this.f38601f) {
                    if (isLoaded()) {
                        if (this.f38598c.isEmpty()) {
                            return null;
                        }
                        RippedAd rippedAd = this.f38602g;
                        if (rippedAd != null) {
                            return rippedAd;
                        }
                        RippedAd rippedAdInternal = getRippedAdInternal(this.f38598c.peekFirst());
                        if (rippedAdInternal == null) {
                            this.f38601f = false;
                            return null;
                        }
                        this.f38602g = rippedAdInternal;
                        return rippedAdInternal;
                    }
                    return null;
                }
                return null;
            }
        }
        return (RippedAd) invokeV.objValue;
    }

    public final RippedAd getRippedAdInternal(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, a)) == null) ? this.mAdRipper.getRippedAd(a) : (RippedAd) invokeL.objValue;
    }

    public String getTid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            int nextInt = new Random().nextInt();
            return MD5Utils.getMD5String(str + this.mPid.pid + nextInt);
        }
        return (String) invokeL.objValue;
    }

    public boolean isAdAvailable(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, a)) == null) ? a != null : invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean isLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            synchronized (this) {
                Iterator<A> it = this.f38598c.iterator();
                while (it.hasNext()) {
                    A next = it.next();
                    if (isAdAvailable(next)) {
                        RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.mPid.pid, getAdType());
                        if (shouldIntercept == null || !shouldIntercept.shouldInterceptShow(getRippedAdInternal(next))) {
                            return true;
                        }
                        destroy(true);
                    } else {
                        it.remove();
                    }
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean load(Context context, FunAdSlot funAdSlot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, context, funAdSlot)) == null) {
            synchronized (this) {
                this.f38600e = false;
                if (this.isAdLoading) {
                    return false;
                }
                this.f38602g = null;
                this.isAdLoading = true;
                this.f38597b.addAll(this.f38598c);
                this.f38598c.clear();
                loadInternal(context, funAdSlot);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public abstract void loadInternal(Context context, FunAdSlot funAdSlot);

    public void onAdClicked(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, strArr) == null) {
            this.f38599d.onAdClicked();
            synchronized (this.a) {
                for (n0 n0Var : this.a) {
                    n0Var.b(Flavors.CALL_BACK_AWARE.needRipper() ? getRippedAd() : null, strArr);
                }
            }
        }
    }

    public void onAdClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.f38599d.onAdClose();
            synchronized (this.a) {
                for (n0 n0Var : this.a) {
                    n0Var.a();
                }
            }
        }
    }

    public void onAdError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048599, this, i, str) == null) {
            this.f38599d.onAdShowError(i, str);
            synchronized (this.a) {
                for (n0 n0Var : this.a) {
                    n0Var.b(i, str);
                }
            }
        }
    }

    public final void onAdLoaded(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, a) == null) {
            cacheOrDestroyAd(a);
            onLoaded();
        }
    }

    public final void onAdLoaded(List<A> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            for (A a : list) {
                cacheOrDestroyAd(a);
            }
            onLoaded();
        }
    }

    public void onAdShow(A a, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, a, strArr) == null) {
            Ssp.Pid pid = this.mPid;
            String str = pid.pid;
            double d2 = pid.basePrice;
            p0 p0Var = i0.a;
            if (TextUtils.isEmpty(str)) {
                LogPrinter.e("update ad cpm show price error : pid null", new Object[0]);
            } else {
                p0 p0Var2 = i0.a;
                synchronized (p0Var2) {
                    Double d3 = p0Var2.a.get(str);
                    double doubleValue = d3 != null ? d3.doubleValue() : -2.0d;
                    if (doubleValue == -2.0d) {
                        double d4 = d2 / 1000.0d;
                        int i = q.a.getInt(str, 0);
                        LogPrinter.d("show count for no cpm ad:" + i, new Object[0]);
                        SharedPreferences.Editor editor = q.f23226b;
                        editor.putInt(str, i + 1);
                        if (d4 == 0.0d) {
                            editor.apply();
                        } else {
                            editor.putLong(str + "_", Double.doubleToRawLongBits(q.b(str) + d4));
                            double a2 = q.a();
                            LogPrinter.d("update PriceByBasePrice", new Object[0]);
                            editor.putLong("key_price_by_baseprice", Double.doubleToRawLongBits(a2 + d4));
                            editor.apply();
                        }
                    } else {
                        LogPrinter.d("update totalPrice", new Object[0]);
                        o.c(o.i() + doubleValue);
                    }
                }
            }
            this.f38599d.onAdShow();
            synchronized (this.a) {
                for (n0 n0Var : this.a) {
                    n0Var.c(Flavors.CALL_BACK_AWARE.needRipper() ? getRippedAd() : null, strArr);
                }
            }
        }
    }

    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i, str) == null) {
            this.isAdLoading = false;
            this.f38599d.onAdLoadError(i, str);
            synchronized (this.a) {
                for (n0 n0Var : this.a) {
                    n0Var.a(i, str);
                }
            }
        }
    }

    public void onLoadStart(FunAdSlot funAdSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, funAdSlot) == null) {
            this.f38599d.onAdLoad();
            synchronized (this.a) {
                for (n0 n0Var : this.a) {
                    n0Var.c();
                }
            }
        }
    }

    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.isAdLoading = false;
            this.f38599d.onAdLoaded();
            synchronized (this.a) {
                for (n0 n0Var : this.a) {
                    n0Var.b();
                }
            }
        }
    }

    public void onRewardedVideo(boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048606, this, z, strArr) == null) {
            this.f38599d.onRewardedVideo();
            synchronized (this.a) {
                for (n0 n0Var : this.a) {
                    n0Var.a(z, strArr);
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void removeListener(n0 n0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, n0Var) == null) || n0Var == null) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(n0Var);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean show(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048608, this, activity, viewGroup, str, funNativeAdInflater)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.f38598c.isEmpty()) {
                        return false;
                    }
                    this.f38602g = null;
                    A pollFirst = this.f38598c.pollFirst();
                    if (pollFirst == null) {
                        return false;
                    }
                    this.f38597b.add(pollFirst);
                    return funNativeAdInflater == null ? showInternal(activity, viewGroup, str, (String) pollFirst) : showInternal(activity, str, funNativeAdInflater, (FunNativeAdInflater) pollFirst);
                }
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, A a) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048609, this, activity, viewGroup, str, a)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean showInternal(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, A a) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048610, this, activity, str, funNativeAdInflater, a)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, activity, viewGroup, str)) == null) {
            synchronized (this) {
                if (this.isSupportSplashAd) {
                    if (isLoaded()) {
                        if (this.f38598c.isEmpty()) {
                            return null;
                        }
                        this.f38602g = null;
                        A removeFirst = this.f38598c.removeFirst();
                        if (removeFirst == null) {
                            return null;
                        }
                        this.f38597b.add(removeFirst);
                        return showSplashInternal(activity, viewGroup, str, removeFirst);
                    }
                    return null;
                }
                return null;
            }
        }
        return (FunSplashAd) invokeLLL.objValue;
    }

    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, A a) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048612, this, activity, viewGroup, str, a)) == null) {
            if (showInternal(activity, viewGroup, str, (String) a)) {
                return new g0();
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
