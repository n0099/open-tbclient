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
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ae;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b extends AdBaseFrameLayout implements TextureView.SurfaceTextureListener, d {
    private static AtomicBoolean o = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    private int f6272a;
    private Context b;
    private AudioManager c;
    private com.kwad.sdk.core.video.a.c d;
    private FrameLayout e;
    private com.kwad.sdk.core.video.a f;
    private c g;
    private SurfaceTexture h;
    private Surface i;
    private String j;
    private Map<String, String> k;
    private int l;
    private boolean m;
    private long n;
    private boolean p;
    private boolean q;
    private com.kwad.sdk.contentalliance.detail.video.d r;
    private com.kwad.sdk.contentalliance.detail.video.c s;
    private c.e t;
    private c.h u;
    private c.b v;
    private c.InterfaceC1123c w;
    private c.d x;
    private c.a y;
    private BroadcastReceiver z;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6272a = 0;
        this.m = false;
        this.p = false;
        this.q = false;
        this.t = new c.e() { // from class: com.kwad.sdk.core.video.videoview.b.1
            @Override // com.kwad.sdk.core.video.a.c.e
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                b.this.f6272a = 2;
                b.this.g.a(b.this.f6272a);
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.f();
                if (b.this.m) {
                    cVar.a((int) ae.a(b.this.b, b.this.j));
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
                    b.this.f.a(i, i2);
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
                }
            }
        };
        this.v = new c.b() { // from class: com.kwad.sdk.core.video.videoview.b.3
            @Override // com.kwad.sdk.core.video.a.c.b
            public void a(com.kwad.sdk.core.video.a.c cVar) {
                b.this.f6272a = 9;
                b.this.g.a(b.this.f6272a);
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                b.this.e.setKeepScreenOn(false);
            }
        };
        this.w = new c.InterfaceC1123c() { // from class: com.kwad.sdk.core.video.videoview.b.4
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC1123c
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
                if (i != -38) {
                    b.this.f6272a = -1;
                    b.this.g.a(i, i2);
                    b.this.g.a(b.this.f6272a);
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                    return true;
                }
                return true;
            }
        };
        this.x = new c.d() { // from class: com.kwad.sdk.core.video.videoview.b.5
            @Override // com.kwad.sdk.core.video.a.c.d
            public boolean a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
                if (i == 3) {
                    b.this.f6272a = 4;
                    b.this.g.a(b.this.f6272a);
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING");
                    return true;
                } else if (i == 701) {
                    if (b.this.f6272a == 5 || b.this.f6272a == 7) {
                        b.this.f6272a = 7;
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        b.this.f6272a = 6;
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    b.this.g.a(b.this.f6272a);
                    return true;
                } else if (i == 702) {
                    if (b.this.f6272a == 6) {
                        b.this.f6272a = 4;
                        b.this.g.a(b.this.f6272a);
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.f6272a == 7) {
                        b.this.f6272a = 5;
                        b.this.g.a(b.this.f6272a);
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                        return true;
                    }
                    return true;
                } else if (i == 10001) {
                    if (b.this.f != null) {
                        b.this.f.setRotation(i2);
                        com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "视频旋转角度：" + i2);
                        return true;
                    }
                    return true;
                } else if (i == 801) {
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "视频不能seekTo，为直播视频");
                    return true;
                } else {
                    com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "onInfo ——> what：" + i);
                    return true;
                }
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
                NetworkInfo c = com.ksad.download.d.b.c(context2);
                if (c == null || c.isConnected()) {
                }
            }
        };
        this.b = context;
        l();
    }

    private void l() {
        this.e = new FrameLayout(this.b);
        addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    }

    private void m() {
        if (this.d == null) {
            this.d = com.kwad.sdk.contentalliance.detail.video.a.a(this.b, false);
            this.d.b(3);
            if (this.p) {
                return;
            }
            this.d.a(0.0f, 0.0f);
        }
    }

    private void n() {
        if (this.f == null) {
            this.f = new com.kwad.sdk.core.video.a(this.b);
            this.f.setSurfaceTextureListener(this);
        }
    }

    private void o() {
        this.e.removeView(this.f);
        this.e.addView(this.f, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void p() {
        this.e.setKeepScreenOn(true);
        this.d.a(this.t);
        this.d.a(this.u);
        this.d.a(this.v);
        this.d.a(this.w);
        this.d.a(this.x);
        this.d.a(this.y);
        try {
            if (this.r != null && this.s != null) {
                this.r.c = this.s;
            }
            this.d.a(this.r);
            if (this.i == null) {
                this.i = new Surface(this.h);
            }
            this.d.a(this.i);
            if (this.d.e()) {
                this.f6272a = 1;
                this.g.a(this.f6272a);
                com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.d.a.a("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    private void setPlayType(int i) {
        if (this.r == null || this.r.b == null) {
            return;
        }
        this.r.b.mVideoPlayerType = i;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void a() {
        if (this.f6272a != 0) {
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        m();
        n();
        o();
        if (this.r == null || this.r.b == null) {
            return;
        }
        if (this.r.b.mVideoPlayerType == 0) {
            setPlayType(1);
        } else {
            setPlayType(3);
        }
    }

    public void a(int i) {
        if (this.d != null) {
            this.d.a(i);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.d dVar, Map<String, String> map) {
        this.r = dVar;
        this.j = dVar.f5747a;
        this.k = map;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void b() {
        if (this.f6272a == 5) {
            this.d.f();
            this.f6272a = 4;
            this.g.a(this.f6272a);
            setPlayType(2);
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_PLAYING");
        } else if (this.f6272a == 7) {
            this.d.f();
            this.f6272a = 6;
            this.g.a(this.f6272a);
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
        } else if (this.f6272a != 9 && this.f6272a != -1) {
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.f6272a + " 时不能调用restart()方法.");
        } else {
            this.d.n();
            p();
            setPlayType(3);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void c() {
        if (this.f6272a == 4) {
            this.d.g();
            this.f6272a = 5;
            this.g.a(this.f6272a);
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_PAUSED");
        }
        if (this.f6272a == 6) {
            this.d.g();
            this.f6272a = 7;
            this.g.a(this.f6272a);
            com.kwad.sdk.core.d.a.b("KSVideoPlayerViewView", "STATE_BUFFERING_PAUSED");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean d() {
        return this.f6272a == 0;
    }

    public boolean e() {
        return this.f6272a == 6;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean f() {
        return this.f6272a == 7;
    }

    public boolean g() {
        return this.f6272a == 4;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public int getBufferPercentage() {
        return this.l;
    }

    public c getController() {
        return this.g;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public long getCurrentPosition() {
        if (this.d != null) {
            return this.d.k();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public long getDuration() {
        if (this.d != null) {
            return this.d.l();
        }
        return 0L;
    }

    public int getMaxVolume() {
        if (this.c != null) {
            return this.c.getStreamMaxVolume(3);
        }
        return 0;
    }

    public int getVolume() {
        if (this.c != null) {
            return this.c.getStreamVolume(3);
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean h() {
        return this.f6272a == 5;
    }

    public boolean i() {
        return this.f6272a == 9;
    }

    public void j() {
        if (this.c != null) {
            this.c.abandonAudioFocus(null);
            this.c = null;
        }
        if (this.d != null) {
            this.d.m();
            this.d = null;
        }
        this.e.removeView(this.f);
        if (this.i != null) {
            this.i.release();
            this.i = null;
        }
        if (this.h != null) {
            this.h.release();
            this.h = null;
        }
        this.f6272a = 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void k() {
        if (this.m) {
            if (g() || e() || f() || h()) {
                ae.a(this.b, this.j, getCurrentPosition());
            } else if (i()) {
                ae.a(this.b, this.j, 0L);
            }
        }
        j();
        if (this.g != null) {
            this.g.c();
        }
        Runtime.getRuntime().gc();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.h != null) {
            this.f.setSurfaceTexture(this.h);
            return;
        }
        this.h = surfaceTexture;
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
        this.e.removeView(this.g);
        this.g = cVar;
        this.g.c();
        this.e.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
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
        if (this.d != null) {
            if (z) {
                this.d.a(1.0f, 1.0f);
            } else {
                this.d.a(0.0f, 0.0f);
            }
        }
    }

    public void setVolume(int i) {
        if (this.c != null) {
            this.c.setStreamVolume(3, i, 0);
        }
    }
}
