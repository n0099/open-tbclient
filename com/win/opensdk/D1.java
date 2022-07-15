package com.win.opensdk;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class D1 implements E2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ F1 a;

    public D1(F1 f1) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f1};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = f1;
    }

    @Override // com.win.opensdk.E2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.win.opensdk.E2
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            F1 f1 = this.a;
            if (V1.a(f1.c, f1.h)) {
                this.a.h = System.currentTimeMillis();
                F1 f12 = this.a;
                V1.a(f12.a, str, f12.c, f12.g, str2);
                e1.a(this.a.a).a(new f1(this.a.c), str).a("desc", str2).a();
                E e = this.a.f;
                if (e != null) {
                    e.onClicked();
                }
                M.a(this.a.c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
