package com.cmic.sso.sdk.b.b;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    public String f30478a;

    /* renamed from: b  reason: collision with root package name */
    public String f30479b;

    /* renamed from: c  reason: collision with root package name */
    public String f30480c;

    /* renamed from: d  reason: collision with root package name */
    public String f30481d;

    /* renamed from: e  reason: collision with root package name */
    public String f30482e;

    /* renamed from: f  reason: collision with root package name */
    public String f30483f;

    /* renamed from: g  reason: collision with root package name */
    public String f30484g;

    /* renamed from: h  reason: collision with root package name */
    public String f30485h;

    /* renamed from: i  reason: collision with root package name */
    public String f30486i;
    public String j;
    public String k;
    public long l;
    public String m;
    public JSONObject n;

    /* renamed from: com.cmic.sso.sdk.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0328a {

        /* renamed from: a  reason: collision with root package name */
        public String f30487a;

        /* renamed from: b  reason: collision with root package name */
        public String f30488b;

        /* renamed from: c  reason: collision with root package name */
        public String f30489c;

        /* renamed from: d  reason: collision with root package name */
        public String f30490d;

        /* renamed from: e  reason: collision with root package name */
        public String f30491e;

        /* renamed from: f  reason: collision with root package name */
        public String f30492f;

        /* renamed from: g  reason: collision with root package name */
        public String f30493g;

        /* renamed from: h  reason: collision with root package name */
        public String f30494h;

        /* renamed from: i  reason: collision with root package name */
        public String f30495i;
        public String j;
        public String k;

        public void a(String str) {
            this.f30487a = str;
        }

        public void b(String str) {
            this.f30488b = str;
        }

        public void c(String str) {
            this.f30489c = str;
        }

        public void d(String str) {
            this.f30490d = str;
        }

        public void e(String str) {
            this.f30491e = str;
        }

        public void f(String str) {
            this.f30492f = str;
        }

        public void g(String str) {
            this.f30493g = str;
        }

        public void h(String str) {
            this.f30494h = str;
        }

        public void i(String str) {
            this.f30495i = str;
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
                jSONObject.put("phone_id", this.f30487a);
                jSONObject.put(IAdRequestParam.OS, this.f30488b);
                jSONObject.put("dev_model", this.f30489c);
                jSONObject.put("dev_brand", this.f30490d);
                jSONObject.put("mnc", this.f30491e);
                jSONObject.put("client_type", this.f30492f);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_NETWORK, this.f30493g);
                jSONObject.put("ipv4_list", this.f30494h);
                jSONObject.put("ipv6_list", this.f30495i);
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
        this.f30486i = str;
    }

    public void c(String str) {
        this.m = str;
    }

    public void d(String str) {
        this.f30483f = str;
    }

    public void e(String str) {
        this.f30484g = str;
    }

    public void f(String str) {
        this.f30478a = str;
    }

    public void g(String str) {
        this.f30479b = str;
    }

    public void h(String str) {
        this.f30480c = str;
    }

    public void i(String str) {
        this.f30481d = str;
    }

    public void j(String str) {
        this.f30482e = str;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public String m(String str) {
        return n(this.f30478a + this.f30480c + str + this.f30481d);
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
            jSONObject.put("version", this.f30478a);
            jSONObject.put("msgid", this.f30479b);
            jSONObject.put("appid", this.f30480c);
            jSONObject.put("scrip", this.f30481d);
            jSONObject.put("sign", this.f30482e);
            jSONObject.put("interfacever", this.f30483f);
            jSONObject.put("userCapaid", this.f30484g);
            jSONObject.put("clienttype", this.f30485h);
            jSONObject.put("sourceid", this.f30486i);
            jSONObject.put("authenticated_appid", this.j);
            jSONObject.put("genTokenByAppid", this.k);
            jSONObject.put("rcData", this.n);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f30485h = str;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30480c;
    }
}
