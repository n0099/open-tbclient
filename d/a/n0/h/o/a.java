package d.a.n0.h.o;

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
import d.a.n0.a.h0.m.l;
import d.a.n0.a.p.b.a.g;
import d.a.n0.h.s.a;
import java.io.File;
@Singleton
@Service
/* loaded from: classes7.dex */
public class a implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.n0.a.p.b.a.g
    public SwanCoreVersion n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.m().s() : (SwanCoreVersion) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.b.a.g
    public d.a.n0.a.t0.c o(SwanAppActivity swanAppActivity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity, str)) == null) ? new d(swanAppActivity, str) : (d.a.n0.a.t0.c) invokeLL.objValue;
    }

    @Override // d.a.n0.a.p.b.a.g
    public l p(d.a.n0.a.v2.e1.b<Exception> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) ? new d.a.n0.h.p.b.a(bVar) : (l) invokeL.objValue;
    }

    @Override // d.a.n0.a.p.b.a.g
    public void q(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            c.m().z(intent);
        }
    }

    @Override // d.a.n0.a.p.b.a.g
    public View r(d.a.n0.a.h0.g.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            if (dVar instanceof d.a.n0.h.n.a) {
                return ((d.a.n0.h.n.a) dVar).h3();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    @Override // d.a.n0.a.p.b.a.g
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.C();
        }
    }

    @Override // d.a.n0.a.p.b.a.g
    public void s(V8ExceptionInfo v8ExceptionInfo) {
        DuMixGameSurfaceView r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, v8ExceptionInfo) == null) || (r = c.m().r()) == null) {
            return;
        }
        r.q(v8ExceptionInfo);
    }

    @Override // d.a.n0.a.p.b.a.g
    public ExtensionCore t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.m().k() : (ExtensionCore) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.b.a.g
    public d.a.n0.a.p0.d.b u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? d.a.n0.h.m.a.i() : (d.a.n0.a.p0.d.b) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.b.a.g
    public int v(String str, long j) {
        InterceptResult invokeLJ;
        d.a.n0.h.c0.a.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j)) == null) {
            if (TextUtils.isEmpty(str) || (a2 = d.a.n0.h.c0.a.a.a(d.a.n0.t.d.D(new File(a.d.h(str, String.valueOf(j)), "game.json")))) == null) {
                return 0;
            }
            return a2.f49883b;
        }
        return invokeLJ.intValue;
    }

    @Override // d.a.n0.a.p.b.a.g
    public void w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, str, z) == null) {
            d.a.n0.h.l0.a.a().d(str, z);
        }
    }
}
