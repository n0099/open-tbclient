package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class W0 implements V1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Y0 f42495a;

    public W0(Y0 y0) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y0};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42495a = y0;
    }

    @Override // com.win.opensdk.V1
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.win.opensdk.V1
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            Y0 y0 = this.f42495a;
            if (o1.a(y0.f42508c, y0.f42513h)) {
                this.f42495a.f42513h = System.currentTimeMillis();
                Y0 y02 = this.f42495a;
                o1.a(y02.f42506a, str, y02.f42508c, y02.f42512g, str2);
                x0.a(this.f42495a.f42506a).a(new y0(this.f42495a.f42508c), str).a("desc", str2).a();
                r rVar = this.f42495a.f42511f;
                if (rVar != null) {
                    rVar.onClicked();
                }
                z.a(this.f42495a.f42508c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
