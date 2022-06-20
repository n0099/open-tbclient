package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class no9 implements mm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ro9 a;

    public no9(ro9 ro9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ro9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ro9Var;
    }

    @Override // com.repackage.mm9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.mm9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            uo9 uo9Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            uo9 uo9Var2 = this.a.a;
            uo9Var.c = currentTimeMillis - uo9Var2.b;
            un9 a = yn9.a(uo9Var2.a);
            a.a(i, this.a.a.c);
            a.m();
        }
    }

    @Override // com.repackage.mm9
    public void a(Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            uo9 uo9Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.a.a.b;
            uo9Var.c = currentTimeMillis - j;
            this.a.a.e((xq9) obj);
        }
    }
}
