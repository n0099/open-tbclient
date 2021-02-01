package com.cmic.sso.sdk.c.b;

import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e extends g {

    /* renamed from: b  reason: collision with root package name */
    private byte[] f7709b;
    private String c;
    private String d;
    private boolean e = false;
    private a pwN;

    public void a(boolean z) {
        this.e = z;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(byte[] bArr) {
        this.f7709b = bArr;
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(a aVar) {
        this.pwN = aVar;
    }

    public a ern() {
        return this.pwN;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.pwN.a();
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.e) {
            try {
                jSONObject.put("encrypted", this.c);
                jSONObject.put("reqdata", com.cmic.sso.sdk.e.a.a(this.f7709b, this.pwN.toString()));
                jSONObject.put("securityreinforce", this.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* loaded from: classes15.dex */
    public static class a {
        private String E;
        private long q;

        /* renamed from: a  reason: collision with root package name */
        private String f7710a = "";

        /* renamed from: b  reason: collision with root package name */
        private String f7711b = "";
        private String c = "";
        private String d = "";
        private String e = "";
        private String f = "";
        private String g = "";
        private String h = "";
        private String i = "";
        private String j = "";
        private String k = "";
        private String l = "";
        private String m = "";
        private String n = "";
        private String o = "";
        private String p = "";
        private String r = "";
        private String s = "";
        private String t = "";
        private String u = "";
        private String v = "";
        private String w = "";
        private String x = "";
        private String y = "";
        private String z = "";
        private String A = "";
        private String B = "";
        private String C = "";
        private String D = "";

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
            this.z = str;
        }

        public void a(long j) {
            this.q = j;
        }

        public void e(String str) {
            this.f7710a = YX(str);
        }

        public void f(String str) {
            this.f7711b = YX(str);
        }

        public String a() {
            return this.c;
        }

        public void g(String str) {
            this.c = YX(str);
        }

        public void h(String str) {
            this.d = YX(str);
        }

        public void i(String str) {
            this.e = YX(str);
        }

        public void j(String str) {
            this.f = YX(str);
        }

        public void k(String str) {
            this.g = YX(str);
        }

        public void l(String str) {
            this.h = YX(str);
        }

        public void m(String str) {
            this.i = YX(str);
        }

        public void n(String str) {
            String YX = YX(str);
            try {
                this.j = URLEncoder.encode(YX, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                this.j = YX;
            }
        }

        public void o(String str) {
            String YX = YX(str);
            try {
                this.k = URLEncoder.encode(YX, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                this.k = YX;
            }
        }

        public void p(String str) {
            this.l = YX(str);
        }

        public void q(String str) {
            this.m = YX(str);
        }

        public void r(String str) {
            this.o = YX(str);
        }

        public void s(String str) {
            this.p = YX(str);
        }

        public void t(String str) {
            this.A = YX(str);
        }

        public void u(String str) {
            this.B = YX(str);
        }

        public void v(String str) {
            this.E = YX(str);
        }

        public String YW(String str) {
            return com.cmic.sso.sdk.e.d.a(this.f7711b + this.c + this.d + this.e + this.f + this.g + this.h + this.i + this.j + this.k + this.l + this.m + this.o + this.p + str + this.r + this.s + this.t + this.u + this.v + this.w + this.x + this.y + this.z + this.A + this.B + this.C + this.D);
        }

        public String toString() {
            return this.f7710a + ETAG.ITEM_SEPARATOR + this.f7711b + ETAG.ITEM_SEPARATOR + this.c + ETAG.ITEM_SEPARATOR + this.d + ETAG.ITEM_SEPARATOR + this.e + ETAG.ITEM_SEPARATOR + this.f + ETAG.ITEM_SEPARATOR + this.g + ETAG.ITEM_SEPARATOR + this.h + ETAG.ITEM_SEPARATOR + this.i + ETAG.ITEM_SEPARATOR + this.j + ETAG.ITEM_SEPARATOR + this.k + ETAG.ITEM_SEPARATOR + this.l + ETAG.ITEM_SEPARATOR + this.m + ETAG.ITEM_SEPARATOR + "6.0" + ETAG.ITEM_SEPARATOR + this.n + ETAG.ITEM_SEPARATOR + this.o + ETAG.ITEM_SEPARATOR + this.p + ETAG.ITEM_SEPARATOR + this.r + ETAG.ITEM_SEPARATOR + this.s + ETAG.ITEM_SEPARATOR + this.t + ETAG.ITEM_SEPARATOR + this.u + ETAG.ITEM_SEPARATOR + this.v + ETAG.ITEM_SEPARATOR + this.w + ETAG.ITEM_SEPARATOR + this.x + ETAG.ITEM_SEPARATOR + this.y + ETAG.ITEM_SEPARATOR + this.z + ETAG.ITEM_SEPARATOR + this.A + ETAG.ITEM_SEPARATOR + this.B + ETAG.ITEM_SEPARATOR + this.E + "&&" + this.C + ETAG.ITEM_SEPARATOR + this.D;
        }

        private String YX(String str) {
            return str == null ? "" : str;
        }
    }
}
