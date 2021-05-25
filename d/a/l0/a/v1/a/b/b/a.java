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
    public static final boolean f45276d = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f45277e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.l0.a.v1.a.b.c.a<d.a.l0.a.v1.a.b.a.b>> f45278a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f45279b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0876a f45280c = new HandlerC0876a(Looper.getMainLooper());

    /* renamed from: d.a.l0.a.v1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0876a extends Handler {
        public HandlerC0876a(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f45281e;

        /* renamed from: f  reason: collision with root package name */
        public String f45282f;

        public b(a aVar, String str) {
            this.f45281e = new WeakReference<>(aVar);
            this.f45282f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f45281e.get();
            if (aVar == null) {
                return;
            }
            if (a.f45276d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f45282f);
            }
            d.a.l0.a.v1.a.b.a.b bVar = new d.a.l0.a.v1.a.b.a.b(this.f45282f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    public static a b() {
        if (f45277e == null) {
            synchronized (a.class) {
                if (f45277e == null) {
                    f45277e = new a();
                }
            }
        }
        return f45277e;
    }

    public void c(@NonNull d.a.l0.a.v1.a.b.a.b bVar) {
        d.a.l0.a.v1.a.b.c.a<d.a.l0.a.v1.a.b.a.b> aVar = this.f45278a.get(bVar.c());
        if (aVar == null) {
            if (f45276d) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (f45276d) {
            Log.d("MDelegate-Observe", "notify observer: " + b2);
        }
        aVar.onEvent(bVar);
        if (this.f45279b.containsKey(b2)) {
            if (f45276d) {
                Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
            }
            this.f45280c.removeCallbacks(this.f45279b.get(b2));
            this.f45279b.remove(b2);
        }
        if (aVar.c()) {
            if (f45276d) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
            }
            f(aVar);
        }
    }

    public void d() {
        if (f45276d) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (f45277e == null) {
            return;
        }
        this.f45278a.clear();
        for (Map.Entry<String, Runnable> entry : this.f45279b.entrySet()) {
            if (f45276d) {
                Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
            }
            this.f45280c.removeCallbacks(entry.getValue());
        }
        this.f45279b.clear();
        f45277e = null;
    }

    public void e(d.a.l0.a.v1.a.b.c.a<d.a.l0.a.v1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f45276d) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (this.f45278a.containsKey(b2)) {
            if (f45276d) {
                Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                return;
            }
            return;
        }
        if (f45276d) {
            Log.d("MDelegate-Observe", "register observer: " + b2);
        }
        this.f45278a.put(b2, aVar);
        long a2 = aVar.a();
        if (a2 <= 0 || !aVar.c()) {
            return;
        }
        if (f45276d) {
            Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
        }
        b bVar = new b(this, b2);
        this.f45279b.put(b2, bVar);
        this.f45280c.postDelayed(bVar, a2);
    }

    public void f(d.a.l0.a.v1.a.b.c.a<d.a.l0.a.v1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f45276d) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (!this.f45278a.containsKey(b2)) {
            if (f45276d) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (f45276d) {
            Log.d("MDelegate-Observe", "unregister observer: " + b2);
        }
        this.f45278a.remove(b2);
    }
}
