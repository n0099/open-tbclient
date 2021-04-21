package d.b.h0.g.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.b.h0.a.k;
import d.b.h0.g.c.f;
import d.b.h0.g.c.j.a;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48704g = k.f45772a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f48705h;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f48709d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f48710e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f48711f;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f48707b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public String f48708c = f.g();

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.c.i.b f48706a = new d.b.h0.g.c.i.b(this.f48708c);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f48711f = SwanAudioPlayer.getInstance();
            SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
        }
    }

    /* renamed from: d.b.h0.g.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0987b implements Runnable {
        public RunnableC0987b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f48711f.pauseAll();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f48711f.resume();
        }
    }

    static {
        d.b.h0.g.i0.f.d.h();
    }

    public b() {
        c();
        e().post(new a());
    }

    public static b h() {
        if (f48705h == null) {
            synchronized (b.class) {
                if (f48705h == null) {
                    f48705h = new b();
                }
            }
        }
        return f48705h;
    }

    public final void c() {
        if (this.f48709d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f48709d = handlerThread;
            handlerThread.start();
            this.f48710e = new Handler(this.f48709d.getLooper());
        }
    }

    public synchronized d.b.h0.g.c.j.c d(String str, boolean z) {
        if (f48704g) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public Handler e() {
        return this.f48710e;
    }

    public long f(String str) {
        if (this.f48707b.containsKey(str)) {
            return this.f48707b.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.f48707b.put(str, Long.valueOf(parseLong));
                return parseLong;
            } catch (Exception e2) {
                if (f48704g) {
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
        return this.f48708c + f.d(str);
    }

    public boolean i() {
        SwanAudioPlayer swanAudioPlayer = this.f48711f;
        if (swanAudioPlayer != null) {
            swanAudioPlayer.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void j(String str, d.b.h0.g.c.i.a aVar) {
        this.f48706a.e(str, aVar);
    }

    public void k() {
        if (this.f48711f != null) {
            e().post(new c());
        }
    }

    public void l() {
        if (this.f48711f != null) {
            e().postDelayed(new RunnableC0987b(), 50L);
        }
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        d.b.h0.g.c.j.a.f().h(jsArrayBuffer, bVar);
    }
}
