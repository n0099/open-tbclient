package com.sdk.n;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.f.b;
import com.sdk.q.d;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static com.sdk.f.b a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1592928983, "Lcom/sdk/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1592928983, "Lcom/sdk/n/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static com.sdk.f.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                b();
            }
            return a;
        }
        return (com.sdk.f.b) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            a = new com.sdk.f.b();
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, str) == null) && a.b(str).booleanValue() && a.a(a.c).booleanValue()) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("sequenceNumber");
            String queryParameter2 = parse.getQueryParameter("ret_url");
            if (a.b(queryParameter2).booleanValue()) {
                queryParameter = Uri.parse(d.a(queryParameter2)).getQueryParameter("seq");
            }
            a.c = queryParameter;
        }
    }

    public static void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, j) == null) {
            try {
                a(str);
                List list = a.b.a;
                b.a.C0646a c0646a = new b.a.C0646a();
                c0646a.a = str;
                c0646a.b = j;
                list.add(c0646a);
                a.b.a = list;
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            try {
                List list = a.b.b;
                list.add(str);
                a.b.b = list;
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            try {
                List list = a.b.c;
                list.add(str);
                a.b.c = list;
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            try {
                a.b.d = str;
            } catch (Throwable unused) {
            }
        }
    }
}
