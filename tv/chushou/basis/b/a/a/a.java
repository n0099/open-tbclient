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
    private final HashMap<String, String> nUR = new HashMap<>();
    private KSDevice nUS = null;
    private String imei = null;
    private String nUT = null;
    private String nUU = null;
    private volatile String nUV = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nUR.put("device_board", Build.BOARD);
        this.nUR.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nUR.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nUR.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nUR.put("device_cpuabi", Build.CPU_ABI);
            this.nUR.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nUR.put("device_devicename", Build.DEVICE);
        this.nUR.put("device_display", Build.DISPLAY);
        this.nUR.put("device_finger", Build.FINGERPRINT);
        this.nUR.put("device_hardware", Build.HARDWARE);
        this.nUR.put("device_versionid", Build.ID);
        this.nUR.put("device_model", Build.MODEL);
        this.nUR.put("device_manufacturer", Build.MANUFACTURER);
        this.nUR.put("device_product", Build.PRODUCT);
        this.nUR.put("device_tags", Build.TAGS);
        this.nUR.put("device_type", Build.TYPE);
        this.nUR.put("device_user", Build.USER);
        this.nUR.put("device_release", Build.VERSION.RELEASE);
        this.nUR.put("device_codename", Build.VERSION.CODENAME);
        this.nUR.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nUR.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nUR.put("device_serial", Build.SERIAL);
        this.nUR.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nUU = sharedPreferences.getString("deviceds", null);
        ahf();
        getIdentifier();
        dPI();
        dPJ();
        this.nUV = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String ahf() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dPR = tv.chushou.basis.d.b.dPR();
        if (dPR.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dPR.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dPI() {
        if (TextUtils.isEmpty(this.nUT)) {
            try {
                if (this.nUS == null) {
                    Application dPR = tv.chushou.basis.d.b.dPR();
                    this.nUR.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dPR.getContentResolver(), "android_id"));
                    this.nUR.put("device_mac", getLocalMacAddress(dPR));
                    this.nUS = new KSDevice();
                    this.nUS.setDevice(tv.chushou.basis.d.b.dPR(), this.nUR);
                }
                this.nUT = this.nUS.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dPS().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nUT;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dPJ() {
        if (TextUtils.isEmpty(this.nUU)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dPR().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nUU = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nUU)) {
                    if (this.nUS == null) {
                        Application dPR = tv.chushou.basis.d.b.dPR();
                        this.nUR.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dPR.getContentResolver(), "android_id"));
                        this.nUR.put("device_mac", getLocalMacAddress(dPR));
                        this.nUS = new KSDevice();
                        this.nUS.setDevice(tv.chushou.basis.d.b.dPR(), this.nUR);
                    }
                    this.nUU = this.nUS.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nUU);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dPS().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nUU;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dPK() {
        return this.nUR;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dPR().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dPL();
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

    private String dPL() {
        String ahf = ahf();
        String decrypt = !TextUtils.isEmpty(ahf) ? tv.chushou.basis.b.a.a.a.b.decrypt(ahf) : ahf;
        String str = this.nUR.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dPR());
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
