package com.kwad.sdk.api.loader;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static class C1040a {

        /* renamed from: a  reason: collision with root package name */
        int f8488a;

        /* renamed from: b  reason: collision with root package name */
        String f8489b;
        String c;
        long d;
        String e;
        transient File f;

        C1040a() {
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f8488a = jSONObject.optInt("dynamicType");
            this.f8489b = jSONObject.optString("dynamicUrl");
            this.c = jSONObject.optString("md5");
            this.d = jSONObject.optLong("interval");
            this.e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f8488a == 1;
        }

        public boolean b() {
            return this.f8488a == -1;
        }
    }

    /* loaded from: classes5.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        long f8490a;

        /* renamed from: b  reason: collision with root package name */
        String f8491b;
        C1040a c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f8490a = jSONObject.optLong("result");
            this.f8491b = jSONObject.optString(TiebaInitialize.LogFields.ERROR_MESSAGE);
            this.c = new C1040a();
            this.c.a(jSONObject.optJSONObject("data"));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f8490a == 1 && this.c != null;
        }
    }
}
