package ms.bd.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import ms.bd.c.b;
/* loaded from: classes9.dex */
public final class d1 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d1() {
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
            Throwable a2 = z1.c().a();
            if (a2 == null) {
                return null;
            }
            StackTraceElement[] stackTrace = a2.getStackTrace();
            if (stackTrace.length < 4) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 1; i3 < 4; i3++) {
                if (stackTrace[i3] != null && !TextUtils.isEmpty(stackTrace[i3].getClassName())) {
                    arrayList.addAll(z1.c().b(Class.forName(stackTrace[i3].getClassName()), stackTrace[i3].getMethodName()));
                }
            }
            return arrayList;
        }
        return invokeCommon.objValue;
    }
}
