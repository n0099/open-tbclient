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
public class s extends t.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public s(w wVar, t.b bVar, long j, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar, bVar, Long.valueOf(j), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(bVar.f76097a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = j + (i2 * 16);
        wVar.h(allocate, j2, 8);
        this.f76095a = allocate.getLong();
        wVar.h(allocate, j2 + 8, 8);
        this.f76096b = allocate.getLong();
    }
}
