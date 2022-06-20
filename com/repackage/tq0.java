package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class tq0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<pu0> a;

    public tq0() {
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
        this.a = new ArrayList<>();
    }

    public void b(@NonNull pu0 pu0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pu0Var) == null) || this.a.contains(pu0Var)) {
            return;
        }
        kx0.b(this.a, pu0Var);
    }

    public void c(@NonNull ir0 ir0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ir0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                pu0 pu0Var = (pu0) kx0.d(this.a, i);
                if (pu0Var != null) {
                    if (i == 0) {
                        pu0Var.d(ir0Var);
                    } else {
                        pu0Var.d(ir0.a(ir0Var));
                    }
                }
            }
        }
    }

    public void d(@NonNull pu0 pu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pu0Var) == null) {
            kx0.j(this.a, pu0Var);
        }
    }
}
