package com.tb.airbnb.lottie;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {
    private final String dD;
    private final String fileName;
    private final int height;
    private final String id;
    private final int width;

    private g(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.id = str;
        this.fileName = str2;
        this.dD = str3;
    }

    /* loaded from: classes6.dex */
    static class a {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static g cu(JSONObject jSONObject) {
            return new g(jSONObject.optInt("w"), jSONObject.optInt("h"), jSONObject.optString("id"), jSONObject.optString("p"), jSONObject.optString("u"));
        }
    }

    public String getId() {
        return this.id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String bn() {
        return this.dD;
    }
}
