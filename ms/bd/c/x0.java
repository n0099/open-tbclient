package ms.bd.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import ms.bd.c.b;
/* loaded from: classes10.dex */
public final class x0 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x0() {
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
            Context c2 = a.a().c();
            String[] split = str.split((String) h.a(16777217, 0, 0L, "590661", new byte[]{24, 39}));
            String str2 = split[0];
            String str3 = split[1];
            SharedPreferences.Editor edit = c2.getSharedPreferences(str2, 0).edit();
            edit.putString(str3, (String) obj);
            edit.commit();
            return null;
        }
        return invokeCommon.objValue;
    }
}
