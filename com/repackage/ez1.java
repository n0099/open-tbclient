package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class ez1 extends SwanAppWebViewManager implements mm1<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public Context w;
    public boolean x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755720427, "Lcom/repackage/ez1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755720427, "Lcom/repackage/ez1;");
                return;
            }
        }
        y = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ez1(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = false;
        this.w = context;
        i1();
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hx1.n(false);
            ViewParent parent = t().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(t());
            }
            destroy();
        }
    }

    @Override // com.repackage.mm1
    public void G(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        k(viewGroup, t());
    }

    public void H(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            t().setVisibility(z ? 0 : 8);
        }
    }

    public final void V() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (context = this.w) != null && (context instanceof Activity)) {
            id3.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // com.repackage.mm1
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            R(t().getVisibility() != 0);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            V();
            super.destroy();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.g0();
        }
    }

    public final void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (y) {
                Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
            }
            if (!this.x || z) {
                ib4 ib4Var = new ib4("sconsole-core", ix1.c(), ix1.b(), 2);
                qh1 h = pj2.h();
                p74.g(ib4Var, h != null ? h.d() : null);
                this.x = true;
            }
        }
    }

    public final boolean h1(ViewGroup viewGroup, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, view2)) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (viewGroup.getChildAt(i) == view2) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void i0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str2)) {
                jSONArray.put(str2);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("logType", str);
            hashMap.put("logs", jSONArray.toString());
            ul2.U().m("console", new ia2("searchboxSConsole", hashMap));
        }
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            t().setVisibility(8);
            t().setBackgroundColor(0);
            File file = new File(ix1.a(), "index.html");
            if (file.exists() && file.isFile()) {
                loadUrl(Uri.fromFile(file).toString());
                g1(false);
                return;
            }
            loadUrl("file:///android_asset/aiapps/sConsole.html");
            ix1.d();
            g1(true);
        }
    }

    public final void k(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, viewGroup, view2) == null) || viewGroup == null || view2 == null || h1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
    }
}
