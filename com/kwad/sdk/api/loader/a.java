package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0292a {
        public int a;
        public String b;
        public String c;
        public long d;
        public String e;
        public transient File f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optInt("dynamicType");
            this.b = jSONObject.optString("dynamicUrl");
            this.c = jSONObject.optString(PackageTable.MD5);
            this.d = jSONObject.optLong("interval");
            this.e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.a == 1;
        }

        public boolean b() {
            return this.a == -1;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public long a;
        public String b;
        public C0292a c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.a = jSONObject.optLong("result");
            this.b = jSONObject.optString("errorMsg");
            C0292a c0292a = new C0292a();
            this.c = c0292a;
            c0292a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.a == 1 && this.c != null;
        }
    }
}
