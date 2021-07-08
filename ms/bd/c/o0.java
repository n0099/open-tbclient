package ms.bd.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import ms.bd.c.b;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes9.dex */
public final class o0 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o0() {
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
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        String name = nextElement.getName();
                        if (!TextUtils.isEmpty(name) && !nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address) && name.startsWith((String) h.a(16777217, 0, 0L, "d40a65", new byte[]{103, 59, 77, 16, 29}))) {
                            StringBuilder sb = new StringBuilder();
                            sb.append((String) h.a(16777217, 0, 0L, "bf133e", new byte[]{122, 106, 71, 83, UtilsBlink.VER_TYPE_SEPARATOR, 118, Constants.SHORT_PING_CMD_TYPE, 85, Constants.SHORT_PING_CMD_TYPE, 112, 96, 36, 76, 70, 1, 119, 59}));
                            sb.append(nextElement.getName());
                            sb.toString();
                            return nextElement.getName();
                        }
                    }
                }
                return "";
            } catch (SocketException e2) {
                String str2 = ((String) h.a(16777217, 0, 0L, "f39c8d", new byte[]{112, 52, 94, 87, 46, 99, 68, 22, 108, PublicSuffixDatabase.EXCEPTION_MARKER, 114, 34, 89, 87, 1, 114, 108, 30, 50})) + e2.toString();
                return "";
            }
        }
        return invokeCommon.objValue;
    }
}
