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
    private final HashMap<String, String> oiB = new HashMap<>();
    private KSDevice oiC = null;
    private String imei = null;
    private String oiD = null;
    private String oiE = null;
    private volatile String oiF = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.oiB.put("device_board", Build.BOARD);
        this.oiB.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.oiB.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.oiB.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.oiB.put("device_cpuabi", Build.CPU_ABI);
            this.oiB.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.oiB.put("device_devicename", Build.DEVICE);
        this.oiB.put("device_display", Build.DISPLAY);
        this.oiB.put("device_finger", Build.FINGERPRINT);
        this.oiB.put("device_hardware", Build.HARDWARE);
        this.oiB.put("device_versionid", Build.ID);
        this.oiB.put("device_model", Build.MODEL);
        this.oiB.put("device_manufacturer", Build.MANUFACTURER);
        this.oiB.put("device_product", Build.PRODUCT);
        this.oiB.put("device_tags", Build.TAGS);
        this.oiB.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.oiB.put("device_user", Build.USER);
        this.oiB.put("device_release", Build.VERSION.RELEASE);
        this.oiB.put("device_codename", Build.VERSION.CODENAME);
        this.oiB.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.oiB.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.oiB.put("device_serial", Build.SERIAL);
        this.oiB.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.oiE = sharedPreferences.getString("deviceds", null);
        auX();
        getIdentifier();
        dVW();
        dVX();
        this.oiF = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String auX() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dWe = tv.chushou.basis.d.b.dWe();
        if (dWe.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dWe.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dVW() {
        if (TextUtils.isEmpty(this.oiD)) {
            try {
                if (this.oiC == null) {
                    Application dWe = tv.chushou.basis.d.b.dWe();
                    this.oiB.put("device_id", Settings.Secure.getString(dWe.getContentResolver(), "android_id"));
                    this.oiB.put("device_mac", getLocalMacAddress(dWe));
                    this.oiC = new KSDevice();
                    this.oiC.setDevice(tv.chushou.basis.d.b.dWe(), this.oiB);
                }
                this.oiD = this.oiC.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dWf().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.oiD;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dVX() {
        if (TextUtils.isEmpty(this.oiE)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dWe().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.oiE = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.oiE)) {
                    if (this.oiC == null) {
                        Application dWe = tv.chushou.basis.d.b.dWe();
                        this.oiB.put("device_id", Settings.Secure.getString(dWe.getContentResolver(), "android_id"));
                        this.oiB.put("device_mac", getLocalMacAddress(dWe));
                        this.oiC = new KSDevice();
                        this.oiC.setDevice(tv.chushou.basis.d.b.dWe(), this.oiB);
                    }
                    this.oiE = this.oiC.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.oiE);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dWf().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.oiE;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dVY() {
        return this.oiB;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dWe().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dVZ();
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

    private String dVZ() {
        String auX = auX();
        String decrypt = !TextUtils.isEmpty(auX) ? tv.chushou.basis.b.a.a.a.b.decrypt(auX) : auX;
        String str = this.oiB.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dWe());
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
