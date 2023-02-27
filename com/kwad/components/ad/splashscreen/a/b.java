package com.kwad.components.ad.splashscreen.a;

import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
/* loaded from: classes8.dex */
public final class b {
    public static TemplateConfig jJ() {
        SdkConfigData rZ = d.rZ();
        if (rZ == null) {
            return null;
        }
        return rZ.splashConfig;
    }

    public static int jK() {
        int intValue = a.yl.getValue().intValue();
        if (intValue > 0) {
            return intValue;
        }
        return 5000;
    }

    public static String jL() {
        return a.yp.getValue();
    }

    public static int jM() {
        return a.yq.getValue().intValue();
    }

    public static int jN() {
        return a.yr.getValue().intValue();
    }

    public static int jO() {
        return a.ys.getValue().intValue();
    }

    public static int jP() {
        return a.ym.getValue().intValue();
    }

    public static String jQ() {
        return a.yn.getValue();
    }

    public static String jR() {
        return a.yo.getValue();
    }

    public static boolean jS() {
        return a.yt.getValue().booleanValue();
    }
}
