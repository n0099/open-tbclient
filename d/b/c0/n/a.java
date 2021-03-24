package d.b.c0.n;

import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes2.dex */
public class a {
    public static String a() {
        byte[] hardwareAddress;
        try {
            InetAddress e2 = e();
            if (e2 == null || (hardwareAddress = NetworkInterface.getByInetAddress(e2).getHardwareAddress()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i != 0) {
                    sb.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                if (hexString.length() == 1) {
                    hexString = 0 + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        return ((WifiManager) g.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }

    public static String c() {
        String f2;
        if (Build.VERSION.SDK_INT < 23) {
            f2 = b();
        } else {
            f2 = f();
        }
        if (!d(f2)) {
            f2 = a();
        }
        return !TextUtils.isEmpty(f2) ? f2.toUpperCase() : f2;
    }

    public static boolean d(String str) {
        return (TextUtils.isEmpty(str) || str.equals(Config.DEF_MAC_ID)) ? false : true;
    }

    public static InetAddress e() {
        InetAddress inetAddress = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            InetAddress inetAddress2 = null;
            do {
                try {
                    if (!networkInterfaces.hasMoreElements()) {
                        return inetAddress2;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement = inetAddresses.nextElement();
                            try {
                                if (!nextElement.isLoopbackAddress() && !nextElement.getHostAddress().contains(":")) {
                                    inetAddress2 = nextElement;
                                    continue;
                                    break;
                                }
                                inetAddress2 = null;
                            } catch (Exception unused) {
                                return nextElement;
                            }
                        }
                    }
                } catch (Exception unused2) {
                    inetAddress = inetAddress2;
                    return inetAddress;
                }
            } while (inetAddress2 == null);
            return inetAddress2;
        } catch (Exception unused3) {
        }
    }

    public static String f() {
        byte[] hardwareAddress;
        try {
            NetworkInterface byName = NetworkInterface.getByName("wlan0");
            if (byName != null && (hardwareAddress = byName.getHardwareAddress()) != null) {
                StringBuilder sb = new StringBuilder();
                int length = hardwareAddress.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }
}
