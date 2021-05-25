package com.cmic.sso.sdk.b.b;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    public a f30508a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f30509b;

    /* renamed from: c  reason: collision with root package name */
    public String f30510c;

    /* renamed from: d  reason: collision with root package name */
    public String f30511d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30512e = false;

    /* loaded from: classes6.dex */
    public static class a {
        public String E;
        public long q;

        /* renamed from: a  reason: collision with root package name */
        public String f30513a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f30514b = "";

        /* renamed from: c  reason: collision with root package name */
        public String f30515c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f30516d = "";

        /* renamed from: e  reason: collision with root package name */
        public String f30517e = "";

        /* renamed from: f  reason: collision with root package name */
        public String f30518f = "";

        /* renamed from: g  reason: collision with root package name */
        public String f30519g = "";

        /* renamed from: h  reason: collision with root package name */
        public String f30520h = "";

        /* renamed from: i  reason: collision with root package name */
        public String f30521i = "";
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
            this.f30513a = v(str);
        }

        public void e(String str) {
            this.f30514b = v(str);
        }

        public void f(String str) {
            this.f30515c = v(str);
        }

        public void g(String str) {
            this.f30516d = v(str);
        }

        public void h(String str) {
            this.f30517e = v(str);
        }

        public void i(String str) {
            this.f30518f = v(str);
        }

        public void j(String str) {
            this.f30520h = v(str);
        }

        public void k(String str) {
            this.f30521i = v(str);
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
            return this.f30513a + "&" + this.f30514b + "&" + this.f30515c + "&" + this.f30516d + "&" + this.f30517e + "&" + this.f30518f + "&" + this.f30519g + "&" + this.f30520h + "&" + this.f30521i + "&" + this.j + "&" + this.k + "&" + this.l + "&" + this.m + "&6.0&" + this.n + "&" + this.o + "&" + this.p + "&" + this.r + "&" + this.s + "&" + this.t + "&" + this.u + "&" + this.v + "&" + this.w + "&" + this.x + "&" + this.y + "&" + this.z + "&" + this.A + "&" + this.B + "&" + this.E + "&&" + this.C + "&" + this.D;
        }

        public String u(String str) {
            return com.cmic.sso.sdk.d.d.a(this.f30514b + this.f30515c + this.f30516d + this.f30517e + this.f30518f + this.f30519g + this.f30520h + this.f30521i + this.j + this.k + this.l + this.m + this.o + this.p + str + this.r + this.s + this.t + this.u + this.v + this.w + this.x + this.y + this.z + this.A + this.B + this.C + this.D);
        }

        public void a(long j) {
            this.q = j;
        }

        public String a() {
            return this.f30515c;
        }
    }

    public void a(boolean z) {
        this.f30512e = z;
    }

    public void b(String str) {
        this.f30510c = str;
    }

    public a c() {
        return this.f30508a;
    }

    public void a(String str) {
        this.f30511d = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.f30512e) {
            try {
                jSONObject.put("encrypted", this.f30510c);
                jSONObject.put("reqdata", com.cmic.sso.sdk.d.a.a(this.f30509b, this.f30508a.toString()));
                jSONObject.put("securityreinforce", this.f30511d);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void a(byte[] bArr) {
        this.f30509b = bArr;
    }

    public void a(a aVar) {
        this.f30508a = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30508a.a();
    }
}
