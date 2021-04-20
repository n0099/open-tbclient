package d.p.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.apollon.statistics.g;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Intent f68268a;

        public final int e() {
            return this.f68268a.getIntExtra("level", 0);
        }

        public final int f() {
            return this.f68268a.getIntExtra("scale", 0);
        }

        public final int g() {
            return this.f68268a.getIntExtra("temperature", 0);
        }

        public final int h() {
            return this.f68268a.getIntExtra("voltage", 0);
        }

        public b(Context context) {
            this.f68268a = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    public static String a(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            String p = p();
            if (!TextUtils.isEmpty(p)) {
                jSONObject.put(IAdRequestParam.OS, p);
            }
            String i = i(context);
            if (!TextUtils.isEmpty(i)) {
                jSONObject.put("imei", i);
            }
            String m = m(context);
            if (!TextUtils.isEmpty(m)) {
                jSONObject.put("meid", m);
            }
            String j = j(context);
            if (!TextUtils.isEmpty(j)) {
                jSONObject.put("imsi", j);
            }
            String k = k(context);
            if (!TextUtils.isEmpty(k)) {
                jSONObject.put(IAdRequestParam.MAC, k);
            }
            String h2 = h(context);
            if (!TextUtils.isEmpty(h2)) {
                jSONObject.put("iccid", h2);
            }
            String s = s();
            if (!TextUtils.isEmpty(s)) {
                jSONObject.put("serial", s);
            }
            String c2 = c(context);
            if (!TextUtils.isEmpty(c2)) {
                jSONObject.put("androidid", c2);
            }
            String f2 = f();
            if (!TextUtils.isEmpty(f2)) {
                jSONObject.put("cpu", f2);
            }
            String o = o();
            if (!TextUtils.isEmpty(o)) {
                jSONObject.put("model", o);
            }
            String r = r();
            if (!TextUtils.isEmpty(r)) {
                jSONObject.put("sdcard", r);
            }
            String q = q(context);
            if (!TextUtils.isEmpty(q)) {
                jSONObject.put("resolution", q);
            }
            String u = u(context);
            if (!TextUtils.isEmpty(u)) {
                jSONObject.put("ssid", u);
            }
            String v = v(context);
            if (!TextUtils.isEmpty(v)) {
                jSONObject.put("bssid", v);
            }
            String g2 = g();
            if (!TextUtils.isEmpty(g2)) {
                jSONObject.put("deviceName", g2);
            }
            String e2 = e(context);
            if (!TextUtils.isEmpty(e2)) {
                jSONObject.put("connecttype", e2);
            }
            try {
                str = b(context);
            } catch (Exception e3) {
                e3.printStackTrace();
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("ua", str);
            }
            double d2 = d(context);
            jSONObject.put("batterymaxcapacity", String.valueOf(d2));
            jSONObject.put("batterycurrentcapacity", String.valueOf(d2));
            b bVar = new b(context);
            jSONObject.put("batterycurrentvoltage", bVar.h());
            jSONObject.put("batterycurrenttemperature", bVar.g());
            jSONObject.put("batterycurrentcapacity", (d2 * bVar.e()) / bVar.f());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String b(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = (TextUtils.isEmpty(packageName) || !packageName.contains("com.sina.weibo")) ? "ssosdk" : "weibo";
        sb.append(Build.MANUFACTURER);
        sb.append("-");
        sb.append(Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append("1.0".replaceAll("\\s+", "_"));
        } catch (Exception unused) {
            sb.append("unknown");
        }
        sb.append("__");
        sb.append("android");
        sb.append("__android");
        sb.append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    public static String c(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        } catch (Exception unused) {
            return "";
        }
    }

    public static double d(Context context) {
        Object obj;
        try {
            obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
        } catch (Exception unused) {
            obj = null;
        }
        try {
            return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(obj, "battery.capacity")).doubleValue();
        } catch (Exception unused2) {
            return 0.0d;
        }
    }

    public static String e(Context context) {
        NetworkInfo activeNetworkInfo;
        String str;
        String str2 = "none";
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = "2G";
                        str2 = str;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str = g.f3909b;
                        str2 = str;
                        break;
                    case 13:
                        str = "4G";
                        str2 = str;
                        break;
                }
            } else if (activeNetworkInfo.getType() == 1) {
                str = "wifi";
                str2 = str;
            }
            return str2;
        }
        return str2;
    }

    public static String f() {
        try {
            return Build.CPU_ABI;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g() {
        try {
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String i(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String j(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String k(Context context) {
        WifiInfo connectionInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            return l();
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String l() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(NetworkInfoUtils.NETWORK_NAME)) {
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
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String n(Context context) {
        try {
            return new String(a(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String o() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String p() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String q(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(displayMetrics.widthPixels) + "*" + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String r() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String s() {
        if (Build.VERSION.SDK_INT >= 26) {
            return t();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception unused) {
            return "";
        }
    }

    @TargetApi(26)
    public static String t() {
        try {
            return Build.getSerial();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String u(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getSSID() : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String v(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            return connectionInfo != null ? connectionInfo.getBSSID() : "";
        } catch (SecurityException unused) {
            return "";
        }
    }

    public static void w(Context context) {
    }
}
