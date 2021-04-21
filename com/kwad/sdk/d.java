package com.kwad.sdk;

import android.text.TextUtils;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.g;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f34896a;

    /* renamed from: b  reason: collision with root package name */
    public static String f34897b;

    static {
        f34896a = a.f32026a.booleanValue() ? 1 : 2;
        f34897b = "kwrules.csv";
    }

    public static String a() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) g.a(DevelopMangerPlugin.class)).a("KEY_HOST_API");
        if (a2 != null) {
            String obj = a2.getValue().toString();
            if (!TextUtils.isEmpty(obj)) {
                return obj;
            }
        }
        return "https://open.e.kuaishou.com";
    }

    public static String b() {
        return a() + "/rest/e/v3/open/univ";
    }

    public static String c() {
        return a() + "/rest/e/v3/open/feed";
    }

    public static String d() {
        return a() + "/rest/e/v3/open/logBatch";
    }

    public static String e() {
        return a() + "/rest/e/v3/open/config";
    }

    public static String f() {
        return a() + "/rest/e/v3/open/share";
    }

    public static String g() {
        return a() + "/rest/e/v3/open/comment";
    }

    public static String h() {
        return a() + "/rest/e/v3/open/trend/list";
    }

    public static String i() {
        return a() + "/rest/e/v3/open/trend/feed";
    }

    public static String j() {
        return a() + "/rest/e/v3/open/mediaPlayerLog";
    }

    public static String k() {
        return a() + "/rest/e/v3/open/user/profile";
    }

    public static String l() {
        return a() + "/rest/e/v3/open/user/feed";
    }

    public static String m() {
        return a() + "/rest/e/v3/open/live/status";
    }

    public static String n() {
        return a() + "/rest/e/v3/open/live/share";
    }

    public static String o() {
        return a() + "/rest/e/v3/open/tube/profile";
    }

    public static String p() {
        return a() + "/rest/e/v3/open/tube/feed";
    }

    public static String q() {
        return a() + "/rest/e/v3/open/crashLog";
    }

    public static String r() {
        return a() + "/rest/e/v3/open/suggest/feed";
    }

    public static String s() {
        return "https://zt.gifshow.com/rest/zt/emoticon/package/list";
    }

    public static String t() {
        return a() + "/rest/e/v3/open/appCheck";
    }
}
