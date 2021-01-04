package com.qq.e.comm.plugin.r.b;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f12674a;

    /* renamed from: b  reason: collision with root package name */
    private int f12675b;
    private int c;
    private String d;
    private String e;
    private List<c> f = new ArrayList();

    public a(JSONObject jSONObject) {
        this.f12674a = jSONObject.optString("pos_id");
        this.f12675b = jSONObject.optInt("timeout");
        this.c = jSONObject.optInt("request_type");
        this.d = jSONObject.optString("no_ad_view_id");
        this.e = jSONObject.optString("pos_view_id");
        JSONArray optJSONArray = jSONObject.optJSONArray("network_config");
        if (optJSONArray == null || optJSONArray.length() < 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            this.f.add(new c(optJSONArray.optJSONObject(i)));
        }
    }

    public String a() {
        return this.f12674a;
    }

    public int b() {
        return this.f12675b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public List<c> f() {
        for (c cVar : this.f) {
            cVar.c(0);
            cVar.c(false);
            cVar.a(-1);
            cVar.b(false);
            cVar.d(false);
            cVar.a(false);
        }
        return this.f;
    }
}
