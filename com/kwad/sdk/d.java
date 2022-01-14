package com.kwad.sdk;

import android.text.TextUtils;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
/* loaded from: classes3.dex */
public class d {
    public static String a = "kwrules.csv";

    /* renamed from: b  reason: collision with root package name */
    public static String f56580b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f56581c = "adEcDistribution";

    /* loaded from: classes3.dex */
    public static class a {
        public static String a() {
            return "/rest/sdk/common/appDownLoadInfo";
        }
    }

    public static String a() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_HOST_API");
        if (a2 != null) {
            String obj = a2.getValue().toString();
            if (!TextUtils.isEmpty(obj)) {
                return obj;
            }
        }
        return "https://open.e.kuaishou.com";
    }

    public static String b() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) com.kwad.sdk.plugin.f.a(DevelopMangerPlugin.class)).a("KEY_HOST_EC_SSP");
        if (a2 != null) {
            String obj = a2.getValue().toString();
            if (!TextUtils.isEmpty(obj)) {
                return obj;
            }
        }
        return "https://s.e.kuaishou.com";
    }

    public static String c() {
        return a() + "/rest/e/v3/open/univ";
    }

    public static String d() {
        return a() + "/rest/e/v3/open/logBatch";
    }

    public static String e() {
        return a() + "/rest/e/v3/open/config";
    }

    public static String f() {
        return a() + "/rest/e/v3/open/callback";
    }

    public static String g() {
        return a() + "/rest/e/v3/open/mediaPlayerLog";
    }

    public static String h() {
        return "/rest/sdk/log/upload";
    }

    public static String i() {
        return a() + "/rest/e/v3/open/crashLog";
    }

    public static String j() {
        return a() + "/rest/e/v3/open/sdk/js";
    }

    public static String k() {
        return a() + "/rest/e/v3/open/sdk/js2";
    }

    public static String l() {
        return a() + "/rest/e/v3/open/appCheck";
    }

    public static String m() {
        return a() + "/rest/e/v3/open/collect";
    }
}
