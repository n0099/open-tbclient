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

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f63902i = AppConfig.isDebug();
    public static volatile d j;

    /* renamed from: a  reason: collision with root package name */
    public Context f63903a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f63904b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f63905c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.g f63906d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.c f63907e;

    /* renamed from: f  reason: collision with root package name */
    public int f63908f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63909g = false;

    /* renamed from: h  reason: collision with root package name */
    public w f63910h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                return;
            }
            d.this.f63907e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - h0.e().getLong("ubc_last_upload_all_time", 0L)) < VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            d.this.f63907e.L();
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
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63907e.m();
        }
    }

    /* renamed from: d.a.p0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1774d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f63914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63915f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f63916g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f63917h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u f63918i;

        public RunnableC1774d(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
            this.f63914e = jSONObject;
            this.f63915f = str;
            this.f63916g = z;
            this.f63917h = oVar;
            this.f63918i = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63907e.H(this.f63914e, this.f63915f, this.f63916g, this.f63917h, this.f63918i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63907e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63907e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f63921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63922f;

        public g(boolean z, String str) {
            this.f63921e = z;
            this.f63922f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f63921e) {
                d.this.f63907e.K(this.f63922f);
            } else {
                d.this.f63907e.J(this.f63922f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public x f63924e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63925f;

        /* renamed from: g  reason: collision with root package name */
        public t f63926g;

        public h(x xVar, boolean z, t tVar) {
            this.f63924e = xVar;
            this.f63925f = z;
            this.f63926g = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63907e.F(this.f63924e, this.f63925f, this.f63926g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63931e;

        /* renamed from: f  reason: collision with root package name */
        public int f63932f;

        public j(String str, int i2) {
            this.f63931e = str;
            this.f63932f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63907e.h(this.f63931e, this.f63932f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63936e;

        /* renamed from: f  reason: collision with root package name */
        public int f63937f;

        /* renamed from: g  reason: collision with root package name */
        public long f63938g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f63939h;

        public l(String str, int i2, JSONArray jSONArray) {
            this.f63936e = str;
            this.f63937f = i2;
            this.f63939h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63907e.l(this.f63936e, this.f63937f, this.f63938g, this.f63939h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63941e;

        /* renamed from: f  reason: collision with root package name */
        public int f63942f;

        /* renamed from: g  reason: collision with root package name */
        public String f63943g;

        public m(String str, int i2, String str2) {
            this.f63941e = str;
            this.f63942f = i2;
            this.f63943g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63907e.G(this.f63941e, this.f63942f, this.f63943g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f63906d = d.a.p0.g.m();
            d.this.f63907e = new d.a.p0.c(d.this.f63903a);
            d.this.f63907e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f63908f;
        dVar.f63908f = i2 + 1;
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
        this.f63904b.execute(new f());
    }

    public void B(x xVar, boolean z, t tVar) {
        this.f63904b.execute(new h(xVar, z, tVar));
    }

    public void C(String str, int i2, String str2) {
        this.f63904b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f63909g) {
            return;
        }
        this.f63909g = true;
        this.f63904b.execute(new b());
    }

    public void E(JSONObject jSONObject) {
        F(jSONObject, null);
    }

    public void F(JSONObject jSONObject, String str) {
        G(jSONObject, str, false, null, null);
    }

    public void G(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
        if (f63902i) {
            Log.d("UBCBehaviorProcessor", "uploadData:" + str);
            Log.d("UBCDEBUG", jSONObject.toString());
        }
        boolean z2 = true;
        s o = o();
        if (o != null && !o.a()) {
            z2 = false;
        }
        if (z2) {
            this.f63905c.execute(new RunnableC1774d(jSONObject, str, z, oVar, uVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, o oVar, u uVar) {
        G(jSONObject, null, z, oVar, uVar);
    }

    public void I(String str, boolean z) {
        this.f63904b.execute(new g(z, str));
    }

    public void J() {
        this.f63904b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f63906d != null && this.f63906d.w(str)) {
                kVar.a(true);
            }
            this.f63904b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f63906d != null && this.f63906d.w(str)) {
                kVar.a(true);
            }
            this.f63904b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f63904b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f63908f, i2);
        d.a.p0.g gVar = this.f63906d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.a.p0.g gVar2 = this.f63906d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.p0.g gVar3 = this.f63906d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.p0.g gVar4 = this.f63906d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f63904b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f63904b.execute(new c());
    }

    public String r(String str) {
        d.a.p0.c cVar = this.f63907e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f63903a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f63903a = context;
        } else {
            this.f63903a = context.getApplicationContext();
        }
        this.f63908f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f63904b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f63905c = Executors.newSingleThreadExecutor();
        this.f63910h = (w) ServiceManager.getService(w.f64014a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f63904b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f63904b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f63904b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f63904b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f63904b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f63904b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f63904b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public o f63928e;

        /* renamed from: f  reason: collision with root package name */
        public String f63929f;

        public i(String str, String str2, int i2) {
            this.f63928e = new o(str, str2, i2);
            this.f63929f = str;
        }

        public final boolean a(String str, int i2) {
            if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                if (d.this.f63906d == null || d.this.f63906d.g(str, i2)) {
                    if (d.this.f63906d == null || !d.this.f63906d.v(str)) {
                        if (d.this.f63906d == null || !d.this.f63906d.h(str)) {
                            return d.this.f63906d == null || !d.this.f63906d.d(str);
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
            o oVar = this.f63928e;
            if (oVar == null) {
                return;
            }
            String g2 = oVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f63928e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f63928e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f63910h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f63910h.a(g2, b2);
        }

        public void c(boolean z) {
            o oVar = this.f63928e;
            if (oVar != null) {
                oVar.n(z);
            }
        }

        public void d(String str) {
            o oVar = this.f63928e;
            if (oVar != null) {
                oVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f63910h != null && d.this.f63906d != null && d.this.f63906d.b(this.f63929f) == 1) {
                b();
            }
            if (this.f63928e.e() == -1) {
                if (!a(this.f63928e.g(), this.f63928e.i())) {
                    return;
                }
                if (d.this.f63906d != null && d.this.f63906d.w(this.f63928e.g())) {
                    c(true);
                }
            }
            this.f63928e.o();
            String g2 = this.f63928e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f63906d != null) {
                String i2 = d.this.f63906d.i(g2);
                if (!TextUtils.isEmpty(i2)) {
                    this.f63928e.m(i2);
                }
            }
            if (d.this.f63910h != null && d.this.f63906d != null && d.this.f63906d.b(this.f63929f) == 2) {
                b();
            }
            if (this.f63928e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f63907e.y(this.f63928e);
            } else if ((this.f63928e.i() & 8) != 0) {
                d.this.f63907e.x(this.f63928e);
            } else if (this.f63928e == null || d.this.f63906d == null || !d.this.f63906d.f(g2)) {
                d.this.f63907e.w(this.f63928e);
            } else {
                d.this.f63907e.Q(this.f63928e);
            }
        }

        public i(String str, JSONObject jSONObject, int i2) {
            this.f63928e = new o(str, jSONObject, i2);
            this.f63929f = str;
        }

        public i(String str, String str2, int i2, String str3, int i3) {
            this.f63928e = new o(str, str2, i2, str3, i3);
            this.f63929f = str;
        }

        public i(String str, String str2, int i2, String str3, long j, int i3) {
            this.f63928e = new o(str, str2, i2, str3, j, i3);
            this.f63929f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f63934e;

        public k(Flow flow, String str) {
            q qVar = new q(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f63934e = qVar;
            qVar.m(flow.getStartTime());
            this.f63934e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            q qVar = this.f63934e;
            if (qVar != null) {
                qVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63907e == null) {
                if (d.f63902i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f63934e.r();
            if (!TextUtils.isEmpty(d.this.f63906d.i(this.f63934e.g()))) {
                this.f63934e.n(d.this.f63906d.i(this.f63934e.g()));
            }
            d.this.f63907e.D(this.f63934e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f63908f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            q qVar = new q(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f63934e = qVar;
            qVar.m(flow.getStartTime());
            this.f63934e.w("1");
            d.i(d.this);
        }
    }
}
