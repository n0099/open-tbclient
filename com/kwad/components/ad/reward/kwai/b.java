package com.kwad.components.ad.reward.kwai;

import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
/* loaded from: classes8.dex */
public final class b {
    public static TemplateConfig fU() {
        SdkConfigData rZ = d.rZ();
        if (rZ == null) {
            return null;
        }
        return rZ.templateConfigMap.rewardReflowConfig;
    }

    public static int fV() {
        return a.nR.getValue().intValue();
    }

    public static String fW() {
        return a.nV.getValue();
    }

    public static int fX() {
        return a.nS.getValue().intValue();
    }

    public static boolean fY() {
        return a.nU.getValue().booleanValue();
    }

    public static int fZ() {
        return a.nT.getValue().intValue();
    }

    public static boolean ga() {
        return a.nX.getValue().intValue() == 1;
    }

    public static float gb() {
        return a.oc.getValue().floatValue();
    }

    public static boolean gc() {
        return a.oc.getValue().floatValue() > 0.0f && a.oc.getValue().floatValue() < 1.0f;
    }

    public static boolean gd() {
        return a.od.getValue().booleanValue();
    }

    public static long ge() {
        return a.oa.getValue().intValue();
    }

    public static int gf() {
        return a.ob.getValue().intValue();
    }

    public static int gg() {
        return a.oe.getValue().intValue();
    }

    public static boolean gh() {
        return a.og.getValue().booleanValue();
    }

    public static boolean gi() {
        return a.of.getValue().booleanValue();
    }

    public static boolean gj() {
        return a.oh.getValue().intValue() == 1 || a.oh.getValue().intValue() == 3;
    }

    public static boolean h(AdInfo adInfo) {
        return !i(adInfo) && com.kwad.sdk.core.response.a.a.bJ(adInfo) && ga();
    }

    public static boolean i(AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.bJ(adInfo) && a.nZ.getValue().intValue() == 1;
    }

    public static boolean j(AdInfo adInfo) {
        return h(adInfo);
    }
}
