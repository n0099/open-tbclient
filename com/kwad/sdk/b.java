package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;
/* loaded from: classes5.dex */
public final class b {
    public static String qJ() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.tH().F("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return str;
    }

    public static String qK() {
        return qJ() + "/rest/e/v3/open/univ";
    }

    public static String qL() {
        return qJ() + "/rest/e/v4/open/univ";
    }

    public static String qM() {
        return qJ() + "/rest/e/v4/open/univ/bidding";
    }

    public static String qN() {
        return qJ() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String qO() {
        return qJ() + "/rest/e/v3/open/logBatch";
    }

    public static String qP() {
        return qJ() + "/rest/e/v3/open/config";
    }

    public static String qQ() {
        return qJ() + "/rest/e/v3/open/callback";
    }

    public static String qR() {
        return qJ() + "/rest/e/v3/open/crashLog";
    }

    public static String qS() {
        return qJ() + "/rest/e/v3/open/appCheck";
    }

    public static String qT() {
        return qJ() + "/rest/e/v3/open/collect";
    }
}
