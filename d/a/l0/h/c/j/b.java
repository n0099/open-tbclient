package d.a.l0.h.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.a.l0.a.k;
import d.a.l0.h.c.f;
import d.a.l0.h.c.j.a;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47224g = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f47225h;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f47229d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f47230e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f47231f;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f47227b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public String f47228c = f.g();

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.h.c.i.b f47226a = new d.a.l0.h.c.i.b(this.f47228c);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47231f = SwanAudioPlayer.getInstance();
            SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
        }
    }

    /* renamed from: d.a.l0.h.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1014b implements Runnable {
        public RunnableC1014b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47231f.pauseAll();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47231f.resume();
        }
    }

    static {
        d.a.l0.a.h2.d.b();
    }

    public b() {
        c();
        e().post(new a());
    }

    public static b h() {
        if (f47225h == null) {
            synchronized (b.class) {
                if (f47225h == null) {
                    f47225h = new b();
                }
            }
        }
        return f47225h;
    }

    public final void c() {
        if (this.f47229d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f47229d = handlerThread;
            handlerThread.start();
            this.f47230e = new Handler(this.f47229d.getLooper());
        }
    }

    public synchronized d.a.l0.h.c.j.c d(String str, boolean z) {
        if (f47224g) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public Handler e() {
        return this.f47230e;
    }

    public long f(String str) {
        if (this.f47227b.containsKey(str)) {
            return this.f47227b.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.f47227b.put(str, Long.valueOf(parseLong));
                return parseLong;
            } catch (Exception e2) {
                if (f47224g) {
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
        return this.f47228c + f.d(str);
    }

    public boolean i() {
        SwanAudioPlayer swanAudioPlayer = this.f47231f;
        if (swanAudioPlayer != null) {
            swanAudioPlayer.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void j(String str, d.a.l0.h.c.i.a aVar) {
        this.f47226a.e(str, aVar);
    }

    public void k() {
        if (this.f47231f != null) {
            e().post(new c());
        }
    }

    public void l() {
        if (this.f47231f != null) {
            e().postDelayed(new RunnableC1014b(), 50L);
        }
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        d.a.l0.h.c.j.a.f().h(jsArrayBuffer, bVar);
    }
}
