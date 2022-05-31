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
import com.repackage.ib9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes7.dex */
public class xg9 implements FunAdLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ib9 a;
    public final Map<Ssp.Pid, PidLoader> b;
    public final Random c;
    public o0.d d;
    public e e;
    public FunAdInteractionListener f;
    public final Handler g;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xg9 xg9Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg9Var, looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 100) {
                e eVar = (e) message.obj;
                if (eVar == null) {
                    LogPrinter.d("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    eVar.a();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements eb9<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;
        public final /* synthetic */ FunNativeAdInflater d;

        public b(xg9 xg9Var, Activity activity, ViewGroup viewGroup, String str, FunNativeAdInflater funNativeAdInflater) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg9Var, activity, viewGroup, str, funNativeAdInflater};
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
        @Override // com.repackage.eb9
        public Boolean a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? Boolean.valueOf(pidLoader.show(this.a, this.b, this.c, this.d)) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.eb9
        public boolean a(Boolean bool) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) ? bool.booleanValue() : invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements eb9<FunSplashAd> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ String c;

        public c(xg9 xg9Var, Activity activity, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg9Var, activity, viewGroup, str};
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
        @Override // com.repackage.eb9
        public FunSplashAd a(PidLoader pidLoader) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) ? pidLoader.showSplash(this.a, this.b, this.c) : invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.eb9
        public boolean a(FunSplashAd funSplashAd) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements db9<ib9.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ xg9 b;

        public d(xg9 xg9Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg9Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg9Var;
            this.a = list;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.repackage.db9
        public boolean a(ib9.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                PidLoader pidLoader = this.b.b.get(aVar.c);
                List list = this.a;
                return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public final FunAdSlot b;
        public final Iterator<ib9.b> c;
        public final o0.d d;
        public final HashSet<ib9.a> e;
        public boolean f;
        public int g;
        public FunAdLoadListener h;
        public final /* synthetic */ xg9 i;

        public e(xg9 xg9Var, Context context, FunAdSlot funAdSlot, Iterator<ib9.b> it, FunAdLoadListener funAdLoadListener, o0.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg9Var, context, funAdSlot, it, funAdLoadListener, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = xg9Var;
            this.e = new HashSet<>();
            this.g = 0;
            this.h = funAdLoadListener;
            this.a = context;
            this.b = funAdSlot;
            this.c = it;
            this.d = dVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.i) {
                    FunAdLoadListener funAdLoadListener = this.h;
                    if (this.f) {
                        this.g++;
                        this.f = false;
                    }
                    int i = this.g;
                    if (funAdLoadListener == null) {
                        LogPrinter.d("Give up load by LoadHandler with listener already recycled", new Object[0]);
                        this.d.f(i, -1);
                    } else if (this.i.e != this) {
                        this.d.f(i, -101);
                        funAdLoadListener.onError(this.i.a.a);
                        c();
                    } else if (!this.c.hasNext() && this.e.isEmpty()) {
                        this.d.f(i, -102);
                        LogPrinter.d("All loader load failed, callback onError(%s)", this.i.a.a);
                        funAdLoadListener.onError(this.i.a.a);
                        c();
                    } else if (!this.c.hasNext()) {
                        LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        ib9.b next = this.c.next();
                        this.f = true;
                        if (next.b.isEmpty()) {
                            LogPrinter.e("There is an empty group in SerialSid(%s)", this.i.a.a);
                            this.d.g(i, null, -1000);
                            a();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        for (ib9.a aVar : next.b) {
                            PidLoader pidLoader = this.i.b.get(aVar.c);
                            if (pidLoader != null) {
                                this.e.add(aVar);
                                if (pidLoader.isLoaded()) {
                                    this.d.g(i, aVar.c.type, 0);
                                    b(aVar);
                                    return;
                                }
                                arrayList.add(pidLoader);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.i.a.a);
                            this.d.g(i, null, -1001);
                            a();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        boolean z = true;
                        while (it.hasNext()) {
                            PidLoader pidLoader2 = (PidLoader) it.next();
                            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(pidLoader2.getPid().pid, pidLoader2.getAdType());
                            if (shouldIntercept == null || !shouldIntercept.shouldInterceptLoad()) {
                                this.d.g(i, pidLoader2.getPid().type, pidLoader2.load(this.a, this.b) ? 1 : 2);
                                z = false;
                            }
                        }
                        if (z) {
                            a();
                            return;
                        }
                        this.i.g.removeMessages(100, this);
                        this.i.g.sendMessageDelayed(this.i.g.obtainMessage(100, this), next.a);
                    }
                }
            }
        }

        public void b(ib9.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.i) {
                    if (this.i.e != this) {
                        return;
                    }
                    FunAdLoadListener funAdLoadListener = this.h;
                    if (funAdLoadListener == null) {
                        return;
                    }
                    if (this.e.remove(aVar)) {
                        o0.d dVar = this.d;
                        int i = this.g;
                        String str = aVar.c.type;
                        dVar.getClass();
                        dVar.c("ldr_ld_succeed", "layer", Integer.valueOf(i), "stype", str);
                        funAdLoadListener.onAdLoaded(this.i.a.a);
                        c();
                    }
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                synchronized (this.i) {
                    this.i.g.removeMessages(100, this);
                    this.h = null;
                    this.e.clear();
                    xg9 xg9Var = this.i;
                    if (xg9Var.e == this) {
                        xg9Var.e = null;
                    }
                }
            }
        }
    }

    public xg9(ib9 ib9Var, ah9 ah9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ib9Var, ah9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new Random();
        this.g = new a(this, Looper.getMainLooper());
        this.a = ib9Var;
        HashMap hashMap = new HashMap();
        for (ib9.b bVar : ib9Var.b) {
            for (ib9.a aVar : bVar.b) {
                PidLoader a2 = ah9Var.a(aVar.c);
                if (a2 != null) {
                    a2.addListener(new f(this, aVar, a2));
                    hashMap.put(aVar.c, a2);
                }
            }
        }
        this.b = Collections.unmodifiableMap(hashMap);
    }

    public final PidLoader a(ib9.b bVar, List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            ib9.a aVar = (ib9.a) cb9.a(this.c, bVar.b, new d(this, list));
            if (aVar == null) {
                return null;
            }
            return this.b.get(aVar.c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <Result> Result b(FunAdInteractionListener funAdInteractionListener, eb9<Result> eb9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, eb9Var)) == null) {
            if (this.d == null) {
                this.d = new o0.d(this.a);
            }
            this.f = funAdInteractionListener;
            this.d.e();
            for (ib9.b bVar : this.a.b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        Result a3 = eb9Var.a(a2);
                        if (a3 != null && eb9Var.a((eb9<Result>) a3)) {
                            return a3;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            funAdInteractionListener.onAdError(this.a.a);
            this.f = null;
            LogPrinter.e("showFailed for SerialSlotId(%s), because no ready loader found", this.a.a);
            return null;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.g.removeMessages(100);
                e eVar = this.e;
                if (eVar != null) {
                    eVar.c();
                }
                this.e = null;
                this.f = null;
                for (ib9.b bVar : this.a.b) {
                    for (ib9.a aVar : bVar.b) {
                        PidLoader pidLoader = this.b.get(aVar.c);
                        if (pidLoader != null) {
                            pidLoader.destroy();
                        }
                    }
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (ib9.b bVar : this.a.b) {
                    for (ib9.a aVar : bVar.b) {
                        if (aVar != null && (pidLoader = this.b.get(aVar.c)) != null && pidLoader.isLoaded()) {
                            arrayList.add(new CacheStatistic(pidLoader.getAdType(), pidLoader.getPid().pid, pidLoader.getAdCount(), pidLoader.getPid().basePrice));
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            for (ib9.b bVar : this.a.b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        FunNativeAd nativeAd = a2.getNativeAd(context, this.a.a);
                        if (nativeAd != null) {
                            return nativeAd;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            return null;
        }
        return (FunNativeAd) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            for (ib9.b bVar : this.a.b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        FunNativeAd2 nativeAd2 = a2.getNativeAd2(context, this.a.a);
                        if (nativeAd2 != null) {
                            return nativeAd2;
                        }
                        arrayList.add(a2);
                    }
                }
            }
            return null;
        }
        return (FunNativeAd2) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized boolean isReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                Iterator<ib9.b> it = this.a.b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (ib9.a aVar : it.next().b) {
                        PidLoader pidLoader = this.b.get(aVar.c);
                        if (pidLoader != null && pidLoader.isLoaded()) {
                            z = true;
                            break loop0;
                        }
                    }
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized void load(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this) {
                if (funAdLoadListener == null) {
                    throw new IllegalArgumentException();
                }
                o0.d dVar = new o0.d(this.a);
                this.g.removeMessages(100);
                if (this.e != null) {
                    dVar.h(true);
                    this.e.c();
                } else {
                    dVar.h(false);
                }
                if (this.a.b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.a.a);
                    dVar.f(-1, -100);
                    funAdLoadListener.onError(this.a.a);
                    return;
                }
                this.d = dVar;
                e eVar = new e(this, context, funAdSlot, this.a.b.iterator(), funAdLoadListener, dVar);
                this.e = eVar;
                eVar.a();
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public void recycleLisener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            e eVar = this.e;
            if (eVar != null) {
                eVar.c();
            }
            this.e = null;
            this.f = null;
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized <T extends ViewGroup> boolean show(Activity activity, T t, String str, FunAdInteractionListener funAdInteractionListener, FunNativeAdInflater funNativeAdInflater) {
        InterceptResult invokeLLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048585, this, activity, t, str, funAdInteractionListener, funNativeAdInflater)) == null) {
            synchronized (this) {
                Boolean bool = (Boolean) b(funAdInteractionListener, new b(this, activity, t, str, funNativeAdInflater));
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
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048586, this, activity, t, str, funAdInteractionListener)) == null) {
            synchronized (this) {
                funSplashAd = (FunSplashAd) b(funAdInteractionListener, new c(this, activity, t, str));
            }
            return funSplashAd;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class f implements zg9 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean d;
        public transient /* synthetic */ FieldHolder $fh;
        public final ib9.a a;
        public final PidLoader b;
        public final /* synthetic */ xg9 c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(128769093, "Lcom/repackage/xg9$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(128769093, "Lcom/repackage/xg9$f;");
                    return;
                }
            }
            d = !xg9.class.desiredAssertionStatus();
        }

        public f(xg9 xg9Var, ib9.a aVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg9Var, aVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = xg9Var;
            this.a = aVar;
            this.b = pidLoader;
        }

        @Override // com.repackage.zg9
        public void a() {
            xg9 xg9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (funAdInteractionListener = (xg9Var = this.c).f) == null) {
                return;
            }
            funAdInteractionListener.onAdClose(xg9Var.a.a);
        }

        @Override // com.repackage.zg9
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
            String str = this.c.a.a;
            Ssp.Pid pid = this.a.c;
            callBackAware.onAdClicked(funAdInteractionListener, str, pid.ssp.type, pid.pid, strArr);
        }

        @Override // com.repackage.zg9
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        @Override // com.repackage.zg9
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
            String str = this.c.a.a;
            Ssp.Pid pid = this.a.c;
            callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, pid.basePrice, rippedAd, strArr);
        }

        @Override // com.repackage.zg9
        public void a(int i, String str) {
            e eVar;
            FunAdLoadListener funAdLoadListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (eVar = this.c.e) == null) {
                return;
            }
            ib9.a aVar = this.a;
            synchronized (eVar.i) {
                if (eVar.i.e == eVar && eVar.e.remove(aVar) && (funAdLoadListener = eVar.h) != null) {
                    if (!eVar.c.hasNext() && eVar.e.isEmpty()) {
                        LogPrinter.d("All loader load failed, callback onError(%s)", eVar.i.a.a);
                        eVar.d.f(eVar.g, -103);
                        funAdLoadListener.onError(eVar.i.a.a);
                        eVar.c();
                    } else if (eVar.e.isEmpty()) {
                        eVar.i.g.removeMessages(100, eVar);
                        eVar.i.g.obtainMessage(100, eVar).sendToTarget();
                    }
                }
            }
        }

        @Override // com.repackage.zg9
        public void b(int i, String str) {
            xg9 xg9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || (funAdInteractionListener = (xg9Var = this.c).f) == null) {
                return;
            }
            funAdInteractionListener.onAdError(xg9Var.a.a);
        }

        @Override // com.repackage.zg9
        public void b() {
            e eVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (eVar = this.c.e) == null) {
                return;
            }
            eVar.b(this.a);
        }

        @Override // com.repackage.zg9
        public void a(boolean z, String... strArr) {
            xg9 xg9Var;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, strArr) == null) || (funAdInteractionListener = (xg9Var = this.c).f) == null) {
                return;
            }
            Flavors.CALL_BACK_AWARE.onRewardedVideo(funAdInteractionListener, xg9Var.a.a, z, strArr);
        }
    }
}
