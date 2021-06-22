package d.a.m0.r;

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
    public static volatile n f52199h;

    /* renamed from: a  reason: collision with root package name */
    public Context f52200a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f52201b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f52202c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.r.d f52203d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.r.c f52204e;

    /* renamed from: f  reason: collision with root package name */
    public int f52205f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52206g = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            cVar.t();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f52208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52209f;

        public b(JSONArray jSONArray, String str) {
            this.f52208e = jSONArray;
            this.f52209f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            cVar.u(this.f52208e, this.f52209f);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONArray f52211e;

        public c(JSONArray jSONArray) {
            this.f52211e = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            cVar.w(this.f52211e);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            cVar.h();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f52214e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f52215f;

        public e(boolean z, String str) {
            this.f52214e = z;
            this.f52215f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            if (this.f52214e) {
                cVar.y(this.f52215f);
            } else {
                cVar.x(this.f52215f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f52217e;

        public f(q qVar) {
            this.f52217e = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            cVar.r(this.f52217e);
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f52221e;

        /* renamed from: f  reason: collision with root package name */
        public int f52222f;

        public h(String str, int i2) {
            this.f52221e = str;
            this.f52222f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            cVar.a(this.f52221e, this.f52222f);
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.m0.r.k f52224e;

        public i(Flow flow, String str) {
            d.a.m0.r.k kVar = new d.a.m0.r.k(flow.g(), flow.f(), str, flow.h(), flow.k());
            this.f52224e = kVar;
            kVar.f52194e = flow.i();
            this.f52224e.f52197h = "1";
            n.this.f52205f++;
        }

        public void a(boolean z) {
            d.a.m0.r.k kVar = this.f52224e;
            if (kVar != null) {
                kVar.l = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f52204e == null) {
                return;
            }
            this.f52224e.a();
            if (!TextUtils.isEmpty(n.this.f52203d.d(this.f52224e.f52190a))) {
                d.a.m0.r.k kVar = this.f52224e;
                kVar.j = n.this.f52203d.d(kVar.f52190a);
            }
            n.this.f52204e.p(this.f52224e);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f52226e;

        /* renamed from: f  reason: collision with root package name */
        public int f52227f;

        /* renamed from: g  reason: collision with root package name */
        public long f52228g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f52229h;

        public j(String str, int i2, JSONArray jSONArray) {
            this.f52226e = str;
            this.f52227f = i2;
            this.f52229h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            cVar.d(this.f52226e, this.f52227f, this.f52228g, this.f52229h);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f52231e;

        /* renamed from: f  reason: collision with root package name */
        public int f52232f;

        /* renamed from: g  reason: collision with root package name */
        public String f52233g;

        public k(String str, int i2, String str2) {
            this.f52231e = str;
            this.f52232f = i2;
            this.f52233g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.m0.r.c cVar = n.this.f52204e;
            if (cVar == null) {
                return;
            }
            cVar.s(this.f52231e, this.f52232f, this.f52233g);
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            n.this.f52203d = d.a.m0.r.d.g();
            n nVar = n.this;
            nVar.f52204e = new d.a.m0.r.c(nVar.f52200a);
            n.this.f52204e.o();
        }
    }

    public n() {
        g(d.a.m0.r.e.f());
    }

    public static n f() {
        if (f52199h == null) {
            synchronized (n.class) {
                if (f52199h == null) {
                    f52199h = new n();
                }
            }
        }
        return f52199h;
    }

    public synchronized Flow a(String str, String str2, int i2) {
        Flow d2;
        d2 = d(str, i2);
        if (d2 != null && d2.j()) {
            i iVar = new i(d2, str2);
            if (this.f52203d != null && this.f52203d.m(str)) {
                iVar.a(true);
            }
            this.f52201b.execute(iVar);
        }
        return d2;
    }

    public void b(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.f52201b.execute(new d.a.m0.p.a(i2));
        this.f52202c.execute(new d.a.m0.p.a(i2));
    }

    public void c(String str, int i2) {
        this.f52201b.execute(new h(str, i2));
    }

    public Flow d(String str, int i2) {
        Flow flow = new Flow(str, this.f52205f, i2);
        d.a.m0.r.d dVar = this.f52203d;
        if (dVar != null && !dVar.c(str, i2)) {
            flow.m(false);
            return flow;
        } else if ((i2 & 16) != 0 && !d.a.m0.r.e.h().c(str)) {
            flow.m(false);
            return flow;
        } else {
            d.a.m0.r.d dVar2 = this.f52203d;
            if (dVar2 != null && dVar2.i(str) > 0) {
                if (new Random().nextInt(100) >= this.f52203d.i(str)) {
                    flow.l(true);
                    return flow;
                }
            }
            d.a.m0.r.d dVar3 = this.f52203d;
            if (dVar3 != null && dVar3.l(str)) {
                flow.m(false);
            }
            return flow;
        }
    }

    public void e(String str, int i2, JSONArray jSONArray) {
        this.f52201b.execute(new j(str, i2, jSONArray));
    }

    public final void g(Context context) {
        if (this.f52200a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f52200a = context;
        } else {
            this.f52200a = context.getApplicationContext();
        }
        int i2 = d.a.m0.d.b.g().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        this.f52205f = i2;
        if (i2 > 1073741823) {
            this.f52205f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.f52205f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        }
        ExecutorService h2 = h();
        this.f52201b = h2;
        h2.execute(new l());
        this.f52202c = Executors.newSingleThreadExecutor();
    }

    public final ExecutorService h() {
        if (d.a.m0.r.e.h() != null && !d.a.m0.r.e.h().j()) {
            if (d.a.m0.r.e.h().d() == null) {
                return Executors.newSingleThreadExecutor();
            }
            return d.a.m0.r.e.h().d();
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
        d.a.m0.r.d dVar = this.f52203d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f52201b.execute(gVar);
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        if (i(str, i2)) {
            return;
        }
        g gVar = new g(str, jSONObject, i2);
        d.a.m0.r.d dVar = this.f52203d;
        if (dVar != null && dVar.m(str)) {
            gVar.a(true);
        }
        this.f52201b.execute(gVar);
    }

    public void l() {
        this.f52201b.execute(new d());
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        this.f52201b.execute(new g(str, str2, i2, str3, i3));
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f52201b.execute(new g(str, str2, i2, str3, j2, i3));
    }

    public void o(q qVar) {
        this.f52201b.execute(new f(qVar));
    }

    public void p(String str, int i2, String str2) {
        this.f52201b.execute(new k(str, i2, str2));
    }

    public void q() {
        if (this.f52206g) {
            return;
        }
        this.f52206g = true;
        this.f52201b.execute(new a());
    }

    public void r(JSONArray jSONArray, String str) {
        r.d(jSONArray);
        this.f52202c.execute(new b(jSONArray, str));
    }

    public void s(JSONArray jSONArray) {
        r.d(jSONArray);
        this.f52202c.execute(new c(jSONArray));
    }

    public void t(String str, boolean z) {
        this.f52201b.execute(new e(z, str));
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.a.m0.r.i f52219e;

        public g(String str, String str2, int i2) {
            this.f52219e = new d.a.m0.r.i(str, str2, i2);
        }

        public void a(boolean z) {
            d.a.m0.r.i iVar = this.f52219e;
            if (iVar != null) {
                iVar.j = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f52204e == null) {
                return;
            }
            this.f52219e.b();
            if (!TextUtils.isEmpty(n.this.f52203d.d(this.f52219e.f52180a))) {
                d.a.m0.r.i iVar = this.f52219e;
                iVar.f52188i = n.this.f52203d.d(iVar.f52180a);
            }
            d.a.m0.r.i iVar2 = this.f52219e;
            if ((iVar2.f52186g & 8) != 0) {
                n.this.f52204e.l(iVar2);
            } else {
                n.this.f52204e.k(iVar2);
            }
        }

        public g(String str, JSONObject jSONObject, int i2) {
            this.f52219e = new d.a.m0.r.i(str, jSONObject, i2);
        }

        public g(String str, String str2, int i2, String str3, int i3) {
            this.f52219e = new d.a.m0.r.i(str, str2, i2, str3, i3);
        }

        public g(String str, String str2, int i2, String str3, long j, int i3) {
            this.f52219e = new d.a.m0.r.i(str, str2, i2, str3, j, i3);
        }
    }
}
