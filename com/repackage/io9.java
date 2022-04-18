package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBNativeListener;
/* loaded from: classes6.dex */
public class io9 implements wo9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ qo9 a;

    public io9(qo9 qo9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qo9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qo9Var;
    }

    @Override // com.repackage.wo9
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.repackage.wo9
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            qo9 qo9Var = this.a;
            if (ar9.d(qo9Var.c, qo9Var.h)) {
                this.a.h = System.currentTimeMillis();
                qo9 qo9Var2 = this.a;
                ar9.a(qo9Var2.a, str, qo9Var2.c, qo9Var2.g, str2);
                yr9 a = cs9.a(this.a.a);
                a.h(new gs9(this.a.c), str);
                a.l("desc", str2);
                a.m();
                PBNativeListener pBNativeListener = this.a.f;
                if (pBNativeListener != null) {
                    pBNativeListener.onClicked();
                }
                wp9.p(this.a.c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
