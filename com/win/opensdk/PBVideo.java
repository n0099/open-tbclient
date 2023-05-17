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
    public String a;
    public q2 b;
    public PBVideoListener c;

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBVideoListener) == null) {
            this.c = pBVideoListener;
        }
    }

    public PBVideo(Context context, String str) {
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
        q2 q2Var = new q2(applicationContext, str);
        this.b = q2Var;
        q2Var.h = new B(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            q2 q2Var = this.b;
            q2Var.e = false;
            q2Var.c = false;
            q2Var.d = false;
            r1 r1Var = q2Var.i;
            if (r1Var != null) {
                r1Var.a();
            }
        }
    }

    public boolean isReady() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q2 q2Var = this.b;
            if (!q2Var.a()) {
                if (q2Var.d && !q2Var.e && q2Var.b() && !q2Var.f.isShown() && q2Var.f.isEffective()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
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
            q2 q2Var = this.b;
            if (q2Var.b() && q2Var.f.isEffective() && !q2Var.f.isShown()) {
                q2Var.a(q2Var.f);
                return;
            }
            if (q2Var.i == null) {
                q2Var.i = new r1(q2Var.b, q2Var.a, L.d);
            }
            q2Var.i.g = new o2(q2Var);
            q2Var.i.b();
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            q2 q2Var = this.b;
            if (!M.e(q2Var.b)) {
                PBVideoListener pBVideoListener = q2Var.h;
                if (pBVideoListener != null) {
                    pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (q2Var.c() && q2Var.a() && q2Var.b()) {
                q2Var.c = false;
                F2.a().a(F2.a(q2Var.f.getTraceid(), q2Var.f.getId(), q2Var.f.getPid()), q2Var.g);
                q2Var.f.setShown(true);
                M.a(q2Var.b, q2Var.f);
                K.a().a(F2.a(q2Var.f.getTraceid(), q2Var.f.getId(), q2Var.a), q2Var.f);
                H5Activity.a(q2Var.b, q2Var.f, q2Var.a);
                M1.a(q2Var.f.getId() + q2Var.a, q2Var);
            }
        }
    }
}
