package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class h92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes6.dex */
    public class a extends f92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy1 c;
        public final /* synthetic */ String d;

        public a(h92 h92Var, fy1 fy1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, fy1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fy1Var;
            this.d = str;
        }

        @Override // com.repackage.f92
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.isDestroyed()) {
                    if (h92.b) {
                        Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + this.d)));
                        return;
                    }
                    return;
                }
                this.c.evaluateJavascript(this.d, null);
                ls2.a("postMessage", "dispatchJSEvent evaluateJavascript");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends f92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fy1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ h92 e;

        public b(h92 h92Var, fy1 fy1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h92Var, fy1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h92Var;
            this.c = fy1Var;
            this.d = str;
        }

        @Override // com.repackage.f92
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.l(this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755693488, "Lcom/repackage/h92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755693488, "Lcom/repackage/h92;");
                return;
            }
        }
        b = rf1.a;
    }

    public h92() {
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

    public final void b(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                jSONObject.put("type", this.a);
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String c(fy1 fy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy1Var)) == null) ? d("event", fy1Var) : (String) invokeL.objValue;
    }

    public String d(String str, fy1 fy1Var) {
        InterceptResult invokeLL;
        String format;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, fy1Var)) == null) {
            if (fy1Var == null || TextUtils.isEmpty(this.a)) {
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                str = "event";
            }
            Locale locale = Locale.getDefault();
            if (fy1Var.isWebView()) {
                format = String.format(locale, "var %s = new Event('%s');", str, this.a);
                b2 = "";
            } else {
                format = String.format(locale, "var %s = new Object();", str);
                b2 = d92.b(str, "type", this.a);
            }
            return format + (b2 + o(str)) + String.format(locale, "%s.dispatchEvent(%s);", d92.c(fy1Var), str);
        }
        return (String) invokeLL.objValue;
    }

    public JSEvent e(fy1 fy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fy1Var)) == null) {
            if (fy1Var == null || TextUtils.isEmpty(this.a)) {
                return null;
            }
            JSEvent jSEvent = new JSEvent(this.a);
            JSONObject jSONObject = new JSONObject();
            try {
                n(jSONObject);
            } catch (Exception e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            b(jSONObject);
            jSEvent.data = jSONObject;
            return jSEvent;
        }
        return (JSEvent) invokeL.objValue;
    }

    public boolean f(fy1 fy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fy1Var)) == null) ? (fy1Var == null || fy1Var.isWebView() || !(fy1Var instanceof r62)) ? false : true : invokeL.booleanValue;
    }

    public void g(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, fy1Var) == null) || fy1Var == null) {
            return;
        }
        ls2.a("postMessage", "dispatchJSEvent start.");
        if (g92.b) {
            r(fy1Var);
        } else {
            q(fy1Var);
        }
        ls2.a("postMessage", "dispatchJSEvent buildEvent");
    }

    public void h(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, fy1Var) == null) || fy1Var == null) {
            return;
        }
        if (b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        JSEvent e = e(fy1Var);
        if (e == null) {
            return;
        }
        j(fy1Var, e);
        if (b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
        }
    }

    public void i(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fy1Var) == null) || fy1Var == null) {
            return;
        }
        if (b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on webView");
        }
        String c = c(fy1Var);
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c);
        k(fy1Var, format);
        if (b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action on webView: " + format);
        }
    }

    public void j(fy1 fy1Var, JSEvent jSEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fy1Var, jSEvent) == null) || fy1Var.isDestroyed()) {
            return;
        }
        if (fy1Var instanceof r62) {
            ((r62) fy1Var).dispatchEvent(jSEvent);
        }
        ls2.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    public void k(fy1 fy1Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, fy1Var, str) == null) || fy1Var == null || TextUtils.isEmpty(str)) {
            return;
        }
        e92.b().c(new a(this, fy1Var, str), null);
    }

    public final void l(fy1 fy1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, fy1Var, str) == null) {
            if (fy1Var.isDestroyed()) {
                if (b) {
                    Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                    return;
                }
                return;
            }
            fy1Var.evaluateJavascript(str, null);
            ls2.a("postMessage", "dispatchJSEvent evaluateJavascript");
        }
    }

    public abstract void m(Map<String, Object> map);

    public void n(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            HashMap hashMap = new HashMap();
            m(hashMap);
            for (String str : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    Object obj = hashMap.get(str);
                    if (p(obj)) {
                        jSONObject.put(str, obj);
                    }
                }
            }
        }
    }

    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Map<String, Object> hashMap = new HashMap<>();
            m(hashMap);
            StringBuilder sb = new StringBuilder();
            for (String str2 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Object obj = hashMap.get(str2);
                    if (p(obj)) {
                        if (obj instanceof String) {
                            obj = JSONObject.quote((String) obj);
                        }
                        sb.append(str);
                        sb.append(".");
                        sb.append(str2);
                        sb.append("=");
                        sb.append(obj);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean p(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (obj instanceof String) {
                return !TextUtils.isEmpty((String) obj);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void q(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fy1Var) == null) {
            String c = c(fy1Var);
            if (TextUtils.isEmpty(c)) {
                return;
            }
            String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c);
            if (b) {
                Log.d("JSEventDispatcher", "dispatchJSEvent action: " + format);
            }
            if (fy1Var.isWebView()) {
                e92.b().c(new b(this, fy1Var, format), null);
            } else {
                l(fy1Var, format);
            }
        }
    }

    public final void r(@NonNull fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fy1Var) == null) {
            if (f(fy1Var)) {
                h(fy1Var);
            } else {
                i(fy1Var);
            }
        }
    }
}
