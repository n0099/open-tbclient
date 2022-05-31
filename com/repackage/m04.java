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
public class m04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r62 a;
    public k04 b;

    public m04(r62 r62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r62Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = r62Var;
        this.b = new k04();
    }

    @NonNull
    public q04 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            db3.h.update();
            return q04.i(null);
        }
        return (q04) invokeV.objValue;
    }

    @NonNull
    public p04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            p04 p04Var = new p04();
            p04Var.keys = n;
            p04Var.currentSize = this.b.m() / 1024;
            p04Var.limitSize = this.b.s() / 1024;
            p04Var.errMsg = n04.b("getStorageInfoSync");
            return p04Var;
        }
        return (p04) invokeV.objValue;
    }

    @NonNull
    public q04 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return q04.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object D = p != null ? this.a.D(Base64.decode(p, 2), true) : null;
            if (D == null) {
                D = q04.h();
            }
            return q04.i(D);
        }
        return (q04) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public q04 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return q04.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            db3.h.update();
            return q04.i(null);
        }
        return (q04) invokeL.objValue;
    }

    @NonNull
    public q04 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return q04.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return q04.i(null);
            } else {
                byte[] O = this.a.O(jsSerializeValue, true);
                d(jsSerializeValue);
                if (O == null) {
                    return q04.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(O, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return q04.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                db3.h.update();
                return t ? q04.i(null) : q04.b("storage error: the storage is invalid.");
            }
        }
        return (q04) invokeLL.objValue;
    }
}
