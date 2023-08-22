package com.huawei.hms.hatool;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.hwb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
/* loaded from: classes10.dex */
public class d1 extends v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(81966946, "Lcom/huawei/hms/hatool/d1$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(81966946, "Lcom/huawei/hms/hatool/d1$a;");
                    return;
                }
            }
            int[] iArr = new int[y0.values().length];
            a = iArr;
            try {
                iArr[y0.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[y0.a.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[y0.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static e1 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            e1 a2 = v.a(str, str2);
            x0 c = z0.a().c(str, str2);
            a2.g(z0.a().a(c.c(str, str2)));
            a2.f(c.o(str, str2));
            a2.c(z0.a().f(str, str2));
            int i = a.a[c.a().ordinal()];
            if (i == 1) {
                a2.d(c.b());
            } else if (i == 2) {
                a2.b(c.b());
            } else if (i == 3) {
                a2.e(c.b());
            }
            return a2;
        }
        return (e1) invokeLL.objValue;
    }

    public static f1 a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, str2, str3, str4)) == null) {
            f1 a2 = v.a(str, str2, str3, str4);
            String a3 = z0.a().a(c.c(str2, str3));
            long currentTimeMillis = System.currentTimeMillis();
            String b = hwb.b(b.f() + a3 + currentTimeMillis);
            a2.f(String.valueOf(currentTimeMillis));
            a2.g(b);
            return a2;
        }
        return (f1) invokeLLLL.objValue;
    }

    public static g1 a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            g1 a2 = v.a(str, str2, str3);
            Pair<String, String> e = z0.a().e(str2, str);
            a2.f((String) e.first);
            a2.g((String) e.second);
            a2.h(f.b());
            a2.d(z0.a().d(str2, str));
            return a2;
        }
        return (g1) invokeLLL.objValue;
    }

    public static r a(List<q> list, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, list, str, str2, str3, str4)) == null) {
            y.c("hmsSdk", "generate UploadData");
            r b = v.b(str, str2);
            if (b == null) {
                return null;
            }
            b.a(a(x.d().a(), str, str2, str3));
            b.a(a(str, str2));
            b.a(a(str2, str, str4));
            b.a(c.g(str, str2));
            b.a(list);
            return b;
        }
        return (r) invokeLLLLL.objValue;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3)) == null) {
            Map<String, String> c = v.c(str, str3);
            Map<String, String> i = c.i(str, str2);
            if (i == null) {
                return c;
            }
            c.putAll(i);
            return c;
        }
        return (Map) invokeLLL.objValue;
    }
}
