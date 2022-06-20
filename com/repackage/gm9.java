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
public class gm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tp9 a;
    public hm9 b;

    public gm9(Context context, String str) {
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
        tp9 tp9Var = new tp9(context.getApplicationContext(), str);
        this.a = tp9Var;
        tp9Var.h = new hk9(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tp9 tp9Var = this.a;
            tp9Var.e = false;
            tp9Var.c = false;
            tp9Var.d = false;
            wp9 wp9Var = tp9Var.i;
            if (wp9Var != null) {
                wp9Var.b();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            tp9 tp9Var = this.a;
            if (!tp9Var.d()) {
                if (!(tp9Var.d && !tp9Var.e && tp9Var.f() && !tp9Var.f.isShown() && tp9Var.f.isEffective())) {
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
            tp9 tp9Var = this.a;
            if (tp9Var.f() && tp9Var.f.isEffective() && !tp9Var.f.isShown()) {
                tp9Var.b(tp9Var.f);
                return;
            }
            if (tp9Var.i == null) {
                tp9Var.i = new wp9(tp9Var.b, tp9Var.a, L.d);
            }
            tp9Var.i.g = new lp9(tp9Var);
            tp9Var.i.g();
        }
    }

    public void d(hm9 hm9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hm9Var) == null) {
            this.b = hm9Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            tp9 tp9Var = this.a;
            if (!sl9.H(tp9Var.b)) {
                hm9 hm9Var = tp9Var.h;
                if (hm9Var != null) {
                    hm9Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (tp9Var.h() && tp9Var.d() && tp9Var.f()) {
                tp9Var.c = false;
                wk9.b().d(wk9.c(tp9Var.f.getTraceid(), tp9Var.f.getId(), tp9Var.f.getPid()), tp9Var.g);
                tp9Var.f.setShown(true);
                sl9.l(tp9Var.b, tp9Var.f);
                nl9.a().c(wk9.c(tp9Var.f.getTraceid(), tp9Var.f.getId(), tp9Var.a), tp9Var.f);
                H5Activity.c(tp9Var.b, tp9Var.f, tp9Var.a);
                rl9.b(tp9Var.f.getId() + tp9Var.a, tp9Var);
            }
        }
    }
}
