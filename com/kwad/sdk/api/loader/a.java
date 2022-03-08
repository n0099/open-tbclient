package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C2083a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f53946b;

        /* renamed from: c  reason: collision with root package name */
        public String f53947c;

        /* renamed from: d  reason: collision with root package name */
        public long f53948d;

        /* renamed from: e  reason: collision with root package name */
        public String f53949e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f53950f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("dynamicType");
            this.f53946b = jSONObject.optString("dynamicUrl");
            this.f53947c = jSONObject.optString(PackageTable.MD5);
            this.f53948d = jSONObject.optLong("interval");
            this.f53949e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.a == 1;
        }

        public boolean b() {
            return this.a == -1;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public String f53951b;

        /* renamed from: c  reason: collision with root package name */
        public C2083a f53952c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optLong("result");
            this.f53951b = jSONObject.optString("errorMsg");
            C2083a c2083a = new C2083a();
            this.f53952c = c2083a;
            c2083a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.a == 1 && this.f53952c != null;
        }
    }
}
