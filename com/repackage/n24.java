package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class n24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JsFunction a;
    public JsFunction b;
    public JsFunction c;

    public n24() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static n24 d(os1 os1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, os1Var)) == null) {
            if (os1Var == null) {
                return null;
            }
            n24 n24Var = new n24();
            JsFunction u = os1Var.u("onCheckForUpdate");
            n24Var.a = u;
            if (u != null) {
                u.setReleaseMode(false);
            }
            JsFunction u2 = os1Var.u("onUpdateReady");
            n24Var.b = u2;
            if (u2 != null) {
                u2.setReleaseMode(false);
            }
            JsFunction u3 = os1Var.u("onUpdateFailed");
            n24Var.c = u3;
            if (u3 != null) {
                u3.setReleaseMode(false);
            }
            return n24Var;
        }
        return (n24) invokeL.objValue;
    }

    public void a(o24 o24Var) {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, o24Var) == null) || (jsFunction = this.a) == null) {
            return;
        }
        jsFunction.call(o24Var);
    }

    public void b() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jsFunction = this.c) == null) {
            return;
        }
        jsFunction.call();
    }

    public void c() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (jsFunction = this.b) == null) {
            return;
        }
        jsFunction.call();
    }
}
