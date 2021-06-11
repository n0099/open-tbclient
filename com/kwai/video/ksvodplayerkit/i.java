package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.b.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public a f38132a;

    /* renamed from: b  reason: collision with root package name */
    public a f38133b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f38134c;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f38135a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38136b;

        /* renamed from: c  reason: collision with root package name */
        public int f38137c;

        /* renamed from: d  reason: collision with root package name */
        public int f38138d;

        /* renamed from: e  reason: collision with root package name */
        public int f38139e;

        /* renamed from: f  reason: collision with root package name */
        public int f38140f;

        /* renamed from: g  reason: collision with root package name */
        public int f38141g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f38142h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f38143i;
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
            this.f38135a = 157286400;
            this.f38136b = false;
            this.f38137c = 300;
            this.f38138d = 500;
            this.f38139e = 5;
            this.f38140f = 256;
            this.f38141g = 3000;
            this.f38142h = false;
            this.f38143i = false;
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
        public static final i f38144a = new i();
    }

    public i() {
        this.f38132a = new a();
        this.f38134c = false;
    }

    public static i a() {
        return b.f38144a;
    }

    private a u() {
        a aVar;
        if (!this.f38134c || (aVar = this.f38133b) == null) {
            if (this.f38132a == null) {
                this.f38132a = new a();
            }
            return this.f38132a;
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
        this.f38134c = false;
        this.f38133b = new a();
        try {
            if (jSONObject.has("maxCacheBytes")) {
                this.f38133b.f38135a = jSONObject.getInt("maxCacheBytes");
            }
            if (jSONObject.has("playHistory")) {
                this.f38133b.f38136b = jSONObject.getBoolean("playHistory");
            }
            if (jSONObject.has("maxBufferCostMs")) {
                this.f38133b.f38138d = jSONObject.getInt("maxBufferCostMs");
            }
            if (jSONObject.has("startPlayBlockBufferMs")) {
                this.f38133b.f38137c = jSONObject.getInt("startPlayBlockBufferMs");
            }
            if (jSONObject.has("socketBufferSizeKB")) {
                this.f38133b.f38140f = jSONObject.getInt("socketBufferSizeKB");
            }
            if (jSONObject.has("maxRetryCount")) {
                this.f38133b.f38139e = jSONObject.getInt("maxRetryCount");
            }
            if (jSONObject.has("enableAsync")) {
                this.f38133b.f38142h = jSONObject.getBoolean("enableAsync");
            }
            if (jSONObject.has("preloadDurationMs")) {
                this.f38133b.f38141g = jSONObject.getInt("preloadDurationMs");
            }
            if (jSONObject.has("enableHostSort")) {
                this.f38133b.k = jSONObject.getBoolean("enableHostSort");
            }
            if (jSONObject.has("enableH264HW")) {
                this.f38133b.f38143i = jSONObject.getBoolean("enableH264HW");
            }
            if (jSONObject.has("enableH265HW")) {
                this.f38133b.j = jSONObject.getBoolean("enableH265HW");
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                this.f38133b.l = jSONObject.getInt(str3);
            }
            if (jSONObject.has("vodAdaptive")) {
                this.f38133b.m = o.a(jSONObject.getString("vodAdaptive"));
            }
            if (jSONObject.has("enableDebugInfo")) {
                this.f38133b.n = jSONObject.getBoolean("enableDebugInfo");
            }
            if (jSONObject.has("cacheDownloadConnectTimeoutMs")) {
                this.f38133b.o = jSONObject.getInt("cacheDownloadConnectTimeoutMs");
            }
            if (jSONObject.has("cacheDownloadReadTimeoutMs")) {
                this.f38133b.p = jSONObject.getInt("cacheDownloadReadTimeoutMs");
            }
            if (jSONObject.has("prefetcherConfig")) {
                this.f38133b.s = com.kwai.video.ksvodplayerkit.d.e.a(jSONObject.getString("prefetcherConfig"));
            }
            this.f38134c = true;
            this.f38132a = this.f38133b;
        } catch (JSONException e3) {
            this.f38133b = null;
            this.f38134c = false;
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "setConfigJsonStr exception:" + e3.getMessage());
        }
    }

    public boolean b() {
        return u().f38136b;
    }

    public int c() {
        return u().f38137c;
    }

    public int d() {
        return u().f38138d;
    }

    public int e() {
        return u().f38139e;
    }

    public int f() {
        return u().f38141g;
    }

    public boolean g() {
        return u().f38143i;
    }

    public boolean h() {
        return u().j;
    }

    public boolean i() {
        return u().f38142h;
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
        return u().f38140f;
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
        return u().s.f38080b;
    }

    public com.kwai.video.ksvodplayerkit.d.d t() {
        return u().s;
    }
}
