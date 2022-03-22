package com.win.opensdk;

import android.content.Context;
import c.m.a.j1;
import c.m.a.m0;
import c.m.a.q0;
import c.m.a.r0;
import c.m.a.v;
import c.m.a.v4;
import c.m.a.x4;
import c.m.a.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public j1 f43992b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f43993c;

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
        j1 j1Var = new j1(applicationContext, str);
        this.f43992b = j1Var;
        j1Var.f23476h = new x4(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j1 j1Var = this.f43992b;
            j1Var.f23473e = false;
            j1Var.f23471c = false;
            j1Var.f23472d = false;
            v4 v4Var = j1Var.i;
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
            j1 j1Var = this.f43992b;
            if (!j1Var.c()) {
                if (!(j1Var.f23472d && !j1Var.f23473e && j1Var.e() && !j1Var.f23474f.isShown() && j1Var.f23474f.isEffective())) {
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
            j1 j1Var = this.f43992b;
            if (j1Var.e() && j1Var.f23474f.isEffective() && !j1Var.f23474f.isShown()) {
                j1Var.b(j1Var.f23474f);
                return;
            }
            if (j1Var.i == null) {
                j1Var.i = new v4(j1Var.f23470b, j1Var.a, L.f43985b);
            }
            j1Var.i.f23601g = new y0(j1Var);
            j1Var.i.g();
        }
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBInterstitialListener) == null) {
            this.f43993c = pBInterstitialListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            j1 j1Var = this.f43992b;
            if (!r0.H(j1Var.f23470b)) {
                PBInterstitialListener pBInterstitialListener = j1Var.f23476h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (j1Var.g() && j1Var.c() && j1Var.e()) {
                j1Var.f23471c = false;
                v.b().d(v.c(j1Var.f23474f.getTraceid(), j1Var.f23474f.getId(), j1Var.f23474f.getPid()), j1Var.f23475g);
                j1Var.f23474f.setShown(true);
                r0.l(j1Var.f23470b, j1Var.f23474f);
                m0.a().c(v.c(j1Var.f23474f.getTraceid(), j1Var.f23474f.getId(), j1Var.a), j1Var.f23474f);
                H5Activity.a(j1Var.f23470b, j1Var.f23474f, j1Var.a);
                q0.b(j1Var.f23474f.getId() + j1Var.a, j1Var);
            }
        }
    }
}
