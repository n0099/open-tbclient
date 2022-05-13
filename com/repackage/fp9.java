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
/* loaded from: classes6.dex */
public class fp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ss9 a;
    public gp9 b;

    public fp9(Context context, String str) {
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
        ss9 ss9Var = new ss9(context.getApplicationContext(), str);
        this.a = ss9Var;
        ss9Var.h = new gn9(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ss9 ss9Var = this.a;
            ss9Var.e = false;
            ss9Var.c = false;
            ss9Var.d = false;
            vs9 vs9Var = ss9Var.i;
            if (vs9Var != null) {
                vs9Var.b();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ss9 ss9Var = this.a;
            if (!ss9Var.c()) {
                if (!(ss9Var.d && !ss9Var.e && ss9Var.e() && !ss9Var.f.isShown() && ss9Var.f.isEffective())) {
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
            ss9 ss9Var = this.a;
            if (ss9Var.e() && ss9Var.f.isEffective() && !ss9Var.f.isShown()) {
                ss9Var.a(ss9Var.f);
                return;
            }
            if (ss9Var.i == null) {
                ss9Var.i = new vs9(ss9Var.b, ss9Var.a, L.d);
            }
            ss9Var.i.g = new ks9(ss9Var);
            ss9Var.i.g();
        }
    }

    public void d(gp9 gp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gp9Var) == null) {
            this.b = gp9Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ss9 ss9Var = this.a;
            if (!ro9.H(ss9Var.b)) {
                gp9 gp9Var = ss9Var.h;
                if (gp9Var != null) {
                    gp9Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (ss9Var.g() && ss9Var.c() && ss9Var.e()) {
                ss9Var.c = false;
                vn9.b().d(vn9.c(ss9Var.f.getTraceid(), ss9Var.f.getId(), ss9Var.f.getPid()), ss9Var.g);
                ss9Var.f.setShown(true);
                ro9.l(ss9Var.b, ss9Var.f);
                mo9.a().c(vn9.c(ss9Var.f.getTraceid(), ss9Var.f.getId(), ss9Var.a), ss9Var.f);
                H5Activity.a(ss9Var.b, ss9Var.f, ss9Var.a);
                qo9.b(ss9Var.f.getId() + ss9Var.a, ss9Var);
            }
        }
    }
}
