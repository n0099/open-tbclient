package d.b.g0.g.c.j;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements d.b.g0.g.c.j.c {

    /* renamed from: f  reason: collision with root package name */
    public String f48387f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48388g;

    /* renamed from: h  reason: collision with root package name */
    public float f48389h;
    public int i;
    public MediaPlayer.OnPreparedListener j;
    public MediaPlayer.OnCompletionListener k;
    public MediaPlayer.OnErrorListener l;
    public MediaPlayer.OnSeekCompleteListener m;
    public d.b.g0.j.a.c n;

    /* renamed from: e  reason: collision with root package name */
    public SwanAudioPlayer f48386e = SwanAudioPlayer.getInstance();
    public Handler o = d.b.g0.g.c.j.b.h().e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 != d.this.f48386e.getState(d.this.i)) {
                d.this.f48386e.play(d.this.i, d.this.f48389h, d.this.f48388g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f48386e.pause(d.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f48392e;

        public c(float f2) {
            this.f48392e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f48386e.seek(d.this.i, (int) this.f48392e);
        }
    }

    /* renamed from: d.b.g0.g.c.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0968d implements Runnable {
        public RunnableC0968d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f48386e.stop(d.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48395e;

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
        public class C0969d implements MediaPlayer.OnErrorListener {
            public C0969d() {
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
        public class C0970e implements d.b.g0.j.a.c {
            public C0970e() {
            }

            @Override // d.b.g0.j.a.c
            public void onPause() {
                if (d.this.n != null) {
                    d.this.n.onPause();
                }
            }
        }

        public e(String str) {
            this.f48395e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f48387f = this.f48395e;
            File file = new File(this.f48395e);
            if (!file.exists() || file.isDirectory()) {
                return;
            }
            d dVar = d.this;
            dVar.i = dVar.f48386e.setDataSource(this.f48395e, (int) file.length());
            d.this.f48386e.setOnPreparedListener(d.this.i, new a());
            d.this.f48386e.setOnCompletionListener(d.this.i, new b());
            d.this.f48386e.setOnSeekCompleteListener(d.this.i, new c());
            d.this.f48386e.setOnErrorListener(d.this.i, new C0969d());
            d.this.f48386e.setOnPauseListener(d.this.i, new C0970e());
            d.this.f48386e.prepare(d.this.i);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48402e;

        public f(boolean z) {
            this.f48402e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f48386e.getState(d.this.i)) {
                d.this.f48386e.setLoop(d.this.i, this.f48402e);
            }
            d.this.f48388g = this.f48402e;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f48404e;

        public g(float f2) {
            this.f48404e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f48386e.getState(d.this.i)) {
                d.this.f48386e.setVolume(d.this.i, this.f48404e);
            }
            d.this.f48389h = this.f48404e;
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
        this.f48386e.release(this.i);
        stop();
    }

    @Override // d.b.g0.g.c.j.c
    public void e(String str) throws Exception {
        this.o.post(new e(str));
    }

    @Override // d.b.g0.g.c.a
    public int getDuration() {
        return this.f48386e.getDuration(this.i);
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
        this.o.post(new RunnableC0968d());
    }

    @Override // d.b.g0.g.c.j.c
    public void t(float f2) {
        this.o.post(new g(f2));
    }

    @Override // d.b.g0.g.c.a
    public int u() {
        return this.f48386e.getPosition(this.i);
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
