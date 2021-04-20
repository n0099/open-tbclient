package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f30325a;

    /* renamed from: b  reason: collision with root package name */
    public a f30326b;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f30327a;

        public JSONObject a() {
            return this.f30327a;
        }

        public void a(JSONObject jSONObject) {
            this.f30327a = jSONObject;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f30328a;

        /* renamed from: b  reason: collision with root package name */
        public String f30329b;

        /* renamed from: c  reason: collision with root package name */
        public String f30330c;

        /* renamed from: d  reason: collision with root package name */
        public String f30331d;

        /* renamed from: e  reason: collision with root package name */
        public String f30332e;

        public String b() {
            return this.f30331d;
        }

        public String c() {
            return this.f30328a;
        }

        public String d() {
            return this.f30329b;
        }

        public String e() {
            return this.f30330c;
        }

        public String f() {
            return com.cmic.sso.sdk.d.d.a(this.f30332e + this.f30331d + this.f30330c + this.f30329b + "@Fdiwmxy7CBDDQNUI");
        }

        public String a() {
            return this.f30332e;
        }

        public void b(String str) {
            this.f30331d = str;
        }

        public void c(String str) {
            this.f30328a = str;
        }

        public void d(String str) {
            this.f30329b = str;
        }

        public void e(String str) {
            this.f30330c = str;
        }

        public void a(String str) {
            this.f30332e = str;
        }
    }

    public void a(b bVar) {
        this.f30325a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f30325a.c());
            jSONObject2.put("msgid", this.f30325a.d());
            jSONObject2.put("systemtime", this.f30325a.e());
            jSONObject2.put("appid", this.f30325a.b());
            jSONObject2.put("version", this.f30325a.a());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f30326b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f30326b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30325a.f30331d;
    }
}
