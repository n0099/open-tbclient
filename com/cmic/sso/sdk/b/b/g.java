package com.cmic.sso.sdk.b.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class g {
    public abstract String a();

    public abstract String a(String str);

    public abstract JSONObject b();

    public String w(String str) {
        return com.cmic.sso.sdk.d.d.a(a(str)).toLowerCase();
    }
}
