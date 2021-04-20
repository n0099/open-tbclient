package com.cmic.sso.sdk.d;

import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes5.dex */
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

    public static String a(boolean z, boolean z2) {
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
}
