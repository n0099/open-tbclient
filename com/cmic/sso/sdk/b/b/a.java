package com.cmic.sso.sdk.b.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30379a;

    /* renamed from: b  reason: collision with root package name */
    public String f30380b;

    /* renamed from: c  reason: collision with root package name */
    public String f30381c;

    /* renamed from: d  reason: collision with root package name */
    public String f30382d;

    /* renamed from: e  reason: collision with root package name */
    public String f30383e;

    /* renamed from: f  reason: collision with root package name */
    public String f30384f;

    /* renamed from: g  reason: collision with root package name */
    public String f30385g;

    /* renamed from: h  reason: collision with root package name */
    public String f30386h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;
    public JSONObject n;

    /* renamed from: com.cmic.sso.sdk.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0347a {

        /* renamed from: a  reason: collision with root package name */
        public String f30387a;

        /* renamed from: b  reason: collision with root package name */
        public String f30388b;

        /* renamed from: c  reason: collision with root package name */
        public String f30389c;

        /* renamed from: d  reason: collision with root package name */
        public String f30390d;

        /* renamed from: e  reason: collision with root package name */
        public String f30391e;

        /* renamed from: f  reason: collision with root package name */
        public String f30392f;

        /* renamed from: g  reason: collision with root package name */
        public String f30393g;

        /* renamed from: h  reason: collision with root package name */
        public String f30394h;
        public String i;
        public String j;
        public String k;

        public void a(String str) {
            this.f30387a = str;
        }

        public void b(String str) {
            this.f30388b = str;
        }

        public void c(String str) {
            this.f30389c = str;
        }

        public void d(String str) {
            this.f30390d = str;
        }

        public void e(String str) {
            this.f30391e = str;
        }

        public void f(String str) {
            this.f30392f = str;
        }

        public void g(String str) {
            this.f30393g = str;
        }

        public void h(String str) {
            this.f30394h = str;
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
                jSONObject.put("phone_id", this.f30387a);
                jSONObject.put(IAdRequestParam.OS, this.f30388b);
                jSONObject.put("dev_model", this.f30389c);
                jSONObject.put("dev_brand", this.f30390d);
                jSONObject.put("mnc", this.f30391e);
                jSONObject.put("client_type", this.f30392f);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_NETWORK, this.f30393g);
                jSONObject.put("ipv4_list", this.f30394h);
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
        this.f30384f = str;
    }

    public void e(String str) {
        this.f30385g = str;
    }

    public void f(String str) {
        this.f30379a = str;
    }

    public void g(String str) {
        this.f30380b = str;
    }

    public void h(String str) {
        this.f30381c = str;
    }

    public void i(String str) {
        this.f30382d = str;
    }

    public void j(String str) {
        this.f30383e = str;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public String m(String str) {
        return n(this.f30379a + this.f30381c + str + this.f30382d);
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
            jSONObject.put("version", this.f30379a);
            jSONObject.put("msgid", this.f30380b);
            jSONObject.put("appid", this.f30381c);
            jSONObject.put("scrip", this.f30382d);
            jSONObject.put("sign", this.f30383e);
            jSONObject.put("interfacever", this.f30384f);
            jSONObject.put("userCapaid", this.f30385g);
            jSONObject.put("clienttype", this.f30386h);
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
        this.f30386h = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30381c;
    }
}
