package com.repackage;

import android.content.Context;
import android.util.Log;
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
/* loaded from: classes6.dex */
public class f22 extends SwanAppWebViewManager implements Object<NgWebView>, d22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public transient /* synthetic */ FieldHolder $fh;
    public final String w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755759797, "Lcom/repackage/f22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755759797, "Lcom/repackage/f22;");
                return;
            }
        }
        x = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f22(Context context) {
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
        this.w = n22.b();
    }

    @Override // com.repackage.d22
    public void E(v62 v62Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, v62Var) == null) || v62Var == null) {
            return;
        }
        if (x) {
            Log.d("SwanAppMasterManager", "pathList item: " + v62Var.b);
        }
        this.b.getSettings().setCodeCacheSetting(az1.a("appjs", v62Var.b));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    @Override // com.repackage.d22
    public fz1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? t() : (fz1) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b72.U().w0(true);
        }
    }

    @Override // com.repackage.d22
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }
}
