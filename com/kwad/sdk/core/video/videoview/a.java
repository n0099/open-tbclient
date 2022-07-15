package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.core.video.kwai.e;
import com.kwad.sdk.core.video.kwai.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.g;
import com.kwad.sdk.utils.as;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
@Deprecated
/* loaded from: classes5.dex */
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    public static AtomicBoolean o = new AtomicBoolean(false);
    public int a;
    public Context b;
    public AudioManager c;
    public com.kwad.sdk.core.video.kwai.c d;
    public FrameLayout e;
    public com.kwad.sdk.core.video.a f;
    public b g;
    public SurfaceTexture h;
    public Surface i;
    public String j;
    public Map<String, String> k;
    public int l;
    public boolean m;
    public long n;
    public boolean p;
    public boolean q;
    public com.kwad.sdk.contentalliance.kwai.kwai.b r;
    public com.kwad.sdk.contentalliance.kwai.kwai.a s;
    public ImageView t;
    public c.e u;
    public c.h v;
    public c.b w;
    public c.InterfaceC0547c x;
    public c.d y;
    public c.a z;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.a = 0;
        this.m = false;
        this.p = false;
        this.q = false;
        this.u = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                a.this.a = 2;
                a.this.g.a(a.this.a);
                com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.e();
                if (a.this.m) {
                    cVar.a((int) as.a(a.this.b, a.this.j));
                }
                if (a.this.n != 0) {
                    cVar.a((int) a.this.n);
                }
            }
        };
        this.v = new c.h() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.h
            public final void a(int i, int i2) {
                if (!a.this.q || i2 <= i) {
                    a.this.f.a(i, i2);
                    com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
                }
            }
        };
        this.w = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.b
            public final void a() {
                if (a.this.a != 9) {
                    a.this.a = 9;
                    a.this.g.a(a.this.a);
                    com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.e.setKeepScreenOn(false);
                }
            }
        };
        this.x = new c.InterfaceC0547c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0547c
            public final boolean a(int i, int i2) {
                if (i != -38) {
                    a.this.a = -1;
                    a.this.g.a(i, i2);
                    a.this.g.a(a.this.a);
                    com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                    return true;
                }
                return true;
            }
        };
        this.y = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.kwai.c.d
            public final boolean a(int i, int i2) {
                String str;
                String str2;
                if (i == 3) {
                    a.this.a = 4;
                    a.this.g.a(a.this.a);
                    str = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
                } else if (i == 701) {
                    if (a.this.a == 5 || a.this.a == 7) {
                        a.this.a = 7;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        a.this.a = 6;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", str2);
                    a.this.g.a(a.this.a);
                    return true;
                } else if (i == 702) {
                    if (a.this.a == 6) {
                        a.this.a = 4;
                        a.this.g.a(a.this.a);
                        com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (a.this.a != 7) {
                        return true;
                    }
                    a.this.a = 5;
                    a.this.g.a(a.this.a);
                    str = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                } else if (i == 10001) {
                    if (a.this.f == null) {
                        return true;
                    }
                    a.this.f.setRotation(i2);
                    str = "视频旋转角度：" + i2;
                } else if (i == 801) {
                    str = "视频不能seekTo，为直播视频";
                } else {
                    str = "onInfo ——> what：" + i;
                }
                com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", str);
                return true;
            }
        };
        this.z = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.kwai.c.a
            public final void a(int i) {
                a.this.l = i;
            }
        };
        this.b = context;
        k();
    }

    private void a(AdTemplate adTemplate) {
        g gVar = (g) ServiceProvider.a(g.class);
        if (gVar != null) {
            gVar.load(this.t, d.l(adTemplate), adTemplate);
        }
    }

    private void k() {
        this.t = l();
        this.e = new FrameLayout(this.b);
        addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    }

    private ImageView l() {
        ImageView imageView = new ImageView(this.b);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean m() {
        return this.a == 6;
    }

    private void n() {
        if (this.d == null) {
            f fVar = (f) ServiceProvider.a(f.class);
            boolean z = true;
            com.kwad.sdk.core.video.kwai.c a = e.a(this.b, false, fVar != null && fVar.a(), (fVar == null || !fVar.b()) ? false : false);
            this.d = a;
            a.b(3);
            if (this.p) {
                return;
            }
            this.d.a(0.0f, 0.0f);
        }
    }

    private void o() {
        if (this.f == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.b);
            this.f = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void p() {
        this.e.removeView(this.f);
        this.e.addView(this.f, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void q() {
        this.e.setKeepScreenOn(true);
        this.d.a(this.u);
        this.d.a(this.v);
        this.d.a(this.w);
        this.d.a(this.x);
        this.d.a(this.y);
        this.d.a(this.z);
        try {
            if (this.r != null && this.s != null) {
                this.r.e = this.s;
            }
            this.d.a(this.r);
            if (this.i == null) {
                this.i = new Surface(this.h);
            }
            this.d.a(this.i);
            if (this.d.d()) {
                this.a = 1;
                this.g.a(1);
                com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            com.kwad.sdk.core.d.b.a("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    private void r() {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.c = null;
        }
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            cVar.i();
            this.d = null;
        }
        this.e.removeView(this.f);
        Surface surface = this.i;
        if (surface != null) {
            surface.release();
            this.i = null;
        }
        SurfaceTexture surfaceTexture = this.h;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.h = null;
        }
        this.a = 0;
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.r;
        if (bVar == null || (videoPlayerStatus = bVar.d) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void a() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.a != 0) {
            com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        n();
        o();
        p();
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.r;
        if (bVar == null || (videoPlayerStatus = bVar.d) == null) {
            return;
        }
        setPlayType(videoPlayerStatus.mVideoPlayerType == 0 ? 1 : 3);
    }

    public final void a(int i) {
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, Map<String, String> map) {
        this.r = bVar;
        this.j = bVar.b;
        this.k = null;
        a(bVar.a);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void b() {
        int i = this.a;
        if (i == 5) {
            this.d.e();
            this.a = 4;
            this.g.a(4);
            setPlayType(2);
            com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "STATE_PLAYING");
        } else if (i == 7) {
            this.d.e();
            this.a = 6;
            this.g.a(6);
            com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
        } else if (i == 9 || i == -1) {
            this.d.j();
            q();
            setPlayType(3);
        } else {
            com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.a + " 时不能调用restart()方法.");
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void c() {
        String str;
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar == null) {
            return;
        }
        int i = this.a;
        if (i == 4) {
            cVar.f();
            this.a = 5;
            this.g.a(5);
            str = "STATE_PAUSED";
        } else if (i != 6) {
            return;
        } else {
            cVar.f();
            this.a = 7;
            this.g.a(7);
            str = "STATE_BUFFERING_PAUSED";
        }
        com.kwad.sdk.core.d.b.c("KSVideoPlayerViewView", str);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean d() {
        return this.a == 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean e() {
        return this.a == 7;
    }

    public final boolean f() {
        return this.a == 4;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean g() {
        return this.a == 5;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.l;
    }

    public final b getController() {
        return this.g;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            return cVar.g();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            return cVar.h();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final b getVideoController() {
        return this.g;
    }

    public final int getVolume() {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean h() {
        return this.a == 9;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void i() {
        Context context;
        String str;
        long currentPosition;
        if (this.m) {
            if (f() || m() || e() || g()) {
                context = this.b;
                str = this.j;
                currentPosition = getCurrentPosition();
            } else if (h()) {
                context = this.b;
                str = this.j;
                currentPosition = 0;
            }
            as.a(context, str, currentPosition);
        }
        r();
        b bVar = this.g;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.h;
        if (surfaceTexture2 != null) {
            this.f.setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.h = surfaceTexture;
        q();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void setController(b bVar) {
        this.e.removeView(this.g);
        this.g = bVar;
        bVar.e();
        this.e.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        this.s = aVar;
    }

    public final void setPortraitFullscreen(boolean z) {
        this.q = z;
    }

    public final void setVideoSoundEnable(boolean z) {
        this.p = z;
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            if (z) {
                cVar.a(1.0f, 1.0f);
            } else {
                cVar.a(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i) {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }
}
