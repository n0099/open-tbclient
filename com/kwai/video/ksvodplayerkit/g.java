package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
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
/* loaded from: classes6.dex */
public class g implements d {
    public com.kwai.video.ksvodplayerkit.HttpDns.d A;
    public com.kwai.video.ksvodplayerkit.b.f C;
    public long E;
    public long F;

    /* renamed from: a  reason: collision with root package name */
    public KwaiPlayerDebugInfoView f37613a;

    /* renamed from: c  reason: collision with root package name */
    public Surface f37615c;

    /* renamed from: d  reason: collision with root package name */
    public SurfaceHolder f37616d;

    /* renamed from: e  reason: collision with root package name */
    public IKwaiMediaPlayer f37617e;

    /* renamed from: f  reason: collision with root package name */
    public IKwaiMediaPlayer f37618f;

    /* renamed from: g  reason: collision with root package name */
    public String f37619g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f37620h;
    public KSVodPlayerBuilder i;
    public boolean j;
    public d.InterfaceC0466d t;
    public d.b u;
    public d.c v;
    public com.kwai.video.ksvodplayerkit.b w;
    public d.e x;
    public a y;
    public d.a z;

    /* renamed from: b  reason: collision with root package name */
    public final Object f37614b = new Object();
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
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (i == 3) {
                synchronized (g.this.f37614b) {
                    if (g.this.i.f37512e != null) {
                        g.this.l = System.currentTimeMillis() - g.this.i.f37512e.f37667d;
                    }
                }
                if (g.this.v != null) {
                    g.this.v.a(10207, 0);
                }
                i = 3;
            } else if (i == 10101) {
                if (g.this.r.get() != 6 && g.this.v != null) {
                    g.this.v.a(10208, 0);
                    g.this.q = true;
                }
                g.this.r.set(6);
                i = PlayerPostEvent.MEDIA_INFO_PLAY_TO_END;
            } else if (i == 10103) {
                g.this.m = i2 == 5;
                if (i2 == 6 && g.this.r.get() != 6) {
                    if (g.this.v != null) {
                        g.this.v.a(10208, 0);
                    }
                    g.this.q = true;
                }
                g.this.r.set(i2);
            } else if (i == 701) {
                i = 701;
            } else if (i != 702) {
                switch (i) {
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
                }
            } else {
                i = 702;
            }
            if (g.this.v != null) {
                g.this.v.a(i, i2);
            }
            return false;
        }
    };
    public IMediaPlayer.OnErrorListener I = new IMediaPlayer.OnErrorListener() { // from class: com.kwai.video.ksvodplayerkit.g.3
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
    public IMediaPlayer.OnPreparedListener J = new IMediaPlayer.OnPreparedListener() { // from class: com.kwai.video.ksvodplayerkit.g.4
        @Override // com.kwai.video.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            boolean z;
            if (g.this.r.get() == 9) {
                return;
            }
            synchronized (g.this.f37614b) {
                if (g.this.f37618f == null || g.this.f37617e == null) {
                    z = false;
                } else {
                    if (!g.this.m && g.this.i.f37514g) {
                        g.this.f37617e.start();
                    }
                    g.this.f37618f = null;
                    if (g.this.f37615c != null) {
                        g.this.f37617e.setSurface(g.this.f37615c);
                    }
                    if (g.this.f37616d != null) {
                        g.this.f37617e.setDisplay(g.this.f37616d);
                    }
                    z = true;
                    if (g.this.f37613a != null && i.a().m()) {
                        g.this.f37613a.stopMonitor();
                        g.this.f37613a.startMonitor(g.this.f37617e);
                    }
                }
            }
            if (z || i.a().b() || g.this.i.i == 2) {
                String str = g.this.f37619g;
                if (g.this.A != null && g.this.A.i() != null) {
                    str = g.this.A.i();
                }
                long c2 = f.a().c(str);
                if (c2 > 0) {
                    com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer use record history progress, seekto:" + c2);
                    g.this.f37617e.seekTo(c2);
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
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            if (g.this.x != null) {
                g.this.x.a(i, i2, i3, i4);
            }
        }
    };
    public IMediaPlayer.OnBufferingUpdateListener L = new IMediaPlayer.OnBufferingUpdateListener() { // from class: com.kwai.video.ksvodplayerkit.g.6
        @Override // com.kwai.video.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            if (g.this.z != null) {
                g.this.z.a(i);
            }
        }
    };

    /* loaded from: classes6.dex */
    public class a extends AwesomeCacheCallback {

        /* renamed from: b  reason: collision with root package name */
        public com.kwai.video.ksvodplayerkit.b f37631b;

        /* renamed from: c  reason: collision with root package name */
        public c f37632c = new c();

        /* renamed from: d  reason: collision with root package name */
        public boolean f37633d = false;

        public a(com.kwai.video.ksvodplayerkit.b bVar) {
            this.f37631b = bVar;
        }

        public void a(com.kwai.video.ksvodplayerkit.b bVar) {
            this.f37631b = bVar;
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onDownloadFinish(AcCallBackInfo acCallBackInfo) {
            com.kwai.video.ksvodplayerkit.b bVar;
            String str;
            c cVar = this.f37632c;
            cVar.f37565f = acCallBackInfo.host;
            cVar.f37564e = acCallBackInfo.currentUri;
            int i = acCallBackInfo.transferConsumeMs;
            cVar.k = i;
            cVar.m = acCallBackInfo.kwaiSign;
            cVar.n = acCallBackInfo.xKsCache;
            String str2 = acCallBackInfo.cdnStatJson;
            cVar.o = str2;
            cVar.f37567h = acCallBackInfo.sessionUUID;
            cVar.i = acCallBackInfo.downloadUUID;
            cVar.o = str2;
            cVar.j = acCallBackInfo.httpResponseCode;
            cVar.p = acCallBackInfo.errorCode;
            int i2 = acCallBackInfo.stopReason;
            cVar.q = i2;
            cVar.l = i;
            if (i2 == 1) {
                com.kwai.video.ksvodplayerkit.b bVar2 = this.f37631b;
                if (bVar2 != null && !this.f37633d) {
                    cVar.r++;
                    bVar2.b(cVar);
                }
                if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && (bVar = this.f37631b) != null && !this.f37633d) {
                    this.f37633d = true;
                    bVar.c(this.f37632c);
                }
                g.this.i();
            } else if (i2 != 2) {
                g.this.b(str2);
                String str3 = acCallBackInfo.currentUri;
                String str4 = null;
                if (g.this.i.i == 2) {
                    str3 = g.this.C != null ? g.this.C.f37527a : null;
                }
                f.a().a(str3, g.this.f37617e != null ? g.this.f37617e.getCurrentPosition() : 0L);
                if (com.kwai.video.ksvodplayerkit.c.a.a(g.this.i.f37508a) && g.this.A != null) {
                    g.this.A.a(false);
                    if (g.this.A.f() > 0 && !g.this.A.e() && g.this.B.addAndGet(1) < i.a().e() && g.this.A.a()) {
                        if (g.this.i.i == 1) {
                            str = com.kwai.video.ksvodplayerkit.b.m.a(g.this.A.g());
                        } else if (g.this.i.i == 2) {
                            com.kwai.video.ksvodplayerkit.b.c h2 = g.this.A.h();
                            if (h2 != null) {
                                str4 = com.kwai.video.ksvodplayerkit.b.d.a(h2);
                                g.this.f37620h.put("Host", h2.f37525d);
                            }
                            str = str4;
                        } else {
                            g.this.f37620h.put("Host", g.this.A.d());
                            str = g.this.A.b().f37486b;
                        }
                        if (str != null && g.this.a(str)) {
                            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + " refreshDataSource count:" + g.this.B.get() + ", new url:" + str);
                            return;
                        }
                    }
                }
                g.this.r.set(9);
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "onDownloadFinish stop_reason:" + acCallBackInfo.stopReason + ", already retry all urls, stop play");
                com.kwai.video.ksvodplayerkit.b bVar3 = this.f37631b;
                if (bVar3 != null) {
                    bVar3.d(this.f37632c);
                    return;
                }
                return;
            } else {
                com.kwai.video.ksvodplayerkit.b bVar4 = this.f37631b;
                if (bVar4 != null) {
                    bVar4.e(cVar);
                }
            }
            g.this.b(acCallBackInfo.cdnStatJson);
        }

        @Override // com.kwai.video.cache.AwesomeCacheCallback
        public void onSessionProgress(AcCallBackInfo acCallBackInfo) {
            com.kwai.video.ksvodplayerkit.b bVar;
            c cVar = this.f37632c;
            cVar.f37563d = acCallBackInfo.contentLength;
            cVar.f37562c = acCallBackInfo.totalBytes;
            cVar.f37566g = acCallBackInfo.ip;
            long j = acCallBackInfo.cachedBytes;
            cVar.f37560a = j;
            long j2 = acCallBackInfo.progressPosition;
            cVar.f37561b = j2;
            if (j2 <= 0 && j > 0) {
                cVar.f37561b = j;
            }
            com.kwai.video.ksvodplayerkit.b bVar2 = this.f37631b;
            if (bVar2 != null) {
                bVar2.a(this.f37632c);
            }
            if (acCallBackInfo.progressPosition >= acCallBackInfo.totalBytes && (bVar = this.f37631b) != null && !this.f37633d) {
                this.f37633d = true;
                bVar.c(this.f37632c);
                c cVar2 = this.f37632c;
                cVar2.r++;
                this.f37631b.b(cVar2);
            }
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "onSessionProgress ,cachedBytes:" + this.f37632c.f37561b + ",mPreloadThresholdBytes:" + i.a().s());
            if (g.this.v == null || !this.f37632c.a()) {
                return;
            }
            com.kwai.video.ksvodplayerkit.a.b.c("KSVodPlayer", "notifyCanPreloadNext ,cachedBytes:" + this.f37632c.f37561b + ",mTotalBytesOfSource:" + this.f37632c.f37562c);
            g.this.i();
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f37634a;

        /* renamed from: b  reason: collision with root package name */
        public String f37635b;

        /* renamed from: c  reason: collision with root package name */
        public String f37636c;

        /* renamed from: d  reason: collision with root package name */
        public long f37637d;

        /* renamed from: e  reason: collision with root package name */
        public String f37638e;

        /* renamed from: f  reason: collision with root package name */
        public long f37639f;

        /* renamed from: g  reason: collision with root package name */
        public long f37640g;

        /* renamed from: h  reason: collision with root package name */
        public long f37641h;
    }

    public g(KSVodPlayerBuilder kSVodPlayerBuilder) {
        com.kwai.video.ksvodplayerkit.b.h hVar;
        List<String> list;
        com.kwai.video.ksvodplayerkit.b.h hVar2;
        List<com.kwai.video.ksvodplayerkit.b.i> list2;
        this.r.set(0);
        this.i = kSVodPlayerBuilder;
        this.f37619g = kSVodPlayerBuilder.f37509b;
        this.f37620h = kSVodPlayerBuilder.f37511d;
        this.B.set(0);
        if (TextUtils.isEmpty(this.f37619g) && (((list = this.i.f37510c) == null || list.isEmpty() || TextUtils.isEmpty(this.i.f37510c.get(0))) && ((hVar2 = this.i.f37515h) == null || (list2 = hVar2.f37536b) == null || list2.isEmpty()))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Play url can't be null!");
        }
        if (this.f37620h == null) {
            this.f37620h = new HashMap();
        }
        Map<String, String> map = this.i.k;
        if (map != null) {
            this.f37620h.putAll(map);
        }
        KSVodPlayerBuilder kSVodPlayerBuilder2 = this.i;
        if (kSVodPlayerBuilder2.i != 1 || (hVar = kSVodPlayerBuilder2.f37515h) == null) {
            KSVodPlayerBuilder kSVodPlayerBuilder3 = this.i;
            if (kSVodPlayerBuilder3.i == 2) {
                com.kwai.video.ksvodplayerkit.HttpDns.d dVar = new com.kwai.video.ksvodplayerkit.HttpDns.d(this.f37619g);
                this.A = dVar;
                com.kwai.video.ksvodplayerkit.b.c h2 = dVar.h();
                try {
                    this.f37619g = com.kwai.video.ksvodplayerkit.b.d.a(h2);
                } catch (Exception e2) {
                    com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", e2);
                }
                this.f37620h.put("Host", h2.f37525d);
            } else {
                String str = this.f37619g;
                str = str == null ? kSVodPlayerBuilder3.f37510c.get(0) : str;
                this.f37619g = str;
                if (com.kwai.video.ksvodplayerkit.c.c.a(str) && !f.a().b(this.f37619g)) {
                    ArrayList arrayList = new ArrayList();
                    List<String> list3 = this.i.f37510c;
                    if (list3 == null || list3.isEmpty()) {
                        arrayList.add(this.f37619g);
                    } else {
                        arrayList.addAll(this.i.f37510c);
                    }
                    com.kwai.video.ksvodplayerkit.HttpDns.d dVar2 = new com.kwai.video.ksvodplayerkit.HttpDns.d(arrayList);
                    this.A = dVar2;
                    if (dVar2.b() != null && !TextUtils.isEmpty(this.A.b().f37486b)) {
                        this.f37619g = this.A.b().f37486b;
                        this.f37620h.put("Host", this.A.d());
                    }
                }
            }
        } else {
            com.kwai.video.ksvodplayerkit.HttpDns.d dVar3 = new com.kwai.video.ksvodplayerkit.HttpDns.d(hVar);
            this.A = dVar3;
            try {
                this.f37619g = com.kwai.video.ksvodplayerkit.b.m.a(dVar3.g());
            } catch (Exception e3) {
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", e3);
            }
            this.f37619g = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
        }
        if (this.f37619g == null) {
            com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "Wrong Input Arguments", new Exception("new KSVodPlayer"));
        }
        this.f37617e = a(this.i.a());
        this.r.set(1);
    }

    private IKwaiMediaPlayer a(KwaiPlayerVodBuilder kwaiPlayerVodBuilder) {
        kwaiPlayerVodBuilder.setUseNatvieCache(true).setStartOnPrepared(false).setOverlayFormat(PlayerSettingConstants.SDL_FCC_RV32).setEnableAccurateSeek(true).setStartOnPrepared(this.i.n).setHevcDcoderName(KwaiPlayerBaseBuilder.HEVC_DECODER_NAME_KS265);
        long j = this.i.o;
        if (j > 0) {
            kwaiPlayerVodBuilder.seekAtStart(j);
        }
        if (this.i.l != null) {
            kwaiPlayerVodBuilder.setProductContext(new ProductContext.Builder().setBizType(this.i.l).setPlayIndex(this.B.get()).build());
        }
        KSVodPlayerBuilder.VodPlayEnterType vodPlayEnterType = this.i.f37513f;
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
        com.kwai.video.ksvodplayerkit.c.b bVar = this.i.m;
        if (bVar != null) {
            kwaiPlayerVodBuilder.setUseMediaCodecByteBuffer(bVar.f37568a);
            if (bVar.f37569b) {
                kwaiPlayerVodBuilder.setMediaCodecAvcHeightLimit(bVar.f37571d);
                kwaiPlayerVodBuilder.setMediaCodecAvcWidthLimit(bVar.f37570c);
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(1);
            }
            if (bVar.f37572e) {
                kwaiPlayerVodBuilder.setMediaCodecHevcHeightLimit(bVar.f37571d);
                kwaiPlayerVodBuilder.setMediaCodecHevcWidthLimit(bVar.f37570c);
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(2);
            }
            if (bVar.f37569b && bVar.f37572e) {
                kwaiPlayerVodBuilder.setUseHardwareDcoderFlag(4096);
            }
            int i = bVar.f37573f;
            if (i > 0) {
                kwaiPlayerVodBuilder.setMediaCodecMaxNum(i);
            }
        }
        KSVodPlayerBuilder kSVodPlayerBuilder = this.i;
        if (kSVodPlayerBuilder.i == 1 && kSVodPlayerBuilder.f37515h != null) {
            kwaiPlayerVodBuilder.setVodManifest(com.kwai.video.ksvodplayerkit.c.a.d(kSVodPlayerBuilder.f37508a), com.kwai.video.ksvodplayerkit.c.c.a(this.i.f37508a), com.kwai.video.ksvodplayerkit.c.c.b(this.i.f37508a), i.a().k(), i.a().l(), 0);
        } else if (this.i.i == 2) {
            kwaiPlayerVodBuilder.setEnableAccurateSeek(false).setEnableSegmentCache(true).setEnableSeekForwardOffset(true);
            int i2 = this.i.j;
            if (i2 >= 0) {
                a(i2);
            }
        } else {
            kwaiPlayerVodBuilder.setCacheKey(f.a().a(this.f37619g));
        }
        if (i.a().b() && this.i.i == 0) {
            long c2 = f.a().c(this.f37619g);
            if (c2 > 0) {
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer use record history progress, seekto:" + c2);
                kwaiPlayerVodBuilder.seekAtStart(c2);
            }
        }
        if (com.kwai.video.ksvodplayerkit.c.c.b(this.f37619g)) {
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
        if (com.kwai.video.ksvodplayerkit.c.c.b(this.f37619g)) {
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
        if (!TextUtils.isEmpty(this.f37619g)) {
            try {
                if (this.i.i == 2) {
                    build.setKwaiManifest(this.C != null ? this.C.f37527a : "no_prefer_url", this.f37619g, this.f37620h);
                } else {
                    build.setDataSource(this.f37619g, this.f37620h);
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "createKwaiMediaPlayer, url:" + this.f37619g);
            } catch (IOException e2) {
                e2.printStackTrace();
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", "setDataSource error", new Exception("setDataSource"));
            }
        }
        Surface surface = this.f37615c;
        if (surface != null) {
            build.setSurface(surface);
        }
        SurfaceHolder surfaceHolder = this.f37616d;
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
        if (this.i.f37512e != null) {
            b bVar = new b();
            l lVar = this.i.f37512e;
            bVar.f37636c = lVar.f37666c;
            bVar.f37635b = lVar.f37665b;
            bVar.f37634a = lVar.f37664a;
            bVar.f37638e = lVar.f37668e;
            bVar.f37637d = this.l;
            bVar.f37639f = this.E;
            bVar.f37640g = this.F;
            bVar.f37641h = lVar.f37667d;
            jSONObject.put("stats", m.a(bVar));
            com.kwai.video.ksvodplayerkit.d.g a2 = com.kwai.video.ksvodplayerkit.d.c.a().a(this.i.f37512e.f37666c);
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
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                this.f37617e.setOnErrorListener(null);
                this.f37617e.setOnPreparedListener(null);
                this.f37617e.setOnVideoSizeChangedListener(null);
                this.f37617e.setOnInfoListener(null);
                this.f37617e.setOnBufferingUpdateListener(null);
                this.f37617e.releaseAsync();
                this.f37617e = null;
            }
            this.f37619g = str;
            this.f37618f = a(this.i.a());
            if (this.n != 1.0f || this.o != 1.0f) {
                this.f37618f.setVolume(this.n, this.o);
            }
            if (this.k != 0) {
                this.f37618f.setVideoScalingMode(this.k);
            }
            this.r.set(2);
            this.f37618f.prepareAsync();
            this.f37617e = this.f37618f;
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
        if (!com.kwai.video.ksvodplayerkit.c.a.a(this.i.f37508a) || this.B.addAndGet(1) >= i.a().e()) {
            return false;
        }
        return g();
    }

    public int a() {
        synchronized (this.f37614b) {
            if (this.f37617e == null || !(this.r.get() == 1 || this.r.get() == 7)) {
                StringBuilder sb = new StringBuilder();
                sb.append("prepareAsync error, playback state:");
                sb.append(this.r.get());
                sb.append(",mCurrentPlayer == null:");
                sb.append(this.f37617e == null);
                com.kwai.video.ksvodplayerkit.a.b.e("KSVodPlayer", sb.toString(), new Exception("prepareAsync"));
                return -1;
            }
            if (this.E == 0) {
                this.E = System.currentTimeMillis();
            }
            com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "prepareAsync");
            this.r.set(2);
            this.f37617e.prepareAsync();
            if (this.i.f37515h != null) {
                this.A.a(this.f37617e.getVodAdaptiveUrl());
                if (i.a().b()) {
                    long c2 = f.a().c(this.f37617e.getVodAdaptiveUrl());
                    if (c2 > 0) {
                        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "prepareAsync, multi rate use history play progress");
                        this.f37617e.seekTo(c2);
                    }
                }
            }
            return 0;
        }
    }

    public void a(float f2) {
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                this.f37617e.setSpeed(f2);
            }
        }
    }

    public void a(float f2, float f3) {
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                this.f37617e.setVolume(f2, f3);
            }
            this.n = f2;
            this.o = f3;
        }
    }

    public void a(int i) {
        com.kwai.video.ksvodplayerkit.b.c h2;
        synchronized (this.f37614b) {
            if (this.i.i == 2 && (h2 = this.A.h()) != null && h2.f37524c != null) {
                Iterator<com.kwai.video.ksvodplayerkit.b.f> it = h2.f37524c.f37526a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.kwai.video.ksvodplayerkit.b.f next = it.next();
                    if (next.f37533g == i) {
                        this.C = next;
                        break;
                    }
                }
                if (this.C == null) {
                    this.C = h2.f37524c.f37526a.get(0);
                }
                if (this.C != null) {
                    this.A.a(this.C.f37527a);
                }
            }
        }
    }

    public void a(long j) {
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                this.p = true;
                this.f37617e.seekTo(j);
            }
        }
    }

    public void a(Surface surface) {
        synchronized (this.f37614b) {
            this.f37615c = surface;
            if (this.f37617e != null) {
                this.f37617e.setSurface(surface);
            }
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            return;
        }
        synchronized (this.f37614b) {
            this.f37616d = surfaceHolder;
            if (this.f37617e != null) {
                this.f37617e.setDisplay(surfaceHolder);
            }
        }
    }

    public void a(com.kwai.video.ksvodplayerkit.b bVar) {
        this.w = bVar;
        if (this.f37617e != null && bVar != null) {
            a aVar = this.y;
            if (aVar != null) {
                aVar.a(bVar);
            } else {
                this.y = new a(bVar);
            }
            this.f37617e.getAspectAwesomeCache().setAwesomeCacheCallback(this.y);
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

    public void a(d.InterfaceC0466d interfaceC0466d) {
        this.t = interfaceC0466d;
    }

    public void a(d.e eVar) {
        this.x = eVar;
    }

    public void a(d.f fVar) {
        a(true, fVar);
    }

    public void a(l lVar) {
        synchronized (this.f37614b) {
            this.i.f37512e = lVar;
        }
    }

    public void a(KwaiPlayerDebugInfoView kwaiPlayerDebugInfoView) {
        this.f37613a = kwaiPlayerDebugInfoView;
        if (i.a().m()) {
            this.f37613a.setVisibility(0);
        }
    }

    public void a(boolean z) {
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                this.j = z;
                this.f37617e.setLooping(z);
            }
        }
    }

    public void a(final boolean z, final d.f fVar) {
        com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "releaseAsync,needReportQos:" + z);
        this.r.set(9);
        OnPlayerReleaseListener onPlayerReleaseListener = new OnPlayerReleaseListener() { // from class: com.kwai.video.ksvodplayerkit.g.7
            @Override // com.kwai.player.OnPlayerReleaseListener
            public void onRelease(KwaiPlayerResultQos kwaiPlayerResultQos) {
                synchronized (g.this.f37614b) {
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
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                this.f37617e.setOnPreparedListener(null);
                this.f37617e.setOnInfoListener(null);
                this.f37617e.setOnErrorListener(null);
                this.f37617e.setOnVideoSizeChangedListener(null);
                this.f37617e.setOnSeekCompleteListener(null);
                this.f37617e.setOnBufferingUpdateListener(null);
                this.f37617e.releaseAsync(onPlayerReleaseListener);
                this.f37617e = null;
            }
        }
    }

    public void b(boolean z) {
    }

    public boolean b() {
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                return this.f37617e.isPlaying();
            }
            return false;
        }
    }

    public long c() {
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                return this.f37617e.getCurrentPosition();
            }
            return 0L;
        }
    }

    public long d() {
        synchronized (this.f37614b) {
            if (this.f37617e != null) {
                return this.f37617e.getDuration();
            }
            return -1L;
        }
    }

    public void e() {
        synchronized (this.f37614b) {
            if (this.f37617e != null && !this.f37617e.isPlaying()) {
                if (this.F == 0) {
                    this.F = System.currentTimeMillis();
                }
                if (this.f37613a != null && i.a().m()) {
                    this.f37613a.startMonitor(this.f37617e);
                }
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", IntentConfig.START);
                this.f37617e.start();
            }
        }
        if (e.a(this.f37619g)) {
            i();
        }
    }

    public void f() {
        synchronized (this.f37614b) {
            if (this.f37617e != null && this.f37617e.isPlaying()) {
                com.kwai.video.ksvodplayerkit.a.b.b("KSVodPlayer", "pause");
                this.f37617e.pause();
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
                    if (this.i.f37515h != null) {
                        str2 = com.kwai.video.ksvodplayerkit.b.m.a(this.A.g());
                    } else {
                        if (this.f37620h == null) {
                            this.f37620h = new HashMap();
                        }
                        this.f37620h.put("Host", this.A.d());
                        str2 = this.A.b().f37486b;
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
        IKwaiMediaPlayer iKwaiMediaPlayer = this.f37617e;
        if (iKwaiMediaPlayer != null) {
            return iKwaiMediaPlayer;
        }
        return null;
    }
}
