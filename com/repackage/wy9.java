package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wx9;
/* loaded from: classes7.dex */
public final class wy9<T, R> implements wx9.a<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final wx9.a<T> a;
    public final wx9.b<? extends R, ? super T> b;

    public wy9(wx9.a<T> aVar, wx9.b<? extends R, ? super T> bVar) {
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

    @Override // com.repackage.wx9.a, com.repackage.ky9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((cy9) ((cy9) obj));
    }

    public void call(cy9<? super R> cy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
            try {
                cy9 cy9Var2 = (cy9) d2a.n(this.b).call(cy9Var);
                cy9Var2.d();
                this.a.call(cy9Var2);
            } catch (Throwable th) {
                iy9.e(th);
                cy9Var.onError(th);
            }
        }
    }
}
