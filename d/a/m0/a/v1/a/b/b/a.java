package d.a.m0.a.v1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f49058d = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f49059e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.m0.a.v1.a.b.c.a<d.a.m0.a.v1.a.b.a.b>> f49060a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f49061b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0935a f49062c = new HandlerC0935a(Looper.getMainLooper());

    /* renamed from: d.a.m0.a.v1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0935a extends Handler {
        public HandlerC0935a(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f49063e;

        /* renamed from: f  reason: collision with root package name */
        public String f49064f;

        public b(a aVar, String str) {
            this.f49063e = new WeakReference<>(aVar);
            this.f49064f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f49063e.get();
            if (aVar == null) {
                return;
            }
            if (a.f49058d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f49064f);
            }
            d.a.m0.a.v1.a.b.a.b bVar = new d.a.m0.a.v1.a.b.a.b(this.f49064f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    public static a b() {
        if (f49059e == null) {
            synchronized (a.class) {
                if (f49059e == null) {
                    f49059e = new a();
                }
            }
        }
        return f49059e;
    }

    public void c(@NonNull d.a.m0.a.v1.a.b.a.b bVar) {
        d.a.m0.a.v1.a.b.c.a<d.a.m0.a.v1.a.b.a.b> aVar = this.f49060a.get(bVar.c());
        if (aVar == null) {
            if (f49058d) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (f49058d) {
            Log.d("MDelegate-Observe", "notify observer: " + b2);
        }
        aVar.onEvent(bVar);
        if (this.f49061b.containsKey(b2)) {
            if (f49058d) {
                Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
            }
            this.f49062c.removeCallbacks(this.f49061b.get(b2));
            this.f49061b.remove(b2);
        }
        if (aVar.c()) {
            if (f49058d) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
            }
            f(aVar);
        }
    }

    public void d() {
        if (f49058d) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (f49059e == null) {
            return;
        }
        this.f49060a.clear();
        for (Map.Entry<String, Runnable> entry : this.f49061b.entrySet()) {
            if (f49058d) {
                Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
            }
            this.f49062c.removeCallbacks(entry.getValue());
        }
        this.f49061b.clear();
        f49059e = null;
    }

    public void e(d.a.m0.a.v1.a.b.c.a<d.a.m0.a.v1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f49058d) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (this.f49060a.containsKey(b2)) {
            if (f49058d) {
                Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                return;
            }
            return;
        }
        if (f49058d) {
            Log.d("MDelegate-Observe", "register observer: " + b2);
        }
        this.f49060a.put(b2, aVar);
        long a2 = aVar.a();
        if (a2 <= 0 || !aVar.c()) {
            return;
        }
        if (f49058d) {
            Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
        }
        b bVar = new b(this, b2);
        this.f49061b.put(b2, bVar);
        this.f49062c.postDelayed(bVar, a2);
    }

    public void f(d.a.m0.a.v1.a.b.c.a<d.a.m0.a.v1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f49058d) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (!this.f49060a.containsKey(b2)) {
            if (f49058d) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (f49058d) {
            Log.d("MDelegate-Observe", "unregister observer: " + b2);
        }
        this.f49060a.remove(b2);
    }
}
