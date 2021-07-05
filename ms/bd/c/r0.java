package ms.bd.c;

import android.telephony.TelephonyManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import ms.bd.c.b;
/* loaded from: classes10.dex */
public final class r0 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r0() {
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
            Boolean bool = Boolean.FALSE;
            TelephonyManager telephonyManager = (TelephonyManager) a.a().c().getApplicationContext().getSystemService((String) h.a(16777217, 0, 0L, "24aa49", new byte[]{51, 62, 29, 27, 14}));
            return (telephonyManager == null || telephonyManager.getSimState() != 5) ? bool : Boolean.TRUE;
        }
        return invokeCommon.objValue;
    }
}
