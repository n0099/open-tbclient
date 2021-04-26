package d.a.l0;

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
    public static final boolean f63165i = AppConfig.isDebug();
    public static volatile d j;

    /* renamed from: a  reason: collision with root package name */
    public Context f63166a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f63167b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f63168c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.g f63169d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.c f63170e;

    /* renamed from: f  reason: collision with root package name */
    public int f63171f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63172g = false;

    /* renamed from: h  reason: collision with root package name */
    public w f63173h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                return;
            }
            d.this.f63170e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - h0.e().getLong("ubc_last_upload_all_time", 0L)) < VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            d.this.f63170e.L();
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
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63170e.m();
        }
    }

    /* renamed from: d.a.l0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1702d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f63177e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63178f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f63179g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f63180h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u f63181i;

        public RunnableC1702d(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
            this.f63177e = jSONObject;
            this.f63178f = str;
            this.f63179g = z;
            this.f63180h = oVar;
            this.f63181i = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63170e.H(this.f63177e, this.f63178f, this.f63179g, this.f63180h, this.f63181i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63170e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63170e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f63184e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63185f;

        public g(boolean z, String str) {
            this.f63184e = z;
            this.f63185f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f63184e) {
                d.this.f63170e.K(this.f63185f);
            } else {
                d.this.f63170e.J(this.f63185f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public x f63187e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63188f;

        /* renamed from: g  reason: collision with root package name */
        public t f63189g;

        public h(x xVar, boolean z, t tVar) {
            this.f63187e = xVar;
            this.f63188f = z;
            this.f63189g = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63170e.F(this.f63187e, this.f63188f, this.f63189g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63194e;

        /* renamed from: f  reason: collision with root package name */
        public int f63195f;

        public j(String str, int i2) {
            this.f63194e = str;
            this.f63195f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63170e.h(this.f63194e, this.f63195f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63199e;

        /* renamed from: f  reason: collision with root package name */
        public int f63200f;

        /* renamed from: g  reason: collision with root package name */
        public long f63201g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f63202h;

        public l(String str, int i2, JSONArray jSONArray) {
            this.f63199e = str;
            this.f63200f = i2;
            this.f63202h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63170e.l(this.f63199e, this.f63200f, this.f63201g, this.f63202h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63204e;

        /* renamed from: f  reason: collision with root package name */
        public int f63205f;

        /* renamed from: g  reason: collision with root package name */
        public String f63206g;

        public m(String str, int i2, String str2) {
            this.f63204e = str;
            this.f63205f = i2;
            this.f63206g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63170e.G(this.f63204e, this.f63205f, this.f63206g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f63169d = d.a.l0.g.m();
            d.this.f63170e = new d.a.l0.c(d.this.f63166a);
            d.this.f63170e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f63171f;
        dVar.f63171f = i2 + 1;
        return i2;
    }

    @Inject
    public static final s o() {
        return d.a.j0.y2.t.a();
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
        this.f63167b.execute(new f());
    }

    public void B(x xVar, boolean z, t tVar) {
        this.f63167b.execute(new h(xVar, z, tVar));
    }

    public void C(String str, int i2, String str2) {
        this.f63167b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f63172g) {
            return;
        }
        this.f63172g = true;
        this.f63167b.execute(new b());
    }

    public void E(JSONObject jSONObject) {
        F(jSONObject, null);
    }

    public void F(JSONObject jSONObject, String str) {
        G(jSONObject, str, false, null, null);
    }

    public void G(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
        if (f63165i) {
            Log.d("UBCBehaviorProcessor", "uploadData:" + str);
            Log.d("UBCDEBUG", jSONObject.toString());
        }
        boolean z2 = true;
        s o = o();
        if (o != null && !o.a()) {
            z2 = false;
        }
        if (z2) {
            this.f63168c.execute(new RunnableC1702d(jSONObject, str, z, oVar, uVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, o oVar, u uVar) {
        G(jSONObject, null, z, oVar, uVar);
    }

    public void I(String str, boolean z) {
        this.f63167b.execute(new g(z, str));
    }

    public void J() {
        this.f63167b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f63169d != null && this.f63169d.w(str)) {
                kVar.a(true);
            }
            this.f63167b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f63169d != null && this.f63169d.w(str)) {
                kVar.a(true);
            }
            this.f63167b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f63167b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f63171f, i2);
        d.a.l0.g gVar = this.f63169d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().a(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.a.l0.g gVar2 = this.f63169d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.l0.g gVar3 = this.f63169d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.l0.g gVar4 = this.f63169d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f63167b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f63167b.execute(new c());
    }

    public String r(String str) {
        d.a.l0.c cVar = this.f63170e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f63166a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f63166a = context;
        } else {
            this.f63166a = context.getApplicationContext();
        }
        this.f63171f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f63167b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f63168c = Executors.newSingleThreadExecutor();
        this.f63173h = (w) ServiceManager.getService(w.f63277a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f63167b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f63167b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f63167b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f63167b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f63167b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f63167b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f63167b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public o f63191e;

        /* renamed from: f  reason: collision with root package name */
        public String f63192f;

        public i(String str, String str2, int i2) {
            this.f63191e = new o(str, str2, i2);
            this.f63192f = str;
        }

        public final boolean a(String str, int i2) {
            if ((i2 & 16) == 0 || UBC.getUBCContext().a(str)) {
                if (d.this.f63169d == null || d.this.f63169d.g(str, i2)) {
                    if (d.this.f63169d == null || !d.this.f63169d.v(str)) {
                        if (d.this.f63169d == null || !d.this.f63169d.h(str)) {
                            return d.this.f63169d == null || !d.this.f63169d.d(str);
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
            o oVar = this.f63191e;
            if (oVar == null) {
                return;
            }
            String g2 = oVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f63191e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f63191e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f63173h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f63173h.a(g2, b2);
        }

        public void c(boolean z) {
            o oVar = this.f63191e;
            if (oVar != null) {
                oVar.n(z);
            }
        }

        public void d(String str) {
            o oVar = this.f63191e;
            if (oVar != null) {
                oVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f63173h != null && d.this.f63169d != null && d.this.f63169d.b(this.f63192f) == 1) {
                b();
            }
            if (this.f63191e.e() == -1) {
                if (!a(this.f63191e.g(), this.f63191e.i())) {
                    return;
                }
                if (d.this.f63169d != null && d.this.f63169d.w(this.f63191e.g())) {
                    c(true);
                }
            }
            this.f63191e.o();
            String g2 = this.f63191e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f63169d != null) {
                String i2 = d.this.f63169d.i(g2);
                if (!TextUtils.isEmpty(i2)) {
                    this.f63191e.m(i2);
                }
            }
            if (d.this.f63173h != null && d.this.f63169d != null && d.this.f63169d.b(this.f63192f) == 2) {
                b();
            }
            if (this.f63191e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f63170e.y(this.f63191e);
            } else if ((this.f63191e.i() & 8) != 0) {
                d.this.f63170e.x(this.f63191e);
            } else if (this.f63191e == null || d.this.f63169d == null || !d.this.f63169d.f(g2)) {
                d.this.f63170e.w(this.f63191e);
            } else {
                d.this.f63170e.Q(this.f63191e);
            }
        }

        public i(String str, JSONObject jSONObject, int i2) {
            this.f63191e = new o(str, jSONObject, i2);
            this.f63192f = str;
        }

        public i(String str, String str2, int i2, String str3, int i3) {
            this.f63191e = new o(str, str2, i2, str3, i3);
            this.f63192f = str;
        }

        public i(String str, String str2, int i2, String str3, long j, int i3) {
            this.f63191e = new o(str, str2, i2, str3, j, i3);
            this.f63192f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f63197e;

        public k(Flow flow, String str) {
            q qVar = new q(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f63197e = qVar;
            qVar.m(flow.getStartTime());
            this.f63197e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            q qVar = this.f63197e;
            if (qVar != null) {
                qVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63170e == null) {
                if (d.f63165i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f63197e.r();
            if (!TextUtils.isEmpty(d.this.f63169d.i(this.f63197e.g()))) {
                this.f63197e.n(d.this.f63169d.i(this.f63197e.g()));
            }
            d.this.f63170e.D(this.f63197e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f63171f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            q qVar = new q(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f63197e = qVar;
            qVar.m(flow.getStartTime());
            this.f63197e.w("1");
            d.i(d.this);
        }
    }
}
