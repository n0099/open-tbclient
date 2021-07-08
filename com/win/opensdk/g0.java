package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g0 implements V1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i0 f39579a;

    public g0(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39579a = i0Var;
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
            i0 i0Var = this.f39579a;
            if (o1.a(i0Var.f39595c, i0Var.f39600h)) {
                this.f39579a.f39600h = System.currentTimeMillis();
                i0 i0Var2 = this.f39579a;
                o1.a(i0Var2.f39593a, str, i0Var2.f39595c, i0Var2.f39599g, str2);
                x0.a(this.f39579a.f39593a).a(new y0(this.f39579a.f39595c), str).a("desc", str2).a();
                PBNativeListener pBNativeListener = this.f39579a.f39598f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                }
                z.a(this.f39579a.f39595c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
