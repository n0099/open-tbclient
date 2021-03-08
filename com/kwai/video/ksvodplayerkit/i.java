package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.kwai.video.ksvodplayerkit.b.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private a f7305a;
    private a b;
    private volatile boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f7306a;
        private boolean b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private int l;
        private com.kwai.video.ksvodplayerkit.b.n m;
        private boolean n;
        private int o;
        private int p;
        private int q;
        private int r;
        private com.kwai.video.ksvodplayerkit.d.d s;

        private a() {
            this.f7306a = 157286400;
            this.b = false;
            this.c = 300;
            this.d = 500;
            this.e = 5;
            this.f = 256;
            this.g = 3000;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
            this.l = 0;
            this.m = new com.kwai.video.ksvodplayerkit.b.n();
            this.n = false;
            this.o = 3000;
            this.p = BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL;
            this.q = 32;
            this.r = 3000;
            this.s = new com.kwai.video.ksvodplayerkit.d.d();
        }
    }

    /* loaded from: classes3.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final i f7307a = new i();
    }

    private i() {
        this.f7305a = new a();
        this.c = false;
    }

    public static i a() {
        return b.f7307a;
    }

    private a u() {
        if (!this.c || this.b == null) {
            if (this.f7305a == null) {
                this.f7305a = new a();
            }
            return this.f7305a;
        }
        return this.b;
    }

    public void a(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "ERROR!  Config JSONException:" + e.getMessage());
            jSONObject = null;
        }
        if (jSONObject == null) {
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "ERROR!  Config is null");
            return;
        }
        this.c = false;
        this.b = new a();
        try {
            if (jSONObject.has("maxCacheBytes")) {
                this.b.f7306a = jSONObject.getInt("maxCacheBytes");
            }
            if (jSONObject.has("playHistory")) {
                this.b.b = jSONObject.getBoolean("playHistory");
            }
            if (jSONObject.has("maxBufferCostMs")) {
                this.b.d = jSONObject.getInt("maxBufferCostMs");
            }
            if (jSONObject.has("startPlayBlockBufferMs")) {
                this.b.c = jSONObject.getInt("startPlayBlockBufferMs");
            }
            if (jSONObject.has("socketBufferSizeKB")) {
                this.b.f = jSONObject.getInt("socketBufferSizeKB");
            }
            if (jSONObject.has("maxRetryCount")) {
                this.b.e = jSONObject.getInt("maxRetryCount");
            }
            if (jSONObject.has("enableAsync")) {
                this.b.h = jSONObject.getBoolean("enableAsync");
            }
            if (jSONObject.has("preloadDurationMs")) {
                this.b.g = jSONObject.getInt("preloadDurationMs");
            }
            if (jSONObject.has("enableHostSort")) {
                this.b.k = jSONObject.getBoolean("enableHostSort");
            }
            if (jSONObject.has("enableH264HW")) {
                this.b.i = jSONObject.getBoolean("enableH264HW");
            }
            if (jSONObject.has("enableH265HW")) {
                this.b.j = jSONObject.getBoolean("enableH265HW");
            }
            if (jSONObject.has("vodLowDevice")) {
                this.b.l = jSONObject.getInt("vodLowDevice");
            }
            if (jSONObject.has("vodAdaptive")) {
                this.b.m = o.a(jSONObject.getString("vodAdaptive"));
            }
            if (jSONObject.has("enableDebugInfo")) {
                this.b.n = jSONObject.getBoolean("enableDebugInfo");
            }
            if (jSONObject.has("cacheDownloadConnectTimeoutMs")) {
                this.b.o = jSONObject.getInt("cacheDownloadConnectTimeoutMs");
            }
            if (jSONObject.has("cacheDownloadReadTimeoutMs")) {
                this.b.p = jSONObject.getInt("cacheDownloadReadTimeoutMs");
            }
            if (jSONObject.has("prefetcherConfig")) {
                this.b.s = com.kwai.video.ksvodplayerkit.d.e.a(jSONObject.getString("prefetcherConfig"));
            }
            this.c = true;
            this.f7305a = this.b;
        } catch (JSONException e2) {
            this.b = null;
            this.c = false;
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "setConfigJsonStr exception:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return u().b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return u().c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return u().d;
    }

    public int e() {
        return u().e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return u().g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return u().i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return u().j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return u().h;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return u().f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return u().o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return u().p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return u().q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return u().r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long s() {
        return u().s.b;
    }

    public com.kwai.video.ksvodplayerkit.d.d t() {
        return u().s;
    }
}
