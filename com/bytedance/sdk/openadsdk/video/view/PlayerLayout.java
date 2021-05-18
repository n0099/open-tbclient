package com.bytedance.sdk.openadsdk.video.view;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.video.c.a;
import com.bytedance.sdk.openadsdk.video.d.d;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class PlayerLayout extends FrameLayout implements a.InterfaceC0322a {

    /* renamed from: b  reason: collision with root package name */
    public static AudioManager.OnAudioFocusChangeListener f30348b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.video.view.PlayerLayout.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static int f30349d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f30350a;

    /* renamed from: c  reason: collision with root package name */
    public int f30351c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.c.a f30352e;

    /* renamed from: f  reason: collision with root package name */
    public Class f30353f;

    /* renamed from: g  reason: collision with root package name */
    public TextureView f30354g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceView f30355h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f30356i;
    public Timer j;
    public AudioManager k;
    public a l;
    public long m;
    public com.bytedance.sdk.openadsdk.video.b.a n;
    public boolean o;

    /* loaded from: classes6.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i2 = PlayerLayout.this.f30351c;
            if (i2 == 5 || i2 == 6 || i2 == 3) {
                PlayerLayout.this.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.video.view.PlayerLayout.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentPositionWhenPlaying = PlayerLayout.this.getCurrentPositionWhenPlaying();
                        long duration = PlayerLayout.this.getDuration();
                        PlayerLayout.this.a((int) ((100 * currentPositionWhenPlaying) / (duration == 0 ? 1L : duration)), currentPositionWhenPlaying, duration);
                    }
                });
            }
        }
    }

    public void a() {
        try {
            com.bytedance.sdk.openadsdk.video.c.a aVar = (com.bytedance.sdk.openadsdk.video.c.a) this.f30353f.getConstructor(new Class[0]).newInstance(new Object[0]);
            this.f30352e = aVar;
            aVar.a(getContext());
            this.f30352e.b(this.f30356i);
            this.f30352e.a(this.o);
            this.f30352e.a(this);
            this.f30352e.a(this.n);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        if (this.o) {
            j();
        } else {
            k();
        }
        AudioManager audioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.k = audioManager;
        audioManager.requestAudioFocus(f30348b, 3, 2);
        d.a(getContext()).getWindow().addFlags(128);
        c();
    }

    public void b() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStateNormal ", Integer.valueOf(hashCode()));
        this.f30351c = 0;
        m();
        com.bytedance.sdk.openadsdk.video.c.a aVar = this.f30352e;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void c() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePreparing ", Integer.valueOf(hashCode()));
        this.f30351c = 1;
        n();
    }

    public void d() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePreparingPlaying ", Integer.valueOf(hashCode()));
        this.f30351c = 3;
    }

    public void e() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePreparingChangeUrl ", Integer.valueOf(hashCode()));
        this.f30351c = 2;
        a();
    }

    public void f() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePlaying seekToInAdvance=", Integer.valueOf(this.f30350a), Integer.valueOf(hashCode()));
        if (this.f30351c == 4) {
            int i2 = this.f30350a;
            if (i2 != 0) {
                this.f30352e.a(i2);
                com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePlaying seekTo");
                this.f30350a = 0;
            } else {
                this.f30352e.a(0);
            }
        }
        this.f30351c = 5;
        l();
    }

    public void g() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePause ", Integer.valueOf(hashCode()));
        this.f30351c = 6;
        m();
    }

    public long getCurrentPositionWhenPlaying() {
        int i2 = this.f30351c;
        if (i2 == 5 || i2 == 6 || i2 == 3) {
            try {
                return this.f30352e.c();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public long getDuration() {
        try {
            return this.f30352e.d();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public void h() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStateError ", Integer.valueOf(hashCode()));
        this.f30351c = 8;
        m();
    }

    public void i() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStateAutoComplete ", Integer.valueOf(hashCode()));
        this.f30351c = 7;
        m();
    }

    public void j() {
        com.bytedance.sdk.openadsdk.video.d.a.a("PlayerLayout", "video_new addTextureView ", Integer.valueOf(hashCode()));
        removeAllViews();
        TextureView textureView = new TextureView(getContext().getApplicationContext());
        this.f30354g = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.bytedance.sdk.openadsdk.video.view.PlayerLayout.2
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                com.bytedance.sdk.openadsdk.video.c.a aVar = PlayerLayout.this.f30352e;
                if (aVar != null) {
                    aVar.a(new Surface(surfaceTexture));
                    PlayerLayout.this.f30352e.a();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new  onSurfaceTextureDestroyed: ");
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        addView(this.f30354g, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void k() {
        com.bytedance.sdk.openadsdk.video.d.a.a("PlayerLayout", "video_new addSurfaceView ", Integer.valueOf(hashCode()));
        removeAllViews();
        SurfaceView surfaceView = new SurfaceView(getContext().getApplicationContext());
        this.f30355h = surfaceView;
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.bytedance.sdk.openadsdk.video.view.PlayerLayout.3
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (PlayerLayout.this.f30352e != null) {
                    surfaceHolder.setType(3);
                    PlayerLayout.this.f30352e.a(surfaceHolder);
                    PlayerLayout.this.f30352e.a();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                com.bytedance.sdk.openadsdk.video.d.a.a("PlayerLayout", "video_new surfaceDestroyed ", Integer.valueOf(hashCode()));
                PlayerLayout playerLayout = PlayerLayout.this;
                com.bytedance.sdk.openadsdk.video.c.a aVar = playerLayout.f30352e;
                if (aVar != null) {
                    playerLayout.f30350a = aVar.c();
                    PlayerLayout.this.f30352e.b();
                    com.bytedance.sdk.openadsdk.video.d.a.a("PlayerLayout", "video_new  ", Integer.valueOf(PlayerLayout.this.f30350a));
                }
            }
        });
        this.f30355h.setZOrderOnTop(true);
        this.f30355h.setZOrderMediaOverlay(true);
        addView(this.f30355h, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void l() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "startProgressTimer: ", Integer.valueOf(hashCode()));
        m();
        this.j = new Timer();
        a aVar = new a();
        this.l = aVar;
        this.j.schedule(aVar, 0L, 300L);
    }

    public void m() {
        Timer timer = this.j;
        if (timer != null) {
            timer.cancel();
        }
        a aVar = this.l;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void n() {
        this.m = 0L;
    }

    public void o() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new reset ", Integer.valueOf(hashCode()));
        m();
        b();
        removeAllViews();
        ((AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).abandonAudioFocus(f30348b);
        d.a(getContext()).getWindow().clearFlags(128);
        com.bytedance.sdk.openadsdk.video.c.a aVar = this.f30352e;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setMediaInterface(Class cls) {
        o();
        this.f30353f = cls;
    }

    public void setState(int i2) {
        switch (i2) {
            case 0:
                b();
                return;
            case 1:
                c();
                return;
            case 2:
                e();
                return;
            case 3:
                d();
                return;
            case 4:
            default:
                return;
            case 5:
                f();
                return;
            case 6:
                g();
                return;
            case 7:
                i();
                return;
            case 8:
                h();
                return;
        }
    }

    public void a(int i2, long j, long j2) {
        this.m = j;
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "onProgress:  progress =", Integer.valueOf(i2), "  position = ", Long.valueOf(j), "  duration=", Long.valueOf(j2));
    }
}
