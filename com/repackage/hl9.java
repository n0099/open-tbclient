package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CacheStatistic;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdLoader;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunNativeAdInflater;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.o0;
import com.repackage.vf9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes6.dex */
public final class hl9 implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Random a;
    public final vf9 b;
    public final Map<Ssp.Pid, PidLoader> c;
    public final com.fun.o0 d;
    public i e;
    public FunAdInteractionListener f;
    public final Handler g;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(hl9 hl9Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl9Var;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                boolean z = false;
                if (i == 100) {
                    i iVar = (i) message.obj;
                    i iVar2 = this.a.e;
                    if (iVar2 == null || iVar2 != iVar || (funAdLoadListener = iVar.c) == null) {
                        return;
                    }
                    vf9 vf9Var = iVar.d.b;
                    LogPrinter.e("callback onError(%s) because of timeout(%d)", vf9Var.a, Long.valueOf(vf9Var.c));
                    funAdLoadListener.onError(iVar.d.b.a);
                    iVar.a();
                } else if (i == 101) {
                    i iVar3 = (i) message.obj;
                    i iVar4 = this.a.e;
                    if (iVar4 == null || iVar4 != iVar3) {
                        return;
                    }
                    synchronized (iVar3) {
                        synchronized (iVar3) {
                            Iterator<Map.Entry<vf9.c, Integer>> it = iVar3.a.entrySet().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                } else if (it.next().getValue().intValue() == 1) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                    }
                    if (z) {
                        iVar3.b(iVar3.c);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements jf9<Result> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf9 a;

        public b(hl9 hl9Var, pf9 pf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, pf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pf9Var;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, Result] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, Result] */
        @Override // com.repackage.jf9
        public Result a(PidLoader pidLoader, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pidLoader, str)) == null) {
                ?? a = this.a.a(pidLoader);
                if (a == 0 || !this.a.a((pf9) a)) {
                    return null;
                }
                return a;
            }
            return invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FunAdInteractionListener a;
        public final /* synthetic */ hl9 b;

        public c(hl9 hl9Var, FunAdInteractionListener funAdInteractionListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, funAdInteractionListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hl9Var;
            this.a = funAdInteractionListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onAdError(this.b.b.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements of9<vf9.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ hl9 c;

        public d(hl9 hl9Var, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hl9Var;
            this.a = list;
            this.b = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.of9
        public boolean a(vf9.b bVar) {
            InterceptResult invokeL;
            List list;
            RippedAd rippedAd;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                PidLoader pidLoader = this.c.c.get(bVar.c);
                if (pidLoader == null || (((list = this.a) != null && list.contains(pidLoader)) || (this.b && ((rippedAd = pidLoader.getRippedAd()) == null || !rippedAd.isDeepLinkAd)))) {
                    return false;
                }
                return pidLoader.isLoaded();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements pf9<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunNativeAdInflater d;

        public e(hl9 hl9Var, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, activity, viewGroup, str, funNativeAdInflater};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
            this.d = funNativeAdInflater;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
        @Override // com.repackage.pf9
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.b, this.c, this.d)) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.pf9
        public boolean a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements pf9<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;

        public f(hl9 hl9Var, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, activity, viewGroup, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = viewGroup;
            this.c = str;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
        @Override // com.repackage.pf9
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.b, this.c) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.pf9
        public boolean a(FunSplashAd funSplashAd) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements jf9<FunNativeAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public g(hl9 hl9Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, com.fun.ad.sdk.FunNativeAd] */
        @Override // com.repackage.jf9
        public FunNativeAd a(PidLoader pidLoader, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pidLoader, str)) == null) ? pidLoader.getNativeAd(this.a, str) : invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements jf9<FunNativeAd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public h(hl9 hl9Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunNativeAd2, java.lang.Object] */
        @Override // com.repackage.jf9
        public FunNativeAd2 a(PidLoader pidLoader, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, pidLoader, str)) == null) ? pidLoader.getNativeAd2(this.a, str) : invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedHashMap<vf9.c, Integer> a;
        public long b;
        public FunAdLoadListener c;
        public final /* synthetic */ hl9 d;

        public i(hl9 hl9Var, FunAdLoadListener funAdLoadListener, List<vf9.b> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, funAdLoadListener, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hl9Var;
            this.a = new LinkedHashMap<>();
            this.c = funAdLoadListener;
            for (vf9.b bVar : list) {
                this.a.put(bVar.d, 0);
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c = null;
                this.d.g.removeMessages(100, this);
                this.d.g.removeMessages(101, this);
            }
        }

        public final void b(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdLoadListener) == null) || funAdLoadListener == null) {
                return;
            }
            funAdLoadListener.onAdLoaded(this.d.b.a);
            a();
        }

        public synchronized void c(vf9.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                synchronized (this) {
                    Ssp.Pid pid = bVar.c;
                    LogPrinter.d("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(bVar.d.a), pid.type, pid.pid);
                    FunAdLoadListener funAdLoadListener = this.c;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    vf9.c cVar = bVar.d;
                    if (this.a.containsKey(cVar)) {
                        this.a.put(cVar, 1);
                        if (this.d.b.b > 0 && System.currentTimeMillis() - this.b < this.d.b.b) {
                            e(funAdLoadListener);
                            return;
                        }
                        b(funAdLoadListener);
                    }
                }
            }
        }

        public synchronized void d(vf9.b bVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, bVar, i, str) == null) {
                synchronized (this) {
                    Ssp.Pid pid = bVar.c;
                    LogPrinter.d("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i), str, Integer.valueOf(bVar.d.a), pid.type, pid.pid);
                    if (this.a.containsKey(bVar.d)) {
                        this.a.put(bVar.d, -1);
                        FunAdLoadListener funAdLoadListener = this.c;
                        if (funAdLoadListener == null) {
                            return;
                        }
                        e(funAdLoadListener);
                    }
                }
            }
        }

        public final synchronized void e(FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, funAdLoadListener) == null) {
                synchronized (this) {
                    boolean z = true;
                    int i = -1;
                    for (Map.Entry<vf9.c, Integer> entry : this.a.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            vf9.c key = entry.getKey();
                            if (i < 0) {
                                i = key.a;
                            } else if (i != key.a) {
                                return;
                            }
                            if (intValue != 0) {
                                if (intValue == 1) {
                                    LogPrinter.d("callback onAdLoaded(%s) because max priority adId is loaded", this.d.b.a);
                                    b(funAdLoadListener);
                                    return;
                                }
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                            z = false;
                        }
                    }
                    if (z) {
                        LogPrinter.e("callback onError(%s) as all group failed to load", this.d.b.a);
                        funAdLoadListener.onError(this.d.b.a);
                        a();
                    }
                }
            }
        }
    }

    public hl9(vf9 vf9Var, ll9 ll9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vf9Var, ll9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Random();
        this.g = new a(this, Looper.getMainLooper());
        this.b = vf9Var;
        this.d = new o0.c(vf9Var);
        HashMap hashMap = new HashMap();
        for (vf9.c cVar : vf9Var.e) {
            for (vf9.b bVar : cVar.b) {
                PidLoader a2 = ll9Var.a(bVar.c);
                if (a2 != null) {
                    a2.addListener(new j(this, bVar, a2));
                    hashMap.put(bVar.c, a2);
                }
            }
        }
        this.c = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(vf9.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            return this.c.get(bVar.c);
        }
        return (PidLoader) invokeL.objValue;
    }

    public final PidLoader b(boolean z, vf9.c cVar, List<PidLoader> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), cVar, list})) == null) {
            vf9.b bVar = (vf9.b) nf9.a(this.a, cVar.b, new d(this, list, z));
            if (bVar == null) {
                return null;
            }
            return this.c.get(bVar.c);
        }
        return (PidLoader) invokeCommon.objValue;
    }

    public final <N> N c(jf9<N> jf9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jf9Var)) == null) {
            boolean z = FunAdSdk.getFunAdConfig().isFilterDeepLinkAd;
            for (vf9.c cVar : this.b.e) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader b2 = b(z, cVar, arrayList);
                    if (b2 != null) {
                        N a2 = jf9Var.a(b2, this.b.a);
                        if (a2 != null) {
                            return a2;
                        }
                        arrayList.add(b2);
                    }
                }
            }
            return null;
        }
        return (N) invokeL.objValue;
    }

    public final <Result> Result d(FunAdInteractionListener funAdInteractionListener, pf9<Result> pf9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, funAdInteractionListener, pf9Var)) == null) {
            this.f = funAdInteractionListener;
            this.d.e();
            Result result = (Result) c(new b(this, pf9Var));
            if (result == null) {
                LogPrinter.e("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.b.a);
                this.g.post(new c(this, funAdInteractionListener));
            }
            return result;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.g.removeMessages(100);
                this.f = null;
                i iVar = this.e;
                if (iVar != null) {
                    iVar.a();
                    this.e = null;
                }
                for (PidLoader pidLoader : this.c.values()) {
                    pidLoader.destroy();
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (vf9.c cVar : this.b.e) {
                    for (vf9.b bVar : cVar.b) {
                        if (bVar != null && (a2 = a(bVar)) != null && a2.isLoaded()) {
                            arrayList.add(new CacheStatistic(a2.getAdType(), a2.getPid().pid, a2.getAdCount(), a2.getPid().basePrice));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd getNativeAd(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            FunNativeAd funNativeAd = (FunNativeAd) c(new g(this, context));
            if (funNativeAd == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.b.a);
            }
            return funNativeAd;
        }
        return (FunNativeAd) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) c(new h(this, context));
            if (funNativeAd2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.b.a);
            }
            return funNativeAd2;
        }
        return (FunNativeAd2) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            for (PidLoader pidLoader : this.c.values()) {
                if (pidLoader.isLoaded()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e1 A[Catch: all -> 0x011f, TryCatch #0 {, blocks: (B:6:0x0007, B:18:0x004c, B:21:0x0054, B:23:0x007c, B:24:0x008d, B:25:0x0099, B:27:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00b5, B:34:0x00c7, B:36:0x00cd, B:38:0x00d3, B:39:0x00db, B:41:0x00e1, B:44:0x00ea, B:47:0x00f1, B:49:0x00f7, B:51:0x00fd, B:55:0x0107, B:9:0x0020, B:10:0x002b, B:12:0x0031, B:14:0x0043, B:58:0x0119, B:59:0x011e), top: B:66:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fd A[Catch: all -> 0x011f, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0007, B:18:0x004c, B:21:0x0054, B:23:0x007c, B:24:0x008d, B:25:0x0099, B:27:0x009f, B:29:0x00ab, B:31:0x00b1, B:32:0x00b5, B:34:0x00c7, B:36:0x00cd, B:38:0x00d3, B:39:0x00db, B:41:0x00e1, B:44:0x00ea, B:47:0x00f1, B:49:0x00f7, B:51:0x00fd, B:55:0x0107, B:9:0x0020, B:10:0x002b, B:12:0x0031, B:14:0x0043, B:58:0x0119, B:59:0x011e), top: B:66:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fb A[EDGE_INSN: B:72:0x00fb->B:50:0x00fb ?: BREAK  , SYNTHETIC] */
    @Override // com.fun.ad.sdk.FunAdLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        boolean z;
        Iterator<vf9.b> it;
        PidLoader a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                this.d.d();
                this.g.removeMessages(101);
                this.g.removeMessages(100);
                vf9 vf9Var = this.b;
                ArrayList arrayList = null;
                if (vf9Var != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (vf9.c cVar : vf9Var.e) {
                        vf9.b bVar = (vf9.b) nf9.a(this.a, cVar.b, null);
                        if (bVar != null) {
                            arrayList2.add(bVar);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    i iVar = new i(this, funAdLoadListener, arrayList);
                    this.e = iVar;
                    iVar.b = System.currentTimeMillis();
                    Message obtainMessage = this.g.obtainMessage(100);
                    obtainMessage.obj = iVar;
                    this.g.sendMessageDelayed(obtainMessage, this.b.c);
                    if (this.b.b > 0) {
                        Message obtainMessage2 = this.g.obtainMessage(101);
                        obtainMessage2.obj = iVar;
                        this.g.sendMessageDelayed(obtainMessage2, this.b.b);
                    }
                    LogPrinter.d("Start load for sid:%s", vf9Var.a);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        vf9.b bVar2 = (vf9.b) arrayList.get(i2);
                        PidLoader a3 = a(bVar2);
                        if (a3 != null) {
                            if (a3.isLoaded()) {
                                iVar.c(bVar2);
                            } else {
                                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(a3.getPid().pid, a3.getAdType());
                                if (shouldIntercept == null || !shouldIntercept.shouldInterceptLoad()) {
                                    a3.load(context, funAdSlot);
                                    z = false;
                                    it = bVar2.d.b.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        vf9.b next = it.next();
                                        if (next != bVar2 && (a2 = a(next)) != null && a2.isLoaded()) {
                                            iVar.c(next);
                                            z = false;
                                            break;
                                        }
                                    }
                                    if (!z) {
                                        iVar.d(bVar2, 0, "F1:No ready loader found");
                                    }
                                }
                            }
                        }
                        z = true;
                        it = bVar2.d.b.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                            }
                        }
                        if (!z) {
                        }
                    }
                    return;
                }
                LogPrinter.e("No selected adIds found for sid:%s", vf9Var.a);
                funAdLoadListener.onError(vf9Var.a);
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f = null;
            i iVar = this.e;
            if (iVar != null) {
                iVar.a();
            }
            this.e = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048587, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) d(funAdInteractionListener, new e(this, activity, t, str, funNativeAdInflater));
                if (bool != null) {
                    z = bool.booleanValue();
                }
            }
            return z;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> FunSplashAd showSplash(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        FunSplashAd funSplashAd;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, activity, t, str, funAdInteractionListener)) == null) {
            synchronized (this) {
                funSplashAd = (FunSplashAd) d(funAdInteractionListener, new f(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes6.dex */
    public class j implements kl9 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean d;
        public transient /* synthetic */ FieldHolder $fh;
        public final vf9.b a;
        public final PidLoader b;
        public final /* synthetic */ hl9 c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-324679594, "Lcom/repackage/hl9$j;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-324679594, "Lcom/repackage/hl9$j;");
                    return;
                }
            }
            d = !hl9.class.desiredAssertionStatus();
        }

        public j(hl9 hl9Var, vf9.b bVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl9Var, bVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = hl9Var;
            this.a = bVar;
            this.b = pidLoader;
        }

        @Override // com.repackage.kl9
        public void a() {
            hl9 hl9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (hl9Var = this.c).f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(hl9Var.b.a);
        }

        @Override // com.repackage.kl9
        public void b(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048581, this, rippedAd, strArr) == null) || (funAdInteractionListener = this.c.f) == null) {
                return;
            }
            if (!d && this.a.c == null) {
                throw new AssertionError();
            }
            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.c.pid, this.b.getAdType());
            if (shouldIntercept != null) {
                shouldIntercept.onAdClick(rippedAd);
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = this.c.b.a;
            Ssp.Pid pid = this.a.c;
            callBackAware.onAdClicked(funAdInteractionListener, str, pid.ssp.type, pid.pid, strArr);
        }

        @Override // com.repackage.kl9
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // com.repackage.kl9
        public void c(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, strArr) == null) || (funAdInteractionListener = this.c.f) == null) {
                return;
            }
            if (!d && this.a.c == null) {
                throw new AssertionError();
            }
            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.c.pid, this.b.getAdType());
            if (shouldIntercept != null) {
                shouldIntercept.onAdShow(rippedAd);
            }
            CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
            String str = this.c.b.a;
            Ssp.Pid pid = this.a.c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd, strArr);
        }

        @Override // com.repackage.kl9
        public void a(int i, String str) {
            i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (iVar = this.c.e) == null) {
                return;
            }
            iVar.d(this.a, i, str);
        }

        @Override // com.repackage.kl9
        public void a(boolean z, String... strArr) {
            hl9 hl9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, strArr) == null) || (funAdInteractionListener = (hl9Var = this.c).f) == null) {
                return;
            }
            Flavors.CALL_BACK_AWARE.onRewardedVideo(funAdInteractionListener, hl9Var.b.a, z, strArr);
        }

        @Override // com.repackage.kl9
        public void b(int i, String str) {
            hl9 hl9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (funAdInteractionListener = (hl9Var = this.c).f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(hl9Var.b.a);
        }

        @Override // com.repackage.kl9
        public void b() {
            i iVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iVar = this.c.e) == null) {
                return;
            }
            iVar.c(this.a);
        }
    }
}
