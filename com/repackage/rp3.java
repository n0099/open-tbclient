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
/* loaded from: classes7.dex */
public class rp3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile HashMap<String, List<zp3>> a;

    public rp3() {
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

    public synchronized void a(String str, zp3 zp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, zp3Var) == null) {
            synchronized (this) {
                if (e(str, zp3Var)) {
                    return;
                }
                List<zp3> c = c(str);
                if (!c.contains(zp3Var)) {
                    c.add(zp3Var);
                }
                if (!this.a.containsKey(str)) {
                    this.a.put(str, c);
                }
            }
        }
    }

    public synchronized void b(String str, aq3 aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, aq3Var) == null) {
            synchronized (this) {
                for (zp3 zp3Var : new ArrayList(c(str))) {
                    if (zp3Var != null) {
                        zp3Var.a(aq3Var);
                    }
                }
            }
        }
    }

    public final List<zp3> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new ArrayList();
            }
            List<zp3> list = this.a.get(str);
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
                List<zp3> list = this.a.get(str);
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

    public final boolean e(String str, zp3 zp3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, zp3Var)) == null) ? TextUtils.isEmpty(str) || zp3Var == null : invokeLL.booleanValue;
    }

    public synchronized void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                g(str, null);
            }
        }
    }

    public synchronized void g(String str, zp3 zp3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, zp3Var) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (zp3Var == null) {
                    this.a.remove(str);
                    return;
                }
                List<zp3> c = c(str);
                if (c.contains(zp3Var)) {
                    c.remove(zp3Var);
                    if (c.isEmpty()) {
                        this.a.remove(str);
                    }
                }
            }
        }
    }
}
