package com.kwad.components.ad.reward.a;

import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes10.dex */
public final class b {
    public static boolean gA() {
        if (a.qH.getValue().intValue() == 1 || a.qH.getValue().intValue() == 3) {
            return true;
        }
        return false;
    }

    public static boolean gB() {
        return a.qI.getValue().booleanValue();
    }

    public static boolean gC() {
        return a.qJ.getValue().booleanValue();
    }

    public static int gn() {
        return a.qs.getValue().intValue();
    }

    public static String go() {
        return a.qw.getValue();
    }

    public static int gp() {
        return a.qt.getValue().intValue();
    }

    public static boolean gq() {
        return a.qv.getValue().booleanValue();
    }

    public static int gr() {
        return a.qu.getValue().intValue();
    }

    public static boolean gs() {
        if (a.qy.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static float gt() {
        return a.qD.getValue().floatValue();
    }

    public static boolean gu() {
        if (a.qD.getValue().floatValue() > 0.0f && a.qD.getValue().floatValue() < 1.0f) {
            return true;
        }
        return false;
    }

    public static boolean gv() {
        return a.qE.getValue().booleanValue();
    }

    public static long gw() {
        return a.qB.getValue().intValue();
    }

    public static int gx() {
        return a.qC.getValue().intValue();
    }

    public static int gy() {
        return a.qF.getValue().intValue();
    }

    public static boolean gz() {
        return a.qG.getValue().booleanValue();
    }

    public static boolean i(AdInfo adInfo) {
        if (j(adInfo) || !com.kwad.sdk.core.response.b.a.cH(adInfo) || !gs()) {
            return false;
        }
        return true;
    }

    public static boolean j(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.cH(adInfo) && a.qA.getValue().intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean k(AdInfo adInfo) {
        return i(adInfo);
    }
}
