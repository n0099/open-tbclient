package d.a.i0.h.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.a.i0.a.k;
import d.a.i0.h.c.f;
import d.a.i0.h.c.j.a;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47048g = k.f43025a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f47049h;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f47053d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f47054e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f47055f;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f47051b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public String f47052c = f.g();

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.h.c.i.b f47050a = new d.a.i0.h.c.i.b(this.f47052c);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47055f = SwanAudioPlayer.getInstance();
            SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
        }
    }

    /* renamed from: d.a.i0.h.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1003b implements Runnable {
        public RunnableC1003b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47055f.pauseAll();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47055f.resume();
        }
    }

    static {
        d.a.i0.a.h2.d.b();
    }

    public b() {
        c();
        e().post(new a());
    }

    public static b h() {
        if (f47049h == null) {
            synchronized (b.class) {
                if (f47049h == null) {
                    f47049h = new b();
                }
            }
        }
        return f47049h;
    }

    public final void c() {
        if (this.f47053d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f47053d = handlerThread;
            handlerThread.start();
            this.f47054e = new Handler(this.f47053d.getLooper());
        }
    }

    public synchronized d.a.i0.h.c.j.c d(String str, boolean z) {
        if (f47048g) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public Handler e() {
        return this.f47054e;
    }

    public long f(String str) {
        if (this.f47051b.containsKey(str)) {
            return this.f47051b.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.f47051b.put(str, Long.valueOf(parseLong));
                return parseLong;
            } catch (Exception e2) {
                if (f47048g) {
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
        return this.f47052c + f.d(str);
    }

    public boolean i() {
        SwanAudioPlayer swanAudioPlayer = this.f47055f;
        if (swanAudioPlayer != null) {
            swanAudioPlayer.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void j(String str, d.a.i0.h.c.i.a aVar) {
        this.f47050a.e(str, aVar);
    }

    public void k() {
        if (this.f47055f != null) {
            e().post(new c());
        }
    }

    public void l() {
        if (this.f47055f != null) {
            e().postDelayed(new RunnableC1003b(), 50L);
        }
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        d.a.i0.h.c.j.a.f().h(jsArrayBuffer, bVar);
    }
}
