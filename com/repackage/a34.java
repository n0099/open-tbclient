package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JsFunction a;
    public JsFunction b;
    public JsFunction c;

    public a34() {
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

    public static a34 d(bt1 bt1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bt1Var)) == null) {
            if (bt1Var == null) {
                return null;
            }
            a34 a34Var = new a34();
            JsFunction u = bt1Var.u("onCheckForUpdate");
            a34Var.a = u;
            if (u != null) {
                u.setReleaseMode(false);
            }
            JsFunction u2 = bt1Var.u("onUpdateReady");
            a34Var.b = u2;
            if (u2 != null) {
                u2.setReleaseMode(false);
            }
            JsFunction u3 = bt1Var.u("onUpdateFailed");
            a34Var.c = u3;
            if (u3 != null) {
                u3.setReleaseMode(false);
            }
            return a34Var;
        }
        return (a34) invokeL.objValue;
    }

    public void a(b34 b34Var) {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, b34Var) == null) || (jsFunction = this.a) == null) {
            return;
        }
        jsFunction.call(b34Var);
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
