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
public class x04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c72 a;
    public v04 b;

    public x04(c72 c72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = c72Var;
        this.b = new v04();
    }

    @NonNull
    public b14 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            ob3.h.update();
            return b14.i(null);
        }
        return (b14) invokeV.objValue;
    }

    @NonNull
    public a14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            a14 a14Var = new a14();
            a14Var.keys = n;
            a14Var.currentSize = this.b.m() / 1024;
            a14Var.limitSize = this.b.s() / 1024;
            a14Var.errMsg = y04.b("getStorageInfoSync");
            return a14Var;
        }
        return (a14) invokeV.objValue;
    }

    @NonNull
    public b14 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return b14.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object D = p != null ? this.a.D(Base64.decode(p, 2), true) : null;
            if (D == null) {
                D = b14.h();
            }
            return b14.i(D);
        }
        return (b14) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public b14 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return b14.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            ob3.h.update();
            return b14.i(null);
        }
        return (b14) invokeL.objValue;
    }

    @NonNull
    public b14 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return b14.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return b14.i(null);
            } else {
                byte[] O = this.a.O(jsSerializeValue, true);
                d(jsSerializeValue);
                if (O == null) {
                    return b14.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(O, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return b14.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                ob3.h.update();
                return t ? b14.i(null) : b14.b("storage error: the storage is invalid.");
            }
        }
        return (b14) invokeLL.objValue;
    }
}
