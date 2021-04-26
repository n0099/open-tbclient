package d.a.h0.a.n1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43408d = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f43409e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.h0.a.n1.a.b.c.a<d.a.h0.a.n1.a.b.a.b>> f43410a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f43411b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0713a f43412c = new HandlerC0713a(Looper.getMainLooper());

    /* renamed from: d.a.h0.a.n1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0713a extends Handler {
        public HandlerC0713a(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f43413e;

        /* renamed from: f  reason: collision with root package name */
        public String f43414f;

        public b(a aVar, String str) {
            this.f43413e = new WeakReference<>(aVar);
            this.f43414f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f43413e.get();
            if (aVar == null) {
                return;
            }
            if (a.f43408d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f43414f);
            }
            d.a.h0.a.n1.a.b.a.b bVar = new d.a.h0.a.n1.a.b.a.b(this.f43414f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    public static a b() {
        if (f43409e == null) {
            synchronized (a.class) {
                if (f43409e == null) {
                    f43409e = new a();
                }
            }
        }
        return f43409e;
    }

    public void c(@NonNull d.a.h0.a.n1.a.b.a.b bVar) {
        d.a.h0.a.n1.a.b.c.a<d.a.h0.a.n1.a.b.a.b> aVar = this.f43410a.get(bVar.c());
        if (aVar == null) {
            if (f43408d) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (f43408d) {
            Log.d("MDelegate-Observe", "notify observer: " + b2);
        }
        aVar.onEvent(bVar);
        if (this.f43411b.containsKey(b2)) {
            if (f43408d) {
                Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
            }
            this.f43412c.removeCallbacks(this.f43411b.get(b2));
            this.f43411b.remove(b2);
        }
        if (aVar.c()) {
            if (f43408d) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
            }
            f(aVar);
        }
    }

    public void d() {
        if (f43408d) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (f43409e == null) {
            return;
        }
        this.f43410a.clear();
        for (Map.Entry<String, Runnable> entry : this.f43411b.entrySet()) {
            if (f43408d) {
                Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
            }
            this.f43412c.removeCallbacks(entry.getValue());
        }
        this.f43411b.clear();
        f43409e = null;
    }

    public void e(d.a.h0.a.n1.a.b.c.a<d.a.h0.a.n1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f43408d) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (this.f43410a.containsKey(b2)) {
            if (f43408d) {
                Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                return;
            }
            return;
        }
        if (f43408d) {
            Log.d("MDelegate-Observe", "register observer: " + b2);
        }
        this.f43410a.put(b2, aVar);
        long a2 = aVar.a();
        if (a2 <= 0 || !aVar.c()) {
            return;
        }
        if (f43408d) {
            Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
        }
        b bVar = new b(this, b2);
        this.f43411b.put(b2, bVar);
        this.f43412c.postDelayed(bVar, a2);
    }

    public void f(d.a.h0.a.n1.a.b.c.a<d.a.h0.a.n1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f43408d) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (!this.f43410a.containsKey(b2)) {
            if (f43408d) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (f43408d) {
            Log.d("MDelegate-Observe", "unregister observer: " + b2);
        }
        this.f43410a.remove(b2);
    }
}
