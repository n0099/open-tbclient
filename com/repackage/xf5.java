package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xf5 implements fg<sf5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public xf5(int i) {
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
    @Override // com.repackage.fg
    public /* bridge */ /* synthetic */ sf5 a(sf5 sf5Var) {
        sf5 sf5Var2 = sf5Var;
        e(sf5Var2);
        return sf5Var2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.repackage.fg
    public /* bridge */ /* synthetic */ sf5 c(sf5 sf5Var) {
        sf5 sf5Var2 = sf5Var;
        i(sf5Var2);
        return sf5Var2;
    }

    public sf5 e(sf5 sf5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sf5Var)) == null) ? sf5Var : (sf5) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fg
    /* renamed from: f */
    public void b(sf5 sf5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, sf5Var) == null) || sf5Var == null || sf5Var.b() == null) {
            return;
        }
        sf5Var.b().recycle();
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fg
    /* renamed from: h */
    public sf5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new sf5(this.a) : (sf5) invokeV.objValue;
    }

    public sf5 i(sf5 sf5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sf5Var)) == null) ? sf5Var : (sf5) invokeL.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.a = i;
        }
    }
}
