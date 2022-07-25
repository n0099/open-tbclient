package com.sdk.o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.o.f;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.o.a";
    public static final Boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592899223, "Lcom/sdk/o/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592899223, "Lcom/sdk/o/a;");
                return;
            }
        }
        b = Boolean.valueOf(com.sdk.f.g.b);
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/content/Context;Ljava/util/ArrayList<Ljava/lang/String;>;Z)Lcom/sdk/o/f$a; */
    public static f.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            f.a aVar = f.a.c;
            if (context == null) {
                return aVar;
            }
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    if ("MOBILE".equalsIgnoreCase(typeName)) {
                        aVar = f.a.b;
                    } else if ("WIFI".equalsIgnoreCase(typeName)) {
                        aVar = f.a.a;
                    }
                }
            } catch (Throwable th) {
                com.sdk.n.a.a(a, th.getMessage(), b);
            }
            return aVar;
        }
        return (f.a) invokeL.objValue;
    }
}
