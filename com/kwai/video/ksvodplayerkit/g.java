package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g implements d {
    public com.kwai.video.ksvodplayerkit.HttpDns.d A;
    public com.kwai.video.ksvodplayerkit.b.f C;
    public long E;
    public long F;

    /* renamed from: a  reason: collision with root package name */
    public KwaiPlayerDebugInfoView f38198a;

    /* renamed from: c  reason: collision with root package name */
    public Surface f38200c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceHolder f38201d;

    /* renamed from: e  reason: collision with root package name */
    public IKwaiMediaPlayer f38202e;

    /* renamed from: f  reason: collision with root package name */
    public IKwaiMediaPlayer f38203f;

    /* renamed from: g  reason: collision with root package name */
    public String f38204g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f38205h;

    /* renamed from: i  reason: collision with root package name */
    public KSVodPlayerBuilder f38206i;
    public boolean j;
    public d.InterfaceC0455d t;
    public d.b u;
    public d.c v;
    public com.kwai.video.ksvodplayerkit.b w;
    public d.e x;
    public a y;
    public d.a z;

    /* renamed from: b  reason: collision with root package name */
    public final Object f38199b = new Object();
    public int k = 0;
    public long l = -1;
    public boolean m = true;
    public float n = 1.0f;
    public float o = 1.0f;
    public boolean p = false;
    public boolean q = false;
    public AtomicInteger r = new AtomicInteger();
    public boolean s = false;
    public AtomicInteger B = new AtomicInteger();
    public boolean D = false;
    public IMediaPlayer.OnSeekCompleteListener G = new IMediaPlayer.OnSeekCompleteListener() { // from class: com.kwai.video.ksvodplayerkit.g.1
        @Override // com.kwai.video.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            if (g.this.v != null) {
                g.this.v.a(10100, 0);
            }
        }
    };
    public IMediaPlayer.OnInfoListener H = new IMediaPlayer.OnInfoListener() { // from class: com.kwai.video.ksvodplayerkit.g.2
        @Override // com.kwai.video.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i2, int i3) {
            if (i2 == 3) {
                synchronized (g.this.f38199b) {
                    if (g.this.f38206i.f38090e != null) {
                        g.this.l = System.currentTimeMillis() - g.this.f38206i.f38090e.f38255d;
                    }
                }
                if (g.this.v != null) {
                    g.this.v.a(10207, 0);
                }
                i2 = 3;
            } else if (i2 == 10101) {
                if (g.this.r.get() != 6 && g.this.v != null) {
                    g.this.v.a(10208, 0);
                    g.this.q = true;
                }
                g.this.r.set(6);
                i2 = PlayerPostEvent.MEDIA_INFO_PLAY_TO_END;
            } else if (i2 == 10103) {
                g.this.m = i3 == 5;
                if (i3 == 6 && g.this.r.get() != 6) {
                    if (g.this.v != null) {
                        g.this.v.a(10208, 0);
                    }
                    g.this.q = true;
                }
                g.this.r.set(i3);
            } else if (i2 == 701) {
                i2 = 701;
            } else if (i2 != 702) {
                switch (i2) {
                    case 10001:
                        i2 = 10001;
                        break;
                    case 10002:
                        i2 = 10002;
                        break;
                    case 10003:
                        i2 = 10003;
                        if (!g.this.p && g.this.q && g.this.v != null) {
                            g.this.v.a(10207, 0);
                            g.this.q = false;
                        }
                        g.this.p = false;
                        break;
                    case 10004:
                        i2 = 10004;
                        break;
                }
            } else {
                i2 = 702;
            }
            if (g.this.v != null) {
                g.this.v.a(i2, i3);
            }
            return false;
        }
    };
    public IMediaPlayer.OnErrorListener I = new IMediaPlayer.OnErrorListener() { // from class: com.kwai.video.ksvodplayerkit.g.3
        @Override // com.kwai.video.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i2, int i3) {
            boolean z;
            g.this.r.set(9);
            if (i2 == -23120 && i3 == -3120) {
                z = g.this.j();
                Log.e("KSVodPlayer", "onError what: " + i2 + " extra: " + i3 + " retry: " + z + " retryCount: " + g.this.B.get());
            } else {
                z = false;
            }
            if (g.this.u != null && !z) {
                g.this.u.b(i2, i3);
            }
            return false;
        }
    };
    public IMediaPlayer.OnPreparedListener J = new IMediaPlayer.OnPreparedListener() { // from class: com.kwai.video.ksvodplayerkit.g.4
        @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            boolean z;
            if (g.this.r.get() == 9) {
                return;
            }
            synchronized (g.this.f38199b) {
                if (g.this.f38203f == null || g.this.f38202e == null) {
                    z = false;
                } else {
                    if (!g.this.m && g.this.f38206i.f38092g) {
                        g.this.f38202e.start();
                    }
                    g.this.f38203f = null;
                    if (g.this.f38200c != null) {
                        g.this.f38202e.setSurface(g.this.f38200c);
                    }
                    if (g.this.f38201d != null) {
                        g.this.f38202e.setDisplay(g.this.f38201d);
                    }
                    z = true;
                    if (g.this.f38198a != null && i.a().m()) {
                        g.this.f38198a.stopMonitor();
                        g.this.f38198a.startMonitor(g.this.f38202e);
                    }
                }
            }
            if (z || i.a().b() || g.this.f38206i.f38094i == 2) {
                String str = g.this.f38204g;
                if (g.this.A != null && g.this.A.i() != null) {
                    str = g.this.A.i();
                }
                long c2 = f.a().c(str);
                if (c2 > 0) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer use record history progress, seekto:" + c2);
                    g.this.f38202e.seekTo(c2);
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
    public IMediaPlayer.OnVideoSizeChangedListener K = new IMediaPlayer.OnVideoSizeChangedListener() { // from class: com.kwai.video.ksvodplayerkit.g.5
        @Override // com.kwai.video.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i2, int i3, int i4, int i5) {
            if (g.this.x != null) {
                g.this.x.a(i2, i3, i4, i5);
            }
        }
    };
    public IMediaPlayer.OnBufferingUpdateListener L = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.kwai.video.ksvodplayerkit.g.6
        @Override // com.kwai.video.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i2) {
            if (g.this.z != null) {
                g.this.z.a(i2);
            }
        }
    };

    /* loaded from: classes7.dex */
    public class a extends AwesomeCacheCallback {

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.video.ksvodplayerkit.b f38217b;

        /* renamed from: c  reason: collision with root package name */
        public c f38218c = new c();

        /* renamed from: d  reason: collision with root package name */
        public boolean f38219d = false;

        public a(com.kwai.video.ksvodplayerkit.b bVar) {
            this.f38217b = bVar;
        }

        public void a(com.kwai.video.ksvodplayerkit.b bVar) {
            this.f38217b = bVar;
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            com.kwai.video.ksvodplayerkit.b bVar;
            String str;
            c cVar = this.f38218c;
            cVar.f38147f = acCallBackInfo.host;
            cVar.f38146e = acCallBackInfo.currentUri;
            int i2 = acCallBackInfo.transferConsumeMs;
            cVar.k = i2;
            cVar.m = acCallBackInfo.kwaiSign;
            cVar.n = acCallBackInfo.xKsCache;
            String str2 = acCallBackInfo.cdnStatJson;
            cVar.o = str2;
            cVar.f38149h = acCallBackInfo.sessionUUID;
            cVar.f38150i = acCallBackInfo.downloadUUID;
            cVar.o = str2;
            cVar.j = acCallBackInfo.httpResponseCode;
            cVar.p = acCallBackInfo.errorCode;
            int i3 = acCallBackInfo.stopReason;
            cVar.q = i3;
            cVar.l = i2;
            if (i3 == 1) {
                com.kwai.video.ksvodplayerkit.b bVar2 = this.f38217b;
                if (bVar2 != null && !this.f38219d) {
                    cVar.r++;
                    bVar2.b(cVar);
                }
                if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && (bVar = this.f38217b) != null && !this.f38219d) {
                    this.f38219d = true;
                    bVar.c(this.f38218c);
                }
                g.this.i();
            } else if (i3 != 2) {
                g.this.b(str2);
                String str3 = acCallBackInfo.currentUri;
                String str4 = null;
                if (g.this.f38206i.f38094i == 2) {
                    str3 = g.this.C != null ? g.this.C.f38106a : null;
                }
                f.a().a(str3, g.this.f38202e != null ? g.this.f38202e.getCurrentPosition() : 0L);
                if (com.kwai.video.ksvodplayerkit.c.a.a(g.this.f38206i.f38086a) && g.this.A != null) {
                    g.this.A.a(false);
                    if (g.this.A.f() > 0 && !g.this.A.e() && g.this.B.addAndGet(1) < i.a().e() && g.this.A.a()) {
                        if (g.this.f38206i.f38094i == 1) {
                            str = com.kwai.video.ksvodplayerkit.b.m.a(g.this.A.g());
                        } else if (g.this.f38206i.f38094i == 2) {
                            com.kwai.video.ksvodplayerkit.b.c h2 = g.this.A.h();
                            if (h2 != null) {
                                str4 = com.kwai.video.ksvodplayerkit.b.d.a(h2);
                                g.this.f38205h.put("Host", h2.f38104d);
                            }
                            str = str4;
                        } else {
                            g.this.f38205h.put("Host", g.this.A.d());
                            str = g.this.A.b().f38063b;
                        }
                        if (str != null && g.this.a(str)) {
                            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + " refreshDataSource count:" + g.this.B.get() + ", new url:" + str);
                            return;
                        }
                    }
                }
                g.this.r.set(9);
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", already retry all urls, stop play");
                com.kwai.video.ksvodplayerkit.b bVar3 = this.f38217b;
                if (bVar3 != null) {
                    bVar3.d(this.f38218c);
                    return;
                }
                return;
            } else {
                com.kwai.video.ksvodplayerkit.b bVar4 = this.f38217b;
                if (bVar4 != null) {
                    bVar4.e(cVar);
                }
            }
            g.this.b(acCallBackInfo.cdnStatJson);
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            com.kwai.video.ksvodplayerkit.b bVar;
            c cVar = this.f38218c;
            cVar.f38145d = acCallBackInfo.contentLength;
            cVar.f38144c = acCallBackInfo.totalBytes;
            cVar.f38148g = acCallBackInfo.ip;
            long j = acCallBackInfo.cachedBytes;
            cVar.f38142a = j;
            long j2 = acCallBackInfo.progressPosition;
            cVar.f38143b = j2;
            if (j2 <= 0 && j > 0) {
                cVar.f38143b = j;
            }
            com.kwai.video.ksvodplayerkit.b bVar2 = this.f38217b;
            if (bVar2 != null) {
                bVar2.a(this.f38218c);
            }
            if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && (bVar = this.f38217b) != null && !this.f38219d) {
                this.f38219d = true;
                bVar.c(this.f38218c);
                c cVar2 = this.f38218c;
                cVar2.r++;
                this.f38217b.b(cVar2);
            }
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "onSessionProgress ,cachedBytes:" + this.f38218c.f38143b + ",mPreloadThresholdBytes:" + i.a().s());
            if (g.this.v == null || !this.f38218c.a()) {
                return;
            }
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "notifyCanPreloadNext ,cachedBytes:" + this.f38218c.f38143b + ",mTotalBytesOfSource:" + this.f38218c.f38144c);
            g.this.i();
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f38220a;

        /* renamed from: b  reason: collision with root package name */
        public String f38221b;

        /* renamed from: c  reason: collision with root package name */
        public String f38222c;

        /* renamed from: d  reason: collision with root package name */
        public long f38223d;

        /* renamed from: e  reason: collision with root package name */
        public String f38224e;

        /* renamed from: f  reason: collision with root package name */
        public long f38225f;

        /* renamed from: g  reason: collision with root package name */
        public long f38226g;

        /* renamed from: h  reason: collision with root package name */
        public long f38227h;
    }

    public g(KSVodPlayerBuilder kSVodPlayerBuilder) {
        com.kwai.video.ksvodplayerkit.b.h hVar;
        List<String> list;
        com.kwai.video.ksvodplayerkit.b.h hVar2;
        List<com.kwai.video.ksvodplayerkit.b.i> list2;
        this.r.set(0);
        this.f38206i = kSVodPlayerBuilder;
        this.f38204g = kSVodPlayerBuilder.f38087b;
        this.f38205h = kSVodPlayerBuilder.f38089d;
        this.B.set(0);
        if (TextUtils.isEmpty(this.f38204g) && (((list = this.f38206i.f38088c) == null || list.isEmpty() || TextUtils.isEmpty(this.f38206i.f38088c.get(0))) && ((hVar2 = this.f38206i.f38093h) == null || (list2 = hVar2.f38116b) == null || list2.isEmpty()))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Play url can't be null!");
        }
        if (this.f38205h == null) {
            this.f38205h = new HashMap();
        }
        Map<String, String> map = this.f38206i.k;
        if (map != null) {
            this.f38205h.putAll(map);
        }
        KSVodPlayerBuilder kSVodPlayerBuilder2 = this.f38206i;
        if (kSVodPlayerBuilder2.f38094i != 1 || (hVar = kSVodPlayerBuilder2.f38093h) == null) {
            KSVodPlayerBuilder kSVodPlayerBuilder3 = this.f38206i;
            if (kSVodPlayerBuilder3.f38094i == 2) {
                com.kwai.video.ksvodplayerkit.HttpDns.d dVar = new com.kwai.video.ksvodplayerkit.HttpDns.d(this.f38204g);
                this.A = dVar;
                com.kwai.video.ksvodplayerkit.b.c h2 = dVar.h();
                try {
                    this.f38204g = com.kwai.video.ksvodplayerkit.b.d.a(h2);
                } catch (Exception e2) {
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", e2);
                }
                this.f38205h.put("Host", h2.f38104d);
            } else {
                String str = this.f38204g;
                str = str == null ? kSVodPlayerBuilder3.f38088c.get(0) : str;
                this.f38204g = str;
                if (com.kwai.video.ksvodplayerkit.c.c.a(str) && !f.a().b(this.f38204g)) {
                    ArrayList arrayList = new ArrayList();
                    List<String> list3 = this.f38206i.f38088c;
                    if (list3 == null || list3.isEmpty()) {
                        arrayList.add(this.f38204g);
                    } else {
                        arrayList.addAll(this.f38206i.f38088c);
                    }
                    com.kwai.video.ksvodplayerkit.HttpDns.d dVar2 = new com.kwai.video.ksvodplayerkit.HttpDns.d(arrayList);
                    this.A = dVar2;
                    if (dVar2.b() != null && !TextUtils.isEmpty(this.A.b().f38063b)) {
                        this.f38204g = this.A.b().f38063b;
                        this.f38205h.put("Host", this.A.d());
                    }
                }
            }
        } else {
            com.kwai.video.ksvodplayerkit.HttpDns.d dVar3 = new com.kwai.video.ksvodplayerkit.HttpDns.d(hVar);
            this.A = dVar3;
            try {
                this.f38204g = com.kwai.video.ksvodplayerkit.b.m.a(dVar3.g());
            } catch (Exception e3) {
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", e3);
            }
            this.f38204g = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
        }
        if (this.f38204g == null) {
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", new Exception("new KSVodPlayer"));
        }
        this.f38202e = a(this.f38206i.a());
        this.r.set(1);
    }

    private IKwaiMediaPlayer a(KwaiPlayerVodBuilder kwaiPlayerVodBuilder) {
        kwaiPlayerVodBuilder.setUseNatvieCache(true).setStartOnPrepared(false).setOverlayFormat(PlayerSettingConstants.SDL_FCC_RV32).setEnableAccurateSeek(true).setStartOnPrepared(this.f38206i.n).setHevcDcoderName(KwaiPlayerBaseBuilder.HEVC_DECODER_NAME_KS265);
        long j = this.f38206i.o;
        if (j > 0) {
            kwaiPlayerVodBuilder.seekAtStart(j);
        }
        if (this.f38206i.l != null) {
            kwaiPlayerVodBuilder.setProductContext(new ProductContext.Builder().setBizType(this.f38206i.l).setPlayIndex(this.B.get()).build());
        }
        KSVodPlayerBuilder.VodPlayEnterType vodPlayEnterType = this.f38206i.f38091f;
        if (vodPlayEnterType == KSVodPlayerBuilder.VodPlayEnterType.CLICK) {
            kwaiPlayerVodBuilder.setMaxBufferStrategy(1).setMaxBufferTimeBspMs(i.a().r()).setStartPlayBlockBufferMs(i.a().c(), i.a().d());
        } else if (vodPlayEnterType == KSVodPlayerBuilder.VodPlayEnterType.SLIDE) {
            kwaiPlayerVodBuilder.setPreLoadDurationMs(1, i.a().f());
        }
        if (i.a().g()) {
            kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
        }
        if (i.a().h()) {
            kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
        }
        com.kwai.video.ksvodplayerkit.c.b bVar = this.f38206i.m;
        if (bVar != null) {
            kwaiPlayerVodBuilder.setUseMediaCodecByteBuffer(bVar.f38151a);
            if (bVar.f38152b) {
                kwaiPlayerVodBuilder.setMediaCodecAvcHeightLimit(bVar.f38154d);
                kwaiPlayerVodBuilder.setMediaCodecAvcWidthLimit(bVar.f38153c);
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
            }
            if (bVar.f38155e) {
                kwaiPlayerVodBuilder.setMediaCodecHevcHeightLimit(bVar.f38154d);
                kwaiPlayerVodBuilder.setMediaCodecHevcWidthLimit(bVar.f38153c);
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
            }
            if (bVar.f38152b && bVar.f38155e) {
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(4096);
            }
            int i2 = bVar.f38156f;
            if (i2 > 0) {
                kwaiPlayerVodBuilder.setMediaCodecMaxNum(i2);
            }
        }
        KSVodPlayerBuilder kSVodPlayerBuilder = this.f38206i;
        if (kSVodPlayerBuilder.f38094i == 1 && kSVodPlayerBuilder.f38093h != null) {
            kwaiPlayerVodBuilder.setVodManifest(com.kwai.video.ksvodplayerkit.c.a.d(kSVodPlayerBuilder.f38086a), com.kwai.video.ksvodplayerkit.c.c.a(this.f38206i.f38086a), com.kwai.video.ksvodplayerkit.c.c.b(this.f38206i.f38086a), i.a().k(), i.a().l(), 0);
        } else if (this.f38206i.f38094i == 2) {
            kwaiPlayerVodBuilder.setEnableAccurateSeek(false).setEnableSegmentCache(true).setEnableSeekForwardOffset(true);
            int i3 = this.f38206i.j;
            if (i3 >= 0) {
                a(i3);
            }
        } else {
            kwaiPlayerVodBuilder.setCacheKey(f.a().a(this.f38204g));
        }
        if (i.a().b() && this.f38206i.f38094i == 0) {
            long c2 = f.a().c(this.f38204g);
            if (c2 > 0) {
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer use record history progress, seekto:" + c2);
                kwaiPlayerVodBuilder.seekAtStart(c2);
            }
        }
        if (com.kwai.video.ksvodplayerkit.c.c.b(this.f38204g)) {
            kwaiPlayerVodBuilder.setEnableAccurateSeek(false);
        }
        IKwaiMediaPlayer build = kwaiPlayerVodBuilder.build();
        build.setLooping(this.j);
        AspectAwesomeCache aspectAwesomeCache = build.getAspectAwesomeCache();
        aspectAwesomeCache.setCacheDownloadReadTimeoutMs(i.a().p());
        aspectAwesomeCache.setCacheDownloadConnectTimeoutMs(i.a().o());
        aspectAwesomeCache.setBufferedDataSourceSizeKB(i.a().q());
        a aVar = new a(this.w);
        this.y = aVar;
        aspectAwesomeCache.setAwesomeCacheCallback(aVar);
        if (i.a().i()) {
            aspectAwesomeCache.setDataSourceType(0);
        }
        if (com.kwai.video.ksvodplayerkit.c.c.b(this.f38204g)) {
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
        if (!TextUtils.isEmpty(this.f38204g)) {
            try {
                if (this.f38206i.f38094i == 2) {
                    build.setKwaiManifest(this.C != null ? this.C.f38106a : "no_prefer_url", this.f38204g, this.f38205h);
                } else {
                    build.setDataSource(this.f38204g, this.f38205h);
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer, url:" + this.f38204g);
            } catch (IOException e2) {
                e2.printStackTrace();
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "setDataSource error", new Exception("setDataSource"));
            }
        }
        Surface surface = this.f38200c;
        if (surface != null) {
            build.setSurface(surface);
        }
        SurfaceHolder surfaceHolder = this.f38201d;
        if (surfaceHolder != null) {
            build.setDisplay(surfaceHolder);
        }
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(KwaiPlayerResultQos kwaiPlayerResultQos) {
        String str = kwaiPlayerResultQos.videoStatJson;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("qos", str);
        if (this.f38206i.f38090e != null) {
            b bVar = new b();
            l lVar = this.f38206i.f38090e;
            bVar.f38222c = lVar.f38254c;
            bVar.f38221b = lVar.f38253b;
            bVar.f38220a = lVar.f38252a;
            bVar.f38224e = lVar.f38256e;
            bVar.f38223d = this.l;
            bVar.f38225f = this.E;
            bVar.f38226g = this.F;
            bVar.f38227h = lVar.f38255d;
            jSONObject.put("stats", m.a(bVar));
            com.kwai.video.ksvodplayerkit.d.g a2 = com.kwai.video.ksvodplayerkit.d.c.a().a(this.f38206i.f38090e.f38254c);
            if (a2 != null) {
                jSONObject.put(PrefetchEvent.MODULE, com.kwai.video.ksvodplayerkit.d.h.a(a2));
            }
        }
        String jSONObject2 = jSONObject.toString();
        com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "logVideoStatJson VP_PLAYFINISHED；" + jSONObject2);
        com.kwai.video.ksvodplayerkit.a.c.a(jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                this.f38202e.setOnErrorListener(null);
                this.f38202e.setOnPreparedListener(null);
                this.f38202e.setOnVideoSizeChangedListener(null);
                this.f38202e.setOnInfoListener(null);
                this.f38202e.setOnBufferingUpdateListener(null);
                this.f38202e.releaseAsync();
                this.f38202e = null;
            }
            this.f38204g = str;
            this.f38203f = a(this.f38206i.a());
            if (this.n != 1.0f || this.o != 1.0f) {
                this.f38203f.setVolume(this.n, this.o);
            }
            if (this.k != 0) {
                this.f38203f.setVideoScalingMode(this.k);
            }
            this.r.set(2);
            this.f38203f.prepareAsync();
            this.f38202e = this.f38203f;
        }
        d.c cVar = this.v;
        if (cVar != null) {
            cVar.a(10205, 0);
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
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        d.c cVar = this.v;
        if (cVar != null) {
            cVar.a(10209, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        if (!com.kwai.video.ksvodplayerkit.c.a.a(this.f38206i.f38086a) || this.B.addAndGet(1) >= i.a().e()) {
            return false;
        }
        return g();
    }

    public int a() {
        synchronized (this.f38199b) {
            if (this.f38202e == null || !(this.r.get() == 1 || this.r.get() == 7)) {
                StringBuilder sb = new StringBuilder();
                sb.append("prepareAsync error, playback state:");
                sb.append(this.r.get());
                sb.append(",mCurrentPlayer == null:");
                sb.append(this.f38202e == null);
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", sb.toString(), new Exception("prepareAsync"));
                return -1;
            }
            if (this.E == 0) {
                this.E = System.currentTimeMillis();
            }
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "prepareAsync");
            this.r.set(2);
            this.f38202e.prepareAsync();
            if (this.f38206i.f38093h != null) {
                this.A.a(this.f38202e.getVodAdaptiveUrl());
                if (i.a().b()) {
                    long c2 = f.a().c(this.f38202e.getVodAdaptiveUrl());
                    if (c2 > 0) {
                        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "prepareAsync, multi rate use history play progress");
                        this.f38202e.seekTo(c2);
                    }
                }
            }
            return 0;
        }
    }

    public void a(float f2) {
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                this.f38202e.setSpeed(f2);
            }
        }
    }

    public void a(float f2, float f3) {
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                this.f38202e.setVolume(f2, f3);
            }
            this.n = f2;
            this.o = f3;
        }
    }

    public void a(int i2) {
        com.kwai.video.ksvodplayerkit.b.c h2;
        synchronized (this.f38199b) {
            if (this.f38206i.f38094i == 2 && (h2 = this.A.h()) != null && h2.f38103c != null) {
                Iterator<com.kwai.video.ksvodplayerkit.b.f> it = h2.f38103c.f38105a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.kwai.video.ksvodplayerkit.b.f next = it.next();
                    if (next.f38112g == i2) {
                        this.C = next;
                        break;
                    }
                }
                if (this.C == null) {
                    this.C = h2.f38103c.f38105a.get(0);
                }
                if (this.C != null) {
                    this.A.a(this.C.f38106a);
                }
            }
        }
    }

    public void a(long j) {
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                this.p = true;
                this.f38202e.seekTo(j);
            }
        }
    }

    public void a(Surface surface) {
        synchronized (this.f38199b) {
            this.f38200c = surface;
            if (this.f38202e != null) {
                this.f38202e.setSurface(surface);
            }
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            return;
        }
        synchronized (this.f38199b) {
            this.f38201d = surfaceHolder;
            if (this.f38202e != null) {
                this.f38202e.setDisplay(surfaceHolder);
            }
        }
    }

    public void a(com.kwai.video.ksvodplayerkit.b bVar) {
        this.w = bVar;
        if (this.f38202e != null && bVar != null) {
            a aVar = this.y;
            if (aVar != null) {
                aVar.a(bVar);
            } else {
                this.y = new a(bVar);
            }
            this.f38202e.getAspectAwesomeCache().setAwesomeCacheCallback(this.y);
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

    public void a(d.InterfaceC0455d interfaceC0455d) {
        this.t = interfaceC0455d;
    }

    public void a(d.e eVar) {
        this.x = eVar;
    }

    public void a(d.f fVar) {
        a(true, fVar);
    }

    public void a(l lVar) {
        synchronized (this.f38199b) {
            this.f38206i.f38090e = lVar;
        }
    }

    public void a(KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView) {
        this.f38198a = kwaiPlayerDebugInfoView;
        if (i.a().m()) {
            this.f38198a.setVisibility(0);
        }
    }

    public void a(boolean z) {
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                this.j = z;
                this.f38202e.setLooping(z);
            }
        }
    }

    public void a(final boolean z, final d.f fVar) {
        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "releaseAsync,needReportQos:" + z);
        this.r.set(9);
        OnPlayerReleaseListener onPlayerReleaseListener = new OnPlayerReleaseListener() { // from class: com.kwai.video.ksvodplayerkit.g.7
            @Override // com.kwai.player.OnPlayerReleaseListener
            public void onRelease(KwaiPlayerResultQos kwaiPlayerResultQos) {
                synchronized (g.this.f38199b) {
                    if (g.this.D) {
                        com.kwai.video.ksvodplayerkit.a.b.d("KSVodPlayer", "logVideoStatJson already reported!");
                        return;
                    }
                    g.this.D = true;
                    d.f fVar2 = fVar;
                    if (fVar2 != null) {
                        fVar2.a();
                    }
                    if (z) {
                        try {
                            g.this.a(kwaiPlayerResultQos);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        };
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                this.f38202e.setOnPreparedListener(null);
                this.f38202e.setOnInfoListener(null);
                this.f38202e.setOnErrorListener(null);
                this.f38202e.setOnVideoSizeChangedListener(null);
                this.f38202e.setOnSeekCompleteListener(null);
                this.f38202e.setOnBufferingUpdateListener(null);
                this.f38202e.releaseAsync(onPlayerReleaseListener);
                this.f38202e = null;
            }
        }
    }

    public void b(boolean z) {
    }

    public boolean b() {
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                return this.f38202e.isPlaying();
            }
            return false;
        }
    }

    public long c() {
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                return this.f38202e.getCurrentPosition();
            }
            return 0L;
        }
    }

    public long d() {
        synchronized (this.f38199b) {
            if (this.f38202e != null) {
                return this.f38202e.getDuration();
            }
            return -1L;
        }
    }

    public void e() {
        synchronized (this.f38199b) {
            if (this.f38202e != null && !this.f38202e.isPlaying()) {
                if (this.F == 0) {
                    this.F = System.currentTimeMillis();
                }
                if (this.f38198a != null && i.a().m()) {
                    this.f38198a.startMonitor(this.f38202e);
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", IntentConfig.START);
                this.f38202e.start();
            }
        }
        if (e.a(this.f38204g)) {
            i();
        }
    }

    public void f() {
        synchronized (this.f38199b) {
            if (this.f38202e != null && this.f38202e.isPlaying()) {
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "pause");
                this.f38202e.pause();
            }
        }
    }

    public boolean g() {
        String str;
        String str2;
        if (this.r.get() != 9) {
            str = "refreshDataSource failed! last player not finish!";
        } else {
            com.kwai.video.ksvodplayerkit.HttpDns.d dVar = this.A;
            if (dVar != null) {
                dVar.a(true);
                if (this.A.f() > 0) {
                    if (this.f38206i.f38093h != null) {
                        str2 = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
                    } else {
                        if (this.f38205h == null) {
                            this.f38205h = new HashMap();
                        }
                        this.f38205h.put("Host", this.A.d());
                        str2 = this.A.b().f38063b;
                    }
                    if (str2 != null && a(str2)) {
                        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "refreshDataSource success!");
                        return true;
                    }
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "refreshDataSource failed! dns url error:" + str2);
                }
            }
            str = "refreshDataSource failed, dns failed or already try all urls!";
        }
        com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", str);
        return false;
    }

    public IKwaiMediaPlayer h() {
        IKwaiMediaPlayer iKwaiMediaPlayer = this.f38202e;
        if (iKwaiMediaPlayer != null) {
            return iKwaiMediaPlayer;
        }
        return null;
    }
}
