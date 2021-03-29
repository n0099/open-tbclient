package com.cmic.sso.sdk.b.b;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    public a f30627a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f30628b;

    /* renamed from: c  reason: collision with root package name */
    public String f30629c;

    /* renamed from: d  reason: collision with root package name */
    public String f30630d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30631e = false;

    /* loaded from: classes6.dex */
    public static class a {
        public String E;
        public long q;

        /* renamed from: a  reason: collision with root package name */
        public String f30632a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f30633b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f30634c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f30635d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f30636e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f30637f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f30638g = "";

        /* renamed from: h  reason: collision with root package name */
        public String f30639h = "";
        public String i = "";
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
            this.f30632a = v(str);
        }

        public void e(String str) {
            this.f30633b = v(str);
        }

        public void f(String str) {
            this.f30634c = v(str);
        }

        public void g(String str) {
            this.f30635d = v(str);
        }

        public void h(String str) {
            this.f30636e = v(str);
        }

        public void i(String str) {
            this.f30637f = v(str);
        }

        public void j(String str) {
            this.f30639h = v(str);
        }

        public void k(String str) {
            this.i = v(str);
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
            return this.f30632a + "&" + this.f30633b + "&" + this.f30634c + "&" + this.f30635d + "&" + this.f30636e + "&" + this.f30637f + "&" + this.f30638g + "&" + this.f30639h + "&" + this.i + "&" + this.j + "&" + this.k + "&" + this.l + "&" + this.m + "&6.0&" + this.n + "&" + this.o + "&" + this.p + "&" + this.r + "&" + this.s + "&" + this.t + "&" + this.u + "&" + this.v + "&" + this.w + "&" + this.x + "&" + this.y + "&" + this.z + "&" + this.A + "&" + this.B + "&" + this.E + "&&" + this.C + "&" + this.D;
        }

        public String u(String str) {
            return com.cmic.sso.sdk.d.d.a(this.f30633b + this.f30634c + this.f30635d + this.f30636e + this.f30637f + this.f30638g + this.f30639h + this.i + this.j + this.k + this.l + this.m + this.o + this.p + str + this.r + this.s + this.t + this.u + this.v + this.w + this.x + this.y + this.z + this.A + this.B + this.C + this.D);
        }

        public void a(long j) {
            this.q = j;
        }

        public String a() {
            return this.f30634c;
        }
    }

    public void a(boolean z) {
        this.f30631e = z;
    }

    public void b(String str) {
        this.f30629c = str;
    }

    public a c() {
        return this.f30627a;
    }

    public void a(String str) {
        this.f30630d = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f30631e) {
            try {
                jSONObject.put("encrypted", this.f30629c);
                jSONObject.put("reqdata", com.cmic.sso.sdk.d.a.a(this.f30628b, this.f30627a.toString()));
                jSONObject.put("securityreinforce", this.f30630d);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void a(byte[] bArr) {
        this.f30628b = bArr;
    }

    public void a(a aVar) {
        this.f30627a = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30627a.a();
    }
}
