package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qz1;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hh1 implements wo3 {
    public static /* synthetic */ Interceptable $ic;
    public static final ViewGroup.LayoutParams c;
    public transient /* synthetic */ FieldHolder $fh;
    public pz1 a;
    public FrameLayout b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755648352, "Lcom/repackage/hh1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755648352, "Lcom/repackage/hh1;");
                return;
            }
        }
        c = new FrameLayout.LayoutParams(-1, -1);
    }

    public hh1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.wo3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            qz1 V = ul2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    zz2.f(appContext, R.string.obfuscated_res_0x7f0f01a1).G();
                    return;
                }
                return;
            }
            hq2 d = hq2.d(str, str);
            d.h(jSONObject.toString());
            qz1.b i = V.i("adLanding");
            i.n(qz1.g, qz1.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.repackage.wo3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.wo3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.wo3
    public boolean d(View view2, qn3 qn3Var) {
        InterceptResult invokeLL;
        qz1 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, qn3Var)) == null) {
            ul2 U = ul2.U();
            SwanAppActivity activity = U.getActivity();
            if (activity == null || activity.isFinishing() || (V = U.V()) == null) {
                return false;
            }
            pz1 o = V.o();
            this.a = o;
            if (o.G3()) {
                int t = yd3.t();
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getTop() < t) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.topMargin = childAt.getTop() + t;
                            childAt.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.b = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view2, c);
            oz2 c2 = o.c();
            if (c2 == null) {
                return false;
            }
            c2.m(true);
            yd3.b(activity);
            c2.n(this.b);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.wo3
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.repackage.wo3
    public boolean f(View view2, qn3 qn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, qn3Var)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.wo3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        oz2 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            this.b.removeAllViews();
            pz1 pz1Var = this.a;
            if (pz1Var == null || (c2 = pz1Var.c()) == null) {
                return false;
            }
            c2.m(false);
            c2.g();
            return true;
        }
        return invokeL.booleanValue;
    }
}
