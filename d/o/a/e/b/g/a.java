package d.o.a.e.b.g;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.u;
import java.io.File;
import java.util.List;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f66957b;

    /* renamed from: a  reason: collision with root package name */
    public String f66958a;

    public a() {
    }

    public static d.o.a.e.b.n.a H(Context context) {
        l(context);
        return new d.o.a.e.b.n.a();
    }

    public static a l(Context context) {
        if (f66957b == null) {
            synchronized (a.class) {
                if (f66957b == null) {
                    d.y(context);
                    f66957b = new a();
                }
            }
        }
        return f66957b;
    }

    public static synchronized void q(b bVar) {
        synchronized (a.class) {
            r(bVar, false);
        }
    }

    public static synchronized void r(b bVar, boolean z) {
        synchronized (a.class) {
            if (bVar == null) {
                return;
            }
            if (f66957b == null) {
                f66957b = bVar.b();
            } else if (!d.p()) {
                d.G(bVar);
            } else if (z) {
                d.a0(bVar);
            }
        }
    }

    public void A(List<String> list) {
        e.c().k(list);
    }

    public void B(List<String> list) {
        e.c().s(list);
    }

    public void C(int i) {
        e.c().C(i);
    }

    public void D(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f66958a = str;
    }

    @Deprecated
    public void E(int i, d.o.a.e.b.f.b bVar) {
        if (bVar == null) {
            return;
        }
        e.c().q(i, bVar, com.ss.android.socialbase.downloader.constants.g.MAIN, true);
    }

    @Deprecated
    public void F(int i, d.o.a.e.b.f.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        e.c().g(i, bVar, com.ss.android.socialbase.downloader.constants.g.MAIN, true, z);
    }

    public void G(q qVar) {
        d.M(qVar);
    }

    public boolean a(int i) {
        return e.c().B(i);
    }

    public void b(int i) {
        c(i, true);
    }

    public void c(int i, boolean z) {
        e.c().w(i, z);
    }

    public void d(int i) {
        e.c().z(i, true);
    }

    public u e(int i) {
        return e.c().L(i);
    }

    public DownloadInfo f(int i) {
        return e.c().G(i);
    }

    public DownloadInfo g(String str, String str2) {
        return e.c().o(str, str2);
    }

    public List<DownloadInfo> h(String str) {
        return e.c().d(str);
    }

    public d.o.a.e.b.f.d i(int i) {
        return e.c().H(i);
    }

    public List<DownloadInfo> j(String str) {
        return e.c().A(str);
    }

    public File k() {
        File file = null;
        if (TextUtils.isEmpty(this.f66958a)) {
            return null;
        }
        try {
            File file2 = new File(this.f66958a);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
        }
    }

    public q m() {
        return d.o();
    }

    public int n(int i) {
        return e.c().E(i);
    }

    public List<DownloadInfo> o(String str) {
        return e.c().u(str);
    }

    public List<DownloadInfo> p(String str) {
        return e.c().x(str);
    }

    public boolean s(int i) {
        return e.c().t(i).b();
    }

    public boolean t(DownloadInfo downloadInfo) {
        return e.c().l(downloadInfo);
    }

    public boolean u(int i) {
        boolean F;
        if (d.o.a.e.b.l.a.a(4194304)) {
            synchronized (this) {
                F = e.c().F(i);
            }
            return F;
        }
        return e.c().F(i);
    }

    public void v(int i) {
        e.c().y(i);
    }

    public void w() {
        e.c().v();
    }

    public void x(d.o.a.e.b.f.o oVar) {
        e.c().i(oVar);
    }

    @Deprecated
    public void y(int i) {
        e.c().f(i, null, com.ss.android.socialbase.downloader.constants.g.MAIN, true);
    }

    public void z(int i) {
        e.c().D(i);
    }

    public a(b bVar) {
        d.G(bVar);
    }
}
