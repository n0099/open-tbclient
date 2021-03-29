package d.b.g0.g.c.j;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements d.b.g0.g.c.j.c {

    /* renamed from: f  reason: collision with root package name */
    public String f47995f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47996g;

    /* renamed from: h  reason: collision with root package name */
    public float f47997h;
    public int i;
    public MediaPlayer.OnPreparedListener j;
    public MediaPlayer.OnCompletionListener k;
    public MediaPlayer.OnErrorListener l;
    public MediaPlayer.OnSeekCompleteListener m;
    public d.b.g0.j.a.c n;

    /* renamed from: e  reason: collision with root package name */
    public SwanAudioPlayer f47994e = SwanAudioPlayer.getInstance();
    public Handler o = d.b.g0.g.c.j.b.h().e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 != d.this.f47994e.getState(d.this.i)) {
                d.this.f47994e.play(d.this.i, d.this.f47997h, d.this.f47996g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47994e.pause(d.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f48000e;

        public c(float f2) {
            this.f48000e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47994e.seek(d.this.i, (int) this.f48000e);
        }
    }

    /* renamed from: d.b.g0.g.c.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0956d implements Runnable {
        public RunnableC0956d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47994e.stop(d.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48003e;

        /* loaded from: classes3.dex */
        public class a implements MediaPlayer.OnPreparedListener {
            public a() {
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (d.this.j != null) {
                    d.this.j.onPrepared(mediaPlayer);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements MediaPlayer.OnCompletionListener {
            public b() {
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (d.this.k != null) {
                    d.this.k.onCompletion(mediaPlayer);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements MediaPlayer.OnSeekCompleteListener {
            public c() {
            }

            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(MediaPlayer mediaPlayer) {
                if (d.this.m != null) {
                    d.this.m.onSeekComplete(mediaPlayer);
                }
            }
        }

        /* renamed from: d.b.g0.g.c.j.d$e$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0957d implements MediaPlayer.OnErrorListener {
            public C0957d() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (d.this.l != null) {
                    return d.this.l.onError(mediaPlayer, i, i2);
                }
                return false;
            }
        }

        /* renamed from: d.b.g0.g.c.j.d$e$e  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0958e implements d.b.g0.j.a.c {
            public C0958e() {
            }

            @Override // d.b.g0.j.a.c
            public void onPause() {
                if (d.this.n != null) {
                    d.this.n.onPause();
                }
            }
        }

        public e(String str) {
            this.f48003e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47995f = this.f48003e;
            File file = new File(this.f48003e);
            if (!file.exists() || file.isDirectory()) {
                return;
            }
            d dVar = d.this;
            dVar.i = dVar.f47994e.setDataSource(this.f48003e, (int) file.length());
            d.this.f47994e.setOnPreparedListener(d.this.i, new a());
            d.this.f47994e.setOnCompletionListener(d.this.i, new b());
            d.this.f47994e.setOnSeekCompleteListener(d.this.i, new c());
            d.this.f47994e.setOnErrorListener(d.this.i, new C0957d());
            d.this.f47994e.setOnPauseListener(d.this.i, new C0958e());
            d.this.f47994e.prepare(d.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48010e;

        public f(boolean z) {
            this.f48010e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f47994e.getState(d.this.i)) {
                d.this.f47994e.setLoop(d.this.i, this.f48010e);
            }
            d.this.f47996g = this.f48010e;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f48012e;

        public g(float f2) {
            this.f48012e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f47994e.getState(d.this.i)) {
                d.this.f47994e.setVolume(d.this.i, this.f48012e);
            }
            d.this.f47997h = this.f48012e;
        }
    }

    @Override // d.b.g0.g.c.j.c
    public void a(boolean z) {
        this.o.post(new f(z));
    }

    @Override // d.b.g0.g.c.j.c
    public void b(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // d.b.g0.g.c.a
    public void destroy() {
        this.f47994e.release(this.i);
        stop();
    }

    @Override // d.b.g0.g.c.j.c
    public void e(String str) throws Exception {
        this.o.post(new e(str));
    }

    @Override // d.b.g0.g.c.a
    public int getDuration() {
        return this.f47994e.getDuration(this.i);
    }

    @Override // d.b.g0.g.c.j.c
    public void j(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.k = onCompletionListener;
    }

    @Override // d.b.g0.g.c.j.c
    public void m(d.b.g0.j.a.c cVar) {
        this.n = cVar;
    }

    @Override // d.b.g0.g.c.j.c
    public boolean n() {
        return false;
    }

    @Override // d.b.g0.g.c.j.c
    public void p(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // d.b.g0.g.c.a
    public void pause() {
        this.o.post(new b());
    }

    @Override // d.b.g0.g.c.a
    public void play() {
        this.o.post(new a());
    }

    @Override // d.b.g0.g.c.j.c
    public void r(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.m = onSeekCompleteListener;
    }

    @Override // d.b.g0.g.c.a
    public void seek(float f2) {
        this.o.post(new c(f2));
    }

    @Override // d.b.g0.g.c.a
    public void stop() {
        this.o.post(new RunnableC0956d());
    }

    @Override // d.b.g0.g.c.j.c
    public void t(float f2) {
        this.o.post(new g(f2));
    }

    @Override // d.b.g0.g.c.a
    public int u() {
        return this.f47994e.getPosition(this.i);
    }

    @Override // d.b.g0.g.c.j.c
    public void x(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.j = onPreparedListener;
    }

    @Override // d.b.g0.g.c.j.c
    public void y(MediaPlayer.OnErrorListener onErrorListener) {
        this.l = onErrorListener;
    }
}
