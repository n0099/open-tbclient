package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ru9;
import com.repackage.vu9;
/* loaded from: classes6.dex */
public final class jw9<T> implements ru9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vu9.c<T> a;

    public jw9(vu9.c<T> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
    }

    @Override // com.repackage.ru9.a, com.repackage.fv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xu9) ((xu9) obj));
    }

    public void call(xu9<? super T> xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
            hw9 hw9Var = new hw9(xu9Var);
            xu9Var.b(hw9Var);
            this.a.call(hw9Var);
        }
    }
}
