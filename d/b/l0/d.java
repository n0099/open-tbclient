package d.b.l0;

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
import com.baidu.webkit.sdk.VideoCloudSetting;
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
    public static final boolean i = AppConfig.isDebug();
    public static volatile d j;

    /* renamed from: a  reason: collision with root package name */
    public Context f64866a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f64867b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f64868c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.l0.g f64869d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.l0.c f64870e;

    /* renamed from: f  reason: collision with root package name */
    public int f64871f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64872g = false;

    /* renamed from: h  reason: collision with root package name */
    public v f64873h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                return;
            }
            d.this.f64870e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - g0.e().getLong("ubc_last_upload_all_time", 0L)) < VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            d.this.f64870e.L();
            long currentTimeMillis = System.currentTimeMillis();
            g0.e().putLong("ubc_last_upload_all_time", currentTimeMillis);
            g0.e().putLong("ubc_last_upload_non_real", currentTimeMillis);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64870e.m();
        }
    }

    /* renamed from: d.b.l0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1764d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f64877e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64878f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f64879g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.l0.n f64880h;
        public final /* synthetic */ t i;

        public RunnableC1764d(JSONObject jSONObject, String str, boolean z, d.b.l0.n nVar, t tVar) {
            this.f64877e = jSONObject;
            this.f64878f = str;
            this.f64879g = z;
            this.f64880h = nVar;
            this.i = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64870e.H(this.f64877e, this.f64878f, this.f64879g, this.f64880h, this.i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64870e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64870e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f64883e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64884f;

        public g(boolean z, String str) {
            this.f64883e = z;
            this.f64884f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f64883e) {
                d.this.f64870e.K(this.f64884f);
            } else {
                d.this.f64870e.J(this.f64884f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public w f64886e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64887f;

        /* renamed from: g  reason: collision with root package name */
        public s f64888g;

        public h(w wVar, boolean z, s sVar) {
            this.f64886e = wVar;
            this.f64887f = z;
            this.f64888g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64870e.F(this.f64886e, this.f64887f, this.f64888g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f64893e;

        /* renamed from: f  reason: collision with root package name */
        public int f64894f;

        public j(String str, int i) {
            this.f64893e = str;
            this.f64894f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64870e.h(this.f64893e, this.f64894f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f64898e;

        /* renamed from: f  reason: collision with root package name */
        public int f64899f;

        /* renamed from: g  reason: collision with root package name */
        public long f64900g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f64901h;

        public l(String str, int i, JSONArray jSONArray) {
            this.f64898e = str;
            this.f64899f = i;
            this.f64901h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64870e.l(this.f64898e, this.f64899f, this.f64900g, this.f64901h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f64902e;

        /* renamed from: f  reason: collision with root package name */
        public int f64903f;

        /* renamed from: g  reason: collision with root package name */
        public String f64904g;

        public m(String str, int i, String str2) {
            this.f64902e = str;
            this.f64903f = i;
            this.f64904g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64870e.G(this.f64902e, this.f64903f, this.f64904g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f64869d = d.b.l0.g.m();
            d.this.f64870e = new d.b.l0.c(d.this.f64866a);
            d.this.f64870e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f64871f;
        dVar.f64871f = i2 + 1;
        return i2;
    }

    @Inject
    public static final r o() {
        return d.b.j0.y2.t.a();
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
        this.f64867b.execute(new f());
    }

    public void B(w wVar, boolean z, s sVar) {
        this.f64867b.execute(new h(wVar, z, sVar));
    }

    public void C(String str, int i2, String str2) {
        this.f64867b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f64872g) {
            return;
        }
        this.f64872g = true;
        this.f64867b.execute(new b());
    }

    public void E(JSONObject jSONObject) {
        F(jSONObject, null);
    }

    public void F(JSONObject jSONObject, String str) {
        G(jSONObject, str, false, null, null);
    }

    public void G(JSONObject jSONObject, String str, boolean z, d.b.l0.n nVar, t tVar) {
        if (i) {
            Log.d("UBCBehaviorProcessor", "uploadData:" + str);
            Log.d("UBCDEBUG", jSONObject.toString());
        }
        boolean z2 = true;
        r o = o();
        if (o != null && !o.a()) {
            z2 = false;
        }
        if (z2) {
            this.f64868c.execute(new RunnableC1764d(jSONObject, str, z, nVar, tVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, d.b.l0.n nVar, t tVar) {
        G(jSONObject, null, z, nVar, tVar);
    }

    public void I(String str, boolean z) {
        this.f64867b.execute(new g(z, str));
    }

    public void J() {
        this.f64867b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f64869d != null && this.f64869d.w(str)) {
                kVar.a(true);
            }
            this.f64867b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f64869d != null && this.f64869d.w(str)) {
                kVar.a(true);
            }
            this.f64867b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f64867b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f64871f, i2);
        d.b.l0.g gVar = this.f64869d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().a(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.b.l0.g gVar2 = this.f64869d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.b.l0.g gVar3 = this.f64869d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.b.l0.g gVar4 = this.f64869d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f64867b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f64867b.execute(new c());
    }

    public String r(String str) {
        d.b.l0.c cVar = this.f64870e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f64866a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f64866a = context;
        } else {
            this.f64866a = context.getApplicationContext();
        }
        this.f64871f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f64867b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f64868c = Executors.newSingleThreadExecutor();
        this.f64873h = (v) ServiceManager.getService(v.f64970a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f64867b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f64867b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f64867b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f64867b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f64867b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f64867b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f64867b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.l0.n f64890e;

        /* renamed from: f  reason: collision with root package name */
        public String f64891f;

        public i(String str, String str2, int i) {
            this.f64890e = new d.b.l0.n(str, str2, i);
            this.f64891f = str;
        }

        public final boolean a(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().a(str)) {
                if (d.this.f64869d == null || d.this.f64869d.g(str, i)) {
                    if (d.this.f64869d == null || !d.this.f64869d.v(str)) {
                        if (d.this.f64869d == null || !d.this.f64869d.h(str)) {
                            return d.this.f64869d == null || !d.this.f64869d.d(str);
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
            d.b.l0.n nVar = this.f64890e;
            if (nVar == null) {
                return;
            }
            String g2 = nVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f64890e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f64890e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f64873h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f64873h.a(g2, b2);
        }

        public void c(boolean z) {
            d.b.l0.n nVar = this.f64890e;
            if (nVar != null) {
                nVar.n(z);
            }
        }

        public void d(String str) {
            d.b.l0.n nVar = this.f64890e;
            if (nVar != null) {
                nVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f64873h != null && d.this.f64869d != null && d.this.f64869d.b(this.f64891f) == 1) {
                b();
            }
            if (this.f64890e.e() == -1) {
                if (!a(this.f64890e.g(), this.f64890e.i())) {
                    return;
                }
                if (d.this.f64869d != null && d.this.f64869d.w(this.f64890e.g())) {
                    c(true);
                }
            }
            this.f64890e.o();
            String g2 = this.f64890e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f64869d != null) {
                String i = d.this.f64869d.i(g2);
                if (!TextUtils.isEmpty(i)) {
                    this.f64890e.m(i);
                }
            }
            if (d.this.f64873h != null && d.this.f64869d != null && d.this.f64869d.b(this.f64891f) == 2) {
                b();
            }
            if (this.f64890e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f64870e.y(this.f64890e);
            } else if ((this.f64890e.i() & 8) != 0) {
                d.this.f64870e.x(this.f64890e);
            } else if (this.f64890e == null || d.this.f64869d == null || !d.this.f64869d.f(g2)) {
                d.this.f64870e.w(this.f64890e);
            } else {
                d.this.f64870e.Q(this.f64890e);
            }
        }

        public i(String str, JSONObject jSONObject, int i) {
            this.f64890e = new d.b.l0.n(str, jSONObject, i);
            this.f64891f = str;
        }

        public i(String str, String str2, int i, String str3, int i2) {
            this.f64890e = new d.b.l0.n(str, str2, i, str3, i2);
            this.f64891f = str;
        }

        public i(String str, String str2, int i, String str3, long j, int i2) {
            this.f64890e = new d.b.l0.n(str, str2, i, str3, j, i2);
            this.f64891f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public p f64896e;

        public k(Flow flow, String str) {
            p pVar = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f64896e = pVar;
            pVar.m(flow.getStartTime());
            this.f64896e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            p pVar = this.f64896e;
            if (pVar != null) {
                pVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64870e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f64896e.r();
            if (!TextUtils.isEmpty(d.this.f64869d.i(this.f64896e.g()))) {
                this.f64896e.n(d.this.f64869d.i(this.f64896e.g()));
            }
            d.this.f64870e.D(this.f64896e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f64871f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            p pVar = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f64896e = pVar;
            pVar.m(flow.getStartTime());
            this.f64896e.w("1");
            d.i(d.this);
        }
    }
}
