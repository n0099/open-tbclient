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
public class PBVideo implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f39451a;

    /* renamed from: b  reason: collision with root package name */
    public I1 f39452b;

    /* renamed from: c  reason: collision with root package name */
    public PBVideoListener f39453c;

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
        this.f39451a = str;
        I1 i1 = new I1(applicationContext, str);
        this.f39452b = i1;
        i1.f39381h = new o(this);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            I1 i1 = this.f39452b;
            i1.f39378e = false;
            i1.f39376c = false;
            i1.f39377d = false;
            K0 k0 = i1.f39382i;
            if (k0 != null) {
                k0.a();
            }
        }
    }

    public String getPid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f39451a : (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            I1 i1 = this.f39452b;
            if (!i1.a()) {
                if (!(i1.f39377d && !i1.f39378e && i1.b() && !i1.f39379f.isShown() && i1.f39379f.isEffective())) {
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
            I1 i1 = this.f39452b;
            if (i1.b() && i1.f39379f.isEffective() && !i1.f39379f.isShown()) {
                i1.a(i1.f39379f);
                return;
            }
            if (i1.f39382i == null) {
                i1.f39382i = new K0(i1.f39375b, i1.f39374a, y.f39719d);
            }
            i1.f39382i.f39399g = new G1(i1);
            i1.f39382i.b();
        }
    }

    public void setVideoListener(PBVideoListener pBVideoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pBVideoListener) == null) {
            this.f39453c = pBVideoListener;
        }
    }

    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            I1 i1 = this.f39452b;
            if (!z.e(i1.f39375b)) {
                PBVideoListener pBVideoListener = i1.f39381h;
                if (pBVideoListener != null) {
                    pBVideoListener.onRewardedShowFail(PBError.NO_NETWORK.getMsg());
                }
            } else if (i1.c() && i1.a() && i1.b()) {
                i1.f39376c = false;
                W1.a().a(W1.a(i1.f39379f.getTraceid(), i1.f39379f.getId(), i1.f39379f.getPid()), i1.f39380g);
                i1.f39379f.setShown(true);
                x.a().a(W1.a(i1.f39379f.getTraceid(), i1.f39379f.getId(), i1.f39374a), i1.f39379f);
                H5Activity.a(i1.f39375b, i1.f39379f, i1.f39374a);
                f1.a(i1.f39379f.getId() + i1.f39374a, i1);
            }
        }
    }
}
