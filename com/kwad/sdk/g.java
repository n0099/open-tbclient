package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;
/* loaded from: classes10.dex */
public final class g {
    public static String bN(String str) {
        return str + "/rest/e/system/speed";
    }

    public static String xK() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.CJ().U("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return str;
    }

    public static String xL() {
        return xK() + "/rest/e/v3/open/univ";
    }

    public static String xM() {
        return xK() + "/rest/e/v4/open/univ";
    }

    public static String xN() {
        return xK() + "/rest/e/v4/open/univ/bidding";
    }

    public static String xO() {
        return xK() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String xP() {
        return xK() + "/rest/e/v3/open/logBatch";
    }

    public static String xQ() {
        return xK() + "/rest/e/v3/open/config";
    }

    public static String xR() {
        return xK() + "/rest/e/v3/open/callback";
    }

    public static String xS() {
        return xK() + "/rest/e/v3/open/crashLog";
    }

    public static String xT() {
        return xK() + "/rest/e/v3/open/appCheck";
    }

    public static String xU() {
        return xK() + "/rest/e/v3/open/collect";
    }

    public static String xV() {
        return xK() + "/rest/e/v3/open/checkReward";
    }

    public static String xW() {
        return xK() + "/rest/e/v3/open/kwaiGeoLocation";
    }
}
