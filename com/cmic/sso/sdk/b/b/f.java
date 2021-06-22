package com.cmic.sso.sdk.b.b;

import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g {

    /* renamed from: a  reason: collision with root package name */
    public b f30698a;

    /* renamed from: b  reason: collision with root package name */
    public a f30699b;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public JSONObject f30700a;

        public JSONObject a() {
            return this.f30700a;
        }

        public void a(JSONObject jSONObject) {
            this.f30700a = jSONObject;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        public String f30701a;

        /* renamed from: b  reason: collision with root package name */
        public String f30702b;

        /* renamed from: c  reason: collision with root package name */
        public String f30703c;

        /* renamed from: d  reason: collision with root package name */
        public String f30704d;

        /* renamed from: e  reason: collision with root package name */
        public String f30705e;

        @Override // com.cmic.sso.sdk.b.b.g
        public JSONObject b() {
            return null;
        }

        public void b(String str) {
            this.f30705e = str;
        }

        public String c() {
            return this.f30705e;
        }

        public String d() {
            return this.f30701a;
        }

        public String e() {
            return this.f30702b;
        }

        public String f() {
            return this.f30703c;
        }

        @Override // com.cmic.sso.sdk.b.b.g
        public String a() {
            return this.f30704d;
        }

        public void c(String str) {
            this.f30704d = str;
        }

        public void d(String str) {
            this.f30701a = str;
        }

        public void e(String str) {
            this.f30702b = str;
        }

        public void f(String str) {
            this.f30703c = str;
        }

        @Override // com.cmic.sso.sdk.b.b.g
        public String a(String str) {
            return this.f30705e + this.f30704d + this.f30703c + this.f30702b + "@Fdiwmxy7CBDDQNUI";
        }
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a(String str) {
        return null;
    }

    public void a(b bVar) {
        this.f30698a = bVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f30698a.d());
            jSONObject2.put("msgid", this.f30698a.e());
            jSONObject2.put("systemtime", this.f30698a.f());
            jSONObject2.put("appid", this.f30698a.a());
            jSONObject2.put("version", this.f30698a.c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.f30699b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.f30699b = aVar;
    }

    @Override // com.cmic.sso.sdk.b.b.g
    public String a() {
        return this.f30698a.f30704d;
    }
}
