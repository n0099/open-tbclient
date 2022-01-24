package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2094a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f55429b;

        /* renamed from: c  reason: collision with root package name */
        public String f55430c;

        /* renamed from: d  reason: collision with root package name */
        public long f55431d;

        /* renamed from: e  reason: collision with root package name */
        public String f55432e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f55433f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("dynamicType");
            this.f55429b = jSONObject.optString("dynamicUrl");
            this.f55430c = jSONObject.optString(PackageTable.MD5);
            this.f55431d = jSONObject.optLong("interval");
            this.f55432e = jSONObject.optString(CommandMessage.SDK_VERSION);
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
        public String f55434b;

        /* renamed from: c  reason: collision with root package name */
        public C2094a f55435c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optLong("result");
            this.f55434b = jSONObject.optString("errorMsg");
            C2094a c2094a = new C2094a();
            this.f55435c = c2094a;
            c2094a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.a == 1 && this.f55435c != null;
        }
    }
}
