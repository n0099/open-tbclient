package tv.chushou.basis.b.a.a;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
import kascend.core.KSDevice;
import tv.chushou.basis.d.a.b.d;
@SuppressLint({"HardwareIds"})
/* loaded from: classes6.dex */
public class a implements d {
    private ActivityManager activityManager;
    private final HashMap<String, String> orq = new HashMap<>();
    private KSDevice orr = null;
    private String imei = null;
    private String ors = null;
    private String ort = null;
    private volatile String oru = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.orq.put("device_board", Build.BOARD);
        this.orq.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.orq.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.orq.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.orq.put("device_cpuabi", Build.CPU_ABI);
            this.orq.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.orq.put("device_devicename", Build.DEVICE);
        this.orq.put("device_display", Build.DISPLAY);
        this.orq.put("device_finger", Build.FINGERPRINT);
        this.orq.put("device_hardware", Build.HARDWARE);
        this.orq.put("device_versionid", Build.ID);
        this.orq.put("device_model", Build.MODEL);
        this.orq.put("device_manufacturer", Build.MANUFACTURER);
        this.orq.put("device_product", Build.PRODUCT);
        this.orq.put("device_tags", Build.TAGS);
        this.orq.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.orq.put("device_user", Build.USER);
        this.orq.put("device_release", Build.VERSION.RELEASE);
        this.orq.put("device_codename", Build.VERSION.CODENAME);
        this.orq.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.orq.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.orq.put("device_serial", Build.SERIAL);
        this.orq.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.ort = sharedPreferences.getString("deviceds", null);
        axd();
        getIdentifier();
        dZx();
        dZy();
        this.oru = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String axd() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dZF = tv.chushou.basis.d.b.dZF();
        if (dZF.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dZF.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dZx() {
        if (TextUtils.isEmpty(this.ors)) {
            try {
                if (this.orr == null) {
                    Application dZF = tv.chushou.basis.d.b.dZF();
                    this.orq.put("device_id", Settings.Secure.getString(dZF.getContentResolver(), "android_id"));
                    this.orq.put("device_mac", getLocalMacAddress(dZF));
                    this.orr = new KSDevice();
                    this.orr.setDevice(tv.chushou.basis.d.b.dZF(), this.orq);
                }
                this.ors = this.orr.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dZG().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.ors;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dZy() {
        if (TextUtils.isEmpty(this.ort)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.ort = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.ort)) {
                    if (this.orr == null) {
                        Application dZF = tv.chushou.basis.d.b.dZF();
                        this.orq.put("device_id", Settings.Secure.getString(dZF.getContentResolver(), "android_id"));
                        this.orq.put("device_mac", getLocalMacAddress(dZF));
                        this.orr = new KSDevice();
                        this.orr.setDevice(tv.chushou.basis.d.b.dZF(), this.orq);
                    }
                    this.ort = this.orr.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.ort);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dZG().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.ort;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dZz() {
        return this.orq;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dZF().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dZA();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("identifier", this.identifier);
                edit.apply();
            }
        }
        return this.identifier;
    }

    private String getLocalMacAddress(Context context) {
        return b.getMacAddress(context);
    }

    private String dZA() {
        String axd = axd();
        String decrypt = !TextUtils.isEmpty(axd) ? tv.chushou.basis.b.a.a.a.b.decrypt(axd) : axd;
        String str = this.orq.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dZF());
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = !TextUtils.isEmpty(decrypt) ? "" + decrypt : "";
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + str;
        }
        int hashCode = (str2 + String.valueOf(currentTimeMillis)).hashCode();
        String valueOf = String.valueOf(Math.abs(hashCode));
        if (hashCode == Integer.MIN_VALUE) {
            return String.valueOf(Math.abs(Long.valueOf(hashCode).longValue()));
        }
        return valueOf;
    }
}
