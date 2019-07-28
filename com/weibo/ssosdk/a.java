package com.weibo.ssosdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.Headers;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.sina.weibo.BuildConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private static void Ib(String str) {
        Log.e("MfpBuilder", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.weibo.ssosdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0482a {
        private Intent kqT;

        private C0482a(Context context) {
            this.kqT = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getLevel() {
            return this.kqT.getIntExtra("level", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int cNc() {
            return this.kqT.getIntExtra("scale", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int cNd() {
            return this.kqT.getIntExtra("voltage", 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int cNe() {
            return this.kqT.getIntExtra("temperature", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        private static LocationManager kqU;
        private static String kqV;
        private static Location kqW;
        private static LocationListener kqX = new LocationListener() { // from class: com.weibo.ssosdk.a.b.1
            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                Location unused = b.kqW = location;
                b.kqU.removeUpdates(this);
                b.kqU.requestLocationUpdates(b.kqV, ReportUserInfoModel.TIME_INTERVAL, 10.0f, b.kqX);
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"MissingPermission"})
        public static void init(Context context) {
            kqU = (LocationManager) context.getSystemService(Headers.LOCATION);
            List<String> providers = kqU.getProviders(true);
            if (providers.contains("gps")) {
                kqV = "gps";
            } else if (providers.contains("network")) {
                kqV = "network";
            } else {
                return;
            }
            Location lastKnownLocation = kqU.getLastKnownLocation(kqV);
            if (lastKnownLocation != null) {
                kqW = lastKnownLocation;
            } else {
                kqU.requestLocationUpdates(kqV, 0L, 0.0f, kqX);
            }
        }

        public static String cNf() {
            return kqW == null ? "" : String.valueOf(kqW.getLatitude()) + "_" + String.valueOf(kqW.getLongitude());
        }
    }

    public static void init(Context context) {
        b.init(context);
    }

    public static String getMfp(Context context) {
        try {
            return new String(eH(context).getBytes(), HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static String generateUAAid(Context context) {
        StringBuilder sb = new StringBuilder();
        String packageName = context.getPackageName();
        String str = "ssosdk";
        if (!TextUtils.isEmpty(packageName) && packageName.contains(BuildConfig.APPLICATION_ID)) {
            str = "weibo";
        }
        sb.append(Build.MANUFACTURER).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(Build.MODEL);
        sb.append("__");
        sb.append(str);
        sb.append("__");
        try {
            sb.append("1.0".replaceAll("\\s+", "_"));
        } catch (Exception e) {
            sb.append("unknown");
        }
        sb.append("__").append("android").append("__android").append(Build.VERSION.RELEASE);
        return sb.toString();
    }

    private static String eH(Context context) {
        String generateUAAid;
        JSONObject jSONObject = new JSONObject();
        try {
            String WR = WR();
            if (!TextUtils.isEmpty(WR)) {
                jSONObject.put(IXAdRequestInfo.OS, WR);
            }
            String imei = getImei(context);
            if (!TextUtils.isEmpty(imei)) {
                jSONObject.put("imei", imei);
            }
            String eI = eI(context);
            if (!TextUtils.isEmpty(eI)) {
                jSONObject.put("meid", eI);
            }
            String imsi = getImsi(context);
            if (!TextUtils.isEmpty(imsi)) {
                jSONObject.put("imsi", imsi);
            }
            String mac = getMac(context);
            if (!TextUtils.isEmpty(mac)) {
                jSONObject.put("mac", mac);
            }
            String iccid = getIccid(context);
            if (!TextUtils.isEmpty(iccid)) {
                jSONObject.put("iccid", iccid);
            }
            String cMW = cMW();
            if (!TextUtils.isEmpty(cMW)) {
                jSONObject.put("serial", cMW);
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                jSONObject.put("androidid", androidId);
            }
            String cMY = cMY();
            if (!TextUtils.isEmpty(cMY)) {
                jSONObject.put("cpu", cMY);
            }
            String cMZ = cMZ();
            if (!TextUtils.isEmpty(cMZ)) {
                jSONObject.put("model", cMZ);
            }
            String cNa = cNa();
            if (!TextUtils.isEmpty(cNa)) {
                jSONObject.put("sdcard", cNa);
            }
            String eK = eK(context);
            if (!TextUtils.isEmpty(eK)) {
                jSONObject.put("resolution", eK);
            }
            String ssid = getSsid(context);
            if (!TextUtils.isEmpty(ssid)) {
                jSONObject.put("ssid", ssid);
            }
            String eL = eL(context);
            if (!TextUtils.isEmpty(eL)) {
                jSONObject.put("bssid", eL);
            }
            String cNb = cNb();
            if (!TextUtils.isEmpty(cNb)) {
                jSONObject.put("deviceName", cNb);
            }
            String eM = eM(context);
            if (!TextUtils.isEmpty(eM)) {
                jSONObject.put("connecttype", eM);
            }
            try {
                generateUAAid = generateUAAid(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(generateUAAid)) {
                jSONObject.put("ua", generateUAAid);
            }
            String cNf = b.cNf();
            if (!TextUtils.isEmpty(cNf)) {
                jSONObject.put("LBS", cNf);
            }
            double eJ = eJ(context);
            jSONObject.put("batterymaxcapacity", String.valueOf(eJ));
            jSONObject.put("batterycurrentcapacity", String.valueOf(eJ));
            C0482a c0482a = new C0482a(context);
            jSONObject.put("batterycurrentvoltage", c0482a.cNd());
            jSONObject.put("batterycurrenttemperature", c0482a.cNe());
            jSONObject.put("batterycurrentcapacity", (eJ * c0482a.getLevel()) / c0482a.cNc());
            return jSONObject.toString();
        } catch (JSONException e2) {
            return "";
        }
    }

    private static String WR() {
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

    private static String eI(Context context) {
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

    private static String cMV() {
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

    private static String getMac(Context context) {
        WifiInfo connectionInfo;
        if (Build.VERSION.SDK_INT >= 23) {
            return cMV();
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
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

    private static String cMW() {
        if (Build.VERSION.SDK_INT >= 26) {
            return cMX();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception e) {
            Ib("getSerialNo" + e.toString());
            return "";
        }
    }

    private static double eJ(Context context) {
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
    private static String cMX() {
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

    private static String cMY() {
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return "";
        }
    }

    private static String cMZ() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return "";
        }
    }

    private static String cNa() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception e) {
            return "";
        }
    }

    private static String eK(Context context) {
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
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String eL(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getBSSID();
            }
        } catch (SecurityException e) {
        }
        return "";
    }

    private static String cNb() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            return "";
        }
    }

    private static String eM(Context context) {
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
                            str = IXAdSystemUtils.NT_NONE;
                            break;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    str = IXAdSystemUtils.NT_WIFI;
                }
                return str;
            }
            str = IXAdSystemUtils.NT_NONE;
            return str;
        } catch (Exception e) {
            return IXAdSystemUtils.NT_NONE;
        }
    }
}
