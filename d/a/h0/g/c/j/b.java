package d.a.h0.g.c.j;

import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.nalib.audio.SwanAudioPlayer;
import d.a.h0.a.k;
import d.a.h0.g.c.f;
import d.a.h0.g.c.j.a;
import java.net.MalformedURLException;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f46170g = k.f43101a;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f46171h;

    /* renamed from: d  reason: collision with root package name */
    public HandlerThread f46175d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f46176e;

    /* renamed from: f  reason: collision with root package name */
    public SwanAudioPlayer f46177f;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Long> f46173b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public String f46174c = f.g();

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.c.i.b f46172a = new d.a.h0.g.c.i.b(this.f46174c);

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f46177f = SwanAudioPlayer.getInstance();
            SwanAudioPlayer.settingNativeAudioParameters(AppRuntime.getApplication());
        }
    }

    /* renamed from: d.a.h0.g.c.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0926b implements Runnable {
        public RunnableC0926b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f46177f.pauseAll();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f46177f.resume();
        }
    }

    static {
        d.a.h0.g.i0.f.d.h();
    }

    public b() {
        c();
        e().post(new a());
    }

    public static b h() {
        if (f46171h == null) {
            synchronized (b.class) {
                if (f46171h == null) {
                    f46171h = new b();
                }
            }
        }
        return f46171h;
    }

    public final void c() {
        if (this.f46175d == null) {
            HandlerThread handlerThread = new HandlerThread("audio_thread");
            this.f46175d = handlerThread;
            handlerThread.start();
            this.f46176e = new Handler(this.f46175d.getLooper());
        }
    }

    public synchronized d.a.h0.g.c.j.c d(String str, boolean z) {
        if (f46170g) {
            Log.e("AudioPlayerManager", "create media player src = " + str);
        }
        return new d();
    }

    public Handler e() {
        return this.f46176e;
    }

    public long f(String str) {
        if (this.f46173b.containsKey(str)) {
            return this.f46173b.get(str).longValue();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                mediaMetadataRetriever.release();
                this.f46173b.put(str, Long.valueOf(parseLong));
                return parseLong;
            } catch (Exception e2) {
                if (f46170g) {
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
        return this.f46174c + f.d(str);
    }

    public boolean i() {
        SwanAudioPlayer swanAudioPlayer = this.f46177f;
        if (swanAudioPlayer != null) {
            swanAudioPlayer.isAudioPlayer();
            return false;
        }
        return false;
    }

    public void j(String str, d.a.h0.g.c.i.a aVar) {
        this.f46172a.e(str, aVar);
    }

    public void k() {
        if (this.f46177f != null) {
            e().post(new c());
        }
    }

    public void l() {
        if (this.f46177f != null) {
            e().postDelayed(new RunnableC0926b(), 50L);
        }
    }

    public void m(JsArrayBuffer jsArrayBuffer, a.b bVar) {
        d.a.h0.g.c.j.a.f().h(jsArrayBuffer, bVar);
    }
}
