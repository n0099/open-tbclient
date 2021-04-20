package d.o.a.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.s;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.f.o;
import d.o.a.d.g;
import d.o.a.d.i;
import d.o.a.e.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: f  reason: collision with root package name */
    public static volatile l f67745f;

    /* renamed from: c  reason: collision with root package name */
    public final d.o.a.b.a.b f67748c;

    /* renamed from: d  reason: collision with root package name */
    public d.o.a.b.a.d f67749d;

    /* renamed from: b  reason: collision with root package name */
    public final k f67747b = k.b();

    /* renamed from: a  reason: collision with root package name */
    public final d.o.a.a.a.b f67746a = new j();

    /* renamed from: e  reason: collision with root package name */
    public long f67750e = System.currentTimeMillis();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a(l lVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.o.a.e.a.h.d.b(n.a());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d.l {

        /* loaded from: classes6.dex */
        public class a implements d.o.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.k f67751a;

            public a(b bVar, d.k kVar) {
                this.f67751a = kVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                this.f67751a.a();
            }
        }

        /* renamed from: d.o.a.d.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1870b implements d.o.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f67752a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.o.a.d.m.a.a f67753b;

            public C1870b(DownloadInfo downloadInfo, d.o.a.d.m.a.a aVar) {
                this.f67752a = downloadInfo;
                this.f67753b = aVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                b.this.d(this.f67752a, this.f67753b);
            }
        }

        /* loaded from: classes6.dex */
        public class c implements d.o.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.o.a.d.m.a.a f67755a;

            public c(b bVar, d.o.a.d.m.a.a aVar) {
                this.f67755a = aVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                this.f67755a.a();
            }
        }

        @Override // d.o.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            c(downloadInfo, new a(this, kVar));
        }

        public void c(DownloadInfo downloadInfo, @NonNull d.o.a.d.m.a.a aVar) {
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 != null && g.j.a(c2)) {
                TTDelegateActivity.a(c2, new C1870b(downloadInfo, aVar));
            } else {
                d(downloadInfo, aVar);
            }
        }

        public final void d(DownloadInfo downloadInfo, @NonNull d.o.a.d.m.a.a aVar) {
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            boolean c3 = g.C1866g.c(c2);
            boolean e2 = g.C1866g.e(c2);
            if (c3 && e2) {
                g.d.a(c2, new c(this, aVar));
            } else {
                aVar.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d.l {
        @Override // d.o.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            d.o.a.b.a.c.b c2;
            if (downloadInfo != null && (c2 = c.g.e().c(downloadInfo)) != null) {
                downloadInfo.K2(c2.J());
            }
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements d.l {

        /* renamed from: b  reason: collision with root package name */
        public static volatile d f67756b;

        /* renamed from: a  reason: collision with root package name */
        public List<d.l> f67757a;

        /* loaded from: classes6.dex */
        public class a implements d.k {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f67758a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f67759b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d.k f67760c;

            public a(int i, DownloadInfo downloadInfo, d.k kVar) {
                this.f67758a = i;
                this.f67759b = downloadInfo;
                this.f67760c = kVar;
            }

            @Override // d.o.a.e.a.d.k
            public void a() {
                d.this.d(this.f67759b, this.f67758a + 1, this.f67760c);
            }
        }

        public d() {
            ArrayList arrayList = new ArrayList();
            this.f67757a = arrayList;
            arrayList.add(new c());
            this.f67757a.add(new b());
        }

        public static d b() {
            if (f67756b == null) {
                synchronized (d.class) {
                    if (f67756b == null) {
                        f67756b = new d();
                    }
                }
            }
            return f67756b;
        }

        @Override // d.o.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            if (downloadInfo != null && this.f67757a.size() != 0) {
                d(downloadInfo, 0, kVar);
            } else if (kVar != null) {
                kVar.a();
            }
        }

        public final void d(DownloadInfo downloadInfo, int i, d.k kVar) {
            if (i != this.f67757a.size() && i >= 0) {
                this.f67757a.get(i).a(downloadInfo, new a(i, downloadInfo, kVar));
            } else {
                kVar.a();
            }
        }
    }

    public l(Context context) {
        k(context);
        this.f67748c = e.d();
    }

    public static l b(Context context) {
        if (f67745f == null) {
            synchronized (l.class) {
                if (f67745f == null) {
                    f67745f = new l(context);
                }
            }
        }
        return f67745f;
    }

    public d.o.a.a.a.b a() {
        return this.f67746a;
    }

    public DownloadInfo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.o.a.e.a.e.F().e(n.a(), str);
    }

    @MainThread
    public void d(Context context, int i, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        q().d(context, i, eVar, dVar);
    }

    public void e(d.o.a.a.a.c.a.a aVar) {
        q().e(aVar);
    }

    @MainThread
    public void f(String str, int i) {
        q().j(str, i);
    }

    @MainThread
    public void g(String str, long j, int i, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        q().k(str, j, i, cVar, bVar);
    }

    @MainThread
    public void h(String str, long j, int i, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, s sVar, d.o.a.a.a.a.n nVar) {
        q().l(str, j, i, cVar, bVar, sVar, nVar);
    }

    @MainThread
    public void i(String str, boolean z) {
        q().m(str, z);
    }

    public long j() {
        return this.f67750e;
    }

    public final void k(Context context) {
        n.b(context);
        d.o.a.e.b.g.a.l(n.a());
        c.g.e().q();
        d.o.a.e.a.e.F().k(n.a(), "misc_config", new i.h(), new i.g(context), new h());
        i.e eVar = new i.e();
        d.o.a.e.a.e.F().l(eVar);
        d.o.a.e.b.g.a.l(context).x(eVar);
        d.o.a.e.a.e.F().p(new o());
        d.o.a.e.b.g.d.B(new i.f());
        d.o.a.e.a.e.F().m(d.b());
        i.a().c(new a(this), 5000L);
    }

    public void l() {
        this.f67750e = System.currentTimeMillis();
    }

    public d.o.a.b.a.b m() {
        return this.f67748c;
    }

    public d.o.a.b.a.d n() {
        if (this.f67749d == null) {
            this.f67749d = g.e();
        }
        return this.f67749d;
    }

    public String o() {
        return n.w();
    }

    public void p() {
        i.a().j();
    }

    public final k q() {
        return this.f67747b;
    }
}
