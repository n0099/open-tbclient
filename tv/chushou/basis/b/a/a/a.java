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
    private final HashMap<String, String> nUT = new HashMap<>();
    private KSDevice nUU = null;
    private String imei = null;
    private String nUV = null;
    private String nUW = null;
    private volatile String nUX = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nUT.put("device_board", Build.BOARD);
        this.nUT.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nUT.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nUT.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nUT.put("device_cpuabi", Build.CPU_ABI);
            this.nUT.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nUT.put("device_devicename", Build.DEVICE);
        this.nUT.put("device_display", Build.DISPLAY);
        this.nUT.put("device_finger", Build.FINGERPRINT);
        this.nUT.put("device_hardware", Build.HARDWARE);
        this.nUT.put("device_versionid", Build.ID);
        this.nUT.put("device_model", Build.MODEL);
        this.nUT.put("device_manufacturer", Build.MANUFACTURER);
        this.nUT.put("device_product", Build.PRODUCT);
        this.nUT.put("device_tags", Build.TAGS);
        this.nUT.put("device_type", Build.TYPE);
        this.nUT.put("device_user", Build.USER);
        this.nUT.put("device_release", Build.VERSION.RELEASE);
        this.nUT.put("device_codename", Build.VERSION.CODENAME);
        this.nUT.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nUT.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nUT.put("device_serial", Build.SERIAL);
        this.nUT.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nUW = sharedPreferences.getString("deviceds", null);
        ahh();
        getIdentifier();
        dPK();
        dPL();
        this.nUX = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String ahh() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dPT = tv.chushou.basis.d.b.dPT();
        if (dPT.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dPT.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dPK() {
        if (TextUtils.isEmpty(this.nUV)) {
            try {
                if (this.nUU == null) {
                    Application dPT = tv.chushou.basis.d.b.dPT();
                    this.nUT.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dPT.getContentResolver(), "android_id"));
                    this.nUT.put("device_mac", getLocalMacAddress(dPT));
                    this.nUU = new KSDevice();
                    this.nUU.setDevice(tv.chushou.basis.d.b.dPT(), this.nUT);
                }
                this.nUV = this.nUU.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dPU().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nUV;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dPL() {
        if (TextUtils.isEmpty(this.nUW)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dPT().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nUW = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nUW)) {
                    if (this.nUU == null) {
                        Application dPT = tv.chushou.basis.d.b.dPT();
                        this.nUT.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dPT.getContentResolver(), "android_id"));
                        this.nUT.put("device_mac", getLocalMacAddress(dPT));
                        this.nUU = new KSDevice();
                        this.nUU.setDevice(tv.chushou.basis.d.b.dPT(), this.nUT);
                    }
                    this.nUW = this.nUU.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nUW);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dPU().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nUW;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dPM() {
        return this.nUT;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dPT().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dPN();
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

    private String dPN() {
        String ahh = ahh();
        String decrypt = !TextUtils.isEmpty(ahh) ? tv.chushou.basis.b.a.a.a.b.decrypt(ahh) : ahh;
        String str = this.nUT.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dPT());
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
