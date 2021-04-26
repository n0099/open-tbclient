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
    public static volatile k f66220f;

    /* renamed from: e  reason: collision with root package name */
    public long f66225e;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.o.a.d.f.j> f66222b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.o.a.d.f.j> f66223c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f66224d = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f66221a = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.d f66226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.b f66227f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.o.a.a.a.c.c f66228g;

        public a(d.o.a.a.a.c.d dVar, d.o.a.a.a.c.b bVar, d.o.a.a.a.c.c cVar) {
            this.f66226e = dVar;
            this.f66227f = bVar;
            this.f66228g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66224d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66226e, this.f66227f, this.f66228g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66226e, this.f66227f, this.f66228g);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66230e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f66231f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f66232g;

        public b(DownloadInfo downloadInfo, BaseException baseException, String str) {
            this.f66230e = downloadInfo;
            this.f66231f = baseException;
            this.f66232g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66224d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66230e, this.f66231f, this.f66232g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66230e, this.f66231f, this.f66232g);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66235f;

        public c(DownloadInfo downloadInfo, String str) {
            this.f66234e = downloadInfo;
            this.f66235f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66224d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66234e, this.f66235f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66234e, this.f66235f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66237e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f66238f;

        public d(DownloadInfo downloadInfo, String str) {
            this.f66237e = downloadInfo;
            this.f66238f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66224d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).b(this.f66237e, this.f66238f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).b(this.f66237e, this.f66238f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f66240e;

        public e(DownloadInfo downloadInfo) {
            this.f66240e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f66224d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.o.a.a.a.c.a.a) {
                    ((d.o.a.a.a.c.a.a) next).a(this.f66240e);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.o.a.a.a.c.a.a) {
                        ((d.o.a.a.a.c.a.a) softReference.get()).a(this.f66240e);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static void a() {
            if (n.f66143c) {
                throw new RuntimeException();
            }
        }

        public static void b(long j, BaseException baseException) {
            if (!n.f66143c) {
                j.c.a().y(j, baseException);
                return;
            }
            throw new RuntimeException(baseException.getErrorMessage());
        }

        public static void c(Throwable th) {
            if (!n.f66143c) {
                th.printStackTrace();
                return;
            }
            throw new RuntimeException(th);
        }
    }

    public static k b() {
        if (f66220f == null) {
            synchronized (k.class) {
                if (f66220f == null) {
                    f66220f = new k();
                }
            }
        }
        return f66220f;
    }

    public d.o.a.d.f.i a(String str) {
        Map<String, d.o.a.d.f.j> map = this.f66223c;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            d.o.a.d.f.j jVar = this.f66223c.get(str);
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
        d.o.a.d.f.j jVar = this.f66223c.get(dVar.a());
        if (jVar != null) {
            jVar.b(context).d(i2, eVar).b(dVar).a();
        } else if (!this.f66222b.isEmpty()) {
            o(context, i2, eVar, dVar);
        } else {
            r(context, i2, eVar, dVar);
        }
    }

    public void e(d.o.a.a.a.c.a.a aVar) {
        if (aVar != null) {
            if (d.o.a.e.b.j.a.r().q("fix_listener_oom", false)) {
                this.f66224d.add(new SoftReference(aVar));
            } else {
                this.f66224d.add(aVar);
            }
        }
    }

    public void f(d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar, @Nullable d.o.a.a.a.c.c cVar) {
        this.f66221a.post(new a(dVar, bVar, cVar));
    }

    public void g(DownloadInfo downloadInfo) {
        this.f66221a.post(new e(downloadInfo));
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        this.f66221a.post(new b(downloadInfo, baseException, str));
    }

    public void i(DownloadInfo downloadInfo, String str) {
        this.f66221a.post(new c(downloadInfo, str));
    }

    public void j(String str, int i2) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66223c.get(str)) == null) {
            return;
        }
        if (jVar.a(i2)) {
            this.f66222b.add(jVar);
            this.f66223c.remove(str);
        }
        q();
    }

    public void k(String str, long j, int i2, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        l(str, j, i2, cVar, bVar, null, null);
    }

    public void l(String str, long j, int i2, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, s sVar, d.o.a.a.a.a.n nVar) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66223c.get(str)) == null) {
            return;
        }
        jVar.a(j).a(cVar).e(bVar).f(sVar).c(nVar).b(i2);
    }

    public void m(String str, boolean z) {
        d.o.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f66223c.get(str)) == null) {
            return;
        }
        jVar.a(z);
    }

    public Handler n() {
        return this.f66221a;
    }

    public final synchronized void o(Context context, int i2, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        if (this.f66222b.size() <= 0) {
            r(context, i2, eVar, dVar);
        } else {
            d.o.a.d.f.j remove = this.f66222b.remove(0);
            remove.b(context).d(i2, eVar).b(dVar).a();
            this.f66223c.put(dVar.a(), remove);
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        this.f66221a.post(new d(downloadInfo, str));
    }

    public final void q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f66225e < 300000) {
            return;
        }
        this.f66225e = currentTimeMillis;
        if (this.f66222b.isEmpty()) {
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
        this.f66223c.put(dVar.a(), iVar);
    }

    public final void s() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (d.o.a.d.f.j jVar : this.f66222b) {
            if (!jVar.b() && currentTimeMillis - jVar.d() > 300000) {
                jVar.g();
                arrayList.add(jVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f66222b.removeAll(arrayList);
    }
}
