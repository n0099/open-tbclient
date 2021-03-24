package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f30639a;

    /* renamed from: b  reason: collision with root package name */
    public a f30640b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f30641a;

        public JSONObject a() {
            return this.f30641a;
        }

        public void a(JSONObject jSONObject) {
            this.f30641a = jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f30642a;

        /* renamed from: b  reason: collision with root package name */
        public String f30643b;

        /* renamed from: c  reason: collision with root package name */
        public String f30644c;

        /* renamed from: d  reason: collision with root package name */
        public String f30645d;

        /* renamed from: e  reason: collision with root package name */
        public String f30646e;

        public String b() {
            return this.f30645d;
        }

        public String c() {
            return this.f30642a;
        }

        public String d() {
            return this.f30643b;
        }

        public String e() {
            return this.f30644c;
        }

        public String f() {
            return com.cmic.sso.sdk.d.d.a(this.f30646e + this.f30645d + this.f30644c + this.f30643b + "@Fdiwmxy7CBDDQNUI");
        }

        public String a() {
            return this.f30646e;
        }

        public void b(String str) {
            this.f30645d = str;
        }

        public void c(String str) {
            this.f30642a = str;
        }

        public void d(String str) {
            this.f30643b = str;
        }

        public void e(String str) {
            this.f30644c = str;
        }

        public void a(String str) {
            this.f30646e = str;
        }
    }

    public void a(b bVar) {
        this.f30639a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f30639a.c());
            jSONObject2.put("msgid", this.f30639a.d());
            jSONObject2.put("systemtime", this.f30639a.e());
            jSONObject2.put("appid", this.f30639a.b());
            jSONObject2.put("version", this.f30639a.a());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f30640b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f30640b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30639a.f30645d;
    }
}
