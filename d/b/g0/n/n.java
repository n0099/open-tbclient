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
    public static volatile n f49655h;

    /* renamed from: a  reason: collision with root package name */
    public Context f49656a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f49657b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f49658c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.n.d f49659d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.g0.n.c f49660e;

    /* renamed from: f  reason: collision with root package name */
    public int f49661f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49662g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            n.this.f49660e.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49664e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49665f;

        public b(JSONArray jSONArray, String str) {
            this.f49664e = jSONArray;
            this.f49665f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            n.this.f49660e.u(this.f49664e, this.f49665f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49667e;

        public c(JSONArray jSONArray) {
            this.f49667e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            n.this.f49660e.w(this.f49667e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            n.this.f49660e.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49670e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49671f;

        public e(boolean z, String str) {
            this.f49670e = z;
            this.f49671f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            if (this.f49670e) {
                n.this.f49660e.y(this.f49671f);
            } else {
                n.this.f49660e.x(this.f49671f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f49673e;

        public f(q qVar) {
            this.f49673e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            n.this.f49660e.r(this.f49673e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49677e;

        /* renamed from: f  reason: collision with root package name */
        public int f49678f;

        public h(String str, int i) {
            this.f49677e = str;
            this.f49678f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            n.this.f49660e.a(this.f49677e, this.f49678f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.g0.n.k f49680e;

        public i(Flow flow, String str) {
            d.b.g0.n.k kVar = new d.b.g0.n.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f49680e = kVar;
            kVar.m(flow.i());
            this.f49680e.w("1");
            n.f(n.this);
        }

        public void a(boolean z) {
            d.b.g0.n.k kVar = this.f49680e;
            if (kVar != null) {
                kVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            this.f49680e.r();
            if (!TextUtils.isEmpty(n.this.f49659d.d(this.f49680e.g()))) {
                this.f49680e.n(n.this.f49659d.d(this.f49680e.g()));
            }
            n.this.f49660e.p(this.f49680e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49682e;

        /* renamed from: f  reason: collision with root package name */
        public int f49683f;

        /* renamed from: g  reason: collision with root package name */
        public long f49684g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f49685h;

        public j(String str, int i, JSONArray jSONArray) {
            this.f49682e = str;
            this.f49683f = i;
            this.f49685h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            n.this.f49660e.d(this.f49682e, this.f49683f, this.f49684g, this.f49685h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f49686e;

        /* renamed from: f  reason: collision with root package name */
        public int f49687f;

        /* renamed from: g  reason: collision with root package name */
        public String f49688g;

        public k(String str, int i, String str2) {
            this.f49686e = str;
            this.f49687f = i;
            this.f49688g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            n.this.f49660e.s(this.f49686e, this.f49687f, this.f49688g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f49659d = d.b.g0.n.d.g();
            n nVar = n.this;
            nVar.f49660e = new d.b.g0.n.c(nVar.f49656a);
            n.this.f49660e.o();
        }

        public /* synthetic */ l(n nVar, a aVar) {
            this();
        }
    }

    public n() {
        l(d.b.g0.n.e.e());
    }

    public static /* synthetic */ int f(n nVar) {
        int i2 = nVar.f49661f;
        nVar.f49661f = i2 + 1;
        return i2;
    }

    public static n k() {
        if (f49655h == null) {
            synchronized (n.class) {
                if (f49655h == null) {
                    f49655h = new n();
                }
            }
        }
        return f49655h;
    }

    public synchronized Flow g(String str, String str2, int i2) {
        Flow i3;
        i3 = i(str, i2);
        if (i3 != null && i3.j()) {
            i iVar = new i(i3, str2);
            if (this.f49659d != null && this.f49659d.m(str)) {
                iVar.a(true);
            }
            this.f49657b.execute(iVar);
        }
        return i3;
    }

    public void h(String str, int i2) {
        this.f49657b.execute(new h(str, i2));
    }

    public Flow i(String str, int i2) {
        Flow flow = new Flow(str, this.f49661f, i2);
        d.b.g0.n.d dVar = this.f49659d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.b.g0.n.e.g().a(str)) {
            flow.m(false);
            return flow;
        } else {
            d.b.g0.n.d dVar2 = this.f49659d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f49659d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.b.g0.n.d dVar3 = this.f49659d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void j(String str, int i2, JSONArray jSONArray) {
        this.f49657b.execute(new j(str, i2, jSONArray));
    }

    public final void l(Context context) {
        if (this.f49656a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f49656a = context;
        } else {
            this.f49656a = context.getApplicationContext();
        }
        int i2 = d.b.g0.c.b.f().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f49661f = i2;
        if (i2 > 1073741823) {
            this.f49661f = i2 - 1073741823;
        } else {
            this.f49661f = i2 + 1073741823;
        }
        if (d.b.g0.n.e.g() != null && d.b.g0.n.e.g().c() != null) {
            this.f49657b = d.b.g0.n.e.g().c();
        } else {
            this.f49657b = Executors.newSingleThreadExecutor();
        }
        this.f49657b.execute(new l(this, null));
        this.f49658c = Executors.newSingleThreadExecutor();
    }

    public boolean m(String str, int i2) {
        return TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20;
    }

    public void n(String str, String str2, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, str2, i2);
        d.b.g0.n.d dVar = this.f49659d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f49657b.execute(gVar);
    }

    public void o(String str, JSONObject jSONObject, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.b.g0.n.d dVar = this.f49659d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f49657b.execute(gVar);
    }

    public void p() {
        this.f49657b.execute(new d());
    }

    public void q(String str, String str2, int i2, String str3, int i3) {
        this.f49657b.execute(new g(str, str2, i2, str3, i3));
    }

    public void r(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f49657b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void s(q qVar) {
        this.f49657b.execute(new f(qVar));
    }

    public void t(String str, int i2, String str2) {
        this.f49657b.execute(new k(str, i2, str2));
    }

    public void u() {
        if (this.f49662g) {
            return;
        }
        this.f49662g = true;
        this.f49657b.execute(new a());
    }

    public void v(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f49658c.execute(new b(jSONArray, str));
    }

    public void w(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f49658c.execute(new c(jSONArray));
    }

    public void x(String str, boolean z) {
        this.f49657b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.g0.n.i f49675e;

        public g(String str, String str2, int i) {
            this.f49675e = new d.b.g0.n.i(str, str2, i);
        }

        public void a(boolean z) {
            d.b.g0.n.i iVar = this.f49675e;
            if (iVar != null) {
                iVar.n(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49660e == null) {
                return;
            }
            this.f49675e.o();
            if (!TextUtils.isEmpty(n.this.f49659d.d(this.f49675e.h()))) {
                this.f49675e.m(n.this.f49659d.d(this.f49675e.h()));
            }
            if ((this.f49675e.j() & 8) != 0) {
                n.this.f49660e.l(this.f49675e);
            } else {
                n.this.f49660e.k(this.f49675e);
            }
        }

        public g(String str, JSONObject jSONObject, int i) {
            this.f49675e = new d.b.g0.n.i(str, jSONObject, i);
        }

        public g(String str, String str2, int i, String str3, int i2) {
            this.f49675e = new d.b.g0.n.i(str, str2, i, str3, i2);
        }

        public g(String str, String str2, int i, String str3, long j, int i2) {
            this.f49675e = new d.b.g0.n.i(str, str2, i, str3, j, i2);
        }
    }
}
