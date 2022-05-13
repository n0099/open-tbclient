package com.repackage;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBMediaView;
/* loaded from: classes6.dex */
public class on9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public un9 a;
    public sn9 b;

    public on9(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        un9 un9Var = new un9(context, str);
        this.a = un9Var;
        un9Var.f = new kn9(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.a != null) {
                    this.a.b();
                    this.a = null;
                }
                if (this.b != null) {
                    this.b = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void b(View view2, PBMediaView pBMediaView) {
        un9 un9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, pBMediaView) == null) || (un9Var = this.a) == null) {
            return;
        }
        un9Var.c(view2, pBMediaView);
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            un9 un9Var = this.a;
            return (un9Var == null || !un9Var.f()) ? "" : un9Var.c.getLoad_type();
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            un9 un9Var = this.a;
            return un9Var != null && un9Var.f();
        }
        return invokeV.booleanValue;
    }
}
