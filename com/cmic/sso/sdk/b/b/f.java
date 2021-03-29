package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f30640a;

    /* renamed from: b  reason: collision with root package name */
    public a f30641b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f30642a;

        public JSONObject a() {
            return this.f30642a;
        }

        public void a(JSONObject jSONObject) {
            this.f30642a = jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f30643a;

        /* renamed from: b  reason: collision with root package name */
        public String f30644b;

        /* renamed from: c  reason: collision with root package name */
        public String f30645c;

        /* renamed from: d  reason: collision with root package name */
        public String f30646d;

        /* renamed from: e  reason: collision with root package name */
        public String f30647e;

        public String b() {
            return this.f30646d;
        }

        public String c() {
            return this.f30643a;
        }

        public String d() {
            return this.f30644b;
        }

        public String e() {
            return this.f30645c;
        }

        public String f() {
            return com.cmic.sso.sdk.d.d.a(this.f30647e + this.f30646d + this.f30645c + this.f30644b + "@Fdiwmxy7CBDDQNUI");
        }

        public String a() {
            return this.f30647e;
        }

        public void b(String str) {
            this.f30646d = str;
        }

        public void c(String str) {
            this.f30643a = str;
        }

        public void d(String str) {
            this.f30644b = str;
        }

        public void e(String str) {
            this.f30645c = str;
        }

        public void a(String str) {
            this.f30647e = str;
        }
    }

    public void a(b bVar) {
        this.f30640a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f30640a.c());
            jSONObject2.put("msgid", this.f30640a.d());
            jSONObject2.put("systemtime", this.f30640a.e());
            jSONObject2.put("appid", this.f30640a.b());
            jSONObject2.put("version", this.f30640a.a());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f30641b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f30641b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30640a.f30646d;
    }
}
