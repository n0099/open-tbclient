package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Enumeration;
/* loaded from: classes6.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(boolean z) {
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
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeZ.objValue;
    }

    public static String a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
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
                                    if (z2) {
                                        if (hostAddress.startsWith("2409:89")) {
                                            sb.append(hostAddress);
                                            sb.append(",");
                                        }
                                    } else {
                                        sb.append(hostAddress);
                                        sb.append(",");
                                    }
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
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i2)) == null) {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            for (int i3 = 0; i3 < allByName.length; i3++) {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(allByName[i3], i2));
                    return socket.getLocalAddress().getHostAddress();
                } catch (IOException e2) {
                    if (i3 == allByName.length - 1) {
                        throw e2;
                    }
                }
            }
            throw new UnknownHostException(str);
        }
        return (String) invokeLI.objValue;
    }
}
