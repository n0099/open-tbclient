package com.win.opensdk;

import android.content.Context;
import b.q.a.a5;
import b.q.a.c5;
import b.q.a.m0;
import b.q.a.o1;
import b.q.a.q0;
import b.q.a.r0;
import b.q.a.v;
import b.q.a.y0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes2.dex */
public class PBInterstitial {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f70460a;

    /* renamed from: b  reason: collision with root package name */
    public o1 f70461b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f70462c;

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
        this.f70460a = str;
        o1 o1Var = new o1(applicationContext, str);
        this.f70461b = o1Var;
        o1Var.l = new c5(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o1 o1Var = this.f70461b;
            o1Var.f33425i = false;
            o1Var.f33423g = false;
            o1Var.f33424h = false;
            a5 a5Var = o1Var.m;
            if (a5Var != null) {
                a5Var.b();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f70460a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            o1 o1Var = this.f70461b;
            if (!o1Var.c()) {
                if (!(o1Var.f33424h && !o1Var.f33425i && o1Var.e() && !o1Var.j.isShown() && o1Var.j.isEffective())) {
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
            o1 o1Var = this.f70461b;
            if (o1Var.e() && o1Var.j.isEffective() && !o1Var.j.isShown()) {
                o1Var.b(o1Var.j);
                return;
            }
            if (o1Var.m == null) {
                o1Var.m = new a5(o1Var.f33422f, o1Var.f33421e, L.f70452b);
            }
            o1Var.m.f33244g = new y0(o1Var);
            o1Var.m.g();
        }
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBInterstitialListener) == null) {
            this.f70462c = pBInterstitialListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o1 o1Var = this.f70461b;
            if (!r0.H(o1Var.f33422f)) {
                PBInterstitialListener pBInterstitialListener = o1Var.l;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (o1Var.g() && o1Var.c() && o1Var.e()) {
                o1Var.f33423g = false;
                v.b().d(v.c(o1Var.j.getTraceid(), o1Var.j.getId(), o1Var.j.getPid()), o1Var.k);
                o1Var.j.setShown(true);
                r0.l(o1Var.f33422f, o1Var.j);
                m0.a().c(v.c(o1Var.j.getTraceid(), o1Var.j.getId(), o1Var.f33421e), o1Var.j);
                H5Activity.a(o1Var.f33422f, o1Var.j, o1Var.f33421e);
                q0.b(o1Var.j.getId() + o1Var.f33421e, o1Var);
            }
        }
    }
}
