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
/* loaded from: classes5.dex */
public class a implements d {
    private ActivityManager activityManager;
    private final HashMap<String, String> oiE = new HashMap<>();
    private KSDevice oiF = null;
    private String imei = null;
    private String oiG = null;
    private String oiH = null;
    private volatile String oiI = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.oiE.put("device_board", Build.BOARD);
        this.oiE.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.oiE.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.oiE.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.oiE.put("device_cpuabi", Build.CPU_ABI);
            this.oiE.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.oiE.put("device_devicename", Build.DEVICE);
        this.oiE.put("device_display", Build.DISPLAY);
        this.oiE.put("device_finger", Build.FINGERPRINT);
        this.oiE.put("device_hardware", Build.HARDWARE);
        this.oiE.put("device_versionid", Build.ID);
        this.oiE.put("device_model", Build.MODEL);
        this.oiE.put("device_manufacturer", Build.MANUFACTURER);
        this.oiE.put("device_product", Build.PRODUCT);
        this.oiE.put("device_tags", Build.TAGS);
        this.oiE.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.oiE.put("device_user", Build.USER);
        this.oiE.put("device_release", Build.VERSION.RELEASE);
        this.oiE.put("device_codename", Build.VERSION.CODENAME);
        this.oiE.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.oiE.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.oiE.put("device_serial", Build.SERIAL);
        this.oiE.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.oiH = sharedPreferences.getString("deviceds", null);
        auX();
        getIdentifier();
        dWa();
        dWb();
        this.oiI = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String auX() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dWi = tv.chushou.basis.d.b.dWi();
        if (dWi.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dWi.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dWa() {
        if (TextUtils.isEmpty(this.oiG)) {
            try {
                if (this.oiF == null) {
                    Application dWi = tv.chushou.basis.d.b.dWi();
                    this.oiE.put("device_id", Settings.Secure.getString(dWi.getContentResolver(), "android_id"));
                    this.oiE.put("device_mac", getLocalMacAddress(dWi));
                    this.oiF = new KSDevice();
                    this.oiF.setDevice(tv.chushou.basis.d.b.dWi(), this.oiE);
                }
                this.oiG = this.oiF.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dWj().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.oiG;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dWb() {
        if (TextUtils.isEmpty(this.oiH)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dWi().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.oiH = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.oiH)) {
                    if (this.oiF == null) {
                        Application dWi = tv.chushou.basis.d.b.dWi();
                        this.oiE.put("device_id", Settings.Secure.getString(dWi.getContentResolver(), "android_id"));
                        this.oiE.put("device_mac", getLocalMacAddress(dWi));
                        this.oiF = new KSDevice();
                        this.oiF.setDevice(tv.chushou.basis.d.b.dWi(), this.oiE);
                    }
                    this.oiH = this.oiF.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.oiH);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dWj().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.oiH;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dWc() {
        return this.oiE;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dWi().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dWd();
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

    private String dWd() {
        String auX = auX();
        String decrypt = !TextUtils.isEmpty(auX) ? tv.chushou.basis.b.a.a.a.b.decrypt(auX) : auX;
        String str = this.oiE.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dWi());
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
