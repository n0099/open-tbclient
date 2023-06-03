package org.chromium.base;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.player.model.YYOption;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.compat.ApiHelperForP;
/* loaded from: classes2.dex */
public class BuildInfo {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_FINGERPRINT_LENGTH = 128;
    public static final String TAG = "BuildInfo";
    public static PackageInfo sBrowserPackageInfo = null;
    public static String sFirebaseAppId = "";
    public static boolean sInitialized;
    public final String abiString;
    public final String androidBuildFingerprint;
    public final String customThemes;
    public final String extractedFileSuffix;
    public final String gmsVersionCode;
    public final String hostPackageLabel;
    public final long hostVersionCode;
    public final String installerPackageName;
    public final boolean isTV;
    public final String packageName;
    public final String resourcesVersion;
    public final long versionCode;
    public final String versionName;

    /* loaded from: classes2.dex */
    public static class Holder {
        public static BuildInfo sInstance = new BuildInfo();
    }

    public BuildInfo() {
        String str;
        boolean z = true;
        sInitialized = true;
        try {
            Context applicationContext = ContextUtils.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            PackageManager packageManager = applicationContext.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            long packageVersionCode = packageVersionCode(packageInfo);
            this.hostVersionCode = packageVersionCode;
            PackageInfo packageInfo2 = null;
            if (sBrowserPackageInfo != null) {
                this.packageName = sBrowserPackageInfo.packageName;
                this.versionCode = packageVersionCode(sBrowserPackageInfo);
                this.versionName = nullToEmpty(sBrowserPackageInfo.versionName);
                sBrowserPackageInfo = null;
            } else {
                this.packageName = packageName;
                this.versionCode = packageVersionCode;
                this.versionName = nullToEmpty(packageInfo.versionName);
            }
            this.hostPackageLabel = nullToEmpty(packageManager.getApplicationLabel(packageInfo.applicationInfo));
            this.installerPackageName = nullToEmpty(packageManager.getInstallerPackageName(this.packageName));
            try {
                packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo2 != null) {
                str = String.valueOf(packageVersionCode(packageInfo2));
            } else {
                str = "gms versionCode not available.";
            }
            this.gmsVersionCode = str;
            String str2 = YYOption.IsLive.VALUE_TRUE;
            try {
                packageManager.getPackageInfo("projekt.substratum", 0);
            } catch (PackageManager.NameNotFoundException unused2) {
                str2 = "false";
            }
            this.customThemes = str2;
            String str3 = "Not Enabled";
            if (BuildConfig.R_STRING_PRODUCT_VERSION != 0) {
                try {
                    str3 = ContextUtils.getApplicationContext().getString(BuildConfig.R_STRING_PRODUCT_VERSION);
                } catch (Exception unused3) {
                    str3 = "Not found";
                }
            }
            this.resourcesVersion = str3;
            if (Build.VERSION.SDK_INT >= 21) {
                this.abiString = TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, Build.SUPPORTED_ABIS);
            } else {
                this.abiString = String.format("ABI1: %s, ABI2: %s", Build.CPU_ABI, Build.CPU_ABI2);
            }
            this.extractedFileSuffix = String.format("@%x_%x", Long.valueOf(this.versionCode), Long.valueOf(packageInfo.lastUpdateTime));
            this.androidBuildFingerprint = Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));
            UiModeManager uiModeManager = (UiModeManager) applicationContext.getSystemService("uimode");
            if (uiModeManager == null || uiModeManager.getCurrentModeType() != 4) {
                z = false;
            }
            this.isTV = z;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String nullToEmpty(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return charSequence.toString();
    }

    public static long packageVersionCode(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApiHelperForP.getLongVersionCode(packageInfo);
        }
        return packageInfo.versionCode;
    }

    public static void setBrowserPackageInfo(PackageInfo packageInfo) {
        sBrowserPackageInfo = packageInfo;
    }

    public static void setFirebaseAppId(String str) {
        sFirebaseAppId = str;
    }

    @CalledByNative
    public static String[] getAll() {
        String str;
        BuildInfo buildInfo = getInstance();
        String packageName = ContextUtils.getApplicationContext().getPackageName();
        String[] strArr = new String[25];
        strArr[0] = Build.BRAND;
        strArr[1] = Build.DEVICE;
        strArr[2] = Build.ID;
        strArr[3] = Build.MANUFACTURER;
        strArr[4] = Build.MODEL;
        strArr[5] = String.valueOf(Build.VERSION.SDK_INT);
        strArr[6] = Build.TYPE;
        strArr[7] = Build.BOARD;
        strArr[8] = packageName;
        strArr[9] = String.valueOf(buildInfo.hostVersionCode);
        strArr[10] = buildInfo.hostPackageLabel;
        strArr[11] = buildInfo.packageName;
        strArr[12] = String.valueOf(buildInfo.versionCode);
        strArr[13] = buildInfo.versionName;
        strArr[14] = buildInfo.androidBuildFingerprint;
        strArr[15] = buildInfo.gmsVersionCode;
        strArr[16] = buildInfo.installerPackageName;
        strArr[17] = buildInfo.abiString;
        strArr[18] = sFirebaseAppId;
        strArr[19] = buildInfo.customThemes;
        strArr[20] = buildInfo.resourcesVersion;
        strArr[21] = buildInfo.extractedFileSuffix;
        strArr[22] = String.valueOf(ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion);
        String str2 = "1";
        if (isDebugAndroid()) {
            str = "1";
        } else {
            str = "0";
        }
        strArr[23] = str;
        if (!buildInfo.isTV) {
            str2 = "0";
        }
        strArr[24] = str2;
        return strArr;
    }

    public static String getFirebaseAppId() {
        return sFirebaseAppId;
    }

    public static BuildInfo getInstance() {
        return Holder.sInstance;
    }

    @ChecksSdkIntAtLeast(codename = ExifInterface.LATITUDE_SOUTH)
    public static boolean isAtLeastS() {
        return Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH);
    }

    public static boolean isDebugAndroid() {
        if (!"eng".equals(Build.TYPE) && !"userdebug".equals(Build.TYPE)) {
            return false;
        }
        return true;
    }

    public static boolean targetsAtLeastS() {
        if (isAtLeastS() && ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion == 10000) {
            return true;
        }
        return false;
    }
}
