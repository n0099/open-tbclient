package d.a.q0.a.h0.e;

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
import d.a.q0.a.e0.e;
import d.a.q0.a.k;
import d.a.q0.a.p.b.a.f;
import d.a.q0.a.v2.x;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class d extends SwanAppWebViewManager implements d.a.q0.a.p.e.a<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean C;
    public transient /* synthetic */ FieldHolder $fh;
    public Context A;
    public boolean B;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705357711, "Ld/a/q0/a/h0/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705357711, "Ld/a/q0/a/h0/e/d;");
                return;
            }
        }
        C = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.B = false;
        this.A = context;
        g1();
    }

    @Override // d.a.q0.a.p.e.a
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d.a.q0.a.e0.d.k(false);
            ViewParent parent = u().getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(u());
            }
            destroy();
        }
    }

    @Override // d.a.q0.a.p.e.a
    public void H(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        l(viewGroup, u());
    }

    @Override // d.a.q0.a.p.e.a
    public void I(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // d.a.q0.a.p.e.a
    public void R(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            u().setVisibility(z ? 0 : 8);
        }
    }

    public final void U() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (context = this.A) != null && (context instanceof Activity)) {
            x.a(context, ((Activity) context).getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // d.a.q0.a.p.e.a
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            R(u().getVisibility() != 0);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.q0.a.p.e.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "console" : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.q0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            U();
            super.destroy();
        }
    }

    public final void e1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (C) {
                Log.d("SwanAppConsoleManager", "call downloadConsoleCore: " + z);
            }
            if (!this.B || z) {
                d.a.q0.n.i.m.d dVar = new d.a.q0.n.i.m.d("sconsole-core", e.c(), e.b(), 2);
                f h2 = d.a.q0.a.c1.b.h();
                d.a.q0.n.b.e(dVar, h2 != null ? h2.d() : null);
                this.B = true;
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.q0.a.p.e.d
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.f0();
        }
    }

    public final boolean f1(ViewGroup viewGroup, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, view)) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (viewGroup.getChildAt(i2) == view) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // d.a.q0.a.p.e.a
    public void g0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(str2)) {
                jSONArray.put(str2);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("logType", str);
            hashMap.put("logs", jSONArray.toString());
            d.a.q0.a.g1.f.V().m("console", new d.a.q0.a.o0.d.b("searchboxSConsole", hashMap));
        }
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            u().setVisibility(8);
            u().setBackgroundColor(0);
            File file = new File(e.a(), "index.html");
            if (file.exists() && file.isFile()) {
                loadUrl(Uri.fromFile(file).toString());
                e1(false);
                return;
            }
            loadUrl("file:///android_asset/aiapps/sConsole.html");
            e.d();
            e1(true);
        }
    }

    public final void l(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, viewGroup, view) == null) || viewGroup == null || view == null || f1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }
}
