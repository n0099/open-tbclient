package com.kwad.sdk.api.loader;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C1087a {

        /* renamed from: a  reason: collision with root package name */
        int f5457a;
        String b;
        String c;
        long d;
        String e;
        transient File f;

        C1087a() {
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f5457a = jSONObject.optInt("dynamicType");
            this.b = jSONObject.optString("dynamicUrl");
            this.c = jSONObject.optString("md5");
            this.d = jSONObject.optLong("interval");
            this.e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f5457a == 1;
        }

        public boolean b() {
            return this.f5457a == -1;
        }
    }

    /* loaded from: classes3.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        long f5458a;
        String b;
        C1087a c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f5458a = jSONObject.optLong("result");
            this.b = jSONObject.optString(TiebaInitialize.LogFields.ERROR_MESSAGE);
            this.c = new C1087a();
            this.c.a(jSONObject.optJSONObject("data"));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f5458a == 1 && this.c != null;
        }
    }
}
