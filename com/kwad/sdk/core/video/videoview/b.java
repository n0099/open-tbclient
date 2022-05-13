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
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.utils.as;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
@Deprecated
/* loaded from: classes5.dex */
public class b extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, d {
    public static AtomicBoolean o = new AtomicBoolean(false);
    public BroadcastReceiver A;
    public int a;
    public Context b;
    public AudioManager c;
    public com.kwad.sdk.core.video.kwai.c d;
    public FrameLayout e;
    public com.kwad.sdk.core.video.a f;
    public c g;
    public SurfaceTexture h;
    public Surface i;
    public String j;
    public Map<String, String> k;
    public int l;
    public boolean m;
    public long n;
    public boolean p;
    public boolean q;
    public com.kwad.sdk.contentalliance.detail.video.c r;
    public com.kwad.sdk.contentalliance.detail.video.b s;
    public ImageView t;
    public c.e u;
    public c.h v;
    public c.b w;
    public c.InterfaceC0306c x;
    public c.d y;
    public c.a z;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.m = false;
        this.p = false;
        this.q = false;
        this.u = new c.e() { // from class: com.kwad.sdk.core.video.videoview.b.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public void a(com.kwad.sdk.core.video.kwai.c cVar) {
                b.this.a = 2;
                b.this.g.a(b.this.a);
                com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.f();
                if (b.this.m) {
                    cVar.a((int) as.a(b.this.b, b.this.j));
                }
                if (b.this.n != 0) {
                    cVar.a((int) b.this.n);
                }
            }
        };
        this.v = new c.h() { // from class: com.kwad.sdk.core.video.videoview.b.2
            @Override // com.kwad.sdk.core.video.kwai.c.h
            public void a(com.kwad.sdk.core.video.kwai.c cVar, int i, int i2) {
                if (!b.this.q || i2 <= i) {
                    b.this.f.a(i, i2);
                    com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i + "， height：" + i2);
                }
            }
        };
        this.w = new c.b() { // from class: com.kwad.sdk.core.video.videoview.b.3
            @Override // com.kwad.sdk.core.video.kwai.c.b
            public void a(com.kwad.sdk.core.video.kwai.c cVar) {
                if (b.this.a != 9) {
                    b.this.a = 9;
                    b.this.g.a(b.this.a);
                    com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    b.this.e.setKeepScreenOn(false);
                }
            }
        };
        this.x = new c.InterfaceC0306c() { // from class: com.kwad.sdk.core.video.videoview.b.4
            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0306c
            public boolean a(com.kwad.sdk.core.video.kwai.c cVar, int i, int i2) {
                if (i != -38) {
                    b.this.a = -1;
                    b.this.g.a(i, i2);
                    b.this.g.a(b.this.a);
                    com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i + ", extra: " + i2);
                    return true;
                }
                return true;
            }
        };
        this.y = new c.d() { // from class: com.kwad.sdk.core.video.videoview.b.5
            @Override // com.kwad.sdk.core.video.kwai.c.d
            public boolean a(com.kwad.sdk.core.video.kwai.c cVar, int i, int i2) {
                StringBuilder sb;
                String str;
                String str2;
                if (i == 3) {
                    b.this.a = 4;
                    b.this.g.a(b.this.a);
                    str = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
                } else if (i == 701) {
                    if (b.this.a == 5 || b.this.a == 7) {
                        b.this.a = 7;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                    } else {
                        b.this.a = 6;
                        str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                    }
                    com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", str2);
                    b.this.g.a(b.this.a);
                    return true;
                } else if (i == 702) {
                    if (b.this.a == 6) {
                        b.this.a = 4;
                        b.this.g.a(b.this.a);
                        com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.a != 7) {
                        return true;
                    }
                    b.this.a = 5;
                    b.this.g.a(b.this.a);
                    str = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                } else {
                    if (i == 10001) {
                        if (b.this.f == null) {
                            return true;
                        }
                        b.this.f.setRotation(i2);
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
                com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", str);
                return true;
            }
        };
        this.z = new c.a() { // from class: com.kwad.sdk.core.video.videoview.b.6
            @Override // com.kwad.sdk.core.video.kwai.c.a
            public void a(com.kwad.sdk.core.video.kwai.c cVar, int i) {
                b.this.l = i;
            }
        };
        this.A = new BroadcastReceiver() { // from class: com.kwad.sdk.core.video.videoview.b.7
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                NetworkInfo c = com.ksad.download.c.b.c(context2);
                if (c != null) {
                    c.isConnected();
                }
            }
        };
        this.b = context;
        p();
    }

    private void a(AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.t, com.kwad.sdk.core.response.a.d.n(adTemplate), adTemplate);
    }

    private void p() {
        setBackgroundColor(-16777216);
        this.t = q();
        this.e = new FrameLayout(this.b);
        addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    }

    private ImageView q() {
        ImageView imageView = new ImageView(this.b);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private void r() {
        if (this.d == null) {
            com.kwad.sdk.core.video.kwai.c a = com.kwad.sdk.contentalliance.detail.video.a.a(this.b, false);
            this.d = a;
            a.b(3);
            if (this.p) {
                return;
            }
            this.d.a(0.0f, 0.0f);
        }
    }

    private void s() {
        if (this.f == null) {
            com.kwad.sdk.core.video.a aVar = new com.kwad.sdk.core.video.a(this.b);
            this.f = aVar;
            aVar.setSurfaceTextureListener(this);
        }
    }

    private void setPlayType(int i) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.detail.video.c cVar = this.r;
        if (cVar == null || (videoPlayerStatus = cVar.d) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i;
    }

    private void t() {
        this.e.removeView(this.f);
        this.e.addView(this.f, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void u() {
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
            if (this.d.e()) {
                this.a = 1;
                this.g.a(1);
                com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.d.a.a("KSVideoPlayerViewView", "打开播放器发生错误", e);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void a() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.a != 0) {
            com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        r();
        s();
        t();
        com.kwad.sdk.contentalliance.detail.video.c cVar = this.r;
        if (cVar == null || (videoPlayerStatus = cVar.d) == null) {
            return;
        }
        setPlayType(videoPlayerStatus.mVideoPlayerType == 0 ? 1 : 3);
    }

    public void a(int i) {
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            cVar.a(i);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.detail.video.c cVar, Map<String, String> map) {
        this.r = cVar;
        this.j = cVar.b;
        this.k = map;
        a(cVar.a);
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void b() {
        String str;
        int i = this.a;
        if (i == 5) {
            this.d.f();
            this.a = 4;
            this.g.a(4);
            setPlayType(2);
            str = "STATE_PLAYING";
        } else if (i == 7) {
            this.d.f();
            this.a = 6;
            this.g.a(6);
            str = "STATE_BUFFERING_PLAYING";
        } else if (i == 9 || i == -1) {
            this.d.m();
            u();
            setPlayType(3);
            return;
        } else {
            str = "KSVideoPlayer在状态为 " + this.a + " 时不能调用restart()方法.";
        }
        com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", str);
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void c() {
        String str;
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar == null) {
            return;
        }
        int i = this.a;
        if (i == 4) {
            cVar.g();
            this.a = 5;
            this.g.a(5);
            str = "STATE_PAUSED";
        } else if (i != 6) {
            return;
        } else {
            cVar.g();
            this.a = 7;
            this.g.a(7);
            str = "STATE_BUFFERING_PAUSED";
        }
        com.kwad.sdk.core.d.a.c("KSVideoPlayerViewView", str);
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean d() {
        return this.a == 0;
    }

    public boolean e() {
        return this.a == 6;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean f() {
        return this.a == 7;
    }

    public boolean g() {
        return this.a == 4;
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
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            return cVar.j();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public long getDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            return cVar.k();
        }
        return 0L;
    }

    public int getMaxVolume() {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public c getVideoController() {
        return this.g;
    }

    public int getVolume() {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public boolean h() {
        return this.a == 5;
    }

    public boolean i() {
        return this.a == 9;
    }

    public void j() {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.c = null;
        }
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            cVar.l();
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

    @Override // com.kwad.sdk.core.video.videoview.d
    public void k() {
        Context context;
        String str;
        long currentPosition;
        if (this.m) {
            if (g() || e() || f() || h()) {
                context = this.b;
                str = this.j;
                currentPosition = getCurrentPosition();
            } else if (i()) {
                context = this.b;
                str = this.j;
                currentPosition = 0;
            }
            as.a(context, str, currentPosition);
        }
        j();
        c cVar = this.g;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        SurfaceTexture surfaceTexture2 = this.h;
        if (surfaceTexture2 != null) {
            this.f.setSurfaceTexture(surfaceTexture2);
            return;
        }
        this.h = surfaceTexture;
        u();
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
        cVar.e();
        this.e.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.d
    public void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.detail.video.b bVar) {
        this.s = bVar;
    }

    public void setPortraitFullscreen(boolean z) {
        this.q = z;
    }

    public void setVideoSoundEnable(boolean z) {
        this.p = z;
        com.kwad.sdk.core.video.kwai.c cVar = this.d;
        if (cVar != null) {
            float f = z ? 1.0f : 0.0f;
            cVar.a(f, f);
        }
    }

    public void setVolume(int i) {
        AudioManager audioManager = this.c;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }
}
