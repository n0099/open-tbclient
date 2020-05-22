package com.weibo.ssosdk;

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
import com.baidu.fsg.base.statistics.j;
import com.baidu.fsg.face.base.b.c;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.weibo.ssosdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0858a {
        private Intent nkH;

        private C0858a(Context context) {
            this.nkH = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getLevel() {
            return this.nkH.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int dJI() {
            return this.nkH.getIntExtra("scale", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int dJJ() {
            return this.nkH.getIntExtra("voltage", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int dJK() {
            return this.nkH.getIntExtra("temperature", 0);
        }
    }

    public static void init(Context context) {
    }

    public static String getMfp(Context context) {
        try {
            return new String(gc(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static String generateUAAid(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = "ssosdk";
        if (!TextUtils.isEmpty(packageName) && packageName.contains("com.sina.weibo")) {
            str = LogConfig.LIVE_SHARE_HK_WEIBO;
        }
        sb.append(Build.MANUFACTURER).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append("1.0".replaceAll("\\s+", PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS));
        } catch (Exception e) {
            sb.append("unknown");
        }
        sb.append("__").append("android").append("__android").append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    private static String gc(Context context) {
        String generateUAAid;
        JSONObject jSONObject = new JSONObject();
        try {
            String os = getOS();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("os", os);
            }
            String imei = getImei(context);
            if (!TextUtils.isEmpty(imei)) {
                jSONObject.put("imei", imei);
            }
            String ge = ge(context);
            if (!TextUtils.isEmpty(ge)) {
                jSONObject.put("meid", ge);
            }
            String imsi = getImsi(context);
            if (!TextUtils.isEmpty(imsi)) {
                jSONObject.put("imsi", imsi);
            }
            String gf = gf(context);
            if (!TextUtils.isEmpty(gf)) {
                jSONObject.put("mac", gf);
            }
            String iccid = getIccid(context);
            if (!TextUtils.isEmpty(iccid)) {
                jSONObject.put("iccid", iccid);
            }
            String dJE = dJE();
            if (!TextUtils.isEmpty(dJE)) {
                jSONObject.put("serial", dJE);
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                jSONObject.put("androidid", androidId);
            }
            String dJG = dJG();
            if (!TextUtils.isEmpty(dJG)) {
                jSONObject.put(c.i, dJG);
            }
            String model = getModel();
            if (!TextUtils.isEmpty(model)) {
                jSONObject.put("model", model);
            }
            String dJH = dJH();
            if (!TextUtils.isEmpty(dJH)) {
                jSONObject.put("sdcard", dJH);
            }
            String gh = gh(context);
            if (!TextUtils.isEmpty(gh)) {
                jSONObject.put("resolution", gh);
            }
            String ssid = getSsid(context);
            if (!TextUtils.isEmpty(ssid)) {
                jSONObject.put("ssid", ssid);
            }
            String gi = gi(context);
            if (!TextUtils.isEmpty(gi)) {
                jSONObject.put("bssid", gi);
            }
            String deviceName = getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                jSONObject.put("deviceName", deviceName);
            }
            String gj = gj(context);
            if (!TextUtils.isEmpty(gj)) {
                jSONObject.put("connecttype", gj);
            }
            try {
                generateUAAid = generateUAAid(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(generateUAAid)) {
                jSONObject.put(j.c, generateUAAid);
            }
            double gg = gg(context);
            jSONObject.put("batterymaxcapacity", String.valueOf(gg));
            jSONObject.put("batterycurrentcapacity", String.valueOf(gg));
            C0858a c0858a = new C0858a(context);
            jSONObject.put("batterycurrentvoltage", c0858a.dJJ());
            jSONObject.put("batterycurrenttemperature", c0858a.dJK());
            jSONObject.put("batterycurrentcapacity", (gg * c0858a.getLevel()) / c0858a.dJI());
            return jSONObject.toString();
        } catch (JSONException e2) {
            return "";
        }
    }

    private static String getOS() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String ge(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getImsi(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String dJD() {
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
        } catch (Exception e) {
        }
        return "";
    }

    private static String gf(Context context) {
        WifiInfo connectionInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            return dJD();
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getIccid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            return "";
        }
    }

    private static String dJE() {
        if (Build.VERSION.SDK_INT >= 26) {
            return dJF();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception e) {
            return "";
        }
    }

    private static double gg(Context context) {
        Object obj = null;
        try {
            obj = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
        } catch (Exception e) {
        }
        try {
            return ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(obj, "battery.capacity")).doubleValue();
        } catch (Exception e2) {
            return 0.0d;
        }
    }

    @TargetApi(26)
    private static String dJF() {
        try {
            return Build.getSerial();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return "";
        }
    }

    private static String dJG() {
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getModel() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return "";
        }
    }

    private static String dJH() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception e) {
            return "";
        }
    }

    private static String gh(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(displayMetrics.widthPixels) + "*" + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSsid(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String gi(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getBSSID();
            }
        } catch (SecurityException e) {
        }
        return "";
    }

    private static String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            return "";
        }
    }

    private static String gj(Context context) {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2G";
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
                            str = "3G";
                            break;
                        case 13:
                            str = "4G";
                            break;
                        default:
                            str = "none";
                            break;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    str = "wifi";
                }
                return str;
            }
            str = "none";
            return str;
        } catch (Exception e) {
            return "none";
        }
    }
}
