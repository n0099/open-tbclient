package com.meizu.cloud.pushsdk.a.a;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f41864b;

    public c(int i, String str) {
        this.a = i;
        this.f41864b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.a);
            jSONObject.put(TtmlNode.TAG_BODY, this.f41864b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
