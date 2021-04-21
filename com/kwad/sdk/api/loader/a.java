package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0372a {

        /* renamed from: a  reason: collision with root package name */
        public int f32157a;

        /* renamed from: b  reason: collision with root package name */
        public String f32158b;

        /* renamed from: c  reason: collision with root package name */
        public String f32159c;

        /* renamed from: d  reason: collision with root package name */
        public long f32160d;

        /* renamed from: e  reason: collision with root package name */
        public String f32161e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f32162f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32157a = jSONObject.optInt("dynamicType");
            this.f32158b = jSONObject.optString("dynamicUrl");
            this.f32159c = jSONObject.optString(PackageTable.MD5);
            this.f32160d = jSONObject.optLong("interval");
            this.f32161e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f32157a == 1;
        }

        public boolean b() {
            return this.f32157a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f32163a;

        /* renamed from: b  reason: collision with root package name */
        public String f32164b;

        /* renamed from: c  reason: collision with root package name */
        public C0372a f32165c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32163a = jSONObject.optLong("result");
            this.f32164b = jSONObject.optString("errorMsg");
            C0372a c0372a = new C0372a();
            this.f32165c = c0372a;
            c0372a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f32163a == 1 && this.f32165c != null;
        }
    }
}
