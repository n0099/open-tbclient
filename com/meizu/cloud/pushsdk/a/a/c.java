package com.meizu.cloud.pushsdk.a.a;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {
    public int a;
    public String b;

    public c(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.a);
            jSONObject.put(TtmlNode.TAG_BODY, this.b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
