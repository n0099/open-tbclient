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
    private final HashMap<String, String> oVf = new HashMap<>();
    private KSDevice oVg = null;
    private String imei = null;
    private String oVh = null;
    private String oVi = null;
    private volatile String oVj = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.oVf.put("device_board", Build.BOARD);
        this.oVf.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.oVf.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.oVf.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.oVf.put("device_cpuabi", Build.CPU_ABI);
            this.oVf.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.oVf.put("device_devicename", Build.DEVICE);
        this.oVf.put("device_display", Build.DISPLAY);
        this.oVf.put("device_finger", Build.FINGERPRINT);
        this.oVf.put("device_hardware", Build.HARDWARE);
        this.oVf.put("device_versionid", Build.ID);
        this.oVf.put("device_model", Build.MODEL);
        this.oVf.put("device_manufacturer", Build.MANUFACTURER);
        this.oVf.put("device_product", Build.PRODUCT);
        this.oVf.put("device_tags", Build.TAGS);
        this.oVf.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.oVf.put("device_user", Build.USER);
        this.oVf.put("device_release", Build.VERSION.RELEASE);
        this.oVf.put("device_codename", Build.VERSION.CODENAME);
        this.oVf.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.oVf.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.oVf.put("device_serial", Build.SERIAL);
        this.oVf.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.oVi = sharedPreferences.getString("deviceds", null);
        aFW();
        getIdentifier();
        epI();
        epJ();
        this.oVj = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aFW() {
        if (this.imei != null) {
            return this.imei;
        }
        Application epQ = tv.chushou.basis.d.b.epQ();
        if (epQ.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) epQ.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String epI() {
        if (TextUtils.isEmpty(this.oVh)) {
            try {
                if (this.oVg == null) {
                    Application epQ = tv.chushou.basis.d.b.epQ();
                    this.oVf.put("device_id", Settings.Secure.getString(epQ.getContentResolver(), "android_id"));
                    this.oVf.put("device_mac", getLocalMacAddress(epQ));
                    this.oVg = new KSDevice();
                    this.oVg.setDevice(tv.chushou.basis.d.b.epQ(), this.oVf);
                }
                this.oVh = this.oVg.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.epR().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.oVh;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String epJ() {
        if (TextUtils.isEmpty(this.oVi)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.epQ().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.oVi = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.oVi)) {
                    if (this.oVg == null) {
                        Application epQ = tv.chushou.basis.d.b.epQ();
                        this.oVf.put("device_id", Settings.Secure.getString(epQ.getContentResolver(), "android_id"));
                        this.oVf.put("device_mac", getLocalMacAddress(epQ));
                        this.oVg = new KSDevice();
                        this.oVg.setDevice(tv.chushou.basis.d.b.epQ(), this.oVf);
                    }
                    this.oVi = this.oVg.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.oVi);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.epR().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.oVi;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> epK() {
        return this.oVf;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.epQ().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = epL();
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

    private String epL() {
        String aFW = aFW();
        String decrypt = !TextUtils.isEmpty(aFW) ? tv.chushou.basis.b.a.a.a.b.decrypt(aFW) : aFW;
        String str = this.oVf.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.epQ());
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
