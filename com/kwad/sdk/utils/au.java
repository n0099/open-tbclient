package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class au {
    public static boolean KE() {
        if (!com.kwad.framework.a.a.mc.booleanValue()) {
            return false;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static boolean KF() {
        KsCustomController ksCustomController;
        if (KE()) {
            return true;
        }
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Location KG() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                return ksCustomController.getLocation();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String KH() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                return ksCustomController.getImei();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] KI() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String KJ() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                return ksCustomController.getAndroidId();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean KK() {
        KsCustomController ksCustomController;
        if (KE()) {
            return true;
        }
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String KL() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                return ksCustomController.getMacAddress();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean KM() {
        KsCustomController ksCustomController;
        if (KE()) {
            return true;
        }
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String KN() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                return ksCustomController.getOaid();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean KO() {
        KsCustomController ksCustomController;
        if (KE()) {
            return true;
        }
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean KP() {
        KsCustomController ksCustomController;
        if (KE()) {
            return true;
        }
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean KQ() {
        KsCustomController ksCustomController;
        if (KE()) {
            return true;
        }
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<String> KR() {
        KsCustomController ksCustomController;
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static boolean usePhoneStateDisable() {
        KsCustomController ksCustomController;
        if (KE()) {
            return true;
        }
        try {
            SdkConfig Jo = ServiceProvider.Jo();
            if (Jo != null && (ksCustomController = Jo.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
