package com.repackage;

import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class nl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ol8> a;
    public vl8 b;

    public nl8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList<>();
        this.b = new vl8();
    }

    public void a(ol8 ol8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ol8Var) == null) {
            if (ol8Var != null) {
                this.a.add(ol8Var);
            }
            if (this.b == null || ol8Var == null || ol8Var.getClass().getAnnotation(io.class) == null) {
                return;
            }
            try {
                this.b.a((ql8) Class.forName("com.baidu.tieba.h5power." + ol8Var.getClass().getSimpleName() + ql8.PROXY_CLASS_NAME_SUFFIX).getConstructor(ol8Var.getClass()).newInstance(ol8Var));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public boolean b(WebView webView, String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, jsPromptResult)) == null) {
            if (str.startsWith("tiebaapp")) {
                e(webView, str);
                return false;
            }
            return c(str, jsPromptResult);
        }
        return invokeLLL.booleanValue;
    }

    public boolean c(String str, JsPromptResult jsPromptResult) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jsPromptResult)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("interfaceName");
                String optString2 = jSONObject.optString("methodName");
                String optString3 = jSONObject.optString("param");
                if (!StringUtils.isNull(optString) && !StringUtils.isNull(optString2) && !StringUtils.isNull(optString3)) {
                    return d(optString, optString2, optString3, jsPromptResult);
                }
            } catch (JSONException unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, str, str2, str3, jsPromptResult)) == null) {
            if (ListUtils.getCount(this.a) > 0) {
                Iterator<ol8> it = this.a.iterator();
                while (it.hasNext()) {
                    ol8 next = it.next();
                    if (next != null && next.dealJsInterface(str, str2, str3, jsPromptResult)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void e(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, webView, str) == null) || this.b == null) {
            return;
        }
        ul8 ul8Var = new ul8();
        sl8 sl8Var = new sl8();
        String a = wl8.a(str);
        ul8Var.f(a);
        String d = wl8.d(str);
        ul8Var.h(d);
        String b = wl8.b(str);
        sl8Var.v(b);
        if (pi.isEmpty(a) || pi.isEmpty(d) || pi.isEmpty(b)) {
            sl8Var.y(101);
        }
        try {
            ul8Var.j(wl8.f(str));
        } catch (JSONException unused) {
            ul8Var.j(new JSONObject());
            sl8Var.y(101);
        }
        ul8Var.i(wl8.e(str));
        ul8Var.g(wl8.c(str));
        sl8 c = this.b.c(ul8Var, sl8Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            f(dj8.a(webView.getContext()), str, c);
        }
    }

    public final boolean f(TbPageContext<?> tbPageContext, String str, sl8 sl8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, tbPageContext, str, sl8Var)) == null) {
            if (sl8Var == null || sl8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            sl8Var.r(true);
            sl8Var.y(0);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.clear();
        }
    }

    public void h(ol8 ol8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ol8Var) == null) || ol8Var == null) {
            return;
        }
        this.a.remove(ol8Var);
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        vl8 vl8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) == null) || (vl8Var = this.b) == null) {
            return;
        }
        this.b.e(webView, vl8Var.f(str, hashMap));
    }
}
