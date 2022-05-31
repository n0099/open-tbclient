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
import com.repackage.wv3;
import java.io.File;
@Singleton
@Service
/* loaded from: classes5.dex */
public class ev3 implements rg1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ev3() {
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

    @Override // com.repackage.rg1
    public SwanCoreVersion n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? gv3.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.repackage.rg1
    public gc2 o(SwanAppActivity swanAppActivity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, str)) == null) ? new hv3(swanAppActivity, str) : (gc2) invokeLL.objValue;
    }

    @Override // com.repackage.rg1
    public p22 p(ae3<Exception> ae3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ae3Var)) == null) ? new mv3(ae3Var) : (p22) invokeL.objValue;
    }

    @Override // com.repackage.rg1
    public void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            gv3.m().z(intent);
        }
    }

    @Override // com.repackage.rg1
    public View r(ny1 ny1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ny1Var)) == null) {
            if (ny1Var instanceof dv3) {
                return ((dv3) ny1Var).u3();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.repackage.rg1
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            gv3.C();
        }
    }

    @Override // com.repackage.rg1
    public void s(V8ExceptionInfo v8ExceptionInfo) {
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, v8ExceptionInfo) == null) || (r = gv3.m().r()) == null) {
            return;
        }
        r.q(v8ExceptionInfo);
    }

    @Override // com.repackage.rg1
    public ExtensionCore t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? gv3.m().k() : (ExtensionCore) invokeV.objValue;
    }

    @Override // com.repackage.rg1
    public t92 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? tu3.i() : (t92) invokeV.objValue;
    }

    @Override // com.repackage.rg1
    public int v(String str, long j) {
        InterceptResult invokeLJ;
        az3 a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j)) == null) {
            if (TextUtils.isEmpty(str) || (a = az3.a(kf4.E(new File(wv3.d.h(str, String.valueOf(j)), "game.json")))) == null) {
                return 0;
            }
            return a.b;
        }
        return invokeLJ.intValue;
    }

    @Override // com.repackage.rg1
    public void w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            m14.a().d(str, z);
        }
    }
}
