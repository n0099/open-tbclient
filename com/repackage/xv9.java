package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xu9;
/* loaded from: classes7.dex */
public final class xv9<T, R> implements xu9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xu9.a<T> a;
    public final xu9.b<? extends R, ? super T> b;

    public xv9(xu9.a<T> aVar, xu9.b<? extends R, ? super T> bVar) {
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

    @Override // com.repackage.xu9.a, com.repackage.lv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dv9) ((dv9) obj));
    }

    public void call(dv9<? super R> dv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
            try {
                dv9 dv9Var2 = (dv9) ez9.n(this.b).call(dv9Var);
                dv9Var2.d();
                this.a.call(dv9Var2);
            } catch (Throwable th) {
                jv9.e(th);
                dv9Var.onError(th);
            }
        }
    }
}
