package com.win.opensdk;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.activitys.H5Activity;
/* loaded from: classes7.dex */
public class PBVideo implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f42437a;

    /* renamed from: b  reason: collision with root package name */
    public I1 f42438b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f42439c;

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
        this.f42437a = str;
        I1 i1 = new I1(applicationContext, str);
        this.f42438b = i1;
        i1.f42367h = new o(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            I1 i1 = this.f42438b;
            i1.f42364e = false;
            i1.f42362c = false;
            i1.f42363d = false;
            K0 k0 = i1.f42368i;
            if (k0 != null) {
                k0.a();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f42437a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            I1 i1 = this.f42438b;
            if (!i1.a()) {
                if (!(i1.f42363d && !i1.f42364e && i1.b() && !i1.f42365f.isShown() && i1.f42365f.isEffective())) {
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
            I1 i1 = this.f42438b;
            if (i1.b() && i1.f42365f.isEffective() && !i1.f42365f.isShown()) {
                i1.a(i1.f42365f);
                return;
            }
            if (i1.f42368i == null) {
                i1.f42368i = new K0(i1.f42361b, i1.f42360a, y.f42705d);
            }
            i1.f42368i.f42385g = new G1(i1);
            i1.f42368i.b();
        }
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBVideoListener) == null) {
            this.f42439c = pBVideoListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            I1 i1 = this.f42438b;
            if (!z.e(i1.f42361b)) {
                PBVideoListener pBVideoListener = i1.f42367h;
                if (pBVideoListener != null) {
                    pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (i1.c() && i1.a() && i1.b()) {
                i1.f42362c = false;
                W1.a().a(W1.a(i1.f42365f.getTraceid(), i1.f42365f.getId(), i1.f42365f.getPid()), i1.f42366g);
                i1.f42365f.setShown(true);
                x.a().a(W1.a(i1.f42365f.getTraceid(), i1.f42365f.getId(), i1.f42360a), i1.f42365f);
                H5Activity.a(i1.f42361b, i1.f42365f, i1.f42360a);
                f1.a(i1.f42365f.getId() + i1.f42360a, i1);
            }
        }
    }
}
