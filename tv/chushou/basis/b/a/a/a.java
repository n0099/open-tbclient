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
/* loaded from: classes4.dex */
public class a implements d {
    private ActivityManager activityManager;
    private final HashMap<String, String> nUd = new HashMap<>();
    private KSDevice nUe = null;
    private String imei = null;
    private String nUf = null;
    private String nUg = null;
    private volatile String nUh = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nUd.put("device_board", Build.BOARD);
        this.nUd.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nUd.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nUd.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nUd.put("device_cpuabi", Build.CPU_ABI);
            this.nUd.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nUd.put("device_devicename", Build.DEVICE);
        this.nUd.put("device_display", Build.DISPLAY);
        this.nUd.put("device_finger", Build.FINGERPRINT);
        this.nUd.put("device_hardware", Build.HARDWARE);
        this.nUd.put("device_versionid", Build.ID);
        this.nUd.put("device_model", Build.MODEL);
        this.nUd.put("device_manufacturer", Build.MANUFACTURER);
        this.nUd.put("device_product", Build.PRODUCT);
        this.nUd.put("device_tags", Build.TAGS);
        this.nUd.put("device_type", Build.TYPE);
        this.nUd.put("device_user", Build.USER);
        this.nUd.put("device_release", Build.VERSION.RELEASE);
        this.nUd.put("device_codename", Build.VERSION.CODENAME);
        this.nUd.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nUd.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nUd.put("device_serial", Build.SERIAL);
        this.nUd.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nUg = sharedPreferences.getString("deviceds", null);
        aeR();
        getIdentifier();
        dOv();
        dOw();
        this.nUh = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aeR() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dOE = tv.chushou.basis.d.b.dOE();
        if (dOE.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dOE.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dOv() {
        if (TextUtils.isEmpty(this.nUf)) {
            try {
                if (this.nUe == null) {
                    Application dOE = tv.chushou.basis.d.b.dOE();
                    this.nUd.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dOE.getContentResolver(), "android_id"));
                    this.nUd.put("device_mac", getLocalMacAddress(dOE));
                    this.nUe = new KSDevice();
                    this.nUe.setDevice(tv.chushou.basis.d.b.dOE(), this.nUd);
                }
                this.nUf = this.nUe.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dOF().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nUf;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dOw() {
        if (TextUtils.isEmpty(this.nUg)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dOE().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nUg = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nUg)) {
                    if (this.nUe == null) {
                        Application dOE = tv.chushou.basis.d.b.dOE();
                        this.nUd.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dOE.getContentResolver(), "android_id"));
                        this.nUd.put("device_mac", getLocalMacAddress(dOE));
                        this.nUe = new KSDevice();
                        this.nUe.setDevice(tv.chushou.basis.d.b.dOE(), this.nUd);
                    }
                    this.nUg = this.nUe.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nUg);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dOF().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nUg;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dOx() {
        return this.nUd;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dOE().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dOy();
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

    private String dOy() {
        String aeR = aeR();
        String str = this.nUd.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dOE());
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = TextUtils.isEmpty(aeR) ? "" : "" + aeR;
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
