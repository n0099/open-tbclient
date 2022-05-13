package com.repackage;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jx3;
import java.io.File;
@Singleton
@Service
/* loaded from: classes7.dex */
public class rw3 implements ei1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rw3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.ei1
    public SwanCoreVersion n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? tw3.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.ei1
    public td2 o(SwanAppActivity swanAppActivity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, str)) == null) ? new uw3(swanAppActivity, str) : (td2) invokeLL.objValue;
    }

    @Override // com.repackage.ei1
    public c42 p(nf3<Exception> nf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nf3Var)) == null) ? new zw3(nf3Var) : (c42) invokeL.objValue;
    }

    @Override // com.repackage.ei1
    public void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            tw3.m().z(intent);
        }
    }

    @Override // com.repackage.ei1
    public View r(a02 a02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, a02Var)) == null) {
            if (a02Var instanceof qw3) {
                return ((qw3) a02Var).u3();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.repackage.ei1
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            tw3.C();
        }
    }

    @Override // com.repackage.ei1
    public void s(V8ExceptionInfo v8ExceptionInfo) {
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, v8ExceptionInfo) == null) || (r = tw3.m().r()) == null) {
            return;
        }
        r.q(v8ExceptionInfo);
    }

    @Override // com.repackage.ei1
    public ExtensionCore t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? tw3.m().k() : (ExtensionCore) invokeV.objValue;
    }

    @Override // com.repackage.ei1
    public gb2 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? gw3.i() : (gb2) invokeV.objValue;
    }

    @Override // com.repackage.ei1
    public int v(String str, long j) {
        InterceptResult invokeLJ;
        n04 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j)) == null) {
            if (TextUtils.isEmpty(str) || (a = n04.a(xg4.E(new File(jx3.d.h(str, String.valueOf(j)), "game.json")))) == null) {
                return 0;
            }
            return a.b;
        }
        return invokeLJ.intValue;
    }

    @Override // com.repackage.ei1
    public void w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            z24.a().d(str, z);
        }
    }
}
