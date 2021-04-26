package d.o.a.d.f;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.a.q;
import d.o.a.a.a.a.s;
import d.o.a.a.a.c.h;
import d.o.a.d.f.c;
import d.o.a.d.f.g;
import d.o.a.d.f.k;
import d.o.a.d.i;
import d.o.a.d.j;
import d.o.a.d.k;
import d.o.a.d.n.l;
import d.o.a.e.a.d;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements j, l.a {
    public static final String t = "i";

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Context> f66115d;

    /* renamed from: f  reason: collision with root package name */
    public d.o.a.a.a.d.e f66117f;

    /* renamed from: g  reason: collision with root package name */
    public DownloadInfo f66118g;

    /* renamed from: h  reason: collision with root package name */
    public h f66119h;
    public boolean j;
    public long k;
    public SoftReference<s> p;
    public boolean q;
    public SoftReference<d.o.a.a.a.a.n> s;

    /* renamed from: a  reason: collision with root package name */
    public final d.o.a.d.n.l f66112a = new d.o.a.d.n.l(Looper.getMainLooper(), this);

    /* renamed from: e  reason: collision with root package name */
    public final Map<Integer, Object> f66116e = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    public final d.o.a.e.b.f.b f66120i = new k.d(this.f66112a);
    public long l = -1;
    public d.o.a.a.a.c.d m = null;
    public d.o.a.a.a.c.c n = null;
    public d.o.a.a.a.c.b o = null;

    /* renamed from: b  reason: collision with root package name */
    public k f66113b = new k();

    /* renamed from: c  reason: collision with root package name */
    public d.o.a.d.f.h f66114c = new d.o.a.d.f.h(this.f66112a);
    public final boolean r = d.o.a.e.b.j.a.r().l("ttdownloader_callback_twice");

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.o.a.a.a.c.e eVar : k.d(i.this.f66116e)) {
                eVar.b(i.this.R());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f66122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f66123b;

        public b(int i2, int i3) {
            this.f66122a = i2;
            this.f66123b = i3;
        }

        @Override // d.o.a.d.f.i.f
        public void a() {
            if (i.this.f66114c.n()) {
                return;
            }
            d.o.a.e.a.e.F().j(n.a(), this.f66122a, this.f66123b);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements g.InterfaceC1802g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f66125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f66126b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f66127c;

        public c(boolean z, int i2, int i3) {
            this.f66125a = z;
            this.f66126b = i2;
            this.f66127c = i3;
        }

        @Override // d.o.a.d.f.g.InterfaceC1802g
        public void a(d.o.a.b.a.c.b bVar) {
            i.this.f66113b.k(i.this.f66118g, this.f66125a);
            d.o.a.e.a.e.F().j(n.a(), this.f66126b, this.f66127c);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements f {
        public e() {
        }

        @Override // d.o.a.d.f.i.f
        public void a() {
            if (i.this.f66114c.n()) {
                return;
            }
            i.this.P();
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(long j);
    }

    /* loaded from: classes6.dex */
    public class h extends AsyncTask<String, Void, DownloadInfo> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr != null) {
                if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                    String str = strArr[0];
                    if (i.this.m != null && !TextUtils.isEmpty(i.this.m.n())) {
                        downloadInfo = d.o.a.e.b.g.a.l(n.a()).g(str, i.this.m.n());
                    }
                    return downloadInfo == null ? d.o.a.e.a.e.F().e(n.a(), str) : downloadInfo;
                }
                return null;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || i.this.m == null) {
                return;
            }
            try {
                c.d j = d.o.a.d.n.k.j(i.this.m.v(), i.this.m.r(), i.this.m.s());
                c.i.a().b(i.this.m.r(), j.c(), c.g.e().c(downloadInfo));
                boolean b2 = j.b();
                if (downloadInfo != null && downloadInfo.c0() != 0 && (b2 || !d.o.a.e.b.g.a.l(n.a()).t(downloadInfo))) {
                    d.o.a.e.b.g.a.l(n.a()).y(downloadInfo.c0());
                    if (i.this.f66118g == null || i.this.f66118g.H0() != -4) {
                        i.this.f66118g = downloadInfo;
                        if (i.this.r) {
                            d.o.a.e.b.g.a.l(n.a()).F(i.this.f66118g.c0(), i.this.f66120i, false);
                        } else {
                            d.o.a.e.b.g.a.l(n.a()).E(i.this.f66118g.c0(), i.this.f66120i);
                        }
                    } else {
                        i.this.f66118g = null;
                    }
                    i.this.f66113b.j(i.this.f66118g, i.this.R(), k.d(i.this.f66116e));
                } else {
                    if (downloadInfo != null && d.o.a.e.b.g.a.l(n.a()).t(downloadInfo)) {
                        d.o.a.e.b.p.b.a().m(downloadInfo.c0());
                        i.this.f66118g = null;
                    }
                    if (i.this.f66118g != null) {
                        d.o.a.e.b.g.a.l(n.a()).y(i.this.f66118g.c0());
                        if (i.this.r) {
                            d.o.a.e.b.g.a.l(i.this.J()).F(i.this.f66118g.c0(), i.this.f66120i, false);
                        } else {
                            d.o.a.e.b.g.a.l(i.this.J()).E(i.this.f66118g.c0(), i.this.f66120i);
                        }
                    }
                    if (!b2) {
                        for (d.o.a.a.a.c.e eVar : k.d(i.this.f66116e)) {
                            eVar.a();
                        }
                        i.this.f66118g = null;
                    } else {
                        i.this.f66118g = new DownloadInfo.b(i.this.m.a()).C();
                        i.this.f66118g.a3(-3);
                        i.this.f66113b.j(i.this.f66118g, i.this.R(), k.d(i.this.f66116e));
                    }
                }
                i.this.f66113b.s(i.this.f66118g);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public /* synthetic */ h(i iVar, a aVar) {
            this();
        }
    }

    public final void B(boolean z) {
        d.o.a.a.a.c.b bVar;
        d.o.a.a.a.c.b bVar2;
        d.o.a.a.a.c.d dVar;
        d.o.a.d.n.j.a(t, "performButtonClickWithNewDownloader", null);
        if (this.f66118g != null && d.o.a.e.b.j.a.r().l("fix_info")) {
            this.f66118g = d.o.a.e.b.g.a.l(J()).f(this.f66118g.c0());
        }
        DownloadInfo downloadInfo = this.f66118g;
        if (downloadInfo != null && ((downloadInfo.H0() == -3 || d.o.a.e.b.g.a.l(n.a()).a(this.f66118g.c0())) && this.f66118g.H0() != 0)) {
            String str = t;
            d.o.a.d.n.j.a(str, "performButtonClickWithNewDownloader continue download, status:" + this.f66118g.H0(), null);
            DownloadInfo downloadInfo2 = this.f66118g;
            if (downloadInfo2 != null && (dVar = this.m) != null) {
                downloadInfo2.Q2(dVar.m());
            }
            int H0 = this.f66118g.H0();
            int c0 = this.f66118g.c0();
            d.o.a.b.a.c.b c2 = c.g.e().c(this.f66118g);
            if (H0 != -4 && H0 != -2 && H0 != -1) {
                if (p.c(H0)) {
                    this.f66114c.m(true);
                    i.C1808i.a().g(c.g.e().u(this.l));
                    g.j.a().b(c2, H0, new c(z, c0, H0));
                    return;
                }
                this.f66113b.k(this.f66118g, z);
                d.o.a.e.a.e.F().j(n.a(), c0, H0);
                return;
            }
            this.f66113b.k(this.f66118g, z);
            if (c2 != null) {
                c2.I0(System.currentTimeMillis());
                c2.M0(this.f66118g.E());
            }
            this.f66118g.p2(false);
            this.f66114c.j(new c.f(this.l, this.m, L(), M()));
            this.f66114c.f(c0, this.f66118g.E(), this.f66118g.Q0(), new b(c0, H0));
            return;
        }
        c.f v = c.g.e().v(this.l);
        DownloadInfo downloadInfo3 = this.f66118g;
        if (downloadInfo3 != null && downloadInfo3.H0() != 0) {
            p(z);
        } else if (this.q) {
            if (this.m.t() && this.s != null) {
                if (S() && (bVar2 = v.f66032d) != null && bVar2.f()) {
                    p(z);
                    return;
                }
                return;
            }
            p(z);
        } else if (this.m.t() && (bVar = v.f66032d) != null && bVar.e() && v.f66030b != null && d.o.a.d.f.f.b.a().e(v.f66030b) && d.o.a.d.f.f.b.a().f(v)) {
        } else {
            p(z);
        }
    }

    public final boolean F() {
        return n.s().optInt("quick_app_enable_switch", 0) == 0 && d.o.a.d.f.e.c(this.m) && d.o.a.d.f.e.d(this.f66118g);
    }

    public final void I() {
        SoftReference<s> softReference = this.p;
        if (softReference != null && softReference.get() != null) {
            this.p.get().a(this.m, L(), M());
            this.p = null;
            return;
        }
        n.m().b(J(), this.m, M(), L());
    }

    public final Context J() {
        WeakReference<Context> weakReference = this.f66115d;
        if (weakReference != null && weakReference.get() != null) {
            return this.f66115d.get();
        }
        return n.a();
    }

    @NonNull
    public final d.o.a.a.a.c.c L() {
        d.o.a.a.a.c.c cVar = this.n;
        return cVar == null ? new h.b().a() : cVar;
    }

    @NonNull
    public final d.o.a.a.a.c.b M() {
        if (this.o == null) {
            this.o = new d.o.a.a.a.c.g();
        }
        return this.o;
    }

    public final void N() {
        d.o.a.d.n.j.a(t, "performItemClickWithNewDownloader", null);
        if (this.f66113b.u(this.f66118g)) {
            d.o.a.d.n.j.a(t, "performItemClickWithNewDownloader ButtonClick", null);
            B(false);
            return;
        }
        d.o.a.d.n.j.a(t, "performItemClickWithNewDownloader onItemClick", null);
        I();
    }

    public final void O() {
        this.f66114c.j(new c.f(this.l, this.m, L(), M()));
        this.f66114c.f(0, 0L, 0L, new e());
    }

    public final void P() {
        for (d.o.a.a.a.c.e eVar : k.d(this.f66116e)) {
            eVar.a(this.m, M());
        }
        int a2 = this.f66113b.a(n.a(), this.f66120i);
        String str = t;
        d.o.a.d.n.j.a(str, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.f66118g != null && !d.o.a.e.b.j.a.r().l("fix_click_start")) {
                this.f66113b.k(this.f66118g, false);
            } else {
                this.f66113b.e();
            }
        } else {
            DownloadInfo C = new DownloadInfo.b(this.m.a()).C();
            C.a3(-1);
            n(C);
            j.c.a().e(this.l, new BaseException(2, "start download failed, id=0"));
            d.o.a.d.n.k.B();
        }
        if (this.f66113b.n(s())) {
            String str2 = t;
            d.o.a.d.n.j.a(str2, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            I();
        }
    }

    public final void Q() {
        h hVar = this.f66119h;
        if (hVar != null && hVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f66119h.cancel(true);
        }
        h hVar2 = new h(this, null);
        this.f66119h = hVar2;
        d.o.a.d.n.b.a(hVar2, this.m.a(), this.m.v());
    }

    public final d.o.a.a.a.d.e R() {
        if (this.f66117f == null) {
            this.f66117f = new d.o.a.a.a.d.e();
        }
        return this.f66117f;
    }

    public final boolean S() {
        SoftReference<d.o.a.a.a.a.n> softReference = this.s;
        if (softReference != null && softReference.get() != null) {
            this.s.get().a(true);
            this.s = null;
            return true;
        }
        k.f.b(this.l, new BaseException(7, "downloadSDK: mDownloadButtonClickListener has recycled"));
        return false;
    }

    @Override // d.o.a.d.f.j
    public /* synthetic */ j a(d.o.a.a.a.c.c cVar) {
        j(cVar);
        return this;
    }

    @Override // d.o.a.d.f.j
    public /* synthetic */ j b(Context context) {
        h(context);
        return this;
    }

    @Override // d.o.a.d.f.j
    public j c(d.o.a.a.a.a.n nVar) {
        if (nVar == null) {
            this.s = null;
        } else {
            this.s = new SoftReference<>(nVar);
        }
        return this;
    }

    @Override // d.o.a.d.f.j
    public /* synthetic */ j d(int i2, d.o.a.a.a.c.e eVar) {
        g(i2, eVar);
        return this;
    }

    @Override // d.o.a.d.f.j
    public /* synthetic */ j e(d.o.a.a.a.c.b bVar) {
        i(bVar);
        return this;
    }

    @Override // d.o.a.d.f.j
    public j f(s sVar) {
        if (sVar == null) {
            this.p = null;
        } else {
            this.p = new SoftReference<>(sVar);
        }
        return this;
    }

    public i g(int i2, d.o.a.a.a.c.e eVar) {
        if (eVar != null) {
            if (n.s().optInt("back_use_softref_listener") == 1) {
                this.f66116e.put(Integer.valueOf(i2), eVar);
            } else {
                this.f66116e.put(Integer.valueOf(i2), new SoftReference(eVar));
            }
        }
        return this;
    }

    public i h(Context context) {
        if (context != null) {
            this.f66115d = new WeakReference<>(context);
        }
        n.l(context);
        return this;
    }

    public i i(d.o.a.a.a.c.b bVar) {
        JSONObject z;
        this.o = bVar;
        if (d.o.a.d.n.e.g(this.m).m("force_auto_open") == 1) {
            M().b(1);
        }
        if (d.o.a.e.b.j.a.r().l("fix_show_dialog") && (z = this.m.z()) != null && z.optInt("subprocess") > 0) {
            M().a(false);
        }
        c.g.e().g(this.l, M());
        return this;
    }

    public i j(d.o.a.a.a.c.c cVar) {
        this.n = cVar;
        this.q = L().k() == 0;
        c.g.e().h(this.l, L());
        return this;
    }

    public i k(d.o.a.a.a.c.d dVar) {
        if (dVar != null) {
            c.g.e().i(dVar);
            this.l = dVar.d();
            this.m = dVar;
            if (l.f(dVar)) {
                ((d.o.a.b.a.a.c) dVar).c(3L);
                d.o.a.b.a.c.b u = c.g.e().u(this.l);
                if (u != null && u.l() != 3) {
                    u.w0(3L);
                    c.j.b().c(u);
                }
            }
        }
        return this;
    }

    public final void n(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.f66112a.sendMessage(obtain);
    }

    public void p(boolean z) {
        if (z) {
            j.c.a().c(this.l, 2);
        }
        if (!d.o.a.d.n.i.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION) && !M().g()) {
            this.m.a(this.f66113b.p());
        }
        if (d.o.a.d.n.e.j(this.m) == 0) {
            d.o.a.d.n.j.a(t, "performButtonClickWithNewDownloader not start", null);
            this.f66113b.h(new d());
            return;
        }
        O();
    }

    public final void r(boolean z) {
        y(z);
    }

    public boolean s() {
        return this.f66118g != null;
    }

    public final boolean t(int i2) {
        if (F()) {
            int i3 = -1;
            String a2 = this.m.B().a();
            if (i2 == 1) {
                i3 = 5;
            } else if (i2 == 2) {
                i3 = 4;
            }
            d.o.a.a.a.c.d dVar = this.m;
            if (dVar instanceof d.o.a.b.a.a.c) {
                ((d.o.a.b.a.a.c) dVar).b(3);
            }
            boolean o = d.o.a.d.n.h.o(n.a(), a2);
            if (o) {
                j.c.a().c(this.l, i2);
                Message obtain = Message.obtain();
                obtain.what = i3;
                obtain.obj = Long.valueOf(this.m.d());
                this.f66112a.sendMessageDelayed(obtain, d.o.a.d.f.e.a().e());
                d.o.a.d.f.e.a().b(i3, this.m, this.n);
            } else {
                j.c.a().g(this.l, false, 0);
            }
            return o;
        }
        return false;
    }

    public final void v(boolean z) {
        if (z) {
            j.c.a().c(this.l, 1);
        }
        N();
    }

    public void x() {
        this.f66112a.post(new a());
    }

    public final void y(boolean z) {
        if (d.o.a.d.n.e.g(this.m).m("notification_opt_2") == 1 && this.f66118g != null) {
            d.o.a.e.b.p.b.a().m(this.f66118g.c0());
        }
        B(z);
    }

    public void z() {
        if (this.f66116e.size() == 0) {
            return;
        }
        for (d.o.a.a.a.c.e eVar : k.d(this.f66116e)) {
            eVar.a();
        }
        DownloadInfo downloadInfo = this.f66118g;
        if (downloadInfo != null) {
            downloadInfo.a3(-4);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements q {
        public d() {
        }

        @Override // d.o.a.a.a.a.q
        public void a() {
            d.o.a.d.n.j.a(i.t, "performButtonClickWithNewDownloader start download", null);
            i.this.O();
        }

        @Override // d.o.a.a.a.a.q
        public void a(String str) {
            d.o.a.d.n.j.a(i.t, "performButtonClickWithNewDownloader onDenied", null);
        }
    }

    @Override // d.o.a.d.f.j
    public void a() {
        this.j = true;
        c.g.e().h(this.l, L());
        c.g.e().g(this.l, M());
        this.f66113b.f(this.l);
        Q();
        if (n.s().optInt("enable_empty_listener", 1) == 1 && this.f66116e.get(Integer.MIN_VALUE) == null) {
            g(Integer.MIN_VALUE, new d.o.a.a.a.a.a());
        }
    }

    @Override // d.o.a.d.f.j
    public /* synthetic */ j b(d.o.a.a.a.c.d dVar) {
        k(dVar);
        return this;
    }

    @Override // d.o.a.d.f.j
    public long d() {
        return this.k;
    }

    @Override // d.o.a.d.f.j
    public boolean b() {
        return this.j;
    }

    @Override // d.o.a.d.f.j
    public void b(int i2) {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f66113b.f(this.l);
        if (!c.g.e().v(this.l).x()) {
            d.o.a.d.n.k.B();
        }
        if (this.f66113b.m(J(), i2, this.q)) {
            return;
        }
        boolean t2 = t(i2);
        if (i2 == 1) {
            if (t2) {
                return;
            }
            String str = t;
            d.o.a.d.n.j.a(str, "handleDownload id:" + this.l + ",tryPerformItemClick:", null);
            v(true);
        } else if (i2 == 2 && !t2) {
            String str2 = t;
            d.o.a.d.n.j.a(str2, "handleDownload id:" + this.l + ",tryPerformButtonClick:", null);
            r(true);
        }
    }

    @Override // d.o.a.d.f.j
    public void g() {
        c.g.e().w(this.l);
    }

    @Override // d.o.a.d.f.j
    public boolean a(int i2) {
        if (i2 == 0) {
            this.f66116e.clear();
        } else {
            this.f66116e.remove(Integer.valueOf(i2));
        }
        boolean z = false;
        if (this.f66116e.isEmpty()) {
            this.j = false;
            this.k = System.currentTimeMillis();
            if (this.f66118g != null) {
                d.o.a.e.b.g.a.l(n.a()).y(this.f66118g.c0());
            }
            h hVar = this.f66119h;
            z = true;
            if (hVar != null && hVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f66119h.cancel(true);
            }
            this.f66113b.i(this.f66118g);
            String str = t;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f66118g;
            sb.append(downloadInfo == null ? "" : downloadInfo.T0());
            d.o.a.d.n.j.a(str, sb.toString(), null);
            this.f66112a.removeCallbacksAndMessages(null);
            this.f66117f = null;
            this.f66118g = null;
        }
        return z;
    }

    @Override // d.o.a.d.f.j
    public void a(boolean z) {
        if (this.f66118g != null) {
            if (z) {
                d.f t2 = d.o.a.e.a.e.F().t();
                if (t2 != null) {
                    t2.a(this.f66118g);
                }
                d.o.a.e.b.g.a.l(d.o.a.e.b.g.d.l()).c(this.f66118g.c0(), true);
                return;
            }
            Intent intent = new Intent(n.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f66118g.c0());
            n.a().startService(intent);
        }
    }

    @Override // d.o.a.d.f.j
    public j a(long j) {
        if (j > 0) {
            d.o.a.a.a.c.d a2 = c.g.e().a(j);
            if (a2 != null) {
                this.m = a2;
                this.l = j;
                this.f66113b.f(j);
            }
        } else {
            d.o.a.d.n.k.B();
        }
        return this;
    }

    @Override // d.o.a.d.n.l.a
    public void a(Message message) {
        if (message == null || !this.j) {
            return;
        }
        int i2 = message.what;
        if (i2 == 3) {
            this.f66118g = (DownloadInfo) message.obj;
            this.f66113b.g(message, R(), this.f66116e);
        } else if (i2 == 4) {
            if (n.u() == null || !n.u().a()) {
                j.c.a().g(this.l, false, 2);
                r(false);
            }
        } else if (i2 != 5) {
        } else {
            if (n.u() == null || !n.u().a()) {
                j.c.a().g(this.l, false, 1);
                v(false);
            }
        }
    }
}
