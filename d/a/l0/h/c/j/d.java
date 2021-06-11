package d.a.l0.h.c.j;

import android.media.MediaPlayer;
import android.os.Handler;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import java.io.File;
/* loaded from: classes3.dex */
public class d implements d.a.l0.h.c.j.c {

    /* renamed from: f  reason: collision with root package name */
    public String f50910f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50911g;

    /* renamed from: h  reason: collision with root package name */
    public float f50912h;

    /* renamed from: i  reason: collision with root package name */
    public int f50913i;
    public MediaPlayer.OnPreparedListener j;
    public MediaPlayer.OnCompletionListener k;
    public MediaPlayer.OnErrorListener l;
    public MediaPlayer.OnSeekCompleteListener m;
    public d.a.l0.l.a.c n;

    /* renamed from: e  reason: collision with root package name */
    public SwanAudioPlayer f50909e = SwanAudioPlayer.getInstance();
    public Handler o = d.a.l0.h.c.j.b.h().e();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 != d.this.f50909e.getState(d.this.f50913i)) {
                d.this.f50909e.play(d.this.f50913i, d.this.f50912h, d.this.f50911g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f50909e.pause(d.this.f50913i);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f50916e;

        public c(float f2) {
            this.f50916e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f50909e.seek(d.this.f50913i, (int) this.f50916e);
        }
    }

    /* renamed from: d.a.l0.h.c.j.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1071d implements Runnable {
        public RunnableC1071d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f50909e.stop(d.this.f50913i);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50919e;

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
        public class C1072d implements MediaPlayer.OnErrorListener {
            public C1072d() {
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
        public class C1073e implements d.a.l0.l.a.c {
            public C1073e() {
            }

            @Override // d.a.l0.l.a.c
            public void onPause() {
                if (d.this.n != null) {
                    d.this.n.onPause();
                }
            }
        }

        public e(String str) {
            this.f50919e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f50910f = this.f50919e;
            File file = new File(this.f50919e);
            if (!file.exists() || file.isDirectory()) {
                return;
            }
            d dVar = d.this;
            dVar.f50913i = dVar.f50909e.setDataSource(this.f50919e, (int) file.length());
            d.this.f50909e.setOnPreparedListener(d.this.f50913i, new a());
            d.this.f50909e.setOnCompletionListener(d.this.f50913i, new b());
            d.this.f50909e.setOnSeekCompleteListener(d.this.f50913i, new c());
            d.this.f50909e.setOnErrorListener(d.this.f50913i, new C1072d());
            d.this.f50909e.setOnPauseListener(d.this.f50913i, new C1073e());
            d.this.f50909e.prepare(d.this.f50913i);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50926e;

        public f(boolean z) {
            this.f50926e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f50909e.getState(d.this.f50913i)) {
                d.this.f50909e.setLoop(d.this.f50913i, this.f50926e);
            }
            d.this.f50911g = this.f50926e;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f50928e;

        public g(float f2) {
            this.f50928e = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (2 == d.this.f50909e.getState(d.this.f50913i)) {
                d.this.f50909e.setVolume(d.this.f50913i, this.f50928e);
            }
            d.this.f50912h = this.f50928e;
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
        this.f50909e.release(this.f50913i);
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
        return this.f50909e.getDuration(this.f50913i);
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
        this.o.post(new RunnableC1071d());
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
        return this.f50909e.getPosition(this.f50913i);
    }
}
