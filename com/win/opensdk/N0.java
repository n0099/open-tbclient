package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class N0 implements r0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ O0 f42413a;

    public N0(O0 o0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42413a = o0;
    }

    @Override // com.win.opensdk.r0
    public void a() {
        r0 r0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (r0Var = this.f42413a.f42415a.f42419d) == null) {
            return;
        }
        r0Var.a();
    }

    @Override // com.win.opensdk.r0
    public void a(int i2, String str) {
        r0 r0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (r0Var = this.f42413a.f42415a.f42419d) == null) {
            return;
        }
        r0Var.a(i2, str);
    }

    @Override // com.win.opensdk.r0
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            w a2 = Q0.a(((R0) obj).f42455c);
            P0 p0 = this.f42413a.f42415a;
            r0 r0Var = p0.f42419d;
            if (r0Var != null) {
                if (a2 == null) {
                    r0Var.a(101, "");
                } else if (TextUtils.isEmpty(p0.f42417b) || !this.f42413a.f42415a.f42417b.equalsIgnoreCase(a2.a())) {
                    this.f42413a.f42415a.f42419d.a(2003, "");
                } else {
                    this.f42413a.f42415a.f42419d.a(a2);
                }
            }
        }
    }
}
