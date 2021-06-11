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
    public static volatile l f70757f;

    /* renamed from: c  reason: collision with root package name */
    public final d.o.a.b.a.b f70760c;

    /* renamed from: d  reason: collision with root package name */
    public d.o.a.b.a.d f70761d;

    /* renamed from: b  reason: collision with root package name */
    public final k f70759b = k.b();

    /* renamed from: a  reason: collision with root package name */
    public final d.o.a.a.a.b f70758a = new j();

    /* renamed from: e  reason: collision with root package name */
    public long f70762e = System.currentTimeMillis();

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
            public final /* synthetic */ d.k f70763a;

            public a(b bVar, d.k kVar) {
                this.f70763a = kVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                this.f70763a.a();
            }
        }

        /* renamed from: d.o.a.d.l$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1937b implements d.o.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f70764a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.o.a.d.m.a.a f70765b;

            public C1937b(DownloadInfo downloadInfo, d.o.a.d.m.a.a aVar) {
                this.f70764a = downloadInfo;
                this.f70765b = aVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                b.this.d(this.f70764a, this.f70765b);
            }
        }

        /* loaded from: classes7.dex */
        public class c implements d.o.a.d.m.a.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.o.a.d.m.a.a f70767a;

            public c(b bVar, d.o.a.d.m.a.a aVar) {
                this.f70767a = aVar;
            }

            @Override // d.o.a.d.m.a.a
            public void a() {
                this.f70767a.a();
            }
        }

        @Override // d.o.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            c(downloadInfo, new a(this, kVar));
        }

        public void c(DownloadInfo downloadInfo, @NonNull d.o.a.d.m.a.a aVar) {
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 != null && g.j.a(c2)) {
                TTDelegateActivity.a(c2, new C1937b(downloadInfo, aVar));
            } else {
                d(downloadInfo, aVar);
            }
        }

        public final void d(DownloadInfo downloadInfo, @NonNull d.o.a.d.m.a.a aVar) {
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            boolean c3 = g.C1933g.c(c2);
            boolean e2 = g.C1933g.e(c2);
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
        public static volatile d f70768b;

        /* renamed from: a  reason: collision with root package name */
        public List<d.l> f70769a;

        /* loaded from: classes7.dex */
        public class a implements d.k {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f70770a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f70771b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d.k f70772c;

            public a(int i2, DownloadInfo downloadInfo, d.k kVar) {
                this.f70770a = i2;
                this.f70771b = downloadInfo;
                this.f70772c = kVar;
            }

            @Override // d.o.a.e.a.d.k
            public void a() {
                d.this.d(this.f70771b, this.f70770a + 1, this.f70772c);
            }
        }

        public d() {
            ArrayList arrayList = new ArrayList();
            this.f70769a = arrayList;
            arrayList.add(new c());
            this.f70769a.add(new b());
        }

        public static d b() {
            if (f70768b == null) {
                synchronized (d.class) {
                    if (f70768b == null) {
                        f70768b = new d();
                    }
                }
            }
            return f70768b;
        }

        @Override // d.o.a.e.a.d.l
        public void a(DownloadInfo downloadInfo, d.k kVar) {
            if (downloadInfo != null && this.f70769a.size() != 0) {
                d(downloadInfo, 0, kVar);
            } else if (kVar != null) {
                kVar.a();
            }
        }

        public final void d(DownloadInfo downloadInfo, int i2, d.k kVar) {
            if (i2 != this.f70769a.size() && i2 >= 0) {
                this.f70769a.get(i2).a(downloadInfo, new a(i2, downloadInfo, kVar));
            } else {
                kVar.a();
            }
        }
    }

    public l(Context context) {
        k(context);
        this.f70760c = e.d();
    }

    public static l b(Context context) {
        if (f70757f == null) {
            synchronized (l.class) {
                if (f70757f == null) {
                    f70757f = new l(context);
                }
            }
        }
        return f70757f;
    }

    public d.o.a.a.a.b a() {
        return this.f70758a;
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
        return this.f70762e;
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
        this.f70762e = System.currentTimeMillis();
    }

    public d.o.a.b.a.b m() {
        return this.f70760c;
    }

    public d.o.a.b.a.d n() {
        if (this.f70761d == null) {
            this.f70761d = g.e();
        }
        return this.f70761d;
    }

    public String o() {
        return n.w();
    }

    public void p() {
        i.a().j();
    }

    public final k q() {
        return this.f70759b;
    }
}
