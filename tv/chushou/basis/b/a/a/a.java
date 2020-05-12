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
    private final HashMap<String, String> nqG = new HashMap<>();
    private KSDevice nqH = null;
    private String imei = null;
    private String nqI = null;
    private String nqJ = null;
    private volatile String nqK = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.nqG.put("device_board", Build.BOARD);
        this.nqG.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.nqG.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.nqG.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.nqG.put("device_cpuabi", Build.CPU_ABI);
            this.nqG.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.nqG.put("device_devicename", Build.DEVICE);
        this.nqG.put("device_display", Build.DISPLAY);
        this.nqG.put("device_finger", Build.FINGERPRINT);
        this.nqG.put("device_hardware", Build.HARDWARE);
        this.nqG.put("device_versionid", Build.ID);
        this.nqG.put("device_model", Build.MODEL);
        this.nqG.put("device_manufacturer", Build.MANUFACTURER);
        this.nqG.put("device_product", Build.PRODUCT);
        this.nqG.put("device_tags", Build.TAGS);
        this.nqG.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.nqG.put("device_user", Build.USER);
        this.nqG.put("device_release", Build.VERSION.RELEASE);
        this.nqG.put("device_codename", Build.VERSION.CODENAME);
        this.nqG.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.nqG.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.nqG.put("device_serial", Build.SERIAL);
        this.nqG.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.nqJ = sharedPreferences.getString("deviceds", null);
        apr();
        getIdentifier();
        dJi();
        dJj();
        this.nqK = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String apr() {
        if (this.imei != null) {
            return this.imei;
        }
        Application dJq = tv.chushou.basis.d.b.dJq();
        if (dJq.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) dJq.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dJi() {
        if (TextUtils.isEmpty(this.nqI)) {
            try {
                if (this.nqH == null) {
                    Application dJq = tv.chushou.basis.d.b.dJq();
                    this.nqG.put("device_id", Settings.Secure.getString(dJq.getContentResolver(), "android_id"));
                    this.nqG.put("device_mac", getLocalMacAddress(dJq));
                    this.nqH = new KSDevice();
                    this.nqH.setDevice(tv.chushou.basis.d.b.dJq(), this.nqG);
                }
                this.nqI = this.nqH.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.dJr().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.nqI;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String dJj() {
        if (TextUtils.isEmpty(this.nqJ)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dJq().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.nqJ = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.nqJ)) {
                    if (this.nqH == null) {
                        Application dJq = tv.chushou.basis.d.b.dJq();
                        this.nqG.put("device_id", Settings.Secure.getString(dJq.getContentResolver(), "android_id"));
                        this.nqG.put("device_mac", getLocalMacAddress(dJq));
                        this.nqH = new KSDevice();
                        this.nqH.setDevice(tv.chushou.basis.d.b.dJq(), this.nqG);
                    }
                    this.nqJ = this.nqH.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.nqJ);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.dJr().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.nqJ;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> dJk() {
        return this.nqG;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.dJq().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = dJl();
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

    private String dJl() {
        String apr = apr();
        String decrypt = !TextUtils.isEmpty(apr) ? tv.chushou.basis.b.a.a.a.b.decrypt(apr) : apr;
        String str = this.nqG.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.dJq());
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
