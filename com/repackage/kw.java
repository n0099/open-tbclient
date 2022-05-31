package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes6.dex */
public final class kw {
    public static /* synthetic */ Interceptable $ic;
    public static final String d;
    public static kw e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public WebView b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964035047, "Lcom/repackage/kw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964035047, "Lcom/repackage/kw;");
                return;
            }
        }
        d = BdSailor.class.getName();
    }

    public kw() {
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

    public static kw a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            kw kwVar = e;
            if (kwVar == null) {
                e = new kw();
            } else if (kwVar.b != null && (kwVar.c ^ BdZeusUtil.isWebkitLoaded())) {
                Log.d(d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
                e.f();
                e.e();
            }
            return e;
        }
        return (kw) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            kw a = a();
            a.f();
            a.a = null;
            e = null;
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Log.d(d, "BdWebViewSingleton pauseTimer");
            try {
                e();
                this.b.pauseTimers();
                return true;
            } catch (Exception e2) {
                Log.printStackTrace(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Log.d(d, "BdWebViewSingleton resumeTimer");
            try {
                e();
                this.b.resumeTimers();
                return true;
            } catch (Exception e2) {
                Log.printStackTrace(e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b == null && this.a != null) {
            if (BdZeusUtil.isWebkitLoaded()) {
                this.c = true;
            } else {
                this.c = false;
                Log.d(d, "BdWebViewSingleton init system webview,zeus was not load complete");
            }
            this.b = new WebView(this.a);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Log.w(d, "BdWebViewSingleton, old instance has been destroyed");
            WebView webView = this.b;
            if (webView != null) {
                webView.destroy();
                this.b = null;
            }
        }
    }
}
