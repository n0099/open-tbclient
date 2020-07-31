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
    private final HashMap<String, String> oro = new HashMap<>();
    private KSDevice orp = null;
    private String imei = null;
    private String orq = null;
    private String orr = null;
    private volatile String ors = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.oro.put("device_board", Build.BOARD);
        this.oro.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.oro.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.oro.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.oro.put("device_cpuabi", Build.CPU_ABI);
            this.oro.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.oro.put("device_devicename", Build.DEVICE);
        this.oro.put("device_display", Build.DISPLAY);
        this.oro.put("device_finger", Build.FINGERPRINT);
        this.oro.put("device_hardware", Build.HARDWARE);
        this.oro.put("device_versionid", Build.ID);
        this.oro.put("device_model", Build.MODEL);
        this.oro.put("device_manufacturer", Build.MANUFACTURER);
        this.oro.put("device_product", Build.PRODUCT);
        this.oro.put("device_tags", Build.TAGS);
        this.oro.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.oro.put("device_user", Build.USER);
        this.oro.put("device_release", Build.VERSION.RELEASE);
        this.oro.put("device_codename", Build.VERSION.CODENAME);
        this.oro.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.oro.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.oro.put("device_serial", Build.SERIAL);
        this.oro.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.orr = sharedPreferences.getString("deviceds", null);
        axd();
        getIdentifier();
        dZw();
        dZx();
        this.ors = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String axd() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dZE = tv.chushou.basis.d.b.dZE();
        if (dZE.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dZE.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dZw() {
        if (TextUtils.isEmpty(this.orq)) {
            try {
                if (this.orp == null) {
                    Application dZE = tv.chushou.basis.d.b.dZE();
                    this.oro.put("device_id", Settings.Secure.getString(dZE.getContentResolver(), "android_id"));
                    this.oro.put("device_mac", getLocalMacAddress(dZE));
                    this.orp = new KSDevice();
                    this.orp.setDevice(tv.chushou.basis.d.b.dZE(), this.oro);
                }
                this.orq = this.orp.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dZF().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.orq;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dZx() {
        if (TextUtils.isEmpty(this.orr)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dZE().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.orr = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.orr)) {
                    if (this.orp == null) {
                        Application dZE = tv.chushou.basis.d.b.dZE();
                        this.oro.put("device_id", Settings.Secure.getString(dZE.getContentResolver(), "android_id"));
                        this.oro.put("device_mac", getLocalMacAddress(dZE));
                        this.orp = new KSDevice();
                        this.orp.setDevice(tv.chushou.basis.d.b.dZE(), this.oro);
                    }
                    this.orr = this.orp.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.orr);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dZF().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.orr;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dZy() {
        return this.oro;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dZE().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dZz();
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

    private String dZz() {
        String axd = axd();
        String decrypt = !TextUtils.isEmpty(axd) ? tv.chushou.basis.b.a.a.a.b.decrypt(axd) : axd;
        String str = this.oro.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dZE());
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
