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
public class nl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final tl8 b;
    public final sl8 c;
    public final ul8 d;
    public final ql8 e;
    public final ml8 f;
    public final pl8 g;
    public final ol8 h;
    public final kl8 i;
    public final rl8 j;
    public final ll8 k;

    public nl8(MainTabActivity mainTabActivity, al8 al8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, al8Var};
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
        this.b = new tl8(mainTabActivity, al8Var);
        this.c = new sl8(mainTabActivity, al8Var);
        this.d = new ul8();
        this.e = new ql8(mainTabActivity, al8Var);
        this.f = new ml8(mainTabActivity, al8Var);
        this.g = new pl8(mainTabActivity, al8Var);
        this.h = new ol8(mainTabActivity, al8Var);
        this.i = new kl8(mainTabActivity, al8Var);
        this.j = new rl8(mainTabActivity, al8Var);
        this.k = new ll8(mainTabActivity, al8Var);
    }

    public kl8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (kl8) invokeV.objValue;
    }

    public ll8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.k : (ll8) invokeV.objValue;
    }

    public ml8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (ml8) invokeV.objValue;
    }

    public ol8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (ol8) invokeV.objValue;
    }

    public pl8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (pl8) invokeV.objValue;
    }

    public ql8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (ql8) invokeV.objValue;
    }

    public rl8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (rl8) invokeV.objValue;
    }

    public sl8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c : (sl8) invokeV.objValue;
    }

    public tl8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.b : (tl8) invokeV.objValue;
    }

    public ul8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.d : (ul8) invokeV.objValue;
    }
}
