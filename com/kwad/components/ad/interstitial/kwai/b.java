package com.kwad.components.ad.interstitial.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes8.dex */
public final class b {
    public static int b(AdInfo adInfo) {
        int intValue = a.fN.getValue().intValue();
        if (com.kwad.sdk.core.response.a.a.aB(adInfo)) {
            return Math.min(intValue, com.kwad.sdk.core.response.a.a.B(adInfo));
        }
        if (intValue > 60) {
            return 60;
        }
        return intValue;
    }

    public static boolean c(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.bJ(adInfo) && a.fQ.getValue().intValue() == 1;
    }

    public static boolean ci() {
        return a.fP.getValue().booleanValue();
    }

    public static boolean cj() {
        return a.fJ.getValue().intValue() == 1;
    }

    public static int ck() {
        return a.fK.getValue().intValue();
    }

    public static boolean cl() {
        return a.fL.getValue().intValue() == 1;
    }

    public static boolean cm() {
        return a.fM.getValue().intValue() == 1;
    }

    public static int cn() {
        return a.fR.getValue().intValue();
    }

    public static boolean co() {
        return a.fO.getValue().intValue() == 1;
    }
}
