package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ma4 extends r94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ha4 a;
    public boolean b;

    public ma4(ha4 ha4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ha4Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ha4Var;
        this.b = z;
    }

    @Override // com.repackage.r94
    public ha4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ha4) invokeV.objValue;
    }

    @Override // com.repackage.r94
    public boolean b(ha4 ha4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ha4Var)) == null) {
            ha4 ha4Var2 = this.a;
            if (ha4Var2 == ha4Var) {
                return true;
            }
            return ha4Var2.d(ha4Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.r94
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.b) {
            return;
        }
        if (z) {
            ha4 ha4Var = this.a;
            ha4Var.a.b.b = 0L;
            ha4Var.b(0);
        }
        fa4.b().f(this.a);
    }

    @Override // com.repackage.r94
    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "isAttached=" + this.b + " " + super.toString();
        }
        return (String) invokeV.objValue;
    }
}
