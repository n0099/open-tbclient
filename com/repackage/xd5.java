package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xd5 implements bg<sd5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public xd5(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.repackage.bg
    public /* bridge */ /* synthetic */ sd5 a(sd5 sd5Var) {
        sd5 sd5Var2 = sd5Var;
        e(sd5Var2);
        return sd5Var2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.repackage.bg
    public /* bridge */ /* synthetic */ sd5 c(sd5 sd5Var) {
        sd5 sd5Var2 = sd5Var;
        i(sd5Var2);
        return sd5Var2;
    }

    public sd5 e(sd5 sd5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sd5Var)) == null) ? sd5Var : (sd5) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bg
    /* renamed from: f */
    public void b(sd5 sd5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, sd5Var) == null) || sd5Var == null || sd5Var.b() == null) {
            return;
        }
        sd5Var.b().recycle();
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bg
    /* renamed from: h */
    public sd5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new sd5(this.a) : (sd5) invokeV.objValue;
    }

    public sd5 i(sd5 sd5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sd5Var)) == null) ? sd5Var : (sd5) invokeL.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a = i;
        }
    }
}
