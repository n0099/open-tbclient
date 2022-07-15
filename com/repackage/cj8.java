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
/* loaded from: classes5.dex */
public class cj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<dj8> a;
    public kj8 b;

    public cj8() {
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
        this.b = new kj8();
    }

    public void a(dj8 dj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dj8Var) == null) {
            if (dj8Var != null) {
                this.a.add(dj8Var);
            }
            if (this.b == null || dj8Var == null || dj8Var.getClass().getAnnotation(ho.class) == null) {
                return;
            }
            try {
                this.b.a((fj8) Class.forName("com.baidu.tieba.h5power." + dj8Var.getClass().getSimpleName() + fj8.PROXY_CLASS_NAME_SUFFIX).getConstructor(dj8Var.getClass()).newInstance(dj8Var));
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
                Iterator<dj8> it = this.a.iterator();
                while (it.hasNext()) {
                    dj8 next = it.next();
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
        jj8 jj8Var = new jj8();
        hj8 hj8Var = new hj8();
        String a = lj8.a(str);
        jj8Var.f(a);
        String d = lj8.d(str);
        jj8Var.h(d);
        String b = lj8.b(str);
        hj8Var.v(b);
        if (oi.isEmpty(a) || oi.isEmpty(d) || oi.isEmpty(b)) {
            hj8Var.y(101);
        }
        try {
            jj8Var.j(lj8.f(str));
        } catch (JSONException unused) {
            jj8Var.j(new JSONObject());
            hj8Var.y(101);
        }
        jj8Var.i(lj8.e(str));
        jj8Var.g(lj8.c(str));
        hj8 c = this.b.c(jj8Var, hj8Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            f(qg8.a(webView.getContext()), str, c);
        }
    }

    public final boolean f(TbPageContext<?> tbPageContext, String str, hj8 hj8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, tbPageContext, str, hj8Var)) == null) {
            if (hj8Var == null || hj8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            hj8Var.r(true);
            hj8Var.y(0);
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

    public void h(dj8 dj8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, dj8Var) == null) || dj8Var == null) {
            return;
        }
        this.a.remove(dj8Var);
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        kj8 kj8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) == null) || (kj8Var = this.b) == null) {
            return;
        }
        this.b.e(webView, kj8Var.f(str, hashMap));
    }
}
