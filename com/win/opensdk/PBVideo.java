package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes10.dex */
public class PBVideo implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f76683a;

    /* renamed from: b  reason: collision with root package name */
    public k2 f76684b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f76685c;

    public PBVideo(Context context, String str) {
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
        this.f76683a = str;
        k2 k2Var = new k2(applicationContext, str);
        this.f76684b = k2Var;
        k2Var.f76910h = new C(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k2 k2Var = this.f76684b;
            k2Var.f76907e = false;
            k2Var.f76905c = false;
            k2Var.f76906d = false;
            m1 m1Var = k2Var.f76911i;
            if (m1Var != null) {
                m1Var.a();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f76683a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            k2 k2Var = this.f76684b;
            if (!k2Var.a()) {
                if (!(k2Var.f76906d && !k2Var.f76907e && k2Var.b() && !k2Var.f76908f.isShown() && k2Var.f76908f.isEffective())) {
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
            k2 k2Var = this.f76684b;
            if (k2Var.b() && k2Var.f76908f.isEffective() && !k2Var.f76908f.isShown()) {
                k2Var.a(k2Var.f76908f);
                return;
            }
            if (k2Var.f76911i == null) {
                k2Var.f76911i = new m1(k2Var.f76904b, k2Var.f76903a, M.f76636d);
            }
            k2Var.f76911i.f76923g = new i2(k2Var);
            k2Var.f76911i.b();
        }
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBVideoListener) == null) {
            this.f76685c = pBVideoListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            k2 k2Var = this.f76684b;
            if (!N.e(k2Var.f76904b)) {
                PBVideoListener pBVideoListener = k2Var.f76910h;
                if (pBVideoListener != null) {
                    pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (k2Var.c() && k2Var.a() && k2Var.b()) {
                k2Var.f76905c = false;
                y2.a().a(y2.a(k2Var.f76908f.getTraceid(), k2Var.f76908f.getId(), k2Var.f76908f.getPid()), k2Var.f76909g);
                k2Var.f76908f.setShown(true);
                L.a().a(y2.a(k2Var.f76908f.getTraceid(), k2Var.f76908f.getId(), k2Var.f76903a), k2Var.f76908f);
                H5Activity.a(k2Var.f76904b, k2Var.f76908f, k2Var.f76903a);
                H1.a(k2Var.f76908f.getId() + k2Var.f76903a, k2Var);
            }
        }
    }
}
