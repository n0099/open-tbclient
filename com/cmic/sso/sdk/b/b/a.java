package com.cmic.sso.sdk.b.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30549a;

    /* renamed from: b  reason: collision with root package name */
    public String f30550b;

    /* renamed from: c  reason: collision with root package name */
    public String f30551c;

    /* renamed from: d  reason: collision with root package name */
    public String f30552d;

    /* renamed from: e  reason: collision with root package name */
    public String f30553e;

    /* renamed from: f  reason: collision with root package name */
    public String f30554f;

    /* renamed from: g  reason: collision with root package name */
    public String f30555g;

    /* renamed from: h  reason: collision with root package name */
    public String f30556h;

    /* renamed from: i  reason: collision with root package name */
    public String f30557i;
    public String j;
    public String k;
    public long l;
    public String m;
    public JSONObject n;

    /* renamed from: com.cmic.sso.sdk.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0327a {

        /* renamed from: a  reason: collision with root package name */
        public String f30558a;

        /* renamed from: b  reason: collision with root package name */
        public String f30559b;

        /* renamed from: c  reason: collision with root package name */
        public String f30560c;

        /* renamed from: d  reason: collision with root package name */
        public String f30561d;

        /* renamed from: e  reason: collision with root package name */
        public String f30562e;

        /* renamed from: f  reason: collision with root package name */
        public String f30563f;

        /* renamed from: g  reason: collision with root package name */
        public String f30564g;

        /* renamed from: h  reason: collision with root package name */
        public String f30565h;

        /* renamed from: i  reason: collision with root package name */
        public String f30566i;
        public String j;
        public String k;

        public void a(String str) {
            this.f30558a = str;
        }

        public void b(String str) {
            this.f30559b = str;
        }

        public void c(String str) {
            this.f30560c = str;
        }

        public void d(String str) {
            this.f30561d = str;
        }

        public void e(String str) {
            this.f30562e = str;
        }

        public void f(String str) {
            this.f30563f = str;
        }

        public void g(String str) {
            this.f30564g = str;
        }

        public void h(String str) {
            this.f30565h = str;
        }

        public void i(String str) {
            this.f30566i = str;
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
                jSONObject.put("phone_id", this.f30558a);
                jSONObject.put(IAdRequestParam.OS, this.f30559b);
                jSONObject.put("dev_model", this.f30560c);
                jSONObject.put("dev_brand", this.f30561d);
                jSONObject.put("mnc", this.f30562e);
                jSONObject.put("client_type", this.f30563f);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_NETWORK, this.f30564g);
                jSONObject.put("ipv4_list", this.f30565h);
                jSONObject.put("ipv6_list", this.f30566i);
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
        this.f30557i = str;
    }

    public void c(String str) {
        this.m = str;
    }

    public void d(String str) {
        this.f30554f = str;
    }

    public void e(String str) {
        this.f30555g = str;
    }

    public void f(String str) {
        this.f30549a = str;
    }

    public void g(String str) {
        this.f30550b = str;
    }

    public void h(String str) {
        this.f30551c = str;
    }

    public void i(String str) {
        this.f30552d = str;
    }

    public void j(String str) {
        this.f30553e = str;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public String m(String str) {
        return n(this.f30549a + this.f30551c + str + this.f30552d);
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
            jSONObject.put("version", this.f30549a);
            jSONObject.put("msgid", this.f30550b);
            jSONObject.put("appid", this.f30551c);
            jSONObject.put("scrip", this.f30552d);
            jSONObject.put("sign", this.f30553e);
            jSONObject.put("interfacever", this.f30554f);
            jSONObject.put("userCapaid", this.f30555g);
            jSONObject.put("clienttype", this.f30556h);
            jSONObject.put("sourceid", this.f30557i);
            jSONObject.put("authenticated_appid", this.j);
            jSONObject.put("genTokenByAppid", this.k);
            jSONObject.put("rcData", this.n);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f30556h = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30551c;
    }
}
