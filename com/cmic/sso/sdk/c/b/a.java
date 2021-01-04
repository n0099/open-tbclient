package com.cmic.sso.sdk.c.b;

import com.baidu.ar.constants.HttpConstants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    private String f7997a;

    /* renamed from: b  reason: collision with root package name */
    private String f7998b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private long l;
    private String m;
    private JSONObject prb;

    public void a(JSONObject jSONObject) {
        this.prb = jSONObject;
    }

    public void a(long j) {
        this.l = j;
    }

    public void a(String str) {
        this.h = str;
    }

    public void b(String str) {
        this.i = str;
    }

    public void c(String str) {
        this.m = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(String str) {
        this.g = str;
    }

    public void f(String str) {
        this.f7997a = str;
    }

    public void g(String str) {
        this.f7998b = str;
    }

    public void h(String str) {
        this.c = str;
    }

    public void i(String str) {
        this.d = str;
    }

    public void j(String str) {
        this.e = str;
    }

    public String toString() {
        return b().toString();
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.c;
    }

    public void k(String str) {
        this.j = str;
    }

    public void l(String str) {
        this.k = str;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.f7997a);
            jSONObject.put("msgid", this.f7998b);
            jSONObject.put("appid", this.c);
            jSONObject.put("scrip", this.d);
            jSONObject.put("sign", this.e);
            jSONObject.put("interfacever", this.f);
            jSONObject.put("userCapaid", this.g);
            jSONObject.put("clienttype", this.h);
            jSONObject.put("sourceid", this.i);
            jSONObject.put("authenticated_appid", this.j);
            jSONObject.put("genTokenByAppid", this.k);
            jSONObject.put("rcData", this.prb);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String Zc(String str) {
        return dI(this.f7997a + this.c + str + this.d);
    }

    /* renamed from: com.cmic.sso.sdk.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1014a {

        /* renamed from: a  reason: collision with root package name */
        private String f7999a;

        /* renamed from: b  reason: collision with root package name */
        private String f8000b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;

        public void a(String str) {
            this.f7999a = str;
        }

        public void b(String str) {
            this.f8000b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public void e(String str) {
            this.e = str;
        }

        public void f(String str) {
            this.f = str;
        }

        public void g(String str) {
            this.g = str;
        }

        public void h(String str) {
            this.h = str;
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
                jSONObject.put("phone_id", this.f7999a);
                jSONObject.put("os", this.f8000b);
                jSONObject.put("dev_model", this.c);
                jSONObject.put("dev_brand", this.d);
                jSONObject.put("mnc", this.e);
                jSONObject.put("client_type", this.f);
                jSONObject.put(HttpConstants.NETWORK_TYPE, this.g);
                jSONObject.put("ipv4_list", this.h);
                jSONObject.put("ipv6_list", this.i);
                jSONObject.put("is_cert", this.j);
                jSONObject.put("is_root", this.k);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
