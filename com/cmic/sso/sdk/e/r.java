package com.cmic.sso.sdk.e;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes10.dex */
public class r {
    public static String a(boolean z) {
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
                            sb.append(nextElement2.getHostAddress()).append(",");
                        }
                    }
                }
            }
            StringBuilder delete = !TextUtils.isEmpty(sb) ? sb.delete(sb.length() - 1, sb.length()) : sb;
            c.b("UmcIPUtils", "onlyMobileDataIp " + z + " IPV4 ip：" + delete.toString());
            return delete.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String aG(boolean z, boolean z2) {
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
                                        sb.append(hostAddress).append(",");
                                    }
                                } else {
                                    sb.append(hostAddress).append(",");
                                }
                            }
                        }
                    }
                }
            }
            StringBuilder delete = !TextUtils.isEmpty(sb) ? sb.delete(sb.length() - 1, sb.length()) : sb;
            c.b("UmcIPUtils", "onlyMobileDataIp " + z + " IPV6 ip：" + delete.toString());
            return delete.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
