package d.b.g0.n;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.ubc.Flow;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: h  reason: collision with root package name */
    public static volatile n f49263h;

    /* renamed from: a  reason: collision with root package name */
    public Context f49264a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f49265b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f49266c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.n.d f49267d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.n.c f49268e;

    /* renamed from: f  reason: collision with root package name */
    public int f49269f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49270g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            n.this.f49268e.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49272e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49273f;

        public b(JSONArray jSONArray, String str) {
            this.f49272e = jSONArray;
            this.f49273f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            n.this.f49268e.u(this.f49272e, this.f49273f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49275e;

        public c(JSONArray jSONArray) {
            this.f49275e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            n.this.f49268e.w(this.f49275e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            n.this.f49268e.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49278e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49279f;

        public e(boolean z, String str) {
            this.f49278e = z;
            this.f49279f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            if (this.f49278e) {
                n.this.f49268e.y(this.f49279f);
            } else {
                n.this.f49268e.x(this.f49279f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f49281e;

        public f(q qVar) {
            this.f49281e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            n.this.f49268e.r(this.f49281e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49285e;

        /* renamed from: f  reason: collision with root package name */
        public int f49286f;

        public h(String str, int i) {
            this.f49285e = str;
            this.f49286f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            n.this.f49268e.a(this.f49285e, this.f49286f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.g0.n.k f49288e;

        public i(Flow flow, String str) {
            d.b.g0.n.k kVar = new d.b.g0.n.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f49288e = kVar;
            kVar.m(flow.i());
            this.f49288e.w("1");
            n.f(n.this);
        }

        public void a(boolean z) {
            d.b.g0.n.k kVar = this.f49288e;
            if (kVar != null) {
                kVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            this.f49288e.r();
            if (!TextUtils.isEmpty(n.this.f49267d.d(this.f49288e.g()))) {
                this.f49288e.n(n.this.f49267d.d(this.f49288e.g()));
            }
            n.this.f49268e.p(this.f49288e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49290e;

        /* renamed from: f  reason: collision with root package name */
        public int f49291f;

        /* renamed from: g  reason: collision with root package name */
        public long f49292g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f49293h;

        public j(String str, int i, JSONArray jSONArray) {
            this.f49290e = str;
            this.f49291f = i;
            this.f49293h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            n.this.f49268e.d(this.f49290e, this.f49291f, this.f49292g, this.f49293h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49294e;

        /* renamed from: f  reason: collision with root package name */
        public int f49295f;

        /* renamed from: g  reason: collision with root package name */
        public String f49296g;

        public k(String str, int i, String str2) {
            this.f49294e = str;
            this.f49295f = i;
            this.f49296g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            n.this.f49268e.s(this.f49294e, this.f49295f, this.f49296g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f49267d = d.b.g0.n.d.g();
            n nVar = n.this;
            nVar.f49268e = new d.b.g0.n.c(nVar.f49264a);
            n.this.f49268e.o();
        }

        public /* synthetic */ l(n nVar, a aVar) {
            this();
        }
    }

    public n() {
        l(d.b.g0.n.e.e());
    }

    public static /* synthetic */ int f(n nVar) {
        int i2 = nVar.f49269f;
        nVar.f49269f = i2 + 1;
        return i2;
    }

    public static n k() {
        if (f49263h == null) {
            synchronized (n.class) {
                if (f49263h == null) {
                    f49263h = new n();
                }
            }
        }
        return f49263h;
    }

    public synchronized Flow g(String str, String str2, int i2) {
        Flow i3;
        i3 = i(str, i2);
        if (i3 != null && i3.j()) {
            i iVar = new i(i3, str2);
            if (this.f49267d != null && this.f49267d.m(str)) {
                iVar.a(true);
            }
            this.f49265b.execute(iVar);
        }
        return i3;
    }

    public void h(String str, int i2) {
        this.f49265b.execute(new h(str, i2));
    }

    public Flow i(String str, int i2) {
        Flow flow = new Flow(str, this.f49269f, i2);
        d.b.g0.n.d dVar = this.f49267d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.b.g0.n.e.g().a(str)) {
            flow.m(false);
            return flow;
        } else {
            d.b.g0.n.d dVar2 = this.f49267d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f49267d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.b.g0.n.d dVar3 = this.f49267d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void j(String str, int i2, JSONArray jSONArray) {
        this.f49265b.execute(new j(str, i2, jSONArray));
    }

    public final void l(Context context) {
        if (this.f49264a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f49264a = context;
        } else {
            this.f49264a = context.getApplicationContext();
        }
        int i2 = d.b.g0.c.b.f().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f49269f = i2;
        if (i2 > 1073741823) {
            this.f49269f = i2 - 1073741823;
        } else {
            this.f49269f = i2 + 1073741823;
        }
        if (d.b.g0.n.e.g() != null && d.b.g0.n.e.g().c() != null) {
            this.f49265b = d.b.g0.n.e.g().c();
        } else {
            this.f49265b = Executors.newSingleThreadExecutor();
        }
        this.f49265b.execute(new l(this, null));
        this.f49266c = Executors.newSingleThreadExecutor();
    }

    public boolean m(String str, int i2) {
        return TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20;
    }

    public void n(String str, String str2, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, str2, i2);
        d.b.g0.n.d dVar = this.f49267d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f49265b.execute(gVar);
    }

    public void o(String str, JSONObject jSONObject, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.b.g0.n.d dVar = this.f49267d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f49265b.execute(gVar);
    }

    public void p() {
        this.f49265b.execute(new d());
    }

    public void q(String str, String str2, int i2, String str3, int i3) {
        this.f49265b.execute(new g(str, str2, i2, str3, i3));
    }

    public void r(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f49265b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void s(q qVar) {
        this.f49265b.execute(new f(qVar));
    }

    public void t(String str, int i2, String str2) {
        this.f49265b.execute(new k(str, i2, str2));
    }

    public void u() {
        if (this.f49270g) {
            return;
        }
        this.f49270g = true;
        this.f49265b.execute(new a());
    }

    public void v(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f49266c.execute(new b(jSONArray, str));
    }

    public void w(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f49266c.execute(new c(jSONArray));
    }

    public void x(String str, boolean z) {
        this.f49265b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.g0.n.i f49283e;

        public g(String str, String str2, int i) {
            this.f49283e = new d.b.g0.n.i(str, str2, i);
        }

        public void a(boolean z) {
            d.b.g0.n.i iVar = this.f49283e;
            if (iVar != null) {
                iVar.n(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49268e == null) {
                return;
            }
            this.f49283e.o();
            if (!TextUtils.isEmpty(n.this.f49267d.d(this.f49283e.h()))) {
                this.f49283e.m(n.this.f49267d.d(this.f49283e.h()));
            }
            if ((this.f49283e.j() & 8) != 0) {
                n.this.f49268e.l(this.f49283e);
            } else {
                n.this.f49268e.k(this.f49283e);
            }
        }

        public g(String str, JSONObject jSONObject, int i) {
            this.f49283e = new d.b.g0.n.i(str, jSONObject, i);
        }

        public g(String str, String str2, int i, String str3, int i2) {
            this.f49283e = new d.b.g0.n.i(str, str2, i, str3, i2);
        }

        public g(String str, String str2, int i, String str3, long j, int i2) {
            this.f49283e = new d.b.g0.n.i(str, str2, i, str3, j, i2);
        }
    }
}
