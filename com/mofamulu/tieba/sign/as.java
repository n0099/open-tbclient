package com.mofamulu.tieba.sign;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class as {
    protected String a;
    protected String b;
    protected int c;
    protected String d;
    protected String e;
    protected int f;
    protected long g;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.a);
            jSONObject.put("name", this.b);
            jSONObject.put("status", this.c);
            jSONObject.put(PushConstants.EXTRA_PUSH_MESSAGE, this.d);
            jSONObject.put("time", this.g);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public as(JSONObject jSONObject) {
        this.c = 0;
        this.a = jSONObject.optString("id");
        this.b = jSONObject.optString("name");
        this.c = jSONObject.optInt("status");
        this.d = jSONObject.optString(PushConstants.EXTRA_PUSH_MESSAGE);
        this.g = jSONObject.optLong("time");
    }

    public as() {
        this.c = 0;
    }

    public String b() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public int c() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(String str) {
        this.d = str;
    }

    public String d() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public int e() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public void a(long j) {
        this.g = j;
    }

    public void d(String str) {
        this.a = str;
    }
}
