package com.kwad.sdk.api.loader;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.kwad.sdk.api.loader.a;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class j {
    public static int a;

    /* loaded from: classes8.dex */
    public static class a {
        public double a;
        public double b;
        public int c;
        public int d;
        public String e;
        public String f;
        public String g;
        public long h;
        public int i;
        public String j;

        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt(MapBundleKey.OfflineMapKey.OFFLINE_RATION, Double.valueOf(this.a));
                jSONObject.putOpt("ratio_count", Double.valueOf(this.b));
                jSONObject.putOpt("load_status", Integer.valueOf(this.c));
                jSONObject.putOpt("update_count", Integer.valueOf(this.d));
                jSONObject.putOpt("current_version", this.e);
                jSONObject.putOpt("new_version", this.f);
                jSONObject.putOpt("download_url", this.g);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.h));
                jSONObject.putOpt("error_code", Integer.valueOf(this.i));
                jSONObject.putOpt(GameCodeGetResponseMsg.PARAM_ERROR_MSG, this.j);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{ratio_count=" + this.b + ", load_status=" + this.c + ", update_count=" + this.d + ", current_version='" + this.e + ", new_version='" + this.f + ", download_url='" + this.g + ", duration_ms=" + this.h + ", error_code=" + this.i + ", error_msg='" + this.j + '}';
        }
    }

    public static void a(int i, a.C0621a c0621a, long j, int i2, String str) {
        if (c0621a == null) {
            return;
        }
        a aVar = new a((byte) 0);
        aVar.a = rl();
        aVar.b = rm();
        aVar.c = i;
        aVar.d = a;
        aVar.e = Loader.get().getKsAdSDKImpl().getSDKVersion();
        aVar.f = c0621a.e;
        aVar.g = c0621a.b;
        aVar.h = j;
        aVar.i = i2;
        aVar.j = str;
        JSONObject a2 = aVar.a();
        StringBuilder sb = new StringBuilder("status:");
        sb.append(i);
        sb.append("--jo:");
        sb.append(a2);
        com.kwad.sdk.api.b.a("reportDynamicUpdate", a2);
    }

    public static void a(a.C0621a c0621a) {
        a++;
        a(1, c0621a, 0L, 0, "");
    }

    public static void a(a.C0621a c0621a, int i, String str) {
        a(4, c0621a, 0L, i, str);
    }

    public static void a(a.C0621a c0621a, long j) {
        a(2, c0621a, j, 0, "");
    }

    public static void a(a.C0621a c0621a, long j, String str) {
        a(3, c0621a, j, 0, str);
    }

    public static void b(a.C0621a c0621a) {
        a(5, c0621a, 0L, 0, "");
    }

    public static void b(a.C0621a c0621a, int i, String str) {
        a(7, c0621a, 0L, i, str);
    }

    public static void b(a.C0621a c0621a, long j) {
        a(6, c0621a, j, 0, "");
    }

    public static double rl() {
        Float f = (Float) com.kwad.sdk.api.b.a("getDynamicLogRate", new Object[0]);
        if (f != null) {
            return f.floatValue();
        }
        return 1.0d;
    }

    public static double rm() {
        Float f = (Float) com.kwad.sdk.api.b.a("getDynamicLogRate", new Object[0]);
        if (f != null) {
            return 1.0d / f.floatValue();
        }
        return 1.0d;
    }
}
