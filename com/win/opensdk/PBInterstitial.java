package com.win.opensdk;

import android.content.Context;
import c.q.a.a5;
import c.q.a.c5;
import c.q.a.m0;
import c.q.a.o1;
import c.q.a.q0;
import c.q.a.r0;
import c.q.a.v;
import c.q.a.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes4.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public o1 f60802b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f60803c;

    public PBInterstitial(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        this.a = str;
        o1 o1Var = new o1(applicationContext, str);
        this.f60802b = o1Var;
        o1Var.l = new c5(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o1 o1Var = this.f60802b;
            o1Var.f30401i = false;
            o1Var.f30399g = false;
            o1Var.f30400h = false;
            a5 a5Var = o1Var.m;
            if (a5Var != null) {
                a5Var.b();
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
            o1 o1Var = this.f60802b;
            if (!o1Var.c()) {
                if (!(o1Var.f30400h && !o1Var.f30401i && o1Var.e() && !o1Var.f30402j.isShown() && o1Var.f30402j.isEffective())) {
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
            o1 o1Var = this.f60802b;
            if (o1Var.e() && o1Var.f30402j.isEffective() && !o1Var.f30402j.isShown()) {
                o1Var.b(o1Var.f30402j);
                return;
            }
            if (o1Var.m == null) {
                o1Var.m = new a5(o1Var.f30398f, o1Var.f30397e, L.f60795b);
            }
            o1Var.m.f30275g = new y0(o1Var);
            o1Var.m.g();
        }
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBInterstitialListener) == null) {
            this.f60803c = pBInterstitialListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o1 o1Var = this.f60802b;
            if (!r0.H(o1Var.f30398f)) {
                PBInterstitialListener pBInterstitialListener = o1Var.l;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (o1Var.g() && o1Var.c() && o1Var.e()) {
                o1Var.f30399g = false;
                v.b().d(v.c(o1Var.f30402j.getTraceid(), o1Var.f30402j.getId(), o1Var.f30402j.getPid()), o1Var.k);
                o1Var.f30402j.setShown(true);
                r0.l(o1Var.f30398f, o1Var.f30402j);
                m0.a().c(v.c(o1Var.f30402j.getTraceid(), o1Var.f30402j.getId(), o1Var.f30397e), o1Var.f30402j);
                H5Activity.a(o1Var.f30398f, o1Var.f30402j, o1Var.f30397e);
                q0.b(o1Var.f30402j.getId() + o1Var.f30397e, o1Var);
            }
        }
    }
}
