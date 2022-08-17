package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ru9;
/* loaded from: classes7.dex */
public final class rv9<T, R> implements ru9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ru9.a<T> a;
    public final ru9.b<? extends R, ? super T> b;

    public rv9(ru9.a<T> aVar, ru9.b<? extends R, ? super T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.b = bVar;
    }

    @Override // com.repackage.ru9.a, com.repackage.fv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xu9) ((xu9) obj));
    }

    public void call(xu9<? super R> xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
            try {
                xu9 xu9Var2 = (xu9) yy9.n(this.b).call(xu9Var);
                xu9Var2.d();
                this.a.call(xu9Var2);
            } catch (Throwable th) {
                dv9.e(th);
                xu9Var.onError(th);
            }
        }
    }
}
