package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2104a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f55596b;

        /* renamed from: c  reason: collision with root package name */
        public String f55597c;

        /* renamed from: d  reason: collision with root package name */
        public long f55598d;

        /* renamed from: e  reason: collision with root package name */
        public String f55599e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f55600f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("dynamicType");
            this.f55596b = jSONObject.optString("dynamicUrl");
            this.f55597c = jSONObject.optString(PackageTable.MD5);
            this.f55598d = jSONObject.optLong("interval");
            this.f55599e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.a == 1;
        }

        public boolean b() {
            return this.a == -1;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f55601b;

        /* renamed from: c  reason: collision with root package name */
        public C2104a f55602c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optLong("result");
            this.f55601b = jSONObject.optString("errorMsg");
            C2104a c2104a = new C2104a();
            this.f55602c = c2104a;
            c2104a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.a == 1 && this.f55602c != null;
        }
    }
}
