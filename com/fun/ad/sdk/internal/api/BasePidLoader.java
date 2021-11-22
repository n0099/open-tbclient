package com.fun.ad.sdk.internal.api;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.f.f;
import b.f.s0;
import b.f.t0;
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
/* loaded from: classes11.dex */
public abstract class BasePidLoader<A> implements PidLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<f> f63723a;

    /* renamed from: b  reason: collision with root package name */
    public final List<A> f63724b;

    /* renamed from: c  reason: collision with root package name */
    public final Deque<A> f63725c;

    /* renamed from: d  reason: collision with root package name */
    public final BasePidLoader<A>.FunAdCallbackWrapper f63726d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63727e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63728f;

    /* renamed from: g  reason: collision with root package name */
    public RippedAd f63729g;
    public boolean isAdLoading;
    public final boolean isSupportCaching;
    public final boolean isSupportNativeAd;
    public final boolean isSupportSplashAd;
    public final AdRipper mAdRipper;
    public final Ssp.Pid mPid;
    public final AdReporter mReporter;

    /* renamed from: com.fun.ad.sdk.internal.api.BasePidLoader$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public class FunAdCallbackWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BasePidLoader f63730a;

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
            this.f63730a = basePidLoader;
        }

        public /* synthetic */ FunAdCallbackWrapper(BasePidLoader basePidLoader, AnonymousClass1 anonymousClass1) {
            this(basePidLoader);
        }

        public void onAdClicked() {
            t0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClicked(this.f63730a.mPid);
        }

        public void onAdClose() {
            t0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdClose(this.f63730a.mPid);
        }

        public void onAdLoad() {
            t0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoad(this.f63730a.mPid);
        }

        public void onAdLoadError(int i2, String str) {
            t0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoadError(this.f63730a.mPid, i2, str);
        }

        public void onAdLoaded() {
            t0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdLoaded(this.f63730a.mPid);
        }

        public void onAdShow() {
            t0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShow(this.f63730a.mPid);
        }

        public void onAdShowError(int i2, String str) {
            t0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onAdShowError(this.f63730a.mPid, i2, str);
        }

        public void onRewardedVideo() {
            t0 adCallback;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (adCallback = FunAdSdk.getAdCallback()) == null) {
                return;
            }
            adCallback.onRewardedVideo(this.f63730a.mPid);
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
        this.f63723a = new ArrayList();
        this.f63724b = new ArrayList();
        this.f63725c = new ArrayDeque();
        this.f63726d = new FunAdCallbackWrapper(this, null);
        this.f63727e = true;
        this.f63728f = true;
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
        synchronized (this.f63723a) {
            this.f63723a.add(fVar);
        }
    }

    public final void cacheOrDestroyAd(A a2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a2) == null) {
            if (this.isSupportCaching || !this.f63727e) {
                this.f63725c.add(a2);
            } else {
                destroyInternal(a2);
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
                this.f63727e = true;
                this.f63729g = null;
                Iterator<A> it = this.f63724b.iterator();
                while (it.hasNext()) {
                    A next = it.next();
                    destroyInternal(next);
                    this.mAdRipper.destroy(next);
                    it.remove();
                }
                if (!this.isSupportCaching) {
                    Iterator<A> it2 = this.f63725c.iterator();
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

    public abstract void destroyInternal(A a2);

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized FunNativeAd getNativeAd(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, context, str)) == null) {
            synchronized (this) {
                if (this.isSupportNativeAd) {
                    if (isLoaded()) {
                        if (this.f63725c.isEmpty()) {
                            return null;
                        }
                        this.f63729g = null;
                        A pollFirst = this.f63725c.pollFirst();
                        if (pollFirst == null) {
                            return null;
                        }
                        this.f63724b.add(pollFirst);
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
                    if (this.f63725c.isEmpty()) {
                        return null;
                    }
                    this.f63729g = null;
                    A peekFirst = this.f63725c.peekFirst();
                    if (peekFirst == null) {
                        this.f63725c.removeFirst();
                        return null;
                    }
                    FunNativeAd2 nativeAdInternal2 = getNativeAdInternal2(context, str, peekFirst);
                    if (nativeAdInternal2 == null) {
                        return null;
                    }
                    this.f63725c.removeFirst();
                    this.f63724b.add(peekFirst);
                    return nativeAdInternal2;
                }
                return null;
            }
        }
        return (FunNativeAd2) invokeLL.objValue;
    }

    @Deprecated
    public FunNativeAd getNativeAdInternal(Context context, String str, A a2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, context, str, a2)) == null) {
            return null;
        }
        return (FunNativeAd) invokeLLL.objValue;
    }

    public FunNativeAd2 getNativeAdInternal2(Context context, String str, A a2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, a2)) == null) {
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
                if (this.f63728f) {
                    if (isLoaded()) {
                        if (this.f63725c.isEmpty()) {
                            return null;
                        }
                        RippedAd rippedAd = this.f63729g;
                        if (rippedAd != null) {
                            return rippedAd;
                        }
                        RippedAd rippedAdInternal = getRippedAdInternal(this.f63725c.peekFirst());
                        if (rippedAdInternal == null) {
                            this.f63728f = false;
                            return null;
                        }
                        this.f63729g = rippedAdInternal;
                        return rippedAdInternal;
                    }
                    return null;
                }
                return null;
            }
        }
        return (RippedAd) invokeV.objValue;
    }

    public final RippedAd getRippedAdInternal(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, a2)) == null) ? this.mAdRipper.getRippedAd(a2) : (RippedAd) invokeL.objValue;
    }

    public boolean isAdAvailable(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, a2)) == null) ? a2 != null : invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean isLoaded() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                Iterator<A> it = this.f63725c.iterator();
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
                this.f63727e = false;
                if (this.isAdLoading) {
                    return false;
                }
                this.f63729g = null;
                this.isAdLoading = true;
                this.f63724b.addAll(this.f63725c);
                this.f63725c.clear();
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
            this.f63726d.onAdClicked();
            synchronized (this.f63723a) {
                for (f fVar : this.f63723a) {
                    fVar.c();
                }
            }
        }
    }

    public void onAdClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f63726d.onAdClose();
            synchronized (this.f63723a) {
                for (f fVar : this.f63723a) {
                    fVar.b();
                }
            }
        }
    }

    public void onAdError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i2, str) == null) {
            this.f63726d.onAdShowError(i2, str);
            synchronized (this.f63723a) {
                for (f fVar : this.f63723a) {
                    fVar.b(i2, str);
                }
            }
        }
    }

    public final void onAdLoaded(A a2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, a2) == null) {
            cacheOrDestroyAd(a2);
            onLoaded();
        }
    }

    public final void onAdLoaded(List<A> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            for (A a2 : list) {
                cacheOrDestroyAd(a2);
            }
            onLoaded();
        }
    }

    public void onAdShow(A a2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, a2) == null) {
            this.f63726d.onAdShow();
            synchronized (this.f63723a) {
                for (f fVar : this.f63723a) {
                    fVar.a(Flavors.CALL_BACK_AWARE.needRipper() ? this.mAdRipper.getRippedAd(a2) : null);
                }
            }
        }
    }

    public void onError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i2, str) == null) {
            this.isAdLoading = false;
            this.f63726d.onAdLoadError(i2, str);
            synchronized (this.f63723a) {
                for (f fVar : this.f63723a) {
                    fVar.a(i2, str);
                }
            }
        }
    }

    public void onLoadStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f63726d.onAdLoad();
            synchronized (this.f63723a) {
                for (f fVar : this.f63723a) {
                    fVar.e();
                }
            }
        }
    }

    public void onLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.isAdLoading = false;
            this.f63726d.onAdLoaded();
            synchronized (this.f63723a) {
                for (f fVar : this.f63723a) {
                    fVar.d();
                }
            }
        }
    }

    public void onRewardedVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f63726d.onRewardedVideo();
            synchronized (this.f63723a) {
                for (f fVar : this.f63723a) {
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
        synchronized (this.f63723a) {
            this.f63723a.remove(fVar);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.PidLoader
    public final synchronized boolean show(Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048603, this, activity, viewGroup, str, funNativeAdInflater)) == null) {
            synchronized (this) {
                if (isLoaded()) {
                    if (this.f63725c.isEmpty()) {
                        return false;
                    }
                    this.f63729g = null;
                    A pollFirst = this.f63725c.pollFirst();
                    if (pollFirst == null) {
                        return false;
                    }
                    this.f63724b.add(pollFirst);
                    return funNativeAdInflater == null ? showInternal(activity, viewGroup, str, (String) pollFirst) : showInternal(activity, str, funNativeAdInflater, (FunNativeAdInflater) pollFirst);
                }
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean showInternal(Activity activity, ViewGroup viewGroup, String str, A a2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048604, this, activity, viewGroup, str, a2)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public boolean showInternal(Activity activity, String str, FunNativeAdInflater funNativeAdInflater, A a2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048605, this, activity, str, funNativeAdInflater, a2)) == null) {
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
                        if (this.f63725c.isEmpty()) {
                            return null;
                        }
                        this.f63729g = null;
                        A removeFirst = this.f63725c.removeFirst();
                        if (removeFirst == null) {
                            return null;
                        }
                        this.f63724b.add(removeFirst);
                        return showSplashInternal(activity, viewGroup, str, removeFirst);
                    }
                    return null;
                }
                return null;
            }
        }
        return (FunSplashAd) invokeLLL.objValue;
    }

    public FunSplashAd showSplashInternal(Activity activity, ViewGroup viewGroup, String str, A a2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048607, this, activity, viewGroup, str, a2)) == null) {
            if (showInternal(activity, viewGroup, str, (String) a2)) {
                return new s0();
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
