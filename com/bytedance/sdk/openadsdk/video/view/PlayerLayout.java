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
/* loaded from: classes5.dex */
public class PlayerLayout extends FrameLayout implements a.InterfaceC0342a {

    /* renamed from: b  reason: collision with root package name */
    public static AudioManager.OnAudioFocusChangeListener f30186b = new AudioManager.OnAudioFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.video.view.PlayerLayout.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static int f30187d = -1;

    /* renamed from: a  reason: collision with root package name */
    public int f30188a;

    /* renamed from: c  reason: collision with root package name */
    public int f30189c;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.video.c.a f30190e;

    /* renamed from: f  reason: collision with root package name */
    public Class f30191f;

    /* renamed from: g  reason: collision with root package name */
    public TextureView f30192g;

    /* renamed from: h  reason: collision with root package name */
    public SurfaceView f30193h;
    public boolean i;
    public Timer j;
    public AudioManager k;
    public a l;
    public long m;
    public com.bytedance.sdk.openadsdk.video.b.a n;
    public boolean o;

    /* loaded from: classes5.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int i = PlayerLayout.this.f30189c;
            if (i == 5 || i == 6 || i == 3) {
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
            com.bytedance.sdk.openadsdk.video.c.a aVar = (com.bytedance.sdk.openadsdk.video.c.a) this.f30191f.getConstructor(new Class[0]).newInstance(new Object[0]);
            this.f30190e = aVar;
            aVar.a(getContext());
            this.f30190e.b(this.i);
            this.f30190e.a(this.o);
            this.f30190e.a(this);
            this.f30190e.a(this.n);
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
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        this.k = audioManager;
        audioManager.requestAudioFocus(f30186b, 3, 2);
        d.a(getContext()).getWindow().addFlags(128);
        c();
    }

    public void b() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStateNormal ", Integer.valueOf(hashCode()));
        this.f30189c = 0;
        m();
        com.bytedance.sdk.openadsdk.video.c.a aVar = this.f30190e;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void c() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePreparing ", Integer.valueOf(hashCode()));
        this.f30189c = 1;
        n();
    }

    public void d() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePreparingPlaying ", Integer.valueOf(hashCode()));
        this.f30189c = 3;
    }

    public void e() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePreparingChangeUrl ", Integer.valueOf(hashCode()));
        this.f30189c = 2;
        a();
    }

    public void f() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePlaying seekToInAdvance=", Integer.valueOf(this.f30188a), Integer.valueOf(hashCode()));
        if (this.f30189c == 4) {
            int i = this.f30188a;
            if (i != 0) {
                this.f30190e.a(i);
                com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePlaying seekTo");
                this.f30188a = 0;
            } else {
                this.f30190e.a(0);
            }
        }
        this.f30189c = 5;
        l();
    }

    public void g() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStatePause ", Integer.valueOf(hashCode()));
        this.f30189c = 6;
        m();
    }

    public long getCurrentPositionWhenPlaying() {
        int i = this.f30189c;
        if (i == 5 || i == 6 || i == 3) {
            try {
                return this.f30190e.c();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return 0L;
    }

    public long getDuration() {
        try {
            return this.f30190e.d();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public void h() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStateError ", Integer.valueOf(hashCode()));
        this.f30189c = 8;
        m();
    }

    public void i() {
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new onStateAutoComplete ", Integer.valueOf(hashCode()));
        this.f30189c = 7;
        m();
    }

    public void j() {
        com.bytedance.sdk.openadsdk.video.d.a.a("PlayerLayout", "video_new addTextureView ", Integer.valueOf(hashCode()));
        removeAllViews();
        TextureView textureView = new TextureView(getContext().getApplicationContext());
        this.f30192g = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.bytedance.sdk.openadsdk.video.view.PlayerLayout.2
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                com.bytedance.sdk.openadsdk.video.c.a aVar = PlayerLayout.this.f30190e;
                if (aVar != null) {
                    aVar.a(new Surface(surfaceTexture));
                    PlayerLayout.this.f30190e.a();
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "video_new  onSurfaceTextureDestroyed: ");
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        addView(this.f30192g, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void k() {
        com.bytedance.sdk.openadsdk.video.d.a.a("PlayerLayout", "video_new addSurfaceView ", Integer.valueOf(hashCode()));
        removeAllViews();
        SurfaceView surfaceView = new SurfaceView(getContext().getApplicationContext());
        this.f30193h = surfaceView;
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.bytedance.sdk.openadsdk.video.view.PlayerLayout.3
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (PlayerLayout.this.f30190e != null) {
                    surfaceHolder.setType(3);
                    PlayerLayout.this.f30190e.a(surfaceHolder);
                    PlayerLayout.this.f30190e.a();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                com.bytedance.sdk.openadsdk.video.d.a.a("PlayerLayout", "video_new surfaceDestroyed ", Integer.valueOf(hashCode()));
                PlayerLayout playerLayout = PlayerLayout.this;
                com.bytedance.sdk.openadsdk.video.c.a aVar = playerLayout.f30190e;
                if (aVar != null) {
                    playerLayout.f30188a = aVar.c();
                    PlayerLayout.this.f30190e.b();
                    com.bytedance.sdk.openadsdk.video.d.a.a("PlayerLayout", "video_new  ", Integer.valueOf(PlayerLayout.this.f30188a));
                }
            }
        });
        this.f30193h.setZOrderOnTop(true);
        this.f30193h.setZOrderMediaOverlay(true);
        addView(this.f30193h, new FrameLayout.LayoutParams(-1, -1, 17));
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
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(f30186b);
        d.a(getContext()).getWindow().clearFlags(128);
        com.bytedance.sdk.openadsdk.video.c.a aVar = this.f30190e;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void setMediaInterface(Class cls) {
        o();
        this.f30191f = cls;
    }

    public void setState(int i) {
        switch (i) {
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

    public void a(int i, long j, long j2) {
        this.m = j;
        com.bytedance.sdk.openadsdk.video.d.a.b("PlayerLayout", "onProgress:  progress =", Integer.valueOf(i), "  position = ", Long.valueOf(j), "  duration=", Long.valueOf(j2));
    }
}
