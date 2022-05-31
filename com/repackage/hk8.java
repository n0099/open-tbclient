package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final ok8 b;
    public final nk8 c;
    public final pk8 d;
    public final kk8 e;
    public final gk8 f;
    public final jk8 g;
    public final ik8 h;
    public final ek8 i;
    public final lk8 j;
    public final mk8 k;
    public final fk8 l;

    public hk8(MainTabActivity mainTabActivity, uj8 uj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, uj8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = new ok8(mainTabActivity, uj8Var);
        this.c = new nk8(mainTabActivity, uj8Var);
        this.d = new pk8();
        this.e = new kk8(mainTabActivity, uj8Var);
        this.f = new gk8(mainTabActivity, uj8Var);
        this.g = new jk8(mainTabActivity, uj8Var);
        this.h = new ik8(mainTabActivity, uj8Var);
        this.i = new ek8(mainTabActivity, uj8Var);
        this.j = new lk8(mainTabActivity, uj8Var);
        this.k = new mk8(mainTabActivity, uj8Var);
        this.l = new fk8(mainTabActivity, uj8Var);
    }

    public ek8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (ek8) invokeV.objValue;
    }

    public fk8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (fk8) invokeV.objValue;
    }

    public gk8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (gk8) invokeV.objValue;
    }

    public ik8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (ik8) invokeV.objValue;
    }

    public jk8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (jk8) invokeV.objValue;
    }

    public kk8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (kk8) invokeV.objValue;
    }

    public lk8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (lk8) invokeV.objValue;
    }

    public mk8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (mk8) invokeV.objValue;
    }

    public nk8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (nk8) invokeV.objValue;
    }

    public ok8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (ok8) invokeV.objValue;
    }

    public pk8 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : (pk8) invokeV.objValue;
    }
}
