package d.a.q0.h.z;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f53737b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a.l0.c f53738a;
    @V8JavascriptField
    public JsObject canvas;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1035997053, "Ld/a/q0/h/z/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1035997053, "Ld/a/q0/h/z/e;");
                return;
            }
        }
        f53737b = k.f49133a;
    }

    public e(d.a.q0.a.l0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.canvas = null;
        this.f53738a = cVar;
        a();
        b();
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c(this.f53738a.getInitBasePath(), "swan-game-open-data.js") : invokeV.booleanValue;
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String A = d.a.q0.a.g1.f.V().A();
            String b2 = f.a().b();
            if (f53737b) {
                Log.d("SwanGameOpenDataContext", "baseFilePath: " + A);
                Log.d("SwanGameOpenDataContext", "openDataJSFile: " + b2);
            }
            return c(A, b2);
        }
        return invokeV.booleanValue;
    }

    public final boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (!f.a().c() || TextUtils.isEmpty(str)) {
                return false;
            }
            this.f53738a.e0().b(str, str2);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f53738a.e0().a();
        }
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) {
            this.f53738a.z().dispatchEvent(new JSEvent("postmessage", jsObject));
        }
    }
}
