package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2088a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f55384b;

        /* renamed from: c  reason: collision with root package name */
        public String f55385c;

        /* renamed from: d  reason: collision with root package name */
        public long f55386d;

        /* renamed from: e  reason: collision with root package name */
        public String f55387e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f55388f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("dynamicType");
            this.f55384b = jSONObject.optString("dynamicUrl");
            this.f55385c = jSONObject.optString(PackageTable.MD5);
            this.f55386d = jSONObject.optLong("interval");
            this.f55387e = jSONObject.optString(CommandMessage.SDK_VERSION);
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
        public String f55389b;

        /* renamed from: c  reason: collision with root package name */
        public C2088a f55390c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optLong("result");
            this.f55389b = jSONObject.optString("errorMsg");
            C2088a c2088a = new C2088a();
            this.f55390c = c2088a;
            c2088a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.a == 1 && this.f55390c != null;
        }
    }
}
