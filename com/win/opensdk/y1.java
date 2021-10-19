package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class y1 implements x2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A1 f77577a;

    public y1(A1 a1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77577a = a1;
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
            A1 a1 = this.f77577a;
            if (Q1.a(a1.f77110c, a1.f77115h)) {
                this.f77577a.f77115h = System.currentTimeMillis();
                A1 a12 = this.f77577a;
                Q1.a(a12.f77108a, str, a12.f77110c, a12.f77114g, str2);
                Z0.a(this.f77577a.f77108a).a(new a1(this.f77577a.f77110c), str).a("desc", str2).a();
                F f2 = this.f77577a.f77113f;
                if (f2 != null) {
                    f2.onClicked();
                }
                N.a(this.f77577a.f77110c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
