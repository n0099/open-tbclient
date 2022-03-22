package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1944a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public String f39098b;

        /* renamed from: c  reason: collision with root package name */
        public String f39099c;

        /* renamed from: d  reason: collision with root package name */
        public long f39100d;

        /* renamed from: e  reason: collision with root package name */
        public String f39101e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f39102f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("dynamicType");
            this.f39098b = jSONObject.optString("dynamicUrl");
            this.f39099c = jSONObject.optString(PackageTable.MD5);
            this.f39100d = jSONObject.optLong("interval");
            this.f39101e = jSONObject.optString(CommandMessage.SDK_VERSION);
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
        public String f39103b;

        /* renamed from: c  reason: collision with root package name */
        public C1944a f39104c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optLong("result");
            this.f39103b = jSONObject.optString("errorMsg");
            C1944a c1944a = new C1944a();
            this.f39104c = c1944a;
            c1944a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.a == 1 && this.f39104c != null;
        }
    }
}
