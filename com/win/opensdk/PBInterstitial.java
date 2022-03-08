package com.win.opensdk;

import android.content.Context;
import c.q.a.j1;
import c.q.a.m0;
import c.q.a.q0;
import c.q.a.r0;
import c.q.a.v;
import c.q.a.v4;
import c.q.a.x4;
import c.q.a.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes8.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public j1 f59364b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f59365c;

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
        j1 j1Var = new j1(applicationContext, str);
        this.f59364b = j1Var;
        j1Var.l = new x4(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j1 j1Var = this.f59364b;
            j1Var.f29001i = false;
            j1Var.f28999g = false;
            j1Var.f29000h = false;
            v4 v4Var = j1Var.m;
            if (v4Var != null) {
                v4Var.b();
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
            j1 j1Var = this.f59364b;
            if (!j1Var.c()) {
                if (!(j1Var.f29000h && !j1Var.f29001i && j1Var.e() && !j1Var.f29002j.isShown() && j1Var.f29002j.isEffective())) {
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
            j1 j1Var = this.f59364b;
            if (j1Var.e() && j1Var.f29002j.isEffective() && !j1Var.f29002j.isShown()) {
                j1Var.b(j1Var.f29002j);
                return;
            }
            if (j1Var.m == null) {
                j1Var.m = new v4(j1Var.f28998f, j1Var.f28997e, L.f59357b);
            }
            j1Var.m.f29158g = new y0(j1Var);
            j1Var.m.g();
        }
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBInterstitialListener) == null) {
            this.f59365c = pBInterstitialListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j1 j1Var = this.f59364b;
            if (!r0.H(j1Var.f28998f)) {
                PBInterstitialListener pBInterstitialListener = j1Var.l;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (j1Var.g() && j1Var.c() && j1Var.e()) {
                j1Var.f28999g = false;
                v.b().d(v.c(j1Var.f29002j.getTraceid(), j1Var.f29002j.getId(), j1Var.f29002j.getPid()), j1Var.k);
                j1Var.f29002j.setShown(true);
                r0.l(j1Var.f28998f, j1Var.f29002j);
                m0.a().c(v.c(j1Var.f29002j.getTraceid(), j1Var.f29002j.getId(), j1Var.f28997e), j1Var.f29002j);
                H5Activity.a(j1Var.f28998f, j1Var.f29002j, j1Var.f28997e);
                q0.b(j1Var.f29002j.getId() + j1Var.f28997e, j1Var);
            }
        }
    }
}
