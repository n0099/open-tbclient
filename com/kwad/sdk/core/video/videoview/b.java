package com.kwad.sdk.core.video.videoview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ae;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b extends AdBaseFrameLayout implements TextureView.SurfaceTextureListener, d {
    public static AtomicBoolean o = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public int f34136a;

    /* renamed from: b  reason: collision with root package name */
    public Context f34137b;

    /* renamed from: c  reason: collision with root package name */
    public AudioManager f34138c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.video.a.c f34139d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f34140e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.video.a f34141f;

    /* renamed from: g  reason: collision with root package name */
    public c f34142g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceTexture f34143h;
    public Surface i;
    public String j;
    public Map<String, String> k;
    public int l;
    public boolean m;
    public long n;
    public boolean p;
    public boolean q;
    public com.kwad.sdk.contentalliance.detail.video.d r;
    public com.kwad.sdk.contentalliance.detail.video.c s;
    public c.e t;
    public c.h u;
    public c.b v;
    public c.InterfaceC0391c w;
    public c.d x;
    public c.a y;
    public BroadcastReceiver z;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34136a = 0;
        this.m = false;
        this.p = false;
        this.q = false;
        this.t = new c.e() { // from class: com.kwad.sdk.core.video.videoview.b.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                b.this.f34136a = 2;
                b.this.f34142g.a(b.this.f34136a);
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.f();
                if (b.this.m) {
                    cVar.a((int) ae.a(b.this.f34137b, b.this.j));
                }
                if (b.this.n != 0) {
                    cVar.a((int) b.this.n);
                }
            }
        };
        this.u = new c.h() { // from class: com.kwad.sdk.core.video.videoview.b.2
            @Override // com.kwad.sdk.core.video.a.c.h
            public void a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
                if (!b.this.q || i2 <= i) {
                    b.this.f34141f.a(i, i2);
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
                }
            }
        };
        this.v = new c.b() { // from class: com.kwad.sdk.core.video.videoview.b.3
            @Override // com.kwad.sdk.core.video.a.c.b
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                b.this.f34136a = 9;
                b.this.f34142g.a(b.this.f34136a);
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                b.this.f34140e.setKeepScreenOn(false);
            }
        };
        this.w = new c.InterfaceC0391c() { // from class: com.kwad.sdk.core.video.videoview.b.4
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0391c
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
                if (i != -38) {
                    b.this.f34136a = -1;
                    b.this.f34142g.a(i, i2);
                    b.this.f34142g.a(b.this.f34136a);
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                    return true;
                }
                return true;
            }
        };
        this.x = new c.d() { // from class: com.kwad.sdk.core.video.videoview.b.5
            @Override // com.kwad.sdk.core.video.a.c.d
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
                StringBuilder sb;
                String str;
                String str2;
                if (i == 3) {
                    b.this.f34136a = 4;
                    b.this.f34142g.a(b.this.f34136a);
                    str = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
                } else if (i == 701) {
                    if (b.this.f34136a == 5 || b.this.f34136a == 7) {
                        b.this.f34136a = 7;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        b.this.f34136a = 6;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", str2);
                    b.this.f34142g.a(b.this.f34136a);
                    return true;
                } else if (i == 702) {
                    if (b.this.f34136a == 6) {
                        b.this.f34136a = 4;
                        b.this.f34142g.a(b.this.f34136a);
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.f34136a != 7) {
                        return true;
                    }
                    b.this.f34136a = 5;
                    b.this.f34142g.a(b.this.f34136a);
                    str = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                } else {
                    if (i == 10001) {
                        if (b.this.f34141f == null) {
                            return true;
                        }
                        b.this.f34141f.setRotation(i2);
                        sb = new StringBuilder();
                        sb.append("视频旋转角度：");
                        sb.append(i2);
                    } else if (i == 801) {
                        str = "视频不能seekTo，为直播视频";
                    } else {
                        sb = new StringBuilder();
                        sb.append("onInfo ——> what：");
                        sb.append(i);
                    }
                    str = sb.toString();
                }
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", str);
                return true;
            }
        };
        this.y = new c.a() { // from class: com.kwad.sdk.core.video.videoview.b.6
            @Override // com.kwad.sdk.core.video.a.c.a
            public void a(com.kwad.sdk.core.video.a.c cVar, int i) {
                b.this.l = i;
            }
        };
        this.z = new BroadcastReceiver() { // from class: com.kwad.sdk.core.video.videoview.b.7
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                NetworkInfo c2 = com.ksad.download.d.b.c(context2);
                if (c2 != null) {
                    c2.isConnected();
                }
            }
        };
        this.f34137b = context;
        l();
    }

    private void l() {
        this.f34140e = new FrameLayout(this.f34137b);
        addView(this.f34140e, new FrameLayout.LayoutParams(-1, -1));
    }

    private void m() {
        if (this.f34139d == null) {
            com.kwad.sdk.core.video.a.c a2 = com.kwad.sdk.contentalliance.detail.video.a.a(this.f34137b, false);
            this.f34139d = a2;
            a2.b(3);
            if (this.p) {
                return;
            }
            this.f34139d.a(0.0f, 0.0f);
        }
    }

    private void n() {
        if (this.f34141f == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.f34137b);
            this.f34141f = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void o() {
        this.f34140e.removeView(this.f34141f);
        this.f34140e.addView(this.f34141f, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void p() {
        this.f34140e.setKeepScreenOn(true);
        this.f34139d.a(this.t);
        this.f34139d.a(this.u);
        this.f34139d.a(this.v);
        this.f34139d.a(this.w);
        this.f34139d.a(this.x);
        this.f34139d.a(this.y);
        try {
            if (this.r != null && this.s != null) {
                this.r.f32543c = this.s;
            }
            this.f34139d.a(this.r);
            if (this.i == null) {
                this.i = new Surface(this.f34143h);
            }
            this.f34139d.a(this.i);
            if (this.f34139d.e()) {
                this.f34136a = 1;
                this.f34142g.a(1);
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            com.kwad.sdk.core.d.a.a("KSVideoPlayerViewView", "打开播放器发生错误", e2);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.detail.video.d dVar = this.r;
        if (dVar == null || (videoPlayerStatus = dVar.f32542b) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void a() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.f34136a != 0) {
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        m();
        n();
        o();
        com.kwad.sdk.contentalliance.detail.video.d dVar = this.r;
        if (dVar == null || (videoPlayerStatus = dVar.f32542b) == null) {
            return;
        }
        setPlayType(videoPlayerStatus.mVideoPlayerType == 0 ? 1 : 3);
    }

    public void a(int i) {
        com.kwad.sdk.core.video.a.c cVar = this.f34139d;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar, Map<String, String> map) {
        this.r = dVar;
        this.j = dVar.f32541a;
        this.k = map;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void b() {
        String str;
        int i = this.f34136a;
        if (i == 5) {
            this.f34139d.f();
            this.f34136a = 4;
            this.f34142g.a(4);
            setPlayType(2);
            str = "STATE_PLAYING";
        } else if (i == 7) {
            this.f34139d.f();
            this.f34136a = 6;
            this.f34142g.a(6);
            str = "STATE_BUFFERING_PLAYING";
        } else if (i == 9 || i == -1) {
            this.f34139d.n();
            p();
            setPlayType(3);
            return;
        } else {
            str = "KSVideoPlayer在状态为 " + this.f34136a + " 时不能调用restart()方法.";
        }
        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", str);
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void c() {
        if (this.f34136a == 4) {
            this.f34139d.g();
            this.f34136a = 5;
            this.f34142g.a(5);
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_PAUSED");
        }
        if (this.f34136a == 6) {
            this.f34139d.g();
            this.f34136a = 7;
            this.f34142g.a(7);
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean d() {
        return this.f34136a == 0;
    }

    public boolean e() {
        return this.f34136a == 6;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean f() {
        return this.f34136a == 7;
    }

    public boolean g() {
        return this.f34136a == 4;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public int getBufferPercentage() {
        return this.l;
    }

    public c getController() {
        return this.f34142g;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.f34139d;
        if (cVar != null) {
            return cVar.k();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.f34139d;
        if (cVar != null) {
            return cVar.l();
        }
        return 0L;
    }

    public int getMaxVolume() {
        AudioManager audioManager = this.f34138c;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public int getVolume() {
        AudioManager audioManager = this.f34138c;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean h() {
        return this.f34136a == 5;
    }

    public boolean i() {
        return this.f34136a == 9;
    }

    public void j() {
        AudioManager audioManager = this.f34138c;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.f34138c = null;
        }
        com.kwad.sdk.core.video.a.c cVar = this.f34139d;
        if (cVar != null) {
            cVar.m();
            this.f34139d = null;
        }
        this.f34140e.removeView(this.f34141f);
        Surface surface = this.i;
        if (surface != null) {
            surface.release();
            this.i = null;
        }
        SurfaceTexture surfaceTexture = this.f34143h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f34143h = null;
        }
        this.f34136a = 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void k() {
        Context context;
        String str;
        long currentPosition;
        if (this.m) {
            if (g() || e() || f() || h()) {
                context = this.f34137b;
                str = this.j;
                currentPosition = getCurrentPosition();
            } else if (i()) {
                context = this.f34137b;
                str = this.j;
                currentPosition = 0;
            }
            ae.a(context, str, currentPosition);
        }
        j();
        c cVar = this.f34142g;
        if (cVar != null) {
            cVar.c();
        }
        Runtime.getRuntime().gc();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.f34143h;
        if (surfaceTexture2 != null) {
            this.f34141f.setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.f34143h = surfaceTexture;
        p();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setController(c cVar) {
        this.f34140e.removeView(this.f34142g);
        this.f34142g = cVar;
        cVar.c();
        this.f34140e.addView(this.f34142g, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar) {
        this.s = cVar;
    }

    public void setPortraitFullscreen(boolean z) {
        this.q = z;
    }

    public void setVideoSoundEnable(boolean z) {
        this.p = z;
        com.kwad.sdk.core.video.a.c cVar = this.f34139d;
        if (cVar != null) {
            float f2 = z ? 1.0f : 0.0f;
            cVar.a(f2, f2);
        }
    }

    public void setVolume(int i) {
        AudioManager audioManager = this.f34138c;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }
}
