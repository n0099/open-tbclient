package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes7.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String[] a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65536, null, z)) == null) {
            String[] strArr = {"", ""};
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (!z || !nextElement.getName().toLowerCase().contains("wlan")) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                                String hostAddress = nextElement2.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress)) {
                                    if (nextElement2 instanceof Inet6Address) {
                                        sb.append(hostAddress);
                                        sb.append(",");
                                    } else if (nextElement2 instanceof Inet4Address) {
                                        sb2.append(hostAddress);
                                        sb2.append(",");
                                    }
                                }
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(sb)) {
                    sb = sb.delete(sb.length() - 1, sb.length());
                }
                if (!TextUtils.isEmpty(sb2)) {
                    sb2 = sb2.delete(sb2.length() - 1, sb2.length());
                }
                strArr[0] = sb2.toString();
                strArr[1] = sb.toString();
                c.b("UmcIPUtils", "onlyMobileDataIp " + z + " IPV6 ip：" + sb.toString());
                c.b("UmcIPUtils", "onlyMobileDataIp " + z + " IPV4 ip：" + sb2.toString());
                return strArr;
            } catch (Exception e) {
                e.printStackTrace();
                return strArr;
            }
        }
        return (String[]) invokeZ.objValue;
    }
}
