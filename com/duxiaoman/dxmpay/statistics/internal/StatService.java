package com.duxiaoman.dxmpay.statistics.internal;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.widget.j;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.d.a.a.b.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class StatService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f32680a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
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
            ETag eTag = new ETag(j.j, 3);
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

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static StatService f32681a;
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
            f32681a = new StatService(null);
        }
    }

    /* loaded from: classes5.dex */
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f32681a : (StatService) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            a().f32680a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        i.a().c(str, null, str2, str3, System.currentTimeMillis());
    }

    public static void d(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, str3, str4) == null) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, "");
            long f2 = f(str);
            if (f2 > 0) {
                arrayList.add(Long.toString(f2));
                hashMap.put("duration", Long.valueOf(f2));
            }
            arrayList.add(str2);
            if (str3 != null) {
                arrayList.add(str3);
            }
            e(str, null, arrayList, hashMap, str4);
        }
    }

    public static void e(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, collection, map, str3) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        i.a().d(str, str2, collection, map, str3, System.currentTimeMillis());
    }

    public static long f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            Long l = a().f32680a.get(str);
            if (l == null) {
                return -1L;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis() - l.longValue());
            a().f32680a.remove(str);
            return valueOf.longValue();
        }
        return invokeL.longValue;
    }

    public static void g(String str, String str2, Collection<String> collection, Map<String, Object> map, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65544, null, str, str2, collection, map, str3) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, "");
            long f2 = f(str);
            if (f2 > 0) {
                arrayList.add(Long.toString(f2));
                if (map == null) {
                    map = new HashMap<>();
                }
                map.put("duration", Long.valueOf(f2));
            }
            arrayList.add(str2);
            if (collection != null) {
                arrayList.addAll(collection);
            }
            e(str, null, arrayList, map, str3);
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
        this.f32680a = new ConcurrentHashMap<>();
    }
}
