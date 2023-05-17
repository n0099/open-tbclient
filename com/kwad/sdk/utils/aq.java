package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class aq {
    public static String Aa() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Ab() {
        KsCustomController ksCustomController;
        if (zS()) {
            return true;
        }
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String Ac() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Ad() {
        KsCustomController ksCustomController;
        if (zS()) {
            return true;
        }
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Ae() {
        KsCustomController ksCustomController;
        if (zS()) {
            return true;
        }
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Af() {
        KsCustomController ksCustomController;
        if (zS()) {
            return true;
        }
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<String> Ag() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static boolean zS() {
        if (com.kwad.b.kwai.a.aw.booleanValue()) {
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            return false;
        }
        return false;
    }

    public static boolean zT() {
        KsCustomController ksCustomController;
        if (zS()) {
            return true;
        }
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Location zU() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zV() {
        KsCustomController ksCustomController;
        if (zS()) {
            return true;
        }
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String zW() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] zX() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String zY() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            return (sdkConfig == null || (ksCustomController = sdkConfig.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean zZ() {
        KsCustomController ksCustomController;
        if (zS()) {
            return true;
        }
        try {
            SdkConfig sdkConfig = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getSdkConfig();
            if (sdkConfig != null && (ksCustomController = sdkConfig.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
