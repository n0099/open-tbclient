package d.a.k.b;

import a.a.a.c.b.ac;
import a.a.a.c.b.shuoy;
import a.a.a.c.b.trw;
import a.a.a.c.bv;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.k.b.b;
import d.a.k.b.c.d;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a implements d.a {

    /* renamed from: f  reason: collision with root package name */
    public static a f44199f;

    /* renamed from: a  reason: collision with root package name */
    public bv f44200a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k.b.c.c f44201b;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f44203d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f44204e = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d> f44202c = new LinkedHashMap();

    /* renamed from: d.a.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0614a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44206f;

        public RunnableC0614a(String str) {
            this.f44206f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f44202c.containsKey(this.f44206f)) {
                a.this.f44202c.remove(this.f44206f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d dVar : a.this.f44202c.values()) {
                if (dVar != null && dVar.isRunning()) {
                    dVar.pause();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d dVar : a.this.f44202c.values()) {
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
        if (f44199f == null) {
            synchronized (a.class) {
                if (f44199f == null) {
                    f44199f = new a();
                }
            }
        }
        return f44199f;
    }

    @Override // d.a.k.b.c.d.a
    public void a(String str, d dVar) {
        this.f44204e.post(new RunnableC0614a(str));
    }

    public void c(String str) {
        String e2 = e(str);
        if (this.f44202c.containsKey(e2)) {
            d dVar = this.f44202c.get(e2);
            if (dVar != null) {
                dVar.cancel();
            }
            this.f44202c.remove(e2);
        }
    }

    public void d() {
        this.f44204e.post(new c());
    }

    public final String e(String str) {
        if (str != null) {
            return String.valueOf(str.hashCode());
        }
        throw new IllegalArgumentException("Tag can't be null!");
    }

    public void f(d.a.k.b.b bVar, String str, d.a.k.b.c.a aVar) {
        String e2 = e(str);
        if (k(e2)) {
            return;
        }
        shuoy shuoyVar = new shuoy(bVar, new ac(this.f44201b, aVar), this.f44203d, e2, this.f44200a, this);
        this.f44202c.put(e2, shuoyVar);
        shuoyVar.start();
    }

    public final void g(d.a.k.b.b bVar, String str, d.a.k.b.c.a aVar, d.a.k.b.c.c cVar) {
        Log.d("RtcDownSo", "start down judge is downloading");
        String e2 = e(str);
        if (k(e2)) {
            return;
        }
        Log.d("RtcDownSo", "real start down ...");
        shuoy shuoyVar = new shuoy(bVar, new ac(cVar, aVar), this.f44203d, e2, this.f44200a, this);
        this.f44202c.put(e2, shuoyVar);
        shuoyVar.start();
    }

    public void h(String str, String str2, String str3, Looper looper, d.a.k.b.c.a aVar) {
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
        int i2 = bvVar.f1457b;
        int i3 = bvVar.f1456a;
        if (i2 > i3) {
            throw new IllegalArgumentException("thread num must < max thread num");
        }
        this.f44200a = bvVar;
        this.f44203d = Executors.newFixedThreadPool(i3);
        this.f44201b = new trw(this.f44204e);
    }

    public final boolean k(String str) {
        d dVar;
        if (!this.f44202c.containsKey(str) || (dVar = this.f44202c.get(str)) == null) {
            return false;
        }
        if (dVar.isRunning()) {
            d.a.k.b.d.c.c("DownloadInfo has been started!");
            return true;
        }
        d.a.k.b.d.c.c("DownloadInfo not started!");
        return false;
    }

    public boolean l(String str) {
        d dVar;
        String e2 = e(str);
        if (!this.f44202c.containsKey(e2) || (dVar = this.f44202c.get(e2)) == null) {
            return false;
        }
        return dVar.isRunning();
    }

    public void m(String str) {
        String e2 = e(str);
        if (this.f44202c.containsKey(e2)) {
            d dVar = this.f44202c.get(e2);
            if (dVar != null && dVar.isRunning()) {
                dVar.pause();
            }
            this.f44202c.remove(e2);
        }
    }

    public void n() {
        this.f44204e.post(new b());
    }
}
