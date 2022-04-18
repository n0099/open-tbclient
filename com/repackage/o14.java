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
public class o14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t72 a;
    public m14 b;

    public o14(t72 t72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t72Var;
        this.b = new m14();
    }

    @NonNull
    public s14 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            fc3.h.update();
            return s14.i(null);
        }
        return (s14) invokeV.objValue;
    }

    @NonNull
    public r14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            r14 r14Var = new r14();
            r14Var.keys = n;
            r14Var.currentSize = this.b.m() / 1024;
            r14Var.limitSize = this.b.s() / 1024;
            r14Var.errMsg = p14.b("getStorageInfoSync");
            return r14Var;
        }
        return (r14) invokeV.objValue;
    }

    @NonNull
    public s14 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return s14.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object D = p != null ? this.a.D(Base64.decode(p, 2), true) : null;
            if (D == null) {
                D = s14.h();
            }
            return s14.i(D);
        }
        return (s14) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public s14 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return s14.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            fc3.h.update();
            return s14.i(null);
        }
        return (s14) invokeL.objValue;
    }

    @NonNull
    public s14 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return s14.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return s14.i(null);
            } else {
                byte[] O = this.a.O(jsSerializeValue, true);
                d(jsSerializeValue);
                if (O == null) {
                    return s14.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(O, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return s14.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                fc3.h.update();
                return t ? s14.i(null) : s14.b("storage error: the storage is invalid.");
            }
        }
        return (s14) invokeLL.objValue;
    }
}
