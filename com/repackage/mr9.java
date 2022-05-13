package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mr9 implements lp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ qr9 a;

    public mr9(qr9 qr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qr9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qr9Var;
    }

    @Override // com.repackage.lp9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.lp9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            tr9 tr9Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            tr9 tr9Var2 = this.a.a;
            tr9Var.c = currentTimeMillis - tr9Var2.b;
            tq9 a = xq9.a(tr9Var2.a);
            a.a(i, this.a.a.c);
            a.m();
        }
    }

    @Override // com.repackage.lp9
    public void a(Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            tr9 tr9Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.a.a.b;
            tr9Var.c = currentTimeMillis - j;
            this.a.a.e((wt9) obj);
        }
    }
}
