package d.a.l0.r;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.ubc.Flow;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public class n {

    /* renamed from: h  reason: collision with root package name */
    public static volatile n f52091h;

    /* renamed from: a  reason: collision with root package name */
    public Context f52092a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f52093b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f52094c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.r.d f52095d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.r.c f52096e;

    /* renamed from: f  reason: collision with root package name */
    public int f52097f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52098g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            cVar.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f52100e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52101f;

        public b(JSONArray jSONArray, String str) {
            this.f52100e = jSONArray;
            this.f52101f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            cVar.u(this.f52100e, this.f52101f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f52103e;

        public c(JSONArray jSONArray) {
            this.f52103e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            cVar.w(this.f52103e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            cVar.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f52106e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52107f;

        public e(boolean z, String str) {
            this.f52106e = z;
            this.f52107f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            if (this.f52106e) {
                cVar.y(this.f52107f);
            } else {
                cVar.x(this.f52107f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f52109e;

        public f(q qVar) {
            this.f52109e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            cVar.r(this.f52109e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f52113e;

        /* renamed from: f  reason: collision with root package name */
        public int f52114f;

        public h(String str, int i2) {
            this.f52113e = str;
            this.f52114f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            cVar.a(this.f52113e, this.f52114f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.l0.r.k f52116e;

        public i(Flow flow, String str) {
            d.a.l0.r.k kVar = new d.a.l0.r.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f52116e = kVar;
            kVar.f52086e = flow.i();
            this.f52116e.f52089h = "1";
            n.this.f52097f++;
        }

        public void a(boolean z) {
            d.a.l0.r.k kVar = this.f52116e;
            if (kVar != null) {
                kVar.l = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f52096e == null) {
                return;
            }
            this.f52116e.a();
            if (!TextUtils.isEmpty(n.this.f52095d.d(this.f52116e.f52082a))) {
                d.a.l0.r.k kVar = this.f52116e;
                kVar.j = n.this.f52095d.d(kVar.f52082a);
            }
            n.this.f52096e.p(this.f52116e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f52118e;

        /* renamed from: f  reason: collision with root package name */
        public int f52119f;

        /* renamed from: g  reason: collision with root package name */
        public long f52120g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f52121h;

        public j(String str, int i2, JSONArray jSONArray) {
            this.f52118e = str;
            this.f52119f = i2;
            this.f52121h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            cVar.d(this.f52118e, this.f52119f, this.f52120g, this.f52121h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f52123e;

        /* renamed from: f  reason: collision with root package name */
        public int f52124f;

        /* renamed from: g  reason: collision with root package name */
        public String f52125g;

        public k(String str, int i2, String str2) {
            this.f52123e = str;
            this.f52124f = i2;
            this.f52125g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f52096e;
            if (cVar == null) {
                return;
            }
            cVar.s(this.f52123e, this.f52124f, this.f52125g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f52095d = d.a.l0.r.d.g();
            n nVar = n.this;
            nVar.f52096e = new d.a.l0.r.c(nVar.f52092a);
            n.this.f52096e.o();
        }
    }

    public n() {
        g(d.a.l0.r.e.f());
    }

    public static n f() {
        if (f52091h == null) {
            synchronized (n.class) {
                if (f52091h == null) {
                    f52091h = new n();
                }
            }
        }
        return f52091h;
    }

    public synchronized Flow a(String str, String str2, int i2) {
        Flow d2;
        d2 = d(str, i2);
        if (d2 != null && d2.j()) {
            i iVar = new i(d2, str2);
            if (this.f52095d != null && this.f52095d.m(str)) {
                iVar.a(true);
            }
            this.f52093b.execute(iVar);
        }
        return d2;
    }

    public void b(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f52093b.execute(new d.a.l0.p.a(i2));
        this.f52094c.execute(new d.a.l0.p.a(i2));
    }

    public void c(String str, int i2) {
        this.f52093b.execute(new h(str, i2));
    }

    public Flow d(String str, int i2) {
        Flow flow = new Flow(str, this.f52097f, i2);
        d.a.l0.r.d dVar = this.f52095d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.a.l0.r.e.h().c(str)) {
            flow.m(false);
            return flow;
        } else {
            d.a.l0.r.d dVar2 = this.f52095d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f52095d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.a.l0.r.d dVar3 = this.f52095d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void e(String str, int i2, JSONArray jSONArray) {
        this.f52093b.execute(new j(str, i2, jSONArray));
    }

    public final void g(Context context) {
        if (this.f52092a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f52092a = context;
        } else {
            this.f52092a = context.getApplicationContext();
        }
        int i2 = d.a.l0.d.b.g().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f52097f = i2;
        if (i2 > 1073741823) {
            this.f52097f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.f52097f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }
        ExecutorService h2 = h();
        this.f52093b = h2;
        h2.execute(new l());
        this.f52094c = Executors.newSingleThreadExecutor();
    }

    public final ExecutorService h() {
        if (d.a.l0.r.e.h() != null && !d.a.l0.r.e.h().j()) {
            if (d.a.l0.r.e.h().d() == null) {
                return Executors.newSingleThreadExecutor();
            }
            return d.a.l0.r.e.h().d();
        }
        return Executors.newSingleThreadExecutor();
    }

    public boolean i(String str, int i2) {
        return TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20;
    }

    public void j(String str, String str2, int i2) {
        if (i(str, i2)) {
            return;
        }
        g gVar = new g(str, str2, i2);
        d.a.l0.r.d dVar = this.f52095d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f52093b.execute(gVar);
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        if (i(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.a.l0.r.d dVar = this.f52095d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f52093b.execute(gVar);
    }

    public void l() {
        this.f52093b.execute(new d());
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        this.f52093b.execute(new g(str, str2, i2, str3, i3));
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f52093b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void o(q qVar) {
        this.f52093b.execute(new f(qVar));
    }

    public void p(String str, int i2, String str2) {
        this.f52093b.execute(new k(str, i2, str2));
    }

    public void q() {
        if (this.f52098g) {
            return;
        }
        this.f52098g = true;
        this.f52093b.execute(new a());
    }

    public void r(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f52094c.execute(new b(jSONArray, str));
    }

    public void s(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f52094c.execute(new c(jSONArray));
    }

    public void t(String str, boolean z) {
        this.f52093b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.l0.r.i f52111e;

        public g(String str, String str2, int i2) {
            this.f52111e = new d.a.l0.r.i(str, str2, i2);
        }

        public void a(boolean z) {
            d.a.l0.r.i iVar = this.f52111e;
            if (iVar != null) {
                iVar.j = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f52096e == null) {
                return;
            }
            this.f52111e.b();
            if (!TextUtils.isEmpty(n.this.f52095d.d(this.f52111e.f52072a))) {
                d.a.l0.r.i iVar = this.f52111e;
                iVar.f52080i = n.this.f52095d.d(iVar.f52072a);
            }
            d.a.l0.r.i iVar2 = this.f52111e;
            if ((iVar2.f52078g & 8) != 0) {
                n.this.f52096e.l(iVar2);
            } else {
                n.this.f52096e.k(iVar2);
            }
        }

        public g(String str, JSONObject jSONObject, int i2) {
            this.f52111e = new d.a.l0.r.i(str, jSONObject, i2);
        }

        public g(String str, String str2, int i2, String str3, int i3) {
            this.f52111e = new d.a.l0.r.i(str, str2, i2, str3, i3);
        }

        public g(String str, String str2, int i2, String str3, long j, int i3) {
            this.f52111e = new d.a.l0.r.i(str, str2, i2, str3, j, i3);
        }
    }
}
