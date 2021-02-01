package com.cmic.sso.sdk.c.b;

import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class f extends g {
    private b pwO;
    private a pwP;

    public void a(b bVar) {
        this.pwO = bVar;
    }

    public void a(a aVar) {
        this.pwP = aVar;
    }

    /* loaded from: classes15.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f7713a;

        /* renamed from: b  reason: collision with root package name */
        private String f7714b;
        private String c;
        private String d;
        private String e;

        public String a() {
            return this.e;
        }

        public void a(String str) {
            this.e = str;
        }

        public String b() {
            return this.d;
        }

        public void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.f7713a;
        }

        public void c(String str) {
            this.f7713a = str;
        }

        public String d() {
            return this.f7714b;
        }

        public void d(String str) {
            this.f7714b = str;
        }

        public String e() {
            return this.c;
        }

        public void e(String str) {
            this.c = str;
        }

        public String f() {
            return com.cmic.sso.sdk.e.d.a(this.e + this.d + this.c + this.f7714b + "@Fdiwmxy7CBDDQNUI");
        }
    }

    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f7712a;

        public JSONObject a() {
            return this.f7712a;
        }

        public void a(JSONObject jSONObject) {
            this.f7712a = jSONObject;
        }
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.pwO.d;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.pwO.c());
            jSONObject2.put("msgid", this.pwO.d());
            jSONObject2.put("systemtime", this.pwO.e());
            jSONObject2.put("appid", this.pwO.b());
            jSONObject2.put("version", this.pwO.a());
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.pwP.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
