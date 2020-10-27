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
    private final HashMap<String, String> qbO = new HashMap<>();
    private KSDevice qbP = null;
    private String imei = null;
    private String qbQ = null;
    private String qbR = null;
    private volatile String qbS = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.qbO.put("device_board", Build.BOARD);
        this.qbO.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.qbO.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.qbO.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.qbO.put("device_cpuabi", Build.CPU_ABI);
            this.qbO.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.qbO.put("device_devicename", Build.DEVICE);
        this.qbO.put("device_display", Build.DISPLAY);
        this.qbO.put("device_finger", Build.FINGERPRINT);
        this.qbO.put("device_hardware", Build.HARDWARE);
        this.qbO.put("device_versionid", Build.ID);
        this.qbO.put("device_model", Build.MODEL);
        this.qbO.put("device_manufacturer", Build.MANUFACTURER);
        this.qbO.put("device_product", Build.PRODUCT);
        this.qbO.put("device_tags", Build.TAGS);
        this.qbO.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.qbO.put("device_user", Build.USER);
        this.qbO.put("device_release", Build.VERSION.RELEASE);
        this.qbO.put("device_codename", Build.VERSION.CODENAME);
        this.qbO.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.qbO.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.qbO.put("device_serial", Build.SERIAL);
        this.qbO.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.qbR = sharedPreferences.getString("deviceds", null);
        aKz();
        getIdentifier();
        eDr();
        eDs();
        this.qbS = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aKz() {
        if (this.imei != null) {
            return this.imei;
        }
        Application eDz = tv.chushou.basis.d.b.eDz();
        if (eDz.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) eDz.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String eDr() {
        if (TextUtils.isEmpty(this.qbQ)) {
            try {
                if (this.qbP == null) {
                    Application eDz = tv.chushou.basis.d.b.eDz();
                    this.qbO.put("device_id", Settings.Secure.getString(eDz.getContentResolver(), "android_id"));
                    this.qbO.put("device_mac", getLocalMacAddress(eDz));
                    this.qbP = new KSDevice();
                    this.qbP.setDevice(tv.chushou.basis.d.b.eDz(), this.qbO);
                }
                this.qbQ = this.qbP.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.eDA().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.qbQ;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String eDs() {
        if (TextUtils.isEmpty(this.qbR)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.eDz().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.qbR = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.qbR)) {
                    if (this.qbP == null) {
                        Application eDz = tv.chushou.basis.d.b.eDz();
                        this.qbO.put("device_id", Settings.Secure.getString(eDz.getContentResolver(), "android_id"));
                        this.qbO.put("device_mac", getLocalMacAddress(eDz));
                        this.qbP = new KSDevice();
                        this.qbP.setDevice(tv.chushou.basis.d.b.eDz(), this.qbO);
                    }
                    this.qbR = this.qbP.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.qbR);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.eDA().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.qbR;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> eDt() {
        return this.qbO;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.eDz().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = eDu();
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

    private String eDu() {
        String aKz = aKz();
        String decrypt = !TextUtils.isEmpty(aKz) ? tv.chushou.basis.b.a.a.a.b.decrypt(aKz) : aKz;
        String str = this.qbO.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.eDz());
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
