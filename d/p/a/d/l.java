package d.p.a.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.a.a.a.s;
import d.p.a.d.f.c;
import d.p.a.d.f.n;
import d.p.a.d.f.o;
import d.p.a.d.g;
import d.p.a.d.i;
import d.p.a.e.a.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: f  reason: collision with root package name */
    public static volatile l f67892f;

    /* renamed from: c  reason: collision with root package name */
    public final d.p.a.b.a.b f67895c;

    /* renamed from: d  reason: collision with root package name */
    public d.p.a.b.a.d f67896d;

    /* renamed from: b  reason: collision with root package name */
    public final k f67894b = k.b();

    /* renamed from: a  reason: collision with root package name */
    public final d.p.a.a.a.b f67893a = new j();

    /* renamed from: e  reason: collision with root package name */
    public long f67897e = System.currentTimeMillis();

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a(l lVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.p.a.e.a.h.d.b(n.a());
        }
    }

    /* loaded from: classes6.dex */
    public class b implements d.l {

        /* loaded from: classes6.dex */
        public class a implements d.p.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.k f67898a;

            public a(b bVar, d.k kVar) {
                this.f67898a = kVar;
            }

            @Override // d.p.a.d.m.a.a
            public void a() {
                this.f67898a.a();
            }
        }

        /* renamed from: d.p.a.d.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1874b implements d.p.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f67899a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.p.a.d.m.a.a f67900b;

            public C1874b(DownloadInfo downloadInfo, d.p.a.d.m.a.a aVar) {
                this.f67899a = downloadInfo;
                this.f67900b = aVar;
            }

            @Override // d.p.a.d.m.a.a
            public void a() {
                b.this.d(this.f67899a, this.f67900b);
            }
        }

        /* loaded from: classes6.dex */
        public class c implements d.p.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.p.a.d.m.a.a f67902a;

            public c(b bVar, d.p.a.d.m.a.a aVar) {
                this.f67902a = aVar;
            }

            @Override // d.p.a.d.m.a.a
            public void a() {
                this.f67902a.a();
            }
        }

        @Override // d.p.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            c(downloadInfo, new a(this, kVar));
        }

        public void c(DownloadInfo downloadInfo, @NonNull d.p.a.d.m.a.a aVar) {
            d.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 != null && g.j.a(c2)) {
                TTDelegateActivity.a(c2, new C1874b(downloadInfo, aVar));
            } else {
                d(downloadInfo, aVar);
            }
        }

        public final void d(DownloadInfo downloadInfo, @NonNull d.p.a.d.m.a.a aVar) {
            d.p.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            boolean c3 = g.C1870g.c(c2);
            boolean e2 = g.C1870g.e(c2);
            if (c3 && e2) {
                g.d.a(c2, new c(this, aVar));
            } else {
                aVar.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements d.l {
        @Override // d.p.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            d.p.a.b.a.c.b c2;
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
        public static volatile d f67903b;

        /* renamed from: a  reason: collision with root package name */
        public List<d.l> f67904a;

        /* loaded from: classes6.dex */
        public class a implements d.k {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f67905a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f67906b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d.k f67907c;

            public a(int i, DownloadInfo downloadInfo, d.k kVar) {
                this.f67905a = i;
                this.f67906b = downloadInfo;
                this.f67907c = kVar;
            }

            @Override // d.p.a.e.a.d.k
            public void a() {
                d.this.d(this.f67906b, this.f67905a + 1, this.f67907c);
            }
        }

        public d() {
            ArrayList arrayList = new ArrayList();
            this.f67904a = arrayList;
            arrayList.add(new c());
            this.f67904a.add(new b());
        }

        public static d b() {
            if (f67903b == null) {
                synchronized (d.class) {
                    if (f67903b == null) {
                        f67903b = new d();
                    }
                }
            }
            return f67903b;
        }

        @Override // d.p.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            if (downloadInfo != null && this.f67904a.size() != 0) {
                d(downloadInfo, 0, kVar);
            } else if (kVar != null) {
                kVar.a();
            }
        }

        public final void d(DownloadInfo downloadInfo, int i, d.k kVar) {
            if (i != this.f67904a.size() && i >= 0) {
                this.f67904a.get(i).a(downloadInfo, new a(i, downloadInfo, kVar));
            } else {
                kVar.a();
            }
        }
    }

    public l(Context context) {
        k(context);
        this.f67895c = e.d();
    }

    public static l b(Context context) {
        if (f67892f == null) {
            synchronized (l.class) {
                if (f67892f == null) {
                    f67892f = new l(context);
                }
            }
        }
        return f67892f;
    }

    public d.p.a.a.a.b a() {
        return this.f67893a;
    }

    public DownloadInfo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.p.a.e.a.e.F().e(n.a(), str);
    }

    @MainThread
    public void d(Context context, int i, d.p.a.a.a.c.e eVar, d.p.a.a.a.c.d dVar) {
        q().d(context, i, eVar, dVar);
    }

    public void e(d.p.a.a.a.c.a.a aVar) {
        q().e(aVar);
    }

    @MainThread
    public void f(String str, int i) {
        q().j(str, i);
    }

    @MainThread
    public void g(String str, long j, int i, d.p.a.a.a.c.c cVar, d.p.a.a.a.c.b bVar) {
        q().k(str, j, i, cVar, bVar);
    }

    @MainThread
    public void h(String str, long j, int i, d.p.a.a.a.c.c cVar, d.p.a.a.a.c.b bVar, s sVar, d.p.a.a.a.a.n nVar) {
        q().l(str, j, i, cVar, bVar, sVar, nVar);
    }

    @MainThread
    public void i(String str, boolean z) {
        q().m(str, z);
    }

    public long j() {
        return this.f67897e;
    }

    public final void k(Context context) {
        n.b(context);
        d.p.a.e.b.g.a.l(n.a());
        c.g.e().q();
        d.p.a.e.a.e.F().k(n.a(), "misc_config", new i.h(), new i.g(context), new h());
        i.e eVar = new i.e();
        d.p.a.e.a.e.F().l(eVar);
        d.p.a.e.b.g.a.l(context).x(eVar);
        d.p.a.e.a.e.F().p(new o());
        d.p.a.e.b.g.d.B(new i.f());
        d.p.a.e.a.e.F().m(d.b());
        i.a().c(new a(this), 5000L);
    }

    public void l() {
        this.f67897e = System.currentTimeMillis();
    }

    public d.p.a.b.a.b m() {
        return this.f67895c;
    }

    public d.p.a.b.a.d n() {
        if (this.f67896d == null) {
            this.f67896d = g.e();
        }
        return this.f67896d;
    }

    public String o() {
        return n.w();
    }

    public void p() {
        i.a().j();
    }

    public final k q() {
        return this.f67894b;
    }
}
