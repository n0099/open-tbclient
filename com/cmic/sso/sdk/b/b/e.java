package com.cmic.sso.sdk.b.b;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    public a f30579a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f30580b;

    /* renamed from: c  reason: collision with root package name */
    public String f30581c;

    /* renamed from: d  reason: collision with root package name */
    public String f30582d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30583e = false;

    /* loaded from: classes6.dex */
    public static class a {
        public String E;
        public long q;

        /* renamed from: a  reason: collision with root package name */
        public String f30584a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f30585b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f30586c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f30587d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f30588e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f30589f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f30590g = "";

        /* renamed from: h  reason: collision with root package name */
        public String f30591h = "";

        /* renamed from: i  reason: collision with root package name */
        public String f30592i = "";
        public String j = "";
        public String k = "";
        public String l = "";
        public String m = "";
        public String n = "";
        public String o = "";
        public String p = "";
        public String r = "";
        public String s = "";
        public String t = "";
        public String u = "";
        public String v = "";
        public String w = "";
        public String x = "";
        public String y = "";
        public String z = "";
        public String A = "";
        public String B = "";
        public String C = "";
        public String D = "";

        private String v(String str) {
            return str == null ? "" : str;
        }

        public void a(String str) {
            this.C = str;
        }

        public void b(String str) {
            this.D = str;
        }

        public void c(String str) {
            this.y = str;
        }

        public void d(String str) {
            this.f30584a = v(str);
        }

        public void e(String str) {
            this.f30585b = v(str);
        }

        public void f(String str) {
            this.f30586c = v(str);
        }

        public void g(String str) {
            this.f30587d = v(str);
        }

        public void h(String str) {
            this.f30588e = v(str);
        }

        public void i(String str) {
            this.f30589f = v(str);
        }

        public void j(String str) {
            this.f30591h = v(str);
        }

        public void k(String str) {
            this.f30592i = v(str);
        }

        public void l(String str) {
            String v = v(str);
            try {
                this.j = URLEncoder.encode(v, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                this.j = v;
            }
        }

        public void m(String str) {
            String v = v(str);
            try {
                this.k = URLEncoder.encode(v, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                this.k = v;
            }
        }

        public void n(String str) {
            this.l = v(str);
        }

        public void o(String str) {
            this.m = v(str);
        }

        public void p(String str) {
            this.o = v(str);
        }

        public void q(String str) {
            this.p = v(str);
        }

        public void r(String str) {
            this.A = v(str);
        }

        public void s(String str) {
            this.B = v(str);
        }

        public void t(String str) {
            this.E = v(str);
        }

        public String toString() {
            return this.f30584a + "&" + this.f30585b + "&" + this.f30586c + "&" + this.f30587d + "&" + this.f30588e + "&" + this.f30589f + "&" + this.f30590g + "&" + this.f30591h + "&" + this.f30592i + "&" + this.j + "&" + this.k + "&" + this.l + "&" + this.m + "&6.0&" + this.n + "&" + this.o + "&" + this.p + "&" + this.r + "&" + this.s + "&" + this.t + "&" + this.u + "&" + this.v + "&" + this.w + "&" + this.x + "&" + this.y + "&" + this.z + "&" + this.A + "&" + this.B + "&" + this.E + "&&" + this.C + "&" + this.D;
        }

        public String u(String str) {
            return com.cmic.sso.sdk.d.d.a(this.f30585b + this.f30586c + this.f30587d + this.f30588e + this.f30589f + this.f30590g + this.f30591h + this.f30592i + this.j + this.k + this.l + this.m + this.o + this.p + str + this.r + this.s + this.t + this.u + this.v + this.w + this.x + this.y + this.z + this.A + this.B + this.C + this.D);
        }

        public void a(long j) {
            this.q = j;
        }

        public String a() {
            return this.f30586c;
        }
    }

    public void a(boolean z) {
        this.f30583e = z;
    }

    public void b(String str) {
        this.f30581c = str;
    }

    public a c() {
        return this.f30579a;
    }

    public void a(String str) {
        this.f30582d = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f30583e) {
            try {
                jSONObject.put("encrypted", this.f30581c);
                jSONObject.put("reqdata", com.cmic.sso.sdk.d.a.a(this.f30580b, this.f30579a.toString()));
                jSONObject.put("securityreinforce", this.f30582d);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void a(byte[] bArr) {
        this.f30580b = bArr;
    }

    public void a(a aVar) {
        this.f30579a = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30579a.a();
    }
}
