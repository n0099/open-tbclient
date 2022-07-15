package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j14 extends m14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j14(r72 r72Var) {
        super(r72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r72) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(JsObject jsObject, String str, String str2, q14 q14Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jsObject, str, str2, q14Var) == null) {
            os1 n = n(jsObject);
            pu3 pu3Var = new pu3();
            boolean g = q14Var.g();
            pu3Var.errMsg = q14Var.c(str, str2);
            s24.call(n, g, pu3Var);
            if (g) {
                return;
            }
            a14.i(str2, pu3Var.errMsg);
        }
    }

    public void h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            g(jsObject, "clearStorage", "", a());
        }
    }

    public final JsSerializeValue i(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
            for (int i = 0; i < jsObject.length(); i++) {
                if ("data".equals(jsObject.getPropertyName(i))) {
                    return jsObject.toSerializeValue(i);
                }
            }
            return null;
        }
        return (JsSerializeValue) invokeL.objValue;
    }

    public final q14 j(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            for (int i = 0; i < jsObject.length(); i++) {
                if ("key".equals(jsObject.getPropertyName(i))) {
                    int propertyType = jsObject.getPropertyType(i);
                    return propertyType == 7 ? q14.i(jsObject.toString(i)) : q14.b(String.format("parameter error: the key must be string instead of %s.", q14.f(propertyType)));
                }
            }
            return q14.b("parameter error: the parameter key is necessary.");
        }
        return (q14) invokeL.objValue;
    }

    public void k(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (m = m(jsObject, "getStorage")) == null) {
            return;
        }
        q14 c = c(m);
        if (c.g()) {
            o14 o14Var = new o14();
            o14Var.errMsg = n14.b("getStorage");
            Object d = c.d();
            o14Var.data = d;
            if (d instanceof JsSerializeValue) {
                ((JsSerializeValue) d).setAutoRelease(false);
            }
            s24.call(n(jsObject), true, o14Var);
            return;
        }
        g(jsObject, "getStorage", m, c);
    }

    public void l(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            os1 n = n(jsObject);
            p14 b = b();
            b.errMsg = n14.b("getStorageInfo");
            s24.call(n, true, b);
        }
    }

    public final String m(JsObject jsObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jsObject, str)) == null) {
            q14 j = j(jsObject);
            if (!j.g()) {
                g(jsObject, str, "", j);
                return null;
            }
            return (String) j.d();
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public final os1 n(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
            os1 F = os1.F(jsObject);
            return F == null ? new os1() : F;
        }
        return (os1) invokeL.objValue;
    }

    public void o(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) || (m = m(jsObject, "removeStorage")) == null) {
            return;
        }
        g(jsObject, "removeStorage", m, e(m));
    }

    public void p(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) || (m = m(jsObject, "setStorage")) == null) {
            return;
        }
        g(jsObject, "setStorage", m, f(m, i(jsObject)));
    }
}
