package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0369a {

        /* renamed from: a  reason: collision with root package name */
        public int f32062a;

        /* renamed from: b  reason: collision with root package name */
        public String f32063b;

        /* renamed from: c  reason: collision with root package name */
        public String f32064c;

        /* renamed from: d  reason: collision with root package name */
        public long f32065d;

        /* renamed from: e  reason: collision with root package name */
        public String f32066e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f32067f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32062a = jSONObject.optInt("dynamicType");
            this.f32063b = jSONObject.optString("dynamicUrl");
            this.f32064c = jSONObject.optString(PackageTable.MD5);
            this.f32065d = jSONObject.optLong("interval");
            this.f32066e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f32062a == 1;
        }

        public boolean b() {
            return this.f32062a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f32068a;

        /* renamed from: b  reason: collision with root package name */
        public String f32069b;

        /* renamed from: c  reason: collision with root package name */
        public C0369a f32070c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f32068a = jSONObject.optLong("result");
            this.f32069b = jSONObject.optString("errorMsg");
            C0369a c0369a = new C0369a();
            this.f32070c = c0369a;
            c0369a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f32068a == 1 && this.f32070c != null;
        }
    }
}
