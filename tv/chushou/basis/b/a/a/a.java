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
/* loaded from: classes5.dex */
public class a implements d {
    private ActivityManager activityManager;
    private final HashMap<String, String> nMN = new HashMap<>();
    private KSDevice nMO = null;
    private String imei = null;
    private String nMP = null;
    private String nMQ = null;
    private volatile String nMR = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nMN.put("device_board", Build.BOARD);
        this.nMN.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nMN.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nMN.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nMN.put("device_cpuabi", Build.CPU_ABI);
            this.nMN.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nMN.put("device_devicename", Build.DEVICE);
        this.nMN.put("device_display", Build.DISPLAY);
        this.nMN.put("device_finger", Build.FINGERPRINT);
        this.nMN.put("device_hardware", Build.HARDWARE);
        this.nMN.put("device_versionid", Build.ID);
        this.nMN.put("device_model", Build.MODEL);
        this.nMN.put("device_manufacturer", Build.MANUFACTURER);
        this.nMN.put("device_product", Build.PRODUCT);
        this.nMN.put("device_tags", Build.TAGS);
        this.nMN.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.nMN.put("device_user", Build.USER);
        this.nMN.put("device_release", Build.VERSION.RELEASE);
        this.nMN.put("device_codename", Build.VERSION.CODENAME);
        this.nMN.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nMN.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nMN.put("device_serial", Build.SERIAL);
        this.nMN.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nMQ = sharedPreferences.getString("deviceds", null);
        atR();
        getIdentifier();
        dRq();
        dRr();
        this.nMR = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String atR() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dRy = tv.chushou.basis.d.b.dRy();
        if (dRy.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dRy.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dRq() {
        if (TextUtils.isEmpty(this.nMP)) {
            try {
                if (this.nMO == null) {
                    Application dRy = tv.chushou.basis.d.b.dRy();
                    this.nMN.put("device_id", Settings.Secure.getString(dRy.getContentResolver(), "android_id"));
                    this.nMN.put("device_mac", getLocalMacAddress(dRy));
                    this.nMO = new KSDevice();
                    this.nMO.setDevice(tv.chushou.basis.d.b.dRy(), this.nMN);
                }
                this.nMP = this.nMO.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dRz().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nMP;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dRr() {
        if (TextUtils.isEmpty(this.nMQ)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dRy().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nMQ = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nMQ)) {
                    if (this.nMO == null) {
                        Application dRy = tv.chushou.basis.d.b.dRy();
                        this.nMN.put("device_id", Settings.Secure.getString(dRy.getContentResolver(), "android_id"));
                        this.nMN.put("device_mac", getLocalMacAddress(dRy));
                        this.nMO = new KSDevice();
                        this.nMO.setDevice(tv.chushou.basis.d.b.dRy(), this.nMN);
                    }
                    this.nMQ = this.nMO.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nMQ);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dRz().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nMQ;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dRs() {
        return this.nMN;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dRy().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dRt();
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

    private String dRt() {
        String atR = atR();
        String decrypt = !TextUtils.isEmpty(atR) ? tv.chushou.basis.b.a.a.a.b.decrypt(atR) : atR;
        String str = this.nMN.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dRy());
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
