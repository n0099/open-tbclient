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
/* loaded from: classes7.dex */
public class l {

    /* renamed from: f  reason: collision with root package name */
    public static volatile l f66928f;

    /* renamed from: c  reason: collision with root package name */
    public final d.o.a.b.a.b f66931c;

    /* renamed from: d  reason: collision with root package name */
    public d.o.a.b.a.d f66932d;

    /* renamed from: b  reason: collision with root package name */
    public final k f66930b = k.b();

    /* renamed from: a  reason: collision with root package name */
    public final d.o.a.a.a.b f66929a = new j();

    /* renamed from: e  reason: collision with root package name */
    public long f66933e = System.currentTimeMillis();

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public a(l lVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.o.a.e.a.h.d.b(n.a());
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.l {

        /* loaded from: classes7.dex */
        public class a implements d.o.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.k f66934a;

            public a(b bVar, d.k kVar) {
                this.f66934a = kVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                this.f66934a.a();
            }
        }

        /* renamed from: d.o.a.d.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1873b implements d.o.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f66935a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.o.a.d.m.a.a f66936b;

            public C1873b(DownloadInfo downloadInfo, d.o.a.d.m.a.a aVar) {
                this.f66935a = downloadInfo;
                this.f66936b = aVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                b.this.d(this.f66935a, this.f66936b);
            }
        }

        /* loaded from: classes7.dex */
        public class c implements d.o.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.o.a.d.m.a.a f66938a;

            public c(b bVar, d.o.a.d.m.a.a aVar) {
                this.f66938a = aVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                this.f66938a.a();
            }
        }

        @Override // d.o.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            c(downloadInfo, new a(this, kVar));
        }

        public void c(DownloadInfo downloadInfo, @NonNull d.o.a.d.m.a.a aVar) {
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 != null && g.j.a(c2)) {
                TTDelegateActivity.a(c2, new C1873b(downloadInfo, aVar));
            } else {
                d(downloadInfo, aVar);
            }
        }

        public final void d(DownloadInfo downloadInfo, @NonNull d.o.a.d.m.a.a aVar) {
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            boolean c3 = g.C1869g.c(c2);
            boolean e2 = g.C1869g.e(c2);
            if (c3 && e2) {
                g.d.a(c2, new c(this, aVar));
            } else {
                aVar.a();
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class d implements d.l {

        /* renamed from: b  reason: collision with root package name */
        public static volatile d f66939b;

        /* renamed from: a  reason: collision with root package name */
        public List<d.l> f66940a;

        /* loaded from: classes7.dex */
        public class a implements d.k {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f66941a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f66942b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d.k f66943c;

            public a(int i2, DownloadInfo downloadInfo, d.k kVar) {
                this.f66941a = i2;
                this.f66942b = downloadInfo;
                this.f66943c = kVar;
            }

            @Override // d.o.a.e.a.d.k
            public void a() {
                d.this.d(this.f66942b, this.f66941a + 1, this.f66943c);
            }
        }

        public d() {
            ArrayList arrayList = new ArrayList();
            this.f66940a = arrayList;
            arrayList.add(new c());
            this.f66940a.add(new b());
        }

        public static d b() {
            if (f66939b == null) {
                synchronized (d.class) {
                    if (f66939b == null) {
                        f66939b = new d();
                    }
                }
            }
            return f66939b;
        }

        @Override // d.o.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            if (downloadInfo != null && this.f66940a.size() != 0) {
                d(downloadInfo, 0, kVar);
            } else if (kVar != null) {
                kVar.a();
            }
        }

        public final void d(DownloadInfo downloadInfo, int i2, d.k kVar) {
            if (i2 != this.f66940a.size() && i2 >= 0) {
                this.f66940a.get(i2).a(downloadInfo, new a(i2, downloadInfo, kVar));
            } else {
                kVar.a();
            }
        }
    }

    public l(Context context) {
        k(context);
        this.f66931c = e.d();
    }

    public static l b(Context context) {
        if (f66928f == null) {
            synchronized (l.class) {
                if (f66928f == null) {
                    f66928f = new l(context);
                }
            }
        }
        return f66928f;
    }

    public d.o.a.a.a.b a() {
        return this.f66929a;
    }

    public DownloadInfo c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.o.a.e.a.e.F().e(n.a(), str);
    }

    @MainThread
    public void d(Context context, int i2, d.o.a.a.a.c.e eVar, d.o.a.a.a.c.d dVar) {
        q().d(context, i2, eVar, dVar);
    }

    public void e(d.o.a.a.a.c.a.a aVar) {
        q().e(aVar);
    }

    @MainThread
    public void f(String str, int i2) {
        q().j(str, i2);
    }

    @MainThread
    public void g(String str, long j, int i2, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        q().k(str, j, i2, cVar, bVar);
    }

    @MainThread
    public void h(String str, long j, int i2, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, s sVar, d.o.a.a.a.a.n nVar) {
        q().l(str, j, i2, cVar, bVar, sVar, nVar);
    }

    @MainThread
    public void i(String str, boolean z) {
        q().m(str, z);
    }

    public long j() {
        return this.f66933e;
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
        this.f66933e = System.currentTimeMillis();
    }

    public d.o.a.b.a.b m() {
        return this.f66931c;
    }

    public d.o.a.b.a.d n() {
        if (this.f66932d == null) {
            this.f66932d = g.e();
        }
        return this.f66932d;
    }

    public String o() {
        return n.w();
    }

    public void p() {
        i.a().j();
    }

    public final k q() {
        return this.f66930b;
    }
}
