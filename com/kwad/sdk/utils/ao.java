package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ao {
    public static boolean a() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canReadLocation();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Location b() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUsePhoneState();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String d() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] e() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String f() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean g() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseMacAddress();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String h() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean i() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseOaid();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String j() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean k() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseNetworkState();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean l() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canUseStoragePermission();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean m() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return false;
            }
            return !ksCustomController.canReadInstalledPackages();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static List<String> n() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = KsAdSDKImpl.get().getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }
}
