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
public class PBInterstitial implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f77166a;

    /* renamed from: b  reason: collision with root package name */
    public S0 f77167b;

    /* renamed from: c  reason: collision with root package name */
    public PBInterstitialListener f77168c;

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
        this.f77166a = str;
        S0 s0 = new S0(applicationContext, str);
        this.f77167b = s0;
        s0.f77208h = new s(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            S0 s0 = this.f77167b;
            s0.f77205e = false;
            s0.f77203c = false;
            s0.f77204d = false;
            m1 m1Var = s0.f77209i;
            if (m1Var != null) {
                m1Var.a();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f77166a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            S0 s0 = this.f77167b;
            if (!s0.a()) {
                if (!(s0.f77204d && !s0.f77205e && s0.b() && !s0.f77206f.isShown() && s0.f77206f.isEffective())) {
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
            S0 s0 = this.f77167b;
            if (s0.b() && s0.f77206f.isEffective() && !s0.f77206f.isShown()) {
                s0.a(s0.f77206f);
                return;
            }
            if (s0.f77209i == null) {
                s0.f77209i = new m1(s0.f77202b, s0.f77201a, M.f77133b);
            }
            s0.f77209i.f77422g = new Q0(s0);
            s0.f77209i.b();
        }
    }

    public void setInterstitialListener(PBInterstitialListener pBInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBInterstitialListener) == null) {
            this.f77168c = pBInterstitialListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            S0 s0 = this.f77167b;
            if (!N.e(s0.f77202b)) {
                PBInterstitialListener pBInterstitialListener = s0.f77208h;
                if (pBInterstitialListener != null) {
                    pBInterstitialListener.onInterstitialShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (s0.c() && s0.a() && s0.b()) {
                s0.f77203c = false;
                y2.a().a(y2.a(s0.f77206f.getTraceid(), s0.f77206f.getId(), s0.f77206f.getPid()), s0.f77207g);
                s0.f77206f.setShown(true);
                L.a().a(y2.a(s0.f77206f.getTraceid(), s0.f77206f.getId(), s0.f77201a), s0.f77206f);
                H5Activity.a(s0.f77202b, s0.f77206f, s0.f77201a);
                H1.a(s0.f77206f.getId() + s0.f77201a, s0);
            }
        }
    }
}
