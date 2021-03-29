package d.o.a.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.s;
import d.o.a.d.f.n;
import d.o.a.d.j;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static volatile k f66730f;

    /* renamed from: e  reason: collision with root package name */
    public long f66735e;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.o.a.d.f.j> f66732b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.o.a.d.f.j> f66733c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f66734d = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f66731a = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.d f66736e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.b f66737f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.c f66738g;

        public a(d.o.a.a.a.c.d dVar, d.o.a.a.a.c.b bVar, d.o.a.a.a.c.c cVar) {
            this.f66736e = dVar;
            this.f66737f = bVar;
            this.f66738g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66734d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66736e, this.f66737f, this.f66738g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66736e, this.f66737f, this.f66738g);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f66741f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f66742g;

        public b(DownloadInfo downloadInfo, BaseException baseException, String str) {
            this.f66740e = downloadInfo;
            this.f66741f = baseException;
            this.f66742g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66734d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66740e, this.f66741f, this.f66742g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66740e, this.f66741f, this.f66742g);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66744e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66745f;

        public c(DownloadInfo downloadInfo, String str) {
            this.f66744e = downloadInfo;
            this.f66745f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66734d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66744e, this.f66745f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66744e, this.f66745f);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66748f;

        public d(DownloadInfo downloadInfo, String str) {
            this.f66747e = downloadInfo;
            this.f66748f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66734d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).b(this.f66747e, this.f66748f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).b(this.f66747e, this.f66748f);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66750e;

        public e(DownloadInfo downloadInfo) {
            this.f66750e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66734d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66750e);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66750e);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f {
        public static void a() {
            if (n.f66655c) {
                throw new RuntimeException();
            }
        }

        public static void b(long j, BaseException baseException) {
            if (!n.f66655c) {
                j.c.a().y(j, baseException);
                return;
            }
            throw new RuntimeException(baseException.getErrorMessage());
        }

        public static void c(Throwable th) {
            if (!n.f66655c) {
                th.printStackTrace();
                return;
            }
            throw new RuntimeException(th);
        }
    }

    public static k b() {
        if (f66730f == null) {
            synchronized (k.class) {
                if (f66730f == null) {
                    f66730f = new k();
                }
            }
        }
        return f66730f;
    }

    public d.o.a.d.f.i a(String str) {
        Map<String, d.o.a.d.f.j> map = this.f66733c;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            d.o.a.d.f.j jVar = this.f66733c.get(str);
            if (jVar instanceof d.o.a.d.f.i) {
                return (d.o.a.d.f.i) jVar;
            }
        }
        return null;
    }

    public void d(Context context, int i, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.a())) {
            return;
        }
        d.o.a.d.f.j jVar = this.f66733c.get(dVar.a());
        if (jVar != null) {
            jVar.b(context).d(i, eVar).b(dVar).a();
        } else if (!this.f66732b.isEmpty()) {
            o(context, i, eVar, dVar);
        } else {
            r(context, i, eVar, dVar);
        }
    }

    public void e(d.o.a.a.a.c.a.a aVar) {
        if (aVar != null) {
            if (d.o.a.e.b.j.a.r().q("fix_listener_oom", false)) {
                this.f66734d.add(new SoftReference(aVar));
            } else {
                this.f66734d.add(aVar);
            }
        }
    }

    public void f(d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar, @Nullable d.o.a.a.a.c.c cVar) {
        this.f66731a.post(new a(dVar, bVar, cVar));
    }

    public void g(DownloadInfo downloadInfo) {
        this.f66731a.post(new e(downloadInfo));
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        this.f66731a.post(new b(downloadInfo, baseException, str));
    }

    public void i(DownloadInfo downloadInfo, String str) {
        this.f66731a.post(new c(downloadInfo, str));
    }

    public void j(String str, int i) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66733c.get(str)) == null) {
            return;
        }
        if (jVar.a(i)) {
            this.f66732b.add(jVar);
            this.f66733c.remove(str);
        }
        q();
    }

    public void k(String str, long j, int i, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        l(str, j, i, cVar, bVar, null, null);
    }

    public void l(String str, long j, int i, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, s sVar, d.o.a.a.a.a.n nVar) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66733c.get(str)) == null) {
            return;
        }
        jVar.a(j).a(cVar).f(bVar).e(sVar).c(nVar).b(i);
    }

    public void m(String str, boolean z) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66733c.get(str)) == null) {
            return;
        }
        jVar.a(z);
    }

    public Handler n() {
        return this.f66731a;
    }

    public final synchronized void o(Context context, int i, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (this.f66732b.size() <= 0) {
            r(context, i, eVar, dVar);
        } else {
            d.o.a.d.f.j remove = this.f66732b.remove(0);
            remove.b(context).d(i, eVar).b(dVar).a();
            this.f66733c.put(dVar.a(), remove);
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        this.f66731a.post(new d(downloadInfo, str));
    }

    public final void q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f66735e < 300000) {
            return;
        }
        this.f66735e = currentTimeMillis;
        if (this.f66732b.isEmpty()) {
            return;
        }
        s();
    }

    public final void r(Context context, int i, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (dVar == null) {
            return;
        }
        d.o.a.d.f.i iVar = new d.o.a.d.f.i();
        iVar.b(context);
        iVar.d(i, eVar);
        iVar.b(dVar);
        iVar.a();
        this.f66733c.put(dVar.a(), iVar);
    }

    public final void s() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (d.o.a.d.f.j jVar : this.f66732b) {
            if (!jVar.b() && currentTimeMillis - jVar.d() > 300000) {
                jVar.g();
                arrayList.add(jVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f66732b.removeAll(arrayList);
    }
}
