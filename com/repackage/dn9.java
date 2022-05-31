package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dn9 implements lk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ jn9 a;

    public dn9(jn9 jn9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jn9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jn9Var;
    }

    @Override // com.repackage.lk9
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.repackage.lk9
    public boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            jn9 jn9Var = this.a;
            if (pm9.d(jn9Var.c, jn9Var.h)) {
                this.a.h = System.currentTimeMillis();
                jn9 jn9Var2 = this.a;
                pm9.a(jn9Var2.a, str, jn9Var2.c, jn9Var2.g, str2);
                nn9 a = rn9.a(this.a.a);
                a.h(new vn9(this.a.c), str);
                a.l("desc", str2);
                a.m();
                xn9 xn9Var = this.a.f;
                if (xn9Var != null) {
                    xn9Var.onClicked();
                }
                ll9.p(this.a.c, str2);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
