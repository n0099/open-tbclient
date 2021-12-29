package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2071a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f57569b;

        /* renamed from: c  reason: collision with root package name */
        public String f57570c;

        /* renamed from: d  reason: collision with root package name */
        public long f57571d;

        /* renamed from: e  reason: collision with root package name */
        public String f57572e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f57573f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("dynamicType");
            this.f57569b = jSONObject.optString("dynamicUrl");
            this.f57570c = jSONObject.optString(PackageTable.MD5);
            this.f57571d = jSONObject.optLong("interval");
            this.f57572e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.a == 1;
        }

        public boolean b() {
            return this.a == -1;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f57574b;

        /* renamed from: c  reason: collision with root package name */
        public C2071a f57575c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optLong("result");
            this.f57574b = jSONObject.optString("errorMsg");
            C2071a c2071a = new C2071a();
            this.f57575c = c2071a;
            c2071a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.a == 1 && this.f57575c != null;
        }
    }
}
