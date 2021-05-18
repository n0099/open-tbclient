package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f30593a;

    /* renamed from: b  reason: collision with root package name */
    public a f30594b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f30595a;

        public JSONObject a() {
            return this.f30595a;
        }

        public void a(JSONObject jSONObject) {
            this.f30595a = jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f30596a;

        /* renamed from: b  reason: collision with root package name */
        public String f30597b;

        /* renamed from: c  reason: collision with root package name */
        public String f30598c;

        /* renamed from: d  reason: collision with root package name */
        public String f30599d;

        /* renamed from: e  reason: collision with root package name */
        public String f30600e;

        public String b() {
            return this.f30599d;
        }

        public String c() {
            return this.f30596a;
        }

        public String d() {
            return this.f30597b;
        }

        public String e() {
            return this.f30598c;
        }

        public String f() {
            return com.cmic.sso.sdk.d.d.a(this.f30600e + this.f30599d + this.f30598c + this.f30597b + "@Fdiwmxy7CBDDQNUI");
        }

        public String a() {
            return this.f30600e;
        }

        public void b(String str) {
            this.f30599d = str;
        }

        public void c(String str) {
            this.f30596a = str;
        }

        public void d(String str) {
            this.f30597b = str;
        }

        public void e(String str) {
            this.f30598c = str;
        }

        public void a(String str) {
            this.f30600e = str;
        }
    }

    public void a(b bVar) {
        this.f30593a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f30593a.c());
            jSONObject2.put("msgid", this.f30593a.d());
            jSONObject2.put("systemtime", this.f30593a.e());
            jSONObject2.put("appid", this.f30593a.b());
            jSONObject2.put("version", this.f30593a.a());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f30594b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f30594b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30593a.f30599d;
    }
}
