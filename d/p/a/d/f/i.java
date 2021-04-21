package d.p.a.d.f;

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
import d.p.a.a.a.a.q;
import d.p.a.a.a.a.s;
import d.p.a.a.a.c.h;
import d.p.a.d.f.c;
import d.p.a.d.f.g;
import d.p.a.d.f.k;
import d.p.a.d.i;
import d.p.a.d.j;
import d.p.a.d.k;
import d.p.a.d.n.l;
import d.p.a.e.a.d;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i implements j, l.a {
    public static final String t = "i";

    /* renamed from: d  reason: collision with root package name */
    public WeakReference<Context> f67768d;

    /* renamed from: f  reason: collision with root package name */
    public d.p.a.a.a.d.e f67770f;

    /* renamed from: g  reason: collision with root package name */
    public DownloadInfo f67771g;

    /* renamed from: h  reason: collision with root package name */
    public h f67772h;
    public boolean j;
    public long k;
    public SoftReference<s> p;
    public boolean q;
    public SoftReference<d.p.a.a.a.a.n> s;

    /* renamed from: a  reason: collision with root package name */
    public final d.p.a.d.n.l f67765a = new d.p.a.d.n.l(Looper.getMainLooper(), this);

    /* renamed from: e  reason: collision with root package name */
    public final Map<Integer, Object> f67769e = new ConcurrentHashMap();
    public final d.p.a.e.b.f.b i = new k.d(this.f67765a);
    public long l = -1;
    public d.p.a.a.a.c.d m = null;
    public d.p.a.a.a.c.c n = null;
    public d.p.a.a.a.c.b o = null;

    /* renamed from: b  reason: collision with root package name */
    public k f67766b = new k();

    /* renamed from: c  reason: collision with root package name */
    public d.p.a.d.f.h f67767c = new d.p.a.d.f.h(this.f67765a);
    public final boolean r = d.p.a.e.b.j.a.r().l("ttdownloader_callback_twice");

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (d.p.a.a.a.c.e eVar : k.d(i.this.f67769e)) {
                eVar.b(i.this.R());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f67774a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f67775b;

        public b(int i, int i2) {
            this.f67774a = i;
            this.f67775b = i2;
        }

        @Override // d.p.a.d.f.i.f
        public void a() {
            if (i.this.f67767c.n()) {
                return;
            }
            d.p.a.e.a.e.F().j(n.a(), this.f67774a, this.f67775b);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements g.InterfaceC1867g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f67777a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f67778b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f67779c;

        public c(boolean z, int i, int i2) {
            this.f67777a = z;
            this.f67778b = i;
            this.f67779c = i2;
        }

        @Override // d.p.a.d.f.g.InterfaceC1867g
        public void a(d.p.a.b.a.c.b bVar) {
            i.this.f67766b.k(i.this.f67771g, this.f67777a);
            d.p.a.e.a.e.F().j(n.a(), this.f67778b, this.f67779c);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements f {
        public e() {
        }

        @Override // d.p.a.d.f.i.f
        public void a() {
            if (i.this.f67767c.n()) {
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
                        downloadInfo = d.p.a.e.b.g.a.l(n.a()).g(str, i.this.m.n());
                    }
                    return downloadInfo == null ? d.p.a.e.a.e.F().e(n.a(), str) : downloadInfo;
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
                c.d j = d.p.a.d.n.k.j(i.this.m.v(), i.this.m.r(), i.this.m.s());
                c.i.a().b(i.this.m.r(), j.c(), c.g.e().c(downloadInfo));
                boolean b2 = j.b();
                if (downloadInfo != null && downloadInfo.c0() != 0 && (b2 || !d.p.a.e.b.g.a.l(n.a()).t(downloadInfo))) {
                    d.p.a.e.b.g.a.l(n.a()).y(downloadInfo.c0());
                    if (i.this.f67771g == null || i.this.f67771g.H0() != -4) {
                        i.this.f67771g = downloadInfo;
                        if (i.this.r) {
                            d.p.a.e.b.g.a.l(n.a()).F(i.this.f67771g.c0(), i.this.i, false);
                        } else {
                            d.p.a.e.b.g.a.l(n.a()).E(i.this.f67771g.c0(), i.this.i);
                        }
                    } else {
                        i.this.f67771g = null;
                    }
                    i.this.f67766b.j(i.this.f67771g, i.this.R(), k.d(i.this.f67769e));
                } else {
                    if (downloadInfo != null && d.p.a.e.b.g.a.l(n.a()).t(downloadInfo)) {
                        d.p.a.e.b.p.b.a().m(downloadInfo.c0());
                        i.this.f67771g = null;
                    }
                    if (i.this.f67771g != null) {
                        d.p.a.e.b.g.a.l(n.a()).y(i.this.f67771g.c0());
                        if (i.this.r) {
                            d.p.a.e.b.g.a.l(i.this.J()).F(i.this.f67771g.c0(), i.this.i, false);
                        } else {
                            d.p.a.e.b.g.a.l(i.this.J()).E(i.this.f67771g.c0(), i.this.i);
                        }
                    }
                    if (!b2) {
                        for (d.p.a.a.a.c.e eVar : k.d(i.this.f67769e)) {
                            eVar.a();
                        }
                        i.this.f67771g = null;
                    } else {
                        i.this.f67771g = new DownloadInfo.b(i.this.m.a()).C();
                        i.this.f67771g.a3(-3);
                        i.this.f67766b.j(i.this.f67771g, i.this.R(), k.d(i.this.f67769e));
                    }
                }
                i.this.f67766b.s(i.this.f67771g);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public /* synthetic */ h(i iVar, a aVar) {
            this();
        }
    }

    public final void B(boolean z) {
        d.p.a.a.a.c.b bVar;
        d.p.a.a.a.c.b bVar2;
        d.p.a.a.a.c.d dVar;
        d.p.a.d.n.j.a(t, "performButtonClickWithNewDownloader", null);
        if (this.f67771g != null && d.p.a.e.b.j.a.r().l("fix_info")) {
            this.f67771g = d.p.a.e.b.g.a.l(J()).f(this.f67771g.c0());
        }
        DownloadInfo downloadInfo = this.f67771g;
        if (downloadInfo != null && ((downloadInfo.H0() == -3 || d.p.a.e.b.g.a.l(n.a()).a(this.f67771g.c0())) && this.f67771g.H0() != 0)) {
            String str = t;
            d.p.a.d.n.j.a(str, "performButtonClickWithNewDownloader continue download, status:" + this.f67771g.H0(), null);
            DownloadInfo downloadInfo2 = this.f67771g;
            if (downloadInfo2 != null && (dVar = this.m) != null) {
                downloadInfo2.Q2(dVar.m());
            }
            int H0 = this.f67771g.H0();
            int c0 = this.f67771g.c0();
            d.p.a.b.a.c.b c2 = c.g.e().c(this.f67771g);
            if (H0 != -4 && H0 != -2 && H0 != -1) {
                if (p.c(H0)) {
                    this.f67767c.m(true);
                    i.C1873i.a().g(c.g.e().u(this.l));
                    g.j.a().b(c2, H0, new c(z, c0, H0));
                    return;
                }
                this.f67766b.k(this.f67771g, z);
                d.p.a.e.a.e.F().j(n.a(), c0, H0);
                return;
            }
            this.f67766b.k(this.f67771g, z);
            if (c2 != null) {
                c2.I0(System.currentTimeMillis());
                c2.M0(this.f67771g.E());
            }
            this.f67771g.p2(false);
            this.f67767c.j(new c.f(this.l, this.m, L(), M()));
            this.f67767c.f(c0, this.f67771g.E(), this.f67771g.Q0(), new b(c0, H0));
            return;
        }
        c.f v = c.g.e().v(this.l);
        DownloadInfo downloadInfo3 = this.f67771g;
        if (downloadInfo3 != null && downloadInfo3.H0() != 0) {
            p(z);
        } else if (this.q) {
            if (this.m.t() && this.s != null) {
                if (S() && (bVar2 = v.f67686d) != null && bVar2.f()) {
                    p(z);
                    return;
                }
                return;
            }
            p(z);
        } else if (this.m.t() && (bVar = v.f67686d) != null && bVar.e() && v.f67684b != null && d.p.a.d.f.f.b.a().e(v.f67684b) && d.p.a.d.f.f.b.a().f(v)) {
        } else {
            p(z);
        }
    }

    public final boolean F() {
        return n.s().optInt("quick_app_enable_switch", 0) == 0 && d.p.a.d.f.e.c(this.m) && d.p.a.d.f.e.d(this.f67771g);
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
        WeakReference<Context> weakReference = this.f67768d;
        if (weakReference != null && weakReference.get() != null) {
            return this.f67768d.get();
        }
        return n.a();
    }

    @NonNull
    public final d.p.a.a.a.c.c L() {
        d.p.a.a.a.c.c cVar = this.n;
        return cVar == null ? new h.b().a() : cVar;
    }

    @NonNull
    public final d.p.a.a.a.c.b M() {
        if (this.o == null) {
            this.o = new d.p.a.a.a.c.g();
        }
        return this.o;
    }

    public final void N() {
        d.p.a.d.n.j.a(t, "performItemClickWithNewDownloader", null);
        if (this.f67766b.u(this.f67771g)) {
            d.p.a.d.n.j.a(t, "performItemClickWithNewDownloader ButtonClick", null);
            B(false);
            return;
        }
        d.p.a.d.n.j.a(t, "performItemClickWithNewDownloader onItemClick", null);
        I();
    }

    public final void O() {
        this.f67767c.j(new c.f(this.l, this.m, L(), M()));
        this.f67767c.f(0, 0L, 0L, new e());
    }

    public final void P() {
        for (d.p.a.a.a.c.e eVar : k.d(this.f67769e)) {
            eVar.a(this.m, M());
        }
        int a2 = this.f67766b.a(n.a(), this.i);
        String str = t;
        d.p.a.d.n.j.a(str, "beginDownloadWithNewDownloader id:" + a2, null);
        if (a2 != 0) {
            if (this.f67771g != null && !d.p.a.e.b.j.a.r().l("fix_click_start")) {
                this.f67766b.k(this.f67771g, false);
            } else {
                this.f67766b.e();
            }
        } else {
            DownloadInfo C = new DownloadInfo.b(this.m.a()).C();
            C.a3(-1);
            n(C);
            j.c.a().e(this.l, new BaseException(2, "start download failed, id=0"));
            d.p.a.d.n.k.B();
        }
        if (this.f67766b.n(s())) {
            String str2 = t;
            d.p.a.d.n.j.a(str2, "beginDownloadWithNewDownloader onItemClick id:" + a2, null);
            I();
        }
    }

    public final void Q() {
        h hVar = this.f67772h;
        if (hVar != null && hVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f67772h.cancel(true);
        }
        h hVar2 = new h(this, null);
        this.f67772h = hVar2;
        d.p.a.d.n.b.a(hVar2, this.m.a(), this.m.v());
    }

    public final d.p.a.a.a.d.e R() {
        if (this.f67770f == null) {
            this.f67770f = new d.p.a.a.a.d.e();
        }
        return this.f67770f;
    }

    public final boolean S() {
        SoftReference<d.p.a.a.a.a.n> softReference = this.s;
        if (softReference != null && softReference.get() != null) {
            this.s.get().a(true);
            this.s = null;
            return true;
        }
        k.f.b(this.l, new BaseException(7, "downloadSDK: mDownloadButtonClickListener has recycled"));
        return false;
    }

    @Override // d.p.a.d.f.j
    public /* synthetic */ j a(d.p.a.a.a.c.c cVar) {
        j(cVar);
        return this;
    }

    @Override // d.p.a.d.f.j
    public /* synthetic */ j b(Context context) {
        h(context);
        return this;
    }

    @Override // d.p.a.d.f.j
    public j c(d.p.a.a.a.a.n nVar) {
        if (nVar == null) {
            this.s = null;
        } else {
            this.s = new SoftReference<>(nVar);
        }
        return this;
    }

    @Override // d.p.a.d.f.j
    public /* synthetic */ j d(int i, d.p.a.a.a.c.e eVar) {
        g(i, eVar);
        return this;
    }

    @Override // d.p.a.d.f.j
    public j e(s sVar) {
        if (sVar == null) {
            this.p = null;
        } else {
            this.p = new SoftReference<>(sVar);
        }
        return this;
    }

    @Override // d.p.a.d.f.j
    public /* synthetic */ j f(d.p.a.a.a.c.b bVar) {
        i(bVar);
        return this;
    }

    public i g(int i, d.p.a.a.a.c.e eVar) {
        if (eVar != null) {
            if (n.s().optInt("back_use_softref_listener") == 1) {
                this.f67769e.put(Integer.valueOf(i), eVar);
            } else {
                this.f67769e.put(Integer.valueOf(i), new SoftReference(eVar));
            }
        }
        return this;
    }

    public i h(Context context) {
        if (context != null) {
            this.f67768d = new WeakReference<>(context);
        }
        n.l(context);
        return this;
    }

    public i i(d.p.a.a.a.c.b bVar) {
        JSONObject z;
        this.o = bVar;
        if (d.p.a.d.n.e.g(this.m).m("force_auto_open") == 1) {
            M().b(1);
        }
        if (d.p.a.e.b.j.a.r().l("fix_show_dialog") && (z = this.m.z()) != null && z.optInt("subprocess") > 0) {
            M().a(false);
        }
        c.g.e().g(this.l, M());
        return this;
    }

    public i j(d.p.a.a.a.c.c cVar) {
        this.n = cVar;
        this.q = L().k() == 0;
        c.g.e().h(this.l, L());
        return this;
    }

    public i k(d.p.a.a.a.c.d dVar) {
        if (dVar != null) {
            c.g.e().i(dVar);
            this.l = dVar.d();
            this.m = dVar;
            if (l.f(dVar)) {
                ((d.p.a.b.a.a.c) dVar).c(3L);
                d.p.a.b.a.c.b u = c.g.e().u(this.l);
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
        this.f67765a.sendMessage(obtain);
    }

    public void p(boolean z) {
        if (z) {
            j.c.a().c(this.l, 2);
        }
        if (!d.p.a.d.n.i.e(StorageUtils.EXTERNAL_STORAGE_PERMISSION) && !M().g()) {
            this.m.a(this.f67766b.p());
        }
        if (d.p.a.d.n.e.j(this.m) == 0) {
            d.p.a.d.n.j.a(t, "performButtonClickWithNewDownloader not start", null);
            this.f67766b.h(new d());
            return;
        }
        O();
    }

    public final void r(boolean z) {
        y(z);
    }

    public boolean s() {
        return this.f67771g != null;
    }

    public final boolean t(int i) {
        if (F()) {
            int i2 = -1;
            String a2 = this.m.B().a();
            if (i == 1) {
                i2 = 5;
            } else if (i == 2) {
                i2 = 4;
            }
            d.p.a.a.a.c.d dVar = this.m;
            if (dVar instanceof d.p.a.b.a.a.c) {
                ((d.p.a.b.a.a.c) dVar).b(3);
            }
            boolean o = d.p.a.d.n.h.o(n.a(), a2);
            if (o) {
                j.c.a().c(this.l, i);
                Message obtain = Message.obtain();
                obtain.what = i2;
                obtain.obj = Long.valueOf(this.m.d());
                this.f67765a.sendMessageDelayed(obtain, d.p.a.d.f.e.a().e());
                d.p.a.d.f.e.a().b(i2, this.m, this.n);
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
        this.f67765a.post(new a());
    }

    public final void y(boolean z) {
        if (d.p.a.d.n.e.g(this.m).m("notification_opt_2") == 1 && this.f67771g != null) {
            d.p.a.e.b.p.b.a().m(this.f67771g.c0());
        }
        B(z);
    }

    public void z() {
        if (this.f67769e.size() == 0) {
            return;
        }
        for (d.p.a.a.a.c.e eVar : k.d(this.f67769e)) {
            eVar.a();
        }
        DownloadInfo downloadInfo = this.f67771g;
        if (downloadInfo != null) {
            downloadInfo.a3(-4);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements q {
        public d() {
        }

        @Override // d.p.a.a.a.a.q
        public void a() {
            d.p.a.d.n.j.a(i.t, "performButtonClickWithNewDownloader start download", null);
            i.this.O();
        }

        @Override // d.p.a.a.a.a.q
        public void a(String str) {
            d.p.a.d.n.j.a(i.t, "performButtonClickWithNewDownloader onDenied", null);
        }
    }

    @Override // d.p.a.d.f.j
    public void a() {
        this.j = true;
        c.g.e().h(this.l, L());
        c.g.e().g(this.l, M());
        this.f67766b.f(this.l);
        Q();
        if (n.s().optInt("enable_empty_listener", 1) == 1 && this.f67769e.get(Integer.MIN_VALUE) == null) {
            g(Integer.MIN_VALUE, new d.p.a.a.a.a.a());
        }
    }

    @Override // d.p.a.d.f.j
    public /* synthetic */ j b(d.p.a.a.a.c.d dVar) {
        k(dVar);
        return this;
    }

    @Override // d.p.a.d.f.j
    public long d() {
        return this.k;
    }

    @Override // d.p.a.d.f.j
    public boolean b() {
        return this.j;
    }

    @Override // d.p.a.d.f.j
    public void b(int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f67766b.f(this.l);
        if (!c.g.e().v(this.l).x()) {
            d.p.a.d.n.k.B();
        }
        if (this.f67766b.m(J(), i, this.q)) {
            return;
        }
        boolean t2 = t(i);
        if (i == 1) {
            if (t2) {
                return;
            }
            String str = t;
            d.p.a.d.n.j.a(str, "handleDownload id:" + this.l + ",tryPerformItemClick:", null);
            v(true);
        } else if (i == 2 && !t2) {
            String str2 = t;
            d.p.a.d.n.j.a(str2, "handleDownload id:" + this.l + ",tryPerformButtonClick:", null);
            r(true);
        }
    }

    @Override // d.p.a.d.f.j
    public void g() {
        c.g.e().w(this.l);
    }

    @Override // d.p.a.d.f.j
    public boolean a(int i) {
        if (i == 0) {
            this.f67769e.clear();
        } else {
            this.f67769e.remove(Integer.valueOf(i));
        }
        boolean z = false;
        if (this.f67769e.isEmpty()) {
            this.j = false;
            this.k = System.currentTimeMillis();
            if (this.f67771g != null) {
                d.p.a.e.b.g.a.l(n.a()).y(this.f67771g.c0());
            }
            h hVar = this.f67772h;
            z = true;
            if (hVar != null && hVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f67772h.cancel(true);
            }
            this.f67766b.i(this.f67771g);
            String str = t;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f67771g;
            sb.append(downloadInfo == null ? "" : downloadInfo.T0());
            d.p.a.d.n.j.a(str, sb.toString(), null);
            this.f67765a.removeCallbacksAndMessages(null);
            this.f67770f = null;
            this.f67771g = null;
        }
        return z;
    }

    @Override // d.p.a.d.f.j
    public void a(boolean z) {
        if (this.f67771g != null) {
            if (z) {
                d.f t2 = d.p.a.e.a.e.F().t();
                if (t2 != null) {
                    t2.a(this.f67771g);
                }
                d.p.a.e.b.g.a.l(d.p.a.e.b.g.d.l()).c(this.f67771g.c0(), true);
                return;
            }
            Intent intent = new Intent(n.a(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f67771g.c0());
            n.a().startService(intent);
        }
    }

    @Override // d.p.a.d.f.j
    public j a(long j) {
        if (j > 0) {
            d.p.a.a.a.c.d a2 = c.g.e().a(j);
            if (a2 != null) {
                this.m = a2;
                this.l = j;
                this.f67766b.f(j);
            }
        } else {
            d.p.a.d.n.k.B();
        }
        return this;
    }

    @Override // d.p.a.d.n.l.a
    public void a(Message message) {
        if (message == null || !this.j) {
            return;
        }
        int i = message.what;
        if (i == 3) {
            this.f67771g = (DownloadInfo) message.obj;
            this.f67766b.g(message, R(), this.f67769e);
        } else if (i == 4) {
            if (n.u() == null || !n.u().a()) {
                j.c.a().g(this.l, false, 2);
                r(false);
            }
        } else if (i != 5) {
        } else {
            if (n.u() == null || !n.u().a()) {
                j.c.a().g(this.l, false, 1);
                v(false);
            }
        }
    }
}
