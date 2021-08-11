package ms.bd.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import ms.bd.c.b;
/* loaded from: classes2.dex */
public final class n0 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public n0() {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
            try {
                Locale locale = a.c().a().getResources().getConfiguration().locale;
                String language = locale.getLanguage();
                String country = locale.getCountry();
                StringBuilder sb = new StringBuilder();
                sb.append(language);
                sb.append((String) h.a(16777217, 0, 0L, "5ac063", new byte[]{27}));
                sb.append(country);
                str2 = sb.toString();
            } catch (Throwable unused) {
                str2 = null;
            }
            return a2.a(str2);
        }
        return invokeCommon.objValue;
    }
}
