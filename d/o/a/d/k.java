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
    public static volatile k f66906f;

    /* renamed from: e  reason: collision with root package name */
    public long f66911e;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.o.a.d.f.j> f66908b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.o.a.d.f.j> f66909c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f66910d = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f66907a = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.d f66912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.b f66913f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.c f66914g;

        public a(d.o.a.a.a.c.d dVar, d.o.a.a.a.c.b bVar, d.o.a.a.a.c.c cVar) {
            this.f66912e = dVar;
            this.f66913f = bVar;
            this.f66914g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66910d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66912e, this.f66913f, this.f66914g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66912e, this.f66913f, this.f66914g);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66916e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f66917f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f66918g;

        public b(DownloadInfo downloadInfo, BaseException baseException, String str) {
            this.f66916e = downloadInfo;
            this.f66917f = baseException;
            this.f66918g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66910d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66916e, this.f66917f, this.f66918g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66916e, this.f66917f, this.f66918g);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66921f;

        public c(DownloadInfo downloadInfo, String str) {
            this.f66920e = downloadInfo;
            this.f66921f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66910d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66920e, this.f66921f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66920e, this.f66921f);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66924f;

        public d(DownloadInfo downloadInfo, String str) {
            this.f66923e = downloadInfo;
            this.f66924f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66910d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).b(this.f66923e, this.f66924f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).b(this.f66923e, this.f66924f);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66926e;

        public e(DownloadInfo downloadInfo) {
            this.f66926e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66910d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66926e);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66926e);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f {
        public static void a() {
            if (n.f66829c) {
                throw new RuntimeException();
            }
        }

        public static void b(long j, BaseException baseException) {
            if (!n.f66829c) {
                j.c.a().y(j, baseException);
                return;
            }
            throw new RuntimeException(baseException.getErrorMessage());
        }

        public static void c(Throwable th) {
            if (!n.f66829c) {
                th.printStackTrace();
                return;
            }
            throw new RuntimeException(th);
        }
    }

    public static k b() {
        if (f66906f == null) {
            synchronized (k.class) {
                if (f66906f == null) {
                    f66906f = new k();
                }
            }
        }
        return f66906f;
    }

    public d.o.a.d.f.i a(String str) {
        Map<String, d.o.a.d.f.j> map = this.f66909c;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            d.o.a.d.f.j jVar = this.f66909c.get(str);
            if (jVar instanceof d.o.a.d.f.i) {
                return (d.o.a.d.f.i) jVar;
            }
        }
        return null;
    }

    public void d(Context context, int i2, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.a())) {
            return;
        }
        d.o.a.d.f.j jVar = this.f66909c.get(dVar.a());
        if (jVar != null) {
            jVar.b(context).d(i2, eVar).b(dVar).a();
        } else if (!this.f66908b.isEmpty()) {
            o(context, i2, eVar, dVar);
        } else {
            r(context, i2, eVar, dVar);
        }
    }

    public void e(d.o.a.a.a.c.a.a aVar) {
        if (aVar != null) {
            if (d.o.a.e.b.j.a.r().q("fix_listener_oom", false)) {
                this.f66910d.add(new SoftReference(aVar));
            } else {
                this.f66910d.add(aVar);
            }
        }
    }

    public void f(d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar, @Nullable d.o.a.a.a.c.c cVar) {
        this.f66907a.post(new a(dVar, bVar, cVar));
    }

    public void g(DownloadInfo downloadInfo) {
        this.f66907a.post(new e(downloadInfo));
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        this.f66907a.post(new b(downloadInfo, baseException, str));
    }

    public void i(DownloadInfo downloadInfo, String str) {
        this.f66907a.post(new c(downloadInfo, str));
    }

    public void j(String str, int i2) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66909c.get(str)) == null) {
            return;
        }
        if (jVar.a(i2)) {
            this.f66908b.add(jVar);
            this.f66909c.remove(str);
        }
        q();
    }

    public void k(String str, long j, int i2, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        l(str, j, i2, cVar, bVar, null, null);
    }

    public void l(String str, long j, int i2, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, s sVar, d.o.a.a.a.a.n nVar) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66909c.get(str)) == null) {
            return;
        }
        jVar.a(j).a(cVar).e(bVar).f(sVar).c(nVar).b(i2);
    }

    public void m(String str, boolean z) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66909c.get(str)) == null) {
            return;
        }
        jVar.a(z);
    }

    public Handler n() {
        return this.f66907a;
    }

    public final synchronized void o(Context context, int i2, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (this.f66908b.size() <= 0) {
            r(context, i2, eVar, dVar);
        } else {
            d.o.a.d.f.j remove = this.f66908b.remove(0);
            remove.b(context).d(i2, eVar).b(dVar).a();
            this.f66909c.put(dVar.a(), remove);
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        this.f66907a.post(new d(downloadInfo, str));
    }

    public final void q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f66911e < 300000) {
            return;
        }
        this.f66911e = currentTimeMillis;
        if (this.f66908b.isEmpty()) {
            return;
        }
        s();
    }

    public final void r(Context context, int i2, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (dVar == null) {
            return;
        }
        d.o.a.d.f.i iVar = new d.o.a.d.f.i();
        iVar.b(context);
        iVar.d(i2, eVar);
        iVar.b(dVar);
        iVar.a();
        this.f66909c.put(dVar.a(), iVar);
    }

    public final void s() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (d.o.a.d.f.j jVar : this.f66908b) {
            if (!jVar.b() && currentTimeMillis - jVar.d() > 300000) {
                jVar.g();
                arrayList.add(jVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f66908b.removeAll(arrayList);
    }
}
