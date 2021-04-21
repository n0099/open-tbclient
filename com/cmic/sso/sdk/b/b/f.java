package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f30420a;

    /* renamed from: b  reason: collision with root package name */
    public a f30421b;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f30422a;

        public JSONObject a() {
            return this.f30422a;
        }

        public void a(JSONObject jSONObject) {
            this.f30422a = jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f30423a;

        /* renamed from: b  reason: collision with root package name */
        public String f30424b;

        /* renamed from: c  reason: collision with root package name */
        public String f30425c;

        /* renamed from: d  reason: collision with root package name */
        public String f30426d;

        /* renamed from: e  reason: collision with root package name */
        public String f30427e;

        public String b() {
            return this.f30426d;
        }

        public String c() {
            return this.f30423a;
        }

        public String d() {
            return this.f30424b;
        }

        public String e() {
            return this.f30425c;
        }

        public String f() {
            return com.cmic.sso.sdk.d.d.a(this.f30427e + this.f30426d + this.f30425c + this.f30424b + "@Fdiwmxy7CBDDQNUI");
        }

        public String a() {
            return this.f30427e;
        }

        public void b(String str) {
            this.f30426d = str;
        }

        public void c(String str) {
            this.f30423a = str;
        }

        public void d(String str) {
            this.f30424b = str;
        }

        public void e(String str) {
            this.f30425c = str;
        }

        public void a(String str) {
            this.f30427e = str;
        }
    }

    public void a(b bVar) {
        this.f30420a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f30420a.c());
            jSONObject2.put("msgid", this.f30420a.d());
            jSONObject2.put("systemtime", this.f30420a.e());
            jSONObject2.put("appid", this.f30420a.b());
            jSONObject2.put("version", this.f30420a.a());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f30421b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f30421b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30420a.f30426d;
    }
}
