package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public abstract class fr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<bv0> a;

    public fr0() {
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

    public void b(@NonNull bv0 bv0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bv0Var) == null) || this.a.contains(bv0Var)) {
            return;
        }
        wx0.b(this.a, bv0Var);
    }

    public void c(@NonNull ur0 ur0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur0Var) == null) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                bv0 bv0Var = (bv0) wx0.d(this.a, i);
                if (bv0Var != null) {
                    if (i == 0) {
                        bv0Var.d(ur0Var);
                    } else {
                        bv0Var.d(ur0.a(ur0Var));
                    }
                }
            }
        }
    }

    public void d(@NonNull bv0 bv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bv0Var) == null) {
            wx0.j(this.a, bv0Var);
        }
    }
}
