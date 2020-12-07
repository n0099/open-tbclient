package com.cmic.sso.sdk.c.b;

import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends g {
    private b oZM;
    private a oZN;

    public void a(b bVar) {
        this.oZM = bVar;
    }

    public void a(a aVar) {
        this.oZN = aVar;
    }

    /* loaded from: classes10.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f4017a;
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
            return this.f4017a;
        }

        public void c(String str) {
            this.f4017a = str;
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

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f4016a;

        public JSONObject a() {
            return this.f4016a;
        }

        public void a(JSONObject jSONObject) {
            this.f4016a = jSONObject;
        }
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.oZM.d;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.oZM.c());
            jSONObject2.put("msgid", this.oZM.d());
            jSONObject2.put("systemtime", this.oZM.e());
            jSONObject2.put("appid", this.oZM.b());
            jSONObject2.put("version", this.oZM.a());
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.oZN.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
