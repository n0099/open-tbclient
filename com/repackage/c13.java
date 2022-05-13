package com.repackage;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.y03;
/* loaded from: classes5.dex */
public class c13 extends q03 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x03 a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c13() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((x03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.x03
    public void A(y03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            G().A(aVar);
        }
    }

    @Override // com.repackage.x03
    public e33 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? G().B() : (e33) invokeV.objValue;
    }

    @Override // com.repackage.x03
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? G().D() : invokeV.booleanValue;
    }

    @Override // com.repackage.x03
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public x03 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (x03) invokeV.objValue;
    }

    @Override // com.repackage.x03
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? G().getAppId() : (String) invokeV.objValue;
    }

    @Override // com.repackage.x03
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? G().l() : invokeV.intValue;
    }

    @Override // com.repackage.x03
    public void m(Bundle bundle, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bundle, str) == null) {
            G().m(bundle, str);
        }
    }

    @Override // com.repackage.x03
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? G().n() : (SwanAppCores) invokeV.objValue;
    }

    @Override // com.repackage.x03
    public String o(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, strArr)) == null) ? G().o(strArr) : (String) invokeL.objValue;
    }

    @Override // com.repackage.x03
    public void p(nf3<y03.a> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nf3Var) == null) {
            G().p(nf3Var);
        }
    }

    @Override // com.repackage.x03
    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            G().q(str);
        }
    }

    @Override // com.repackage.x03
    public u03 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? G().r() : (u03) invokeV.objValue;
    }

    @Override // com.repackage.x03
    public void s(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, swanAppActivity) == null) {
            G().s(swanAppActivity);
        }
    }

    @Override // com.repackage.x03
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            G().t();
        }
    }

    @Override // com.repackage.x03
    public void u(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, swanAppActivity) == null) {
            G().u(swanAppActivity);
        }
    }

    @Override // com.repackage.x03
    public void v(nf3<y03.a> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, nf3Var) == null) {
            G().v(nf3Var);
        }
    }

    @Override // com.repackage.x03
    public void w(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, bundle) == null) {
            G().w(str, bundle);
        }
    }

    @Override // com.repackage.x03
    public SwanAppActivity x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? G().x() : (SwanAppActivity) invokeV.objValue;
    }

    @Override // com.repackage.x03
    public xh1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? G().y() : (xh1) invokeV.objValue;
    }

    @Override // com.repackage.x03
    public px2 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? G().z() : (px2) invokeV.objValue;
    }

    public c13(x03 x03Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = x03Var == null ? t03.J() : x03Var;
    }
}
