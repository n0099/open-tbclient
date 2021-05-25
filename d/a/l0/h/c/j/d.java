package d.a.l0.h.c.j;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements d.a.l0.h.c.j.c {

    /* renamed from: f  reason: collision with root package name */
    public String f47236f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47237g;

    /* renamed from: h  reason: collision with root package name */
    public float f47238h;

    /* renamed from: i  reason: collision with root package name */
    public int f47239i;
    public MediaPlayer.OnPreparedListener j;
    public MediaPlayer.OnCompletionListener k;
    public MediaPlayer.OnErrorListener l;
    public MediaPlayer.OnSeekCompleteListener m;
    public d.a.l0.l.a.c n;

    /* renamed from: e  reason: collision with root package name */
    public SwanAudioPlayer f47235e = SwanAudioPlayer.getInstance();
    public Handler o = d.a.l0.h.c.j.b.h().e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 != d.this.f47235e.getState(d.this.f47239i)) {
                d.this.f47235e.play(d.this.f47239i, d.this.f47238h, d.this.f47237g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47235e.pause(d.this.f47239i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f47242e;

        public c(float f2) {
            this.f47242e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47235e.seek(d.this.f47239i, (int) this.f47242e);
        }
    }

    /* renamed from: d.a.l0.h.c.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1015d implements Runnable {
        public RunnableC1015d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47235e.stop(d.this.f47239i);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47245e;

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

        /* renamed from: d.a.l0.h.c.j.d$e$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1016d implements MediaPlayer.OnErrorListener {
            public C1016d() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                if (d.this.l != null) {
                    return d.this.l.onError(mediaPlayer, i2, i3);
                }
                return false;
            }
        }

        /* renamed from: d.a.l0.h.c.j.d$e$e  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1017e implements d.a.l0.l.a.c {
            public C1017e() {
            }

            @Override // d.a.l0.l.a.c
            public void onPause() {
                if (d.this.n != null) {
                    d.this.n.onPause();
                }
            }
        }

        public e(String str) {
            this.f47245e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f47236f = this.f47245e;
            File file = new File(this.f47245e);
            if (!file.exists() || file.isDirectory()) {
                return;
            }
            d dVar = d.this;
            dVar.f47239i = dVar.f47235e.setDataSource(this.f47245e, (int) file.length());
            d.this.f47235e.setOnPreparedListener(d.this.f47239i, new a());
            d.this.f47235e.setOnCompletionListener(d.this.f47239i, new b());
            d.this.f47235e.setOnSeekCompleteListener(d.this.f47239i, new c());
            d.this.f47235e.setOnErrorListener(d.this.f47239i, new C1016d());
            d.this.f47235e.setOnPauseListener(d.this.f47239i, new C1017e());
            d.this.f47235e.prepare(d.this.f47239i);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47252e;

        public f(boolean z) {
            this.f47252e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f47235e.getState(d.this.f47239i)) {
                d.this.f47235e.setLoop(d.this.f47239i, this.f47252e);
            }
            d.this.f47237g = this.f47252e;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f47254e;

        public g(float f2) {
            this.f47254e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f47235e.getState(d.this.f47239i)) {
                d.this.f47235e.setVolume(d.this.f47239i, this.f47254e);
            }
            d.this.f47238h = this.f47254e;
        }
    }

    @Override // d.a.l0.h.c.j.c
    public void a(boolean z) {
        this.o.post(new f(z));
    }

    @Override // d.a.l0.h.c.j.c
    public void c(String str) throws Exception {
        this.o.post(new e(str));
    }

    @Override // d.a.l0.h.c.a
    public void destroy() {
        this.f47235e.release(this.f47239i);
        stop();
    }

    @Override // d.a.l0.h.c.j.c
    public void e(d.a.l0.l.a.c cVar) {
        this.n = cVar;
    }

    @Override // d.a.l0.h.c.j.c
    public void g(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // d.a.l0.h.c.a
    public int getDuration() {
        return this.f47235e.getDuration(this.f47239i);
    }

    @Override // d.a.l0.h.c.j.c
    public void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.m = onSeekCompleteListener;
    }

    @Override // d.a.l0.h.c.j.c
    public void j(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.j = onPreparedListener;
    }

    @Override // d.a.l0.h.c.j.c
    public void l(MediaPlayer.OnErrorListener onErrorListener) {
        this.l = onErrorListener;
    }

    @Override // d.a.l0.h.c.j.c
    public void o(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // d.a.l0.h.c.a
    public void pause() {
        this.o.post(new b());
    }

    @Override // d.a.l0.h.c.a
    public void play() {
        this.o.post(new a());
    }

    @Override // d.a.l0.h.c.j.c
    public void r(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.k = onCompletionListener;
    }

    @Override // d.a.l0.h.c.a
    public void seek(float f2) {
        this.o.post(new c(f2));
    }

    @Override // d.a.l0.h.c.a
    public void stop() {
        this.o.post(new RunnableC1015d());
    }

    @Override // d.a.l0.h.c.j.c
    public boolean t() {
        return false;
    }

    @Override // d.a.l0.h.c.j.c
    public void w(float f2) {
        this.o.post(new g(f2));
    }

    @Override // d.a.l0.h.c.a
    public int x() {
        return this.f47235e.getPosition(this.f47239i);
    }
}
