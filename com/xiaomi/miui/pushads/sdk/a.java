package com.xiaomi.miui.pushads.sdk;

import android.os.Bundle;
import com.xiaomi.push.ce;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends ce {
    public String a;

    @Override // com.xiaomi.push.ce
    public Bundle a() {
        Bundle a = super.a();
        a.putString("content", this.a);
        return a;
    }

    @Override // com.xiaomi.push.ce
    public void a(JSONObject jSONObject) {
        super.a(jSONObject);
        this.a = jSONObject.optString("content");
    }

    @Override // com.xiaomi.push.ce
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f178a);
            jSONObject.put("showType", this.a);
            jSONObject.put("lastShowTime", this.f180b);
            jSONObject.put("content", this.a);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
