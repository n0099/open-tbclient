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
    private final HashMap<String, String> pkz = new HashMap<>();
    private KSDevice pkA = null;
    private String imei = null;
    private String pkB = null;
    private String pkC = null;
    private volatile String pkD = null;
    private String identifier = null;

    static {
        System.loadLibrary("myhttp");
    }

    public a() {
        this.pkz.put("device_board", Build.BOARD);
        this.pkz.put("device_brand", Build.BRAND);
        if (Build.VERSION.SDK_INT >= 21) {
            this.pkz.put("device_cpuabi", Build.SUPPORTED_ABIS[0]);
            this.pkz.put("device_cpuabi2", Build.SUPPORTED_ABIS[1]);
        } else {
            this.pkz.put("device_cpuabi", Build.CPU_ABI);
            this.pkz.put("device_cpuabi2", Build.CPU_ABI2);
        }
        this.pkz.put("device_devicename", Build.DEVICE);
        this.pkz.put("device_display", Build.DISPLAY);
        this.pkz.put("device_finger", Build.FINGERPRINT);
        this.pkz.put("device_hardware", Build.HARDWARE);
        this.pkz.put("device_versionid", Build.ID);
        this.pkz.put("device_model", Build.MODEL);
        this.pkz.put("device_manufacturer", Build.MANUFACTURER);
        this.pkz.put("device_product", Build.PRODUCT);
        this.pkz.put("device_tags", Build.TAGS);
        this.pkz.put(HttpConstants.DEVICE_TYPE, Build.TYPE);
        this.pkz.put("device_user", Build.USER);
        this.pkz.put("device_release", Build.VERSION.RELEASE);
        this.pkz.put("device_codename", Build.VERSION.CODENAME);
        this.pkz.put("device_incremental", Build.VERSION.INCREMENTAL);
        this.pkz.put("device_api_int", Build.VERSION.SDK_INT + "");
        this.pkz.put("device_serial", Build.SERIAL);
        this.pkz.put("device_host", Build.HOST);
    }

    @Override // tv.chushou.basis.d.a
    public synchronized void init(Application application) {
        SharedPreferences sharedPreferences = application.getSharedPreferences("com_kascend_chushou_prefs", 0);
        this.identifier = sharedPreferences.getString("identifier", null);
        this.pkC = sharedPreferences.getString("deviceds", null);
        aIF();
        getIdentifier();
        ett();
        etu();
        this.pkD = "";
        this.activityManager = (ActivityManager) application.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
    }

    @Override // tv.chushou.basis.d.a.b.d
    public String aIF() {
        if (this.imei != null) {
            return this.imei;
        }
        Application etB = tv.chushou.basis.d.b.etB();
        if (etB.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            this.imei = ((TelephonyManager) etB.getSystemService("phone")).getDeviceId();
        }
        if (this.imei == null) {
            this.imei = "";
        } else {
            this.imei = tv.chushou.basis.b.a.a.a.b.encrypt(this.imei);
        }
        return this.imei;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String ett() {
        if (TextUtils.isEmpty(this.pkB)) {
            try {
                if (this.pkA == null) {
                    Application etB = tv.chushou.basis.d.b.etB();
                    this.pkz.put("device_id", Settings.Secure.getString(etB.getContentResolver(), "android_id"));
                    this.pkz.put("device_mac", getLocalMacAddress(etB));
                    this.pkA = new KSDevice();
                    this.pkA.setDevice(tv.chushou.basis.d.b.etB(), this.pkz);
                }
                this.pkB = this.pkA.getDeviceId();
            } catch (Exception e) {
                tv.chushou.basis.d.b.etC().e("Router", "device getDeviceCS failed", e);
            }
        }
        return this.pkB;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String etu() {
        if (TextUtils.isEmpty(this.pkC)) {
            try {
                SharedPreferences sharedPreferences = tv.chushou.basis.d.b.etB().getSharedPreferences("com_kascend_chushou_prefs", 0);
                this.pkC = sharedPreferences.getString("deviceds", null);
                if (TextUtils.isEmpty(this.pkC)) {
                    if (this.pkA == null) {
                        Application etB = tv.chushou.basis.d.b.etB();
                        this.pkz.put("device_id", Settings.Secure.getString(etB.getContentResolver(), "android_id"));
                        this.pkz.put("device_mac", getLocalMacAddress(etB));
                        this.pkA = new KSDevice();
                        this.pkA.setDevice(tv.chushou.basis.d.b.etB(), this.pkz);
                    }
                    this.pkC = this.pkA.getDS();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("deviceds", this.pkC);
                    edit.apply();
                }
            } catch (Exception e) {
                tv.chushou.basis.d.b.etC().e("Router", "device getDeviceDS failed", e);
            }
        }
        return this.pkC;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public Map<String, String> etv() {
        return this.pkz;
    }

    @Override // tv.chushou.basis.d.a.b.d
    public synchronized String getIdentifier() {
        if (TextUtils.isEmpty(this.identifier)) {
            SharedPreferences sharedPreferences = tv.chushou.basis.d.b.etB().getSharedPreferences("com_kascend_chushou_prefs", 0);
            this.identifier = sharedPreferences.getString("identifier", null);
            if (TextUtils.isEmpty(this.identifier)) {
                this.identifier = etw();
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

    private String etw() {
        String aIF = aIF();
        String decrypt = !TextUtils.isEmpty(aIF) ? tv.chushou.basis.b.a.a.a.b.decrypt(aIF) : aIF;
        String str = this.pkz.get("device_mac");
        if (TextUtils.isEmpty(str)) {
            str = getLocalMacAddress(tv.chushou.basis.d.b.etB());
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
