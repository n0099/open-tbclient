package d.a.i0.a.v1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45100d = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f45101e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.i0.a.v1.a.b.c.a<d.a.i0.a.v1.a.b.a.b>> f45102a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f45103b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0865a f45104c = new HandlerC0865a(Looper.getMainLooper());

    /* renamed from: d.a.i0.a.v1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0865a extends Handler {
        public HandlerC0865a(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f45105e;

        /* renamed from: f  reason: collision with root package name */
        public String f45106f;

        public b(a aVar, String str) {
            this.f45105e = new WeakReference<>(aVar);
            this.f45106f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f45105e.get();
            if (aVar == null) {
                return;
            }
            if (a.f45100d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f45106f);
            }
            d.a.i0.a.v1.a.b.a.b bVar = new d.a.i0.a.v1.a.b.a.b(this.f45106f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    public static a b() {
        if (f45101e == null) {
            synchronized (a.class) {
                if (f45101e == null) {
                    f45101e = new a();
                }
            }
        }
        return f45101e;
    }

    public void c(@NonNull d.a.i0.a.v1.a.b.a.b bVar) {
        d.a.i0.a.v1.a.b.c.a<d.a.i0.a.v1.a.b.a.b> aVar = this.f45102a.get(bVar.c());
        if (aVar == null) {
            if (f45100d) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (f45100d) {
            Log.d("MDelegate-Observe", "notify observer: " + b2);
        }
        aVar.onEvent(bVar);
        if (this.f45103b.containsKey(b2)) {
            if (f45100d) {
                Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
            }
            this.f45104c.removeCallbacks(this.f45103b.get(b2));
            this.f45103b.remove(b2);
        }
        if (aVar.c()) {
            if (f45100d) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
            }
            f(aVar);
        }
    }

    public void d() {
        if (f45100d) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (f45101e == null) {
            return;
        }
        this.f45102a.clear();
        for (Map.Entry<String, Runnable> entry : this.f45103b.entrySet()) {
            if (f45100d) {
                Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
            }
            this.f45104c.removeCallbacks(entry.getValue());
        }
        this.f45103b.clear();
        f45101e = null;
    }

    public void e(d.a.i0.a.v1.a.b.c.a<d.a.i0.a.v1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f45100d) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (this.f45102a.containsKey(b2)) {
            if (f45100d) {
                Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                return;
            }
            return;
        }
        if (f45100d) {
            Log.d("MDelegate-Observe", "register observer: " + b2);
        }
        this.f45102a.put(b2, aVar);
        long a2 = aVar.a();
        if (a2 <= 0 || !aVar.c()) {
            return;
        }
        if (f45100d) {
            Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
        }
        b bVar = new b(this, b2);
        this.f45103b.put(b2, bVar);
        this.f45104c.postDelayed(bVar, a2);
    }

    public void f(d.a.i0.a.v1.a.b.c.a<d.a.i0.a.v1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f45100d) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (!this.f45102a.containsKey(b2)) {
            if (f45100d) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (f45100d) {
            Log.d("MDelegate-Observe", "unregister observer: " + b2);
        }
        this.f45102a.remove(b2);
    }
}
