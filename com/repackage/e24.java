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
/* loaded from: classes6.dex */
public class e24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j82 a;
    public c24 b;

    public e24(j82 j82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j82Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j82Var;
        this.b = new c24();
    }

    @NonNull
    public i24 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            vc3.h.update();
            return i24.i(null);
        }
        return (i24) invokeV.objValue;
    }

    @NonNull
    public h24 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            h24 h24Var = new h24();
            h24Var.keys = n;
            h24Var.currentSize = this.b.m() / 1024;
            h24Var.limitSize = this.b.s() / 1024;
            h24Var.errMsg = f24.b("getStorageInfoSync");
            return h24Var;
        }
        return (h24) invokeV.objValue;
    }

    @NonNull
    public i24 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return i24.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object A = p != null ? this.a.A(Base64.decode(p, 2), true) : null;
            if (A == null) {
                A = i24.h();
            }
            return i24.i(A);
        }
        return (i24) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public i24 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return i24.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            vc3.h.update();
            return i24.i(null);
        }
        return (i24) invokeL.objValue;
    }

    @NonNull
    public i24 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return i24.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return i24.i(null);
            } else {
                byte[] I = this.a.I(jsSerializeValue, true);
                d(jsSerializeValue);
                if (I == null) {
                    return i24.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(I, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return i24.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                vc3.h.update();
                return t ? i24.i(null) : i24.b("storage error: the storage is invalid.");
            }
        }
        return (i24) invokeLL.objValue;
    }
}
