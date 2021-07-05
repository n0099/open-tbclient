package com.win.opensdk;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Y0 f42619a;

    /* renamed from: b  reason: collision with root package name */
    public r f42620b;

    public q(Context context, String str) {
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
        Y0 y0 = new Y0(context, str);
        this.f42619a = y0;
        y0.f42511f = new p(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f42619a != null) {
                    this.f42619a.a();
                    this.f42619a = null;
                }
                if (this.f42620b != null) {
                    this.f42620b = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        Y0 y0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pBMediaView) == null) || (y0 = this.f42619a) == null) {
            return;
        }
        y0.a(view, pBMediaView);
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Y0 y0 = this.f42619a;
            return (y0 == null || !y0.b()) ? "" : y0.f42508c.getLoad_type();
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Y0 y0 = this.f42619a;
            return y0 != null && y0.b();
        }
        return invokeV.booleanValue;
    }
}
