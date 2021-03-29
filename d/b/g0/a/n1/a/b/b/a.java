package d.b.g0.a.n1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45344d = k.f45051a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f45345e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.b.g0.a.n1.a.b.c.a<d.b.g0.a.n1.a.b.a.b>> f45346a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f45347b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0742a f45348c = new HandlerC0742a(Looper.getMainLooper());

    /* renamed from: d.b.g0.a.n1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0742a extends Handler {
        public HandlerC0742a(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f45349e;

        /* renamed from: f  reason: collision with root package name */
        public String f45350f;

        public b(a aVar, String str) {
            this.f45349e = new WeakReference<>(aVar);
            this.f45350f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f45349e.get();
            if (aVar == null) {
                return;
            }
            if (a.f45344d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f45350f);
            }
            d.b.g0.a.n1.a.b.a.b bVar = new d.b.g0.a.n1.a.b.a.b(this.f45350f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    public static a b() {
        if (f45345e == null) {
            synchronized (a.class) {
                if (f45345e == null) {
                    f45345e = new a();
                }
            }
        }
        return f45345e;
    }

    public void c(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
        d.b.g0.a.n1.a.b.c.a<d.b.g0.a.n1.a.b.a.b> aVar = this.f45346a.get(bVar.c());
        if (aVar == null) {
            if (f45344d) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (f45344d) {
            Log.d("MDelegate-Observe", "notify observer: " + b2);
        }
        aVar.onEvent(bVar);
        if (this.f45347b.containsKey(b2)) {
            if (f45344d) {
                Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
            }
            this.f45348c.removeCallbacks(this.f45347b.get(b2));
            this.f45347b.remove(b2);
        }
        if (aVar.c()) {
            if (f45344d) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
            }
            f(aVar);
        }
    }

    public void d() {
        if (f45344d) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (f45345e == null) {
            return;
        }
        this.f45346a.clear();
        for (Map.Entry<String, Runnable> entry : this.f45347b.entrySet()) {
            if (f45344d) {
                Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
            }
            this.f45348c.removeCallbacks(entry.getValue());
        }
        this.f45347b.clear();
        f45345e = null;
    }

    public void e(d.b.g0.a.n1.a.b.c.a<d.b.g0.a.n1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f45344d) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (this.f45346a.containsKey(b2)) {
            if (f45344d) {
                Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                return;
            }
            return;
        }
        if (f45344d) {
            Log.d("MDelegate-Observe", "register observer: " + b2);
        }
        this.f45346a.put(b2, aVar);
        long a2 = aVar.a();
        if (a2 <= 0 || !aVar.c()) {
            return;
        }
        if (f45344d) {
            Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
        }
        b bVar = new b(this, b2);
        this.f45347b.put(b2, bVar);
        this.f45348c.postDelayed(bVar, a2);
    }

    public void f(d.b.g0.a.n1.a.b.c.a<d.b.g0.a.n1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f45344d) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (!this.f45346a.containsKey(b2)) {
            if (f45344d) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (f45344d) {
            Log.d("MDelegate-Observe", "unregister observer: " + b2);
        }
        this.f45346a.remove(b2);
    }
}
