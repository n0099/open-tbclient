package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zx9;
/* loaded from: classes7.dex */
public class yz9 implements jy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final jy9 a;
    public final zx9.a b;
    public final long c;

    public yz9(jy9 jy9Var, zx9.a aVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jy9Var, aVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jy9Var;
        this.b = aVar;
        this.c = j;
    }

    @Override // com.repackage.jy9
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
                iy9.c(e);
                throw null;
            }
        }
        if (this.b.isUnsubscribed()) {
            return;
        }
        this.a.call();
    }
}
