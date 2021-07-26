package d.a.o0.h.g0;

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
/* loaded from: classes7.dex */
public class b extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.o0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.l0.c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(JsObject jsObject, String str, String str2, d.a.o0.h.g0.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jsObject, str, str2, dVar) == null) {
            d.a.o0.a.y.b.a n = n(jsObject);
            d.a.o0.h.d.c.b bVar = new d.a.o0.h.d.c.b();
            boolean g2 = dVar.g();
            bVar.errMsg = dVar.c(str, str2);
            d.a.o0.h.m0.c.a(n, g2, bVar);
            if (g2) {
                return;
            }
            d.a.o0.h.f0.e.i(str2, bVar.errMsg);
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
            for (int i2 = 0; i2 < jsObject.length(); i2++) {
                if ("data".equals(jsObject.getPropertyName(i2))) {
                    return jsObject.toSerializeValue(i2);
                }
            }
            return null;
        }
        return (JsSerializeValue) invokeL.objValue;
    }

    public final d.a.o0.h.g0.f.d j(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            for (int i2 = 0; i2 < jsObject.length(); i2++) {
                if ("key".equals(jsObject.getPropertyName(i2))) {
                    int propertyType = jsObject.getPropertyType(i2);
                    return propertyType == 7 ? d.a.o0.h.g0.f.d.i(jsObject.toString(i2)) : d.a.o0.h.g0.f.d.b(String.format("parameter error: the key must be string instead of %s.", d.a.o0.h.g0.f.d.f(propertyType)));
                }
            }
            return d.a.o0.h.g0.f.d.b("parameter error: the parameter key is necessary.");
        }
        return (d.a.o0.h.g0.f.d) invokeL.objValue;
    }

    public void k(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (m = m(jsObject, "getStorage")) == null) {
            return;
        }
        d.a.o0.h.g0.f.d c2 = c(m);
        if (c2.g()) {
            d.a.o0.h.g0.f.b bVar = new d.a.o0.h.g0.f.b();
            bVar.errMsg = d.a.o0.h.g0.f.a.b("getStorage");
            Object d2 = c2.d();
            bVar.data = d2;
            if (d2 instanceof JsSerializeValue) {
                ((JsSerializeValue) d2).setAutoRelease(false);
            }
            d.a.o0.h.m0.c.a(n(jsObject), true, bVar);
            return;
        }
        g(jsObject, "getStorage", m, c2);
    }

    public void l(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            d.a.o0.a.y.b.a n = n(jsObject);
            d.a.o0.h.g0.f.c b2 = b();
            b2.errMsg = d.a.o0.h.g0.f.a.b("getStorageInfo");
            d.a.o0.h.m0.c.a(n, true, b2);
        }
    }

    public final String m(JsObject jsObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jsObject, str)) == null) {
            d.a.o0.h.g0.f.d j = j(jsObject);
            if (!j.g()) {
                g(jsObject, str, "", j);
                return null;
            }
            return (String) j.d();
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public final d.a.o0.a.y.b.a n(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
            d.a.o0.a.y.b.a G = d.a.o0.a.y.b.a.G(jsObject);
            return G == null ? new d.a.o0.a.y.b.a() : G;
        }
        return (d.a.o0.a.y.b.a) invokeL.objValue;
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
