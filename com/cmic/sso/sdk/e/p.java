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

    public static String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65536, null, z)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (!z || !nextElement.getName().toLowerCase().contains("wlan")) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address)) {
                                sb.append(nextElement2.getHostAddress());
                                sb.append(",");
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(sb)) {
                    sb = sb.delete(sb.length() - 1, sb.length());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onlyMobileDataIp ");
                sb2.append(z);
                sb2.append(" IPV4 ip：");
                sb2.append(sb.toString());
                c.b("UmcIPUtils", sb2.toString());
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeZ.objValue;
    }

    public static String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (!z || !nextElement.getName().toLowerCase().contains("wlan")) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet6Address) && !nextElement2.isLinkLocalAddress()) {
                                String hostAddress = nextElement2.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress)) {
                                    sb.append(hostAddress);
                                    sb.append(",");
                                }
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(sb)) {
                    sb = sb.delete(sb.length() - 1, sb.length());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onlyMobileDataIp ");
                sb2.append(z);
                sb2.append(" IPV6 ip：");
                sb2.append(sb.toString());
                c.b("UmcIPUtils", sb2.toString());
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeZ.objValue;
    }
}
