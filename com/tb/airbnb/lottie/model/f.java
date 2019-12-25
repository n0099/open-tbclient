package com.tb.airbnb.lottie.model;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    private final String hw;
    private final float hx;
    private final String name;
    private final String style;

    f(String str, String str2, String str3, float f) {
        this.hw = str;
        this.name = str2;
        this.style = str3;
        this.hx = f;
    }

    public String cg() {
        return this.hw;
    }

    public String getName() {
        return this.name;
    }

    public String ch() {
        return this.style;
    }

    /* loaded from: classes2.dex */
    public static class a {
        public static f dD(JSONObject jSONObject) {
            return new f(jSONObject.optString("fFamily"), jSONObject.optString("fName"), jSONObject.optString("fStyle"), (float) jSONObject.optDouble("ascent"));
        }
    }
}
