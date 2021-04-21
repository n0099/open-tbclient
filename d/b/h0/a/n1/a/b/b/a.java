package d.b.h0.a.n1.a.b.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.h0.a.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46065d = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f46066e;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.b.h0.a.n1.a.b.c.a<d.b.h0.a.n1.a.b.a.b>> f46067a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Runnable> f46068b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HandlerC0774a f46069c = new HandlerC0774a(Looper.getMainLooper());

    /* renamed from: d.b.h0.a.n1.a.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0774a extends Handler {
        public HandlerC0774a(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<a> f46070e;

        /* renamed from: f  reason: collision with root package name */
        public String f46071f;

        public b(a aVar, String str) {
            this.f46070e = new WeakReference<>(aVar);
            this.f46071f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f46070e.get();
            if (aVar == null) {
                return;
            }
            if (a.f46065d) {
                Log.d("MDelegate-Observe", "run: observer timeout " + this.f46071f);
            }
            d.b.h0.a.n1.a.b.a.b bVar = new d.b.h0.a.n1.a.b.a.b(this.f46071f);
            bVar.b(null);
            aVar.c(bVar);
        }
    }

    public static a b() {
        if (f46066e == null) {
            synchronized (a.class) {
                if (f46066e == null) {
                    f46066e = new a();
                }
            }
        }
        return f46066e;
    }

    public void c(@NonNull d.b.h0.a.n1.a.b.a.b bVar) {
        d.b.h0.a.n1.a.b.c.a<d.b.h0.a.n1.a.b.a.b> aVar = this.f46067a.get(bVar.c());
        if (aVar == null) {
            if (f46065d) {
                Log.e("MDelegate-Observe", "notify a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (f46065d) {
            Log.d("MDelegate-Observe", "notify observer: " + b2);
        }
        aVar.onEvent(bVar);
        if (this.f46068b.containsKey(b2)) {
            if (f46065d) {
                Log.d("MDelegate-Observe", "remove observer: " + b2 + " timeout runnable");
            }
            this.f46069c.removeCallbacks(this.f46068b.get(b2));
            this.f46068b.remove(b2);
        }
        if (aVar.c()) {
            if (f46065d) {
                Log.d("MDelegate-Observe", "auto unregister disposable observer: " + b2);
            }
            f(aVar);
        }
    }

    public void d() {
        if (f46065d) {
            Log.d("MDelegate-Observe", "release observable");
        }
        if (f46066e == null) {
            return;
        }
        this.f46067a.clear();
        for (Map.Entry<String, Runnable> entry : this.f46068b.entrySet()) {
            if (f46065d) {
                Log.d("MDelegate-Observe", "remove observer: " + entry.getKey() + " timeout runnable");
            }
            this.f46069c.removeCallbacks(entry.getValue());
        }
        this.f46068b.clear();
        f46066e = null;
    }

    public void e(d.b.h0.a.n1.a.b.c.a<d.b.h0.a.n1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f46065d) {
                Log.e("MDelegate-Observe", "register a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (this.f46067a.containsKey(b2)) {
            if (f46065d) {
                Log.e("MDelegate-Observe", "multiple register observer：" + b2);
                return;
            }
            return;
        }
        if (f46065d) {
            Log.d("MDelegate-Observe", "register observer: " + b2);
        }
        this.f46067a.put(b2, aVar);
        long a2 = aVar.a();
        if (a2 <= 0 || !aVar.c()) {
            return;
        }
        if (f46065d) {
            Log.d("MDelegate-Observe", "post observer: " + b2 + " " + a2 + "ms timeout runnable");
        }
        b bVar = new b(this, b2);
        this.f46068b.put(b2, bVar);
        this.f46069c.postDelayed(bVar, a2);
    }

    public void f(d.b.h0.a.n1.a.b.c.a<d.b.h0.a.n1.a.b.a.b> aVar) {
        if (aVar == null) {
            if (f46065d) {
                Log.e("MDelegate-Observe", "unregister a null observer");
                return;
            }
            return;
        }
        String b2 = aVar.b();
        if (!this.f46067a.containsKey(b2)) {
            if (f46065d) {
                Log.e("MDelegate-Observe", "unregister a nonexistent observer");
                return;
            }
            return;
        }
        if (f46065d) {
            Log.d("MDelegate-Observe", "unregister observer: " + b2);
        }
        this.f46067a.remove(b2);
    }
}
