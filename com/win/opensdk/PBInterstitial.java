package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jp9;
import com.repackage.mo9;
import com.repackage.qo9;
import com.repackage.ro9;
import com.repackage.vn9;
import com.repackage.vs9;
import com.repackage.xs9;
import com.repackage.yo9;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes8.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public jp9 b;
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
        jp9 jp9Var = new jp9(applicationContext, str);
        this.b = jp9Var;
        jp9Var.h = new xs9(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jp9 jp9Var = this.b;
            jp9Var.e = false;
            jp9Var.c = false;
            jp9Var.d = false;
            vs9 vs9Var = jp9Var.i;
            if (vs9Var != null) {
                vs9Var.b();
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
            jp9 jp9Var = this.b;
            if (!jp9Var.c()) {
                if (!(jp9Var.d && !jp9Var.e && jp9Var.e() && !jp9Var.f.isShown() && jp9Var.f.isEffective())) {
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
            jp9 jp9Var = this.b;
            if (jp9Var.e() && jp9Var.f.isEffective() && !jp9Var.f.isShown()) {
                jp9Var.b(jp9Var.f);
                return;
            }
            if (jp9Var.i == null) {
                jp9Var.i = new vs9(jp9Var.b, jp9Var.a, L.b);
            }
            jp9Var.i.g = new yo9(jp9Var);
            jp9Var.i.g();
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
            jp9 jp9Var = this.b;
            if (!ro9.H(jp9Var.b)) {
                PBInterstitialListener pBInterstitialListener = jp9Var.h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (jp9Var.g() && jp9Var.c() && jp9Var.e()) {
                jp9Var.c = false;
                vn9.b().d(vn9.c(jp9Var.f.getTraceid(), jp9Var.f.getId(), jp9Var.f.getPid()), jp9Var.g);
                jp9Var.f.setShown(true);
                ro9.l(jp9Var.b, jp9Var.f);
                mo9.a().c(vn9.c(jp9Var.f.getTraceid(), jp9Var.f.getId(), jp9Var.a), jp9Var.f);
                H5Activity.a(jp9Var.b, jp9Var.f, jp9Var.a);
                qo9.b(jp9Var.f.getId() + jp9Var.a, jp9Var);
            }
        }
    }
}
