package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class an {
    public static boolean a() {
        KsCustomController ksCustomController;
        if (o()) {
            return true;
        }
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Location b() {
        KsCustomController ksCustomController;
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k == null || (ksCustomController = k.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c() {
        KsCustomController ksCustomController;
        if (o()) {
            return true;
        }
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String d() {
        KsCustomController ksCustomController;
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            return (k == null || (ksCustomController = k.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] e() {
        KsCustomController ksCustomController;
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String f() {
        KsCustomController ksCustomController;
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            return (k == null || (ksCustomController = k.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean g() {
        KsCustomController ksCustomController;
        if (o()) {
            return true;
        }
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String h() {
        KsCustomController ksCustomController;
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            return (k == null || (ksCustomController = k.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean i() {
        KsCustomController ksCustomController;
        if (o()) {
            return true;
        }
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String j() {
        KsCustomController ksCustomController;
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            return (k == null || (ksCustomController = k.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean k() {
        KsCustomController ksCustomController;
        if (o()) {
            return true;
        }
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean l() {
        KsCustomController ksCustomController;
        if (o()) {
            return true;
        }
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean m() {
        KsCustomController ksCustomController;
        if (o()) {
            return true;
        }
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<String> n() {
        KsCustomController ksCustomController;
        try {
            SdkConfig k = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).k();
            if (k != null && (ksCustomController = k.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }

    public static boolean o() {
        if (com.kwad.b.kwai.a.b.booleanValue()) {
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            return false;
        }
        return false;
    }
}
