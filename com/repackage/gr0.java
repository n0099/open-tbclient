package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class gr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<cv0> a;

    public gr0() {
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

    public void b(@NonNull cv0 cv0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cv0Var) == null) || this.a.contains(cv0Var)) {
            return;
        }
        xx0.b(this.a, cv0Var);
    }

    public void c(@NonNull vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vr0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                cv0 cv0Var = (cv0) xx0.d(this.a, i);
                if (cv0Var != null) {
                    if (i == 0) {
                        cv0Var.d(vr0Var);
                    } else {
                        cv0Var.d(vr0.a(vr0Var));
                    }
                }
            }
        }
    }

    public void d(@NonNull cv0 cv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cv0Var) == null) {
            xx0.j(this.a, cv0Var);
        }
    }
}
