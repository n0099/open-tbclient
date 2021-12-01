package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.g.f;
import c.g.r0;
import c.g.s0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.ripper.AdRipper;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class BasePidLoader<A> implements PidLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<f> a;

    /* renamed from: b  reason: collision with root package name */
    public final List<A> f55708b;

    /* renamed from: c  reason: collision with root package name */
    public final Deque<A> f55709c;

    /* renamed from: d  reason: collision with root package name */
    public final BasePidLoader<A>.FunAdCallbackWrapper f55710d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55711e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55712f;

    /* renamed from: g  reason: collision with root package name */
    public RippedAd f55713g;
    public boolean isAdLoading;
    public final boolean isSupportCaching;
    public final boolean isSupportNativeAd;
    public final boolean isSupportSplashAd;
    public final AdRipper mAdRipper;
    public final Ssp.Pid mPid;
    public final AdReporter mReporter;

    /* renamed from: com.fun.ad.sdk.internal.api.BasePidLoader$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            s0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClicked(this.a.mPid);
        }

        public void onAdClose() {
            s0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClose(this.a.mPid);
        }

        public void onAdLoad() {
            s0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoad(this.a.mPid);
        }

        public void onAdLoadError(int i2, String str) {
            s0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoadError(this.a.mPid, i2, str);
        }

        public void onAdLoaded() {
            s0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoaded(this.a.mPid);
        }

        public void onAdShow() {
            s0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShow(this.a.mPid);
        }

        public void onAdShowError(int i2, String str) {
            s0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShowError(this.a.mPid, i2, str);
        }

        public void onRewardedVideo() {
            s0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onRewardedVideo(this.a.mPid);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePidLoader(Ssp.Pid pid) {
        this(pid, true, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePidLoader(Ssp.Pid pid, boolean z) {
        this(pid, z, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePidLoader(Ssp.Pid pid, boolean z, boolean z2) {
        this(pid, z, z2, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Ssp.Pid) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public BasePidLoader(Ssp.Pid pid, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f55708b = new ArrayList();
        this.f55709c = new ArrayDeque();
        this.f55710d = new FunAdCallbackWrapper(this, null);
        this.f55711e = true;
        this.f55712f = true;
        this.mReporter = new AdReporter();
        if (pid == null) {
            throw new IllegalArgumentException();
        }
        this.mPid = pid;
        this.isSupportCaching = z;
        this.isSupportNativeAd = z2;
        this.isSupportSplashAd = z3;
        this.mAdRipper = createAdRipper(pid);
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void addListener(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) || fVar == null) {
            return;
        }
        synchronized (this.a) {
            this.a.add(fVar);
        }
    }

    public final void cacheOrDestroyAd(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a) == null) {
            if (this.isSupportCaching || !this.f55711e) {
                this.f55709c.add(a);
            } else {
                destroyInternal(a);
            }
        }
    }

    public AdRipper createAdRipper(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pid)) == null) ? BaseAdRipper.FAKE_AD_RIPPER : (AdRipper) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.f55711e = true;
                this.f55713g = null;
                Iterator<A> it = this.f55708b.iterator();
                while (it.hasNext()) {
                    A next = it.next();
                    destroyInternal(next);
                    this.mAdRipper.destroy(next);
                    it.remove();
                }
                if (!this.isSupportCaching) {
                    Iterator<A> it2 = this.f55709c.iterator();
                    while (it2.hasNext()) {
                        A next2 = it2.next();
                        destroyInternal(next2);
                        this.mAdRipper.destroy(next2);
                        it2.remove();
                    }
                }
            }
        }
    }

    public abstract void destroyInternal(A a);

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, str)) == null) {
            synchronized (this) {
                if (this.isSupportNativeAd) {
                    if (isLoaded()) {
                        if (this.f55709c.isEmpty()) {
                            return null;
                        }
                        this.f55713g = null;
                        A pollFirst = this.f55709c.pollFirst();
                        if (pollFirst == null) {
                            return null;
                        }
                        this.f55708b.add(pollFirst);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, context, str)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.f55709c.isEmpty()) {
                        return null;
                    }
                    this.f55713g = null;
                    A peekFirst = this.f55709c.peekFirst();
                    if (peekFirst == null) {
                        this.f55709c.removeFirst();
                        return null;
                    }
                    FunNativeAd2 nativeAdInternal2 = getNativeAdInternal2(context, str, peekFirst);
                    if (nativeAdInternal2 == null) {
                        return null;
                    }
                    this.f55709c.removeFirst();
                    this.f55708b.add(peekFirst);
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, str, a)) == null) {
            return null;
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    public FunNativeAd2 getNativeAdInternal2(Context context, String str, A a) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, a)) == null) {
            return null;
        }
        return (FunNativeAd2) invokeLLL.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public Ssp.Pid getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mPid : (Ssp.Pid) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized RippedAd getRippedAd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                if (this.f55712f) {
                    if (isLoaded()) {
                        if (this.f55709c.isEmpty()) {
                            return null;
                        }
                        RippedAd rippedAd = this.f55713g;
                        if (rippedAd != null) {
                            return rippedAd;
                        }
                        RippedAd rippedAdInternal = getRippedAdInternal(this.f55709c.peekFirst());
                        if (rippedAdInternal == null) {
                            this.f55712f = false;
                            return null;
                        }
                        this.f55713g = rippedAdInternal;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, a)) == null) ? this.mAdRipper.getRippedAd(a) : (RippedAd) invokeL.objValue;
    }

    public boolean isAdAvailable(A a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, a)) == null) ? a != null : invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean isLoaded() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                Iterator<A> it = this.f55709c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (isAdAvailable(it.next())) {
                        z = true;
                        break;
                    } else {
                        it.remove();
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean load(Context context, FunAdSlot funAdSlot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, context, funAdSlot)) == null) {
            synchronized (this) {
                this.f55711e = false;
                if (this.isAdLoading) {
                    return false;
                }
                this.f55713g = null;
                this.isAdLoading = true;
                this.f55708b.addAll(this.f55709c);
                this.f55709c.clear();
                loadInternal(context, funAdSlot);
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public abstract void loadInternal(Context context, FunAdSlot funAdSlot);

    public void onAdClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f55710d.onAdClicked();
            synchronized (this.a) {
                for (f fVar : this.a) {
                    fVar.c();
                }
            }
        }
    }

    public void onAdClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f55710d.onAdClose();
            synchronized (this.a) {
                for (f fVar : this.a) {
                    fVar.b();
                }
            }
        }
    }

    public void onAdError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, str) == null) {
            this.f55710d.onAdShowError(i2, str);
            synchronized (this.a) {
                for (f fVar : this.a) {
                    fVar.b(i2, str);
                }
            }
        }
    }

    public final void onAdLoaded(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, a) == null) {
            cacheOrDestroyAd(a);
            onLoaded();
        }
    }

    public final void onAdLoaded(List<A> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            for (A a : list) {
                cacheOrDestroyAd(a);
            }
            onLoaded();
        }
    }

    public void onAdShow(A a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, a) == null) {
            this.f55710d.onAdShow();
            synchronized (this.a) {
                for (f fVar : this.a) {
                    fVar.a(Flavors.CALL_BACK_AWARE.needRipper() ? this.mAdRipper.getRippedAd(a) : null);
                }
            }
        }
    }

    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, str) == null) {
            this.isAdLoading = false;
            this.f55710d.onAdLoadError(i2, str);
            synchronized (this.a) {
                for (f fVar : this.a) {
                    fVar.a(i2, str);
                }
            }
        }
    }

    public void onLoadStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f55710d.onAdLoad();
            synchronized (this.a) {
                for (f fVar : this.a) {
                    fVar.e();
                }
            }
        }
    }

    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.isAdLoading = false;
            this.f55710d.onAdLoaded();
            synchronized (this.a) {
                for (f fVar : this.a) {
                    fVar.d();
                }
            }
        }
    }

    public void onRewardedVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f55710d.onRewardedVideo();
            synchronized (this.a) {
                for (f fVar : this.a) {
                    fVar.a();
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public void removeListener(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) || fVar == null) {
            return;
        }
        synchronized (this.a) {
            this.a.remove(fVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean show(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048603, this, activity, viewGroup, str, funNativeAdInflater)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.f55709c.isEmpty()) {
                        return false;
                    }
                    this.f55713g = null;
                    A pollFirst = this.f55709c.pollFirst();
                    if (pollFirst == null) {
                        return false;
                    }
                    this.f55708b.add(pollFirst);
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
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048604, this, activity, viewGroup, str, a)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean showInternal(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, A a) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048605, this, activity, str, funNativeAdInflater, a)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048606, this, activity, viewGroup, str)) == null) {
            synchronized (this) {
                if (this.isSupportSplashAd) {
                    if (isLoaded()) {
                        if (this.f55709c.isEmpty()) {
                            return null;
                        }
                        this.f55713g = null;
                        A removeFirst = this.f55709c.removeFirst();
                        if (removeFirst == null) {
                            return null;
                        }
                        this.f55708b.add(removeFirst);
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
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048607, this, activity, viewGroup, str, a)) == null) {
            if (showInternal(activity, viewGroup, str, (String) a)) {
                return new r0();
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
