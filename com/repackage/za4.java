package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class za4 extends ea4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ua4 a;
    public boolean b;

    public za4(ua4 ua4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ua4Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ua4Var;
        this.b = z;
    }

    @Override // com.repackage.ea4
    public ua4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ua4) invokeV.objValue;
    }

    @Override // com.repackage.ea4
    public boolean b(ua4 ua4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ua4Var)) == null) {
            ua4 ua4Var2 = this.a;
            if (ua4Var2 == ua4Var) {
                return true;
            }
            return ua4Var2.d(ua4Var);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.ea4
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.b) {
            return;
        }
        if (z) {
            ua4 ua4Var = this.a;
            ua4Var.a.b.b = 0L;
            ua4Var.b(0);
        }
        sa4.b().f(this.a);
    }

    @Override // com.repackage.ea4
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
