package com.kwad.a.kwai;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.a.kwai.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes5.dex */
public class g extends c.AbstractC0282c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g(f fVar, c.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(bVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = bVar.c + (j * bVar.e);
        this.a = fVar.c(allocate, j2);
        this.b = fVar.c(allocate, 4 + j2);
        this.c = fVar.c(allocate, 8 + j2);
        this.d = fVar.c(allocate, j2 + 20);
    }
}
