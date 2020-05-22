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
    private final HashMap<String, String> nLD = new HashMap<>();
    private KSDevice nLE = null;
    private String imei = null;
    private String nLF = null;
    private String nLG = null;
    private volatile String nLH = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nLD.put("device_board", Build.BOARD);
        this.nLD.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nLD.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nLD.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nLD.put("device_cpuabi", Build.CPU_ABI);
            this.nLD.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nLD.put("device_devicename", Build.DEVICE);
        this.nLD.put("device_display", Build.DISPLAY);
        this.nLD.put("device_finger", Build.FINGERPRINT);
        this.nLD.put("device_hardware", Build.HARDWARE);
        this.nLD.put("device_versionid", Build.ID);
        this.nLD.put("device_model", Build.MODEL);
        this.nLD.put("device_manufacturer", Build.MANUFACTURER);
        this.nLD.put("device_product", Build.PRODUCT);
        this.nLD.put("device_tags", Build.TAGS);
        this.nLD.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.nLD.put("device_user", Build.USER);
        this.nLD.put("device_release", Build.VERSION.RELEASE);
        this.nLD.put("device_codename", Build.VERSION.CODENAME);
        this.nLD.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nLD.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nLD.put("device_serial", Build.SERIAL);
        this.nLD.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nLG = sharedPreferences.getString("deviceds", null);
        atR();
        getIdentifier();
        dRc();
        dRd();
        this.nLH = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String atR() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dRk = tv.chushou.basis.d.b.dRk();
        if (dRk.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dRk.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dRc() {
        if (TextUtils.isEmpty(this.nLF)) {
            try {
                if (this.nLE == null) {
                    Application dRk = tv.chushou.basis.d.b.dRk();
                    this.nLD.put("device_id", Settings.Secure.getString(dRk.getContentResolver(), "android_id"));
                    this.nLD.put("device_mac", getLocalMacAddress(dRk));
                    this.nLE = new KSDevice();
                    this.nLE.setDevice(tv.chushou.basis.d.b.dRk(), this.nLD);
                }
                this.nLF = this.nLE.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dRl().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nLF;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dRd() {
        if (TextUtils.isEmpty(this.nLG)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dRk().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nLG = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nLG)) {
                    if (this.nLE == null) {
                        Application dRk = tv.chushou.basis.d.b.dRk();
                        this.nLD.put("device_id", Settings.Secure.getString(dRk.getContentResolver(), "android_id"));
                        this.nLD.put("device_mac", getLocalMacAddress(dRk));
                        this.nLE = new KSDevice();
                        this.nLE.setDevice(tv.chushou.basis.d.b.dRk(), this.nLD);
                    }
                    this.nLG = this.nLE.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nLG);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dRl().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nLG;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dRe() {
        return this.nLD;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dRk().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dRf();
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

    private String dRf() {
        String atR = atR();
        String decrypt = !TextUtils.isEmpty(atR) ? tv.chushou.basis.b.a.a.a.b.decrypt(atR) : atR;
        String str = this.nLD.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dRk());
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
