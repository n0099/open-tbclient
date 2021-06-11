package com.yy.hiidostatis.inner.util.hdid;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.UUID;
/* loaded from: classes7.dex */
public class ClientIdHelper {
    public static final String BI_CLIENT_ID_FILE_NAME = "hdcltid.ini";
    public static final String BI_CLIENT_ID_FILE_SUFFIX = ".ini";
    public static final String BI_CLIENT_ID_PREF_FILE_NAME = "hdcltid";
    public static final String PREFIX_BUILD = "bp_";
    public static final String PREFIX_CUSTOM = "bc_";
    public static final String PREFIX_NORMAL = "bi_";
    public static final String PREFIX_SERIAL = "bs_";
    public static final String SP_BI_CLIENT_ID_KEY = "hdcltid";
    public static final String TAG = "ClientIdHelper";
    public static String mClientID = "";
    public static volatile ClientIdHelper mInstance;
    public IClientIdConfig mConfig;
    public final int boardDigit = boardDigit();
    public final int brandDigit = brandDigit();
    public final int cpuAbiDigit = cpuAbiDigit();
    public final int deviceDigit = deviceDigit();
    public final int manufacturerDigit = manufacturerDigit();
    public final int modelDigit = modelDigit();
    public final int productDigit = productDigit();

    public ClientIdHelper(IClientIdConfig iClientIdConfig) {
        this.mConfig = iClientIdConfig;
        checkConfig();
        initClientId();
        if (this.mConfig.logEnable()) {
            Log.d(TAG, "boardDigit = " + this.boardDigit);
            Log.d(TAG, "brandDigit = " + this.brandDigit);
            Log.d(TAG, "cpuAbiDigit = " + this.cpuAbiDigit);
            Log.d(TAG, "deviceDigit = " + this.deviceDigit);
            Log.d(TAG, "manufacturerDigit = " + this.manufacturerDigit);
            Log.d(TAG, "modelDigit = " + this.modelDigit);
            Log.d(TAG, "productDigit = " + this.productDigit);
        }
    }

    private int boardDigit() {
        if (TextUtils.isEmpty(Build.BOARD)) {
            return 0;
        }
        return Build.BOARD.length() % 10;
    }

    private int brandDigit() {
        if (TextUtils.isEmpty(Build.BRAND)) {
            return 0;
        }
        return Build.BRAND.length() % 10;
    }

    private boolean checkBuild() {
        return (((((this.boardDigit + this.brandDigit) + this.cpuAbiDigit) + this.deviceDigit) + this.manufacturerDigit) + this.modelDigit) + this.productDigit != 0;
    }

    private void checkConfig() {
        if (this.mConfig == null) {
            throw new RuntimeException("IConfig must be initialized !!");
        }
    }

    private int cpuAbiDigit() {
        if (TextUtils.isEmpty(Build.CPU_ABI)) {
            return 0;
        }
        return Build.CPU_ABI.length() % 10;
    }

    private String createPsuedoID() {
        return UUID.randomUUID().toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r3.isEmpty() != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String createUniquePsuedoID() {
        String str;
        String str2;
        String str3;
        boolean checkBuild = checkBuild();
        boolean z = false;
        try {
            str2 = Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : "";
            if (str2 != null) {
                try {
                } catch (Throwable th) {
                    str = str2;
                    th = th;
                    if (this.mConfig.logEnable()) {
                        th.printStackTrace();
                    }
                    str2 = str;
                    if (this.mConfig.logEnable()) {
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        z = true;
                    }
                    if (!z) {
                    }
                    String str4 = EventType.GiftEventID.LOAD_ALL_GIFT_FAIL + this.boardDigit + this.brandDigit + this.cpuAbiDigit + this.deviceDigit + this.manufacturerDigit + this.modelDigit + this.productDigit;
                    if (!checkBuild) {
                    }
                    if (!checkBuild) {
                    }
                    if (TextUtils.isEmpty(str3)) {
                    }
                    return str3.replaceAll("_", "").replaceAll("-", "");
                }
            }
            str2 = Build.class.getField("SERIAL").get(null).toString();
        } catch (Throwable th2) {
            th = th2;
            str = "";
        }
        if (this.mConfig.logEnable()) {
            Log.e(TAG, "serial = " + str2);
            Log.e(TAG, "buildParamOk = " + checkBuild);
        }
        if (!TextUtils.isEmpty(str2) && !str2.equalsIgnoreCase("unKnown")) {
            z = true;
        }
        if (!z) {
            str2 = "";
        }
        String str42 = EventType.GiftEventID.LOAD_ALL_GIFT_FAIL + this.boardDigit + this.brandDigit + this.cpuAbiDigit + this.deviceDigit + this.manufacturerDigit + this.modelDigit + this.productDigit;
        if (!checkBuild && !TextUtils.isEmpty(str2)) {
            str3 = PREFIX_NORMAL + new UUID(str42.hashCode(), str2.hashCode()).toString();
        } else if (!checkBuild) {
            str3 = PREFIX_BUILD + new UUID(str42.hashCode(), str2.hashCode()).toString();
        } else if (!TextUtils.isEmpty(str2)) {
            str3 = PREFIX_SERIAL + new UUID(str42.hashCode(), str2.hashCode()).toString();
        } else {
            str3 = PREFIX_CUSTOM + createPsuedoID();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = createPsuedoID();
        }
        return str3.replaceAll("_", "").replaceAll("-", "");
    }

    private int deviceDigit() {
        if (TextUtils.isEmpty(Build.DEVICE)) {
            return 0;
        }
        return Build.DEVICE.length() % 10;
    }

    public static ClientIdHelper getInstance() {
        if (mInstance != null) {
            return mInstance;
        }
        throw new RuntimeException("ClientIdHelper must be initialized ! init should be called Firstly !");
    }

    public static void init(IClientIdConfig iClientIdConfig) {
        if (mInstance == null) {
            synchronized (ClientIdHelper.class) {
                if (mInstance == null) {
                    mInstance = new ClientIdHelper(iClientIdConfig);
                }
            }
        }
    }

    private boolean initClientId() {
        String readFromSp = readFromSp();
        if (!TextUtils.isEmpty(readFromSp)) {
            setMemoryClientId(readFromSp);
            return true;
        }
        String createUniquePsuedoID = createUniquePsuedoID();
        if (TextUtils.isEmpty(createUniquePsuedoID)) {
            return false;
        }
        setClientId(createUniquePsuedoID);
        return true;
    }

    private int manufacturerDigit() {
        if (TextUtils.isEmpty(Build.MANUFACTURER)) {
            return 0;
        }
        return Build.MANUFACTURER.length() % 10;
    }

    private int modelDigit() {
        if (TextUtils.isEmpty(Build.MODEL)) {
            return 0;
        }
        return Build.MODEL.length() % 10;
    }

    private int productDigit() {
        if (TextUtils.isEmpty(Build.PRODUCT)) {
            return 0;
        }
        return Build.PRODUCT.length() % 10;
    }

    private String readFromSp() {
        if (this.mConfig.logEnable()) {
            Log.d(TAG, "readFromSp");
        }
        return sharedPref().getString("hdcltid", null);
    }

    private void setClientId(String str) {
        setMemoryClientId(str);
        writeIntoSp();
    }

    private void setMemoryClientId(String str) {
        mClientID = str;
    }

    private SharedPreferences sharedPref() {
        return this.mConfig.getAppContext().getSharedPreferences("hdcltid", 0);
    }

    private boolean writeIntoSp() {
        if (this.mConfig.logEnable()) {
            Log.d(TAG, "writeIntoSp" + mClientID);
        }
        return sharedPref().edit().putString("hdcltid", mClientID).commit();
    }

    public byte[] getByteClientId() {
        String str = mClientID;
        if (str != null) {
            return str.getBytes();
        }
        return null;
    }

    public String getClientId() {
        return mClientID;
    }
}
