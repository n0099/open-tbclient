package ms.bd.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import ms.bd.c.b;
/* loaded from: classes10.dex */
public final class g0 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // ms.bd.c.b.a
    public Object b(int i2, long j, String str, Object obj) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, obj})) == null) {
            File file = new File(a.a().c().getFilesDir(), (String) h.a(16777217, 0, 0L, "7e7d7b", new byte[]{104, 106, 87, 20, 9, 97, 53}));
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return invokeCommon.objValue;
    }
}
