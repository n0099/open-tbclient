package com.kwad.sdk.api.loader;

import java.io.File;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0692a {
        public int alu;
        public String alv;
        public transient File alw;
        public long interval;
        public String md5;
        public String sdkVersion;

        public final boolean zf() {
            if (this.alu == 1) {
                return true;
            }
            return false;
        }

        public final boolean zg() {
            if (this.alu == -1) {
                return true;
            }
            return false;
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.alu = jSONObject.optInt("dynamicType");
            this.alv = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong("interval");
            this.sdkVersion = jSONObject.optString(com.heytap.mcssdk.constant.b.C);
        }

        public final String toString() {
            return "Data{dynamicType=" + this.alu + ", dynamicUrl='" + this.alv + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.alw + '}';
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public long alx;
        public C0692a aly;
        public String errorMsg;

        public final String toString() {
            return "UpdateData{result=" + this.alx + ", errorMsg='" + this.errorMsg + "', data=" + this.aly + '}';
        }

        public final boolean zh() {
            if (this.alx == 1 && this.aly != null) {
                return true;
            }
            return false;
        }

        public final void parseJson(JSONObject jSONObject) {
            this.alx = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString("errorMsg");
            C0692a c0692a = new C0692a();
            this.aly = c0692a;
            c0692a.parseJson(jSONObject.optJSONObject("data"));
        }
    }
}
