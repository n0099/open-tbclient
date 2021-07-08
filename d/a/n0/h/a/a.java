package d.a.n0.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.h;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.p.b.a.n;
import d.a.n0.a.z1.b.f.e;
import d.a.n0.f.i.l.f;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements f {
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

    @Override // d.a.n0.f.i.l.f
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            g W = d.a.n0.a.g1.f.V().W();
            Context appContext = AppRuntime.getAppContext();
            if (W == null) {
                if (appContext != null) {
                    e.f(appContext, h.aiapps_open_fragment_failed_toast).F();
                    return;
                }
                return;
            }
            d.a.n0.a.l1.b g2 = d.a.n0.a.l1.b.g(str, str);
            g2.k(jSONObject.toString());
            g.b i2 = W.i("adLanding");
            i2.n(g.f44708g, g.f44710i);
            i2.k("adLanding", g2).b();
        }
    }

    @Override // d.a.n0.f.i.l.f
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.b() : invokeV.booleanValue;
    }

    @Override // d.a.n0.f.i.l.f
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) ? d.c(view) : invokeL.booleanValue;
    }

    @Override // d.a.n0.f.i.l.f
    public boolean d(View view, d.a.n0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) ? d.a(view, new d.a.n0.a.l1.e.a.a(aVar.f(), aVar.g(), aVar.h(), aVar.e())) : invokeLL.booleanValue;
    }

    @Override // d.a.n0.f.i.l.f
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = d.a.n0.a.g1.f.V().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            d.a.n0.a.g1.f.V().X().g(true);
        }
    }

    @Override // d.a.n0.f.i.l.f
    public boolean f(View view, d.a.n0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            n X = d.a.n0.a.g1.f.V().X();
            return X != null && X.a(view, new d.a.n0.a.l1.e.a.a(aVar.f(), aVar.g(), aVar.h(), aVar.e()));
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.n0.f.i.l.f
    public boolean removeView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) ? d.d(view) : invokeL.booleanValue;
    }
}
