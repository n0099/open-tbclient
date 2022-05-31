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
import com.repackage.az3;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class t04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile t04 c;
    public transient /* synthetic */ FieldHolder $fh;
    public az3 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755344583, "Lcom/repackage/t04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755344583, "Lcom/repackage/t04;");
                return;
            }
        }
        b = rf1.a;
    }

    public t04() {
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

    public static t04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (t04.class) {
                    if (c == null) {
                        c = new t04();
                    }
                }
            }
            return c;
        }
        return (t04) invokeV.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        az3 az3Var;
        az3.c cVar;
        HashMap<String, String> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2) || (az3Var = this.a) == null || (cVar = az3Var.d) == null || (hashMap = cVar.a) == null) {
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
        az3 az3Var;
        az3.b bVar;
        List<az3.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (!TextUtils.isEmpty(str) && (az3Var = this.a) != null && (bVar = az3Var.c) != null && (list = bVar.a) != null) {
                for (az3.a aVar : list) {
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
        az3.b bVar;
        HashMap<String, Boolean> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            String c2 = c(str, 1);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            az3 az3Var = this.a;
            if (az3Var != null && (bVar = az3Var.c) != null && (hashMap = bVar.b) != null && hashMap.containsKey(c2)) {
                if (b) {
                    Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
                }
                return this.a.c.b.get(c2).booleanValue();
            }
            if (b) {
                Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
            }
            String f0 = hz2.f0();
            if (hz2.L() == null) {
                return false;
            }
            String j0 = hz2.L().j0();
            if (TextUtils.isEmpty(f0) || TextUtils.isEmpty(j0)) {
                return false;
            }
            boolean n = c74.i().n(f0, j0, c2);
            if (n) {
                f(c2, true);
            }
            return n;
        }
        return invokeL.booleanValue;
    }

    public void e(az3 az3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, az3Var) == null) {
            this.a = az3Var;
        }
    }

    public void f(String str, boolean z) {
        az3 az3Var;
        az3.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, str, z) == null) || TextUtils.isEmpty(str) || (az3Var = this.a) == null || (bVar = az3Var.c) == null || bVar.b == null) {
            return;
        }
        if (b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.a.c.b.put(str, Boolean.valueOf(z));
    }
}
