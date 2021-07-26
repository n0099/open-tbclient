package ms.bd.c;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import ms.bd.c.b;
import org.json.JSONArray;
/* loaded from: classes9.dex */
public final class q0 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q0() {
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
            JSONArray jSONArray = new JSONArray();
            try {
                DhcpInfo dhcpInfo = ((WifiManager) a.c().a().getApplicationContext().getSystemService((String) h.a(16777217, 0, 0L, "529c70", new byte[]{51, 57, 76, 30}))).getDhcpInfo();
                StringBuilder sb = new StringBuilder();
                sb.append(dhcpInfo.dns1 & 255);
                sb.append((String) h.a(16777217, 0, 0L, "94c3a4", new byte[]{102}));
                sb.append((dhcpInfo.dns1 >> 8) & 255);
                sb.append((String) h.a(16777217, 0, 0L, "b1b427", new byte[]{61}));
                sb.append((dhcpInfo.dns1 >> 16) & 255);
                sb.append((String) h.a(16777217, 0, 0L, "fa6b5c", new byte[]{57}));
                sb.append((dhcpInfo.dns1 >> 24) & 255);
                jSONArray.put(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(dhcpInfo.dns2 & 255);
                sb2.append((String) h.a(16777217, 0, 0L, "e61394", new byte[]{58}));
                sb2.append((dhcpInfo.dns2 >> 8) & 255);
                sb2.append((String) h.a(16777217, 0, 0L, "73154f", new byte[]{104}));
                sb2.append((dhcpInfo.dns2 >> 16) & 255);
                sb2.append((String) h.a(16777217, 0, 0L, "049ea3", new byte[]{111}));
                sb2.append((dhcpInfo.dns2 >> 24) & 255);
                jSONArray.put(sb2.toString());
            } catch (Throwable unused) {
                String str2 = (String) h.a(16777217, 0, 0L, "130a27", new byte[]{UtilsBlink.VER_TYPE_SEPARATOR, 56, 75, 42, 9, 44});
            }
            return jSONArray.toString();
        }
        return invokeCommon.objValue;
    }
}
