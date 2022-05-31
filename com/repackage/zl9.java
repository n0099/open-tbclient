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
/* loaded from: classes7.dex */
public class zl9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mp9 a;
    public am9 b;

    public zl9(Context context, String str) {
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
        mp9 mp9Var = new mp9(context.getApplicationContext(), str);
        this.a = mp9Var;
        mp9Var.h = new ak9(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            mp9 mp9Var = this.a;
            mp9Var.e = false;
            mp9Var.c = false;
            mp9Var.d = false;
            pp9 pp9Var = mp9Var.i;
            if (pp9Var != null) {
                pp9Var.b();
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            mp9 mp9Var = this.a;
            if (!mp9Var.c()) {
                if (!(mp9Var.d && !mp9Var.e && mp9Var.e() && !mp9Var.f.isShown() && mp9Var.f.isEffective())) {
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
            mp9 mp9Var = this.a;
            if (mp9Var.e() && mp9Var.f.isEffective() && !mp9Var.f.isShown()) {
                mp9Var.a(mp9Var.f);
                return;
            }
            if (mp9Var.i == null) {
                mp9Var.i = new pp9(mp9Var.b, mp9Var.a, L.d);
            }
            mp9Var.i.g = new ep9(mp9Var);
            mp9Var.i.g();
        }
    }

    public void d(am9 am9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, am9Var) == null) {
            this.b = am9Var;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            mp9 mp9Var = this.a;
            if (!ll9.H(mp9Var.b)) {
                am9 am9Var = mp9Var.h;
                if (am9Var != null) {
                    am9Var.d(PBError.NO_NETWORK.getMsg());
                }
            } else if (mp9Var.g() && mp9Var.c() && mp9Var.e()) {
                mp9Var.c = false;
                pk9.b().d(pk9.c(mp9Var.f.getTraceid(), mp9Var.f.getId(), mp9Var.f.getPid()), mp9Var.g);
                mp9Var.f.setShown(true);
                ll9.l(mp9Var.b, mp9Var.f);
                gl9.a().c(pk9.c(mp9Var.f.getTraceid(), mp9Var.f.getId(), mp9Var.a), mp9Var.f);
                H5Activity.a(mp9Var.b, mp9Var.f, mp9Var.a);
                kl9.b(mp9Var.f.getId() + mp9Var.a, mp9Var);
            }
        }
    }
}
