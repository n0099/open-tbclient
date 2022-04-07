package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.uy9;
/* loaded from: classes7.dex */
public final class uz9<T, R> implements uy9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uy9.a<T> a;
    public final uy9.b<? extends R, ? super T> b;

    public uz9(uy9.a<T> aVar, uy9.b<? extends R, ? super T> bVar) {
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

    @Override // com.repackage.uy9.a, com.repackage.iz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((az9) ((az9) obj));
    }

    public void call(az9<? super R> az9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, az9Var) == null) {
            try {
                az9 az9Var2 = (az9) c3a.n(this.b).call(az9Var);
                az9Var2.d();
                this.a.call(az9Var2);
            } catch (Throwable th) {
                gz9.e(th);
                az9Var.onError(th);
            }
        }
    }
}
