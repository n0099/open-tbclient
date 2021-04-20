package com.cmic.sso.sdk.b.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30284a;

    /* renamed from: b  reason: collision with root package name */
    public String f30285b;

    /* renamed from: c  reason: collision with root package name */
    public String f30286c;

    /* renamed from: d  reason: collision with root package name */
    public String f30287d;

    /* renamed from: e  reason: collision with root package name */
    public String f30288e;

    /* renamed from: f  reason: collision with root package name */
    public String f30289f;

    /* renamed from: g  reason: collision with root package name */
    public String f30290g;

    /* renamed from: h  reason: collision with root package name */
    public String f30291h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;
    public JSONObject n;

    /* renamed from: com.cmic.sso.sdk.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0345a {

        /* renamed from: a  reason: collision with root package name */
        public String f30292a;

        /* renamed from: b  reason: collision with root package name */
        public String f30293b;

        /* renamed from: c  reason: collision with root package name */
        public String f30294c;

        /* renamed from: d  reason: collision with root package name */
        public String f30295d;

        /* renamed from: e  reason: collision with root package name */
        public String f30296e;

        /* renamed from: f  reason: collision with root package name */
        public String f30297f;

        /* renamed from: g  reason: collision with root package name */
        public String f30298g;

        /* renamed from: h  reason: collision with root package name */
        public String f30299h;
        public String i;
        public String j;
        public String k;

        public void a(String str) {
            this.f30292a = str;
        }

        public void b(String str) {
            this.f30293b = str;
        }

        public void c(String str) {
            this.f30294c = str;
        }

        public void d(String str) {
            this.f30295d = str;
        }

        public void e(String str) {
            this.f30296e = str;
        }

        public void f(String str) {
            this.f30297f = str;
        }

        public void g(String str) {
            this.f30298g = str;
        }

        public void h(String str) {
            this.f30299h = str;
        }

        public void i(String str) {
            this.i = str;
        }

        public void j(String str) {
            this.j = str;
        }

        public void k(String str) {
            this.k = str;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("phone_id", this.f30292a);
                jSONObject.put(IAdRequestParam.OS, this.f30293b);
                jSONObject.put("dev_model", this.f30294c);
                jSONObject.put("dev_brand", this.f30295d);
                jSONObject.put("mnc", this.f30296e);
                jSONObject.put("client_type", this.f30297f);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_NETWORK, this.f30298g);
                jSONObject.put("ipv4_list", this.f30299h);
                jSONObject.put("ipv6_list", this.i);
                jSONObject.put("is_cert", this.j);
                jSONObject.put("is_root", this.k);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
    }

    public void a(JSONObject jSONObject) {
        this.n = jSONObject;
    }

    public void b(String str) {
        this.i = str;
    }

    public void c(String str) {
        this.m = str;
    }

    public void d(String str) {
        this.f30289f = str;
    }

    public void e(String str) {
        this.f30290g = str;
    }

    public void f(String str) {
        this.f30284a = str;
    }

    public void g(String str) {
        this.f30285b = str;
    }

    public void h(String str) {
        this.f30286c = str;
    }

    public void i(String str) {
        this.f30287d = str;
    }

    public void j(String str) {
        this.f30288e = str;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public String m(String str) {
        return n(this.f30284a + this.f30286c + str + this.f30287d);
    }

    public String toString() {
        return b().toString();
    }

    public void a(long j) {
        this.l = j;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f30284a);
            jSONObject.put("msgid", this.f30285b);
            jSONObject.put("appid", this.f30286c);
            jSONObject.put("scrip", this.f30287d);
            jSONObject.put("sign", this.f30288e);
            jSONObject.put("interfacever", this.f30289f);
            jSONObject.put("userCapaid", this.f30290g);
            jSONObject.put("clienttype", this.f30291h);
            jSONObject.put("sourceid", this.i);
            jSONObject.put("authenticated_appid", this.j);
            jSONObject.put("genTokenByAppid", this.k);
            jSONObject.put("rcData", this.n);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f30291h = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30286c;
    }
}
