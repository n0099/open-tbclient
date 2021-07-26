package com.win.opensdk;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class E implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public A1 f39563a;

    /* renamed from: b  reason: collision with root package name */
    public F f39564b;

    public E(Context context, String str) {
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
        A1 a1 = new A1(context, str);
        this.f39563a = a1;
        a1.f39544f = new D(this);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f39563a != null) {
                    this.f39563a.a();
                    this.f39563a = null;
                }
                if (this.f39564b != null) {
                    this.f39564b = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        A1 a1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, pBMediaView) == null) || (a1 = this.f39563a) == null) {
            return;
        }
        a1.a(view, pBMediaView);
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            A1 a1 = this.f39563a;
            return (a1 == null || !a1.b()) ? "" : a1.f39541c.getLoad_type();
        }
        return (String) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            A1 a1 = this.f39563a;
            return a1 != null && a1.b();
        }
        return invokeV.booleanValue;
    }
}
