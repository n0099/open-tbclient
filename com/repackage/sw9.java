package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.tu9;
/* loaded from: classes7.dex */
public class sw9 implements dv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dv9 a;
    public final tu9.a b;
    public final long c;

    public sw9(dv9 dv9Var, tu9.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dv9Var, aVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = dv9Var;
        this.b = aVar;
        this.c = j;
    }

    @Override // com.repackage.dv9
    public void call() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.isUnsubscribed()) {
            return;
        }
        long a = this.c - this.b.a();
        if (a > 0) {
            try {
                Thread.sleep(a);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                cv9.c(e);
                throw null;
            }
        }
        if (this.b.isUnsubscribed()) {
            return;
        }
        this.a.call();
    }
}
