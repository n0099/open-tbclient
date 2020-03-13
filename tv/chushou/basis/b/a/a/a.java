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
import com.baidu.android.imsdk.internal.Constants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
import kascend.core.KSDevice;
import tv.chushou.basis.d.a.b.d;
@SuppressLint({"HardwareIds"})
/* loaded from: classes5.dex */
public class a implements d {
    private ActivityManager activityManager;
    private final HashMap<String, String> nVe = new HashMap<>();
    private KSDevice nVf = null;
    private String imei = null;
    private String nVg = null;
    private String nVh = null;
    private volatile String nVi = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nVe.put("device_board", Build.BOARD);
        this.nVe.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nVe.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nVe.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nVe.put("device_cpuabi", Build.CPU_ABI);
            this.nVe.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nVe.put("device_devicename", Build.DEVICE);
        this.nVe.put("device_display", Build.DISPLAY);
        this.nVe.put("device_finger", Build.FINGERPRINT);
        this.nVe.put("device_hardware", Build.HARDWARE);
        this.nVe.put("device_versionid", Build.ID);
        this.nVe.put("device_model", Build.MODEL);
        this.nVe.put("device_manufacturer", Build.MANUFACTURER);
        this.nVe.put("device_product", Build.PRODUCT);
        this.nVe.put("device_tags", Build.TAGS);
        this.nVe.put("device_type", Build.TYPE);
        this.nVe.put("device_user", Build.USER);
        this.nVe.put("device_release", Build.VERSION.RELEASE);
        this.nVe.put("device_codename", Build.VERSION.CODENAME);
        this.nVe.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nVe.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nVe.put("device_serial", Build.SERIAL);
        this.nVe.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nVh = sharedPreferences.getString("deviceds", null);
        ahh();
        getIdentifier();
        dPL();
        dPM();
        this.nVi = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String ahh() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dPU = tv.chushou.basis.d.b.dPU();
        if (dPU.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dPU.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dPL() {
        if (TextUtils.isEmpty(this.nVg)) {
            try {
                if (this.nVf == null) {
                    Application dPU = tv.chushou.basis.d.b.dPU();
                    this.nVe.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dPU.getContentResolver(), "android_id"));
                    this.nVe.put("device_mac", getLocalMacAddress(dPU));
                    this.nVf = new KSDevice();
                    this.nVf.setDevice(tv.chushou.basis.d.b.dPU(), this.nVe);
                }
                this.nVg = this.nVf.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dPV().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nVg;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dPM() {
        if (TextUtils.isEmpty(this.nVh)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dPU().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nVh = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nVh)) {
                    if (this.nVf == null) {
                        Application dPU = tv.chushou.basis.d.b.dPU();
                        this.nVe.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dPU.getContentResolver(), "android_id"));
                        this.nVe.put("device_mac", getLocalMacAddress(dPU));
                        this.nVf = new KSDevice();
                        this.nVf.setDevice(tv.chushou.basis.d.b.dPU(), this.nVe);
                    }
                    this.nVh = this.nVf.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nVh);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dPV().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nVh;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dPN() {
        return this.nVe;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dPU().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dPO();
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

    private String dPO() {
        String ahh = ahh();
        String decrypt = !TextUtils.isEmpty(ahh) ? tv.chushou.basis.b.a.a.a.b.decrypt(ahh) : ahh;
        String str = this.nVe.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dPU());
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
