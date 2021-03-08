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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
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
    public static final class C1264a {
        private Intent qjP;

        private C1264a(Context context) {
            this.qjP = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getLevel() {
            return this.qjP.getIntExtra("level", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int eIQ() {
            return this.qjP.getIntExtra("scale", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int eIR() {
            return this.qjP.getIntExtra("voltage", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int eIS() {
            return this.qjP.getIntExtra("temperature", 0);
        }
    }

    public static void init(Context context) {
    }

    public static String getMfp(Context context) {
        try {
            return new String(iE(context).getBytes(), "UTF-8");
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
        sb.append("__").append(HttpConstants.OS_TYPE_VALUE).append("__android").append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    private static String iE(Context context) {
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
            String iF = iF(context);
            if (!TextUtils.isEmpty(iF)) {
                jSONObject.put("meid", iF);
            }
            String imsi = getImsi(context);
            if (!TextUtils.isEmpty(imsi)) {
                jSONObject.put("imsi", imsi);
            }
            String iG = iG(context);
            if (!TextUtils.isEmpty(iG)) {
                jSONObject.put("mac", iG);
            }
            String iccid = getIccid(context);
            if (!TextUtils.isEmpty(iccid)) {
                jSONObject.put("iccid", iccid);
            }
            String eIM = eIM();
            if (!TextUtils.isEmpty(eIM)) {
                jSONObject.put("serial", eIM);
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                jSONObject.put("androidid", androidId);
            }
            String eIO = eIO();
            if (!TextUtils.isEmpty(eIO)) {
                jSONObject.put("cpu", eIO);
            }
            String model = getModel();
            if (!TextUtils.isEmpty(model)) {
                jSONObject.put("model", model);
            }
            String eIP = eIP();
            if (!TextUtils.isEmpty(eIP)) {
                jSONObject.put("sdcard", eIP);
            }
            String iI = iI(context);
            if (!TextUtils.isEmpty(iI)) {
                jSONObject.put("resolution", iI);
            }
            String ssid = getSsid(context);
            if (!TextUtils.isEmpty(ssid)) {
                jSONObject.put("ssid", ssid);
            }
            String iJ = iJ(context);
            if (!TextUtils.isEmpty(iJ)) {
                jSONObject.put("bssid", iJ);
            }
            String deviceName = getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                jSONObject.put("deviceName", deviceName);
            }
            String iK = iK(context);
            if (!TextUtils.isEmpty(iK)) {
                jSONObject.put("connecttype", iK);
            }
            try {
                generateUAAid = generateUAAid(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(generateUAAid)) {
                jSONObject.put(j.c, generateUAAid);
            }
            double iH = iH(context);
            jSONObject.put("batterymaxcapacity", String.valueOf(iH));
            jSONObject.put("batterycurrentcapacity", String.valueOf(iH));
            C1264a c1264a = new C1264a(context);
            jSONObject.put("batterycurrentvoltage", c1264a.eIR());
            jSONObject.put("batterycurrenttemperature", c1264a.eIS());
            jSONObject.put("batterycurrentcapacity", (iH * c1264a.getLevel()) / c1264a.eIQ());
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

    private static String iF(Context context) {
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

    private static String getMacAddr() {
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

    private static String iG(Context context) {
        WifiInfo connectionInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            return getMacAddr();
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

    private static String eIM() {
        if (Build.VERSION.SDK_INT >= 26) {
            return eIN();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception e) {
            return "";
        }
    }

    private static double iH(Context context) {
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
    private static String eIN() {
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

    private static String eIO() {
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

    private static String eIP() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception e) {
            return "";
        }
    }

    private static String iI(Context context) {
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

    public static String iJ(Context context) {
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

    private static String iK(Context context) {
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
