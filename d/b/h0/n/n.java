package d.b.h0.n;

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
    public static volatile n f49984h;

    /* renamed from: a  reason: collision with root package name */
    public Context f49985a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f49986b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f49987c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.n.d f49988d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.n.c f49989e;

    /* renamed from: f  reason: collision with root package name */
    public int f49990f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49991g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            n.this.f49989e.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49993e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49994f;

        public b(JSONArray jSONArray, String str) {
            this.f49993e = jSONArray;
            this.f49994f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            n.this.f49989e.u(this.f49993e, this.f49994f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f49996e;

        public c(JSONArray jSONArray) {
            this.f49996e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            n.this.f49989e.w(this.f49996e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            n.this.f49989e.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49999e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50000f;

        public e(boolean z, String str) {
            this.f49999e = z;
            this.f50000f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            if (this.f49999e) {
                n.this.f49989e.y(this.f50000f);
            } else {
                n.this.f49989e.x(this.f50000f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f50002e;

        public f(q qVar) {
            this.f50002e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            n.this.f49989e.r(this.f50002e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f50006e;

        /* renamed from: f  reason: collision with root package name */
        public int f50007f;

        public h(String str, int i) {
            this.f50006e = str;
            this.f50007f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            n.this.f49989e.a(this.f50006e, this.f50007f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.h0.n.k f50009e;

        public i(Flow flow, String str) {
            d.b.h0.n.k kVar = new d.b.h0.n.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f50009e = kVar;
            kVar.m(flow.i());
            this.f50009e.w("1");
            n.f(n.this);
        }

        public void a(boolean z) {
            d.b.h0.n.k kVar = this.f50009e;
            if (kVar != null) {
                kVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            this.f50009e.r();
            if (!TextUtils.isEmpty(n.this.f49988d.d(this.f50009e.g()))) {
                this.f50009e.n(n.this.f49988d.d(this.f50009e.g()));
            }
            n.this.f49989e.p(this.f50009e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f50011e;

        /* renamed from: f  reason: collision with root package name */
        public int f50012f;

        /* renamed from: g  reason: collision with root package name */
        public long f50013g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f50014h;

        public j(String str, int i, JSONArray jSONArray) {
            this.f50011e = str;
            this.f50012f = i;
            this.f50014h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            n.this.f49989e.d(this.f50011e, this.f50012f, this.f50013g, this.f50014h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f50015e;

        /* renamed from: f  reason: collision with root package name */
        public int f50016f;

        /* renamed from: g  reason: collision with root package name */
        public String f50017g;

        public k(String str, int i, String str2) {
            this.f50015e = str;
            this.f50016f = i;
            this.f50017g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            n.this.f49989e.s(this.f50015e, this.f50016f, this.f50017g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f49988d = d.b.h0.n.d.g();
            n nVar = n.this;
            nVar.f49989e = new d.b.h0.n.c(nVar.f49985a);
            n.this.f49989e.o();
        }

        public /* synthetic */ l(n nVar, a aVar) {
            this();
        }
    }

    public n() {
        l(d.b.h0.n.e.e());
    }

    public static /* synthetic */ int f(n nVar) {
        int i2 = nVar.f49990f;
        nVar.f49990f = i2 + 1;
        return i2;
    }

    public static n k() {
        if (f49984h == null) {
            synchronized (n.class) {
                if (f49984h == null) {
                    f49984h = new n();
                }
            }
        }
        return f49984h;
    }

    public synchronized Flow g(String str, String str2, int i2) {
        Flow i3;
        i3 = i(str, i2);
        if (i3 != null && i3.j()) {
            i iVar = new i(i3, str2);
            if (this.f49988d != null && this.f49988d.m(str)) {
                iVar.a(true);
            }
            this.f49986b.execute(iVar);
        }
        return i3;
    }

    public void h(String str, int i2) {
        this.f49986b.execute(new h(str, i2));
    }

    public Flow i(String str, int i2) {
        Flow flow = new Flow(str, this.f49990f, i2);
        d.b.h0.n.d dVar = this.f49988d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.b.h0.n.e.g().a(str)) {
            flow.m(false);
            return flow;
        } else {
            d.b.h0.n.d dVar2 = this.f49988d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f49988d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.b.h0.n.d dVar3 = this.f49988d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void j(String str, int i2, JSONArray jSONArray) {
        this.f49986b.execute(new j(str, i2, jSONArray));
    }

    public final void l(Context context) {
        if (this.f49985a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f49985a = context;
        } else {
            this.f49985a = context.getApplicationContext();
        }
        int i2 = d.b.h0.c.b.f().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f49990f = i2;
        if (i2 > 1073741823) {
            this.f49990f = i2 - 1073741823;
        } else {
            this.f49990f = i2 + 1073741823;
        }
        if (d.b.h0.n.e.g() != null && d.b.h0.n.e.g().c() != null) {
            this.f49986b = d.b.h0.n.e.g().c();
        } else {
            this.f49986b = Executors.newSingleThreadExecutor();
        }
        this.f49986b.execute(new l(this, null));
        this.f49987c = Executors.newSingleThreadExecutor();
    }

    public boolean m(String str, int i2) {
        return TextUtils.equals(str, "834") && new Random().nextInt(100) >= 20;
    }

    public void n(String str, String str2, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, str2, i2);
        d.b.h0.n.d dVar = this.f49988d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f49986b.execute(gVar);
    }

    public void o(String str, JSONObject jSONObject, int i2) {
        if (m(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.b.h0.n.d dVar = this.f49988d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f49986b.execute(gVar);
    }

    public void p() {
        this.f49986b.execute(new d());
    }

    public void q(String str, String str2, int i2, String str3, int i3) {
        this.f49986b.execute(new g(str, str2, i2, str3, i3));
    }

    public void r(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f49986b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void s(q qVar) {
        this.f49986b.execute(new f(qVar));
    }

    public void t(String str, int i2, String str2) {
        this.f49986b.execute(new k(str, i2, str2));
    }

    public void u() {
        if (this.f49991g) {
            return;
        }
        this.f49991g = true;
        this.f49986b.execute(new a());
    }

    public void v(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f49987c.execute(new b(jSONArray, str));
    }

    public void w(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f49987c.execute(new c(jSONArray));
    }

    public void x(String str, boolean z) {
        this.f49986b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.h0.n.i f50004e;

        public g(String str, String str2, int i) {
            this.f50004e = new d.b.h0.n.i(str, str2, i);
        }

        public void a(boolean z) {
            d.b.h0.n.i iVar = this.f50004e;
            if (iVar != null) {
                iVar.n(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f49989e == null) {
                return;
            }
            this.f50004e.o();
            if (!TextUtils.isEmpty(n.this.f49988d.d(this.f50004e.h()))) {
                this.f50004e.m(n.this.f49988d.d(this.f50004e.h()));
            }
            if ((this.f50004e.j() & 8) != 0) {
                n.this.f49989e.l(this.f50004e);
            } else {
                n.this.f49989e.k(this.f50004e);
            }
        }

        public g(String str, JSONObject jSONObject, int i) {
            this.f50004e = new d.b.h0.n.i(str, jSONObject, i);
        }

        public g(String str, String str2, int i, String str3, int i2) {
            this.f50004e = new d.b.h0.n.i(str, str2, i, str3, i2);
        }

        public g(String str, String str2, int i, String str3, long j, int i2) {
            this.f50004e = new d.b.h0.n.i(str, str2, i, str3, j, i2);
        }
    }
}
