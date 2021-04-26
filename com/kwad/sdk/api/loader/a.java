package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0363a {

        /* renamed from: a  reason: collision with root package name */
        public int f32568a;

        /* renamed from: b  reason: collision with root package name */
        public String f32569b;

        /* renamed from: c  reason: collision with root package name */
        public String f32570c;

        /* renamed from: d  reason: collision with root package name */
        public long f32571d;

        /* renamed from: e  reason: collision with root package name */
        public String f32572e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f32573f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32568a = jSONObject.optInt("dynamicType");
            this.f32569b = jSONObject.optString("dynamicUrl");
            this.f32570c = jSONObject.optString(PackageTable.MD5);
            this.f32571d = jSONObject.optLong("interval");
            this.f32572e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f32568a == 1;
        }

        public boolean b() {
            return this.f32568a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f32574a;

        /* renamed from: b  reason: collision with root package name */
        public String f32575b;

        /* renamed from: c  reason: collision with root package name */
        public C0363a f32576c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32574a = jSONObject.optLong("result");
            this.f32575b = jSONObject.optString("errorMsg");
            C0363a c0363a = new C0363a();
            this.f32576c = c0363a;
            c0363a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f32574a == 1 && this.f32576c != null;
        }
    }
}
