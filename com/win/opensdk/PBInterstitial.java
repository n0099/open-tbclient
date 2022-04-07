package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hq9;
import com.repackage.kp9;
import com.repackage.op9;
import com.repackage.pp9;
import com.repackage.to9;
import com.repackage.tt9;
import com.repackage.vt9;
import com.repackage.wp9;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes8.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public hq9 b;
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
        hq9 hq9Var = new hq9(applicationContext, str);
        this.b = hq9Var;
        hq9Var.h = new vt9(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hq9 hq9Var = this.b;
            hq9Var.e = false;
            hq9Var.c = false;
            hq9Var.d = false;
            tt9 tt9Var = hq9Var.i;
            if (tt9Var != null) {
                tt9Var.b();
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
            hq9 hq9Var = this.b;
            if (!hq9Var.c()) {
                if (!(hq9Var.d && !hq9Var.e && hq9Var.e() && !hq9Var.f.isShown() && hq9Var.f.isEffective())) {
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
            hq9 hq9Var = this.b;
            if (hq9Var.e() && hq9Var.f.isEffective() && !hq9Var.f.isShown()) {
                hq9Var.b(hq9Var.f);
                return;
            }
            if (hq9Var.i == null) {
                hq9Var.i = new tt9(hq9Var.b, hq9Var.a, L.b);
            }
            hq9Var.i.g = new wp9(hq9Var);
            hq9Var.i.g();
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
            hq9 hq9Var = this.b;
            if (!pp9.H(hq9Var.b)) {
                PBInterstitialListener pBInterstitialListener = hq9Var.h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (hq9Var.g() && hq9Var.c() && hq9Var.e()) {
                hq9Var.c = false;
                to9.b().d(to9.c(hq9Var.f.getTraceid(), hq9Var.f.getId(), hq9Var.f.getPid()), hq9Var.g);
                hq9Var.f.setShown(true);
                pp9.l(hq9Var.b, hq9Var.f);
                kp9.a().c(to9.c(hq9Var.f.getTraceid(), hq9Var.f.getId(), hq9Var.a), hq9Var.f);
                H5Activity.a(hq9Var.b, hq9Var.f, hq9Var.a);
                op9.b(hq9Var.f.getId() + hq9Var.a, hq9Var);
            }
        }
    }
}
