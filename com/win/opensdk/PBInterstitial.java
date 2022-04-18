package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ap9;
import com.repackage.au9;
import com.repackage.cu9;
import com.repackage.dq9;
import com.repackage.oq9;
import com.repackage.rp9;
import com.repackage.vp9;
import com.repackage.wp9;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes8.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public oq9 b;
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
        oq9 oq9Var = new oq9(applicationContext, str);
        this.b = oq9Var;
        oq9Var.h = new cu9(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            oq9 oq9Var = this.b;
            oq9Var.e = false;
            oq9Var.c = false;
            oq9Var.d = false;
            au9 au9Var = oq9Var.i;
            if (au9Var != null) {
                au9Var.b();
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
            oq9 oq9Var = this.b;
            if (!oq9Var.c()) {
                if (!(oq9Var.d && !oq9Var.e && oq9Var.e() && !oq9Var.f.isShown() && oq9Var.f.isEffective())) {
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
            oq9 oq9Var = this.b;
            if (oq9Var.e() && oq9Var.f.isEffective() && !oq9Var.f.isShown()) {
                oq9Var.b(oq9Var.f);
                return;
            }
            if (oq9Var.i == null) {
                oq9Var.i = new au9(oq9Var.b, oq9Var.a, L.b);
            }
            oq9Var.i.g = new dq9(oq9Var);
            oq9Var.i.g();
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
            oq9 oq9Var = this.b;
            if (!wp9.H(oq9Var.b)) {
                PBInterstitialListener pBInterstitialListener = oq9Var.h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (oq9Var.g() && oq9Var.c() && oq9Var.e()) {
                oq9Var.c = false;
                ap9.b().d(ap9.c(oq9Var.f.getTraceid(), oq9Var.f.getId(), oq9Var.f.getPid()), oq9Var.g);
                oq9Var.f.setShown(true);
                wp9.l(oq9Var.b, oq9Var.f);
                rp9.a().c(ap9.c(oq9Var.f.getTraceid(), oq9Var.f.getId(), oq9Var.a), oq9Var.f);
                H5Activity.a(oq9Var.b, oq9Var.f, oq9Var.a);
                vp9.b(oq9Var.f.getId() + oq9Var.a, oq9Var);
            }
        }
    }
}
