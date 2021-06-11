package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0355a {

        /* renamed from: a  reason: collision with root package name */
        public int f32318a;

        /* renamed from: b  reason: collision with root package name */
        public String f32319b;

        /* renamed from: c  reason: collision with root package name */
        public String f32320c;

        /* renamed from: d  reason: collision with root package name */
        public long f32321d;

        /* renamed from: e  reason: collision with root package name */
        public String f32322e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f32323f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32318a = jSONObject.optInt("dynamicType");
            this.f32319b = jSONObject.optString("dynamicUrl");
            this.f32320c = jSONObject.optString(PackageTable.MD5);
            this.f32321d = jSONObject.optLong("interval");
            this.f32322e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f32318a == 1;
        }

        public boolean b() {
            return this.f32318a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f32324a;

        /* renamed from: b  reason: collision with root package name */
        public String f32325b;

        /* renamed from: c  reason: collision with root package name */
        public C0355a f32326c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32324a = jSONObject.optLong("result");
            this.f32325b = jSONObject.optString("errorMsg");
            C0355a c0355a = new C0355a();
            this.f32326c = c0355a;
            c0355a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f32324a == 1 && this.f32326c != null;
        }
    }
}
