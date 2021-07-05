package ms.bd.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import ms.bd.c.t;
/* loaded from: classes10.dex */
public class y extends t.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public y(w wVar, t.b bVar, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, bVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(bVar.f76097a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = bVar.f76098b + (j * bVar.f76100d);
        wVar.h(allocate, j2, 4);
        this.f76103a = allocate.getInt() & 4294967295L;
        wVar.h(allocate, 8 + j2, 8);
        this.f76104b = allocate.getLong();
        wVar.h(allocate, 16 + j2, 8);
        this.f76105c = allocate.getLong();
        wVar.h(allocate, j2 + 40, 8);
        this.f76106d = allocate.getLong();
    }
}
