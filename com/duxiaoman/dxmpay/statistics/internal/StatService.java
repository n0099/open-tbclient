package com.duxiaoman.dxmpay.statistics.internal;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.d.a.a.a.e;
import com.alipay.sdk.widget.d;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class StatService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<String, Long> a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class ETag {
        public static final /* synthetic */ ETag[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ETag back;
        public static final ETag in;
        public static final ETag out;
        public static final ETag push;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(62356316, "Lcom/duxiaoman/dxmpay/statistics/internal/StatService$ETag;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(62356316, "Lcom/duxiaoman/dxmpay/statistics/internal/StatService$ETag;");
                    return;
                }
            }
            in = new ETag("in", 0);
            out = new ETag("out", 1);
            push = new ETag("push", 2);
            ETag eTag = new ETag(d.u, 3);
            back = eTag;
            $VALUES = new ETag[]{in, out, push, eTag};
        }

        public ETag(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ETag valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ETag) Enum.valueOf(ETag.class, str) : (ETag) invokeL.objValue;
        }

        public static ETag[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ETag[]) $VALUES.clone() : (ETag[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static StatService a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-157719004, "Lcom/duxiaoman/dxmpay/statistics/internal/StatService$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-157719004, "Lcom/duxiaoman/dxmpay/statistics/internal/StatService$a;");
                    return;
                }
            }
            a = new StatService(null);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ StatService(b bVar) {
        this();
    }

    public static StatService a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (StatService) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a().a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static synchronized void c(String str, ETag eTag, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, eTag, collection) == null) {
            synchronized (StatService.class) {
                if (eTag != null) {
                    f(str, eTag.name(), collection, null);
                }
            }
        }
    }

    public static void d(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        e.a().c(str, null, str2, str3, System.currentTimeMillis());
    }

    public static void e(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, str, str2, str3, str4) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, "");
            long i2 = i(str);
            if (i2 > 0) {
                arrayList.add(Long.toString(i2));
                hashMap.put("duration", Long.valueOf(i2));
            }
            arrayList.add(str2);
            if (str3 != null) {
                arrayList.add(str3);
            }
            g(str, null, arrayList, hashMap, str4);
        }
    }

    public static void f(String str, String str2, Collection<String> collection, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65543, null, str, str2, collection, str3) == null) {
            g(str, str2, collection, null, str3);
        }
    }

    public static void g(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65544, null, str, str2, collection, map, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        e.a().d(str, str2, collection, map, str3, System.currentTimeMillis());
    }

    public static void h(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, str, collection, map, str2) == null) {
            ArrayList arrayList = new ArrayList();
            long i2 = i(str);
            if (i2 > 0) {
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("duration", Long.valueOf(i2));
            }
            if (collection != null) {
                arrayList.addAll(collection);
            }
            g(str, null, arrayList, map, str2);
        }
    }

    public static long i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            Long l = a().a.get(str);
            if (l == null) {
                return -1L;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
            a().a.remove(str);
            return valueOf.longValue();
        }
        return invokeL.longValue;
    }

    public static void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            long i2 = i(str);
            if (i2 > 0) {
                hashMap.put("duration", Long.valueOf(i2));
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            g(str, null, arrayList, hashMap, str3);
        }
    }

    public static void k(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, null, str, str2, collection, map, str3) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, "");
            long i2 = i(str);
            if (i2 > 0) {
                arrayList.add(Long.toString(i2));
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("duration", Long.valueOf(i2));
            }
            arrayList.add(str2);
            if (collection != null) {
                arrayList.addAll(collection);
            }
            g(str, null, arrayList, map, str3);
        }
    }

    public StatService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap<>();
    }
}
