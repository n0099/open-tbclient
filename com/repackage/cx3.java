package com.repackage;

import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class cx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c82 a;

    public cx3() {
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

    public boolean a(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            c82 c82Var = this.a;
            if (c82Var == null) {
                return false;
            }
            boolean f = dx3.f(c82Var.p());
            boolean f2 = dx3.f(this.a.x());
            JSEvent jSEvent = null;
            if (f || f2) {
                jSEvent = dx3.j(motionEvent);
            }
            boolean dispatchEvent = f ? this.a.dispatchEvent(jSEvent) : false;
            if (f2 && this.a.w0()) {
                this.a.x().dispatchEvent(jSEvent);
            }
            dx3.g(true);
            return dispatchEvent;
        }
        return invokeL.booleanValue;
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            dx3.m(i, i2);
        }
    }

    public void c(c82 c82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c82Var) == null) {
            this.a = c82Var;
        }
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            dx3.l(i, i2);
        }
    }
}
