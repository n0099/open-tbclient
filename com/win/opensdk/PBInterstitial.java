package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.km9;
import com.repackage.nl9;
import com.repackage.rl9;
import com.repackage.sl9;
import com.repackage.wk9;
import com.repackage.wp9;
import com.repackage.yp9;
import com.repackage.zl9;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes8.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public km9 b;
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
        km9 km9Var = new km9(applicationContext, str);
        this.b = km9Var;
        km9Var.h = new yp9(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            km9 km9Var = this.b;
            km9Var.e = false;
            km9Var.c = false;
            km9Var.d = false;
            wp9 wp9Var = km9Var.i;
            if (wp9Var != null) {
                wp9Var.b();
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
            km9 km9Var = this.b;
            if (!km9Var.d()) {
                if (!(km9Var.d && !km9Var.e && km9Var.f() && !km9Var.f.isShown() && km9Var.f.isEffective())) {
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
            km9 km9Var = this.b;
            if (km9Var.f() && km9Var.f.isEffective() && !km9Var.f.isShown()) {
                km9Var.c(km9Var.f);
                return;
            }
            if (km9Var.i == null) {
                km9Var.i = new wp9(km9Var.b, km9Var.a, L.b);
            }
            km9Var.i.g = new zl9(km9Var);
            km9Var.i.g();
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
            km9 km9Var = this.b;
            if (!sl9.H(km9Var.b)) {
                PBInterstitialListener pBInterstitialListener = km9Var.h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (km9Var.h() && km9Var.d() && km9Var.f()) {
                km9Var.c = false;
                wk9.b().d(wk9.c(km9Var.f.getTraceid(), km9Var.f.getId(), km9Var.f.getPid()), km9Var.g);
                km9Var.f.setShown(true);
                sl9.l(km9Var.b, km9Var.f);
                nl9.a().c(wk9.c(km9Var.f.getTraceid(), km9Var.f.getId(), km9Var.a), km9Var.f);
                H5Activity.c(km9Var.b, km9Var.f, km9Var.a);
                rl9.b(km9Var.f.getId() + km9Var.a, km9Var);
            }
        }
    }
}
