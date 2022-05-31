package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dm9;
import com.repackage.gl9;
import com.repackage.kl9;
import com.repackage.ll9;
import com.repackage.pk9;
import com.repackage.pp9;
import com.repackage.rp9;
import com.repackage.sl9;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public dm9 b;
    public PBInterstitialListener c;

    public PBInterstitial(Context context, String str) {
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
        Context applicationContext = context.getApplicationContext();
        this.a = str;
        dm9 dm9Var = new dm9(applicationContext, str);
        this.b = dm9Var;
        dm9Var.h = new rp9(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            dm9 dm9Var = this.b;
            dm9Var.e = false;
            dm9Var.c = false;
            dm9Var.d = false;
            pp9 pp9Var = dm9Var.i;
            if (pp9Var != null) {
                pp9Var.b();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            dm9 dm9Var = this.b;
            if (!dm9Var.c()) {
                if (!(dm9Var.d && !dm9Var.e && dm9Var.e() && !dm9Var.f.isShown() && dm9Var.f.isEffective())) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            dm9 dm9Var = this.b;
            if (dm9Var.e() && dm9Var.f.isEffective() && !dm9Var.f.isShown()) {
                dm9Var.b(dm9Var.f);
                return;
            }
            if (dm9Var.i == null) {
                dm9Var.i = new pp9(dm9Var.b, dm9Var.a, L.b);
            }
            dm9Var.i.g = new sl9(dm9Var);
            dm9Var.i.g();
        }
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBInterstitialListener) == null) {
            this.c = pBInterstitialListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            dm9 dm9Var = this.b;
            if (!ll9.H(dm9Var.b)) {
                PBInterstitialListener pBInterstitialListener = dm9Var.h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (dm9Var.g() && dm9Var.c() && dm9Var.e()) {
                dm9Var.c = false;
                pk9.b().d(pk9.c(dm9Var.f.getTraceid(), dm9Var.f.getId(), dm9Var.f.getPid()), dm9Var.g);
                dm9Var.f.setShown(true);
                ll9.l(dm9Var.b, dm9Var.f);
                gl9.a().c(pk9.c(dm9Var.f.getTraceid(), dm9Var.f.getId(), dm9Var.a), dm9Var.f);
                H5Activity.a(dm9Var.b, dm9Var.f, dm9Var.a);
                kl9.b(dm9Var.f.getId() + dm9Var.a, dm9Var);
            }
        }
    }
}
