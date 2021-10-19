package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class b0 implements x2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f77317a;

    public b0(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77317a = d0Var;
    }

    @Override // com.win.opensdk.x2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.win.opensdk.x2
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            d0 d0Var = this.f77317a;
            if (Q1.a(d0Var.f77354c, d0Var.f77359h)) {
                this.f77317a.f77359h = System.currentTimeMillis();
                d0 d0Var2 = this.f77317a;
                Q1.a(d0Var2.f77352a, str, d0Var2.f77354c, d0Var2.f77358g, str2);
                Z0.a(this.f77317a.f77352a).a(new a1(this.f77317a.f77354c), str).a("desc", str2).a();
                f fVar = this.f77317a.f77357f;
                if (fVar != null) {
                    fVar.onClicked();
                }
                N.a(this.f77317a.f77354c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
