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
public class oh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ph8> a;
    public wh8 b;

    public oh8() {
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
        this.b = new wh8();
    }

    public void a(ph8 ph8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ph8Var) == null) {
            if (ph8Var != null) {
                this.a.add(ph8Var);
            }
            if (this.b == null || ph8Var == null || ph8Var.getClass().getAnnotation(Cdo.class) == null) {
                return;
            }
            try {
                this.b.a((rh8) Class.forName("com.baidu.tieba.h5power." + ph8Var.getClass().getSimpleName() + rh8.PROXY_CLASS_NAME_SUFFIX).getConstructor(ph8Var.getClass()).newInstance(ph8Var));
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
                Iterator<ph8> it = this.a.iterator();
                while (it.hasNext()) {
                    ph8 next = it.next();
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
        vh8 vh8Var = new vh8();
        th8 th8Var = new th8();
        String a = xh8.a(str);
        vh8Var.f(a);
        String d = xh8.d(str);
        vh8Var.h(d);
        String b = xh8.b(str);
        th8Var.v(b);
        if (ki.isEmpty(a) || ki.isEmpty(d) || ki.isEmpty(b)) {
            th8Var.y(101);
        }
        try {
            vh8Var.j(xh8.f(str));
        } catch (JSONException unused) {
            vh8Var.j(new JSONObject());
            th8Var.y(101);
        }
        vh8Var.i(xh8.e(str));
        vh8Var.g(xh8.c(str));
        th8 c = this.b.c(vh8Var, th8Var);
        if (c.g()) {
            this.b.d(webView, c);
        } else {
            f(cf8.a(webView.getContext()), str, c);
        }
    }

    public final boolean f(TbPageContext<?> tbPageContext, String str, th8 th8Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, tbPageContext, str, th8Var)) == null) {
            if (th8Var == null || th8Var.i() || !SchemeActionManager.getInstance().doSchemeAction(tbPageContext, str)) {
                return false;
            }
            th8Var.r(true);
            th8Var.y(0);
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

    public void h(ph8 ph8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ph8Var) == null) || ph8Var == null) {
            return;
        }
        this.a.remove(ph8Var);
    }

    public void i(WebView webView, String str, @Nullable HashMap hashMap) {
        wh8 wh8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, hashMap) == null) || (wh8Var = this.b) == null) {
            return;
        }
        this.b.e(webView, wh8Var.f(str, hashMap));
    }
}
