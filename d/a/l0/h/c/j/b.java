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
    public static final boolean f50898g = k.f46875a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f50899h;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f50903d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f50904e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f50905f;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f50901b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public String f50902c = f.g();

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.h.c.i.b f50900a = new d.a.l0.h.c.i.b(this.f50902c);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f50905f = SwanAudioPlayer.getInstance();
            SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
        }
    }

    /* renamed from: d.a.l0.h.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1070b implements Runnable {
        public RunnableC1070b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f50905f.pauseAll();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f50905f.resume();
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
        if (f50899h == null) {
            synchronized (b.class) {
                if (f50899h == null) {
                    f50899h = new b();
                }
            }
        }
        return f50899h;
    }

    public final void c() {
        if (this.f50903d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f50903d = handlerThread;
            handlerThread.start();
            this.f50904e = new Handler(this.f50903d.getLooper());
        }
    }

    public synchronized d.a.l0.h.c.j.c d(String str, boolean z) {
        if (f50898g) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public Handler e() {
        return this.f50904e;
    }

    public long f(String str) {
        if (this.f50901b.containsKey(str)) {
            return this.f50901b.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.f50901b.put(str, Long.valueOf(parseLong));
                return parseLong;
            } catch (Exception e2) {
                if (f50898g) {
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
        return this.f50902c + f.d(str);
    }

    public boolean i() {
        SwanAudioPlayer swanAudioPlayer = this.f50905f;
        if (swanAudioPlayer != null) {
            swanAudioPlayer.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void j(String str, d.a.l0.h.c.i.a aVar) {
        this.f50900a.e(str, aVar);
    }

    public void k() {
        if (this.f50905f != null) {
            e().post(new c());
        }
    }

    public void l() {
        if (this.f50905f != null) {
            e().postDelayed(new RunnableC1070b(), 50L);
        }
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        d.a.l0.h.c.j.a.f().h(jsArrayBuffer, bVar);
    }
}
