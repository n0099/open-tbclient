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
    private final HashMap<String, String> oLB = new HashMap<>();
    private KSDevice oLC = null;
    private String imei = null;
    private String oLD = null;
    private String oLE = null;
    private volatile String oLF = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.oLB.put("device_board", Build.BOARD);
        this.oLB.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.oLB.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.oLB.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.oLB.put("device_cpuabi", Build.CPU_ABI);
            this.oLB.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.oLB.put("device_devicename", Build.DEVICE);
        this.oLB.put("device_display", Build.DISPLAY);
        this.oLB.put("device_finger", Build.FINGERPRINT);
        this.oLB.put("device_hardware", Build.HARDWARE);
        this.oLB.put("device_versionid", Build.ID);
        this.oLB.put("device_model", Build.MODEL);
        this.oLB.put("device_manufacturer", Build.MANUFACTURER);
        this.oLB.put("device_product", Build.PRODUCT);
        this.oLB.put("device_tags", Build.TAGS);
        this.oLB.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.oLB.put("device_user", Build.USER);
        this.oLB.put("device_release", Build.VERSION.RELEASE);
        this.oLB.put("device_codename", Build.VERSION.CODENAME);
        this.oLB.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.oLB.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.oLB.put("device_serial", Build.SERIAL);
        this.oLB.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.oLE = sharedPreferences.getString("deviceds", null);
        aFm();
        getIdentifier();
        elK();
        elL();
        this.oLF = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aFm() {
        if (this.imei != null) {
            return this.imei;
        }
        Application elS = tv.chushou.basis.d.b.elS();
        if (elS.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) elS.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String elK() {
        if (TextUtils.isEmpty(this.oLD)) {
            try {
                if (this.oLC == null) {
                    Application elS = tv.chushou.basis.d.b.elS();
                    this.oLB.put("device_id", Settings.Secure.getString(elS.getContentResolver(), "android_id"));
                    this.oLB.put("device_mac", getLocalMacAddress(elS));
                    this.oLC = new KSDevice();
                    this.oLC.setDevice(tv.chushou.basis.d.b.elS(), this.oLB);
                }
                this.oLD = this.oLC.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.elT().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.oLD;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String elL() {
        if (TextUtils.isEmpty(this.oLE)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.elS().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.oLE = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.oLE)) {
                    if (this.oLC == null) {
                        Application elS = tv.chushou.basis.d.b.elS();
                        this.oLB.put("device_id", Settings.Secure.getString(elS.getContentResolver(), "android_id"));
                        this.oLB.put("device_mac", getLocalMacAddress(elS));
                        this.oLC = new KSDevice();
                        this.oLC.setDevice(tv.chushou.basis.d.b.elS(), this.oLB);
                    }
                    this.oLE = this.oLC.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.oLE);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.elT().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.oLE;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> elM() {
        return this.oLB;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.elS().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = elN();
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

    private String elN() {
        String aFm = aFm();
        String decrypt = !TextUtils.isEmpty(aFm) ? tv.chushou.basis.b.a.a.a.b.decrypt(aFm) : aFm;
        String str = this.oLB.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.elS());
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
