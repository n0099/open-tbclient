package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.b.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public a f37354a;

    /* renamed from: b  reason: collision with root package name */
    public a f37355b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f37356c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37357a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37358b;

        /* renamed from: c  reason: collision with root package name */
        public int f37359c;

        /* renamed from: d  reason: collision with root package name */
        public int f37360d;

        /* renamed from: e  reason: collision with root package name */
        public int f37361e;

        /* renamed from: f  reason: collision with root package name */
        public int f37362f;

        /* renamed from: g  reason: collision with root package name */
        public int f37363g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37364h;
        public boolean i;
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
            this.f37357a = 157286400;
            this.f37358b = false;
            this.f37359c = 300;
            this.f37360d = 500;
            this.f37361e = 5;
            this.f37362f = 256;
            this.f37363g = 3000;
            this.f37364h = false;
            this.i = false;
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

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final i f37365a = new i();
    }

    public i() {
        this.f37354a = new a();
        this.f37356c = false;
    }

    public static i a() {
        return b.f37365a;
    }

    private a u() {
        a aVar;
        if (!this.f37356c || (aVar = this.f37355b) == null) {
            if (this.f37354a == null) {
                this.f37354a = new a();
            }
            return this.f37354a;
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
        this.f37356c = false;
        this.f37355b = new a();
        try {
            if (jSONObject.has("maxCacheBytes")) {
                this.f37355b.f37357a = jSONObject.getInt("maxCacheBytes");
            }
            if (jSONObject.has("playHistory")) {
                this.f37355b.f37358b = jSONObject.getBoolean("playHistory");
            }
            if (jSONObject.has("maxBufferCostMs")) {
                this.f37355b.f37360d = jSONObject.getInt("maxBufferCostMs");
            }
            if (jSONObject.has("startPlayBlockBufferMs")) {
                this.f37355b.f37359c = jSONObject.getInt("startPlayBlockBufferMs");
            }
            if (jSONObject.has("socketBufferSizeKB")) {
                this.f37355b.f37362f = jSONObject.getInt("socketBufferSizeKB");
            }
            if (jSONObject.has("maxRetryCount")) {
                this.f37355b.f37361e = jSONObject.getInt("maxRetryCount");
            }
            if (jSONObject.has("enableAsync")) {
                this.f37355b.f37364h = jSONObject.getBoolean("enableAsync");
            }
            if (jSONObject.has("preloadDurationMs")) {
                this.f37355b.f37363g = jSONObject.getInt("preloadDurationMs");
            }
            if (jSONObject.has("enableHostSort")) {
                this.f37355b.k = jSONObject.getBoolean("enableHostSort");
            }
            if (jSONObject.has("enableH264HW")) {
                this.f37355b.i = jSONObject.getBoolean("enableH264HW");
            }
            if (jSONObject.has("enableH265HW")) {
                this.f37355b.j = jSONObject.getBoolean("enableH265HW");
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                this.f37355b.l = jSONObject.getInt(str3);
            }
            if (jSONObject.has("vodAdaptive")) {
                this.f37355b.m = o.a(jSONObject.getString("vodAdaptive"));
            }
            if (jSONObject.has("enableDebugInfo")) {
                this.f37355b.n = jSONObject.getBoolean("enableDebugInfo");
            }
            if (jSONObject.has("cacheDownloadConnectTimeoutMs")) {
                this.f37355b.o = jSONObject.getInt("cacheDownloadConnectTimeoutMs");
            }
            if (jSONObject.has("cacheDownloadReadTimeoutMs")) {
                this.f37355b.p = jSONObject.getInt("cacheDownloadReadTimeoutMs");
            }
            if (jSONObject.has("prefetcherConfig")) {
                this.f37355b.s = com.kwai.video.ksvodplayerkit.d.e.a(jSONObject.getString("prefetcherConfig"));
            }
            this.f37356c = true;
            this.f37354a = this.f37355b;
        } catch (JSONException e3) {
            this.f37355b = null;
            this.f37356c = false;
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "setConfigJsonStr exception:" + e3.getMessage());
        }
    }

    public boolean b() {
        return u().f37358b;
    }

    public int c() {
        return u().f37359c;
    }

    public int d() {
        return u().f37360d;
    }

    public int e() {
        return u().f37361e;
    }

    public int f() {
        return u().f37363g;
    }

    public boolean g() {
        return u().i;
    }

    public boolean h() {
        return u().j;
    }

    public boolean i() {
        return u().f37364h;
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
        return u().f37362f;
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
        return u().s.f37304b;
    }

    public com.kwai.video.ksvodplayerkit.d.d t() {
        return u().s;
    }
}
