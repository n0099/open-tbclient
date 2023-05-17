package com.sdk.p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sdk.p.f;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.p.a";
    public static final Boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592869432, "Lcom/sdk/p/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592869432, "Lcom/sdk/p/a;");
                return;
            }
        }
        b = Boolean.valueOf(com.sdk.f.f.a);
    }

    /* JADX DEBUG: Incorrect args count in method signature: (Landroid/content/Context;Ljava/util/ArrayList<Ljava/lang/String;>;Z)Lcom/sdk/p/f$a; */
    public static f.a a(Context context) {
        InterceptResult invokeL;
        f.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            f.a aVar2 = f.a.c;
            if (context == null) {
                return aVar2;
            }
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return aVar2;
                }
                String typeName = activeNetworkInfo.getTypeName();
                if ("MOBILE".equalsIgnoreCase(typeName)) {
                    aVar = f.a.b;
                } else if (!"WIFI".equalsIgnoreCase(typeName)) {
                    return aVar2;
                } else {
                    aVar = f.a.a;
                }
                return aVar;
            } catch (Throwable th) {
                com.sdk.o.a.a(a, th.getMessage(), b);
                return aVar2;
            }
        }
        return (f.a) invokeL.objValue;
    }
}
