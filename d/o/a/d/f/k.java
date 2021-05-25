package d.o.a.d.f;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.q;
import d.o.a.a.a.c.f;
import d.o.a.d.f.c;
import d.o.a.d.g;
import d.o.a.d.j;
import d.o.a.d.n.i;
import d.o.a.d.n.l;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k implements l.a {

    /* renamed from: a  reason: collision with root package name */
    public long f66861a;

    /* renamed from: b  reason: collision with root package name */
    public c.f f66862b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66863c = false;

    /* renamed from: d  reason: collision with root package name */
    public e f66864d;

    /* loaded from: classes7.dex */
    public class a implements q {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f66865a;

        public a(q qVar) {
            this.f66865a = qVar;
        }

        @Override // d.o.a.a.a.a.q
        public void a() {
            this.f66865a.a();
        }

        @Override // d.o.a.a.a.a.q
        public void a(String str) {
            n.n().a(1, n.a(), k.this.f66862b.f66759b, "您已禁止使用存储权限，请授权后再下载", null, 1);
            j.c.a().x(k.this.f66861a, 1);
            this.f66865a.a(str);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements e {
        public c() {
        }

        @Override // d.o.a.d.f.k.e
        public void a(DownloadInfo downloadInfo) {
            j.c.a().d(k.this.f66861a, 2, downloadInfo);
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends d.o.a.e.b.f.c {

        /* renamed from: b  reason: collision with root package name */
        public d.o.a.d.n.l f66869b;

        public d(d.o.a.d.n.l lVar) {
            this.f66869b = lVar;
        }

        @Override // d.o.a.e.b.f.t
        public void a(DownloadInfo downloadInfo) {
            n(downloadInfo, 11);
        }

        @Override // d.o.a.e.b.f.a, d.o.a.e.b.f.b
        public void b(DownloadInfo downloadInfo) {
            n(downloadInfo, -2);
        }

        @Override // d.o.a.e.b.f.a, d.o.a.e.b.f.b
        public void c(DownloadInfo downloadInfo) {
            n(downloadInfo, 2);
        }

        @Override // d.o.a.e.b.f.a, d.o.a.e.b.f.b
        public void e(DownloadInfo downloadInfo) {
            n(downloadInfo, -4);
        }

        @Override // d.o.a.e.b.f.a, d.o.a.e.b.f.b
        public void f(DownloadInfo downloadInfo) {
            n(downloadInfo, -3);
        }

        @Override // d.o.a.e.b.f.a, d.o.a.e.b.f.b
        public void g(DownloadInfo downloadInfo) {
            n(downloadInfo, 4);
        }

        @Override // d.o.a.e.b.f.a, d.o.a.e.b.f.b
        public void h(DownloadInfo downloadInfo, BaseException baseException) {
            n(downloadInfo, -1);
        }

        @Override // d.o.a.e.b.f.a, d.o.a.e.b.f.b
        public void l(DownloadInfo downloadInfo) {
            n(downloadInfo, 1);
        }

        public final void n(DownloadInfo downloadInfo, int i2) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i2;
            this.f66869b.sendMessage(obtain);
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(DownloadInfo downloadInfo);
    }

    public k() {
        new d.o.a.d.n.l(Looper.getMainLooper(), this);
    }

    @NonNull
    public static List<d.o.a.a.a.c.e> d(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof d.o.a.a.a.c.e) {
                    arrayList.add((d.o.a.a.a.c.e) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof d.o.a.a.a.c.e) {
                        arrayList.add((d.o.a.a.a.c.e) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public static List<f> q(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof f) {
                    arrayList.add((f) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof f) {
                        arrayList.add((f) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    public int a(Context context, d.o.a.e.b.f.b bVar) {
        if (context == null) {
            return 0;
        }
        Map<String, String> j = this.f66862b.f66759b.j();
        ArrayList arrayList = new ArrayList();
        if (j != null) {
            for (Map.Entry<String, String> entry : j.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.model.c(entry.getKey(), entry.getValue()));
                }
            }
        }
        String a2 = d.o.a.d.n.d.a(String.valueOf(this.f66862b.f66759b.d()), this.f66862b.f66759b.c(), this.f66862b.f66759b.k(), String.valueOf(this.f66862b.f66759b.A()));
        d.o.a.e.b.j.a g2 = d.o.a.d.n.e.g(this.f66862b.f66759b);
        this.f66862b.f66759b.F();
        int i2 = (this.f66862b.f66759b.t() || l.i(this.f66862b.f66759b)) ? 4 : 4;
        String c2 = c(g2);
        DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(d.o.a.e.b.g.d.s(this.f66862b.f66759b.a(), c2));
        if (f2 != null && 3 == this.f66862b.f66759b.A()) {
            f2.t2(true);
            d.o.a.e.b.l.e.u(f2);
        }
        d.o.a.e.a.i iVar = new d.o.a.e.a.i(context, this.f66862b.f66759b.a());
        iVar.V(this.f66862b.f66759b.b());
        iVar.J(this.f66862b.f66759b.h());
        iVar.c0(a2);
        iVar.K(arrayList);
        iVar.M(this.f66862b.f66759b.l());
        iVar.Z(this.f66862b.f66759b.m());
        iVar.U(this.f66862b.f66759b.o());
        iVar.Y(c2);
        iVar.w0(this.f66862b.f66759b.w());
        iVar.n0(this.f66862b.f66759b.e());
        iVar.t0(this.f66862b.f66759b.I());
        iVar.B(this.f66862b.f66759b.f());
        iVar.D(bVar);
        iVar.B0(this.f66862b.f66759b.q() || g2.b("need_independent_process", 0) == 1);
        iVar.G(this.f66862b.f66759b.D());
        iVar.W(this.f66862b.f66759b.C());
        iVar.k0(this.f66862b.f66759b.v());
        iVar.b0(1000);
        iVar.f0(100);
        iVar.L(d.o.a.d.n.e.e(this.f66862b.f66759b));
        iVar.u0(true);
        iVar.x0(true);
        iVar.T(g2.b("retry_count", 5));
        iVar.X(g2.b("backup_url_retry_count", 0));
        iVar.x0(true);
        iVar.D0(g2.b("need_head_connection", 1) == 1);
        iVar.d0(g2.b("need_https_to_http_retry", 0) == 1);
        iVar.r0(g2.b("need_chunk_downgrade_retry", 1) == 1);
        iVar.o0(g2.b("need_retry_delay", 0) == 1);
        iVar.q0(g2.t("retry_delay_time_array"));
        iVar.z0(g2.b("need_reuse_runnable", 0) == 1);
        iVar.I(g.d(this.f66862b.f66759b.a(), this.f66862b.f66759b.p()));
        iVar.H(g.b(this.f66862b.f66759b.p()));
        iVar.j0(i2);
        if (!TextUtils.isEmpty(this.f66862b.f66759b.i())) {
            iVar.g0(this.f66862b.f66759b.i());
        } else {
            iVar.g0("application/vnd.android.package-archive");
        }
        if (g2.b("notification_opt_2", 0) == 1) {
            iVar.M(false);
            iVar.W(true);
        }
        d.o.a.d.f.d.a aVar = null;
        if (g2.b("clear_space_use_disk_handler", 0) == 1) {
            aVar = new d.o.a.d.f.d.a();
            iVar.F(aVar);
        }
        int a3 = l.a(this.f66862b, t(), iVar);
        if (aVar != null) {
            aVar.c(a3);
        }
        return a3;
    }

    @Override // d.o.a.d.n.l.a
    public void a(Message message) {
    }

    public final String c(d.o.a.e.b.j.a aVar) {
        if (!TextUtils.isEmpty(this.f66862b.f66759b.n())) {
            return this.f66862b.f66759b.n();
        }
        DownloadInfo e2 = d.o.a.e.a.e.F().e(n.a(), this.f66862b.f66759b.a());
        boolean e3 = d.o.a.d.n.i.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        String p = p();
        if (e2 != null && !TextUtils.isEmpty(e2.F0())) {
            String F0 = e2.F0();
            if (e3 || F0.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return F0;
            }
            try {
                if (!TextUtils.isEmpty(p)) {
                    if (F0.startsWith(p)) {
                        return F0;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).b(e2.c0());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(e3 ? 1 : 2));
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        j.c.a().v("label_external_permission", jSONObject, this.f66862b);
        String str = null;
        try {
            str = d.o.a.e.a.d.F();
        } catch (Exception unused) {
        }
        int b2 = d.o.a.d.n.e.b(aVar);
        if (b2 != 0) {
            if (b2 != 4 && (e3 || b2 != 2)) {
                if ((b2 == 3 || (!e3 && b2 == 1)) && !TextUtils.isEmpty(p)) {
                    return p;
                }
            } else {
                File filesDir = n.a().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return str;
    }

    public void e() {
        if (this.f66864d == null) {
            this.f66864d = new c();
        }
    }

    public void f(long j) {
        this.f66861a = j;
        c.f v = c.g.e().v(j);
        this.f66862b = v;
        if (v.w()) {
            d.o.a.d.n.k.B();
        }
    }

    public void g(Message message, d.o.a.a.a.d.e eVar, Map<Integer, Object> map) {
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i2 = message.arg1;
        int i3 = 0;
        if (i2 != 1 && i2 != 6 && i2 == 2) {
            if (downloadInfo.d0()) {
                d.o.a.d.k b2 = d.o.a.d.k.b();
                c.f fVar = this.f66862b;
                b2.f(fVar.f66759b, fVar.f66761d, fVar.f66760c);
                downloadInfo.t2(false);
            }
            j.c.a().i(downloadInfo);
        }
        eVar.a(downloadInfo);
        m.c(eVar);
        int b3 = d.o.a.e.a.d.b(downloadInfo.H0());
        long Q0 = downloadInfo.Q0();
        if (Q0 > 0) {
            i3 = (int) ((downloadInfo.E() * 100) / Q0);
            e eVar2 = this.f66864d;
            if (eVar2 != null) {
                eVar2.a(downloadInfo);
                this.f66864d = null;
            }
        }
        for (d.o.a.a.a.c.e eVar3 : d(map)) {
            if (b3 != 1) {
                if (b3 == 2) {
                    eVar3.b(eVar, m.a(downloadInfo.c0(), i3));
                } else if (b3 == 3) {
                    if (downloadInfo.H0() == -4) {
                        eVar3.a();
                    } else if (downloadInfo.H0() == -1) {
                        eVar3.a(eVar);
                    } else if (downloadInfo.H0() == -3) {
                        if (d.o.a.d.n.k.w(this.f66862b.f66759b)) {
                            eVar3.b(eVar);
                        } else {
                            eVar3.c(eVar);
                        }
                    }
                }
            } else if (downloadInfo.H0() != 11) {
                eVar3.a(eVar, m.a(downloadInfo.c0(), i3));
            } else {
                for (f fVar2 : q(map)) {
                    fVar2.a(downloadInfo);
                }
            }
        }
    }

    public void h(@NonNull q qVar) {
        if (!TextUtils.isEmpty(this.f66862b.f66759b.n())) {
            String n = this.f66862b.f66759b.n();
            if (n.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                qVar.a();
                return;
            }
            try {
                if (n.startsWith(n.a().getExternalCacheDir().getParent())) {
                    qVar.a();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        r(new a(qVar));
    }

    public void i(DownloadInfo downloadInfo) {
        this.f66863c = false;
        e eVar = this.f66864d;
        if (eVar != null) {
            eVar.a(downloadInfo);
            this.f66864d = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j(DownloadInfo downloadInfo, d.o.a.a.a.d.e eVar, List<d.o.a.a.a.c.e> list) {
        int i2;
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && eVar != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (downloadInfo.Q0() > 0) {
                i2 = (int) ((downloadInfo.E() * 100) / downloadInfo.Q0());
                int i3 = i2 >= 0 ? i2 : 0;
                eVar.a(downloadInfo);
                m.c(eVar);
                for (d.o.a.a.a.c.e eVar2 : list) {
                    switch (downloadInfo.H0()) {
                        case -4:
                        case 0:
                            if (d.o.a.d.n.k.w(this.f66862b.f66759b)) {
                                eVar.f66592b = -3;
                                eVar2.b(eVar);
                                break;
                            } else {
                                eVar2.a();
                                break;
                            }
                        case -3:
                            if (d.o.a.d.n.k.w(this.f66862b.f66759b)) {
                                eVar2.b(eVar);
                                break;
                            } else {
                                eVar2.c(eVar);
                                break;
                            }
                        case -2:
                            eVar2.b(eVar, m.a(downloadInfo.c0(), i3));
                            break;
                        case -1:
                            eVar2.a(eVar);
                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                        case 8:
                            eVar2.a(eVar, m.a(downloadInfo.c0(), i3));
                            break;
                        case 11:
                            if (eVar2 instanceof f) {
                                ((f) eVar2).a(downloadInfo);
                                break;
                            } else {
                                eVar2.a(eVar, m.a(downloadInfo.c0(), i3));
                                break;
                            }
                    }
                }
                return;
            }
            i2 = 0;
            if (i2 >= 0) {
            }
            eVar.a(downloadInfo);
            m.c(eVar);
            while (r9.hasNext()) {
            }
            return;
        }
        for (d.o.a.a.a.c.e eVar3 : list) {
            eVar3.a();
        }
    }

    public void k(DownloadInfo downloadInfo, boolean z) {
        if (this.f66862b.f66759b == null || downloadInfo == null || downloadInfo.c0() == 0) {
            return;
        }
        int H0 = downloadInfo.H0();
        if (H0 != -1 && H0 != -4) {
            if (l.f(this.f66862b.f66759b)) {
                j.c.a().c(this.f66861a, 2);
            } else if (z && j.e.a().f() && (H0 == -2 || H0 == -3)) {
                j.c.a().c(this.f66861a, 2);
            }
        } else {
            j.c.a().c(this.f66861a, 2);
        }
        switch (H0) {
            case -4:
            case -1:
                e();
                c.g e2 = c.g.e();
                c.f fVar = this.f66862b;
                e2.j(new d.o.a.b.a.c.b(fVar.f66759b, fVar.f66760c, fVar.f66761d, downloadInfo.c0()));
                return;
            case -3:
                if (d.o.a.d.n.k.w(this.f66862b.f66759b)) {
                    d.o.a.d.n.k.B();
                    return;
                }
                j.c.a().d(this.f66861a, 5, downloadInfo);
                if (z && j.e.a().c() && !j.e.a().d(this.f66861a, this.f66862b.f66759b.u())) {
                    j.c.a().c(this.f66861a, 2);
                    return;
                }
                return;
            case -2:
                j.c.a().d(this.f66861a, 4, downloadInfo);
                if (z && j.e.a().c() && !j.e.a().d(this.f66861a, this.f66862b.f66759b.u())) {
                    j.c.a().c(this.f66861a, 2);
                    return;
                }
                return;
            case 0:
            case 6:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                j.c.a().d(this.f66861a, 3, downloadInfo);
                return;
        }
    }

    public final boolean l(int i2) {
        if (this.f66862b.f66761d.b() == 2 && i2 == 2) {
            return true;
        }
        return this.f66862b.f66761d.b() == 2 && i2 == 1 && n.s().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean m(Context context, int i2, boolean z) {
        if (d.o.a.d.n.k.w(this.f66862b.f66759b)) {
            d.o.a.b.a.c.b u = c.g.e().u(this.f66862b.f66758a);
            if (u != null) {
                d.o.a.e.b.p.b.a().m(u.s());
            }
            return g.b.g(this.f66862b);
        } else if (!l(i2) || TextUtils.isEmpty(this.f66862b.f66759b.v()) || n.s().optInt("disable_market") == 1) {
            return false;
        } else {
            return g.b.h(this.f66862b, i2);
        }
    }

    public boolean n(boolean z) {
        return !z && this.f66862b.f66761d.b() == 1;
    }

    @Nullable
    public String p() {
        File externalFilesDir = n.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir != null) {
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            if (externalFilesDir.exists()) {
                return externalFilesDir.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public final void r(q qVar) {
        if (!d.o.a.d.n.i.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            d.o.a.d.n.i.d(new String[]{StorageUtils.EXTERNAL_STORAGE_PERMISSION}, new b(this, qVar));
        } else if (qVar != null) {
            qVar.a();
        }
    }

    public void s(DownloadInfo downloadInfo) {
        if (!l.f(this.f66862b.f66759b) || this.f66863c) {
            return;
        }
        j.c.a().k("file_status", (downloadInfo == null || !d.o.a.d.n.k.E(downloadInfo.K0())) ? 2 : 1, this.f66862b);
        this.f66863c = true;
    }

    public final boolean t() {
        return v() && x();
    }

    public boolean u(DownloadInfo downloadInfo) {
        return w(downloadInfo) || z();
    }

    public final boolean v() {
        d.o.a.a.a.c.d dVar = this.f66862b.f66759b;
        return (dVar == null || TextUtils.isEmpty(dVar.v()) || TextUtils.isEmpty(this.f66862b.f66759b.a())) ? false : true;
    }

    public final boolean w(DownloadInfo downloadInfo) {
        return y(downloadInfo) && !d.o.a.d.n.k.w(this.f66862b.f66759b);
    }

    public final boolean x() {
        return this.f66862b.f66761d.d();
    }

    public final boolean y(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.H0() == -3;
    }

    public final boolean z() {
        return d.o.a.d.n.k.w(this.f66862b.f66759b) && l.e(this.f66862b.f66761d.a());
    }

    /* loaded from: classes7.dex */
    public class b implements i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q f66867a;

        public b(k kVar, q qVar) {
            this.f66867a = qVar;
        }

        @Override // d.o.a.d.n.i.a
        public void a() {
            q qVar = this.f66867a;
            if (qVar != null) {
                qVar.a();
            }
        }

        @Override // d.o.a.d.n.i.a
        public void a(String str) {
            q qVar = this.f66867a;
            if (qVar != null) {
                qVar.a(str);
            }
        }
    }
}
