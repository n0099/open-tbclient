package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes6.dex */
public class PBInterstitial implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39436a;

    /* renamed from: b  reason: collision with root package name */
    public q0 f39437b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f39438c;

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
        this.f39436a = str;
        q0 q0Var = new q0(applicationContext, str);
        this.f39437b = q0Var;
        q0Var.f39642h = new e(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q0 q0Var = this.f39437b;
            q0Var.f39639e = false;
            q0Var.f39637c = false;
            q0Var.f39638d = false;
            K0 k0 = q0Var.f39643i;
            if (k0 != null) {
                k0.a();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39436a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q0 q0Var = this.f39437b;
            if (!q0Var.a()) {
                if (!(q0Var.f39638d && !q0Var.f39639e && q0Var.b() && !q0Var.f39640f.isShown() && q0Var.f39640f.isEffective())) {
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
            q0 q0Var = this.f39437b;
            if (q0Var.b() && q0Var.f39640f.isEffective() && !q0Var.f39640f.isShown()) {
                q0Var.a(q0Var.f39640f);
                return;
            }
            if (q0Var.f39643i == null) {
                q0Var.f39643i = new K0(q0Var.f39636b, q0Var.f39635a, y.f39717b);
            }
            q0Var.f39643i.f39399g = new o0(q0Var);
            q0Var.f39643i.b();
        }
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBInterstitialListener) == null) {
            this.f39438c = pBInterstitialListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q0 q0Var = this.f39437b;
            if (!z.e(q0Var.f39636b)) {
                PBInterstitialListener pBInterstitialListener = q0Var.f39642h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (q0Var.c() && q0Var.a() && q0Var.b()) {
                q0Var.f39637c = false;
                W1.a().a(W1.a(q0Var.f39640f.getTraceid(), q0Var.f39640f.getId(), q0Var.f39640f.getPid()), q0Var.f39641g);
                q0Var.f39640f.setShown(true);
                x.a().a(W1.a(q0Var.f39640f.getTraceid(), q0Var.f39640f.getId(), q0Var.f39635a), q0Var.f39640f);
                H5Activity.a(q0Var.f39636b, q0Var.f39640f, q0Var.f39635a);
                f1.a(q0Var.f39640f.getId() + q0Var.f39635a, q0Var);
            }
        }
    }
}
