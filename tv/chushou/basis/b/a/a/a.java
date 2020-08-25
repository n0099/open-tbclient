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
    private final HashMap<String, String> oLj = new HashMap<>();
    private KSDevice oLk = null;
    private String imei = null;
    private String oLl = null;
    private String oLm = null;
    private volatile String oLn = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.oLj.put("device_board", Build.BOARD);
        this.oLj.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.oLj.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.oLj.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.oLj.put("device_cpuabi", Build.CPU_ABI);
            this.oLj.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.oLj.put("device_devicename", Build.DEVICE);
        this.oLj.put("device_display", Build.DISPLAY);
        this.oLj.put("device_finger", Build.FINGERPRINT);
        this.oLj.put("device_hardware", Build.HARDWARE);
        this.oLj.put("device_versionid", Build.ID);
        this.oLj.put("device_model", Build.MODEL);
        this.oLj.put("device_manufacturer", Build.MANUFACTURER);
        this.oLj.put("device_product", Build.PRODUCT);
        this.oLj.put("device_tags", Build.TAGS);
        this.oLj.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.oLj.put("device_user", Build.USER);
        this.oLj.put("device_release", Build.VERSION.RELEASE);
        this.oLj.put("device_codename", Build.VERSION.CODENAME);
        this.oLj.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.oLj.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.oLj.put("device_serial", Build.SERIAL);
        this.oLj.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.oLm = sharedPreferences.getString("deviceds", null);
        aFm();
        getIdentifier();
        elB();
        elC();
        this.oLn = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aFm() {
        if (this.imei != null) {
            return this.imei;
        }
        Application elJ = tv.chushou.basis.d.b.elJ();
        if (elJ.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) elJ.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String elB() {
        if (TextUtils.isEmpty(this.oLl)) {
            try {
                if (this.oLk == null) {
                    Application elJ = tv.chushou.basis.d.b.elJ();
                    this.oLj.put("device_id", Settings.Secure.getString(elJ.getContentResolver(), "android_id"));
                    this.oLj.put("device_mac", getLocalMacAddress(elJ));
                    this.oLk = new KSDevice();
                    this.oLk.setDevice(tv.chushou.basis.d.b.elJ(), this.oLj);
                }
                this.oLl = this.oLk.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.elK().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.oLl;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String elC() {
        if (TextUtils.isEmpty(this.oLm)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.elJ().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.oLm = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.oLm)) {
                    if (this.oLk == null) {
                        Application elJ = tv.chushou.basis.d.b.elJ();
                        this.oLj.put("device_id", Settings.Secure.getString(elJ.getContentResolver(), "android_id"));
                        this.oLj.put("device_mac", getLocalMacAddress(elJ));
                        this.oLk = new KSDevice();
                        this.oLk.setDevice(tv.chushou.basis.d.b.elJ(), this.oLj);
                    }
                    this.oLm = this.oLk.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.oLm);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.elK().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.oLm;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> elD() {
        return this.oLj;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.elJ().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = elE();
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

    private String elE() {
        String aFm = aFm();
        String decrypt = !TextUtils.isEmpty(aFm) ? tv.chushou.basis.b.a.a.a.b.decrypt(aFm) : aFm;
        String str = this.oLj.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.elJ());
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
