package d.a.m0;

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
    public static final boolean f63889i = AppConfig.isDebug();
    public static volatile d j;

    /* renamed from: a  reason: collision with root package name */
    public Context f63890a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f63891b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f63892c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.g f63893d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.c f63894e;

    /* renamed from: f  reason: collision with root package name */
    public int f63895f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63896g = false;

    /* renamed from: h  reason: collision with root package name */
    public w f63897h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                return;
            }
            d.this.f63894e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - h0.e().getLong("ubc_last_upload_all_time", 0L)) < VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            d.this.f63894e.L();
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
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63894e.m();
        }
    }

    /* renamed from: d.a.m0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1766d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f63901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63902f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f63903g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f63904h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ u f63905i;

        public RunnableC1766d(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
            this.f63901e = jSONObject;
            this.f63902f = str;
            this.f63903g = z;
            this.f63904h = oVar;
            this.f63905i = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63894e.H(this.f63901e, this.f63902f, this.f63903g, this.f63904h, this.f63905i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63894e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63894e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f63908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63909f;

        public g(boolean z, String str) {
            this.f63908e = z;
            this.f63909f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f63908e) {
                d.this.f63894e.K(this.f63909f);
            } else {
                d.this.f63894e.J(this.f63909f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public x f63911e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63912f;

        /* renamed from: g  reason: collision with root package name */
        public t f63913g;

        public h(x xVar, boolean z, t tVar) {
            this.f63911e = xVar;
            this.f63912f = z;
            this.f63913g = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63894e.F(this.f63911e, this.f63912f, this.f63913g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63918e;

        /* renamed from: f  reason: collision with root package name */
        public int f63919f;

        public j(String str, int i2) {
            this.f63918e = str;
            this.f63919f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63894e.h(this.f63918e, this.f63919f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63923e;

        /* renamed from: f  reason: collision with root package name */
        public int f63924f;

        /* renamed from: g  reason: collision with root package name */
        public long f63925g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f63926h;

        public l(String str, int i2, JSONArray jSONArray) {
            this.f63923e = str;
            this.f63924f = i2;
            this.f63926h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63894e.l(this.f63923e, this.f63924f, this.f63925g, this.f63926h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63928e;

        /* renamed from: f  reason: collision with root package name */
        public int f63929f;

        /* renamed from: g  reason: collision with root package name */
        public String f63930g;

        public m(String str, int i2, String str2) {
            this.f63928e = str;
            this.f63929f = i2;
            this.f63930g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63894e.G(this.f63928e, this.f63929f, this.f63930g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f63893d = d.a.m0.g.m();
            d.this.f63894e = new d.a.m0.c(d.this.f63890a);
            d.this.f63894e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f63895f;
        dVar.f63895f = i2 + 1;
        return i2;
    }

    @Inject
    public static final s o() {
        return d.a.k0.y2.t.a();
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
        this.f63891b.execute(new f());
    }

    public void B(x xVar, boolean z, t tVar) {
        this.f63891b.execute(new h(xVar, z, tVar));
    }

    public void C(String str, int i2, String str2) {
        this.f63891b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f63896g) {
            return;
        }
        this.f63896g = true;
        this.f63891b.execute(new b());
    }

    public void E(JSONObject jSONObject) {
        F(jSONObject, null);
    }

    public void F(JSONObject jSONObject, String str) {
        G(jSONObject, str, false, null, null);
    }

    public void G(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
        if (f63889i) {
            Log.d("UBCBehaviorProcessor", "uploadData:" + str);
            Log.d("UBCDEBUG", jSONObject.toString());
        }
        boolean z2 = true;
        s o = o();
        if (o != null && !o.a()) {
            z2 = false;
        }
        if (z2) {
            this.f63892c.execute(new RunnableC1766d(jSONObject, str, z, oVar, uVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, o oVar, u uVar) {
        G(jSONObject, null, z, oVar, uVar);
    }

    public void I(String str, boolean z) {
        this.f63891b.execute(new g(z, str));
    }

    public void J() {
        this.f63891b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f63893d != null && this.f63893d.w(str)) {
                kVar.a(true);
            }
            this.f63891b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f63893d != null && this.f63893d.w(str)) {
                kVar.a(true);
            }
            this.f63891b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f63891b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f63895f, i2);
        d.a.m0.g gVar = this.f63893d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().c(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.a.m0.g gVar2 = this.f63893d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.m0.g gVar3 = this.f63893d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.a.m0.g gVar4 = this.f63893d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f63891b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f63891b.execute(new c());
    }

    public String r(String str) {
        d.a.m0.c cVar = this.f63894e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f63890a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f63890a = context;
        } else {
            this.f63890a = context.getApplicationContext();
        }
        this.f63895f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f63891b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f63892c = Executors.newSingleThreadExecutor();
        this.f63897h = (w) ServiceManager.getService(w.f64001a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f63891b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f63891b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f63891b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f63891b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f63891b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f63891b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f63891b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public o f63915e;

        /* renamed from: f  reason: collision with root package name */
        public String f63916f;

        public i(String str, String str2, int i2) {
            this.f63915e = new o(str, str2, i2);
            this.f63916f = str;
        }

        public final boolean a(String str, int i2) {
            if ((i2 & 16) == 0 || UBC.getUBCContext().c(str)) {
                if (d.this.f63893d == null || d.this.f63893d.g(str, i2)) {
                    if (d.this.f63893d == null || !d.this.f63893d.v(str)) {
                        if (d.this.f63893d == null || !d.this.f63893d.h(str)) {
                            return d.this.f63893d == null || !d.this.f63893d.d(str);
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
            o oVar = this.f63915e;
            if (oVar == null) {
                return;
            }
            String g2 = oVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f63915e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f63915e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f63897h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f63897h.a(g2, b2);
        }

        public void c(boolean z) {
            o oVar = this.f63915e;
            if (oVar != null) {
                oVar.n(z);
            }
        }

        public void d(String str) {
            o oVar = this.f63915e;
            if (oVar != null) {
                oVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f63897h != null && d.this.f63893d != null && d.this.f63893d.b(this.f63916f) == 1) {
                b();
            }
            if (this.f63915e.e() == -1) {
                if (!a(this.f63915e.g(), this.f63915e.i())) {
                    return;
                }
                if (d.this.f63893d != null && d.this.f63893d.w(this.f63915e.g())) {
                    c(true);
                }
            }
            this.f63915e.o();
            String g2 = this.f63915e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f63893d != null) {
                String i2 = d.this.f63893d.i(g2);
                if (!TextUtils.isEmpty(i2)) {
                    this.f63915e.m(i2);
                }
            }
            if (d.this.f63897h != null && d.this.f63893d != null && d.this.f63893d.b(this.f63916f) == 2) {
                b();
            }
            if (this.f63915e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f63894e.y(this.f63915e);
            } else if ((this.f63915e.i() & 8) != 0) {
                d.this.f63894e.x(this.f63915e);
            } else if (this.f63915e == null || d.this.f63893d == null || !d.this.f63893d.f(g2)) {
                d.this.f63894e.w(this.f63915e);
            } else {
                d.this.f63894e.Q(this.f63915e);
            }
        }

        public i(String str, JSONObject jSONObject, int i2) {
            this.f63915e = new o(str, jSONObject, i2);
            this.f63916f = str;
        }

        public i(String str, String str2, int i2, String str3, int i3) {
            this.f63915e = new o(str, str2, i2, str3, i3);
            this.f63916f = str;
        }

        public i(String str, String str2, int i2, String str3, long j, int i3) {
            this.f63915e = new o(str, str2, i2, str3, j, i3);
            this.f63916f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public q f63921e;

        public k(Flow flow, String str) {
            q qVar = new q(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f63921e = qVar;
            qVar.m(flow.getStartTime());
            this.f63921e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            q qVar = this.f63921e;
            if (qVar != null) {
                qVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63894e == null) {
                if (d.f63889i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f63921e.r();
            if (!TextUtils.isEmpty(d.this.f63893d.i(this.f63921e.g()))) {
                this.f63921e.n(d.this.f63893d.i(this.f63921e.g()));
            }
            d.this.f63894e.D(this.f63921e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f63895f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            q qVar = new q(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f63921e = qVar;
            qVar.m(flow.getStartTime());
            this.f63921e.w("1");
            d.i(d.this);
        }
    }
}
