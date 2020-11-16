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
    private final HashMap<String, String> qmM = new HashMap<>();
    private KSDevice qmN = null;
    private String imei = null;
    private String qmO = null;
    private String qmP = null;
    private volatile String qmQ = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.qmM.put("device_board", Build.BOARD);
        this.qmM.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.qmM.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.qmM.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.qmM.put("device_cpuabi", Build.CPU_ABI);
            this.qmM.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.qmM.put("device_devicename", Build.DEVICE);
        this.qmM.put("device_display", Build.DISPLAY);
        this.qmM.put("device_finger", Build.FINGERPRINT);
        this.qmM.put("device_hardware", Build.HARDWARE);
        this.qmM.put("device_versionid", Build.ID);
        this.qmM.put("device_model", Build.MODEL);
        this.qmM.put("device_manufacturer", Build.MANUFACTURER);
        this.qmM.put("device_product", Build.PRODUCT);
        this.qmM.put("device_tags", Build.TAGS);
        this.qmM.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.qmM.put("device_user", Build.USER);
        this.qmM.put("device_release", Build.VERSION.RELEASE);
        this.qmM.put("device_codename", Build.VERSION.CODENAME);
        this.qmM.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.qmM.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.qmM.put("device_serial", Build.SERIAL);
        this.qmM.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.qmP = sharedPreferences.getString("deviceds", null);
        aMr();
        getIdentifier();
        eHh();
        eHi();
        this.qmQ = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aMr() {
        if (this.imei != null) {
            return this.imei;
        }
        Application eHp = tv.chushou.basis.d.b.eHp();
        if (eHp.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) eHp.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String eHh() {
        if (TextUtils.isEmpty(this.qmO)) {
            try {
                if (this.qmN == null) {
                    Application eHp = tv.chushou.basis.d.b.eHp();
                    this.qmM.put("device_id", Settings.Secure.getString(eHp.getContentResolver(), "android_id"));
                    this.qmM.put("device_mac", getLocalMacAddress(eHp));
                    this.qmN = new KSDevice();
                    this.qmN.setDevice(tv.chushou.basis.d.b.eHp(), this.qmM);
                }
                this.qmO = this.qmN.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.eHq().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.qmO;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String eHi() {
        if (TextUtils.isEmpty(this.qmP)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.eHp().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.qmP = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.qmP)) {
                    if (this.qmN == null) {
                        Application eHp = tv.chushou.basis.d.b.eHp();
                        this.qmM.put("device_id", Settings.Secure.getString(eHp.getContentResolver(), "android_id"));
                        this.qmM.put("device_mac", getLocalMacAddress(eHp));
                        this.qmN = new KSDevice();
                        this.qmN.setDevice(tv.chushou.basis.d.b.eHp(), this.qmM);
                    }
                    this.qmP = this.qmN.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.qmP);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.eHq().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.qmP;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> eHj() {
        return this.qmM;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.eHp().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = eHk();
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

    private String eHk() {
        String aMr = aMr();
        String decrypt = !TextUtils.isEmpty(aMr) ? tv.chushou.basis.b.a.a.a.b.decrypt(aMr) : aMr;
        String str = this.qmM.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.eHp());
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
