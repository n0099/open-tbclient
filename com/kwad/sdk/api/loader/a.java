package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0358a {

        /* renamed from: a  reason: collision with root package name */
        public int f32416a;

        /* renamed from: b  reason: collision with root package name */
        public String f32417b;

        /* renamed from: c  reason: collision with root package name */
        public String f32418c;

        /* renamed from: d  reason: collision with root package name */
        public long f32419d;

        /* renamed from: e  reason: collision with root package name */
        public String f32420e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f32421f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32416a = jSONObject.optInt("dynamicType");
            this.f32417b = jSONObject.optString("dynamicUrl");
            this.f32418c = jSONObject.optString(PackageTable.MD5);
            this.f32419d = jSONObject.optLong("interval");
            this.f32420e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f32416a == 1;
        }

        public boolean b() {
            return this.f32416a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f32422a;

        /* renamed from: b  reason: collision with root package name */
        public String f32423b;

        /* renamed from: c  reason: collision with root package name */
        public C0358a f32424c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32422a = jSONObject.optLong("result");
            this.f32423b = jSONObject.optString("errorMsg");
            C0358a c0358a = new C0358a();
            this.f32424c = c0358a;
            c0358a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f32422a == 1 && this.f32424c != null;
        }
    }
}
