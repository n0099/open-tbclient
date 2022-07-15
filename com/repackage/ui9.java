package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.GuardedBy;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CacheStatistic;
import com.fun.ad.sdk.FunAdFactory;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdLoader;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class ui9 implements FunAdFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, LinkedHashMap<kd9, FunAdLoader>> a;
    public final Object b;
    @GuardedBy("mInitializeLock")
    public final LinkedList<a> c;
    @GuardedBy("mInitializeLock")
    public int d;
    @GuardedBy("mInitializeLock")
    public vc9 e;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public final FunAdSlot b;
        public final FunAdLoadListener c;

        public a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, funAdSlot, funAdLoadListener};
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
            this.b = funAdSlot;
            this.c = funAdLoadListener;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755259860, "Lcom/repackage/ui9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755259860, "Lcom/repackage/ui9;");
                return;
            }
        }
        f = !ui9.class.desiredAssertionStatus();
    }

    public ui9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new Object();
        this.c = new LinkedList<>();
        this.d = 0;
    }

    public final List<FunAdLoader> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.a) {
                kd9 b = bd9.b(str);
                if (b == null) {
                    return null;
                }
                LinkedHashMap<kd9, FunAdLoader> linkedHashMap = this.a.get(str);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                    this.a.put(str, linkedHashMap);
                }
                if (linkedHashMap.get(b) == null) {
                    linkedHashMap.put(b, b.a.a(this.e));
                }
                ArrayList arrayList = new ArrayList(linkedHashMap.values());
                Collections.reverse(arrayList);
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void destroyAd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this.b) {
                this.c.clear();
            }
            synchronized (this.a) {
                kd9 b = bd9.b(str);
                if (b == null) {
                    LogPrinter.e("No SlotId found for sid:%s when destroyAd", str);
                    return;
                }
                LinkedHashMap<kd9, FunAdLoader> linkedHashMap = this.a.get(str);
                if (linkedHashMap == null) {
                    LogPrinter.e("No slotIdLoaderMap found for sid:%s when destroyAd", str);
                    return;
                }
                HashSet hashSet = new HashSet();
                for (Map.Entry<kd9, FunAdLoader> entry : linkedHashMap.entrySet()) {
                    kd9 key = entry.getKey();
                    entry.getValue().destroy();
                    if (!b.equals(key)) {
                        LogPrinter.d("Remove redundant loader for sid:%s", str);
                        hashSet.add(key);
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    linkedHashMap.remove((kd9) it.next());
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 != null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                for (FunAdLoader funAdLoader : a2) {
                    List<CacheStatistic> cacheStatistics = funAdLoader.getCacheStatistics(str);
                    if (!cacheStatistics.isEmpty()) {
                        return cacheStatistics;
                    }
                }
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunNativeAd2 getNativeAd2(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                return null;
            }
            for (FunAdLoader funAdLoader : a2) {
                FunNativeAd2 nativeAd2 = funAdLoader.getNativeAd2(context);
                if (nativeAd2 != null) {
                    return nativeAd2;
                }
            }
            return null;
        }
        return (FunNativeAd2) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public boolean isAdReady(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                return false;
            }
            for (FunAdLoader funAdLoader : a2) {
                if (funAdLoader.isReady()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void loadAd(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, context, funAdSlot, funAdLoadListener) == null) {
            synchronized (this.b) {
                i = this.d;
            }
            if (i == -1) {
                LogPrinter.e("loadAd err because of AdSdks initialized failed", new Object[0]);
                funAdLoadListener.onError(funAdSlot.getSid());
            } else if (i == 0) {
                synchronized (this.b) {
                    this.c.add(new a(context, funAdSlot, funAdLoadListener));
                }
            } else if (i != 1) {
                throw new RuntimeException("Unknown st:" + i);
            } else {
                List<FunAdLoader> a2 = a(funAdSlot.getSid());
                if (a2 == null) {
                    LogPrinter.d("No Loader found for sid:%s", funAdSlot.getSid());
                    funAdLoadListener.onError(funAdSlot.getSid());
                    return;
                }
                Iterator<FunAdLoader> it = a2.iterator();
                FunAdLoader next = it.next();
                while (it.hasNext()) {
                    it.next().recycleListener();
                }
                next.load(context, funAdSlot, funAdLoadListener);
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public void showAd(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, activity, viewGroup, str, funAdInteractionListener) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                funAdInteractionListener.onAdError(str);
                return;
            }
            Iterator<FunAdLoader> it = a2.iterator();
            while (it.hasNext()) {
                FunAdLoader next = it.next();
                if (!it.hasNext()) {
                    next.show(activity, viewGroup, str, funAdInteractionListener);
                    return;
                } else if (next.isReady()) {
                    next.show(activity, viewGroup, str, funAdInteractionListener);
                    return;
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdFactory
    public FunSplashAd showSplash(Activity activity, ViewGroup viewGroup, String str, FunAdInteractionListener funAdInteractionListener) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, activity, viewGroup, str, funAdInteractionListener)) == null) {
            List<FunAdLoader> a2 = a(str);
            if (a2 == null) {
                LogPrinter.d("No Loader found for sid:%s", str);
                funAdInteractionListener.onAdError(str);
                return null;
            }
            for (FunAdLoader funAdLoader : a2) {
                FunSplashAd showSplash = funAdLoader.showSplash(activity, viewGroup, str, funAdInteractionListener);
                if (showSplash != null) {
                    return showSplash;
                }
            }
            return null;
        }
        return (FunSplashAd) invokeLLLL.objValue;
    }
}
