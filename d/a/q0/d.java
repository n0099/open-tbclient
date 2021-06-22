package d.a.q0;

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
    public static final boolean f68034i = AppConfig.isDebug();
    public static volatile d j;

    /* renamed from: a  reason: collision with root package name */
    public Context f68035a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f68036b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f68037c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.g f68038d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.c f68039e;

    /* renamed from: f  reason: collision with root package name */
    public int f68040f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68041g = false;

    /* renamed from: h  reason: collision with root package name */
    public w f68042h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                return;
            }
            d.this.f68039e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - h0.e().getLong("ubc_last_upload_all_time", 0L)) < 3600000) {
                return;
            }
            d.this.f68039e.L();
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
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f68039e.m();
        }
    }

    /* renamed from: d.a.q0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1859d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f68046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68047f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f68048g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f68049h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u f68050i;

        public RunnableC1859d(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
            this.f68046e = jSONObject;
            this.f68047f = str;
            this.f68048g = z;
            this.f68049h = oVar;
            this.f68050i = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f68039e.H(this.f68046e, this.f68047f, this.f68048g, this.f68049h, this.f68050i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f68039e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f68039e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f68053e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68054f;

        public g(boolean z, String str) {
            this.f68053e = z;
            this.f68054f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f68053e) {
                d.this.f68039e.K(this.f68054f);
            } else {
                d.this.f68039e.J(this.f68054f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public x f68056e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68057f;

        /* renamed from: g  reason: collision with root package name */
        public t f68058g;

        public h(x xVar, boolean z, t tVar) {
            this.f68056e = xVar;
            this.f68057f = z;
            this.f68058g = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f68039e.F(this.f68056e, this.f68057f, this.f68058g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f68063e;

        /* renamed from: f  reason: collision with root package name */
        public int f68064f;

        public j(String str, int i2) {
            this.f68063e = str;
            this.f68064f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f68039e.h(this.f68063e, this.f68064f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f68068e;

        /* renamed from: f  reason: collision with root package name */
        public int f68069f;

        /* renamed from: g  reason: collision with root package name */
        public long f68070g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f68071h;

        public l(String str, int i2, JSONArray jSONArray) {
            this.f68068e = str;
            this.f68069f = i2;
            this.f68071h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f68039e.l(this.f68068e, this.f68069f, this.f68070g, this.f68071h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f68073e;

        /* renamed from: f  reason: collision with root package name */
        public int f68074f;

        /* renamed from: g  reason: collision with root package name */
        public String f68075g;

        public m(String str, int i2, String str2) {
            this.f68073e = str;
            this.f68074f = i2;
            this.f68075g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f68039e.G(this.f68073e, this.f68074f, this.f68075g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f68038d = d.a.q0.g.m();
            d.this.f68039e = new d.a.q0.c(d.this.f68035a);
            d.this.f68039e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f68040f;
        dVar.f68040f = i2 + 1;
        return i2;
    }

    @Inject
    public static final s o() {
        return d.a.o0.z2.t.a();
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
        this.f68036b.execute(new f());
    }

    public void B(x xVar, boolean z, t tVar) {
        this.f68036b.execute(new h(xVar, z, tVar));
    }

    public void C(String str, int i2, String str2) {
        this.f68036b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f68041g) {
            return;
        }
        this.f68041g = true;
        this.f68036b.execute(new b());
    }

    public void E(JSONObject jSONObject) {
        F(jSONObject, null);
    }

    public void F(JSONObject jSONObject, String str) {
        G(jSONObject, str, false, null, null);
    }

    public void G(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
        if (f68034i) {
            Log.d("UBCBehaviorProcessor", "uploadData:" + str);
            Log.d("UBCDEBUG", jSONObject.toString());
        }
        boolean z2 = true;
        s o = o();
        if (o != null && !o.a()) {
            z2 = false;
        }
        if (z2) {
            this.f68037c.execute(new RunnableC1859d(jSONObject, str, z, oVar, uVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, o oVar, u uVar) {
        G(jSONObject, null, z, oVar, uVar);
    }

    public void I(String str, boolean z) {
        this.f68036b.execute(new g(z, str));
    }

    public void J() {
        this.f68036b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f68038d != null && this.f68038d.w(str)) {
                kVar.a(true);
            }
            this.f68036b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f68038d != null && this.f68038d.w(str)) {
                kVar.a(true);
            }
            this.f68036b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f68036b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f68040f, i2);
        d.a.q0.g gVar = this.f68038d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.a.q0.g gVar2 = this.f68038d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.q0.g gVar3 = this.f68038d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.q0.g gVar4 = this.f68038d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f68036b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f68036b.execute(new c());
    }

    public String r(String str) {
        d.a.q0.c cVar = this.f68039e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f68035a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f68035a = context;
        } else {
            this.f68035a = context.getApplicationContext();
        }
        this.f68040f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f68036b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f68037c = Executors.newSingleThreadExecutor();
        this.f68042h = (w) ServiceManager.getService(w.f68146a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f68036b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f68036b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f68036b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f68036b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f68036b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f68036b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f68036b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public o f68060e;

        /* renamed from: f  reason: collision with root package name */
        public String f68061f;

        public i(String str, String str2, int i2) {
            this.f68060e = new o(str, str2, i2);
            this.f68061f = str;
        }

        public final boolean a(String str, int i2) {
            if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                if (d.this.f68038d == null || d.this.f68038d.g(str, i2)) {
                    if (d.this.f68038d == null || !d.this.f68038d.v(str)) {
                        if (d.this.f68038d == null || !d.this.f68038d.h(str)) {
                            return d.this.f68038d == null || !d.this.f68038d.d(str);
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
            o oVar = this.f68060e;
            if (oVar == null) {
                return;
            }
            String g2 = oVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f68060e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f68060e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f68042h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f68042h.a(g2, b2);
        }

        public void c(boolean z) {
            o oVar = this.f68060e;
            if (oVar != null) {
                oVar.n(z);
            }
        }

        public void d(String str) {
            o oVar = this.f68060e;
            if (oVar != null) {
                oVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f68042h != null && d.this.f68038d != null && d.this.f68038d.b(this.f68061f) == 1) {
                b();
            }
            if (this.f68060e.e() == -1) {
                if (!a(this.f68060e.g(), this.f68060e.i())) {
                    return;
                }
                if (d.this.f68038d != null && d.this.f68038d.w(this.f68060e.g())) {
                    c(true);
                }
            }
            this.f68060e.o();
            String g2 = this.f68060e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f68038d != null) {
                String i2 = d.this.f68038d.i(g2);
                if (!TextUtils.isEmpty(i2)) {
                    this.f68060e.m(i2);
                }
            }
            if (d.this.f68042h != null && d.this.f68038d != null && d.this.f68038d.b(this.f68061f) == 2) {
                b();
            }
            if (this.f68060e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f68039e.y(this.f68060e);
            } else if ((this.f68060e.i() & 8) != 0) {
                d.this.f68039e.x(this.f68060e);
            } else if (this.f68060e == null || d.this.f68038d == null || !d.this.f68038d.f(g2)) {
                d.this.f68039e.w(this.f68060e);
            } else {
                d.this.f68039e.Q(this.f68060e);
            }
        }

        public i(String str, JSONObject jSONObject, int i2) {
            this.f68060e = new o(str, jSONObject, i2);
            this.f68061f = str;
        }

        public i(String str, String str2, int i2, String str3, int i3) {
            this.f68060e = new o(str, str2, i2, str3, i3);
            this.f68061f = str;
        }

        public i(String str, String str2, int i2, String str3, long j, int i3) {
            this.f68060e = new o(str, str2, i2, str3, j, i3);
            this.f68061f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f68066e;

        public k(Flow flow, String str) {
            q qVar = new q(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f68066e = qVar;
            qVar.m(flow.getStartTime());
            this.f68066e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            q qVar = this.f68066e;
            if (qVar != null) {
                qVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f68039e == null) {
                if (d.f68034i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f68066e.r();
            if (!TextUtils.isEmpty(d.this.f68038d.i(this.f68066e.g()))) {
                this.f68066e.n(d.this.f68038d.i(this.f68066e.g()));
            }
            d.this.f68039e.D(this.f68066e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f68040f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            q qVar = new q(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f68066e = qVar;
            qVar.m(flow.getStartTime());
            this.f68066e.w("1");
            d.i(d.this);
        }
    }
}
