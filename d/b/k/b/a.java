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
    public static a f63840f;

    /* renamed from: a  reason: collision with root package name */
    public bv f63841a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.k.b.c.c f63842b;

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f63844d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f63845e = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public Map<String, d> f63843c = new LinkedHashMap();

    /* renamed from: d.b.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC1732a implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63847f;

        public RunnableC1732a(String str) {
            this.f63847f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f63843c.containsKey(this.f63847f)) {
                a.this.f63843c.remove(this.f63847f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d dVar : a.this.f63843c.values()) {
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
            for (d dVar : a.this.f63843c.values()) {
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
        if (f63840f == null) {
            synchronized (a.class) {
                if (f63840f == null) {
                    f63840f = new a();
                }
            }
        }
        return f63840f;
    }

    @Override // d.b.k.b.c.d.a
    public void a(String str, d dVar) {
        this.f63845e.post(new RunnableC1732a(str));
    }

    public void c(String str) {
        String e2 = e(str);
        if (this.f63843c.containsKey(e2)) {
            d dVar = this.f63843c.get(e2);
            if (dVar != null) {
                dVar.cancel();
            }
            this.f63843c.remove(e2);
        }
    }

    public void d() {
        this.f63845e.post(new c());
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
        shuoy shuoyVar = new shuoy(bVar, new ac(this.f63842b, aVar), this.f63844d, e2, this.f63841a, this);
        this.f63843c.put(e2, shuoyVar);
        shuoyVar.start();
    }

    public final void g(d.b.k.b.b bVar, String str, d.b.k.b.c.a aVar, d.b.k.b.c.c cVar) {
        Log.d("RtcDownSo", "start down judge is downloading");
        String e2 = e(str);
        if (k(e2)) {
            return;
        }
        Log.d("RtcDownSo", "real start down ...");
        shuoy shuoyVar = new shuoy(bVar, new ac(cVar, aVar), this.f63844d, e2, this.f63841a, this);
        this.f63843c.put(e2, shuoyVar);
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
        this.f63841a = bvVar;
        this.f63844d = Executors.newFixedThreadPool(i2);
        this.f63842b = new trw(this.f63845e);
    }

    public final boolean k(String str) {
        d dVar;
        if (!this.f63843c.containsKey(str) || (dVar = this.f63843c.get(str)) == null) {
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
        if (!this.f63843c.containsKey(e2) || (dVar = this.f63843c.get(e2)) == null) {
            return false;
        }
        return dVar.isRunning();
    }

    public void m(String str) {
        String e2 = e(str);
        if (this.f63843c.containsKey(e2)) {
            d dVar = this.f63843c.get(e2);
            if (dVar != null && dVar.isRunning()) {
                dVar.pause();
            }
            this.f63843c.remove(e2);
        }
    }

    public void n() {
        this.f63845e.post(new b());
    }
}
