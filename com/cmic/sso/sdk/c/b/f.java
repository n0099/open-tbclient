package com.cmic.sso.sdk.c.b;

import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tbadk.TbConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f extends g {
    private b pmy;
    private a pmz;

    public void a(b bVar) {
        this.pmy = bVar;
    }

    public void a(a aVar) {
        this.pmz = aVar;
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f7711a;

        /* renamed from: b  reason: collision with root package name */
        private String f7712b;
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
            return this.f7711a;
        }

        public void c(String str) {
            this.f7711a = str;
        }

        public String d() {
            return this.f7712b;
        }

        public void d(String str) {
            this.f7712b = str;
        }

        public String e() {
            return this.c;
        }

        public void e(String str) {
            this.c = str;
        }

        public String f() {
            return com.cmic.sso.sdk.e.d.a(this.e + this.d + this.c + this.f7712b + "@Fdiwmxy7CBDDQNUI");
        }
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f7710a;

        public JSONObject a() {
            return this.f7710a;
        }

        public void a(JSONObject jSONObject) {
            this.f7710a = jSONObject;
        }
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.pmy.d;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.pmy.c());
            jSONObject2.put("msgid", this.pmy.d());
            jSONObject2.put("systemtime", this.pmy.e());
            jSONObject2.put("appid", this.pmy.b());
            jSONObject2.put("version", this.pmy.a());
            jSONObject.put(WebSocketRequest.PARAM_KEY_HEADER, jSONObject2);
            jSONObject3.put(TbConfig.TMP_LOG_DIR_NAME, this.pmz.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
