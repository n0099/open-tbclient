package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;
/* loaded from: classes5.dex */
public final class b {
    public static String a() {
        String str = "https://" + com.kwad.sdk.core.network.idc.a.a().a("api", "open.e.kuaishou.com");
        com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        return str;
    }

    public static String b() {
        return a() + "/rest/e/v3/open/univ";
    }

    public static String c() {
        return a() + "/rest/e/v4/open/univ";
    }

    public static String d() {
        return a() + "/rest/e/v4/open/univ/bidding";
    }

    public static String e() {
        return a() + "/rest/e/v4/open/univ/getMaterial";
    }

    public static String f() {
        return a() + "/rest/e/v3/open/logBatch";
    }

    public static String g() {
        return a() + "/rest/e/v3/open/config";
    }

    public static String h() {
        return a() + "/rest/e/v3/open/callback";
    }

    public static String i() {
        return a() + "/rest/e/v3/open/mediaPlayerLog";
    }

    public static String j() {
        return a() + "/rest/e/v3/open/crashLog";
    }

    public static String k() {
        return a() + "/rest/e/v3/open/appCheck";
    }

    public static String l() {
        return a() + "/rest/e/v3/open/collect";
    }
}
