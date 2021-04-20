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
    public static volatile k f67723f;

    /* renamed from: e  reason: collision with root package name */
    public long f67728e;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.o.a.d.f.j> f67725b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.o.a.d.f.j> f67726c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f67727d = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f67724a = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.d f67729e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.b f67730f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.c f67731g;

        public a(d.o.a.a.a.c.d dVar, d.o.a.a.a.c.b bVar, d.o.a.a.a.c.c cVar) {
            this.f67729e = dVar;
            this.f67730f = bVar;
            this.f67731g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67727d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f67729e, this.f67730f, this.f67731g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f67729e, this.f67730f, this.f67731g);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67733e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f67734f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f67735g;

        public b(DownloadInfo downloadInfo, BaseException baseException, String str) {
            this.f67733e = downloadInfo;
            this.f67734f = baseException;
            this.f67735g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67727d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f67733e, this.f67734f, this.f67735g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f67733e, this.f67734f, this.f67735g);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67737e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67738f;

        public c(DownloadInfo downloadInfo, String str) {
            this.f67737e = downloadInfo;
            this.f67738f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67727d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f67737e, this.f67738f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f67737e, this.f67738f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67741f;

        public d(DownloadInfo downloadInfo, String str) {
            this.f67740e = downloadInfo;
            this.f67741f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67727d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).b(this.f67740e, this.f67741f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).b(this.f67740e, this.f67741f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67743e;

        public e(DownloadInfo downloadInfo) {
            this.f67743e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67727d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f67743e);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f67743e);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static void a() {
            if (n.f67648c) {
                throw new RuntimeException();
            }
        }

        public static void b(long j, BaseException baseException) {
            if (!n.f67648c) {
                j.c.a().y(j, baseException);
                return;
            }
            throw new RuntimeException(baseException.getErrorMessage());
        }

        public static void c(Throwable th) {
            if (!n.f67648c) {
                th.printStackTrace();
                return;
            }
            throw new RuntimeException(th);
        }
    }

    public static k b() {
        if (f67723f == null) {
            synchronized (k.class) {
                if (f67723f == null) {
                    f67723f = new k();
                }
            }
        }
        return f67723f;
    }

    public d.o.a.d.f.i a(String str) {
        Map<String, d.o.a.d.f.j> map = this.f67726c;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            d.o.a.d.f.j jVar = this.f67726c.get(str);
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
        d.o.a.d.f.j jVar = this.f67726c.get(dVar.a());
        if (jVar != null) {
            jVar.b(context).d(i, eVar).b(dVar).a();
        } else if (!this.f67725b.isEmpty()) {
            o(context, i, eVar, dVar);
        } else {
            r(context, i, eVar, dVar);
        }
    }

    public void e(d.o.a.a.a.c.a.a aVar) {
        if (aVar != null) {
            if (d.o.a.e.b.j.a.r().q("fix_listener_oom", false)) {
                this.f67727d.add(new SoftReference(aVar));
            } else {
                this.f67727d.add(aVar);
            }
        }
    }

    public void f(d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar, @Nullable d.o.a.a.a.c.c cVar) {
        this.f67724a.post(new a(dVar, bVar, cVar));
    }

    public void g(DownloadInfo downloadInfo) {
        this.f67724a.post(new e(downloadInfo));
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        this.f67724a.post(new b(downloadInfo, baseException, str));
    }

    public void i(DownloadInfo downloadInfo, String str) {
        this.f67724a.post(new c(downloadInfo, str));
    }

    public void j(String str, int i) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f67726c.get(str)) == null) {
            return;
        }
        if (jVar.a(i)) {
            this.f67725b.add(jVar);
            this.f67726c.remove(str);
        }
        q();
    }

    public void k(String str, long j, int i, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        l(str, j, i, cVar, bVar, null, null);
    }

    public void l(String str, long j, int i, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, s sVar, d.o.a.a.a.a.n nVar) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f67726c.get(str)) == null) {
            return;
        }
        jVar.a(j).a(cVar).f(bVar).e(sVar).c(nVar).b(i);
    }

    public void m(String str, boolean z) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f67726c.get(str)) == null) {
            return;
        }
        jVar.a(z);
    }

    public Handler n() {
        return this.f67724a;
    }

    public final synchronized void o(Context context, int i, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (this.f67725b.size() <= 0) {
            r(context, i, eVar, dVar);
        } else {
            d.o.a.d.f.j remove = this.f67725b.remove(0);
            remove.b(context).d(i, eVar).b(dVar).a();
            this.f67726c.put(dVar.a(), remove);
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        this.f67724a.post(new d(downloadInfo, str));
    }

    public final void q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f67728e < 300000) {
            return;
        }
        this.f67728e = currentTimeMillis;
        if (this.f67725b.isEmpty()) {
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
        this.f67726c.put(dVar.a(), iVar);
    }

    public final void s() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (d.o.a.d.f.j jVar : this.f67725b) {
            if (!jVar.b() && currentTimeMillis - jVar.d() > 300000) {
                jVar.g();
                arrayList.add(jVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f67725b.removeAll(arrayList);
    }
}
