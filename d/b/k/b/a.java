package d.b.k.b;

import a.a.a.c.b.ac;
import a.a.a.c.b.shuoy;
import a.a.a.c.b.trw;
import a.a.a.c.bv;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.k.b.b;
import d.b.k.b.c.d;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class a implements d.a {

    /* renamed from: f  reason: collision with root package name */
    public static a f64756f;

    /* renamed from: a  reason: collision with root package name */
    public bv f64757a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.k.b.c.c f64758b;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f64760d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f64761e = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d> f64759c = new LinkedHashMap();

    /* renamed from: d.b.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC1760a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64763f;

        public RunnableC1760a(String str) {
            this.f64763f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64759c.containsKey(this.f64763f)) {
                a.this.f64759c.remove(this.f64763f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d dVar : a.this.f64759c.values()) {
                if (dVar != null && dVar.isRunning()) {
                    dVar.pause();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d dVar : a.this.f64759c.values()) {
                if (dVar != null && dVar.isRunning()) {
                    dVar.cancel();
                }
            }
        }
    }

    public a() {
        j(new bv());
    }

    public static a i() {
        if (f64756f == null) {
            synchronized (a.class) {
                if (f64756f == null) {
                    f64756f = new a();
                }
            }
        }
        return f64756f;
    }

    @Override // d.b.k.b.c.d.a
    public void a(String str, d dVar) {
        this.f64761e.post(new RunnableC1760a(str));
    }

    public void c(String str) {
        String e2 = e(str);
        if (this.f64759c.containsKey(e2)) {
            d dVar = this.f64759c.get(e2);
            if (dVar != null) {
                dVar.cancel();
            }
            this.f64759c.remove(e2);
        }
    }

    public void d() {
        this.f64761e.post(new c());
    }

    public final String e(String str) {
        if (str != null) {
            return String.valueOf(str.hashCode());
        }
        throw new IllegalArgumentException("Tag can't be null!");
    }

    public void f(d.b.k.b.b bVar, String str, d.b.k.b.c.a aVar) {
        String e2 = e(str);
        if (k(e2)) {
            return;
        }
        shuoy shuoyVar = new shuoy(bVar, new ac(this.f64758b, aVar), this.f64760d, e2, this.f64757a, this);
        this.f64759c.put(e2, shuoyVar);
        shuoyVar.start();
    }

    public final void g(d.b.k.b.b bVar, String str, d.b.k.b.c.a aVar, d.b.k.b.c.c cVar) {
        Log.d("RtcDownSo", "start down judge is downloading");
        String e2 = e(str);
        if (k(e2)) {
            return;
        }
        Log.d("RtcDownSo", "real start down ...");
        shuoy shuoyVar = new shuoy(bVar, new ac(cVar, aVar), this.f64760d, e2, this.f64757a, this);
        this.f64759c.put(e2, shuoyVar);
        shuoyVar.start();
    }

    public void h(String str, String str2, String str3, Looper looper, d.b.k.b.c.a aVar) {
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        b.a aVar2 = new b.a();
        aVar2.d(str);
        aVar2.b(new File(str2));
        aVar2.c(str3);
        g(aVar2.a(), str, aVar, new trw(new Handler(looper)));
    }

    public final void j(@NonNull bv bvVar) {
        int i = bvVar.f1425b;
        int i2 = bvVar.f1424a;
        if (i > i2) {
            throw new IllegalArgumentException("thread num must < max thread num");
        }
        this.f64757a = bvVar;
        this.f64760d = Executors.newFixedThreadPool(i2);
        this.f64758b = new trw(this.f64761e);
    }

    public final boolean k(String str) {
        d dVar;
        if (!this.f64759c.containsKey(str) || (dVar = this.f64759c.get(str)) == null) {
            return false;
        }
        if (dVar.isRunning()) {
            d.b.k.b.d.c.c("DownloadInfo has been started!");
            return true;
        }
        d.b.k.b.d.c.c("DownloadInfo not started!");
        return false;
    }

    public boolean l(String str) {
        d dVar;
        String e2 = e(str);
        if (!this.f64759c.containsKey(e2) || (dVar = this.f64759c.get(e2)) == null) {
            return false;
        }
        return dVar.isRunning();
    }

    public void m(String str) {
        String e2 = e(str);
        if (this.f64759c.containsKey(e2)) {
            d dVar = this.f64759c.get(e2);
            if (dVar != null && dVar.isRunning()) {
                dVar.pause();
            }
            this.f64759c.remove(e2);
        }
    }

    public void n() {
        this.f64761e.post(new b());
    }
}
