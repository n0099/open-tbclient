package com.kwad.sdk.api.loader;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C1064a {

        /* renamed from: a  reason: collision with root package name */
        int f8189a;

        /* renamed from: b  reason: collision with root package name */
        String f8190b;
        String c;
        long d;
        String e;
        transient File f;

        C1064a() {
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f8189a = jSONObject.optInt("dynamicType");
            this.f8190b = jSONObject.optString("dynamicUrl");
            this.c = jSONObject.optString("md5");
            this.d = jSONObject.optLong("interval");
            this.e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f8189a == 1;
        }

        public boolean b() {
            return this.f8189a == -1;
        }
    }

    /* loaded from: classes4.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        long f8191a;

        /* renamed from: b  reason: collision with root package name */
        String f8192b;
        C1064a c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f8191a = jSONObject.optLong("result");
            this.f8192b = jSONObject.optString(TiebaInitialize.LogFields.ERROR_MESSAGE);
            this.c = new C1064a();
            this.c.a(jSONObject.optJSONObject("data"));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f8191a == 1 && this.c != null;
        }
    }
}
