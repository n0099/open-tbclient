package d.o.a.e.b.g;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.e.b.f.u;
import java.io.File;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f66458b;

    /* renamed from: a  reason: collision with root package name */
    public String f66459a;

    public a() {
    }

    public static d.o.a.e.b.n.a H(Context context) {
        l(context);
        return new d.o.a.e.b.n.a();
    }

    public static a l(Context context) {
        if (f66458b == null) {
            synchronized (a.class) {
                if (f66458b == null) {
                    d.y(context);
                    f66458b = new a();
                }
            }
        }
        return f66458b;
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
            if (f66458b == null) {
                f66458b = bVar.b();
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

    public void C(int i2) {
        e.c().C(i2);
    }

    public void D(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f66459a = str;
    }

    @Deprecated
    public void E(int i2, d.o.a.e.b.f.b bVar) {
        if (bVar == null) {
            return;
        }
        e.c().q(i2, bVar, com.ss.android.socialbase.downloader.constants.g.MAIN, true);
    }

    @Deprecated
    public void F(int i2, d.o.a.e.b.f.b bVar, boolean z) {
        if (bVar == null) {
            return;
        }
        e.c().g(i2, bVar, com.ss.android.socialbase.downloader.constants.g.MAIN, true, z);
    }

    public void G(q qVar) {
        d.M(qVar);
    }

    public boolean a(int i2) {
        return e.c().B(i2);
    }

    public void b(int i2) {
        c(i2, true);
    }

    public void c(int i2, boolean z) {
        e.c().w(i2, z);
    }

    public void d(int i2) {
        e.c().z(i2, true);
    }

    public u e(int i2) {
        return e.c().L(i2);
    }

    public DownloadInfo f(int i2) {
        return e.c().G(i2);
    }

    public DownloadInfo g(String str, String str2) {
        return e.c().o(str, str2);
    }

    public List<DownloadInfo> h(String str) {
        return e.c().d(str);
    }

    public d.o.a.e.b.f.d i(int i2) {
        return e.c().H(i2);
    }

    public List<DownloadInfo> j(String str) {
        return e.c().A(str);
    }

    public File k() {
        File file = null;
        if (TextUtils.isEmpty(this.f66459a)) {
            return null;
        }
        try {
            File file2 = new File(this.f66459a);
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

    public int n(int i2) {
        return e.c().E(i2);
    }

    public List<DownloadInfo> o(String str) {
        return e.c().u(str);
    }

    public List<DownloadInfo> p(String str) {
        return e.c().x(str);
    }

    public boolean s(int i2) {
        return e.c().t(i2).b();
    }

    public boolean t(DownloadInfo downloadInfo) {
        return e.c().l(downloadInfo);
    }

    public boolean u(int i2) {
        boolean F;
        if (d.o.a.e.b.l.a.a(4194304)) {
            synchronized (this) {
                F = e.c().F(i2);
            }
            return F;
        }
        return e.c().F(i2);
    }

    public void v(int i2) {
        e.c().y(i2);
    }

    public void w() {
        e.c().v();
    }

    public void x(d.o.a.e.b.f.o oVar) {
        e.c().i(oVar);
    }

    @Deprecated
    public void y(int i2) {
        e.c().f(i2, null, com.ss.android.socialbase.downloader.constants.g.MAIN, true);
    }

    public void z(int i2) {
        e.c().D(i2);
    }

    public a(b bVar) {
        d.G(bVar);
    }
}
