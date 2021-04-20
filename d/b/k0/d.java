package d.b.k0;

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
    public Context f64585a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f64586b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f64587c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.k0.g f64588d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.k0.c f64589e;

    /* renamed from: f  reason: collision with root package name */
    public int f64590f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64591g = false;

    /* renamed from: h  reason: collision with root package name */
    public v f64592h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                return;
            }
            d.this.f64589e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - g0.e().getLong("ubc_last_upload_all_time", 0L)) < VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            d.this.f64589e.L();
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
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64589e.m();
        }
    }

    /* renamed from: d.b.k0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1745d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f64596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64597f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f64598g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.k0.n f64599h;
        public final /* synthetic */ t i;

        public RunnableC1745d(JSONObject jSONObject, String str, boolean z, d.b.k0.n nVar, t tVar) {
            this.f64596e = jSONObject;
            this.f64597f = str;
            this.f64598g = z;
            this.f64599h = nVar;
            this.i = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64589e.H(this.f64596e, this.f64597f, this.f64598g, this.f64599h, this.i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64589e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64589e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f64602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f64603f;

        public g(boolean z, String str) {
            this.f64602e = z;
            this.f64603f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f64602e) {
                d.this.f64589e.K(this.f64603f);
            } else {
                d.this.f64589e.J(this.f64603f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public w f64605e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64606f;

        /* renamed from: g  reason: collision with root package name */
        public s f64607g;

        public h(w wVar, boolean z, s sVar) {
            this.f64605e = wVar;
            this.f64606f = z;
            this.f64607g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64589e.F(this.f64605e, this.f64606f, this.f64607g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f64612e;

        /* renamed from: f  reason: collision with root package name */
        public int f64613f;

        public j(String str, int i) {
            this.f64612e = str;
            this.f64613f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64589e.h(this.f64612e, this.f64613f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f64617e;

        /* renamed from: f  reason: collision with root package name */
        public int f64618f;

        /* renamed from: g  reason: collision with root package name */
        public long f64619g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f64620h;

        public l(String str, int i, JSONArray jSONArray) {
            this.f64617e = str;
            this.f64618f = i;
            this.f64620h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64589e.l(this.f64617e, this.f64618f, this.f64619g, this.f64620h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f64621e;

        /* renamed from: f  reason: collision with root package name */
        public int f64622f;

        /* renamed from: g  reason: collision with root package name */
        public String f64623g;

        public m(String str, int i, String str2) {
            this.f64621e = str;
            this.f64622f = i;
            this.f64623g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f64589e.G(this.f64621e, this.f64622f, this.f64623g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f64588d = d.b.k0.g.m();
            d.this.f64589e = new d.b.k0.c(d.this.f64585a);
            d.this.f64589e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f64590f;
        dVar.f64590f = i2 + 1;
        return i2;
    }

    @Inject
    public static final r o() {
        return d.b.i0.y2.t.a();
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
        this.f64586b.execute(new f());
    }

    public void B(w wVar, boolean z, s sVar) {
        this.f64586b.execute(new h(wVar, z, sVar));
    }

    public void C(String str, int i2, String str2) {
        this.f64586b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f64591g) {
            return;
        }
        this.f64591g = true;
        this.f64586b.execute(new b());
    }

    public void E(JSONObject jSONObject) {
        F(jSONObject, null);
    }

    public void F(JSONObject jSONObject, String str) {
        G(jSONObject, str, false, null, null);
    }

    public void G(JSONObject jSONObject, String str, boolean z, d.b.k0.n nVar, t tVar) {
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
            this.f64587c.execute(new RunnableC1745d(jSONObject, str, z, nVar, tVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, d.b.k0.n nVar, t tVar) {
        G(jSONObject, null, z, nVar, tVar);
    }

    public void I(String str, boolean z) {
        this.f64586b.execute(new g(z, str));
    }

    public void J() {
        this.f64586b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f64588d != null && this.f64588d.w(str)) {
                kVar.a(true);
            }
            this.f64586b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f64588d != null && this.f64588d.w(str)) {
                kVar.a(true);
            }
            this.f64586b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f64586b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f64590f, i2);
        d.b.k0.g gVar = this.f64588d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().a(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.b.k0.g gVar2 = this.f64588d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.b.k0.g gVar3 = this.f64588d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.b.k0.g gVar4 = this.f64588d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f64586b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f64586b.execute(new c());
    }

    public String r(String str) {
        d.b.k0.c cVar = this.f64589e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f64585a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f64585a = context;
        } else {
            this.f64585a = context.getApplicationContext();
        }
        this.f64590f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f64586b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f64587c = Executors.newSingleThreadExecutor();
        this.f64592h = (v) ServiceManager.getService(v.f64689a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f64586b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f64586b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f64586b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f64586b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f64586b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f64586b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f64586b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.k0.n f64609e;

        /* renamed from: f  reason: collision with root package name */
        public String f64610f;

        public i(String str, String str2, int i) {
            this.f64609e = new d.b.k0.n(str, str2, i);
            this.f64610f = str;
        }

        public final boolean a(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().a(str)) {
                if (d.this.f64588d == null || d.this.f64588d.g(str, i)) {
                    if (d.this.f64588d == null || !d.this.f64588d.v(str)) {
                        if (d.this.f64588d == null || !d.this.f64588d.h(str)) {
                            return d.this.f64588d == null || !d.this.f64588d.d(str);
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
            d.b.k0.n nVar = this.f64609e;
            if (nVar == null) {
                return;
            }
            String g2 = nVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f64609e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f64609e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f64592h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f64592h.a(g2, b2);
        }

        public void c(boolean z) {
            d.b.k0.n nVar = this.f64609e;
            if (nVar != null) {
                nVar.n(z);
            }
        }

        public void d(String str) {
            d.b.k0.n nVar = this.f64609e;
            if (nVar != null) {
                nVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f64592h != null && d.this.f64588d != null && d.this.f64588d.b(this.f64610f) == 1) {
                b();
            }
            if (this.f64609e.e() == -1) {
                if (!a(this.f64609e.g(), this.f64609e.i())) {
                    return;
                }
                if (d.this.f64588d != null && d.this.f64588d.w(this.f64609e.g())) {
                    c(true);
                }
            }
            this.f64609e.o();
            String g2 = this.f64609e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f64588d != null) {
                String i = d.this.f64588d.i(g2);
                if (!TextUtils.isEmpty(i)) {
                    this.f64609e.m(i);
                }
            }
            if (d.this.f64592h != null && d.this.f64588d != null && d.this.f64588d.b(this.f64610f) == 2) {
                b();
            }
            if (this.f64609e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f64589e.y(this.f64609e);
            } else if ((this.f64609e.i() & 8) != 0) {
                d.this.f64589e.x(this.f64609e);
            } else if (this.f64609e == null || d.this.f64588d == null || !d.this.f64588d.f(g2)) {
                d.this.f64589e.w(this.f64609e);
            } else {
                d.this.f64589e.Q(this.f64609e);
            }
        }

        public i(String str, JSONObject jSONObject, int i) {
            this.f64609e = new d.b.k0.n(str, jSONObject, i);
            this.f64610f = str;
        }

        public i(String str, String str2, int i, String str3, int i2) {
            this.f64609e = new d.b.k0.n(str, str2, i, str3, i2);
            this.f64610f = str;
        }

        public i(String str, String str2, int i, String str3, long j, int i2) {
            this.f64609e = new d.b.k0.n(str, str2, i, str3, j, i2);
            this.f64610f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public p f64615e;

        public k(Flow flow, String str) {
            p pVar = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f64615e = pVar;
            pVar.m(flow.getStartTime());
            this.f64615e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            p pVar = this.f64615e;
            if (pVar != null) {
                pVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f64589e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f64615e.r();
            if (!TextUtils.isEmpty(d.this.f64588d.i(this.f64615e.g()))) {
                this.f64615e.n(d.this.f64588d.i(this.f64615e.g()));
            }
            d.this.f64589e.D(this.f64615e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f64590f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            p pVar = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f64615e = pVar;
            pVar.m(flow.getStartTime());
            this.f64615e.w("1");
            d.i(d.this);
        }
    }
}
