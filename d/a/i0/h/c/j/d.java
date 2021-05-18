package d.a.i0.h.c.j;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements d.a.i0.h.c.j.c {

    /* renamed from: f  reason: collision with root package name */
    public String f47060f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47061g;

    /* renamed from: h  reason: collision with root package name */
    public float f47062h;

    /* renamed from: i  reason: collision with root package name */
    public int f47063i;
    public MediaPlayer.OnPreparedListener j;
    public MediaPlayer.OnCompletionListener k;
    public MediaPlayer.OnErrorListener l;
    public MediaPlayer.OnSeekCompleteListener m;
    public d.a.i0.l.a.c n;

    /* renamed from: e  reason: collision with root package name */
    public SwanAudioPlayer f47059e = SwanAudioPlayer.getInstance();
    public Handler o = d.a.i0.h.c.j.b.h().e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 != d.this.f47059e.getState(d.this.f47063i)) {
                d.this.f47059e.play(d.this.f47063i, d.this.f47062h, d.this.f47061g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47059e.pause(d.this.f47063i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f47066e;

        public c(float f2) {
            this.f47066e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47059e.seek(d.this.f47063i, (int) this.f47066e);
        }
    }

    /* renamed from: d.a.i0.h.c.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1004d implements Runnable {
        public RunnableC1004d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47059e.stop(d.this.f47063i);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47069e;

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

        /* renamed from: d.a.i0.h.c.j.d$e$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1005d implements MediaPlayer.OnErrorListener {
            public C1005d() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                if (d.this.l != null) {
                    return d.this.l.onError(mediaPlayer, i2, i3);
                }
                return false;
            }
        }

        /* renamed from: d.a.i0.h.c.j.d$e$e  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1006e implements d.a.i0.l.a.c {
            public C1006e() {
            }

            @Override // d.a.i0.l.a.c
            public void onPause() {
                if (d.this.n != null) {
                    d.this.n.onPause();
                }
            }
        }

        public e(String str) {
            this.f47069e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47060f = this.f47069e;
            File file = new File(this.f47069e);
            if (!file.exists() || file.isDirectory()) {
                return;
            }
            d dVar = d.this;
            dVar.f47063i = dVar.f47059e.setDataSource(this.f47069e, (int) file.length());
            d.this.f47059e.setOnPreparedListener(d.this.f47063i, new a());
            d.this.f47059e.setOnCompletionListener(d.this.f47063i, new b());
            d.this.f47059e.setOnSeekCompleteListener(d.this.f47063i, new c());
            d.this.f47059e.setOnErrorListener(d.this.f47063i, new C1005d());
            d.this.f47059e.setOnPauseListener(d.this.f47063i, new C1006e());
            d.this.f47059e.prepare(d.this.f47063i);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47076e;

        public f(boolean z) {
            this.f47076e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f47059e.getState(d.this.f47063i)) {
                d.this.f47059e.setLoop(d.this.f47063i, this.f47076e);
            }
            d.this.f47061g = this.f47076e;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f47078e;

        public g(float f2) {
            this.f47078e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f47059e.getState(d.this.f47063i)) {
                d.this.f47059e.setVolume(d.this.f47063i, this.f47078e);
            }
            d.this.f47062h = this.f47078e;
        }
    }

    @Override // d.a.i0.h.c.j.c
    public void a(boolean z) {
        this.o.post(new f(z));
    }

    @Override // d.a.i0.h.c.j.c
    public void c(String str) throws Exception {
        this.o.post(new e(str));
    }

    @Override // d.a.i0.h.c.a
    public void destroy() {
        this.f47059e.release(this.f47063i);
        stop();
    }

    @Override // d.a.i0.h.c.j.c
    public void e(d.a.i0.l.a.c cVar) {
        this.n = cVar;
    }

    @Override // d.a.i0.h.c.j.c
    public void g(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // d.a.i0.h.c.a
    public int getDuration() {
        return this.f47059e.getDuration(this.f47063i);
    }

    @Override // d.a.i0.h.c.j.c
    public void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.m = onSeekCompleteListener;
    }

    @Override // d.a.i0.h.c.j.c
    public void j(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.j = onPreparedListener;
    }

    @Override // d.a.i0.h.c.j.c
    public void l(MediaPlayer.OnErrorListener onErrorListener) {
        this.l = onErrorListener;
    }

    @Override // d.a.i0.h.c.j.c
    public void o(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // d.a.i0.h.c.a
    public void pause() {
        this.o.post(new b());
    }

    @Override // d.a.i0.h.c.a
    public void play() {
        this.o.post(new a());
    }

    @Override // d.a.i0.h.c.j.c
    public void r(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.k = onCompletionListener;
    }

    @Override // d.a.i0.h.c.a
    public void seek(float f2) {
        this.o.post(new c(f2));
    }

    @Override // d.a.i0.h.c.a
    public void stop() {
        this.o.post(new RunnableC1004d());
    }

    @Override // d.a.i0.h.c.j.c
    public boolean t() {
        return false;
    }

    @Override // d.a.i0.h.c.j.c
    public void w(float f2) {
        this.o.post(new g(f2));
    }

    @Override // d.a.i0.h.c.a
    public int x() {
        return this.f47059e.getPosition(this.f47063i);
    }
}
