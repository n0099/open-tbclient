package com.fun;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.eub;
import com.baidu.tieba.fub;
import com.baidu.tieba.hub;
import com.baidu.tieba.lob;
import com.baidu.tieba.rnb;
import com.baidu.tieba.snb;
import com.baidu.tieba.tnb;
import com.baidu.tieba.ynb;
import com.baidu.tieba.ztb;
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
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.ReadyCacheStatistic;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.IAdForbidStrategyManager;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes9.dex */
public class t extends lob<b> {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int d = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final ynb e;
    public final Map<Ssp.Pid, PidLoader> f;
    public final Random g;
    public FunAdInteractionListener h;
    public final boolean i;
    public final List<PidLoader> j;
    public final List<PidLoader> k;
    public final List<ynb.a> l;
    public final Handler m;

    public t(ynb ynbVar, fub fubVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ynbVar, fubVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new Random();
        this.m = new a(this, Looper.getMainLooper());
        this.e = ynbVar;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        for (ynb.b bVar : ynbVar.b) {
            for (ynb.a aVar : bVar.b) {
                PidLoader a2 = fubVar.a(aVar.c);
                if (a2 != null) {
                    if (aVar.c.isBidding) {
                        arrayList2.add(a2);
                        arrayList3.add(aVar);
                    } else {
                        arrayList.add(a2);
                    }
                    a2.addListener(new c(this, aVar, a2));
                    hashMap.put(aVar.c, a2);
                }
            }
        }
        this.f = Collections.unmodifiableMap(hashMap);
        this.j = Collections.unmodifiableList(arrayList);
        List<PidLoader> unmodifiableList = Collections.unmodifiableList(arrayList2);
        this.k = unmodifiableList;
        this.l = Collections.unmodifiableList(arrayList3);
        this.i = !unmodifiableList.isEmpty();
        if (hashMap2.isEmpty()) {
            return;
        }
        Collections.unmodifiableMap(hashMap2);
    }

    public static /* synthetic */ Object a(tnb tnbVar, PidLoader pidLoader, String str) {
        Object a2 = tnbVar.a(pidLoader);
        if (a2 == null || !tnbVar.a((tnb) a2)) {
            return null;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(List list, ynb.a aVar) {
        PidLoader pidLoader = this.f.get(aVar.c);
        return (list == null || !list.contains(pidLoader)) && pidLoader != null && pidLoader.isLoaded();
    }

    public final PidLoader a(ynb.b bVar, final List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, list)) == null) {
            ynb.a aVar = (ynb.a) rnb.a(this.g, bVar.b, new snb() { // from class: com.baidu.tieba.lnb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.snb
                public final boolean a(Object obj) {
                    InterceptResult invokeL;
                    boolean a2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                        a2 = com.fun.t.this.a(list, (ynb.a) obj);
                        return a2;
                    }
                    return invokeL.booleanValue;
                }
            });
            if (aVar == null) {
                return null;
            }
            return this.f.get(aVar.c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <Result> Result a(FunAdInteractionListener funAdInteractionListener, final tnb<Result> tnbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, funAdInteractionListener, tnbVar)) == null) {
            this.h = funAdInteractionListener;
            if (a(new hub() { // from class: com.baidu.tieba.vmb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.hub
                public final Object a(PidLoader pidLoader, String str) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, pidLoader, str)) == null) ? com.fun.t.a(tnb.this, pidLoader, str) : invokeLL2.objValue;
                }
            }) == null) {
                funAdInteractionListener.onAdError(this.e.a);
                this.h = null;
                LogPrinter.e("showFailed for SerialSlotId(%s), because no ready loader found", this.e.a);
            }
            return null;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.lob, com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.m.removeMessages(101, this);
                this.m.removeMessages(100);
                super.destroy();
                this.h = null;
                for (ynb.b bVar : this.e.b) {
                    for (ynb.a aVar : bVar.b) {
                        PidLoader pidLoader = this.f.get(aVar.c);
                        if (pidLoader != null) {
                            pidLoader.destroy();
                        }
                    }
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public ReadyCacheStatistic getCacheStatistic(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? a(this.k, this.j) : (ReadyCacheStatistic) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (ynb.b bVar : this.e.b) {
                    for (ynb.a aVar : bVar.b) {
                        if (aVar != null && (pidLoader = this.f.get(aVar.c)) != null && pidLoader.isLoaded()) {
                            arrayList.add(new CacheStatistic(pidLoader.getAdType(), pidLoader.getPid().pid, pidLoader.getAdCount(), pidLoader.getBiddingOrBasePrices()));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(final Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) a(new hub() { // from class: com.baidu.tieba.zmb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.hub
                public final Object a(PidLoader pidLoader, String str) {
                    InterceptResult invokeLL;
                    FunNativeAd2 nativeAd2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, pidLoader, str)) == null) {
                        nativeAd2 = pidLoader.getNativeAd2(context, str);
                        return nativeAd2;
                    }
                    return invokeLL.objValue;
                }
            });
            if (funNativeAd2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.e.a);
            }
            return funNativeAd2;
        }
        return (FunNativeAd2) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized boolean isReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                Iterator<ynb.b> it = this.e.b.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    for (ynb.a aVar : it.next().b) {
                        PidLoader pidLoader = this.f.get(aVar.c);
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

    @Override // com.baidu.tieba.lob, com.fun.ad.sdk.FunAdLoader
    public void recycleListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.recycleListener();
            this.h = null;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends lob.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context d;
        public FunAdSlot e;
        public Iterator<ynb.b> f;
        public final HashSet<ynb.a> g;
        public final LinkedHashMap<ynb.a, Integer> h;
        public final List<PidLoader> i;
        public boolean j;
        public boolean k;
        public boolean l;
        public double m;
        public boolean n;
        public int o;
        public final /* synthetic */ t p;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485910541, "Lcom/fun/t$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-485910541, "Lcom/fun/t$b;");
                    return;
                }
            }
            t.class.desiredAssertionStatus();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t tVar) {
            super(tVar.e.a, tVar.e.c, "s");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.p = tVar;
            this.g = new HashSet<>();
            this.h = new LinkedHashMap<>();
            this.i = new ArrayList();
            this.j = true;
            this.k = false;
            this.l = false;
            this.m = 0.0d;
            this.o = 0;
        }

        public static /* synthetic */ int a(PidLoader pidLoader, PidLoader pidLoader2) {
            return -Double.compare(pidLoader.getBiddingOrBasePrices(), pidLoader2.getBiddingOrBasePrices());
        }

        public final boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !this.f.hasNext() && this.g.isEmpty() : invokeV.booleanValue;
        }

        /* loaded from: classes9.dex */
        public class a implements tnb<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ViewGroup b;
            public final /* synthetic */ b c;

            public a(b bVar, Activity activity, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, activity, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = activity;
                this.b = viewGroup;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
            @Override // com.baidu.tieba.tnb
            public Boolean a(PidLoader pidLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) {
                    b bVar = this.c;
                    return Boolean.valueOf(pidLoader.show(this.a, this.b, bVar.p.e.a, bVar.a));
                }
                return invokeL.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.tnb
            public boolean a(Boolean bool) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
                    return bool.booleanValue();
                }
                return invokeL.booleanValue;
            }
        }

        /* renamed from: com.fun.t$b$b  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0582b implements tnb<FunSplashAd> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ViewGroup b;
            public final /* synthetic */ b c;

            public C0582b(b bVar, Activity activity, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, activity, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = activity;
                this.b = viewGroup;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.tnb
            public boolean a(FunSplashAd funSplashAd) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
            @Override // com.baidu.tieba.tnb
            public FunSplashAd a(PidLoader pidLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) {
                    b bVar = this.c;
                    return pidLoader.showSplash(this.a, this.b, bVar.p.e.a, bVar.a);
                }
                return invokeL.objValue;
            }
        }

        @Override // com.baidu.tieba.lob.a
        public void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, funAdSlot, funAdLoadListener) == null) {
                this.p.m.removeMessages(100);
                this.p.m.removeMessages(101, this);
                this.d = context;
                this.e = funAdSlot;
                if (this.p.e.b.isEmpty()) {
                    LogPrinter.e("No groups found in SerialSlotId(%s)", this.p.e.a);
                    a("g_empty");
                    return;
                }
                this.f = this.p.e.b.iterator();
                t tVar = this.p;
                if (!tVar.i) {
                    this.j = true;
                } else {
                    this.j = false;
                    long j = 0;
                    synchronized (tVar) {
                        ArrayList arrayList = new ArrayList();
                        for (ynb.a aVar : this.p.l) {
                            long j2 = aVar.d.a;
                            if (j2 > j) {
                                j = j2;
                            }
                            t tVar2 = this.p;
                            tVar2.getClass();
                            PidLoader pidLoader = tVar2.f.get(aVar.c);
                            if (pidLoader != null) {
                                if (pidLoader.isLoaded()) {
                                    pidLoader.destroy(true);
                                }
                                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(pidLoader.getPid().pid, pidLoader.getAdType());
                                if (shouldIntercept == null || !shouldIntercept.shouldInterceptLoad()) {
                                    this.h.put(aVar, 0);
                                    arrayList.add(pidLoader);
                                }
                            }
                        }
                        if (arrayList.isEmpty()) {
                            this.j = true;
                        } else {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((PidLoader) it.next()).load(this.d, this.e, this.a);
                            }
                            this.p.m.sendMessageDelayed(this.p.m.obtainMessage(101, this), j);
                        }
                    }
                }
                h();
            }
        }

        public void a(ynb.a aVar) {
            PidLoader pidLoader;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                synchronized (this.p) {
                    if (!g()) {
                        return;
                    }
                    t tVar = this.p;
                    int i = t.d;
                    tVar.getClass();
                    if (aVar == null) {
                        pidLoader = null;
                    } else {
                        pidLoader = tVar.f.get(aVar.c);
                    }
                    if (pidLoader != null) {
                        this.i.add(pidLoader);
                    }
                    t tVar2 = this.p;
                    if (tVar2.i) {
                        boolean z = aVar.c.isBidding;
                        if (z && !this.j) {
                            tVar2.m.removeMessages(101, this);
                            this.h.put(aVar, 1);
                            if (pidLoader != null) {
                                if (pidLoader.getBiddingOrBasePrices() > this.m) {
                                    this.m = pidLoader.getBiddingOrBasePrices();
                                }
                                LogPrinter.d("bidding ad:" + aVar.c.pid + "load success：", new Object[0]);
                            }
                            this.k = true;
                            if (!this.l && !e()) {
                                return;
                            }
                        } else if (!z) {
                            tVar2.m.removeMessages(100, this);
                            this.l = true;
                            if (!this.k && !this.j) {
                                return;
                            }
                        }
                    }
                    if (!this.g.remove(aVar) && !aVar.c.isBidding) {
                        return;
                    }
                    d();
                    b();
                }
            }
        }

        @Override // com.baidu.tieba.lob.a
        public boolean a(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, funAdInteractionListener)) == null) {
                t tVar = this.p;
                a aVar = new a(this, activity, viewGroup);
                int i = t.d;
                tVar.a(funAdInteractionListener, aVar);
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.tieba.lob.a
        public FunSplashAd b(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, activity, viewGroup, funAdInteractionListener)) == null) {
                t tVar = this.p;
                C0582b c0582b = new C0582b(this, activity, viewGroup);
                int i = t.d;
                tVar.a(funAdInteractionListener, c0582b);
                return null;
            }
            return (FunSplashAd) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.lob.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.c = null;
                synchronized (this.p) {
                    this.j = true;
                    this.p.m.removeMessages(100, this);
                    this.p.m.removeMessages(101, this);
                    this.g.clear();
                }
            }
        }

        public final void d() {
            double d;
            double d2;
            String str;
            double d3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.p.i || this.i.isEmpty()) {
                return;
            }
            PidLoader pidLoader = null;
            Collections.sort(this.i, new Comparator() { // from class: com.baidu.tieba.bnb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? t.b.a((PidLoader) obj, (PidLoader) obj2) : invokeLL.intValue;
                }
            });
            if (this.i.size() >= 1) {
                pidLoader = this.i.get(0);
                d2 = pidLoader.getBiddingOrBasePrices();
                if (this.i.size() >= 2) {
                    d3 = this.i.get(1).getBiddingOrBasePrices();
                } else {
                    d3 = 0.0d;
                }
                if (d3 != 0.0d) {
                    pidLoader.setBiddingResult(pidLoader.getPid().ssp.type, d2, d3, 1);
                }
                d = d3;
            } else {
                d = 0.0d;
                d2 = 0.0d;
            }
            for (Map.Entry<ynb.a, Integer> entry : this.h.entrySet()) {
                entry.getValue().intValue();
                PidLoader pidLoader2 = this.p.f.get(entry.getKey().c);
                if (pidLoader2 != null && pidLoader2 != pidLoader) {
                    if (pidLoader == null) {
                        str = "";
                    } else {
                        str = pidLoader.getPid().ssp.type;
                    }
                    pidLoader2.setBiddingResult(str, d2, d, 2);
                }
            }
        }

        public final void f() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (!this.j) {
                    Iterator<Map.Entry<ynb.a, Integer>> it = this.h.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().getValue().intValue() != -1) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    this.j = z;
                }
                if (this.j) {
                    this.p.m.removeMessages(101, this);
                }
                boolean z2 = this.j;
                if (z2 && this.l) {
                    d();
                    b();
                } else if (z2 && e()) {
                    LogPrinter.d("All loader load failed, callback onError(%s)", this.p.e.a);
                    d();
                    a("af");
                }
            }
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.p.c != this) {
                    return false;
                }
                if (a()) {
                    LogPrinter.d("Give up load by LoadHandler with listener already recycled", new Object[0]);
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public void h() {
            PidLoader pidLoader;
            RCInterceptor shouldIntercept;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                synchronized (this.p) {
                    if (this.n) {
                        this.o++;
                        this.n = false;
                    }
                    if (!g()) {
                        return;
                    }
                    if (e()) {
                        if (this.j) {
                            LogPrinter.d("All loader load failed, callback onError(%s)", this.p.e.a);
                            d();
                            a("af");
                        } else if (this.k) {
                            d();
                            b();
                        }
                    } else if (!this.f.hasNext()) {
                        LogPrinter.d("All loader already started, just wait for the loader callback", new Object[0]);
                    } else {
                        ynb.b next = this.f.next();
                        this.n = true;
                        if (next.b.isEmpty()) {
                            LogPrinter.e("There is an empty group in SerialSid(%s)", this.p.e.a);
                            h();
                            return;
                        }
                        double d = 0.0d;
                        boolean z = true;
                        for (ynb.a aVar : next.b) {
                            Ssp.Pid pid = aVar.c;
                            if (!pid.isBidding) {
                                double a2 = ztb.a(pid.pid) * 1000.0d;
                                if (d < a2) {
                                    d = a2;
                                }
                                z = false;
                            }
                        }
                        if (!z) {
                            double d2 = this.m;
                            if (d2 != 0.0d && d2 > d) {
                                if (!g()) {
                                    return;
                                }
                                d();
                                b();
                                return;
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        for (ynb.a aVar2 : next.b) {
                            Ssp.Pid pid2 = aVar2.c;
                            if (!pid2.isBidding && (pidLoader = this.p.f.get(pid2)) != null && ((shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(pidLoader.getPid().pid, pidLoader.getAdType())) == null || !shouldIntercept.shouldInterceptLoad())) {
                                this.g.add(aVar2);
                                if (pidLoader.isLoaded()) {
                                    a(aVar2);
                                    return;
                                }
                                arrayList.add(pidLoader);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            LogPrinter.e("No group which ready to load found in SerialSid(%s)", this.p.e.a);
                            h();
                            return;
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((PidLoader) it.next()).load(this.d, this.e, this.a);
                        }
                        this.p.m.removeMessages(100, this);
                        this.p.m.sendMessageDelayed(this.p.m.obtainMessage(100, this), next.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t tVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, looper};
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
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 100) {
                    if (i == 101) {
                        b bVar = (b) message.obj;
                        if (bVar == null) {
                            LogPrinter.d("MSG_BIDDING_LOAD_TIMEOUT: give up load without LoadHandler", new Object[0]);
                            return;
                        }
                        bVar.j = true;
                        bVar.f();
                        return;
                    }
                    return;
                }
                b bVar2 = (b) message.obj;
                if (bVar2 == null) {
                    LogPrinter.d("MSG_CONTINUE_LOAD: give up load without LoadHandler", new Object[0]);
                } else {
                    bVar2.h();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements eub {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean a;
        public transient /* synthetic */ FieldHolder $fh;
        public final ynb.a b;
        public final PidLoader c;
        public final /* synthetic */ t d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-485910510, "Lcom/fun/t$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-485910510, "Lcom/fun/t$c;");
                    return;
                }
            }
            a = !t.class.desiredAssertionStatus();
        }

        public c(t tVar, ynb.a aVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, aVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.d = tVar;
            this.b = aVar;
            this.c = pidLoader;
        }

        @Override // com.baidu.tieba.eub
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.baidu.tieba.eub
        public void a() {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = (b) this.d.c) != null) {
                bVar.a(this.b);
            }
        }

        @Override // com.baidu.tieba.eub
        public void a(int i, String str) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (bVar = (b) this.d.c) != null) {
                ynb.a aVar = this.b;
                synchronized (bVar.p) {
                    if (bVar.g()) {
                        if (aVar.c.isBidding) {
                            if (bVar.h.containsKey(aVar)) {
                                bVar.h.put(aVar, -1);
                                bVar.f();
                            }
                        } else if (bVar.g.remove(aVar)) {
                            if (bVar.e()) {
                                if (bVar.k) {
                                    bVar.d();
                                    bVar.b();
                                } else if (bVar.j) {
                                    bVar.d();
                                    LogPrinter.d("All loader load failed, callback onError(%s)", bVar.p.e.a);
                                    bVar.a("af");
                                }
                            } else if (bVar.g.isEmpty()) {
                                bVar.p.m.removeMessages(100, bVar);
                                bVar.p.m.obtainMessage(100, bVar).sendToTarget();
                            }
                        }
                    }
                }
                IAdForbidStrategyManager iAdForbidStrategyManager = Flavors.STRATEGY_MANAGER;
                Ssp.Pid pid = this.b.c;
                iAdForbidStrategyManager.setErrInfo(pid.ssp.type, pid.pid, i, str);
            }
        }

        @Override // com.baidu.tieba.eub
        public void a(RippedAd rippedAd, Map<String, String> map) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rippedAd, map) == null) && (funAdInteractionListener = this.d.h) != null) {
                if (!a && this.b.c == null) {
                    throw new AssertionError();
                }
                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.b.c.pid, this.c.getAdType());
                if (shouldIntercept != null) {
                    shouldIntercept.onAdClick(rippedAd);
                }
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = this.d.e.a;
                Ssp.Pid pid = this.b.c;
                callBackAware.onAdClicked(funAdInteractionListener, str, pid.ssp.type, pid.pid, rippedAd, map);
            }
        }

        @Override // com.baidu.tieba.eub
        public void b(RippedAd rippedAd, Map<String, String> map) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, map) == null) && (funAdInteractionListener = this.d.h) != null) {
                if (!a && this.b.c == null) {
                    throw new AssertionError();
                }
                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.b.c.pid, this.c.getAdType());
                if (shouldIntercept != null) {
                    shouldIntercept.onAdShow(rippedAd);
                }
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = this.d.e.a;
                Ssp.Pid pid = this.b.c;
                callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, rippedAd, map);
            }
        }

        @Override // com.baidu.tieba.eub
        public void a(Map<String, String> map) {
            t tVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, map) == null) && (funAdInteractionListener = (tVar = this.d).h) != null) {
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = tVar.e.a;
                Ssp.Pid pid = this.b.c;
                callBackAware.onAdClose(funAdInteractionListener, str, pid.ssp.type, pid.pid, map);
            }
        }

        @Override // com.baidu.tieba.eub
        public void a(boolean z, int i, Map<String, String> map) {
            t tVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), map}) == null) && (funAdInteractionListener = (tVar = this.d).h) != null) {
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = tVar.e.a;
                Ssp.Pid pid = this.b.c;
                callBackAware.onRewardedVideo(funAdInteractionListener, str, z, pid.ssp.type, i, pid.pid, map);
            }
        }

        @Override // com.baidu.tieba.eub
        public void b(int i, String str) {
            t tVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) && (funAdInteractionListener = (tVar = this.d).h) != null) {
                funAdInteractionListener.onAdError(tVar.e.a);
            }
        }
    }

    public final <N> N a(hub<N> hubVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hubVar)) == null) {
            if (this.i) {
                return (N) a(this.k, this.j, hubVar, this.e.a);
            }
            for (ynb.b bVar : this.e.b) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader a2 = a(bVar, arrayList);
                    if (a2 != null) {
                        N a3 = hubVar.a(a2, this.e.a);
                        if (a3 == null) {
                            arrayList.add(a2);
                        } else {
                            return a3;
                        }
                    }
                }
            }
            return null;
        }
        return (N) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lob
    public void a(String str) {
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            for (ynb.a aVar : this.l) {
                if (!aVar.c.pid.equals(str) && (pidLoader = this.f.get(aVar.c)) != null && pidLoader.isLoaded()) {
                    LogPrinter.d("destroy bid : %s ", aVar.c.pid);
                    pidLoader.destroy(true);
                }
            }
        }
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.lob$a' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.lob$a, com.fun.t$b] */
    @Override // com.baidu.tieba.lob
    public b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new b(this);
        }
        return (lob.a) invokeV.objValue;
    }
}
