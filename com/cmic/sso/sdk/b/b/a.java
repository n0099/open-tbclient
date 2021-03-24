package com.cmic.sso.sdk.b.b;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30598a;

    /* renamed from: b  reason: collision with root package name */
    public String f30599b;

    /* renamed from: c  reason: collision with root package name */
    public String f30600c;

    /* renamed from: d  reason: collision with root package name */
    public String f30601d;

    /* renamed from: e  reason: collision with root package name */
    public String f30602e;

    /* renamed from: f  reason: collision with root package name */
    public String f30603f;

    /* renamed from: g  reason: collision with root package name */
    public String f30604g;

    /* renamed from: h  reason: collision with root package name */
    public String f30605h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;
    public JSONObject n;

    /* renamed from: com.cmic.sso.sdk.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0342a {

        /* renamed from: a  reason: collision with root package name */
        public String f30606a;

        /* renamed from: b  reason: collision with root package name */
        public String f30607b;

        /* renamed from: c  reason: collision with root package name */
        public String f30608c;

        /* renamed from: d  reason: collision with root package name */
        public String f30609d;

        /* renamed from: e  reason: collision with root package name */
        public String f30610e;

        /* renamed from: f  reason: collision with root package name */
        public String f30611f;

        /* renamed from: g  reason: collision with root package name */
        public String f30612g;

        /* renamed from: h  reason: collision with root package name */
        public String f30613h;
        public String i;
        public String j;
        public String k;

        public void a(String str) {
            this.f30606a = str;
        }

        public void b(String str) {
            this.f30607b = str;
        }

        public void c(String str) {
            this.f30608c = str;
        }

        public void d(String str) {
            this.f30609d = str;
        }

        public void e(String str) {
            this.f30610e = str;
        }

        public void f(String str) {
            this.f30611f = str;
        }

        public void g(String str) {
            this.f30612g = str;
        }

        public void h(String str) {
            this.f30613h = str;
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
                jSONObject.put("phone_id", this.f30606a);
                jSONObject.put(IXAdRequestInfo.OS, this.f30607b);
                jSONObject.put("dev_model", this.f30608c);
                jSONObject.put("dev_brand", this.f30609d);
                jSONObject.put("mnc", this.f30610e);
                jSONObject.put("client_type", this.f30611f);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_NETWORK, this.f30612g);
                jSONObject.put("ipv4_list", this.f30613h);
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
        this.f30603f = str;
    }

    public void e(String str) {
        this.f30604g = str;
    }

    public void f(String str) {
        this.f30598a = str;
    }

    public void g(String str) {
        this.f30599b = str;
    }

    public void h(String str) {
        this.f30600c = str;
    }

    public void i(String str) {
        this.f30601d = str;
    }

    public void j(String str) {
        this.f30602e = str;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public String m(String str) {
        return n(this.f30598a + this.f30600c + str + this.f30601d);
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
            jSONObject.put("version", this.f30598a);
            jSONObject.put("msgid", this.f30599b);
            jSONObject.put("appid", this.f30600c);
            jSONObject.put("scrip", this.f30601d);
            jSONObject.put("sign", this.f30602e);
            jSONObject.put("interfacever", this.f30603f);
            jSONObject.put("userCapaid", this.f30604g);
            jSONObject.put("clienttype", this.f30605h);
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
        this.f30605h = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30600c;
    }
}
