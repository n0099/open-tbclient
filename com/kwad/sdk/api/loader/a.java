package com.kwad.sdk.api.loader;

import com.baidu.searchbox.pms.db.PackageTable;
import com.heytap.mcssdk.mode.CommandMessage;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0350a {

        /* renamed from: a  reason: collision with root package name */
        public int f31813a;

        /* renamed from: b  reason: collision with root package name */
        public String f31814b;

        /* renamed from: c  reason: collision with root package name */
        public String f31815c;

        /* renamed from: d  reason: collision with root package name */
        public long f31816d;

        /* renamed from: e  reason: collision with root package name */
        public String f31817e;

        /* renamed from: f  reason: collision with root package name */
        public transient File f31818f;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f31813a = jSONObject.optInt("dynamicType");
            this.f31814b = jSONObject.optString("dynamicUrl");
            this.f31815c = jSONObject.optString(PackageTable.MD5);
            this.f31816d = jSONObject.optLong("interval");
            this.f31817e = jSONObject.optString(CommandMessage.SDK_VERSION);
        }

        public boolean a() {
            return this.f31813a == 1;
        }

        public boolean b() {
            return this.f31813a == -1;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f31819a;

        /* renamed from: b  reason: collision with root package name */
        public String f31820b;

        /* renamed from: c  reason: collision with root package name */
        public C0350a f31821c;

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f31819a = jSONObject.optLong("result");
            this.f31820b = jSONObject.optString("errorMsg");
            C0350a c0350a = new C0350a();
            this.f31821c = c0350a;
            c0350a.a(jSONObject.optJSONObject("data"));
        }

        public boolean a() {
            return this.f31819a == 1 && this.f31821c != null;
        }
    }
}
