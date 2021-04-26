package com.kwad.sdk;

import android.text.TextUtils;
import com.kwad.sdk.plugin.DevelopMangerPlugin;
import com.kwad.sdk.plugin.f;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f33864a;

    /* renamed from: b  reason: collision with root package name */
    public static String f33865b;

    static {
        f33864a = b.f32644a.booleanValue() ? 1 : 2;
        f33865b = "kwrules.csv";
    }

    public static String a() {
        DevelopMangerPlugin.DevelopValue a2 = ((DevelopMangerPlugin) f.a(DevelopMangerPlugin.class)).a("KEY_HOST_API");
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
        return a() + "/rest/e/v3/open/logBatch";
    }

    public static String d() {
        return a() + "/rest/e/v3/open/config";
    }

    public static String e() {
        return a() + "/rest/e/v3/open/mediaPlayerLog";
    }

    public static String f() {
        return a() + "/rest/e/v3/open/crashLog";
    }

    public static String g() {
        return a() + "/rest/e/v3/open/appCheck";
    }

    public static String h() {
        return a() + "/rest/e/v3/open/collect";
    }
}
