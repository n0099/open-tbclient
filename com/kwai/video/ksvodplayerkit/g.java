package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwai.player.OnPlayerReleaseListener;
import com.kwai.player.qos.KwaiPlayerResultQos;
import com.kwai.video.cache.AcCallBackInfo;
import com.kwai.video.cache.AwesomeCacheCallback;
import com.kwai.video.ksvodplayerkit.KSVodPlayerBuilder;
import com.kwai.video.ksvodplayerkit.d;
import com.kwai.video.kwaiplayer_debug_tools.debuginfo.KwaiPlayerDebugInfoView;
import com.kwai.video.player.IKwaiMediaPlayer;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.PlayerPostEvent;
import com.kwai.video.player.PlayerSettingConstants;
import com.kwai.video.player.kwai_player.AspectAwesomeCache;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;
import com.kwai.video.player.kwai_player.KwaiPlayerVodBuilder;
import com.kwai.video.player.kwai_player.ProductContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g implements d {
    private com.kwai.video.ksvodplayerkit.HttpDns.d A;
    private com.kwai.video.ksvodplayerkit.b.f C;
    private long E;
    private long F;

    /* renamed from: a  reason: collision with root package name */
    KwaiPlayerDebugInfoView f11081a;
    private Surface c;
    private SurfaceHolder d;
    private IKwaiMediaPlayer e;
    private IKwaiMediaPlayer f;
    private String g;
    private Map<String, String> h;
    private KSVodPlayerBuilder i;
    private boolean j;
    private d.InterfaceC1167d t;
    private d.b u;
    private d.c v;
    private com.kwai.video.ksvodplayerkit.b w;
    private d.e x;
    private a y;
    private d.a z;

    /* renamed from: b  reason: collision with root package name */
    private final Object f11082b = new Object();
    private int k = 0;
    private long l = -1;
    private boolean m = true;
    private float n = 1.0f;
    private float o = 1.0f;
    private boolean p = false;
    private boolean q = false;
    private AtomicInteger r = new AtomicInteger();
    private boolean s = false;
    private AtomicInteger B = new AtomicInteger();
    private boolean D = false;
    private IMediaPlayer.OnSeekCompleteListener G = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.kwai.video.ksvodplayerkit.g.1
        @Override // com.kwai.video.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            if (g.this.v != null) {
                g.this.v.a(10100, 0);
            }
        }
    };
    private IMediaPlayer.OnInfoListener H = new IMediaPlayer.OnInfoListener() { // from class: com.kwai.video.ksvodplayerkit.g.2
        @Override // com.kwai.video.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            switch (i) {
                case 3:
                    i = 3;
                    synchronized (g.this.f11082b) {
                        if (g.this.i.e != null) {
                            g.this.l = System.currentTimeMillis() - g.this.i.e.d;
                        }
                    }
                    if (g.this.v != null) {
                        g.this.v.a(10207, 0);
                        break;
                    }
                    break;
                case 701:
                    i = 701;
                    break;
                case 702:
                    i = 702;
                    break;
                case 10001:
                    i = 10001;
                    break;
                case 10002:
                    i = 10002;
                    break;
                case 10003:
                    i = 10003;
                    if (!g.this.p && g.this.q && g.this.v != null) {
                        g.this.v.a(10207, 0);
                        g.this.q = false;
                    }
                    g.this.p = false;
                    break;
                case 10004:
                    i = 10004;
                    break;
                case PlayerPostEvent.MEDIA_INFO_PLAY_TO_END /* 10101 */:
                    i = PlayerPostEvent.MEDIA_INFO_PLAY_TO_END;
                    if (g.this.r.get() != 6 && g.this.v != null) {
                        g.this.v.a(10208, 0);
                        g.this.q = true;
                    }
                    g.this.r.set(6);
                    break;
                case 10103:
                    g.this.m = i2 == 5;
                    if (i2 == 6 && g.this.r.get() != 6) {
                        if (g.this.v != null) {
                            g.this.v.a(10208, 0);
                        }
                        g.this.q = true;
                    }
                    g.this.r.set(i2);
                    break;
            }
            if (g.this.v != null) {
                g.this.v.a(i, i2);
            }
            return false;
        }
    };
    private IMediaPlayer.OnErrorListener I = new IMediaPlayer.OnErrorListener() { // from class: com.kwai.video.ksvodplayerkit.g.3
        @Override // com.kwai.video.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            boolean z;
            g.this.r.set(9);
            if (i == -23120 && i2 == -3120) {
                z = g.this.j();
                Log.e("KSVodPlayer", "onError what: " + i + " extra: " + i2 + " retry: " + z + " retryCount: " + g.this.B.get());
            } else {
                z = false;
            }
            if (g.this.u != null && !z) {
                g.this.u.b(i, i2);
            }
            return false;
        }
    };
    private IMediaPlayer.OnPreparedListener J = new IMediaPlayer.OnPreparedListener() { // from class: com.kwai.video.ksvodplayerkit.g.4
        @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            boolean z;
            if (g.this.r.get() == 9) {
                return;
            }
            synchronized (g.this.f11082b) {
                if (g.this.f == null || g.this.e == null) {
                    z = false;
                } else {
                    if (!g.this.m && g.this.i.g) {
                        g.this.e.start();
                    }
                    g.this.f = null;
                    if (g.this.c != null) {
                        g.this.e.setSurface(g.this.c);
                    }
                    if (g.this.d != null) {
                        g.this.e.setDisplay(g.this.d);
                    }
                    if (g.this.f11081a != null && i.a().m()) {
                        g.this.f11081a.stopMonitor();
                        g.this.f11081a.startMonitor(g.this.e);
                    }
                    z = true;
                }
            }
            if (z || i.a().b() || g.this.i.i == 2) {
                String str = g.this.g;
                if (g.this.A != null && g.this.A.i() != null) {
                    str = g.this.A.i();
                }
                long c = f.a().c(str);
                if (c > 0) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer use record history progress, seekto:" + c);
                    g.this.e.seekTo(c);
                }
            }
            if (z && g.this.v != null) {
                g.this.v.a(10206, 0);
            }
            if (g.this.t != null && (!z || g.this.r.get() <= 2)) {
                g.this.r.set(3);
                g.this.t.b();
            }
            g.this.r.set(3);
        }
    };
    private IMediaPlayer.OnVideoSizeChangedListener K = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.kwai.video.ksvodplayerkit.g.5
        @Override // com.kwai.video.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            if (g.this.x != null) {
                g.this.x.a(i, i2, i3, i4);
            }
        }
    };
    private IMediaPlayer.OnBufferingUpdateListener L = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.kwai.video.ksvodplayerkit.g.6
        @Override // com.kwai.video.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            if (g.this.z != null) {
                g.this.z.a(i);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends AwesomeCacheCallback {

        /* renamed from: b  reason: collision with root package name */
        private com.kwai.video.ksvodplayerkit.b f11092b;
        private c c = new c();
        private boolean d = false;

        a(com.kwai.video.ksvodplayerkit.b bVar) {
            this.f11092b = bVar;
        }

        public void a(com.kwai.video.ksvodplayerkit.b bVar) {
            this.f11092b = bVar;
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            String str = null;
            this.c.f = acCallBackInfo.host;
            this.c.e = acCallBackInfo.currentUri;
            this.c.k = acCallBackInfo.transferConsumeMs;
            this.c.m = acCallBackInfo.kwaiSign;
            this.c.n = acCallBackInfo.xKsCache;
            this.c.o = acCallBackInfo.cdnStatJson;
            this.c.h = acCallBackInfo.sessionUUID;
            this.c.i = acCallBackInfo.downloadUUID;
            this.c.o = acCallBackInfo.cdnStatJson;
            this.c.j = acCallBackInfo.httpResponseCode;
            this.c.p = acCallBackInfo.errorCode;
            this.c.q = acCallBackInfo.stopReason;
            this.c.l = acCallBackInfo.transferConsumeMs;
            switch (acCallBackInfo.stopReason) {
                case 1:
                    if (this.f11092b != null && !this.d) {
                        this.c.r++;
                        this.f11092b.b(this.c);
                    }
                    if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && this.f11092b != null && !this.d) {
                        this.d = true;
                        this.f11092b.c(this.c);
                    }
                    g.this.i();
                    g.this.b(acCallBackInfo.cdnStatJson);
                    return;
                case 2:
                    if (this.f11092b != null) {
                        this.f11092b.e(this.c);
                    }
                    g.this.b(acCallBackInfo.cdnStatJson);
                    return;
                default:
                    g.this.b(acCallBackInfo.cdnStatJson);
                    String str2 = acCallBackInfo.currentUri;
                    if (g.this.i.i == 2) {
                        str2 = g.this.C != null ? g.this.C.f11048a : null;
                    }
                    f.a().a(str2, g.this.e != null ? g.this.e.getCurrentPosition() : 0L);
                    if (com.kwai.video.ksvodplayerkit.c.a.a(g.this.i.f11038a) && g.this.A != null) {
                        g.this.A.a(false);
                        if (g.this.A.f() > 0 && !g.this.A.e() && g.this.B.addAndGet(1) < i.a().e() && g.this.A.a()) {
                            if (g.this.i.i == 1) {
                                str = com.kwai.video.ksvodplayerkit.b.m.a(g.this.A.g());
                            } else if (g.this.i.i == 2) {
                                com.kwai.video.ksvodplayerkit.b.c h = g.this.A.h();
                                if (h != null) {
                                    str = com.kwai.video.ksvodplayerkit.b.d.a(h);
                                    g.this.h.put("Host", h.d);
                                }
                            } else {
                                g.this.h.put("Host", g.this.A.d());
                                str = g.this.A.b().f11028b;
                            }
                            if (str != null && g.this.a(str)) {
                                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + " refreshDataSource count:" + g.this.B.get() + ", new url:" + str);
                                return;
                            }
                        }
                    }
                    g.this.r.set(9);
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", already retry all urls, stop play");
                    if (this.f11092b != null) {
                        this.f11092b.d(this.c);
                        return;
                    }
                    return;
            }
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            this.c.d = acCallBackInfo.contentLength;
            this.c.c = acCallBackInfo.totalBytes;
            this.c.g = acCallBackInfo.ip;
            this.c.f11059a = acCallBackInfo.cachedBytes;
            this.c.f11060b = acCallBackInfo.progressPosition;
            if (this.c.f11060b <= 0 && acCallBackInfo.cachedBytes > 0) {
                this.c.f11060b = acCallBackInfo.cachedBytes;
            }
            if (this.f11092b != null) {
                this.f11092b.a(this.c);
            }
            if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && this.f11092b != null && !this.d) {
                this.d = true;
                this.f11092b.c(this.c);
                this.c.r++;
                this.f11092b.b(this.c);
            }
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "onSessionProgress ,cachedBytes:" + this.c.f11060b + ",mPreloadThresholdBytes:" + i.a().s());
            if (g.this.v == null || !this.c.a()) {
                return;
            }
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "notifyCanPreloadNext ,cachedBytes:" + this.c.f11060b + ",mTotalBytesOfSource:" + this.c.c);
            g.this.i();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f11093a;

        /* renamed from: b  reason: collision with root package name */
        public String f11094b;
        public String c;
        public long d;
        public String e;
        public long f;
        public long g;
        public long h;
    }

    public g(KSVodPlayerBuilder kSVodPlayerBuilder) {
        this.r.set(0);
        this.i = kSVodPlayerBuilder;
        this.g = this.i.f11039b;
        this.h = this.i.d;
        this.B.set(0);
        if (TextUtils.isEmpty(this.g) && ((this.i.c == null || this.i.c.isEmpty() || TextUtils.isEmpty(this.i.c.get(0))) && (this.i.h == null || this.i.h.f11051b == null || this.i.h.f11051b.isEmpty()))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Play url can't be null!");
        }
        if (this.h == null) {
            this.h = new HashMap();
        }
        if (this.i.k != null) {
            this.h.putAll(this.i.k);
        }
        if (this.i.i == 1 && this.i.h != null) {
            this.A = new com.kwai.video.ksvodplayerkit.HttpDns.d(this.i.h);
            try {
                this.g = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
            } catch (Exception e) {
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", e);
            }
            this.g = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
        } else if (this.i.i == 2) {
            this.A = new com.kwai.video.ksvodplayerkit.HttpDns.d(this.g);
            com.kwai.video.ksvodplayerkit.b.c h = this.A.h();
            try {
                this.g = com.kwai.video.ksvodplayerkit.b.d.a(h);
            } catch (Exception e2) {
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", e2);
            }
            this.h.put("Host", h.d);
        } else {
            this.g = this.g != null ? this.g : this.i.c.get(0);
            if (com.kwai.video.ksvodplayerkit.c.c.a(this.g) && !f.a().b(this.g)) {
                ArrayList arrayList = new ArrayList();
                if (this.i.c == null || this.i.c.isEmpty()) {
                    arrayList.add(this.g);
                } else {
                    arrayList.addAll(this.i.c);
                }
                this.A = new com.kwai.video.ksvodplayerkit.HttpDns.d(arrayList);
                if (this.A.b() != null && !TextUtils.isEmpty(this.A.b().f11028b)) {
                    this.g = this.A.b().f11028b;
                    this.h.put("Host", this.A.d());
                }
            }
        }
        if (this.g == null) {
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", new Exception("new KSVodPlayer"));
        }
        this.e = a(this.i.a());
        this.r.set(1);
    }

    private IKwaiMediaPlayer a(KwaiPlayerVodBuilder kwaiPlayerVodBuilder) {
        kwaiPlayerVodBuilder.setUseNatvieCache(true).setStartOnPrepared(false).setOverlayFormat(PlayerSettingConstants.SDL_FCC_RV32).setEnableAccurateSeek(true).setStartOnPrepared(this.i.n).setHevcDcoderName(KwaiPlayerBaseBuilder.HEVC_DECODER_NAME_KS265);
        if (this.i.o > 0) {
            kwaiPlayerVodBuilder.seekAtStart(this.i.o);
        }
        if (this.i.l != null) {
            kwaiPlayerVodBuilder.setProductContext(new ProductContext.Builder().setBizType(this.i.l).setPlayIndex(this.B.get()).build());
        }
        if (this.i.f == KSVodPlayerBuilder.VodPlayEnterType.CLICK) {
            kwaiPlayerVodBuilder.setMaxBufferStrategy(1).setMaxBufferTimeBspMs(i.a().r()).setStartPlayBlockBufferMs(i.a().c(), i.a().d());
        } else if (this.i.f == KSVodPlayerBuilder.VodPlayEnterType.SLIDE) {
            kwaiPlayerVodBuilder.setPreLoadDurationMs(1, i.a().f());
        }
        if (i.a().g()) {
            kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
        }
        if (i.a().h()) {
            kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
        }
        if (this.i.m != null) {
            com.kwai.video.ksvodplayerkit.c.b bVar = this.i.m;
            kwaiPlayerVodBuilder.setUseMediaCodecByteBuffer(bVar.f11061a);
            if (bVar.f11062b) {
                kwaiPlayerVodBuilder.setMediaCodecAvcHeightLimit(bVar.d);
                kwaiPlayerVodBuilder.setMediaCodecAvcWidthLimit(bVar.c);
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
            }
            if (bVar.e) {
                kwaiPlayerVodBuilder.setMediaCodecHevcHeightLimit(bVar.d);
                kwaiPlayerVodBuilder.setMediaCodecHevcWidthLimit(bVar.c);
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
            }
            if (bVar.f11062b && bVar.e) {
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(4096);
            }
            if (bVar.f > 0) {
                kwaiPlayerVodBuilder.setMediaCodecMaxNum(bVar.f);
            }
        }
        if (this.i.i == 1 && this.i.h != null) {
            kwaiPlayerVodBuilder.setVodManifest(com.kwai.video.ksvodplayerkit.c.a.d(this.i.f11038a), com.kwai.video.ksvodplayerkit.c.c.a(this.i.f11038a), com.kwai.video.ksvodplayerkit.c.c.b(this.i.f11038a), i.a().k(), i.a().l(), 0);
        } else if (this.i.i == 2) {
            kwaiPlayerVodBuilder.setEnableAccurateSeek(false).setEnableSegmentCache(true).setEnableSeekForwardOffset(true);
            if (this.i.j >= 0) {
                a(this.i.j);
            }
        } else {
            kwaiPlayerVodBuilder.setCacheKey(f.a().a(this.g));
        }
        if (i.a().b() && this.i.i == 0) {
            long c = f.a().c(this.g);
            if (c > 0) {
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer use record history progress, seekto:" + c);
                kwaiPlayerVodBuilder.seekAtStart(c);
            }
        }
        if (com.kwai.video.ksvodplayerkit.c.c.b(this.g)) {
            kwaiPlayerVodBuilder.setEnableAccurateSeek(false);
        }
        IKwaiMediaPlayer build = kwaiPlayerVodBuilder.build();
        build.setLooping(this.j);
        AspectAwesomeCache aspectAwesomeCache = build.getAspectAwesomeCache();
        aspectAwesomeCache.setCacheDownloadReadTimeoutMs(i.a().p());
        aspectAwesomeCache.setCacheDownloadConnectTimeoutMs(i.a().o());
        aspectAwesomeCache.setBufferedDataSourceSizeKB(i.a().q());
        this.y = new a(this.w);
        aspectAwesomeCache.setAwesomeCacheCallback(this.y);
        if (i.a().i()) {
            aspectAwesomeCache.setDataSourceType(0);
        }
        if (com.kwai.video.ksvodplayerkit.c.c.b(this.g)) {
            aspectAwesomeCache.setDataSourceType(2);
        }
        if (i.a().n() > 0) {
            aspectAwesomeCache.setCacheSocketBufferSizeKb(i.a().n());
        }
        build.setOnPreparedListener(this.J);
        build.setOnInfoListener(this.H);
        build.setOnErrorListener(this.I);
        build.setOnVideoSizeChangedListener(this.K);
        build.setOnSeekCompleteListener(this.G);
        build.setOnBufferingUpdateListener(this.L);
        if (!TextUtils.isEmpty(this.g)) {
            try {
                if (this.i.i == 2) {
                    build.setKwaiManifest(this.C != null ? this.C.f11048a : "no_prefer_url", this.g, this.h);
                } else {
                    build.setDataSource(this.g, this.h);
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer, url:" + this.g);
            } catch (IOException e) {
                e.printStackTrace();
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "setDataSource error", new Exception("setDataSource"));
            }
        }
        if (this.c != null) {
            build.setSurface(this.c);
        }
        if (this.d != null) {
            build.setDisplay(this.d);
        }
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KwaiPlayerResultQos kwaiPlayerResultQos) {
        String str = kwaiPlayerResultQos.videoStatJson;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("qos", str);
        if (this.i.e != null) {
            b bVar = new b();
            bVar.c = this.i.e.c;
            bVar.f11094b = this.i.e.f11105b;
            bVar.f11093a = this.i.e.f11104a;
            bVar.e = this.i.e.e;
            bVar.d = this.l;
            bVar.f = this.E;
            bVar.g = this.F;
            bVar.h = this.i.e.d;
            jSONObject.put("stats", m.a(bVar));
            com.kwai.video.ksvodplayerkit.d.g a2 = com.kwai.video.ksvodplayerkit.d.c.a().a(this.i.e.c);
            if (a2 != null) {
                jSONObject.put("prefetch", com.kwai.video.ksvodplayerkit.d.h.a(a2));
            }
        }
        String jSONObject2 = jSONObject.toString();
        com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "logVideoStatJson VP_PLAYFINISHED；" + jSONObject2);
        com.kwai.video.ksvodplayerkit.a.c.a(jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        synchronized (this.f11082b) {
            if (this.e != null) {
                this.e.setOnErrorListener(null);
                this.e.setOnPreparedListener(null);
                this.e.setOnVideoSizeChangedListener(null);
                this.e.setOnInfoListener(null);
                this.e.setOnBufferingUpdateListener(null);
                this.e.releaseAsync();
                this.e = null;
            }
            this.g = str;
            this.f = a(this.i.a());
            if (this.n != 1.0f || this.o != 1.0f) {
                this.f.setVolume(this.n, this.o);
            }
            if (this.k != 0) {
                this.f.setVideoScalingMode(this.k);
            }
            this.r.set(2);
            this.f.prepareAsync();
            this.e = this.f;
        }
        if (this.v != null) {
            this.v.a(10205, 0);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (str == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qos", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rank", this.A != null ? this.A.c() : 0);
            jSONObject.put("stats", jSONObject2.toString());
            jSONObject.put("resource_type", "video");
            String jSONObject3 = jSONObject.toString();
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "logVideoStatJson VP_CDN_RESOURCE：" + jSONObject3);
            com.kwai.video.ksvodplayerkit.a.c.b(jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.v != null) {
            this.v.a(10209, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        if (!com.kwai.video.ksvodplayerkit.c.a.a(this.i.f11038a) || this.B.addAndGet(1) >= i.a().e()) {
            return false;
        }
        return g();
    }

    public int a() {
        int i = 0;
        synchronized (this.f11082b) {
            if (this.e == null || !(this.r.get() == 1 || this.r.get() == 7)) {
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "prepareAsync error, playback state:" + this.r.get() + ",mCurrentPlayer == null:" + (this.e == null), new Exception("prepareAsync"));
                i = -1;
            } else {
                if (this.E == 0) {
                    this.E = System.currentTimeMillis();
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "prepareAsync");
                this.r.set(2);
                this.e.prepareAsync();
                if (this.i.h != null) {
                    this.A.a(this.e.getVodAdaptiveUrl());
                    if (i.a().b()) {
                        long c = f.a().c(this.e.getVodAdaptiveUrl());
                        if (c > 0) {
                            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "prepareAsync, multi rate use history play progress");
                            this.e.seekTo(c);
                        }
                    }
                }
            }
        }
        return i;
    }

    public void a(float f) {
        synchronized (this.f11082b) {
            if (this.e != null) {
                this.e.setSpeed(f);
            }
        }
    }

    public void a(float f, float f2) {
        synchronized (this.f11082b) {
            if (this.e != null) {
                this.e.setVolume(f, f2);
            }
            this.n = f;
            this.o = f2;
        }
    }

    public void a(int i) {
        com.kwai.video.ksvodplayerkit.b.c h;
        synchronized (this.f11082b) {
            if (this.i.i == 2 && (h = this.A.h()) != null && h.c != null) {
                Iterator<com.kwai.video.ksvodplayerkit.b.f> it = h.c.f11047a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.kwai.video.ksvodplayerkit.b.f next = it.next();
                    if (next.g == i) {
                        this.C = next;
                        break;
                    }
                }
                if (this.C == null) {
                    this.C = h.c.f11047a.get(0);
                }
                if (this.C != null) {
                    this.A.a(this.C.f11048a);
                }
            }
        }
    }

    public void a(long j) {
        synchronized (this.f11082b) {
            if (this.e != null) {
                this.p = true;
                this.e.seekTo(j);
            }
        }
    }

    public void a(Surface surface) {
        synchronized (this.f11082b) {
            this.c = surface;
            if (this.e != null) {
                this.e.setSurface(this.c);
            }
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            return;
        }
        synchronized (this.f11082b) {
            this.d = surfaceHolder;
            if (this.e != null) {
                this.e.setDisplay(this.d);
            }
        }
    }

    public void a(com.kwai.video.ksvodplayerkit.b bVar) {
        this.w = bVar;
        if (this.e != null && bVar != null) {
            if (this.y != null) {
                this.y.a(this.w);
            } else {
                this.y = new a(this.w);
            }
            this.e.getAspectAwesomeCache().setAwesomeCacheCallback(this.y);
        }
        if (bVar == null) {
            this.y = null;
        }
    }

    public void a(d.a aVar) {
        this.z = aVar;
    }

    public void a(d.b bVar) {
        this.u = bVar;
    }

    public void a(d.c cVar) {
        this.v = cVar;
    }

    public void a(d.InterfaceC1167d interfaceC1167d) {
        this.t = interfaceC1167d;
    }

    public void a(d.e eVar) {
        this.x = eVar;
    }

    public void a(d.f fVar) {
        a(true, fVar);
    }

    public void a(l lVar) {
        synchronized (this.f11082b) {
            this.i.e = lVar;
        }
    }

    public void a(KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView) {
        this.f11081a = kwaiPlayerDebugInfoView;
        if (i.a().m()) {
            this.f11081a.setVisibility(0);
        }
    }

    public void a(boolean z) {
        synchronized (this.f11082b) {
            if (this.e != null) {
                this.j = z;
                this.e.setLooping(z);
            }
        }
    }

    public void a(final boolean z, final d.f fVar) {
        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "releaseAsync,needReportQos:" + z);
        this.r.set(9);
        OnPlayerReleaseListener onPlayerReleaseListener = new OnPlayerReleaseListener() { // from class: com.kwai.video.ksvodplayerkit.g.7
            @Override // com.kwai.player.OnPlayerReleaseListener
            public void onRelease(KwaiPlayerResultQos kwaiPlayerResultQos) {
                synchronized (g.this.f11082b) {
                    if (g.this.D) {
                        com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayer", "logVideoStatJson already reported!");
                        return;
                    }
                    g.this.D = true;
                    if (fVar != null) {
                        fVar.a();
                    }
                    if (z) {
                        try {
                            g.this.a(kwaiPlayerResultQos);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        synchronized (this.f11082b) {
            if (this.e != null) {
                this.e.setOnPreparedListener(null);
                this.e.setOnInfoListener(null);
                this.e.setOnErrorListener(null);
                this.e.setOnVideoSizeChangedListener(null);
                this.e.setOnSeekCompleteListener(null);
                this.e.setOnBufferingUpdateListener(null);
                this.e.releaseAsync(onPlayerReleaseListener);
                this.e = null;
            }
        }
    }

    public void b(boolean z) {
    }

    public boolean b() {
        synchronized (this.f11082b) {
            if (this.e != null) {
                return this.e.isPlaying();
            }
            return false;
        }
    }

    public long c() {
        synchronized (this.f11082b) {
            if (this.e != null) {
                return this.e.getCurrentPosition();
            }
            return 0L;
        }
    }

    public long d() {
        synchronized (this.f11082b) {
            if (this.e != null) {
                return this.e.getDuration();
            }
            return -1L;
        }
    }

    public void e() {
        synchronized (this.f11082b) {
            if (this.e != null && !this.e.isPlaying()) {
                if (this.F == 0) {
                    this.F = System.currentTimeMillis();
                }
                if (this.f11081a != null && i.a().m()) {
                    this.f11081a.startMonitor(this.e);
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "start");
                this.e.start();
            }
        }
        if (e.a(this.g)) {
            i();
        }
    }

    public void f() {
        synchronized (this.f11082b) {
            if (this.e != null && this.e.isPlaying()) {
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "pause");
                this.e.pause();
            }
        }
    }

    public boolean g() {
        String str;
        if (this.r.get() != 9) {
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "refreshDataSource failed! last player not finish!");
            return false;
        }
        if (this.A != null) {
            this.A.a(true);
            if (this.A.f() > 0) {
                if (this.i.h != null) {
                    str = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
                } else {
                    if (this.h == null) {
                        this.h = new HashMap();
                    }
                    this.h.put("Host", this.A.d());
                    str = this.A.b().f11028b;
                }
                if (str != null && a(str)) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "refreshDataSource success!");
                    return true;
                }
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "refreshDataSource failed! dns url error:" + str);
            }
        }
        com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "refreshDataSource failed, dns failed or already try all urls!");
        return false;
    }

    public IKwaiMediaPlayer h() {
        if (this.e != null) {
            return this.e;
        }
        return null;
    }
}
