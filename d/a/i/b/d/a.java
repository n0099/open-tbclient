package d.a.i.b.d;

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
/* loaded from: classes8.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String f45726d;

    /* renamed from: e  reason: collision with root package name */
    public static a f45727e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45728a;

    /* renamed from: b  reason: collision with root package name */
    public WebView f45729b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45730c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-364163523, "Ld/a/i/b/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-364163523, "Ld/a/i/b/d/a;");
                return;
            }
        }
        f45726d = BdSailor.class.getName();
    }

    public a() {
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

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a aVar = f45727e;
            if (aVar == null) {
                f45727e = new a();
            } else if (aVar.f45729b != null && (aVar.f45730c ^ BdZeusUtil.isWebkitLoaded())) {
                Log.d(f45726d, "BdWebViewSingleton, re-new instance need because of the kernel changed");
                f45727e.f();
                f45727e.e();
            }
            return f45727e;
        }
        return (a) invokeV.objValue;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            a a2 = a();
            a2.f();
            a2.f45728a = null;
            f45727e = null;
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Log.d(f45726d, "BdWebViewSingleton pauseTimer");
            try {
                e();
                this.f45729b.pauseTimers();
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
            Log.d(f45726d, "BdWebViewSingleton resumeTimer");
            try {
                e();
                this.f45729b.resumeTimers();
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f45729b == null && this.f45728a != null) {
            if (BdZeusUtil.isWebkitLoaded()) {
                this.f45730c = true;
            } else {
                this.f45730c = false;
                Log.d(f45726d, "BdWebViewSingleton init system webview,zeus was not load complete");
            }
            this.f45729b = new WebView(this.f45728a);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Log.w(f45726d, "BdWebViewSingleton, old instance has been destroyed");
            WebView webView = this.f45729b;
            if (webView != null) {
                webView.destroy();
                this.f45729b = null;
            }
        }
    }
}
