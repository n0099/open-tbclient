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
    private final HashMap<String, String> nqD = new HashMap<>();
    private KSDevice nqE = null;
    private String imei = null;
    private String nqF = null;
    private String nqG = null;
    private volatile String nqH = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nqD.put("device_board", Build.BOARD);
        this.nqD.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nqD.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nqD.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nqD.put("device_cpuabi", Build.CPU_ABI);
            this.nqD.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nqD.put("device_devicename", Build.DEVICE);
        this.nqD.put("device_display", Build.DISPLAY);
        this.nqD.put("device_finger", Build.FINGERPRINT);
        this.nqD.put("device_hardware", Build.HARDWARE);
        this.nqD.put("device_versionid", Build.ID);
        this.nqD.put("device_model", Build.MODEL);
        this.nqD.put("device_manufacturer", Build.MANUFACTURER);
        this.nqD.put("device_product", Build.PRODUCT);
        this.nqD.put("device_tags", Build.TAGS);
        this.nqD.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.nqD.put("device_user", Build.USER);
        this.nqD.put("device_release", Build.VERSION.RELEASE);
        this.nqD.put("device_codename", Build.VERSION.CODENAME);
        this.nqD.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nqD.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nqD.put("device_serial", Build.SERIAL);
        this.nqD.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nqG = sharedPreferences.getString("deviceds", null);
        aps();
        getIdentifier();
        dJl();
        dJm();
        this.nqH = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aps() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dJt = tv.chushou.basis.d.b.dJt();
        if (dJt.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dJt.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dJl() {
        if (TextUtils.isEmpty(this.nqF)) {
            try {
                if (this.nqE == null) {
                    Application dJt = tv.chushou.basis.d.b.dJt();
                    this.nqD.put("device_id", Settings.Secure.getString(dJt.getContentResolver(), "android_id"));
                    this.nqD.put("device_mac", getLocalMacAddress(dJt));
                    this.nqE = new KSDevice();
                    this.nqE.setDevice(tv.chushou.basis.d.b.dJt(), this.nqD);
                }
                this.nqF = this.nqE.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dJu().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nqF;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dJm() {
        if (TextUtils.isEmpty(this.nqG)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dJt().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nqG = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nqG)) {
                    if (this.nqE == null) {
                        Application dJt = tv.chushou.basis.d.b.dJt();
                        this.nqD.put("device_id", Settings.Secure.getString(dJt.getContentResolver(), "android_id"));
                        this.nqD.put("device_mac", getLocalMacAddress(dJt));
                        this.nqE = new KSDevice();
                        this.nqE.setDevice(tv.chushou.basis.d.b.dJt(), this.nqD);
                    }
                    this.nqG = this.nqE.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nqG);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dJu().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nqG;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dJn() {
        return this.nqD;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dJt().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dJo();
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

    private String dJo() {
        String aps = aps();
        String decrypt = !TextUtils.isEmpty(aps) ? tv.chushou.basis.b.a.a.a.b.decrypt(aps) : aps;
        String str = this.nqD.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dJt());
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
