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
    private final HashMap<String, String> nWR = new HashMap<>();
    private KSDevice nWS = null;
    private String imei = null;
    private String nWT = null;
    private String nWU = null;
    private volatile String nWV = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nWR.put("device_board", Build.BOARD);
        this.nWR.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nWR.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nWR.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nWR.put("device_cpuabi", Build.CPU_ABI);
            this.nWR.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nWR.put("device_devicename", Build.DEVICE);
        this.nWR.put("device_display", Build.DISPLAY);
        this.nWR.put("device_finger", Build.FINGERPRINT);
        this.nWR.put("device_hardware", Build.HARDWARE);
        this.nWR.put("device_versionid", Build.ID);
        this.nWR.put("device_model", Build.MODEL);
        this.nWR.put("device_manufacturer", Build.MANUFACTURER);
        this.nWR.put("device_product", Build.PRODUCT);
        this.nWR.put("device_tags", Build.TAGS);
        this.nWR.put("device_type", Build.TYPE);
        this.nWR.put("device_user", Build.USER);
        this.nWR.put("device_release", Build.VERSION.RELEASE);
        this.nWR.put("device_codename", Build.VERSION.CODENAME);
        this.nWR.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nWR.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nWR.put("device_serial", Build.SERIAL);
        this.nWR.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nWU = sharedPreferences.getString("deviceds", null);
        ahk();
        getIdentifier();
        dQl();
        dQm();
        this.nWV = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String ahk() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dQu = tv.chushou.basis.d.b.dQu();
        if (dQu.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dQu.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dQl() {
        if (TextUtils.isEmpty(this.nWT)) {
            try {
                if (this.nWS == null) {
                    Application dQu = tv.chushou.basis.d.b.dQu();
                    this.nWR.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dQu.getContentResolver(), "android_id"));
                    this.nWR.put("device_mac", getLocalMacAddress(dQu));
                    this.nWS = new KSDevice();
                    this.nWS.setDevice(tv.chushou.basis.d.b.dQu(), this.nWR);
                }
                this.nWT = this.nWS.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dQv().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nWT;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dQm() {
        if (TextUtils.isEmpty(this.nWU)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dQu().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nWU = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nWU)) {
                    if (this.nWS == null) {
                        Application dQu = tv.chushou.basis.d.b.dQu();
                        this.nWR.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dQu.getContentResolver(), "android_id"));
                        this.nWR.put("device_mac", getLocalMacAddress(dQu));
                        this.nWS = new KSDevice();
                        this.nWS.setDevice(tv.chushou.basis.d.b.dQu(), this.nWR);
                    }
                    this.nWU = this.nWS.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nWU);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dQv().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nWU;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dQn() {
        return this.nWR;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dQu().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dQo();
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

    private String dQo() {
        String ahk = ahk();
        String decrypt = !TextUtils.isEmpty(ahk) ? tv.chushou.basis.b.a.a.a.b.decrypt(ahk) : ahk;
        String str = this.nWR.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dQu());
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
