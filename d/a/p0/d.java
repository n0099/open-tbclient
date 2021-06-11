package d.a.p0;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
@Autowired
/* loaded from: classes5.dex */
public class d {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f67620i = AppConfig.isDebug();
    public static volatile d j;

    /* renamed from: a  reason: collision with root package name */
    public Context f67621a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f67622b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f67623c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.g f67624d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.c f67625e;

    /* renamed from: f  reason: collision with root package name */
    public int f67626f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f67627g = false;

    /* renamed from: h  reason: collision with root package name */
    public w f67628h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                return;
            }
            d.this.f67625e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - h0.e().getLong("ubc_last_upload_all_time", 0L)) < 3600000) {
                return;
            }
            d.this.f67625e.L();
            long currentTimeMillis = System.currentTimeMillis();
            h0.e().putLong("ubc_last_upload_all_time", currentTimeMillis);
            h0.e().putLong("ubc_last_upload_non_real", currentTimeMillis);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f67625e.m();
        }
    }

    /* renamed from: d.a.p0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1832d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f67632e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67633f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f67634g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f67635h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u f67636i;

        public RunnableC1832d(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
            this.f67632e = jSONObject;
            this.f67633f = str;
            this.f67634g = z;
            this.f67635h = oVar;
            this.f67636i = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f67625e.H(this.f67632e, this.f67633f, this.f67634g, this.f67635h, this.f67636i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f67625e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f67625e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f67639e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67640f;

        public g(boolean z, String str) {
            this.f67639e = z;
            this.f67640f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f67639e) {
                d.this.f67625e.K(this.f67640f);
            } else {
                d.this.f67625e.J(this.f67640f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public x f67642e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67643f;

        /* renamed from: g  reason: collision with root package name */
        public t f67644g;

        public h(x xVar, boolean z, t tVar) {
            this.f67642e = xVar;
            this.f67643f = z;
            this.f67644g = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f67625e.F(this.f67642e, this.f67643f, this.f67644g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f67649e;

        /* renamed from: f  reason: collision with root package name */
        public int f67650f;

        public j(String str, int i2) {
            this.f67649e = str;
            this.f67650f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f67625e.h(this.f67649e, this.f67650f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f67654e;

        /* renamed from: f  reason: collision with root package name */
        public int f67655f;

        /* renamed from: g  reason: collision with root package name */
        public long f67656g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f67657h;

        public l(String str, int i2, JSONArray jSONArray) {
            this.f67654e = str;
            this.f67655f = i2;
            this.f67657h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f67625e.l(this.f67654e, this.f67655f, this.f67656g, this.f67657h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f67659e;

        /* renamed from: f  reason: collision with root package name */
        public int f67660f;

        /* renamed from: g  reason: collision with root package name */
        public String f67661g;

        public m(String str, int i2, String str2) {
            this.f67659e = str;
            this.f67660f = i2;
            this.f67661g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f67625e.G(this.f67659e, this.f67660f, this.f67661g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f67624d = d.a.p0.g.m();
            d.this.f67625e = new d.a.p0.c(d.this.f67621a);
            d.this.f67625e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f67626f;
        dVar.f67626f = i2 + 1;
        return i2;
    }

    @Inject
    public static final s o() {
        return d.a.n0.z2.t.a();
    }

    public static d q() {
        if (j == null) {
            synchronized (d.class) {
                if (j == null) {
                    j = new d();
                }
            }
        }
        return j;
    }

    public void A() {
        this.f67622b.execute(new f());
    }

    public void B(x xVar, boolean z, t tVar) {
        this.f67622b.execute(new h(xVar, z, tVar));
    }

    public void C(String str, int i2, String str2) {
        this.f67622b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f67627g) {
            return;
        }
        this.f67627g = true;
        this.f67622b.execute(new b());
    }

    public void E(JSONObject jSONObject) {
        F(jSONObject, null);
    }

    public void F(JSONObject jSONObject, String str) {
        G(jSONObject, str, false, null, null);
    }

    public void G(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
        if (f67620i) {
            Log.d("UBCBehaviorProcessor", "uploadData:" + str);
            Log.d("UBCDEBUG", jSONObject.toString());
        }
        boolean z2 = true;
        s o = o();
        if (o != null && !o.a()) {
            z2 = false;
        }
        if (z2) {
            this.f67623c.execute(new RunnableC1832d(jSONObject, str, z, oVar, uVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, o oVar, u uVar) {
        G(jSONObject, null, z, oVar, uVar);
    }

    public void I(String str, boolean z) {
        this.f67622b.execute(new g(z, str));
    }

    public void J() {
        this.f67622b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f67624d != null && this.f67624d.w(str)) {
                kVar.a(true);
            }
            this.f67622b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f67624d != null && this.f67624d.w(str)) {
                kVar.a(true);
            }
            this.f67622b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f67622b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f67626f, i2);
        d.a.p0.g gVar = this.f67624d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.a.p0.g gVar2 = this.f67624d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.p0.g gVar3 = this.f67624d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.p0.g gVar4 = this.f67624d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f67622b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f67622b.execute(new c());
    }

    public String r(String str) {
        d.a.p0.c cVar = this.f67625e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f67621a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f67621a = context;
        } else {
            this.f67621a = context.getApplicationContext();
        }
        this.f67626f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f67622b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f67623c = Executors.newSingleThreadExecutor();
        this.f67628h = (w) ServiceManager.getService(w.f67732a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f67622b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f67622b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f67622b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f67622b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f67622b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f67622b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f67622b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public o f67646e;

        /* renamed from: f  reason: collision with root package name */
        public String f67647f;

        public i(String str, String str2, int i2) {
            this.f67646e = new o(str, str2, i2);
            this.f67647f = str;
        }

        public final boolean a(String str, int i2) {
            if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                if (d.this.f67624d == null || d.this.f67624d.g(str, i2)) {
                    if (d.this.f67624d == null || !d.this.f67624d.v(str)) {
                        if (d.this.f67624d == null || !d.this.f67624d.h(str)) {
                            return d.this.f67624d == null || !d.this.f67624d.d(str);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public final void b() {
            JSONObject h2;
            o oVar = this.f67646e;
            if (oVar == null) {
                return;
            }
            String g2 = oVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f67646e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f67646e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f67628h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f67628h.a(g2, b2);
        }

        public void c(boolean z) {
            o oVar = this.f67646e;
            if (oVar != null) {
                oVar.n(z);
            }
        }

        public void d(String str) {
            o oVar = this.f67646e;
            if (oVar != null) {
                oVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f67628h != null && d.this.f67624d != null && d.this.f67624d.b(this.f67647f) == 1) {
                b();
            }
            if (this.f67646e.e() == -1) {
                if (!a(this.f67646e.g(), this.f67646e.i())) {
                    return;
                }
                if (d.this.f67624d != null && d.this.f67624d.w(this.f67646e.g())) {
                    c(true);
                }
            }
            this.f67646e.o();
            String g2 = this.f67646e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f67624d != null) {
                String i2 = d.this.f67624d.i(g2);
                if (!TextUtils.isEmpty(i2)) {
                    this.f67646e.m(i2);
                }
            }
            if (d.this.f67628h != null && d.this.f67624d != null && d.this.f67624d.b(this.f67647f) == 2) {
                b();
            }
            if (this.f67646e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f67625e.y(this.f67646e);
            } else if ((this.f67646e.i() & 8) != 0) {
                d.this.f67625e.x(this.f67646e);
            } else if (this.f67646e == null || d.this.f67624d == null || !d.this.f67624d.f(g2)) {
                d.this.f67625e.w(this.f67646e);
            } else {
                d.this.f67625e.Q(this.f67646e);
            }
        }

        public i(String str, JSONObject jSONObject, int i2) {
            this.f67646e = new o(str, jSONObject, i2);
            this.f67647f = str;
        }

        public i(String str, String str2, int i2, String str3, int i3) {
            this.f67646e = new o(str, str2, i2, str3, i3);
            this.f67647f = str;
        }

        public i(String str, String str2, int i2, String str3, long j, int i3) {
            this.f67646e = new o(str, str2, i2, str3, j, i3);
            this.f67647f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f67652e;

        public k(Flow flow, String str) {
            q qVar = new q(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f67652e = qVar;
            qVar.m(flow.getStartTime());
            this.f67652e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            q qVar = this.f67652e;
            if (qVar != null) {
                qVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f67625e == null) {
                if (d.f67620i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f67652e.r();
            if (!TextUtils.isEmpty(d.this.f67624d.i(this.f67652e.g()))) {
                this.f67652e.n(d.this.f67624d.i(this.f67652e.g()));
            }
            d.this.f67625e.D(this.f67652e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f67626f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            q qVar = new q(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f67652e = qVar;
            qVar.m(flow.getStartTime());
            this.f67652e.w("1");
            d.i(d.this);
        }
    }
}
