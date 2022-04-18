package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rs9 implements qq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ vs9 a;

    public rs9(vs9 vs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vs9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vs9Var;
    }

    @Override // com.repackage.qq9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.qq9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            ys9 ys9Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            ys9 ys9Var2 = this.a.a;
            ys9Var.c = currentTimeMillis - ys9Var2.b;
            yr9 a = cs9.a(ys9Var2.a);
            a.a(i, this.a.a.c);
            a.m();
        }
    }

    @Override // com.repackage.qq9
    public void a(Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            ys9 ys9Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.a.a.b;
            ys9Var.c = currentTimeMillis - j;
            this.a.a.e((bv9) obj);
        }
    }
}
