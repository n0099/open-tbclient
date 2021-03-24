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
/* loaded from: classes6.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    public static volatile k f66725f;

    /* renamed from: e  reason: collision with root package name */
    public long f66730e;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.o.a.d.f.j> f66727b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.o.a.d.f.j> f66728c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f66729d = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f66726a = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.d f66731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.b f66732f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.c f66733g;

        public a(d.o.a.a.a.c.d dVar, d.o.a.a.a.c.b bVar, d.o.a.a.a.c.c cVar) {
            this.f66731e = dVar;
            this.f66732f = bVar;
            this.f66733g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66729d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66731e, this.f66732f, this.f66733g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66731e, this.f66732f, this.f66733g);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f66736f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f66737g;

        public b(DownloadInfo downloadInfo, BaseException baseException, String str) {
            this.f66735e = downloadInfo;
            this.f66736f = baseException;
            this.f66737g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66729d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66735e, this.f66736f, this.f66737g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66735e, this.f66736f, this.f66737g);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66739e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66740f;

        public c(DownloadInfo downloadInfo, String str) {
            this.f66739e = downloadInfo;
            this.f66740f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66729d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66739e, this.f66740f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66739e, this.f66740f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66742e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66743f;

        public d(DownloadInfo downloadInfo, String str) {
            this.f66742e = downloadInfo;
            this.f66743f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66729d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).b(this.f66742e, this.f66743f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).b(this.f66742e, this.f66743f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66745e;

        public e(DownloadInfo downloadInfo) {
            this.f66745e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66729d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66745e);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66745e);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static void a() {
            if (n.f66650c) {
                throw new RuntimeException();
            }
        }

        public static void b(long j, BaseException baseException) {
            if (!n.f66650c) {
                j.c.a().y(j, baseException);
                return;
            }
            throw new RuntimeException(baseException.getErrorMessage());
        }

        public static void c(Throwable th) {
            if (!n.f66650c) {
                th.printStackTrace();
                return;
            }
            throw new RuntimeException(th);
        }
    }

    public static k b() {
        if (f66725f == null) {
            synchronized (k.class) {
                if (f66725f == null) {
                    f66725f = new k();
                }
            }
        }
        return f66725f;
    }

    public d.o.a.d.f.i a(String str) {
        Map<String, d.o.a.d.f.j> map = this.f66728c;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            d.o.a.d.f.j jVar = this.f66728c.get(str);
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
        d.o.a.d.f.j jVar = this.f66728c.get(dVar.a());
        if (jVar != null) {
            jVar.b(context).d(i, eVar).b(dVar).a();
        } else if (!this.f66727b.isEmpty()) {
            o(context, i, eVar, dVar);
        } else {
            r(context, i, eVar, dVar);
        }
    }

    public void e(d.o.a.a.a.c.a.a aVar) {
        if (aVar != null) {
            if (d.o.a.e.b.j.a.r().q("fix_listener_oom", false)) {
                this.f66729d.add(new SoftReference(aVar));
            } else {
                this.f66729d.add(aVar);
            }
        }
    }

    public void f(d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar, @Nullable d.o.a.a.a.c.c cVar) {
        this.f66726a.post(new a(dVar, bVar, cVar));
    }

    public void g(DownloadInfo downloadInfo) {
        this.f66726a.post(new e(downloadInfo));
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        this.f66726a.post(new b(downloadInfo, baseException, str));
    }

    public void i(DownloadInfo downloadInfo, String str) {
        this.f66726a.post(new c(downloadInfo, str));
    }

    public void j(String str, int i) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66728c.get(str)) == null) {
            return;
        }
        if (jVar.a(i)) {
            this.f66727b.add(jVar);
            this.f66728c.remove(str);
        }
        q();
    }

    public void k(String str, long j, int i, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        l(str, j, i, cVar, bVar, null, null);
    }

    public void l(String str, long j, int i, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, s sVar, d.o.a.a.a.a.n nVar) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66728c.get(str)) == null) {
            return;
        }
        jVar.a(j).a(cVar).f(bVar).e(sVar).c(nVar).b(i);
    }

    public void m(String str, boolean z) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66728c.get(str)) == null) {
            return;
        }
        jVar.a(z);
    }

    public Handler n() {
        return this.f66726a;
    }

    public final synchronized void o(Context context, int i, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (this.f66727b.size() <= 0) {
            r(context, i, eVar, dVar);
        } else {
            d.o.a.d.f.j remove = this.f66727b.remove(0);
            remove.b(context).d(i, eVar).b(dVar).a();
            this.f66728c.put(dVar.a(), remove);
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        this.f66726a.post(new d(downloadInfo, str));
    }

    public final void q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f66730e < 300000) {
            return;
        }
        this.f66730e = currentTimeMillis;
        if (this.f66727b.isEmpty()) {
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
        this.f66728c.put(dVar.a(), iVar);
    }

    public final void s() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (d.o.a.d.f.j jVar : this.f66727b) {
            if (!jVar.b() && currentTimeMillis - jVar.d() > 300000) {
                jVar.g();
                arrayList.add(jVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f66727b.removeAll(arrayList);
    }
}
