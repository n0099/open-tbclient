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
    public static volatile n f48417h;

    /* renamed from: a  reason: collision with root package name */
    public Context f48418a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f48419b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f48420c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.r.d f48421d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.r.c f48422e;

    /* renamed from: f  reason: collision with root package name */
    public int f48423f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48424g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            cVar.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f48426e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48427f;

        public b(JSONArray jSONArray, String str) {
            this.f48426e = jSONArray;
            this.f48427f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            cVar.u(this.f48426e, this.f48427f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f48429e;

        public c(JSONArray jSONArray) {
            this.f48429e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            cVar.w(this.f48429e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            cVar.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48433f;

        public e(boolean z, String str) {
            this.f48432e = z;
            this.f48433f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            if (this.f48432e) {
                cVar.y(this.f48433f);
            } else {
                cVar.x(this.f48433f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f48435e;

        public f(q qVar) {
            this.f48435e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            cVar.r(this.f48435e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48439e;

        /* renamed from: f  reason: collision with root package name */
        public int f48440f;

        public h(String str, int i2) {
            this.f48439e = str;
            this.f48440f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            cVar.a(this.f48439e, this.f48440f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.l0.r.k f48442e;

        public i(Flow flow, String str) {
            d.a.l0.r.k kVar = new d.a.l0.r.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f48442e = kVar;
            kVar.f48412e = flow.i();
            this.f48442e.f48415h = "1";
            n.this.f48423f++;
        }

        public void a(boolean z) {
            d.a.l0.r.k kVar = this.f48442e;
            if (kVar != null) {
                kVar.l = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f48422e == null) {
                return;
            }
            this.f48442e.a();
            if (!TextUtils.isEmpty(n.this.f48421d.d(this.f48442e.f48408a))) {
                d.a.l0.r.k kVar = this.f48442e;
                kVar.j = n.this.f48421d.d(kVar.f48408a);
            }
            n.this.f48422e.p(this.f48442e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48444e;

        /* renamed from: f  reason: collision with root package name */
        public int f48445f;

        /* renamed from: g  reason: collision with root package name */
        public long f48446g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f48447h;

        public j(String str, int i2, JSONArray jSONArray) {
            this.f48444e = str;
            this.f48445f = i2;
            this.f48447h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            cVar.d(this.f48444e, this.f48445f, this.f48446g, this.f48447h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48449e;

        /* renamed from: f  reason: collision with root package name */
        public int f48450f;

        /* renamed from: g  reason: collision with root package name */
        public String f48451g;

        public k(String str, int i2, String str2) {
            this.f48449e = str;
            this.f48450f = i2;
            this.f48451g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.r.c cVar = n.this.f48422e;
            if (cVar == null) {
                return;
            }
            cVar.s(this.f48449e, this.f48450f, this.f48451g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f48421d = d.a.l0.r.d.g();
            n nVar = n.this;
            nVar.f48422e = new d.a.l0.r.c(nVar.f48418a);
            n.this.f48422e.o();
        }
    }

    public n() {
        g(d.a.l0.r.e.f());
    }

    public static n f() {
        if (f48417h == null) {
            synchronized (n.class) {
                if (f48417h == null) {
                    f48417h = new n();
                }
            }
        }
        return f48417h;
    }

    public synchronized Flow a(String str, String str2, int i2) {
        Flow d2;
        d2 = d(str, i2);
        if (d2 != null && d2.j()) {
            i iVar = new i(d2, str2);
            if (this.f48421d != null && this.f48421d.m(str)) {
                iVar.a(true);
            }
            this.f48419b.execute(iVar);
        }
        return d2;
    }

    public void b(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f48419b.execute(new d.a.l0.p.a(i2));
        this.f48420c.execute(new d.a.l0.p.a(i2));
    }

    public void c(String str, int i2) {
        this.f48419b.execute(new h(str, i2));
    }

    public Flow d(String str, int i2) {
        Flow flow = new Flow(str, this.f48423f, i2);
        d.a.l0.r.d dVar = this.f48421d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.a.l0.r.e.h().c(str)) {
            flow.m(false);
            return flow;
        } else {
            d.a.l0.r.d dVar2 = this.f48421d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f48421d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.a.l0.r.d dVar3 = this.f48421d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void e(String str, int i2, JSONArray jSONArray) {
        this.f48419b.execute(new j(str, i2, jSONArray));
    }

    public final void g(Context context) {
        if (this.f48418a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f48418a = context;
        } else {
            this.f48418a = context.getApplicationContext();
        }
        int i2 = d.a.l0.d.b.g().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f48423f = i2;
        if (i2 > 1073741823) {
            this.f48423f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.f48423f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }
        ExecutorService h2 = h();
        this.f48419b = h2;
        h2.execute(new l());
        this.f48420c = Executors.newSingleThreadExecutor();
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
        d.a.l0.r.d dVar = this.f48421d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f48419b.execute(gVar);
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        if (i(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.a.l0.r.d dVar = this.f48421d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f48419b.execute(gVar);
    }

    public void l() {
        this.f48419b.execute(new d());
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        this.f48419b.execute(new g(str, str2, i2, str3, i3));
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f48419b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void o(q qVar) {
        this.f48419b.execute(new f(qVar));
    }

    public void p(String str, int i2, String str2) {
        this.f48419b.execute(new k(str, i2, str2));
    }

    public void q() {
        if (this.f48424g) {
            return;
        }
        this.f48424g = true;
        this.f48419b.execute(new a());
    }

    public void r(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f48420c.execute(new b(jSONArray, str));
    }

    public void s(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f48420c.execute(new c(jSONArray));
    }

    public void t(String str, boolean z) {
        this.f48419b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.l0.r.i f48437e;

        public g(String str, String str2, int i2) {
            this.f48437e = new d.a.l0.r.i(str, str2, i2);
        }

        public void a(boolean z) {
            d.a.l0.r.i iVar = this.f48437e;
            if (iVar != null) {
                iVar.j = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f48422e == null) {
                return;
            }
            this.f48437e.b();
            if (!TextUtils.isEmpty(n.this.f48421d.d(this.f48437e.f48398a))) {
                d.a.l0.r.i iVar = this.f48437e;
                iVar.f48406i = n.this.f48421d.d(iVar.f48398a);
            }
            d.a.l0.r.i iVar2 = this.f48437e;
            if ((iVar2.f48404g & 8) != 0) {
                n.this.f48422e.l(iVar2);
            } else {
                n.this.f48422e.k(iVar2);
            }
        }

        public g(String str, JSONObject jSONObject, int i2) {
            this.f48437e = new d.a.l0.r.i(str, jSONObject, i2);
        }

        public g(String str, String str2, int i2, String str3, int i3) {
            this.f48437e = new d.a.l0.r.i(str, str2, i2, str3, i3);
        }

        public g(String str, String str2, int i2, String str3, long j, int i3) {
            this.f48437e = new d.a.l0.r.i(str, str2, i2, str3, j, i3);
        }
    }
}
