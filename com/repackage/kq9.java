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
public class kq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xt9 a;
    public lq9 b;

    public kq9(Context context, String str) {
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
        xt9 xt9Var = new xt9(context.getApplicationContext(), str);
        this.a = xt9Var;
        xt9Var.h = new lo9(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xt9 xt9Var = this.a;
            xt9Var.e = false;
            xt9Var.c = false;
            xt9Var.d = false;
            au9 au9Var = xt9Var.i;
            if (au9Var != null) {
                au9Var.b();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            xt9 xt9Var = this.a;
            if (!xt9Var.c()) {
                if (!(xt9Var.d && !xt9Var.e && xt9Var.e() && !xt9Var.f.isShown() && xt9Var.f.isEffective())) {
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
            xt9 xt9Var = this.a;
            if (xt9Var.e() && xt9Var.f.isEffective() && !xt9Var.f.isShown()) {
                xt9Var.a(xt9Var.f);
                return;
            }
            if (xt9Var.i == null) {
                xt9Var.i = new au9(xt9Var.b, xt9Var.a, L.d);
            }
            xt9Var.i.g = new pt9(xt9Var);
            xt9Var.i.g();
        }
    }

    public void d(lq9 lq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lq9Var) == null) {
            this.b = lq9Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xt9 xt9Var = this.a;
            if (!wp9.H(xt9Var.b)) {
                lq9 lq9Var = xt9Var.h;
                if (lq9Var != null) {
                    lq9Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (xt9Var.g() && xt9Var.c() && xt9Var.e()) {
                xt9Var.c = false;
                ap9.b().d(ap9.c(xt9Var.f.getTraceid(), xt9Var.f.getId(), xt9Var.f.getPid()), xt9Var.g);
                xt9Var.f.setShown(true);
                wp9.l(xt9Var.b, xt9Var.f);
                rp9.a().c(ap9.c(xt9Var.f.getTraceid(), xt9Var.f.getId(), xt9Var.a), xt9Var.f);
                H5Activity.a(xt9Var.b, xt9Var.f, xt9Var.a);
                vp9.b(xt9Var.f.getId() + xt9Var.a, xt9Var);
            }
        }
    }
}
