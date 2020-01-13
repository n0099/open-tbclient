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
    private final HashMap<String, String> nTY = new HashMap<>();
    private KSDevice nTZ = null;
    private String imei = null;
    private String nUa = null;
    private String nUb = null;
    private volatile String nUc = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nTY.put("device_board", Build.BOARD);
        this.nTY.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nTY.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nTY.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nTY.put("device_cpuabi", Build.CPU_ABI);
            this.nTY.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nTY.put("device_devicename", Build.DEVICE);
        this.nTY.put("device_display", Build.DISPLAY);
        this.nTY.put("device_finger", Build.FINGERPRINT);
        this.nTY.put("device_hardware", Build.HARDWARE);
        this.nTY.put("device_versionid", Build.ID);
        this.nTY.put("device_model", Build.MODEL);
        this.nTY.put("device_manufacturer", Build.MANUFACTURER);
        this.nTY.put("device_product", Build.PRODUCT);
        this.nTY.put("device_tags", Build.TAGS);
        this.nTY.put("device_type", Build.TYPE);
        this.nTY.put("device_user", Build.USER);
        this.nTY.put("device_release", Build.VERSION.RELEASE);
        this.nTY.put("device_codename", Build.VERSION.CODENAME);
        this.nTY.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nTY.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nTY.put("device_serial", Build.SERIAL);
        this.nTY.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nUb = sharedPreferences.getString("deviceds", null);
        aeR();
        getIdentifier();
        dOt();
        dOu();
        this.nUc = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aeR() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dOC = tv.chushou.basis.d.b.dOC();
        if (dOC.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dOC.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dOt() {
        if (TextUtils.isEmpty(this.nUa)) {
            try {
                if (this.nTZ == null) {
                    Application dOC = tv.chushou.basis.d.b.dOC();
                    this.nTY.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dOC.getContentResolver(), "android_id"));
                    this.nTY.put("device_mac", getLocalMacAddress(dOC));
                    this.nTZ = new KSDevice();
                    this.nTZ.setDevice(tv.chushou.basis.d.b.dOC(), this.nTY);
                }
                this.nUa = this.nTZ.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dOD().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nUa;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dOu() {
        if (TextUtils.isEmpty(this.nUb)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dOC().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nUb = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nUb)) {
                    if (this.nTZ == null) {
                        Application dOC = tv.chushou.basis.d.b.dOC();
                        this.nTY.put(Constants.KEY_DEVICE_ID, Settings.Secure.getString(dOC.getContentResolver(), "android_id"));
                        this.nTY.put("device_mac", getLocalMacAddress(dOC));
                        this.nTZ = new KSDevice();
                        this.nTZ.setDevice(tv.chushou.basis.d.b.dOC(), this.nTY);
                    }
                    this.nUb = this.nTZ.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nUb);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dOD().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nUb;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dOv() {
        return this.nTY;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dOC().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dOw();
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

    private String dOw() {
        String aeR = aeR();
        String str = this.nTY.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dOC());
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
