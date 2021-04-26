package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f31348a;

    /* renamed from: b  reason: collision with root package name */
    public a f31349b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f31350a;

        public JSONObject a() {
            return this.f31350a;
        }

        public void a(JSONObject jSONObject) {
            this.f31350a = jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f31351a;

        /* renamed from: b  reason: collision with root package name */
        public String f31352b;

        /* renamed from: c  reason: collision with root package name */
        public String f31353c;

        /* renamed from: d  reason: collision with root package name */
        public String f31354d;

        /* renamed from: e  reason: collision with root package name */
        public String f31355e;

        public String b() {
            return this.f31354d;
        }

        public String c() {
            return this.f31351a;
        }

        public String d() {
            return this.f31352b;
        }

        public String e() {
            return this.f31353c;
        }

        public String f() {
            return com.cmic.sso.sdk.d.d.a(this.f31355e + this.f31354d + this.f31353c + this.f31352b + "@Fdiwmxy7CBDDQNUI");
        }

        public String a() {
            return this.f31355e;
        }

        public void b(String str) {
            this.f31354d = str;
        }

        public void c(String str) {
            this.f31351a = str;
        }

        public void d(String str) {
            this.f31352b = str;
        }

        public void e(String str) {
            this.f31353c = str;
        }

        public void a(String str) {
            this.f31355e = str;
        }
    }

    public void a(b bVar) {
        this.f31348a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f31348a.c());
            jSONObject2.put("msgid", this.f31348a.d());
            jSONObject2.put("systemtime", this.f31348a.e());
            jSONObject2.put("appid", this.f31348a.b());
            jSONObject2.put("version", this.f31348a.a());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f31349b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f31349b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f31348a.f31354d;
    }
}
