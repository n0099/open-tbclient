package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f30616a;

    /* renamed from: b  reason: collision with root package name */
    public a f30617b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f30618a;

        public JSONObject a() {
            return this.f30618a;
        }

        public void a(JSONObject jSONObject) {
            this.f30618a = jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        public String f30619a;

        /* renamed from: b  reason: collision with root package name */
        public String f30620b;

        /* renamed from: c  reason: collision with root package name */
        public String f30621c;

        /* renamed from: d  reason: collision with root package name */
        public String f30622d;

        /* renamed from: e  reason: collision with root package name */
        public String f30623e;

        @Override // com.cmic.sso.sdk.b.b.g
        public JSONObject b() {
            return null;
        }

        public void b(String str) {
            this.f30623e = str;
        }

        public String c() {
            return this.f30623e;
        }

        public String d() {
            return this.f30619a;
        }

        public String e() {
            return this.f30620b;
        }

        public String f() {
            return this.f30621c;
        }

        @Override // com.cmic.sso.sdk.b.b.g
        public String a() {
            return this.f30622d;
        }

        public void c(String str) {
            this.f30622d = str;
        }

        public void d(String str) {
            this.f30619a = str;
        }

        public void e(String str) {
            this.f30620b = str;
        }

        public void f(String str) {
            this.f30621c = str;
        }

        @Override // com.cmic.sso.sdk.b.b.g
        public String a(String str) {
            return this.f30623e + this.f30622d + this.f30621c + this.f30620b + "@Fdiwmxy7CBDDQNUI";
        }
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return null;
    }

    public void a(b bVar) {
        this.f30616a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f30616a.d());
            jSONObject2.put("msgid", this.f30616a.e());
            jSONObject2.put("systemtime", this.f30616a.f());
            jSONObject2.put("appid", this.f30616a.a());
            jSONObject2.put("version", this.f30616a.c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f30617b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f30617b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30616a.f30622d;
    }
}
