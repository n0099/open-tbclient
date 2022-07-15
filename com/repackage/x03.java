package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.z03;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class x03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public z03.d a;
    public z03.d b;
    public Map<String, z03.d> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755225450, "Lcom/repackage/x03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755225450, "Lcom/repackage/x03;");
                return;
            }
        }
        d = rg1.a;
    }

    public x03() {
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
        this.c = new ConcurrentHashMap();
    }

    public static boolean a(z03.d dVar, String str) {
        InterceptResult invokeLL;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dVar, str)) == null) {
            if ((dVar == null || (list = dVar.b) == null || list.isEmpty()) ? false : true) {
                File file = new File(str);
                if (file.exists() && file.lastModified() == dVar.c) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? z03.d() : (List) invokeV.objValue;
    }

    public z03.d c(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z)) == null) {
            z03.d dVar = this.c.get(str2);
            if (a(dVar, z03.i(str))) {
                hx1.k("SwanAppWebSafe", "read from cache: serverDomains.data=" + dVar.b);
                return dVar;
            }
            if (dVar != null) {
                dVar.c();
            } else {
                dVar = new z03.d();
            }
            z03.h(z, str, str2, dVar);
            this.c.put(str2, dVar);
            return dVar;
        }
        return (z03.d) invokeLLZ.objValue;
    }

    public List<String> d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (a(this.b, z03.j())) {
                hx1.k("SwanAppWebSafe", "read from cache: webActions.data=" + this.b.b);
                return this.b.b;
            }
            z03.d dVar = this.b;
            if (dVar != null) {
                dVar.c();
            } else {
                this.b = new z03.d();
            }
            z03.k(z, this.b);
            return this.b.b;
        }
        return (List) invokeZ.objValue;
    }

    public List<String> e(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (a(this.a, z03.m(str))) {
                hx1.k("SwanAppWebSafe", "read from cache: webDomains.data=" + this.a.b);
                return this.a.b;
            }
            z03.d dVar = this.a;
            if (dVar != null) {
                dVar.c();
            } else {
                this.a = new z03.d();
            }
            z03.l(z, str, this.a);
            return this.a.b;
        }
        return (List) invokeLZ.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                if (d) {
                    throw new RuntimeException("appId can not be empty");
                }
                return;
            }
            d(true);
            e(str, true);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            z03.d dVar = this.a;
            if (dVar != null) {
                dVar.c();
                this.a = null;
            }
            z03.d dVar2 = this.b;
            if (dVar2 != null) {
                dVar2.c();
                this.b = null;
            }
            hx1.k("SwanAppWebSafe", "release cache done");
        }
    }
}
