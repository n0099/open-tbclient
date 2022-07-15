package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes6.dex */
public class gr3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile HashMap<String, List<zr3>> a;

    public gr3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }

    public synchronized void a(String str, zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, zr3Var) == null) {
            synchronized (this) {
                if (e(str, zr3Var)) {
                    return;
                }
                List<zr3> c = c(str);
                if (!c.contains(zr3Var)) {
                    c.add(zr3Var);
                }
                if (!this.a.containsKey(str)) {
                    this.a.put(str, c);
                }
            }
        }
    }

    public synchronized void b(String str, bs3 bs3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bs3Var) == null) {
            synchronized (this) {
                for (zr3 zr3Var : new ArrayList(c(str))) {
                    if (zr3Var != null) {
                        zr3Var.a(bs3Var);
                    }
                }
            }
        }
    }

    public final List<zr3> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            List<zr3> list = this.a.get(str);
            return list == null ? new ArrayList() : list;
        }
        return (List) invokeL.objValue;
    }

    public synchronized boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                List<zr3> list = this.a.get(str);
                if (list != null) {
                    if (!list.isEmpty()) {
                        z = true;
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean e(String str, zr3 zr3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, zr3Var)) == null) ? TextUtils.isEmpty(str) || zr3Var == null : invokeLL.booleanValue;
    }

    public synchronized void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                g(str, null);
            }
        }
    }

    public synchronized void g(String str, zr3 zr3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, zr3Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (zr3Var == null) {
                    this.a.remove(str);
                    return;
                }
                List<zr3> c = c(str);
                if (c.contains(zr3Var)) {
                    c.remove(zr3Var);
                    if (c.isEmpty()) {
                        this.a.remove(str);
                    }
                }
            }
        }
    }
}
