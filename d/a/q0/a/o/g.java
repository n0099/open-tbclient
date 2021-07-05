package d.a.q0.a.o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.v2.n0;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g implements d.a.q0.f.i.l.f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final ViewGroup.LayoutParams f49808c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.h0.g.f f49809a;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f49810b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(835265357, "Ld/a/q0/a/o/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(835265357, "Ld/a/q0/a/o/g;");
                return;
            }
        }
        f49808c = new FrameLayout.LayoutParams(-1, -1);
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.q0.f.i.l.f
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
            Context appContext = AppRuntime.getAppContext();
            if (W == null) {
                if (appContext != null) {
                    d.a.q0.a.z1.b.f.e.f(appContext, h.aiapps_open_fragment_failed_toast).F();
                    return;
                }
                return;
            }
            d.a.q0.a.l1.b g2 = d.a.q0.a.l1.b.g(str, str);
            g2.k(jSONObject.toString());
            g.b i2 = W.i("adLanding");
            i2.n(d.a.q0.a.h0.g.g.f48010g, d.a.q0.a.h0.g.g.f48012i);
            i2.k("adLanding", g2).b();
        }
    }

    @Override // d.a.q0.f.i.l.f
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.f.i.l.f
    public boolean c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.f.i.l.f
    public boolean d(View view, d.a.q0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        d.a.q0.a.h0.g.g W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, aVar)) == null) {
            d.a.q0.a.g1.f V = d.a.q0.a.g1.f.V();
            SwanAppActivity activity = V.getActivity();
            if (activity == null || activity.isFinishing() || (W = V.W()) == null) {
                return false;
            }
            d.a.q0.a.h0.g.f o = W.o();
            this.f49809a = o;
            if (o.t3()) {
                int u = n0.u();
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (childAt.getTop() < u) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.topMargin = childAt.getTop() + u;
                            childAt.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.f49810b = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view, f49808c);
            d.a.q0.a.z1.b.c.a floatLayer = o.getFloatLayer();
            if (floatLayer == null) {
                return false;
            }
            floatLayer.j(true);
            n0.b(activity);
            floatLayer.k(this.f49810b);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.q0.f.i.l.f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // d.a.q0.f.i.l.f
    public boolean f(View view, d.a.q0.f.i.i.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view, aVar)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.q0.f.i.l.f
    public boolean removeView(View view) {
        InterceptResult invokeL;
        d.a.q0.a.z1.b.c.a floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            this.f49810b.removeAllViews();
            d.a.q0.a.h0.g.f fVar = this.f49809a;
            if (fVar == null || (floatLayer = fVar.getFloatLayer()) == null) {
                return false;
            }
            floatLayer.j(false);
            floatLayer.g();
            return true;
        }
        return invokeL.booleanValue;
    }
}
