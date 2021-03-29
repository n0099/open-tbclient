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
    public Context f63885a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f63886b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f63887c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.k0.g f63888d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.k0.c f63889e;

    /* renamed from: f  reason: collision with root package name */
    public int f63890f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63891g = false;

    /* renamed from: h  reason: collision with root package name */
    public v f63892h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                return;
            }
            d.this.f63889e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - g0.e().getLong("ubc_last_upload_all_time", 0L)) < VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            d.this.f63889e.L();
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
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63889e.m();
        }
    }

    /* renamed from: d.b.k0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1733d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f63896e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63897f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f63898g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.k0.n f63899h;
        public final /* synthetic */ t i;

        public RunnableC1733d(JSONObject jSONObject, String str, boolean z, d.b.k0.n nVar, t tVar) {
            this.f63896e = jSONObject;
            this.f63897f = str;
            this.f63898g = z;
            this.f63899h = nVar;
            this.i = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63889e.H(this.f63896e, this.f63897f, this.f63898g, this.f63899h, this.i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63889e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63889e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f63902e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63903f;

        public g(boolean z, String str) {
            this.f63902e = z;
            this.f63903f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f63902e) {
                d.this.f63889e.K(this.f63903f);
            } else {
                d.this.f63889e.J(this.f63903f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public w f63905e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63906f;

        /* renamed from: g  reason: collision with root package name */
        public s f63907g;

        public h(w wVar, boolean z, s sVar) {
            this.f63905e = wVar;
            this.f63906f = z;
            this.f63907g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63889e.F(this.f63905e, this.f63906f, this.f63907g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63912e;

        /* renamed from: f  reason: collision with root package name */
        public int f63913f;

        public j(String str, int i) {
            this.f63912e = str;
            this.f63913f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63889e.h(this.f63912e, this.f63913f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63917e;

        /* renamed from: f  reason: collision with root package name */
        public int f63918f;

        /* renamed from: g  reason: collision with root package name */
        public long f63919g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f63920h;

        public l(String str, int i, JSONArray jSONArray) {
            this.f63917e = str;
            this.f63918f = i;
            this.f63920h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63889e.l(this.f63917e, this.f63918f, this.f63919g, this.f63920h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63921e;

        /* renamed from: f  reason: collision with root package name */
        public int f63922f;

        /* renamed from: g  reason: collision with root package name */
        public String f63923g;

        public m(String str, int i, String str2) {
            this.f63921e = str;
            this.f63922f = i;
            this.f63923g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63889e.G(this.f63921e, this.f63922f, this.f63923g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f63888d = d.b.k0.g.m();
            d.this.f63889e = new d.b.k0.c(d.this.f63885a);
            d.this.f63889e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f63890f;
        dVar.f63890f = i2 + 1;
        return i2;
    }

    @Inject
    public static final r o() {
        return d.b.i0.x2.t.a();
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
        this.f63886b.execute(new f());
    }

    public void B(w wVar, boolean z, s sVar) {
        this.f63886b.execute(new h(wVar, z, sVar));
    }

    public void C(String str, int i2, String str2) {
        this.f63886b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f63891g) {
            return;
        }
        this.f63891g = true;
        this.f63886b.execute(new b());
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
            this.f63887c.execute(new RunnableC1733d(jSONObject, str, z, nVar, tVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, d.b.k0.n nVar, t tVar) {
        G(jSONObject, null, z, nVar, tVar);
    }

    public void I(String str, boolean z) {
        this.f63886b.execute(new g(z, str));
    }

    public void J() {
        this.f63886b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f63888d != null && this.f63888d.w(str)) {
                kVar.a(true);
            }
            this.f63886b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f63888d != null && this.f63888d.w(str)) {
                kVar.a(true);
            }
            this.f63886b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f63886b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f63890f, i2);
        d.b.k0.g gVar = this.f63888d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().a(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.b.k0.g gVar2 = this.f63888d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.b.k0.g gVar3 = this.f63888d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.b.k0.g gVar4 = this.f63888d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f63886b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f63886b.execute(new c());
    }

    public String r(String str) {
        d.b.k0.c cVar = this.f63889e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f63885a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f63885a = context;
        } else {
            this.f63885a = context.getApplicationContext();
        }
        this.f63890f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f63886b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f63887c = Executors.newSingleThreadExecutor();
        this.f63892h = (v) ServiceManager.getService(v.f63989a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f63886b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f63886b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f63886b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f63886b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f63886b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f63886b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f63886b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.k0.n f63909e;

        /* renamed from: f  reason: collision with root package name */
        public String f63910f;

        public i(String str, String str2, int i) {
            this.f63909e = new d.b.k0.n(str, str2, i);
            this.f63910f = str;
        }

        public final boolean a(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().a(str)) {
                if (d.this.f63888d == null || d.this.f63888d.g(str, i)) {
                    if (d.this.f63888d == null || !d.this.f63888d.v(str)) {
                        if (d.this.f63888d == null || !d.this.f63888d.h(str)) {
                            return d.this.f63888d == null || !d.this.f63888d.d(str);
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
            d.b.k0.n nVar = this.f63909e;
            if (nVar == null) {
                return;
            }
            String g2 = nVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f63909e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f63909e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f63892h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f63892h.a(g2, b2);
        }

        public void c(boolean z) {
            d.b.k0.n nVar = this.f63909e;
            if (nVar != null) {
                nVar.n(z);
            }
        }

        public void d(String str) {
            d.b.k0.n nVar = this.f63909e;
            if (nVar != null) {
                nVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f63892h != null && d.this.f63888d != null && d.this.f63888d.b(this.f63910f) == 1) {
                b();
            }
            if (this.f63909e.e() == -1) {
                if (!a(this.f63909e.g(), this.f63909e.i())) {
                    return;
                }
                if (d.this.f63888d != null && d.this.f63888d.w(this.f63909e.g())) {
                    c(true);
                }
            }
            this.f63909e.o();
            String g2 = this.f63909e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f63888d != null) {
                String i = d.this.f63888d.i(g2);
                if (!TextUtils.isEmpty(i)) {
                    this.f63909e.m(i);
                }
            }
            if (d.this.f63892h != null && d.this.f63888d != null && d.this.f63888d.b(this.f63910f) == 2) {
                b();
            }
            if (this.f63909e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f63889e.y(this.f63909e);
            } else if ((this.f63909e.i() & 8) != 0) {
                d.this.f63889e.x(this.f63909e);
            } else if (this.f63909e == null || d.this.f63888d == null || !d.this.f63888d.f(g2)) {
                d.this.f63889e.w(this.f63909e);
            } else {
                d.this.f63889e.Q(this.f63909e);
            }
        }

        public i(String str, JSONObject jSONObject, int i) {
            this.f63909e = new d.b.k0.n(str, jSONObject, i);
            this.f63910f = str;
        }

        public i(String str, String str2, int i, String str3, int i2) {
            this.f63909e = new d.b.k0.n(str, str2, i, str3, i2);
            this.f63910f = str;
        }

        public i(String str, String str2, int i, String str3, long j, int i2) {
            this.f63909e = new d.b.k0.n(str, str2, i, str3, j, i2);
            this.f63910f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public p f63915e;

        public k(Flow flow, String str) {
            p pVar = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f63915e = pVar;
            pVar.m(flow.getStartTime());
            this.f63915e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            p pVar = this.f63915e;
            if (pVar != null) {
                pVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63889e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f63915e.r();
            if (!TextUtils.isEmpty(d.this.f63888d.i(this.f63915e.g()))) {
                this.f63915e.n(d.this.f63888d.i(this.f63915e.g()));
            }
            d.this.f63889e.D(this.f63915e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f63890f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            p pVar = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f63915e = pVar;
            pVar.m(flow.getStartTime());
            this.f63915e.w("1");
            d.i(d.this);
        }
    }
}
