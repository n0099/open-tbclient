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
    private final HashMap<String, String> qlj = new HashMap<>();
    private KSDevice qlk = null;
    private String imei = null;
    private String qll = null;
    private String qlm = null;
    private volatile String qln = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.qlj.put("device_board", Build.BOARD);
        this.qlj.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.qlj.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.qlj.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.qlj.put("device_cpuabi", Build.CPU_ABI);
            this.qlj.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.qlj.put("device_devicename", Build.DEVICE);
        this.qlj.put("device_display", Build.DISPLAY);
        this.qlj.put("device_finger", Build.FINGERPRINT);
        this.qlj.put("device_hardware", Build.HARDWARE);
        this.qlj.put("device_versionid", Build.ID);
        this.qlj.put("device_model", Build.MODEL);
        this.qlj.put("device_manufacturer", Build.MANUFACTURER);
        this.qlj.put("device_product", Build.PRODUCT);
        this.qlj.put("device_tags", Build.TAGS);
        this.qlj.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.qlj.put("device_user", Build.USER);
        this.qlj.put("device_release", Build.VERSION.RELEASE);
        this.qlj.put("device_codename", Build.VERSION.CODENAME);
        this.qlj.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.qlj.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.qlj.put("device_serial", Build.SERIAL);
        this.qlj.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.qlm = sharedPreferences.getString("deviceds", null);
        aMZ();
        getIdentifier();
        eHg();
        eHh();
        this.qln = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aMZ() {
        if (this.imei != null) {
            return this.imei;
        }
        Application eHo = tv.chushou.basis.d.b.eHo();
        if (eHo.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) eHo.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String eHg() {
        if (TextUtils.isEmpty(this.qll)) {
            try {
                if (this.qlk == null) {
                    Application eHo = tv.chushou.basis.d.b.eHo();
                    this.qlj.put("device_id", Settings.Secure.getString(eHo.getContentResolver(), "android_id"));
                    this.qlj.put("device_mac", getLocalMacAddress(eHo));
                    this.qlk = new KSDevice();
                    this.qlk.setDevice(tv.chushou.basis.d.b.eHo(), this.qlj);
                }
                this.qll = this.qlk.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.eHp().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.qll;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String eHh() {
        if (TextUtils.isEmpty(this.qlm)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.eHo().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.qlm = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.qlm)) {
                    if (this.qlk == null) {
                        Application eHo = tv.chushou.basis.d.b.eHo();
                        this.qlj.put("device_id", Settings.Secure.getString(eHo.getContentResolver(), "android_id"));
                        this.qlj.put("device_mac", getLocalMacAddress(eHo));
                        this.qlk = new KSDevice();
                        this.qlk.setDevice(tv.chushou.basis.d.b.eHo(), this.qlj);
                    }
                    this.qlm = this.qlk.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.qlm);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.eHp().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.qlm;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> eHi() {
        return this.qlj;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.eHo().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = eHj();
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

    private String eHj() {
        String aMZ = aMZ();
        String decrypt = !TextUtils.isEmpty(aMZ) ? tv.chushou.basis.b.a.a.a.b.decrypt(aMZ) : aMZ;
        String str = this.qlj.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.eHo());
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
