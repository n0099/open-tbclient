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
public class gn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final nn8 b;
    public final mn8 c;
    public final on8 d;
    public final jn8 e;
    public final fn8 f;
    public final in8 g;
    public final hn8 h;
    public final dn8 i;
    public final kn8 j;
    public final ln8 k;
    public final en8 l;

    public gn8(MainTabActivity mainTabActivity, tm8 tm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, tm8Var};
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
        this.b = new nn8(mainTabActivity, tm8Var);
        this.c = new mn8(mainTabActivity, tm8Var);
        this.d = new on8();
        this.e = new jn8(mainTabActivity, tm8Var);
        this.f = new fn8(mainTabActivity, tm8Var);
        this.g = new in8(mainTabActivity, tm8Var);
        this.h = new hn8(mainTabActivity, tm8Var);
        this.i = new dn8(mainTabActivity, tm8Var);
        this.j = new kn8(mainTabActivity, tm8Var);
        this.k = new ln8(mainTabActivity, tm8Var);
        this.l = new en8(mainTabActivity, tm8Var);
    }

    public dn8 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : (dn8) invokeV.objValue;
    }

    public en8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (en8) invokeV.objValue;
    }

    public fn8 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (fn8) invokeV.objValue;
    }

    public hn8 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.h : (hn8) invokeV.objValue;
    }

    public in8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (in8) invokeV.objValue;
    }

    public jn8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (jn8) invokeV.objValue;
    }

    public kn8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (kn8) invokeV.objValue;
    }

    public ln8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (ln8) invokeV.objValue;
    }

    public mn8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (mn8) invokeV.objValue;
    }

    public nn8 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b : (nn8) invokeV.objValue;
    }

    public on8 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.d : (on8) invokeV.objValue;
    }
}
