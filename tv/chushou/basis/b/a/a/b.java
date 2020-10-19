package tv.chushou.basis.b.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.NetworkInterface;
import java.util.Collections;
/* loaded from: classes6.dex */
public class b {
    public static String getMacAddress(Context context) {
        String hh = hh(context);
        if (hh == null || hh.isEmpty()) {
            hh = Config.DEF_MAC_ID;
        }
        return hh.replace("?", "%3F").replace(ETAG.ITEM_SEPARATOR, "%26").replace("|", "%124").replace(ETAG.EQUAL, "%3D").replace("#", "%23").replace("/", "%2F").replace("+", "%2B").replace("%", "%25").trim();
    }

    private static String hh(Context context) {
        String hi = hi(context);
        if (TextUtils.isEmpty(hi)) {
            String etx = etx();
            if (TextUtils.isEmpty(etx)) {
                String ety = ety();
                if (TextUtils.isEmpty(ety)) {
                    String etz = etz();
                    if (TextUtils.isEmpty(etz)) {
                        return null;
                    }
                    return etz;
                }
                return ety;
            }
            return etx;
        }
        return hi;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003f A[ORIG_RETURN, RETURN] */
    @SuppressLint({"HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String hi(Context context) {
        String str;
        WifiInfo connectionInfo;
        try {
            connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        } catch (Exception e) {
            tv.chushou.basis.d.b.etC().e("MacAddressCompact", "get getMacAddress0 failed", e);
        }
        if (connectionInfo != null) {
            str = connectionInfo.getMacAddress();
            tv.chushou.basis.d.b.etC().d("MacAddressCompact", "getMacAddress0:" + str);
            if (Config.DEF_MAC_ID.equals(str)) {
                return str;
            }
            return null;
        }
        str = null;
        tv.chushou.basis.d.b.etC().d("MacAddressCompact", "getMacAddress0:" + str);
        if (Config.DEF_MAC_ID.equals(str)) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
        r0 = r1.trim();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String etx() {
        String str = null;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream()));
            String str2 = "";
            while (true) {
                if (str2 != null) {
                    str2 = lineNumberReader.readLine();
                    if (str2 != null) {
                        break;
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            tv.chushou.basis.d.b.etC().e("MacAddressCompact", "get getMacAddress1 failed", e);
        }
        tv.chushou.basis.d.b.etC().d("MacAddressCompact", "getMacAddress1:" + str);
        return str;
    }

    private static String ety() {
        String str = null;
        try {
            str = tv.chushou.a.a.d.a.j(new File("/sys/class/net/eth0/address"), null);
        } catch (Exception e) {
            tv.chushou.basis.d.b.etC().e("MacAddressCompact", "get getMacAddress2 failed", e);
        }
        tv.chushou.basis.d.b.etC().d("MacAddressCompact", "getMacAddress2:" + str);
        return str;
    }

    private static String etz() {
        StringBuilder sb = new StringBuilder();
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
            }
        } catch (Exception e) {
            tv.chushou.basis.d.b.etC().e("MacAddressCompact", "get getMacAddress3 failed", e);
        }
        String sb2 = sb.toString();
        tv.chushou.basis.d.b.etC().d("MacAddressCompact", "getMacAddress3:" + sb2);
        return sb2;
    }
}
