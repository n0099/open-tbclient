package d.a.l0.a.v1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48950d = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f48951e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.l0.a.v1.a.b.c.a<d.a.l0.a.v1.a.b.a.b>> f48952a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f48953b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0932a f48954c = new HandlerC0932a(Looper.getMainLooper());

    /* renamed from: d.a.l0.a.v1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0932a extends Handler {
        public HandlerC0932a(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f48955e;

        /* renamed from: f  reason: collision with root package name */
        public String f48956f;

        public b(a aVar, String str) {
            this.f48955e = new WeakReference<>(aVar);
            this.f48956f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f48955e.get();
            if (aVar == null) {
                return;
            }
            if (a.f48950d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f48956f);
            }
            d.a.l0.a.v1.a.b.a.b bVar = new d.a.l0.a.v1.a.b.a.b(this.f48956f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    public static a b() {
        if (f48951e == null) {
            synchronized (a.class) {
                if (f48951e == null) {
                    f48951e = new a();
                }
            }
        }
        return f48951e;
    }

    public void c(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
        d.a.l0.a.v1.a.b.c.a<d.a.l0.a.v1.a.b.a.b> aVar = this.f48952a.get(bVar.c());
        if (aVar == null) {
            if (f48950d) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (f48950d) {
            Log.d("MDelegate-Observe", "notify observer: " + b2);
        }
        aVar.onEvent(bVar);
        if (this.f48953b.containsKey(b2)) {
            if (f48950d) {
                Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
            }
            this.f48954c.removeCallbacks(this.f48953b.get(b2));
            this.f48953b.remove(b2);
        }
        if (aVar.c()) {
            if (f48950d) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
            }
            f(aVar);
        }
    }

    public void d() {
        if (f48950d) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (f48951e == null) {
            return;
        }
        this.f48952a.clear();
        for (Map.Entry<String, Runnable> entry : this.f48953b.entrySet()) {
            if (f48950d) {
                Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
            }
            this.f48954c.removeCallbacks(entry.getValue());
        }
        this.f48953b.clear();
        f48951e = null;
    }

    public void e(d.a.l0.a.v1.a.b.c.a<d.a.l0.a.v1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f48950d) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (this.f48952a.containsKey(b2)) {
            if (f48950d) {
                Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                return;
            }
            return;
        }
        if (f48950d) {
            Log.d("MDelegate-Observe", "register observer: " + b2);
        }
        this.f48952a.put(b2, aVar);
        long a2 = aVar.a();
        if (a2 <= 0 || !aVar.c()) {
            return;
        }
        if (f48950d) {
            Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
        }
        b bVar = new b(this, b2);
        this.f48953b.put(b2, bVar);
        this.f48954c.postDelayed(bVar, a2);
    }

    public void f(d.a.l0.a.v1.a.b.c.a<d.a.l0.a.v1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f48950d) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (!this.f48952a.containsKey(b2)) {
            if (f48950d) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (f48950d) {
            Log.d("MDelegate-Observe", "unregister observer: " + b2);
        }
        this.f48952a.remove(b2);
    }
}
