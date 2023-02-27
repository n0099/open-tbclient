package com.sdk.u;

import android.content.Context;
import android.net.ConnectivityManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.f.f;
import com.sdk.q.b;
import java.util.TreeMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static Boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592720477, "Lcom/sdk/u/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592720477, "Lcom/sdk/u/a;");
                return;
            }
        }
        new TreeMap();
        a = a.class.getSimpleName();
        b = Boolean.valueOf(f.a);
    }

    public a() {
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

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            try {
                return new JSONObject(str).optLong("exp") < System.currentTimeMillis();
            } catch (Exception e) {
                String str2 = a;
                com.sdk.o.a.c(str2, "out data error" + e, b);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString2 = jSONObject.optString("aesKey");
                String optString3 = jSONObject.optString("data");
                String optString4 = jSONObject.optString("sign");
                if (com.sdk.v.a.d == 0) {
                    optString = b.a(optString2, com.sdk.v.a.b);
                } else {
                    optString = jSONObject.optString("key");
                    com.sdk.r.f a2 = com.sdk.r.f.a();
                    String a3 = a2.b.a(a2.c, optString, optString, optString4);
                    if (com.sdk.o.a.a(a3).booleanValue() && !Boolean.parseBoolean(a3)) {
                        return null;
                    }
                }
                return com.sdk.r.f.a().b.b(optString, optString3);
            } catch (Throwable th) {
                com.sdk.o.b.b(th.toString());
                String str2 = a;
                com.sdk.o.a.a(str2, "SDK解密异常：" + th.toString(), b);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context) {
        ConnectivityManager.NetworkCallback networkCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            com.sdk.a.b bVar = new com.sdk.a.b();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getApplicationContext().getSystemService("connectivity");
            bVar.g = connectivityManager;
            if (connectivityManager != null && (networkCallback = com.sdk.a.b.e) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
                com.sdk.a.b.d = true;
                com.sdk.a.b.e = null;
            }
        }
    }
}
