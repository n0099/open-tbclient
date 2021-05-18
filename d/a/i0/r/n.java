package d.a.i0.r;

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
    public static volatile n f48241h;

    /* renamed from: a  reason: collision with root package name */
    public Context f48242a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f48243b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f48244c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.r.d f48245d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.r.c f48246e;

    /* renamed from: f  reason: collision with root package name */
    public int f48247f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48248g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            cVar.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f48250e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48251f;

        public b(JSONArray jSONArray, String str) {
            this.f48250e = jSONArray;
            this.f48251f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            cVar.u(this.f48250e, this.f48251f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f48253e;

        public c(JSONArray jSONArray) {
            this.f48253e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            cVar.w(this.f48253e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            cVar.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48256e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48257f;

        public e(boolean z, String str) {
            this.f48256e = z;
            this.f48257f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            if (this.f48256e) {
                cVar.y(this.f48257f);
            } else {
                cVar.x(this.f48257f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f48259e;

        public f(q qVar) {
            this.f48259e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            cVar.r(this.f48259e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48263e;

        /* renamed from: f  reason: collision with root package name */
        public int f48264f;

        public h(String str, int i2) {
            this.f48263e = str;
            this.f48264f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            cVar.a(this.f48263e, this.f48264f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.i0.r.k f48266e;

        public i(Flow flow, String str) {
            d.a.i0.r.k kVar = new d.a.i0.r.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f48266e = kVar;
            kVar.f48236e = flow.i();
            this.f48266e.f48239h = "1";
            n.this.f48247f++;
        }

        public void a(boolean z) {
            d.a.i0.r.k kVar = this.f48266e;
            if (kVar != null) {
                kVar.l = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f48246e == null) {
                return;
            }
            this.f48266e.a();
            if (!TextUtils.isEmpty(n.this.f48245d.d(this.f48266e.f48232a))) {
                d.a.i0.r.k kVar = this.f48266e;
                kVar.j = n.this.f48245d.d(kVar.f48232a);
            }
            n.this.f48246e.p(this.f48266e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48268e;

        /* renamed from: f  reason: collision with root package name */
        public int f48269f;

        /* renamed from: g  reason: collision with root package name */
        public long f48270g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f48271h;

        public j(String str, int i2, JSONArray jSONArray) {
            this.f48268e = str;
            this.f48269f = i2;
            this.f48271h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            cVar.d(this.f48268e, this.f48269f, this.f48270g, this.f48271h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f48273e;

        /* renamed from: f  reason: collision with root package name */
        public int f48274f;

        /* renamed from: g  reason: collision with root package name */
        public String f48275g;

        public k(String str, int i2, String str2) {
            this.f48273e = str;
            this.f48274f = i2;
            this.f48275g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.r.c cVar = n.this.f48246e;
            if (cVar == null) {
                return;
            }
            cVar.s(this.f48273e, this.f48274f, this.f48275g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f48245d = d.a.i0.r.d.g();
            n nVar = n.this;
            nVar.f48246e = new d.a.i0.r.c(nVar.f48242a);
            n.this.f48246e.o();
        }
    }

    public n() {
        g(d.a.i0.r.e.f());
    }

    public static n f() {
        if (f48241h == null) {
            synchronized (n.class) {
                if (f48241h == null) {
                    f48241h = new n();
                }
            }
        }
        return f48241h;
    }

    public synchronized Flow a(String str, String str2, int i2) {
        Flow d2;
        d2 = d(str, i2);
        if (d2 != null && d2.j()) {
            i iVar = new i(d2, str2);
            if (this.f48245d != null && this.f48245d.m(str)) {
                iVar.a(true);
            }
            this.f48243b.execute(iVar);
        }
        return d2;
    }

    public void b(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f48243b.execute(new d.a.i0.p.a(i2));
        this.f48244c.execute(new d.a.i0.p.a(i2));
    }

    public void c(String str, int i2) {
        this.f48243b.execute(new h(str, i2));
    }

    public Flow d(String str, int i2) {
        Flow flow = new Flow(str, this.f48247f, i2);
        d.a.i0.r.d dVar = this.f48245d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.a.i0.r.e.h().c(str)) {
            flow.m(false);
            return flow;
        } else {
            d.a.i0.r.d dVar2 = this.f48245d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f48245d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.a.i0.r.d dVar3 = this.f48245d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void e(String str, int i2, JSONArray jSONArray) {
        this.f48243b.execute(new j(str, i2, jSONArray));
    }

    public final void g(Context context) {
        if (this.f48242a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f48242a = context;
        } else {
            this.f48242a = context.getApplicationContext();
        }
        int i2 = d.a.i0.d.b.g().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f48247f = i2;
        if (i2 > 1073741823) {
            this.f48247f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.f48247f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }
        ExecutorService h2 = h();
        this.f48243b = h2;
        h2.execute(new l());
        this.f48244c = Executors.newSingleThreadExecutor();
    }

    public final ExecutorService h() {
        if (d.a.i0.r.e.h() != null && !d.a.i0.r.e.h().j()) {
            if (d.a.i0.r.e.h().d() == null) {
                return Executors.newSingleThreadExecutor();
            }
            return d.a.i0.r.e.h().d();
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
        d.a.i0.r.d dVar = this.f48245d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f48243b.execute(gVar);
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        if (i(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.a.i0.r.d dVar = this.f48245d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f48243b.execute(gVar);
    }

    public void l() {
        this.f48243b.execute(new d());
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        this.f48243b.execute(new g(str, str2, i2, str3, i3));
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f48243b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void o(q qVar) {
        this.f48243b.execute(new f(qVar));
    }

    public void p(String str, int i2, String str2) {
        this.f48243b.execute(new k(str, i2, str2));
    }

    public void q() {
        if (this.f48248g) {
            return;
        }
        this.f48248g = true;
        this.f48243b.execute(new a());
    }

    public void r(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f48244c.execute(new b(jSONArray, str));
    }

    public void s(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f48244c.execute(new c(jSONArray));
    }

    public void t(String str, boolean z) {
        this.f48243b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.i0.r.i f48261e;

        public g(String str, String str2, int i2) {
            this.f48261e = new d.a.i0.r.i(str, str2, i2);
        }

        public void a(boolean z) {
            d.a.i0.r.i iVar = this.f48261e;
            if (iVar != null) {
                iVar.j = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f48246e == null) {
                return;
            }
            this.f48261e.b();
            if (!TextUtils.isEmpty(n.this.f48245d.d(this.f48261e.f48222a))) {
                d.a.i0.r.i iVar = this.f48261e;
                iVar.f48230i = n.this.f48245d.d(iVar.f48222a);
            }
            d.a.i0.r.i iVar2 = this.f48261e;
            if ((iVar2.f48228g & 8) != 0) {
                n.this.f48246e.l(iVar2);
            } else {
                n.this.f48246e.k(iVar2);
            }
        }

        public g(String str, JSONObject jSONObject, int i2) {
            this.f48261e = new d.a.i0.r.i(str, jSONObject, i2);
        }

        public g(String str, String str2, int i2, String str3, int i3) {
            this.f48261e = new d.a.i0.r.i(str, str2, i2, str3, i3);
        }

        public g(String str, String str2, int i2, String str3, long j, int i3) {
            this.f48261e = new d.a.i0.r.i(str, str2, i2, str3, j, i3);
        }
    }
}
