package d.b.g0.g.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.b.g0.a.k;
import d.b.g0.g.c.f;
import d.b.g0.g.c.j.a;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48375g = k.f45443a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f48376h;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f48380d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f48381e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f48382f;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f48378b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public String f48379c = f.g();

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.c.i.b f48377a = new d.b.g0.g.c.i.b(this.f48379c);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f48382f = SwanAudioPlayer.getInstance();
            SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
        }
    }

    /* renamed from: d.b.g0.g.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0967b implements Runnable {
        public RunnableC0967b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f48382f.pauseAll();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f48382f.resume();
        }
    }

    static {
        d.b.g0.g.i0.f.d.h();
    }

    public b() {
        c();
        e().post(new a());
    }

    public static b h() {
        if (f48376h == null) {
            synchronized (b.class) {
                if (f48376h == null) {
                    f48376h = new b();
                }
            }
        }
        return f48376h;
    }

    public final void c() {
        if (this.f48380d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f48380d = handlerThread;
            handlerThread.start();
            this.f48381e = new Handler(this.f48380d.getLooper());
        }
    }

    public synchronized d.b.g0.g.c.j.c d(String str, boolean z) {
        if (f48375g) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public Handler e() {
        return this.f48381e;
    }

    public long f(String str) {
        if (this.f48378b.containsKey(str)) {
            return this.f48378b.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.f48378b.put(str, Long.valueOf(parseLong));
                return parseLong;
            } catch (Exception e2) {
                if (f48375g) {
                    e2.printStackTrace();
                }
                mediaMetadataRetriever.release();
                return 0L;
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    public String g(String str) throws MalformedURLException {
        return this.f48379c + f.d(str);
    }

    public boolean i() {
        SwanAudioPlayer swanAudioPlayer = this.f48382f;
        if (swanAudioPlayer != null) {
            swanAudioPlayer.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void j(String str, d.b.g0.g.c.i.a aVar) {
        this.f48377a.e(str, aVar);
    }

    public void k() {
        if (this.f48382f != null) {
            e().post(new c());
        }
    }

    public void l() {
        if (this.f48382f != null) {
            e().postDelayed(new RunnableC0967b(), 50L);
        }
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        d.b.g0.g.c.j.a.f().h(jsArrayBuffer, bVar);
    }
}
