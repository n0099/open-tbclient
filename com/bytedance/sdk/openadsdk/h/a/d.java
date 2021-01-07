package com.bytedance.sdk.openadsdk.h.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.a.d;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d<T extends d> implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f7475a;

    /* renamed from: b  reason: collision with root package name */
    private String f7476b;
    private String c;
    private String e;
    private String h;
    private String j;
    private String k;
    private String l;
    private String m;
    private String d = "3.2.5.1";
    private long f = System.currentTimeMillis() / 1000;
    private int g = 0;
    private int i = 0;

    public static d<d> b() {
        return new d<>();
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.b
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(c())) {
                jSONObject.put("type", c());
            }
            if (!TextUtils.isEmpty(e())) {
                jSONObject.put("rit", e());
            }
            if (!TextUtils.isEmpty(f())) {
                jSONObject.put("creative_id", f());
            }
            if (!TextUtils.isEmpty(g())) {
                jSONObject.put("ad_sdk_version", g());
            }
            if (!TextUtils.isEmpty(h())) {
                jSONObject.put("app_version", h());
            } else {
                jSONObject.put("app_version", aj.f());
            }
            if (i() > 0) {
                jSONObject.put("timestamp", i());
            }
            if (j() > 0) {
                jSONObject.put("adtype", j());
            }
            if (!TextUtils.isEmpty(k())) {
                jSONObject.put("req_id", k());
            }
            jSONObject.put("error_code", l());
            if (!TextUtils.isEmpty(m())) {
                jSONObject.put("error_msg", m());
            }
            if (!TextUtils.isEmpty(n())) {
                jSONObject.put("extra", n());
            }
            if (!TextUtils.isEmpty(o())) {
                jSONObject.put("image_url", o());
            }
            if (!TextUtils.isEmpty(d())) {
                jSONObject.put("event_extra", d());
            }
            jSONObject.put("conn_type", x.b(p.a()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jSONObject.put("device_info", p());
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    private JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            jSONObject.put("imei", k.d(p.a()));
            jSONObject.put("oaid", y.a());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private T q() {
        return this;
    }

    public String c() {
        return this.f7475a;
    }

    public T a(String str) {
        this.f7475a = str;
        return q();
    }

    public String d() {
        return this.m;
    }

    public T b(String str) {
        this.m = str;
        return q();
    }

    public String e() {
        return this.f7476b;
    }

    public T c(String str) {
        this.f7476b = str;
        return q();
    }

    public String f() {
        return this.c;
    }

    public T d(String str) {
        this.c = str;
        return q();
    }

    public String g() {
        return this.d;
    }

    public T e(String str) {
        this.d = str;
        return q();
    }

    public String h() {
        return this.e;
    }

    public long i() {
        return this.f;
    }

    public T c(long j) {
        this.f = j;
        return q();
    }

    public int j() {
        return this.g;
    }

    public T a(int i) {
        this.g = i;
        return q();
    }

    public String k() {
        return this.h;
    }

    public T f(String str) {
        this.h = str;
        return q();
    }

    public int l() {
        return this.i;
    }

    public T b(int i) {
        this.i = i;
        return q();
    }

    public String m() {
        return this.j;
    }

    public T g(String str) {
        this.j = str;
        return q();
    }

    public String n() {
        return this.k;
    }

    public T h(String str) {
        this.k = str;
        return q();
    }

    public String o() {
        return this.l;
    }

    public T i(String str) {
        this.l = str;
        return q();
    }
}
