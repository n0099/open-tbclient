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
public class gi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<hi8> a;
    public oi8 b;

    public gi8() {
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
        this.b = new oi8();
    }

    public void a(hi8 hi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hi8Var) == null) {
            if (hi8Var != null) {
                this.a.add(hi8Var);
            }
            if (this.b == null || hi8Var == null || hi8Var.getClass().getAnnotation(ho.class) == null) {
                return;
            }
            try {
                this.b.a((ji8) Class.forName("com.baidu.tieba.h5power." + hi8Var.getClass().getSimpleName() + ji8.PROXY_CLASS_NAME_SUFFIX).getConstructor(hi8Var.getClass()).newInstance(hi8Var));
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
                Iterator<hi8> it = this.a.iterator();
                while (it.hasNext()) {
                    hi8 next = it.next();
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
        ni8 ni8Var = new ni8();
        li8 li8Var = new li8();
        String a = pi8.a(str);
        ni8Var.f(a);
        String d = pi8.d(str);
        ni8Var.h(d);
        String b = pi8.b(str);
        li8Var.v(b);
        if (oi.isEmpty(a) || oi.isEmpty(d) || oi.isEmpty(b)) {
            li8Var.y(101);
        }
        try {
            ni8Var.j(pi8.f(str));
        } catch (JSONException unused) {
            ni8Var.j(new JSONObject());
            li8Var.y(101);
        }
        ni8Var.i(pi8.e(str));
        ni8Var.g(pi8.c(str));
        li8 c = this.b.c(ni8Var, li8Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            f(vf8.a(webView.getContext()), str, c);
        }
    }

    public final boolean f(TbPageContext<?> tbPageContext, String str, li8 li8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, tbPageContext, str, li8Var)) == null) {
            if (li8Var == null || li8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            li8Var.r(true);
            li8Var.y(0);
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

    public void h(hi8 hi8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, hi8Var) == null) || hi8Var == null) {
            return;
        }
        this.a.remove(hi8Var);
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        oi8 oi8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) == null) || (oi8Var = this.b) == null) {
            return;
        }
        this.b.e(webView, oi8Var.f(str, hashMap));
    }
}
