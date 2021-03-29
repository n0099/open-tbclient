package com.cmic.sso.sdk.b.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30599a;

    /* renamed from: b  reason: collision with root package name */
    public String f30600b;

    /* renamed from: c  reason: collision with root package name */
    public String f30601c;

    /* renamed from: d  reason: collision with root package name */
    public String f30602d;

    /* renamed from: e  reason: collision with root package name */
    public String f30603e;

    /* renamed from: f  reason: collision with root package name */
    public String f30604f;

    /* renamed from: g  reason: collision with root package name */
    public String f30605g;

    /* renamed from: h  reason: collision with root package name */
    public String f30606h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;
    public JSONObject n;

    /* renamed from: com.cmic.sso.sdk.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0343a {

        /* renamed from: a  reason: collision with root package name */
        public String f30607a;

        /* renamed from: b  reason: collision with root package name */
        public String f30608b;

        /* renamed from: c  reason: collision with root package name */
        public String f30609c;

        /* renamed from: d  reason: collision with root package name */
        public String f30610d;

        /* renamed from: e  reason: collision with root package name */
        public String f30611e;

        /* renamed from: f  reason: collision with root package name */
        public String f30612f;

        /* renamed from: g  reason: collision with root package name */
        public String f30613g;

        /* renamed from: h  reason: collision with root package name */
        public String f30614h;
        public String i;
        public String j;
        public String k;

        public void a(String str) {
            this.f30607a = str;
        }

        public void b(String str) {
            this.f30608b = str;
        }

        public void c(String str) {
            this.f30609c = str;
        }

        public void d(String str) {
            this.f30610d = str;
        }

        public void e(String str) {
            this.f30611e = str;
        }

        public void f(String str) {
            this.f30612f = str;
        }

        public void g(String str) {
            this.f30613g = str;
        }

        public void h(String str) {
            this.f30614h = str;
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
                jSONObject.put("phone_id", this.f30607a);
                jSONObject.put(IXAdRequestInfo.OS, this.f30608b);
                jSONObject.put("dev_model", this.f30609c);
                jSONObject.put("dev_brand", this.f30610d);
                jSONObject.put("mnc", this.f30611e);
                jSONObject.put("client_type", this.f30612f);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_NETWORK, this.f30613g);
                jSONObject.put("ipv4_list", this.f30614h);
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
        this.f30604f = str;
    }

    public void e(String str) {
        this.f30605g = str;
    }

    public void f(String str) {
        this.f30599a = str;
    }

    public void g(String str) {
        this.f30600b = str;
    }

    public void h(String str) {
        this.f30601c = str;
    }

    public void i(String str) {
        this.f30602d = str;
    }

    public void j(String str) {
        this.f30603e = str;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public String m(String str) {
        return n(this.f30599a + this.f30601c + str + this.f30602d);
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
            jSONObject.put("version", this.f30599a);
            jSONObject.put("msgid", this.f30600b);
            jSONObject.put("appid", this.f30601c);
            jSONObject.put("scrip", this.f30602d);
            jSONObject.put("sign", this.f30603e);
            jSONObject.put("interfacever", this.f30604f);
            jSONObject.put("userCapaid", this.f30605g);
            jSONObject.put("clienttype", this.f30606h);
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
        this.f30606h = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30601c;
    }
}
