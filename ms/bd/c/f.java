package ms.bd.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import ms.bd.c.b;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes9.dex */
public final class f extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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
        boolean z;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, obj})) == null) {
            try {
                z = g.c(a.a().c(), str, obj.toString());
            } catch (Throwable unused) {
                String str2 = (String) h.a(16777217, 0, 0L, "7fde33", new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, Constants.SHORT_PING_CMD_TYPE, 17});
                z = false;
            }
            return new Boolean(z);
        }
        return invokeCommon.objValue;
    }
}
