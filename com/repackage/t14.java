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
import com.repackage.a04;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class t14 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile t14 c;
    public transient /* synthetic */ FieldHolder $fh;
    public a04 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755343622, "Lcom/repackage/t14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755343622, "Lcom/repackage/t14;");
                return;
            }
        }
        b = rg1.a;
    }

    public t14() {
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

    public static t14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (t14.class) {
                    if (c == null) {
                        c = new t14();
                    }
                }
            }
            return c;
        }
        return (t14) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        a04 a04Var;
        a04.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (a04Var = this.a) == null || (cVar = a04Var.d) == null || (hashMap = cVar.a) == null) {
                return null;
            }
            return hashMap.get(c2);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i) {
        InterceptResult invokeLI;
        a04 a04Var;
        a04.b bVar;
        List<a04.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str) && (a04Var = this.a) != null && (bVar = a04Var.c) != null && (list = bVar.a) != null) {
                for (a04.a aVar : list) {
                    if (TextUtils.equals(aVar.a, str) || TextUtils.equals(aVar.b, str)) {
                        if (i != 0) {
                            if (i != 1) {
                                if (i != 2) {
                                    if (i != 3) {
                                        return aVar.b;
                                    }
                                    return aVar.d;
                                }
                                return aVar.c;
                            }
                            return aVar.b;
                        }
                        return aVar.a;
                    }
                    while (r0.hasNext()) {
                    }
                }
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        a04.b bVar;
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            a04 a04Var = this.a;
            if (a04Var != null && (bVar = a04Var.c) != null && (hashMap = bVar.b) != null && hashMap.containsKey(c2)) {
                if (b) {
                    Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
                }
                return this.a.c.b.get(c2).booleanValue();
            }
            if (b) {
                Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
            }
            String g0 = h03.g0();
            if (h03.M() == null) {
                return false;
            }
            String k0 = h03.M().k0();
            if (TextUtils.isEmpty(g0) || TextUtils.isEmpty(k0)) {
                return false;
            }
            boolean n = c84.i().n(g0, k0, c2);
            if (n) {
                f(c2, true);
            }
            return n;
        }
        return invokeL.booleanValue;
    }

    public void e(a04 a04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, a04Var) == null) {
            this.a = a04Var;
        }
    }

    public void f(String str, boolean z) {
        a04 a04Var;
        a04.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (a04Var = this.a) == null || (bVar = a04Var.c) == null || bVar.b == null) {
            return;
        }
        if (b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.a.c.b.put(str, Boolean.valueOf(z));
    }
}
