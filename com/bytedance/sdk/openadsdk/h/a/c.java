package com.bytedance.sdk.openadsdk.h.a;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.x;
import com.bytedance.sdk.openadsdk.utils.y;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c<T extends c> implements a {

    /* renamed from: a  reason: collision with root package name */
    public String f29112a;

    /* renamed from: b  reason: collision with root package name */
    public String f29113b;

    /* renamed from: c  reason: collision with root package name */
    public String f29114c;

    /* renamed from: e  reason: collision with root package name */
    public String f29116e;

    /* renamed from: h  reason: collision with root package name */
    public String f29119h;
    public String j;
    public String k;
    public String l;
    public String m;

    /* renamed from: d  reason: collision with root package name */
    public String f29115d = "3.4.5.5";

    /* renamed from: f  reason: collision with root package name */
    public long f29117f = System.currentTimeMillis() / 1000;

    /* renamed from: g  reason: collision with root package name */
    public int f29118g = 0;
    public int i = 0;

    public static c<c> b() {
        return new c<>();
    }

    private JSONObject p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdRequestParam.OS, 1);
            jSONObject.put("imei", k.d(p.a()));
            jSONObject.put("oaid", y.a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private T q() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
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
                jSONObject.put("app_version", ak.g());
            }
            if (i() > 0) {
                jSONObject.put("timestamp", i());
            }
            if (j() > 0) {
                jSONObject.put("adtype", j());
            }
            if (!TextUtils.isEmpty(k())) {
                jSONObject.put(IAdRequestParam.REQ_ID, k());
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
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("device_info", p());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String c() {
        return this.f29112a;
    }

    public String d() {
        return this.m;
    }

    public String e() {
        return this.f29113b;
    }

    public String f() {
        return this.f29114c;
    }

    public String g() {
        return this.f29115d;
    }

    public String h() {
        return this.f29116e;
    }

    public long i() {
        return this.f29117f;
    }

    public int j() {
        return this.f29118g;
    }

    public String k() {
        return this.f29119h;
    }

    public int l() {
        return this.i;
    }

    public String m() {
        return this.j;
    }

    public String n() {
        return this.k;
    }

    public String o() {
        return this.l;
    }

    public T b(String str) {
        this.m = str;
        return q();
    }

    public T c(String str) {
        this.f29113b = str;
        return q();
    }

    public T d(String str) {
        this.f29114c = str;
        return q();
    }

    public T e(String str) {
        this.f29115d = str;
        return q();
    }

    public T f(String str) {
        this.f29119h = str;
        return q();
    }

    public T g(String str) {
        this.j = str;
        return q();
    }

    public T h(String str) {
        this.k = str;
        return q();
    }

    public T i(String str) {
        this.l = str;
        return q();
    }

    public T b(int i) {
        this.i = i;
        return q();
    }

    public T c(long j) {
        this.f29117f = j;
        return q();
    }

    public T a(String str) {
        this.f29112a = str;
        return q();
    }

    public T a(int i) {
        this.f29118g = i;
        return q();
    }
}
