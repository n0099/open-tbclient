package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f30522a;

    /* renamed from: b  reason: collision with root package name */
    public a f30523b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f30524a;

        public JSONObject a() {
            return this.f30524a;
        }

        public void a(JSONObject jSONObject) {
            this.f30524a = jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f30525a;

        /* renamed from: b  reason: collision with root package name */
        public String f30526b;

        /* renamed from: c  reason: collision with root package name */
        public String f30527c;

        /* renamed from: d  reason: collision with root package name */
        public String f30528d;

        /* renamed from: e  reason: collision with root package name */
        public String f30529e;

        public String b() {
            return this.f30528d;
        }

        public String c() {
            return this.f30525a;
        }

        public String d() {
            return this.f30526b;
        }

        public String e() {
            return this.f30527c;
        }

        public String f() {
            return com.cmic.sso.sdk.d.d.a(this.f30529e + this.f30528d + this.f30527c + this.f30526b + "@Fdiwmxy7CBDDQNUI");
        }

        public String a() {
            return this.f30529e;
        }

        public void b(String str) {
            this.f30528d = str;
        }

        public void c(String str) {
            this.f30525a = str;
        }

        public void d(String str) {
            this.f30526b = str;
        }

        public void e(String str) {
            this.f30527c = str;
        }

        public void a(String str) {
            this.f30529e = str;
        }
    }

    public void a(b bVar) {
        this.f30522a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f30522a.c());
            jSONObject2.put("msgid", this.f30522a.d());
            jSONObject2.put("systemtime", this.f30522a.e());
            jSONObject2.put("appid", this.f30522a.b());
            jSONObject2.put("version", this.f30522a.a());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f30523b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f30523b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30522a.f30528d;
    }
}
