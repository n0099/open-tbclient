package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class xt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xt3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<zt3> a;

    public xt3() {
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
        this.a = new CopyOnWriteArrayList();
    }

    public static xt3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (xt3.class) {
                    if (b == null) {
                        b = new xt3();
                    }
                }
            }
            return b;
        }
        return (xt3) invokeV.objValue;
    }

    public void a(zt3 zt3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, zt3Var) == null) || zt3Var == null || this.a.contains(zt3Var)) {
            return;
        }
        this.a.add(zt3Var);
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (zt3 zt3Var : this.a) {
                if (i == 16) {
                    zt3Var.c();
                } else if (i == 17) {
                    zt3Var.b(str);
                }
                d(zt3Var);
            }
        }
    }

    public void d(zt3 zt3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zt3Var) == null) && this.a.contains(zt3Var)) {
            this.a.remove(zt3Var);
        }
    }
}
