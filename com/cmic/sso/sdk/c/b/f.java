package com.cmic.sso.sdk.c.b;

import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends g {
    private b oJc;
    private a oJd;

    public void a(b bVar) {
        this.oJc = bVar;
    }

    public void a(a aVar) {
        this.oJd = aVar;
    }

    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f4014a;
        private String b;
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
            return this.f4014a;
        }

        public void c(String str) {
            this.f4014a = str;
        }

        public String d() {
            return this.b;
        }

        public void d(String str) {
            this.b = str;
        }

        public String e() {
            return this.c;
        }

        public void e(String str) {
            this.c = str;
        }

        public String f() {
            return com.cmic.sso.sdk.e.d.a(this.e + this.d + this.c + this.b + "@Fdiwmxy7CBDDQNUI");
        }
    }

    /* loaded from: classes8.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f4013a;

        public JSONObject a() {
            return this.f4013a;
        }

        public void a(JSONObject jSONObject) {
            this.f4013a = jSONObject;
        }
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.oJc.d;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.oJc.c());
            jSONObject2.put("msgid", this.oJc.d());
            jSONObject2.put("systemtime", this.oJc.e());
            jSONObject2.put("appid", this.oJc.b());
            jSONObject2.put("version", this.oJc.a());
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.oJd.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
