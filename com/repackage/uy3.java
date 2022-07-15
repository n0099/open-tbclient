package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ww3;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes7.dex */
public class uy3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile uy3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, my3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755244670, "Lcom/repackage/uy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755244670, "Lcom/repackage/uy3;");
                return;
            }
        }
        b = rg1.a;
    }

    public uy3() {
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
        this.a = new HashMap<>();
    }

    public static void a(r72 r72Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, r72Var, str) == null) || r72Var == null || r72Var.z() == null || TextUtils.isEmpty(str)) {
            return;
        }
        r72Var.z().b(str);
    }

    public static uy3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (uy3.class) {
                    if (c == null) {
                        c = new uy3();
                    }
                }
            }
            return c;
        }
        return (uy3) invokeV.objValue;
    }

    public final String c(String str, int i) {
        InterceptResult invokeLI;
        HttpUrl parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
                return null;
            }
            return parse.url().toString() + i;
        }
        return (String) invokeLI.objValue;
    }

    public synchronized my3 d(r72 r72Var, os1 os1Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r72Var, os1Var, i)) == null) {
            synchronized (this) {
                if (os1Var == null) {
                    return null;
                }
                String B = os1Var.B("url");
                String c2 = c(B, i);
                if (TextUtils.isEmpty(c2)) {
                    return null;
                }
                my3 remove = this.a.remove(c2);
                if (remove != null) {
                    a(r72Var, "preload used, url = " + B);
                }
                if (b) {
                    Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + B + ";task:" + remove);
                }
                return remove;
            }
        }
        return (my3) invokeLLI.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a.clear();
            }
        }
    }

    public void f(r72 r72Var, ww3.c cVar) {
        a04 a04Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, r72Var, cVar) == null) || r72Var == null || cVar == null || (a04Var = cVar.c) == null || a04Var.g == null) {
            return;
        }
        e();
        oj2.g0().getSwitch("swan_game_resource_preload", 0);
    }
}
