package com.kwad.sdk.contentalliance.home;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f35002a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<Long, List<AdTemplate>> f35003b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-113361264, "Lcom/kwad/sdk/contentalliance/home/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-113361264, "Lcom/kwad/sdk/contentalliance/home/a;");
                return;
            }
        }
        f35002a = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f35003b = new HashMap();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f35002a : (a) invokeV.objValue;
    }

    public static boolean a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) ? com.kwad.sdk.core.response.b.c.b(adTemplate) && adTemplate.mPreloadData.isPreload && SystemClock.elapsedRealtime() - adTemplate.mPreloadData.mCacheTime < com.kwad.sdk.core.response.b.d.G(com.kwad.sdk.core.response.b.c.k(adTemplate)) - AppConfig.TIMESTAMP_AVAILABLE_DURATION : invokeL.booleanValue;
    }

    public synchronized List<AdTemplate> a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            synchronized (this) {
                List<AdTemplate> list = this.f35003b != null ? this.f35003b.get(Long.valueOf(j)) : null;
                if (list != null) {
                    ArrayList arrayList = new ArrayList(list);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (!a((AdTemplate) it.next())) {
                            it.remove();
                        }
                    }
                    return arrayList;
                }
                return null;
            }
        }
        return (List) invokeJ.objValue;
    }

    public synchronized void a(@NonNull List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ContentDataMemCache", "save()");
                HashMap hashMap = new HashMap();
                for (AdTemplate adTemplate : list) {
                    List list2 = (List) hashMap.get(Long.valueOf(adTemplate.posId));
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(Long.valueOf(adTemplate.posId), list2);
                    }
                    KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.c.m(adTemplate).a(), adTemplate);
                    adTemplate.mPreloadData.mCacheTime = SystemClock.elapsedRealtime();
                    adTemplate.mPreloadData.isPreload = true;
                    list2.add(adTemplate);
                    com.kwad.sdk.core.d.a.a("ContentDataMemCache", "preload save posId=" + adTemplate.posId);
                }
                this.f35003b = hashMap;
            }
        }
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ContentDataMemCache", "clearAll()");
                if (this.f35003b != null) {
                    this.f35003b.clear();
                }
            }
        }
    }

    public synchronized void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            synchronized (this) {
                com.kwad.sdk.core.d.a.a("ContentDataMemCache", "clear() posId=" + j);
                if (this.f35003b != null && this.f35003b.containsKey(Long.valueOf(j))) {
                    List<AdTemplate> list = this.f35003b.get(Long.valueOf(j));
                    if (list != null) {
                        list.clear();
                    }
                    this.f35003b.remove(Long.valueOf(j));
                }
            }
        }
    }

    public synchronized boolean c(long j) {
        InterceptResult invokeJ;
        boolean isEmpty;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            synchronized (this) {
                List<AdTemplate> list = this.f35003b != null ? this.f35003b.get(Long.valueOf(j)) : null;
                isEmpty = list == null ? true : list.isEmpty();
            }
            return isEmpty;
        }
        return invokeJ.booleanValue;
    }
}
