package d.p.a.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.a.a.a.s;
import d.p.a.d.f.n;
import d.p.a.d.j;
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
    public static volatile k f67870f;

    /* renamed from: e  reason: collision with root package name */
    public long f67875e;

    /* renamed from: b  reason: collision with root package name */
    public final List<d.p.a.d.f.j> f67872b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d.p.a.d.f.j> f67873c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final CopyOnWriteArrayList<Object> f67874d = new CopyOnWriteArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f67871a = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.p.a.a.a.c.d f67876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.p.a.a.a.c.b f67877f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.p.a.a.a.c.c f67878g;

        public a(d.p.a.a.a.c.d dVar, d.p.a.a.a.c.b bVar, d.p.a.a.a.c.c cVar) {
            this.f67876e = dVar;
            this.f67877f = bVar;
            this.f67878g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67874d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.p.a.a.a.c.a.a) {
                    ((d.p.a.a.a.c.a.a) next).a(this.f67876e, this.f67877f, this.f67878g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.p.a.a.a.c.a.a) {
                        ((d.p.a.a.a.c.a.a) softReference.get()).a(this.f67876e, this.f67877f, this.f67878g);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BaseException f67881f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f67882g;

        public b(DownloadInfo downloadInfo, BaseException baseException, String str) {
            this.f67880e = downloadInfo;
            this.f67881f = baseException;
            this.f67882g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67874d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.p.a.a.a.c.a.a) {
                    ((d.p.a.a.a.c.a.a) next).a(this.f67880e, this.f67881f, this.f67882g);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.p.a.a.a.c.a.a) {
                        ((d.p.a.a.a.c.a.a) softReference.get()).a(this.f67880e, this.f67881f, this.f67882g);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67885f;

        public c(DownloadInfo downloadInfo, String str) {
            this.f67884e = downloadInfo;
            this.f67885f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67874d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.p.a.a.a.c.a.a) {
                    ((d.p.a.a.a.c.a.a) next).a(this.f67884e, this.f67885f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.p.a.a.a.c.a.a) {
                        ((d.p.a.a.a.c.a.a) softReference.get()).a(this.f67884e, this.f67885f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67887e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67888f;

        public d(DownloadInfo downloadInfo, String str) {
            this.f67887e = downloadInfo;
            this.f67888f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67874d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.p.a.a.a.c.a.a) {
                    ((d.p.a.a.a.c.a.a) next).b(this.f67887e, this.f67888f);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.p.a.a.a.c.a.a) {
                        ((d.p.a.a.a.c.a.a) softReference.get()).b(this.f67887e, this.f67888f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f67890e;

        public e(DownloadInfo downloadInfo) {
            this.f67890e = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = k.this.f67874d.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof d.p.a.a.a.c.a.a) {
                    ((d.p.a.a.a.c.a.a) next).a(this.f67890e);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof d.p.a.a.a.c.a.a) {
                        ((d.p.a.a.a.c.a.a) softReference.get()).a(this.f67890e);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static void a() {
            if (n.f67795c) {
                throw new RuntimeException();
            }
        }

        public static void b(long j, BaseException baseException) {
            if (!n.f67795c) {
                j.c.a().y(j, baseException);
                return;
            }
            throw new RuntimeException(baseException.getErrorMessage());
        }

        public static void c(Throwable th) {
            if (!n.f67795c) {
                th.printStackTrace();
                return;
            }
            throw new RuntimeException(th);
        }
    }

    public static k b() {
        if (f67870f == null) {
            synchronized (k.class) {
                if (f67870f == null) {
                    f67870f = new k();
                }
            }
        }
        return f67870f;
    }

    public d.p.a.d.f.i a(String str) {
        Map<String, d.p.a.d.f.j> map = this.f67873c;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            d.p.a.d.f.j jVar = this.f67873c.get(str);
            if (jVar instanceof d.p.a.d.f.i) {
                return (d.p.a.d.f.i) jVar;
            }
        }
        return null;
    }

    public void d(Context context, int i, d.p.a.a.a.c.e eVar, d.p.a.a.a.c.d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.a())) {
            return;
        }
        d.p.a.d.f.j jVar = this.f67873c.get(dVar.a());
        if (jVar != null) {
            jVar.b(context).d(i, eVar).b(dVar).a();
        } else if (!this.f67872b.isEmpty()) {
            o(context, i, eVar, dVar);
        } else {
            r(context, i, eVar, dVar);
        }
    }

    public void e(d.p.a.a.a.c.a.a aVar) {
        if (aVar != null) {
            if (d.p.a.e.b.j.a.r().q("fix_listener_oom", false)) {
                this.f67874d.add(new SoftReference(aVar));
            } else {
                this.f67874d.add(aVar);
            }
        }
    }

    public void f(d.p.a.a.a.c.d dVar, @Nullable d.p.a.a.a.c.b bVar, @Nullable d.p.a.a.a.c.c cVar) {
        this.f67871a.post(new a(dVar, bVar, cVar));
    }

    public void g(DownloadInfo downloadInfo) {
        this.f67871a.post(new e(downloadInfo));
    }

    public void h(DownloadInfo downloadInfo, BaseException baseException, String str) {
        this.f67871a.post(new b(downloadInfo, baseException, str));
    }

    public void i(DownloadInfo downloadInfo, String str) {
        this.f67871a.post(new c(downloadInfo, str));
    }

    public void j(String str, int i) {
        d.p.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f67873c.get(str)) == null) {
            return;
        }
        if (jVar.a(i)) {
            this.f67872b.add(jVar);
            this.f67873c.remove(str);
        }
        q();
    }

    public void k(String str, long j, int i, d.p.a.a.a.c.c cVar, d.p.a.a.a.c.b bVar) {
        l(str, j, i, cVar, bVar, null, null);
    }

    public void l(String str, long j, int i, d.p.a.a.a.c.c cVar, d.p.a.a.a.c.b bVar, s sVar, d.p.a.a.a.a.n nVar) {
        d.p.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f67873c.get(str)) == null) {
            return;
        }
        jVar.a(j).a(cVar).f(bVar).e(sVar).c(nVar).b(i);
    }

    public void m(String str, boolean z) {
        d.p.a.d.f.j jVar;
        if (TextUtils.isEmpty(str) || (jVar = this.f67873c.get(str)) == null) {
            return;
        }
        jVar.a(z);
    }

    public Handler n() {
        return this.f67871a;
    }

    public final synchronized void o(Context context, int i, d.p.a.a.a.c.e eVar, d.p.a.a.a.c.d dVar) {
        if (this.f67872b.size() <= 0) {
            r(context, i, eVar, dVar);
        } else {
            d.p.a.d.f.j remove = this.f67872b.remove(0);
            remove.b(context).d(i, eVar).b(dVar).a();
            this.f67873c.put(dVar.a(), remove);
        }
    }

    public void p(DownloadInfo downloadInfo, String str) {
        this.f67871a.post(new d(downloadInfo, str));
    }

    public final void q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f67875e < 300000) {
            return;
        }
        this.f67875e = currentTimeMillis;
        if (this.f67872b.isEmpty()) {
            return;
        }
        s();
    }

    public final void r(Context context, int i, d.p.a.a.a.c.e eVar, d.p.a.a.a.c.d dVar) {
        if (dVar == null) {
            return;
        }
        d.p.a.d.f.i iVar = new d.p.a.d.f.i();
        iVar.b(context);
        iVar.d(i, eVar);
        iVar.b(dVar);
        iVar.a();
        this.f67873c.put(dVar.a(), iVar);
    }

    public final void s() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (d.p.a.d.f.j jVar : this.f67872b) {
            if (!jVar.b() && currentTimeMillis - jVar.d() > 300000) {
                jVar.g();
                arrayList.add(jVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f67872b.removeAll(arrayList);
    }
}
