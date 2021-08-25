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
    public final /* synthetic */ d0 f76783a;

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
        this.f76783a = d0Var;
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
            d0 d0Var = this.f76783a;
            if (Q1.a(d0Var.f76820c, d0Var.f76825h)) {
                this.f76783a.f76825h = System.currentTimeMillis();
                d0 d0Var2 = this.f76783a;
                Q1.a(d0Var2.f76818a, str, d0Var2.f76820c, d0Var2.f76824g, str2);
                Z0.a(this.f76783a.f76818a).a(new a1(this.f76783a.f76820c), str).a("desc", str2).a();
                f fVar = this.f76783a.f76823f;
                if (fVar != null) {
                    fVar.onClicked();
                }
                N.a(this.f76783a.f76820c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
