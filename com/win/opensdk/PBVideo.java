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
public class PBVideo implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39644a;

    /* renamed from: b  reason: collision with root package name */
    public k2 f39645b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f39646c;

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
        this.f39644a = str;
        k2 k2Var = new k2(applicationContext, str);
        this.f39645b = k2Var;
        k2Var.f39866h = new C(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k2 k2Var = this.f39645b;
            k2Var.f39863e = false;
            k2Var.f39861c = false;
            k2Var.f39862d = false;
            m1 m1Var = k2Var.f39867i;
            if (m1Var != null) {
                m1Var.a();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39644a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            k2 k2Var = this.f39645b;
            if (!k2Var.a()) {
                if (!(k2Var.f39862d && !k2Var.f39863e && k2Var.b() && !k2Var.f39864f.isShown() && k2Var.f39864f.isEffective())) {
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
            k2 k2Var = this.f39645b;
            if (k2Var.b() && k2Var.f39864f.isEffective() && !k2Var.f39864f.isShown()) {
                k2Var.a(k2Var.f39864f);
                return;
            }
            if (k2Var.f39867i == null) {
                k2Var.f39867i = new m1(k2Var.f39860b, k2Var.f39859a, M.f39599d);
            }
            k2Var.f39867i.f39878g = new i2(k2Var);
            k2Var.f39867i.b();
        }
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBVideoListener) == null) {
            this.f39646c = pBVideoListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            k2 k2Var = this.f39645b;
            if (!N.e(k2Var.f39860b)) {
                PBVideoListener pBVideoListener = k2Var.f39866h;
                if (pBVideoListener != null) {
                    pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (k2Var.c() && k2Var.a() && k2Var.b()) {
                k2Var.f39861c = false;
                y2.a().a(y2.a(k2Var.f39864f.getTraceid(), k2Var.f39864f.getId(), k2Var.f39864f.getPid()), k2Var.f39865g);
                k2Var.f39864f.setShown(true);
                L.a().a(y2.a(k2Var.f39864f.getTraceid(), k2Var.f39864f.getId(), k2Var.f39859a), k2Var.f39864f);
                H5Activity.a(k2Var.f39860b, k2Var.f39864f, k2Var.f39859a);
                H1.a(k2Var.f39864f.getId() + k2Var.f39859a, k2Var);
            }
        }
    }
}
