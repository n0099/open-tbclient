package com.cmic.sso.sdk.c.b;

import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends g {
    private byte[] b;
    private String c;
    private String d;
    private boolean e = false;
    private a ozI;

    public void a(boolean z) {
        this.e = z;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(a aVar) {
        this.ozI = aVar;
    }

    public a eeY() {
        return this.ozI;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.ozI.a();
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        if (this.e) {
            try {
                jSONObject.put("encrypted", this.c);
                jSONObject.put("reqdata", com.cmic.sso.sdk.e.a.a(this.b, this.ozI.toString()));
                jSONObject.put("securityreinforce", this.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    /* loaded from: classes8.dex */
    public static class a {
        private String E;
        private long q;

        /* renamed from: a  reason: collision with root package name */
        private String f4010a = "";
        private String b = "";
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
            this.f4010a = Xj(str);
        }

        public void f(String str) {
            this.b = Xj(str);
        }

        public String a() {
            return this.c;
        }

        public void g(String str) {
            this.c = Xj(str);
        }

        public void h(String str) {
            this.d = Xj(str);
        }

        public void i(String str) {
            this.e = Xj(str);
        }

        public void j(String str) {
            this.f = Xj(str);
        }

        public void k(String str) {
            this.g = Xj(str);
        }

        public void l(String str) {
            this.h = Xj(str);
        }

        public void m(String str) {
            this.i = Xj(str);
        }

        public void n(String str) {
            String Xj = Xj(str);
            try {
                this.j = URLEncoder.encode(Xj, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                this.j = Xj;
            }
        }

        public void o(String str) {
            String Xj = Xj(str);
            try {
                this.k = URLEncoder.encode(Xj, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                this.k = Xj;
            }
        }

        public void p(String str) {
            this.l = Xj(str);
        }

        public void q(String str) {
            this.m = Xj(str);
        }

        public void r(String str) {
            this.o = Xj(str);
        }

        public void s(String str) {
            this.p = Xj(str);
        }

        public void t(String str) {
            this.A = Xj(str);
        }

        public void u(String str) {
            this.B = Xj(str);
        }

        public void v(String str) {
            this.E = Xj(str);
        }

        public String Xi(String str) {
            return com.cmic.sso.sdk.e.d.a(this.b + this.c + this.d + this.e + this.f + this.g + this.h + this.i + this.j + this.k + this.l + this.m + this.o + this.p + str + this.r + this.s + this.t + this.u + this.v + this.w + this.x + this.y + this.z + this.A + this.B + this.C + this.D);
        }

        public String toString() {
            return this.f4010a + ETAG.ITEM_SEPARATOR + this.b + ETAG.ITEM_SEPARATOR + this.c + ETAG.ITEM_SEPARATOR + this.d + ETAG.ITEM_SEPARATOR + this.e + ETAG.ITEM_SEPARATOR + this.f + ETAG.ITEM_SEPARATOR + this.g + ETAG.ITEM_SEPARATOR + this.h + ETAG.ITEM_SEPARATOR + this.i + ETAG.ITEM_SEPARATOR + this.j + ETAG.ITEM_SEPARATOR + this.k + ETAG.ITEM_SEPARATOR + this.l + ETAG.ITEM_SEPARATOR + this.m + ETAG.ITEM_SEPARATOR + "6.0" + ETAG.ITEM_SEPARATOR + this.n + ETAG.ITEM_SEPARATOR + this.o + ETAG.ITEM_SEPARATOR + this.p + ETAG.ITEM_SEPARATOR + this.r + ETAG.ITEM_SEPARATOR + this.s + ETAG.ITEM_SEPARATOR + this.t + ETAG.ITEM_SEPARATOR + this.u + ETAG.ITEM_SEPARATOR + this.v + ETAG.ITEM_SEPARATOR + this.w + ETAG.ITEM_SEPARATOR + this.x + ETAG.ITEM_SEPARATOR + this.y + ETAG.ITEM_SEPARATOR + this.z + ETAG.ITEM_SEPARATOR + this.A + ETAG.ITEM_SEPARATOR + this.B + ETAG.ITEM_SEPARATOR + this.E + "&&" + this.C + ETAG.ITEM_SEPARATOR + this.D;
        }

        private String Xj(String str) {
            return str == null ? "" : str;
        }
    }
}
