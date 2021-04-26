package d.a.h0.n;

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
/* loaded from: classes3.dex */
public class n {

    /* renamed from: h  reason: collision with root package name */
    public static volatile n f47514h;

    /* renamed from: a  reason: collision with root package name */
    public Context f47515a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f47516b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f47517c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.n.d f47518d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.h0.n.c f47519e;

    /* renamed from: f  reason: collision with root package name */
    public int f47520f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47521g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            n.this.f47519e.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47523e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47524f;

        public b(JSONArray jSONArray, String str) {
            this.f47523e = jSONArray;
            this.f47524f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            n.this.f47519e.u(this.f47523e, this.f47524f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47526e;

        public c(JSONArray jSONArray) {
            this.f47526e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            n.this.f47519e.w(this.f47526e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            n.this.f47519e.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f47529e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47530f;

        public e(boolean z, String str) {
            this.f47529e = z;
            this.f47530f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            if (this.f47529e) {
                n.this.f47519e.y(this.f47530f);
            } else {
                n.this.f47519e.x(this.f47530f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f47532e;

        public f(q qVar) {
            this.f47532e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            n.this.f47519e.r(this.f47532e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f47536e;

        /* renamed from: f  reason: collision with root package name */
        public int f47537f;

        public h(String str, int i2) {
            this.f47536e = str;
            this.f47537f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            n.this.f47519e.a(this.f47536e, this.f47537f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.h0.n.k f47539e;

        public i(Flow flow, String str) {
            d.a.h0.n.k kVar = new d.a.h0.n.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f47539e = kVar;
            kVar.m(flow.i());
            this.f47539e.w("1");
            n.f(n.this);
        }

        public void a(boolean z) {
            d.a.h0.n.k kVar = this.f47539e;
            if (kVar != null) {
                kVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            this.f47539e.r();
            if (!TextUtils.isEmpty(n.this.f47518d.d(this.f47539e.g()))) {
                this.f47539e.n(n.this.f47518d.d(this.f47539e.g()));
            }
            n.this.f47519e.p(this.f47539e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f47541e;

        /* renamed from: f  reason: collision with root package name */
        public int f47542f;

        /* renamed from: g  reason: collision with root package name */
        public long f47543g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f47544h;

        public j(String str, int i2, JSONArray jSONArray) {
            this.f47541e = str;
            this.f47542f = i2;
            this.f47544h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            n.this.f47519e.d(this.f47541e, this.f47542f, this.f47543g, this.f47544h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f47546e;

        /* renamed from: f  reason: collision with root package name */
        public int f47547f;

        /* renamed from: g  reason: collision with root package name */
        public String f47548g;

        public k(String str, int i2, String str2) {
            this.f47546e = str;
            this.f47547f = i2;
            this.f47548g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            n.this.f47519e.s(this.f47546e, this.f47547f, this.f47548g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f47518d = d.a.h0.n.d.g();
            n nVar = n.this;
            nVar.f47519e = new d.a.h0.n.c(nVar.f47515a);
            n.this.f47519e.o();
        }

        public /* synthetic */ l(n nVar, a aVar) {
            this();
        }
    }

    public n() {
        l(d.a.h0.n.e.e());
    }

    public static /* synthetic */ int f(n nVar) {
        int i2 = nVar.f47520f;
        nVar.f47520f = i2 + 1;
        return i2;
    }

    public static n k() {
        if (f47514h == null) {
            synchronized (n.class) {
                if (f47514h == null) {
                    f47514h = new n();
                }
            }
        }
        return f47514h;
    }

    public synchronized Flow g(String str, String str2, int i2) {
        Flow i3;
        i3 = i(str, i2);
        if (i3 != null && i3.j()) {
            i iVar = new i(i3, str2);
            if (this.f47518d != null && this.f47518d.m(str)) {
                iVar.a(true);
            }
            this.f47516b.execute(iVar);
        }
        return i3;
    }

    public void h(String str, int i2) {
        this.f47516b.execute(new h(str, i2));
    }

    public Flow i(String str, int i2) {
        Flow flow = new Flow(str, this.f47520f, i2);
        d.a.h0.n.d dVar = this.f47518d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.a.h0.n.e.g().a(str)) {
            flow.m(false);
            return flow;
        } else {
            d.a.h0.n.d dVar2 = this.f47518d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f47518d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.a.h0.n.d dVar3 = this.f47518d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void j(String str, int i2, JSONArray jSONArray) {
        this.f47516b.execute(new j(str, i2, jSONArray));
    }

    public final void l(Context context) {
        if (this.f47515a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f47515a = context;
        } else {
            this.f47515a = context.getApplicationContext();
        }
        int i2 = d.a.h0.c.b.f().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f47520f = i2;
        if (i2 > 1073741823) {
            this.f47520f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.f47520f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }
        if (d.a.h0.n.e.g() != null && d.a.h0.n.e.g().b() != null) {
            this.f47516b = d.a.h0.n.e.g().b();
        } else {
            this.f47516b = Executors.newSingleThreadExecutor();
        }
        this.f47516b.execute(new l(this, null));
        this.f47517c = Executors.newSingleThreadExecutor();
    }

    public boolean m(String str, int i2) {
        return TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20;
    }

    public void n(String str, String str2, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, str2, i2);
        d.a.h0.n.d dVar = this.f47518d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f47516b.execute(gVar);
    }

    public void o(String str, JSONObject jSONObject, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.a.h0.n.d dVar = this.f47518d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f47516b.execute(gVar);
    }

    public void p() {
        this.f47516b.execute(new d());
    }

    public void q(String str, String str2, int i2, String str3, int i3) {
        this.f47516b.execute(new g(str, str2, i2, str3, i3));
    }

    public void r(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f47516b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void s(q qVar) {
        this.f47516b.execute(new f(qVar));
    }

    public void t(String str, int i2, String str2) {
        this.f47516b.execute(new k(str, i2, str2));
    }

    public void u() {
        if (this.f47521g) {
            return;
        }
        this.f47521g = true;
        this.f47516b.execute(new a());
    }

    public void v(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f47517c.execute(new b(jSONArray, str));
    }

    public void w(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f47517c.execute(new c(jSONArray));
    }

    public void x(String str, boolean z) {
        this.f47516b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.h0.n.i f47534e;

        public g(String str, String str2, int i2) {
            this.f47534e = new d.a.h0.n.i(str, str2, i2);
        }

        public void a(boolean z) {
            d.a.h0.n.i iVar = this.f47534e;
            if (iVar != null) {
                iVar.n(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f47519e == null) {
                return;
            }
            this.f47534e.o();
            if (!TextUtils.isEmpty(n.this.f47518d.d(this.f47534e.h()))) {
                this.f47534e.m(n.this.f47518d.d(this.f47534e.h()));
            }
            if ((this.f47534e.j() & 8) != 0) {
                n.this.f47519e.l(this.f47534e);
            } else {
                n.this.f47519e.k(this.f47534e);
            }
        }

        public g(String str, JSONObject jSONObject, int i2) {
            this.f47534e = new d.a.h0.n.i(str, jSONObject, i2);
        }

        public g(String str, String str2, int i2, String str3, int i3) {
            this.f47534e = new d.a.h0.n.i(str, str2, i2, str3, i3);
        }

        public g(String str, String str2, int i2, String str3, long j, int i3) {
            this.f47534e = new d.a.h0.n.i(str, str2, i2, str3, j, i3);
        }
    }
}
