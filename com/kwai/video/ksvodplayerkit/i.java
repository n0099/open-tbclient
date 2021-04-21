package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.b.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public a f37739a;

    /* renamed from: b  reason: collision with root package name */
    public a f37740b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f37741c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37742a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37743b;

        /* renamed from: c  reason: collision with root package name */
        public int f37744c;

        /* renamed from: d  reason: collision with root package name */
        public int f37745d;

        /* renamed from: e  reason: collision with root package name */
        public int f37746e;

        /* renamed from: f  reason: collision with root package name */
        public int f37747f;

        /* renamed from: g  reason: collision with root package name */
        public int f37748g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37749h;
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
            this.f37742a = 157286400;
            this.f37743b = false;
            this.f37744c = 300;
            this.f37745d = 500;
            this.f37746e = 5;
            this.f37747f = 256;
            this.f37748g = 3000;
            this.f37749h = false;
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
        public static final i f37750a = new i();
    }

    public i() {
        this.f37739a = new a();
        this.f37741c = false;
    }

    public static i a() {
        return b.f37750a;
    }

    private a u() {
        a aVar;
        if (!this.f37741c || (aVar = this.f37740b) == null) {
            if (this.f37739a == null) {
                this.f37739a = new a();
            }
            return this.f37739a;
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
        this.f37741c = false;
        this.f37740b = new a();
        try {
            if (jSONObject.has("maxCacheBytes")) {
                this.f37740b.f37742a = jSONObject.getInt("maxCacheBytes");
            }
            if (jSONObject.has("playHistory")) {
                this.f37740b.f37743b = jSONObject.getBoolean("playHistory");
            }
            if (jSONObject.has("maxBufferCostMs")) {
                this.f37740b.f37745d = jSONObject.getInt("maxBufferCostMs");
            }
            if (jSONObject.has("startPlayBlockBufferMs")) {
                this.f37740b.f37744c = jSONObject.getInt("startPlayBlockBufferMs");
            }
            if (jSONObject.has("socketBufferSizeKB")) {
                this.f37740b.f37747f = jSONObject.getInt("socketBufferSizeKB");
            }
            if (jSONObject.has("maxRetryCount")) {
                this.f37740b.f37746e = jSONObject.getInt("maxRetryCount");
            }
            if (jSONObject.has("enableAsync")) {
                this.f37740b.f37749h = jSONObject.getBoolean("enableAsync");
            }
            if (jSONObject.has("preloadDurationMs")) {
                this.f37740b.f37748g = jSONObject.getInt("preloadDurationMs");
            }
            if (jSONObject.has("enableHostSort")) {
                this.f37740b.k = jSONObject.getBoolean("enableHostSort");
            }
            if (jSONObject.has("enableH264HW")) {
                this.f37740b.i = jSONObject.getBoolean("enableH264HW");
            }
            if (jSONObject.has("enableH265HW")) {
                this.f37740b.j = jSONObject.getBoolean("enableH265HW");
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                this.f37740b.l = jSONObject.getInt(str3);
            }
            if (jSONObject.has("vodAdaptive")) {
                this.f37740b.m = o.a(jSONObject.getString("vodAdaptive"));
            }
            if (jSONObject.has("enableDebugInfo")) {
                this.f37740b.n = jSONObject.getBoolean("enableDebugInfo");
            }
            if (jSONObject.has("cacheDownloadConnectTimeoutMs")) {
                this.f37740b.o = jSONObject.getInt("cacheDownloadConnectTimeoutMs");
            }
            if (jSONObject.has("cacheDownloadReadTimeoutMs")) {
                this.f37740b.p = jSONObject.getInt("cacheDownloadReadTimeoutMs");
            }
            if (jSONObject.has("prefetcherConfig")) {
                this.f37740b.s = com.kwai.video.ksvodplayerkit.d.e.a(jSONObject.getString("prefetcherConfig"));
            }
            this.f37741c = true;
            this.f37739a = this.f37740b;
        } catch (JSONException e3) {
            this.f37740b = null;
            this.f37741c = false;
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "setConfigJsonStr exception:" + e3.getMessage());
        }
    }

    public boolean b() {
        return u().f37743b;
    }

    public int c() {
        return u().f37744c;
    }

    public int d() {
        return u().f37745d;
    }

    public int e() {
        return u().f37746e;
    }

    public int f() {
        return u().f37748g;
    }

    public boolean g() {
        return u().i;
    }

    public boolean h() {
        return u().j;
    }

    public boolean i() {
        return u().f37749h;
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
        return u().f37747f;
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
        return u().s.f37689b;
    }

    public com.kwai.video.ksvodplayerkit.d.d t() {
        return u().s;
    }
}
