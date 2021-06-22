package d.a.m0.h.c.j;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements d.a.m0.h.c.j.c {

    /* renamed from: f  reason: collision with root package name */
    public String f51018f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51019g;

    /* renamed from: h  reason: collision with root package name */
    public float f51020h;

    /* renamed from: i  reason: collision with root package name */
    public int f51021i;
    public MediaPlayer.OnPreparedListener j;
    public MediaPlayer.OnCompletionListener k;
    public MediaPlayer.OnErrorListener l;
    public MediaPlayer.OnSeekCompleteListener m;
    public d.a.m0.l.a.c n;

    /* renamed from: e  reason: collision with root package name */
    public SwanAudioPlayer f51017e = SwanAudioPlayer.getInstance();
    public Handler o = d.a.m0.h.c.j.b.h().e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 != d.this.f51017e.getState(d.this.f51021i)) {
                d.this.f51017e.play(d.this.f51021i, d.this.f51020h, d.this.f51019g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f51017e.pause(d.this.f51021i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f51024e;

        public c(float f2) {
            this.f51024e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f51017e.seek(d.this.f51021i, (int) this.f51024e);
        }
    }

    /* renamed from: d.a.m0.h.c.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1074d implements Runnable {
        public RunnableC1074d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f51017e.stop(d.this.f51021i);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51027e;

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

        /* renamed from: d.a.m0.h.c.j.d$e$d  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1075d implements MediaPlayer.OnErrorListener {
            public C1075d() {
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                if (d.this.l != null) {
                    return d.this.l.onError(mediaPlayer, i2, i3);
                }
                return false;
            }
        }

        /* renamed from: d.a.m0.h.c.j.d$e$e  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1076e implements d.a.m0.l.a.c {
            public C1076e() {
            }

            @Override // d.a.m0.l.a.c
            public void onPause() {
                if (d.this.n != null) {
                    d.this.n.onPause();
                }
            }
        }

        public e(String str) {
            this.f51027e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f51018f = this.f51027e;
            File file = new File(this.f51027e);
            if (!file.exists() || file.isDirectory()) {
                return;
            }
            d dVar = d.this;
            dVar.f51021i = dVar.f51017e.setDataSource(this.f51027e, (int) file.length());
            d.this.f51017e.setOnPreparedListener(d.this.f51021i, new a());
            d.this.f51017e.setOnCompletionListener(d.this.f51021i, new b());
            d.this.f51017e.setOnSeekCompleteListener(d.this.f51021i, new c());
            d.this.f51017e.setOnErrorListener(d.this.f51021i, new C1075d());
            d.this.f51017e.setOnPauseListener(d.this.f51021i, new C1076e());
            d.this.f51017e.prepare(d.this.f51021i);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f51034e;

        public f(boolean z) {
            this.f51034e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f51017e.getState(d.this.f51021i)) {
                d.this.f51017e.setLoop(d.this.f51021i, this.f51034e);
            }
            d.this.f51019g = this.f51034e;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f51036e;

        public g(float f2) {
            this.f51036e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f51017e.getState(d.this.f51021i)) {
                d.this.f51017e.setVolume(d.this.f51021i, this.f51036e);
            }
            d.this.f51020h = this.f51036e;
        }
    }

    @Override // d.a.m0.h.c.j.c
    public void a(boolean z) {
        this.o.post(new f(z));
    }

    @Override // d.a.m0.h.c.j.c
    public void c(String str) throws Exception {
        this.o.post(new e(str));
    }

    @Override // d.a.m0.h.c.a
    public void destroy() {
        this.f51017e.release(this.f51021i);
        stop();
    }

    @Override // d.a.m0.h.c.j.c
    public void e(d.a.m0.l.a.c cVar) {
        this.n = cVar;
    }

    @Override // d.a.m0.h.c.j.c
    public void g(MediaPlayer.OnInfoListener onInfoListener) {
    }

    @Override // d.a.m0.h.c.a
    public int getDuration() {
        return this.f51017e.getDuration(this.f51021i);
    }

    @Override // d.a.m0.h.c.j.c
    public void h(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.m = onSeekCompleteListener;
    }

    @Override // d.a.m0.h.c.j.c
    public void j(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.j = onPreparedListener;
    }

    @Override // d.a.m0.h.c.j.c
    public void l(MediaPlayer.OnErrorListener onErrorListener) {
        this.l = onErrorListener;
    }

    @Override // d.a.m0.h.c.j.c
    public void o(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
    }

    @Override // d.a.m0.h.c.a
    public void pause() {
        this.o.post(new b());
    }

    @Override // d.a.m0.h.c.a
    public void play() {
        this.o.post(new a());
    }

    @Override // d.a.m0.h.c.j.c
    public void r(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.k = onCompletionListener;
    }

    @Override // d.a.m0.h.c.a
    public void seek(float f2) {
        this.o.post(new c(f2));
    }

    @Override // d.a.m0.h.c.a
    public void stop() {
        this.o.post(new RunnableC1074d());
    }

    @Override // d.a.m0.h.c.j.c
    public boolean t() {
        return false;
    }

    @Override // d.a.m0.h.c.j.c
    public void w(float f2) {
        this.o.post(new g(f2));
    }

    @Override // d.a.m0.h.c.a
    public int x() {
        return this.f51017e.getPosition(this.f51021i);
    }
}
