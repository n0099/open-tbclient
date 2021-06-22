package d.a.m0.h.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.a.m0.a.k;
import d.a.m0.h.c.f;
import d.a.m0.h.c.j.a;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f51006g = k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f51007h;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f51011d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f51012e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f51013f;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f51009b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public String f51010c = f.g();

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.h.c.i.b f51008a = new d.a.m0.h.c.i.b(this.f51010c);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f51013f = SwanAudioPlayer.getInstance();
            SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
        }
    }

    /* renamed from: d.a.m0.h.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1073b implements Runnable {
        public RunnableC1073b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f51013f.pauseAll();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f51013f.resume();
        }
    }

    static {
        d.a.m0.a.h2.d.b();
    }

    public b() {
        c();
        e().post(new a());
    }

    public static b h() {
        if (f51007h == null) {
            synchronized (b.class) {
                if (f51007h == null) {
                    f51007h = new b();
                }
            }
        }
        return f51007h;
    }

    public final void c() {
        if (this.f51011d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f51011d = handlerThread;
            handlerThread.start();
            this.f51012e = new Handler(this.f51011d.getLooper());
        }
    }

    public synchronized d.a.m0.h.c.j.c d(String str, boolean z) {
        if (f51006g) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public Handler e() {
        return this.f51012e;
    }

    public long f(String str) {
        if (this.f51009b.containsKey(str)) {
            return this.f51009b.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.f51009b.put(str, Long.valueOf(parseLong));
                return parseLong;
            } catch (Exception e2) {
                if (f51006g) {
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
        return this.f51010c + f.d(str);
    }

    public boolean i() {
        SwanAudioPlayer swanAudioPlayer = this.f51013f;
        if (swanAudioPlayer != null) {
            swanAudioPlayer.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void j(String str, d.a.m0.h.c.i.a aVar) {
        this.f51008a.e(str, aVar);
    }

    public void k() {
        if (this.f51013f != null) {
            e().post(new c());
        }
    }

    public void l() {
        if (this.f51013f != null) {
            e().postDelayed(new RunnableC1073b(), 50L);
        }
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        d.a.m0.h.c.j.a.f().h(jsArrayBuffer, bVar);
    }
}
