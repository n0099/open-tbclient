package com.kwad.sdk.api.loader;

import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.sdk.api.loader.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class j {
    public static int alQ;

    /* loaded from: classes10.dex */
    public static class a {
        public int alR;
        public int alS;
        public String alT;
        public String alU;
        public long alV;
        public int alW;
        public String alX;

        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a W(long j) {
            this.alV = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bQ(int i) {
            this.alR = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bR(int i) {
            this.alS = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bS(int i) {
            this.alW = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bU(String str) {
            this.alT = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bV(String str) {
            this.alU = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bW(String str) {
            this.alX = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.alR));
                jSONObject.putOpt("update_count", Integer.valueOf(this.alS));
                jSONObject.putOpt("dynamic_version", this.alT);
                jSONObject.putOpt("download_url", this.alU);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.alV));
                jSONObject.putOpt("error_code", Integer.valueOf(this.alW));
                jSONObject.putOpt(GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.alX);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.alR + ", update_count=" + this.alS + ", dynamic_version='" + this.alT + "', download_url='" + this.alU + "', duration_ms=" + this.alV + ", error_code=" + this.alW + ", error_msg='" + this.alX + "'}";
        }
    }

    public static void a(int i, a.C0692a c0692a, long j, int i2, String str) {
        if (c0692a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).bQ(i).bR(alQ).bU(c0692a.sdkVersion).bV(c0692a.alv).W(j).bS(i2).bW(str).toJson();
            StringBuilder sb = new StringBuilder("status:");
            sb.append(i);
            sb.append("--jo:");
            sb.append(json);
            com.kwad.sdk.api.c.c("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }

    public static void a(a.C0692a c0692a) {
        alQ++;
        a(1, c0692a, 0L, 0, "");
    }

    public static void b(a.C0692a c0692a) {
        a(5, c0692a, 0L, 0, "");
    }

    public static void a(a.C0692a c0692a, int i, String str) {
        a(4, c0692a, 0L, i, str);
    }

    public static void b(a.C0692a c0692a, int i, String str) {
        a(7, c0692a, 0L, i, str);
    }

    public static void a(a.C0692a c0692a, long j) {
        a(2, c0692a, j, 0, "");
    }

    public static void b(a.C0692a c0692a, long j) {
        a(6, c0692a, j, 0, "");
    }

    public static void a(a.C0692a c0692a, long j, String str) {
        a(3, c0692a, j, 0, str);
    }
}
