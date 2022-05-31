package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m94 extends r84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h94 a;
    public boolean b;

    public m94(h94 h94Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h94Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = h94Var;
        this.b = z;
    }

    @Override // com.repackage.r84
    public h94 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (h94) invokeV.objValue;
    }

    @Override // com.repackage.r84
    public boolean b(h94 h94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h94Var)) == null) {
            h94 h94Var2 = this.a;
            if (h94Var2 == h94Var) {
                return true;
            }
            return h94Var2.d(h94Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.r84
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.b) {
            return;
        }
        if (z) {
            h94 h94Var = this.a;
            h94Var.a.b.b = 0L;
            h94Var.b(0);
        }
        f94.b().f(this.a);
    }

    @Override // com.repackage.r84
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
