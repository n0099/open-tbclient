package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0355a {

        /* renamed from: a  reason: collision with root package name */
        public int f31773a;

        /* renamed from: b  reason: collision with root package name */
        public String f31774b;

        /* renamed from: c  reason: collision with root package name */
        public String f31775c;

        /* renamed from: d  reason: collision with root package name */
        public long f31776d;

        /* renamed from: e  reason: collision with root package name */
        public String f31777e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f31778f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f31773a = jSONObject.optInt("dynamicType");
            this.f31774b = jSONObject.optString("dynamicUrl");
            this.f31775c = jSONObject.optString(PackageTable.MD5);
            this.f31776d = jSONObject.optLong("interval");
            this.f31777e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f31773a == 1;
        }

        public boolean b() {
            return this.f31773a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f31779a;

        /* renamed from: b  reason: collision with root package name */
        public String f31780b;

        /* renamed from: c  reason: collision with root package name */
        public C0355a f31781c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f31779a = jSONObject.optLong("result");
            this.f31780b = jSONObject.optString("errorMsg");
            C0355a c0355a = new C0355a();
            this.f31781c = c0355a;
            c0355a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f31779a == 1 && this.f31781c != null;
        }
    }
}
