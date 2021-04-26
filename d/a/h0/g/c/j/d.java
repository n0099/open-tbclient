package d.a.h0.g.c.j;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements d.a.h0.g.c.j.c {

    /* renamed from: f  reason: collision with root package name */
    public String f46182f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46183g;

    /* renamed from: h  reason: collision with root package name */
    public float f46184h;

    /* renamed from: i  reason: collision with root package name */
    public int f46185i;
    public MediaPlayer.OnPreparedListener j;
    public MediaPlayer.OnCompletionListener k;
    public MediaPlayer.OnErrorListener l;
    public MediaPlayer.OnSeekCompleteListener m;
    public d.a.h0.j.a.c n;

    /* renamed from: e  reason: collision with root package name */
    public SwanAudioPlayer f46181e = SwanAudioPlayer.getInstance();
    public Handler o = d.a.h0.g.c.j.b.h().e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 != d.this.f46181e.getState(d.this.f46185i)) {
                d.this.f46181e.play(d.this.f46185i, d.this.f46184h, d.this.f46183g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f46181e.pause(d.this.f46185i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f46188e;

        public c(float f2) {
            this.f46188e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f46181e.seek(d.this.f46185i, (int) this.f46188e);
        }
    }

    /* renamed from: d.a.h0.g.c.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0927d implements Runnable {
        public RunnableC0927d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f46181e.stop(d.this.f46185i);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46191e;

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

        /* renamed from: d.a.h0.g.c.j.d$e$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0928d implements MediaPlayer.OnErrorListener {
            public C0928d() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                if (d.this.l != null) {
                    return d.this.l.onError(mediaPlayer, i2, i3);
                }
                return false;
            }
        }

        /* renamed from: d.a.h0.g.c.j.d$e$e  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0929e implements d.a.h0.j.a.c {
            public C0929e() {
            }

            @Override // d.a.h0.j.a.c
            public void onPause() {
                if (d.this.n != null) {
                    d.this.n.onPause();
                }
            }
        }

        public e(String str) {
            this.f46191e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f46182f = this.f46191e;
            File file = new File(this.f46191e);
            if (!file.exists() || file.isDirectory()) {
                return;
            }
            d dVar = d.this;
            dVar.f46185i = dVar.f46181e.setDataSource(this.f46191e, (int) file.length());
            d.this.f46181e.setOnPreparedListener(d.this.f46185i, new a());
            d.this.f46181e.setOnCompletionListener(d.this.f46185i, new b());
            d.this.f46181e.setOnSeekCompleteListener(d.this.f46185i, new c());
            d.this.f46181e.setOnErrorListener(d.this.f46185i, new C0928d());
            d.this.f46181e.setOnPauseListener(d.this.f46185i, new C0929e());
            d.this.f46181e.prepare(d.this.f46185i);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46198e;

        public f(boolean z) {
            this.f46198e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f46181e.getState(d.this.f46185i)) {
                d.this.f46181e.setLoop(d.this.f46185i, this.f46198e);
            }
            d.this.f46183g = this.f46198e;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f46200e;

        public g(float f2) {
            this.f46200e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f46181e.getState(d.this.f46185i)) {
                d.this.f46181e.setVolume(d.this.f46185i, this.f46200e);
            }
            d.this.f46184h = this.f46200e;
        }
    }

    @Override // d.a.h0.g.c.j.c
    public void a(boolean z) {
        this.o.post(new f(z));
    }

    @Override // d.a.h0.g.c.j.c
    public void c(String str) throws Exception {
        this.o.post(new e(str));
    }

    @Override // d.a.h0.g.c.a
    public void destroy() {
        this.f46181e.release(this.f46185i);
        stop();
    }

    @Override // d.a.h0.g.c.j.c
    public void g(d.a.h0.j.a.c cVar) {
        this.n = cVar;
    }

    @Override // d.a.h0.g.c.a
    public int getDuration() {
        return this.f46181e.getDuration(this.f46185i);
    }

    @Override // d.a.h0.g.c.j.c
    public void h(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // d.a.h0.g.c.j.c
    public void i(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.m = onSeekCompleteListener;
    }

    @Override // d.a.h0.g.c.j.c
    public void l(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.j = onPreparedListener;
    }

    @Override // d.a.h0.g.c.j.c
    public void n(MediaPlayer.OnErrorListener onErrorListener) {
        this.l = onErrorListener;
    }

    @Override // d.a.h0.g.c.j.c
    public void p(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // d.a.h0.g.c.a
    public void pause() {
        this.o.post(new b());
    }

    @Override // d.a.h0.g.c.a
    public void play() {
        this.o.post(new a());
    }

    @Override // d.a.h0.g.c.j.c
    public void s(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.k = onCompletionListener;
    }

    @Override // d.a.h0.g.c.a
    public void seek(float f2) {
        this.o.post(new c(f2));
    }

    @Override // d.a.h0.g.c.a
    public void stop() {
        this.o.post(new RunnableC0927d());
    }

    @Override // d.a.h0.g.c.j.c
    public boolean u() {
        return false;
    }

    @Override // d.a.h0.g.c.j.c
    public void x(float f2) {
        this.o.post(new g(f2));
    }

    @Override // d.a.h0.g.c.a
    public int y() {
        return this.f46181e.getPosition(this.f46185i);
    }
}
