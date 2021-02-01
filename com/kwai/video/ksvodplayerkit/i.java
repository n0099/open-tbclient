package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.kwai.video.ksvodplayerkit.b.o;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private a f11097a;

    /* renamed from: b  reason: collision with root package name */
    private a f11098b;
    private volatile boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f11099a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11100b;
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
            this.f11099a = 157286400;
            this.f11100b = false;
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
        private static final i f11101a = new i();
    }

    private i() {
        this.f11097a = new a();
        this.c = false;
    }

    public static i a() {
        return b.f11101a;
    }

    private a u() {
        if (!this.c || this.f11098b == null) {
            if (this.f11097a == null) {
                this.f11097a = new a();
            }
            return this.f11097a;
        }
        return this.f11098b;
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
        this.f11098b = new a();
        try {
            if (jSONObject.has("maxCacheBytes")) {
                this.f11098b.f11099a = jSONObject.getInt("maxCacheBytes");
            }
            if (jSONObject.has("playHistory")) {
                this.f11098b.f11100b = jSONObject.getBoolean("playHistory");
            }
            if (jSONObject.has("maxBufferCostMs")) {
                this.f11098b.d = jSONObject.getInt("maxBufferCostMs");
            }
            if (jSONObject.has("startPlayBlockBufferMs")) {
                this.f11098b.c = jSONObject.getInt("startPlayBlockBufferMs");
            }
            if (jSONObject.has("socketBufferSizeKB")) {
                this.f11098b.f = jSONObject.getInt("socketBufferSizeKB");
            }
            if (jSONObject.has("maxRetryCount")) {
                this.f11098b.e = jSONObject.getInt("maxRetryCount");
            }
            if (jSONObject.has("enableAsync")) {
                this.f11098b.h = jSONObject.getBoolean("enableAsync");
            }
            if (jSONObject.has("preloadDurationMs")) {
                this.f11098b.g = jSONObject.getInt("preloadDurationMs");
            }
            if (jSONObject.has("enableHostSort")) {
                this.f11098b.k = jSONObject.getBoolean("enableHostSort");
            }
            if (jSONObject.has("enableH264HW")) {
                this.f11098b.i = jSONObject.getBoolean("enableH264HW");
            }
            if (jSONObject.has("enableH265HW")) {
                this.f11098b.j = jSONObject.getBoolean("enableH265HW");
            }
            if (jSONObject.has("vodLowDevice")) {
                this.f11098b.l = jSONObject.getInt("vodLowDevice");
            }
            if (jSONObject.has("vodAdaptive")) {
                this.f11098b.m = o.a(jSONObject.getString("vodAdaptive"));
            }
            if (jSONObject.has("enableDebugInfo")) {
                this.f11098b.n = jSONObject.getBoolean("enableDebugInfo");
            }
            if (jSONObject.has("cacheDownloadConnectTimeoutMs")) {
                this.f11098b.o = jSONObject.getInt("cacheDownloadConnectTimeoutMs");
            }
            if (jSONObject.has("cacheDownloadReadTimeoutMs")) {
                this.f11098b.p = jSONObject.getInt("cacheDownloadReadTimeoutMs");
            }
            if (jSONObject.has("prefetcherConfig")) {
                this.f11098b.s = com.kwai.video.ksvodplayerkit.d.e.a(jSONObject.getString("prefetcherConfig"));
            }
            this.c = true;
            this.f11097a = this.f11098b;
        } catch (JSONException e2) {
            this.f11098b = null;
            this.c = false;
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayerConfig", "setConfigJsonStr exception:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return u().f11100b;
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
        return u().s.f11073b;
    }

    public com.kwai.video.ksvodplayerkit.d.d t() {
        return u().s;
    }
}
