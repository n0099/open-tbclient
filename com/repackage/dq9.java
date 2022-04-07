package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.L;
import com.win.opensdk.PBError;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes5.dex */
public class dq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qt9 a;
    public eq9 b;

    public dq9(Context context, String str) {
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
        qt9 qt9Var = new qt9(context.getApplicationContext(), str);
        this.a = qt9Var;
        qt9Var.h = new eo9(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            qt9 qt9Var = this.a;
            qt9Var.e = false;
            qt9Var.c = false;
            qt9Var.d = false;
            tt9 tt9Var = qt9Var.i;
            if (tt9Var != null) {
                tt9Var.b();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            qt9 qt9Var = this.a;
            if (!qt9Var.c()) {
                if (!(qt9Var.d && !qt9Var.e && qt9Var.e() && !qt9Var.f.isShown() && qt9Var.f.isEffective())) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            qt9 qt9Var = this.a;
            if (qt9Var.e() && qt9Var.f.isEffective() && !qt9Var.f.isShown()) {
                qt9Var.a(qt9Var.f);
                return;
            }
            if (qt9Var.i == null) {
                qt9Var.i = new tt9(qt9Var.b, qt9Var.a, L.d);
            }
            qt9Var.i.g = new it9(qt9Var);
            qt9Var.i.g();
        }
    }

    public void d(eq9 eq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eq9Var) == null) {
            this.b = eq9Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            qt9 qt9Var = this.a;
            if (!pp9.H(qt9Var.b)) {
                eq9 eq9Var = qt9Var.h;
                if (eq9Var != null) {
                    eq9Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (qt9Var.g() && qt9Var.c() && qt9Var.e()) {
                qt9Var.c = false;
                to9.b().d(to9.c(qt9Var.f.getTraceid(), qt9Var.f.getId(), qt9Var.f.getPid()), qt9Var.g);
                qt9Var.f.setShown(true);
                pp9.l(qt9Var.b, qt9Var.f);
                kp9.a().c(to9.c(qt9Var.f.getTraceid(), qt9Var.f.getId(), qt9Var.a), qt9Var.f);
                H5Activity.a(qt9Var.b, qt9Var.f, qt9Var.a);
                op9.b(qt9Var.f.getId() + qt9Var.a, qt9Var);
            }
        }
    }
}
