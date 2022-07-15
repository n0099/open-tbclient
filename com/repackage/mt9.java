package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur9;
import com.repackage.yr9;
/* loaded from: classes6.dex */
public final class mt9<T> implements ur9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yr9.c<T> a;

    public mt9(yr9.c<T> cVar) {
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

    @Override // com.repackage.ur9.a, com.repackage.is9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((as9) ((as9) obj));
    }

    public void call(as9<? super T> as9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
            kt9 kt9Var = new kt9(as9Var);
            as9Var.b(kt9Var);
            this.a.call(kt9Var);
        }
    }
}
