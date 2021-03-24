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
    public static volatile n f49262h;

    /* renamed from: a  reason: collision with root package name */
    public Context f49263a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f49264b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f49265c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.n.d f49266d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.n.c f49267e;

    /* renamed from: f  reason: collision with root package name */
    public int f49268f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49269g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            n.this.f49267e.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49272f;

        public b(JSONArray jSONArray, String str) {
            this.f49271e = jSONArray;
            this.f49272f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            n.this.f49267e.u(this.f49271e, this.f49272f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49274e;

        public c(JSONArray jSONArray) {
            this.f49274e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            n.this.f49267e.w(this.f49274e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            n.this.f49267e.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49277e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49278f;

        public e(boolean z, String str) {
            this.f49277e = z;
            this.f49278f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            if (this.f49277e) {
                n.this.f49267e.y(this.f49278f);
            } else {
                n.this.f49267e.x(this.f49278f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f49280e;

        public f(q qVar) {
            this.f49280e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            n.this.f49267e.r(this.f49280e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49284e;

        /* renamed from: f  reason: collision with root package name */
        public int f49285f;

        public h(String str, int i) {
            this.f49284e = str;
            this.f49285f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            n.this.f49267e.a(this.f49284e, this.f49285f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.g0.n.k f49287e;

        public i(Flow flow, String str) {
            d.b.g0.n.k kVar = new d.b.g0.n.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f49287e = kVar;
            kVar.m(flow.i());
            this.f49287e.w("1");
            n.f(n.this);
        }

        public void a(boolean z) {
            d.b.g0.n.k kVar = this.f49287e;
            if (kVar != null) {
                kVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            this.f49287e.r();
            if (!TextUtils.isEmpty(n.this.f49266d.d(this.f49287e.g()))) {
                this.f49287e.n(n.this.f49266d.d(this.f49287e.g()));
            }
            n.this.f49267e.p(this.f49287e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49289e;

        /* renamed from: f  reason: collision with root package name */
        public int f49290f;

        /* renamed from: g  reason: collision with root package name */
        public long f49291g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f49292h;

        public j(String str, int i, JSONArray jSONArray) {
            this.f49289e = str;
            this.f49290f = i;
            this.f49292h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            n.this.f49267e.d(this.f49289e, this.f49290f, this.f49291g, this.f49292h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49293e;

        /* renamed from: f  reason: collision with root package name */
        public int f49294f;

        /* renamed from: g  reason: collision with root package name */
        public String f49295g;

        public k(String str, int i, String str2) {
            this.f49293e = str;
            this.f49294f = i;
            this.f49295g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            n.this.f49267e.s(this.f49293e, this.f49294f, this.f49295g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f49266d = d.b.g0.n.d.g();
            n nVar = n.this;
            nVar.f49267e = new d.b.g0.n.c(nVar.f49263a);
            n.this.f49267e.o();
        }

        public /* synthetic */ l(n nVar, a aVar) {
            this();
        }
    }

    public n() {
        l(d.b.g0.n.e.e());
    }

    public static /* synthetic */ int f(n nVar) {
        int i2 = nVar.f49268f;
        nVar.f49268f = i2 + 1;
        return i2;
    }

    public static n k() {
        if (f49262h == null) {
            synchronized (n.class) {
                if (f49262h == null) {
                    f49262h = new n();
                }
            }
        }
        return f49262h;
    }

    public synchronized Flow g(String str, String str2, int i2) {
        Flow i3;
        i3 = i(str, i2);
        if (i3 != null && i3.j()) {
            i iVar = new i(i3, str2);
            if (this.f49266d != null && this.f49266d.m(str)) {
                iVar.a(true);
            }
            this.f49264b.execute(iVar);
        }
        return i3;
    }

    public void h(String str, int i2) {
        this.f49264b.execute(new h(str, i2));
    }

    public Flow i(String str, int i2) {
        Flow flow = new Flow(str, this.f49268f, i2);
        d.b.g0.n.d dVar = this.f49266d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.b.g0.n.e.g().a(str)) {
            flow.m(false);
            return flow;
        } else {
            d.b.g0.n.d dVar2 = this.f49266d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f49266d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.b.g0.n.d dVar3 = this.f49266d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void j(String str, int i2, JSONArray jSONArray) {
        this.f49264b.execute(new j(str, i2, jSONArray));
    }

    public final void l(Context context) {
        if (this.f49263a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f49263a = context;
        } else {
            this.f49263a = context.getApplicationContext();
        }
        int i2 = d.b.g0.c.b.f().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f49268f = i2;
        if (i2 > 1073741823) {
            this.f49268f = i2 - 1073741823;
        } else {
            this.f49268f = i2 + 1073741823;
        }
        if (d.b.g0.n.e.g() != null && d.b.g0.n.e.g().c() != null) {
            this.f49264b = d.b.g0.n.e.g().c();
        } else {
            this.f49264b = Executors.newSingleThreadExecutor();
        }
        this.f49264b.execute(new l(this, null));
        this.f49265c = Executors.newSingleThreadExecutor();
    }

    public boolean m(String str, int i2) {
        return TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20;
    }

    public void n(String str, String str2, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, str2, i2);
        d.b.g0.n.d dVar = this.f49266d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f49264b.execute(gVar);
    }

    public void o(String str, JSONObject jSONObject, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.b.g0.n.d dVar = this.f49266d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f49264b.execute(gVar);
    }

    public void p() {
        this.f49264b.execute(new d());
    }

    public void q(String str, String str2, int i2, String str3, int i3) {
        this.f49264b.execute(new g(str, str2, i2, str3, i3));
    }

    public void r(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f49264b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void s(q qVar) {
        this.f49264b.execute(new f(qVar));
    }

    public void t(String str, int i2, String str2) {
        this.f49264b.execute(new k(str, i2, str2));
    }

    public void u() {
        if (this.f49269g) {
            return;
        }
        this.f49269g = true;
        this.f49264b.execute(new a());
    }

    public void v(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f49265c.execute(new b(jSONArray, str));
    }

    public void w(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f49265c.execute(new c(jSONArray));
    }

    public void x(String str, boolean z) {
        this.f49264b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.g0.n.i f49282e;

        public g(String str, String str2, int i) {
            this.f49282e = new d.b.g0.n.i(str, str2, i);
        }

        public void a(boolean z) {
            d.b.g0.n.i iVar = this.f49282e;
            if (iVar != null) {
                iVar.n(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49267e == null) {
                return;
            }
            this.f49282e.o();
            if (!TextUtils.isEmpty(n.this.f49266d.d(this.f49282e.h()))) {
                this.f49282e.m(n.this.f49266d.d(this.f49282e.h()));
            }
            if ((this.f49282e.j() & 8) != 0) {
                n.this.f49267e.l(this.f49282e);
            } else {
                n.this.f49267e.k(this.f49282e);
            }
        }

        public g(String str, JSONObject jSONObject, int i) {
            this.f49282e = new d.b.g0.n.i(str, jSONObject, i);
        }

        public g(String str, String str2, int i, String str3, int i2) {
            this.f49282e = new d.b.g0.n.i(str, str2, i, str3, i2);
        }

        public g(String str, String str2, int i, String str3, long j, int i2) {
            this.f49282e = new d.b.g0.n.i(str, str2, i, str3, j, i2);
        }
    }
}
