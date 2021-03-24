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
/* loaded from: classes2.dex */
public class a implements d.a {

    /* renamed from: f  reason: collision with root package name */
    public static a f63839f;

    /* renamed from: a  reason: collision with root package name */
    public bv f63840a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.k.b.c.c f63841b;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f63843d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f63844e = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d> f63842c = new LinkedHashMap();

    /* renamed from: d.b.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1731a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63846f;

        public RunnableC1731a(String str) {
            this.f63846f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f63842c.containsKey(this.f63846f)) {
                a.this.f63842c.remove(this.f63846f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d dVar : a.this.f63842c.values()) {
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
            for (d dVar : a.this.f63842c.values()) {
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
        if (f63839f == null) {
            synchronized (a.class) {
                if (f63839f == null) {
                    f63839f = new a();
                }
            }
        }
        return f63839f;
    }

    @Override // d.b.k.b.c.d.a
    public void a(String str, d dVar) {
        this.f63844e.post(new RunnableC1731a(str));
    }

    public void c(String str) {
        String e2 = e(str);
        if (this.f63842c.containsKey(e2)) {
            d dVar = this.f63842c.get(e2);
            if (dVar != null) {
                dVar.cancel();
            }
            this.f63842c.remove(e2);
        }
    }

    public void d() {
        this.f63844e.post(new c());
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
        shuoy shuoyVar = new shuoy(bVar, new ac(this.f63841b, aVar), this.f63843d, e2, this.f63840a, this);
        this.f63842c.put(e2, shuoyVar);
        shuoyVar.start();
    }

    public final void g(d.b.k.b.b bVar, String str, d.b.k.b.c.a aVar, d.b.k.b.c.c cVar) {
        Log.d("RtcDownSo", "start down judge is downloading");
        String e2 = e(str);
        if (k(e2)) {
            return;
        }
        Log.d("RtcDownSo", "real start down ...");
        shuoy shuoyVar = new shuoy(bVar, new ac(cVar, aVar), this.f63843d, e2, this.f63840a, this);
        this.f63842c.put(e2, shuoyVar);
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
        int i = bvVar.f1439b;
        int i2 = bvVar.f1438a;
        if (i > i2) {
            throw new IllegalArgumentException("thread num must < max thread num");
        }
        this.f63840a = bvVar;
        this.f63843d = Executors.newFixedThreadPool(i2);
        this.f63841b = new trw(this.f63844e);
    }

    public final boolean k(String str) {
        d dVar;
        if (!this.f63842c.containsKey(str) || (dVar = this.f63842c.get(str)) == null) {
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
        if (!this.f63842c.containsKey(e2) || (dVar = this.f63842c.get(e2)) == null) {
            return false;
        }
        return dVar.isRunning();
    }

    public void m(String str) {
        String e2 = e(str);
        if (this.f63842c.containsKey(e2)) {
            d dVar = this.f63842c.get(e2);
            if (dVar != null && dVar.isRunning()) {
                dVar.pause();
            }
            this.f63842c.remove(e2);
        }
    }

    public void n() {
        this.f63844e.post(new b());
    }
}
