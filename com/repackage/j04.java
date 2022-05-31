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
public class j04 extends m04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j04(r62 r62Var) {
        super(r62Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r62Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r62) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(JsObject jsObject, String str, String str2, q04 q04Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jsObject, str, str2, q04Var) == null) {
            or1 n = n(jsObject);
            pt3 pt3Var = new pt3();
            boolean g = q04Var.g();
            pt3Var.errMsg = q04Var.c(str, str2);
            s14.call(n, g, pt3Var);
            if (g) {
                return;
            }
            a04.i(str2, pt3Var.errMsg);
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

    public final q04 j(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            for (int i = 0; i < jsObject.length(); i++) {
                if ("key".equals(jsObject.getPropertyName(i))) {
                    int propertyType = jsObject.getPropertyType(i);
                    return propertyType == 7 ? q04.i(jsObject.toString(i)) : q04.b(String.format("parameter error: the key must be string instead of %s.", q04.f(propertyType)));
                }
            }
            return q04.b("parameter error: the parameter key is necessary.");
        }
        return (q04) invokeL.objValue;
    }

    public void k(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (m = m(jsObject, "getStorage")) == null) {
            return;
        }
        q04 c = c(m);
        if (c.g()) {
            o04 o04Var = new o04();
            o04Var.errMsg = n04.b("getStorage");
            Object d = c.d();
            o04Var.data = d;
            if (d instanceof JsSerializeValue) {
                ((JsSerializeValue) d).setAutoRelease(false);
            }
            s14.call(n(jsObject), true, o04Var);
            return;
        }
        g(jsObject, "getStorage", m, c);
    }

    public void l(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            or1 n = n(jsObject);
            p04 b = b();
            b.errMsg = n04.b("getStorageInfo");
            s14.call(n, true, b);
        }
    }

    public final String m(JsObject jsObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jsObject, str)) == null) {
            q04 j = j(jsObject);
            if (!j.g()) {
                g(jsObject, str, "", j);
                return null;
            }
            return (String) j.d();
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public final or1 n(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
            or1 F = or1.F(jsObject);
            return F == null ? new or1() : F;
        }
        return (or1) invokeL.objValue;
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
