package com.cmic.sso.sdk.b.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f31304a;

    /* renamed from: b  reason: collision with root package name */
    public String f31305b;

    /* renamed from: c  reason: collision with root package name */
    public String f31306c;

    /* renamed from: d  reason: collision with root package name */
    public String f31307d;

    /* renamed from: e  reason: collision with root package name */
    public String f31308e;

    /* renamed from: f  reason: collision with root package name */
    public String f31309f;

    /* renamed from: g  reason: collision with root package name */
    public String f31310g;

    /* renamed from: h  reason: collision with root package name */
    public String f31311h;

    /* renamed from: i  reason: collision with root package name */
    public String f31312i;
    public String j;
    public String k;
    public long l;
    public String m;
    public JSONObject n;

    /* renamed from: com.cmic.sso.sdk.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0340a {

        /* renamed from: a  reason: collision with root package name */
        public String f31313a;

        /* renamed from: b  reason: collision with root package name */
        public String f31314b;

        /* renamed from: c  reason: collision with root package name */
        public String f31315c;

        /* renamed from: d  reason: collision with root package name */
        public String f31316d;

        /* renamed from: e  reason: collision with root package name */
        public String f31317e;

        /* renamed from: f  reason: collision with root package name */
        public String f31318f;

        /* renamed from: g  reason: collision with root package name */
        public String f31319g;

        /* renamed from: h  reason: collision with root package name */
        public String f31320h;

        /* renamed from: i  reason: collision with root package name */
        public String f31321i;
        public String j;
        public String k;

        public void a(String str) {
            this.f31313a = str;
        }

        public void b(String str) {
            this.f31314b = str;
        }

        public void c(String str) {
            this.f31315c = str;
        }

        public void d(String str) {
            this.f31316d = str;
        }

        public void e(String str) {
            this.f31317e = str;
        }

        public void f(String str) {
            this.f31318f = str;
        }

        public void g(String str) {
            this.f31319g = str;
        }

        public void h(String str) {
            this.f31320h = str;
        }

        public void i(String str) {
            this.f31321i = str;
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
                jSONObject.put("phone_id", this.f31313a);
                jSONObject.put(IAdRequestParam.OS, this.f31314b);
                jSONObject.put("dev_model", this.f31315c);
                jSONObject.put("dev_brand", this.f31316d);
                jSONObject.put("mnc", this.f31317e);
                jSONObject.put("client_type", this.f31318f);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_NETWORK, this.f31319g);
                jSONObject.put("ipv4_list", this.f31320h);
                jSONObject.put("ipv6_list", this.f31321i);
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
        this.f31312i = str;
    }

    public void c(String str) {
        this.m = str;
    }

    public void d(String str) {
        this.f31309f = str;
    }

    public void e(String str) {
        this.f31310g = str;
    }

    public void f(String str) {
        this.f31304a = str;
    }

    public void g(String str) {
        this.f31305b = str;
    }

    public void h(String str) {
        this.f31306c = str;
    }

    public void i(String str) {
        this.f31307d = str;
    }

    public void j(String str) {
        this.f31308e = str;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public String m(String str) {
        return n(this.f31304a + this.f31306c + str + this.f31307d);
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
            jSONObject.put("version", this.f31304a);
            jSONObject.put("msgid", this.f31305b);
            jSONObject.put("appid", this.f31306c);
            jSONObject.put("scrip", this.f31307d);
            jSONObject.put("sign", this.f31308e);
            jSONObject.put("interfacever", this.f31309f);
            jSONObject.put("userCapaid", this.f31310g);
            jSONObject.put("clienttype", this.f31311h);
            jSONObject.put("sourceid", this.f31312i);
            jSONObject.put("authenticated_appid", this.j);
            jSONObject.put("genTokenByAppid", this.k);
            jSONObject.put("rcData", this.n);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f31311h = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f31306c;
    }
}
