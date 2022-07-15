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
public class m14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r72 a;
    public k14 b;

    public m14(r72 r72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = r72Var;
        this.b = new k14();
    }

    @NonNull
    public q14 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            dc3.h.update();
            return q14.i(null);
        }
        return (q14) invokeV.objValue;
    }

    @NonNull
    public p14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            p14 p14Var = new p14();
            p14Var.keys = n;
            p14Var.currentSize = this.b.m() / 1024;
            p14Var.limitSize = this.b.s() / 1024;
            p14Var.errMsg = n14.b("getStorageInfoSync");
            return p14Var;
        }
        return (p14) invokeV.objValue;
    }

    @NonNull
    public q14 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return q14.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object C = p != null ? this.a.C(Base64.decode(p, 2), true) : null;
            if (C == null) {
                C = q14.h();
            }
            return q14.i(C);
        }
        return (q14) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public q14 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return q14.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            dc3.h.update();
            return q14.i(null);
        }
        return (q14) invokeL.objValue;
    }

    @NonNull
    public q14 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return q14.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return q14.i(null);
            } else {
                byte[] K = this.a.K(jsSerializeValue, true);
                d(jsSerializeValue);
                if (K == null) {
                    return q14.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(K, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return q14.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                dc3.h.update();
                return t ? q14.i(null) : q14.b("storage error: the storage is invalid.");
            }
        }
        return (q14) invokeLL.objValue;
    }
}
