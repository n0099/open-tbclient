package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uy9;
import com.repackage.yy9;
/* loaded from: classes6.dex */
public final class n0a<T> implements uy9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yy9.c<T> a;

    public n0a(yy9.c<T> cVar) {
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

    @Override // com.repackage.uy9.a, com.repackage.iz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((az9) ((az9) obj));
    }

    public void call(az9<? super T> az9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
            l0a l0aVar = new l0a(az9Var);
            az9Var.b(l0aVar);
            this.a.call(l0aVar);
        }
    }
}
