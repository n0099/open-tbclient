package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.kwai.video.ksvodplayerkit.b.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public a f37644a;

    /* renamed from: b  reason: collision with root package name */
    public a f37645b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f37646c;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37647a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f37648b;

        /* renamed from: c  reason: collision with root package name */
        public int f37649c;

        /* renamed from: d  reason: collision with root package name */
        public int f37650d;

        /* renamed from: e  reason: collision with root package name */
        public int f37651e;

        /* renamed from: f  reason: collision with root package name */
        public int f37652f;

        /* renamed from: g  reason: collision with root package name */
        public int f37653g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f37654h;
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
            this.f37647a = 157286400;
            this.f37648b = false;
            this.f37649c = 300;
            this.f37650d = 500;
            this.f37651e = 5;
            this.f37652f = 256;
            this.f37653g = 3000;
            this.f37654h = false;
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
        public static final i f37655a = new i();
    }

    public i() {
        this.f37644a = new a();
        this.f37646c = false;
    }

    public static i a() {
        return b.f37655a;
    }

    private a u() {
        a aVar;
        if (!this.f37646c || (aVar = this.f37645b) == null) {
            if (this.f37644a == null) {
                this.f37644a = new a();
            }
            return this.f37644a;
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
        this.f37646c = false;
        this.f37645b = new a();
        try {
            if (jSONObject.has("maxCacheBytes")) {
                this.f37645b.f37647a = jSONObject.getInt("maxCacheBytes");
            }
            if (jSONObject.has("playHistory")) {
                this.f37645b.f37648b = jSONObject.getBoolean("playHistory");
            }
            if (jSONObject.has("maxBufferCostMs")) {
                this.f37645b.f37650d = jSONObject.getInt("maxBufferCostMs");
            }
            if (jSONObject.has("startPlayBlockBufferMs")) {
                this.f37645b.f37649c = jSONObject.getInt("startPlayBlockBufferMs");
            }
            if (jSONObject.has("socketBufferSizeKB")) {
                this.f37645b.f37652f = jSONObject.getInt("socketBufferSizeKB");
            }
            if (jSONObject.has("maxRetryCount")) {
                this.f37645b.f37651e = jSONObject.getInt("maxRetryCount");
            }
            if (jSONObject.has("enableAsync")) {
                this.f37645b.f37654h = jSONObject.getBoolean("enableAsync");
            }
            if (jSONObject.has("preloadDurationMs")) {
                this.f37645b.f37653g = jSONObject.getInt("preloadDurationMs");
            }
            if (jSONObject.has("enableHostSort")) {
                this.f37645b.k = jSONObject.getBoolean("enableHostSort");
            }
            if (jSONObject.has("enableH264HW")) {
                this.f37645b.i = jSONObject.getBoolean("enableH264HW");
            }
            if (jSONObject.has("enableH265HW")) {
                this.f37645b.j = jSONObject.getBoolean("enableH265HW");
            }
            String str3 = str2;
            if (jSONObject.has(str3)) {
                this.f37645b.l = jSONObject.getInt(str3);
            }
            if (jSONObject.has("vodAdaptive")) {
                this.f37645b.m = o.a(jSONObject.getString("vodAdaptive"));
            }
            if (jSONObject.has("enableDebugInfo")) {
                this.f37645b.n = jSONObject.getBoolean("enableDebugInfo");
            }
            if (jSONObject.has("cacheDownloadConnectTimeoutMs")) {
                this.f37645b.o = jSONObject.getInt("cacheDownloadConnectTimeoutMs");
            }
            if (jSONObject.has("cacheDownloadReadTimeoutMs")) {
                this.f37645b.p = jSONObject.getInt("cacheDownloadReadTimeoutMs");
            }
            if (jSONObject.has("prefetcherConfig")) {
                this.f37645b.s = com.kwai.video.ksvodplayerkit.d.e.a(jSONObject.getString("prefetcherConfig"));
            }
            this.f37646c = true;
            this.f37644a = this.f37645b;
        } catch (JSONException e3) {
            this.f37645b = null;
            this.f37646c = false;
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "setConfigJsonStr exception:" + e3.getMessage());
        }
    }

    public boolean b() {
        return u().f37648b;
    }

    public int c() {
        return u().f37649c;
    }

    public int d() {
        return u().f37650d;
    }

    public int e() {
        return u().f37651e;
    }

    public int f() {
        return u().f37653g;
    }

    public boolean g() {
        return u().i;
    }

    public boolean h() {
        return u().j;
    }

    public boolean i() {
        return u().f37654h;
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
        return u().f37652f;
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
        return u().s.f37594b;
    }

    public com.kwai.video.ksvodplayerkit.d.d t() {
        return u().s;
    }
}
