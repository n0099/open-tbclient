package com.cmic.sso.sdk.c.b;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.ugc.model.UgcConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends g {
    private String a;
    private String b;
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
    private JSONObject niC;

    public void a(JSONObject jSONObject) {
        this.niC = jSONObject;
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
        this.a = str;
    }

    public void g(String str) {
        this.b = str;
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
            jSONObject.put("version", this.a);
            jSONObject.put("msgid", this.b);
            jSONObject.put("appid", this.c);
            jSONObject.put("scrip", this.d);
            jSONObject.put("sign", this.e);
            jSONObject.put("interfacever", this.f);
            jSONObject.put("userCapaid", this.g);
            jSONObject.put("clienttype", this.h);
            jSONObject.put(UgcConstant.SOURCE_ID, this.i);
            jSONObject.put("authenticated_appid", this.j);
            jSONObject.put("genTokenByAppid", this.k);
            jSONObject.put("rcData", this.niC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String Ue(String str) {
        return dF(this.a + this.c + str + this.d);
    }

    /* renamed from: com.cmic.sso.sdk.c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0859a {
        private String a;
        private String b;
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
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
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
                jSONObject.put("phone_id", this.a);
                jSONObject.put("os", this.b);
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
