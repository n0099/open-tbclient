package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0354a {

        /* renamed from: a  reason: collision with root package name */
        public int f31772a;

        /* renamed from: b  reason: collision with root package name */
        public String f31773b;

        /* renamed from: c  reason: collision with root package name */
        public String f31774c;

        /* renamed from: d  reason: collision with root package name */
        public long f31775d;

        /* renamed from: e  reason: collision with root package name */
        public String f31776e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f31777f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f31772a = jSONObject.optInt("dynamicType");
            this.f31773b = jSONObject.optString("dynamicUrl");
            this.f31774c = jSONObject.optString(PackageTable.MD5);
            this.f31775d = jSONObject.optLong("interval");
            this.f31776e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f31772a == 1;
        }

        public boolean b() {
            return this.f31772a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f31778a;

        /* renamed from: b  reason: collision with root package name */
        public String f31779b;

        /* renamed from: c  reason: collision with root package name */
        public C0354a f31780c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f31778a = jSONObject.optLong("result");
            this.f31779b = jSONObject.optString("errorMsg");
            C0354a c0354a = new C0354a();
            this.f31780c = c0354a;
            c0354a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f31778a == 1 && this.f31780c != null;
        }
    }
}
