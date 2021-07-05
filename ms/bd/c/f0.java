package ms.bd.c;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.lang.reflect.Method;
import ms.bd.c.b;
/* loaded from: classes10.dex */
public final class f0 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f0() {
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
        StringBuilder sb;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, obj})) == null) {
            Context c2 = a.a().c();
            String str2 = (String) h.a(16777217, 0, 0L, "45f393", new byte[]{43, 34, 25, 75});
            String str3 = (String) h.a(16777217, 0, 0L, "297d7f", new byte[]{UtilsBlink.VER_TYPE_SEPARATOR, 46, 72, 28});
            try {
                WifiInfo connectionInfo = ((WifiManager) c2.getSystemService((String) h.a(16777217, 0, 0L, "3ab624", new byte[]{53, 106, 23, 75}))).getConnectionInfo();
                Method declaredMethod = connectionInfo.getClass().getDeclaredMethod(new String(c0.b((String) h.a(16777217, 0, 0L, "ca1c24", new byte[]{36, 52, 20, 66, 90, 119, 52, 25, 55, 99, 38, 50, 20, 67, 91, 119, 55, 18, 54, 102, 37, 48, 21, 68}))), new Class[0]);
                declaredMethod.setAccessible(true);
                String a3 = a2.a(Integer.toString(((Integer) declaredMethod.invoke(connectionInfo, new Object[0])).intValue()));
                sb = new StringBuilder();
                sb.append(str2);
                sb.append((String) h.a(16777217, 0, 0L, "05757c", new byte[]{26, 107, 5, 31, 53}));
                sb.append(str3);
                sb.append((String) h.a(16777217, 0, 0L, "699d18", new byte[]{28, 103, 11, 78, 51}));
                sb.append((a3 == null || a3.length() <= 0) ? (String) h.a(16777217, 0, 0L, "b94abd", new byte[]{Base64.INTERNAL_PADDING}) : a3.trim());
                a2 = h.a(16777217, 0, 0L, "410734", new byte[]{30, 111, 2, 29, 49});
            } catch (Throwable unused) {
                String a4 = a2.a(null);
                sb = new StringBuilder();
                sb.append(str2);
                sb.append((String) h.a(16777217, 0, 0L, "fc68b1", new byte[]{76, 61, 4, 18, 96}));
                sb.append(str3);
                sb.append((String) h.a(16777217, 0, 0L, "722896", new byte[]{29, 108, 0, 18, 59}));
                sb.append((a4 == null || a4.length() <= 0) ? (String) h.a(16777217, 0, 0L, "9153c5", new byte[]{120}) : a4.trim());
                a2 = h.a(16777217, 0, 0L, "7c0fee", new byte[]{29, 61, 2, 76, 103});
            }
            sb.append((String) a2);
            return sb.toString().trim();
        }
        return invokeCommon.objValue;
    }
}
