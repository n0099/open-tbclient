package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes8.dex */
public class PBInterstitial implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public R0 b;
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
        R0 r0 = new R0(applicationContext, str);
        this.b = r0;
        r0.h = new r(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            R0 r0 = this.b;
            r0.e = false;
            r0.c = false;
            r0.d = false;
            r1 r1Var = r0.i;
            if (r1Var != null) {
                r1Var.a();
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
            R0 r0 = this.b;
            if (!r0.a()) {
                if (!(r0.d && !r0.e && r0.b() && !r0.f.isShown() && r0.f.isEffective())) {
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
            R0 r0 = this.b;
            if (r0.b() && r0.f.isEffective() && !r0.f.isShown()) {
                r0.a(r0.f);
                return;
            }
            if (r0.i == null) {
                r0.i = new r1(r0.b, r0.a, L.b);
            }
            r0.i.g = new P0(r0);
            r0.i.b();
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
            R0 r0 = this.b;
            if (!M.e(r0.b)) {
                PBInterstitialListener pBInterstitialListener = r0.h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (r0.c() && r0.a() && r0.b()) {
                r0.c = false;
                F2.a().a(F2.a(r0.f.getTraceid(), r0.f.getId(), r0.f.getPid()), r0.g);
                r0.f.setShown(true);
                M.a(r0.b, r0.f);
                K.a().a(F2.a(r0.f.getTraceid(), r0.f.getId(), r0.a), r0.f);
                H5Activity.a(r0.b, r0.f, r0.a);
                M1.a(r0.f.getId() + r0.a, r0);
            }
        }
    }
}
