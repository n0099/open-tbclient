package ms.bd.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TimeZone;
import ms.bd.c.b;
/* loaded from: classes2.dex */
public final class j1 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public j1() {
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
    public Object b(int i2, long j2, String str, Object obj) throws Throwable {
        InterceptResult invokeCommon;
        String str2;
        int i3;
        TimeZone timeZone;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
            try {
                timeZone = TimeZone.getDefault();
                str2 = timeZone.getID();
            } catch (Throwable unused) {
                str2 = null;
            }
            try {
                i3 = ((timeZone.getRawOffset() / 60) / 60) / 1000;
            } catch (Throwable unused2) {
                i3 = 0;
                return str2 + ((String) h.a(16777217, 0, 0L, "1ea9b7", new byte[]{108})) + i3;
            }
            return str2 + ((String) h.a(16777217, 0, 0L, "1ea9b7", new byte[]{108})) + i3;
        }
        return invokeCommon.objValue;
    }
}
