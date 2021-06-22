package d.a.n0.z0;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.net.NetworkInterface;
import java.util.Enumeration;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public String f54807a;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f54808a = new g();
    }

    public static g c() {
        return b.f54808a;
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
        if (context != null && StringUtils.isNull(this.f54807a)) {
            if (TbadkCoreApplication.getInst().isAllActivityBackground()) {
                return this.f54807a;
            }
            try {
            } catch (Exception e2) {
                this.f54807a = "";
                e2.printStackTrace();
            }
            if (Build.VERSION.SDK_INT < 23) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    this.f54807a = connectionInfo.getMacAddress();
                }
                return this.f54807a;
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
                    this.f54807a = stringBuffer.toString();
                    if (NetworkInfoUtils.NETWORK_NAME.equals(nextElement.getName())) {
                        return this.f54807a;
                    }
                }
            }
            return this.f54807a;
        }
        return this.f54807a;
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
        this.f54807a = null;
    }
}
