package d.a.m0.z0;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f51023a = new g();
    }

    public static g c() {
        return b.f51023a;
    }

    public String a() {
        return Build.BRAND;
    }

    @RequiresApi(api = 17)
    public final DisplayMetrics b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context == null) {
            return displayMetrics;
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public String d(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            if (Build.VERSION.SDK_INT < 23) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getMacAddress();
                }
                return null;
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                byte[] hardwareAddress = nextElement.getHardwareAddress();
                if (hardwareAddress != null && hardwareAddress.length != 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = hardwareAddress.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        stringBuffer.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                    }
                    if (stringBuffer.length() > 0) {
                        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    }
                    str = stringBuffer.toString();
                    if (NetworkInfoUtils.NETWORK_NAME.equals(nextElement.getName())) {
                        return str;
                    }
                }
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @RequiresApi(api = 17)
    public String e(Context context) {
        return String.valueOf(b(context).heightPixels);
    }

    @RequiresApi(api = 17)
    public String f(Context context) {
        return String.valueOf(b(context).widthPixels);
    }

    public String g() {
        return Build.DEVICE;
    }

    public String h() {
        return Build.MODEL;
    }

    public g() {
    }
}
