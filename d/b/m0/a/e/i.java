package d.b.m0.a.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobstat.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.NetworkInterface;
import java.util.Collections;
/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f64085a;

    /* renamed from: b  reason: collision with root package name */
    public static String f64086b;

    /* renamed from: c  reason: collision with root package name */
    public static String f64087c;

    public static String a() {
        if (TextUtils.isEmpty(f64087c)) {
            k(d.b.m0.a.c.i().g());
        }
        return f64087c;
    }

    public static String b(WifiManager wifiManager) throws Exception {
        String str = "";
        boolean z = 3 == wifiManager.getWifiState();
        try {
            wifiManager.setWifiEnabled(true);
            FileInputStream fileInputStream = new FileInputStream(new File("/sys/class/net/wlan0/address"));
            str = c(fileInputStream);
            fileInputStream.close();
        } catch (Exception e2) {
            d.b.m0.a.f.i.d(e2);
        }
        wifiManager.setWifiEnabled(z);
        return str;
    }

    public static String c(InputStream inputStream) throws IOException {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[2048];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    inputStream.close();
                    return stringWriter.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static String d() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
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
            }
            return null;
        } catch (Exception e2) {
            d.b.m0.a.f.i.d(e2);
            return null;
        }
    }

    public static String e(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            d.b.m0.a.f.i.d(e2);
            return "NA";
        }
    }

    public static int f(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                return 1;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null) {
                NetworkInfo.State state2 = networkInfo2.getState();
                String subtypeName = networkInfo2.getSubtypeName();
                if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 3 : 5;
                    }
                }
            }
        }
        return 0;
    }

    public static String g(Context context) {
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return deviceId == null ? "" : d.b.m0.a.f.e.a(deviceId);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null || !Config.DEF_MAC_ID.equals(connectionInfo.getMacAddress())) {
            return (connectionInfo == null || connectionInfo.getMacAddress() == null) ? "" : d.b.m0.a.f.e.a(connectionInfo.getMacAddress());
        }
        try {
            String d2 = d();
            if (d2 != null) {
                return d.b.m0.a.f.e.a(d2);
            }
            return d.b.m0.a.f.e.a(b(wifiManager));
        } catch (Exception e2) {
            d.b.m0.a.f.i.d(e2);
            return d.b.m0.a.f.e.a(Config.DEF_MAC_ID);
        }
    }

    public static String i(Context context) {
        int i = 0;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            d.b.m0.a.f.i.d(e2);
        }
        return String.valueOf(i);
    }

    public static String j(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            return packageInfo != null ? packageInfo.versionName == null ? StringUtil.NULL_STRING : packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException e2) {
            d.b.m0.a.f.i.d(e2);
            return "";
        }
    }

    public static void k(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        f64085a = String.valueOf(displayMetrics.widthPixels);
        f64086b = String.valueOf(displayMetrics.heightPixels);
        f64087c = String.valueOf(displayMetrics.density);
    }

    public static String l(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e2) {
            d.b.m0.a.f.i.d(e2);
            return null;
        }
    }

    public static String m() {
        if (TextUtils.isEmpty(f64085a)) {
            k(d.b.m0.a.c.i().g());
        }
        return f64085a;
    }

    public static String n() {
        if (TextUtils.isEmpty(f64086b)) {
            k(d.b.m0.a.c.i().g());
        }
        return f64086b;
    }
}
