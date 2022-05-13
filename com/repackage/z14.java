package com.repackage;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e82 a;
    public x14 b;

    public z14(e82 e82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e82Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = e82Var;
        this.b = new x14();
    }

    @NonNull
    public d24 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            qc3.h.update();
            return d24.i(null);
        }
        return (d24) invokeV.objValue;
    }

    @NonNull
    public c24 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            c24 c24Var = new c24();
            c24Var.keys = n;
            c24Var.currentSize = this.b.m() / 1024;
            c24Var.limitSize = this.b.s() / 1024;
            c24Var.errMsg = a24.b("getStorageInfoSync");
            return c24Var;
        }
        return (c24) invokeV.objValue;
    }

    @NonNull
    public d24 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return d24.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object D = p != null ? this.a.D(Base64.decode(p, 2), true) : null;
            if (D == null) {
                D = d24.h();
            }
            return d24.i(D);
        }
        return (d24) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public d24 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return d24.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            qc3.h.update();
            return d24.i(null);
        }
        return (d24) invokeL.objValue;
    }

    @NonNull
    public d24 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return d24.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return d24.i(null);
            } else {
                byte[] O = this.a.O(jsSerializeValue, true);
                d(jsSerializeValue);
                if (O == null) {
                    return d24.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(O, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return d24.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                qc3.h.update();
                return t ? d24.i(null) : d24.b("storage error: the storage is invalid.");
            }
        }
        return (d24) invokeLL.objValue;
    }
}
