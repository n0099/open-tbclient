package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class go9 implements fm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ko9 a;

    public go9(ko9 ko9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ko9Var;
    }

    @Override // com.repackage.fm9
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.repackage.fm9
    public void a(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            no9 no9Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            no9 no9Var2 = this.a.a;
            no9Var.c = currentTimeMillis - no9Var2.b;
            nn9 a = rn9.a(no9Var2.a);
            a.a(i, this.a.a.c);
            a.m();
        }
    }

    @Override // com.repackage.fm9
    public void a(Object obj) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            no9 no9Var = this.a.a;
            long currentTimeMillis = System.currentTimeMillis();
            j = this.a.a.b;
            no9Var.c = currentTimeMillis - j;
            this.a.a.e((qq9) obj);
        }
    }
}
