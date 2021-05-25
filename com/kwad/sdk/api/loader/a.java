package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0351a {

        /* renamed from: a  reason: collision with root package name */
        public int f31742a;

        /* renamed from: b  reason: collision with root package name */
        public String f31743b;

        /* renamed from: c  reason: collision with root package name */
        public String f31744c;

        /* renamed from: d  reason: collision with root package name */
        public long f31745d;

        /* renamed from: e  reason: collision with root package name */
        public String f31746e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f31747f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f31742a = jSONObject.optInt("dynamicType");
            this.f31743b = jSONObject.optString("dynamicUrl");
            this.f31744c = jSONObject.optString(PackageTable.MD5);
            this.f31745d = jSONObject.optLong("interval");
            this.f31746e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f31742a == 1;
        }

        public boolean b() {
            return this.f31742a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f31748a;

        /* renamed from: b  reason: collision with root package name */
        public String f31749b;

        /* renamed from: c  reason: collision with root package name */
        public C0351a f31750c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f31748a = jSONObject.optLong("result");
            this.f31749b = jSONObject.optString("errorMsg");
            C0351a c0351a = new C0351a();
            this.f31750c = c0351a;
            c0351a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f31748a == 1 && this.f31750c != null;
        }
    }
}
