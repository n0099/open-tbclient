package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ur9;
/* loaded from: classes7.dex */
public final class us9<T, R> implements ur9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ur9.a<T> a;
    public final ur9.b<? extends R, ? super T> b;

    public us9(ur9.a<T> aVar, ur9.b<? extends R, ? super T> bVar) {
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

    @Override // com.repackage.ur9.a, com.repackage.is9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((as9) ((as9) obj));
    }

    public void call(as9<? super R> as9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
            try {
                as9 as9Var2 = (as9) bw9.n(this.b).call(as9Var);
                as9Var2.d();
                this.a.call(as9Var2);
            } catch (Throwable th) {
                gs9.e(th);
                as9Var.onError(th);
            }
        }
    }
}
