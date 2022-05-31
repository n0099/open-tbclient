package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes6.dex */
public class ks3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ks3 b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ms3> a;

    public ks3() {
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

    public static ks3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (ks3.class) {
                    if (b == null) {
                        b = new ks3();
                    }
                }
            }
            return b;
        }
        return (ks3) invokeV.objValue;
    }

    public void a(ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ms3Var) == null) || ms3Var == null || this.a.contains(ms3Var)) {
            return;
        }
        this.a.add(ms3Var);
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            for (ms3 ms3Var : this.a) {
                if (i == 16) {
                    ms3Var.c();
                } else if (i == 17) {
                    ms3Var.b(str);
                }
                d(ms3Var);
            }
        }
    }

    public void d(ms3 ms3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ms3Var) == null) && this.a.contains(ms3Var)) {
            this.a.remove(ms3Var);
        }
    }
}
