package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.b.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public a f38230a;

    /* renamed from: b  reason: collision with root package name */
    public a f38231b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f38232c;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f38233a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38234b;

        /* renamed from: c  reason: collision with root package name */
        public int f38235c;

        /* renamed from: d  reason: collision with root package name */
        public int f38236d;

        /* renamed from: e  reason: collision with root package name */
        public int f38237e;

        /* renamed from: f  reason: collision with root package name */
        public int f38238f;

        /* renamed from: g  reason: collision with root package name */
        public int f38239g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38240h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f38241i;
        public boolean j;
        public boolean k;
        public int l;
        public com.kwai.video.ksvodplayerkit.b.n m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;
        public com.kwai.video.ksvodplayerkit.d.d s;

        public a() {
            this.f38233a = 157286400;
            this.f38234b = false;
            this.f38235c = 300;
            this.f38236d = 500;
            this.f38237e = 5;
            this.f38238f = 256;
            this.f38239g = 3000;
            this.f38240h = false;
            this.f38241i = false;
            this.j = false;
            this.k = false;
            this.l = 0;
            this.m = new com.kwai.video.ksvodplayerkit.b.n();
            this.n = false;
            this.o = 3000;
            this.p = 15000;
            this.q = 32;
            this.r = 3000;
            this.s = new com.kwai.video.ksvodplayerkit.d.d();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final i f38242a = new i();
    }

    public i() {
        this.f38230a = new a();
        this.f38232c = false;
    }

    public static i a() {
        return b.f38242a;
    }

    private a u() {
        a aVar;
        if (!this.f38232c || (aVar = this.f38231b) == null) {
            if (this.f38230a == null) {
                this.f38230a = new a();
            }
            return this.f38230a;
        }
        return aVar;
    }

    public void a(String str) {
        String str2;
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
            str2 = "vodLowDevice";
        } catch (JSONException e2) {
            StringBuilder sb = new StringBuilder();
            str2 = "vodLowDevice";
            sb.append("ERROR!  Config JSONException:");
            sb.append(e2.getMessage());
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", sb.toString());
            jSONObject = null;
        }
        if (jSONObject == null) {
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "ERROR!  Config is null");
            return;
        }
        this.f38232c = false;
        this.f38231b = new a();
        try {
            if (jSONObject.has("maxCacheBytes")) {
                this.f38231b.f38233a = jSONObject.getInt("maxCacheBytes");
            }
            if (jSONObject.has("playHistory")) {
                this.f38231b.f38234b = jSONObject.getBoolean("playHistory");
            }
            if (jSONObject.has("maxBufferCostMs")) {
                this.f38231b.f38236d = jSONObject.getInt("maxBufferCostMs");
            }
            if (jSONObject.has("startPlayBlockBufferMs")) {
                this.f38231b.f38235c = jSONObject.getInt("startPlayBlockBufferMs");
            }
            if (jSONObject.has("socketBufferSizeKB")) {
                this.f38231b.f38238f = jSONObject.getInt("socketBufferSizeKB");
            }
            if (jSONObject.has("maxRetryCount")) {
                this.f38231b.f38237e = jSONObject.getInt("maxRetryCount");
            }
            if (jSONObject.has("enableAsync")) {
                this.f38231b.f38240h = jSONObject.getBoolean("enableAsync");
            }
            if (jSONObject.has("preloadDurationMs")) {
                this.f38231b.f38239g = jSONObject.getInt("preloadDurationMs");
            }
            if (jSONObject.has("enableHostSort")) {
                this.f38231b.k = jSONObject.getBoolean("enableHostSort");
            }
            if (jSONObject.has("enableH264HW")) {
                this.f38231b.f38241i = jSONObject.getBoolean("enableH264HW");
            }
            if (jSONObject.has("enableH265HW")) {
                this.f38231b.j = jSONObject.getBoolean("enableH265HW");
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                this.f38231b.l = jSONObject.getInt(str3);
            }
            if (jSONObject.has("vodAdaptive")) {
                this.f38231b.m = o.a(jSONObject.getString("vodAdaptive"));
            }
            if (jSONObject.has("enableDebugInfo")) {
                this.f38231b.n = jSONObject.getBoolean("enableDebugInfo");
            }
            if (jSONObject.has("cacheDownloadConnectTimeoutMs")) {
                this.f38231b.o = jSONObject.getInt("cacheDownloadConnectTimeoutMs");
            }
            if (jSONObject.has("cacheDownloadReadTimeoutMs")) {
                this.f38231b.p = jSONObject.getInt("cacheDownloadReadTimeoutMs");
            }
            if (jSONObject.has("prefetcherConfig")) {
                this.f38231b.s = com.kwai.video.ksvodplayerkit.d.e.a(jSONObject.getString("prefetcherConfig"));
            }
            this.f38232c = true;
            this.f38230a = this.f38231b;
        } catch (JSONException e3) {
            this.f38231b = null;
            this.f38232c = false;
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "setConfigJsonStr exception:" + e3.getMessage());
        }
    }

    public boolean b() {
        return u().f38234b;
    }

    public int c() {
        return u().f38235c;
    }

    public int d() {
        return u().f38236d;
    }

    public int e() {
        return u().f38237e;
    }

    public int f() {
        return u().f38239g;
    }

    public boolean g() {
        return u().f38241i;
    }

    public boolean h() {
        return u().j;
    }

    public boolean i() {
        return u().f38240h;
    }

    public boolean j() {
        return u().k;
    }

    public String k() {
        com.kwai.video.ksvodplayerkit.b.n nVar = u().m;
        if (nVar == null) {
            nVar = new com.kwai.video.ksvodplayerkit.b.n();
        }
        return nVar.a();
    }

    public int l() {
        return u().l;
    }

    public boolean m() {
        return true;
    }

    public int n() {
        return u().f38238f;
    }

    public int o() {
        return u().o;
    }

    public int p() {
        return u().p;
    }

    public int q() {
        return u().q;
    }

    public int r() {
        return u().r;
    }

    public long s() {
        return u().s.f38178b;
    }

    public com.kwai.video.ksvodplayerkit.d.d t() {
        return u().s;
    }
}
