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
    public Context f63884a;

    /* renamed from: b  reason: collision with root package name */
    public ScheduledExecutorService f63885b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f63886c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.k0.g f63887d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.k0.c f63888e;

    /* renamed from: f  reason: collision with root package name */
    public int f63889f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63890g = false;

    /* renamed from: h  reason: collision with root package name */
    public v f63891h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                return;
            }
            d.this.f63888e.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "upload#ubc init not finish");
                    return;
                }
                return;
            }
            if (Math.abs(System.currentTimeMillis() - g0.e().getLong("ubc_last_upload_all_time", 0L)) < VideoCloudSetting.HOUR_MILLISECOND) {
                return;
            }
            d.this.f63888e.L();
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
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "saveCache#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63888e.m();
        }
    }

    /* renamed from: d.b.k0.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1732d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f63895e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63896f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f63897g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.k0.n f63898h;
        public final /* synthetic */ t i;

        public RunnableC1732d(JSONObject jSONObject, String str, boolean z, d.b.k0.n nVar, t tVar) {
            this.f63895e = jSONObject;
            this.f63896f = str;
            this.f63897g = z;
            this.f63898h = nVar;
            this.i = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63888e.H(this.f63895e, this.f63896f, this.f63897g, this.f63898h, this.i);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63888e.t();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "sendQualityData#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63888e.A();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f63901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63902f;

        public g(boolean z, String str) {
            this.f63901e = z;
            this.f63902f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "uploadFailedData#ubc init not finish");
                }
            } else if (this.f63901e) {
                d.this.f63888e.K(this.f63902f);
            } else {
                d.this.f63888e.J(this.f63902f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public w f63904e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f63905f;

        /* renamed from: g  reason: collision with root package name */
        public s f63906g;

        public h(w wVar, boolean z, s sVar) {
            this.f63904e = wVar;
            this.f63905f = z;
            this.f63906g = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63888e.F(this.f63904e, this.f63905f, this.f63906g);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63911e;

        /* renamed from: f  reason: collision with root package name */
        public int f63912f;

        public j(String str, int i) {
            this.f63911e = str;
            this.f63912f = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63888e.h(this.f63911e, this.f63912f);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63916e;

        /* renamed from: f  reason: collision with root package name */
        public int f63917f;

        /* renamed from: g  reason: collision with root package name */
        public long f63918g = System.currentTimeMillis();

        /* renamed from: h  reason: collision with root package name */
        public JSONArray f63919h;

        public l(String str, int i, JSONArray jSONArray) {
            this.f63916e = str;
            this.f63917f = i;
            this.f63919h = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63888e.l(this.f63916e, this.f63917f, this.f63918g, this.f63919h);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f63920e;

        /* renamed from: f  reason: collision with root package name */
        public int f63921f;

        /* renamed from: g  reason: collision with root package name */
        public String f63922g;

        public m(String str, int i, String str2) {
            this.f63920e = str;
            this.f63921f = i;
            this.f63922g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            d.this.f63888e.G(this.f63920e, this.f63921f, this.f63922g);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            d.this.f63887d = d.b.k0.g.m();
            d.this.f63888e = new d.b.k0.c(d.this.f63884a);
            d.this.f63888e.C();
        }

        public /* synthetic */ n(d dVar, a aVar) {
            this();
        }
    }

    public d() {
        s(UBC.getContext());
    }

    public static /* synthetic */ int i(d dVar) {
        int i2 = dVar.f63889f;
        dVar.f63889f = i2 + 1;
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
        this.f63885b.execute(new f());
    }

    public void B(w wVar, boolean z, s sVar) {
        this.f63885b.execute(new h(wVar, z, sVar));
    }

    public void C(String str, int i2, String str2) {
        this.f63885b.execute(new m(str, i2, str2));
    }

    public void D() {
        if (this.f63890g) {
            return;
        }
        this.f63890g = true;
        this.f63885b.execute(new b());
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
            this.f63886c.execute(new RunnableC1732d(jSONObject, str, z, nVar, tVar));
        }
    }

    public void H(JSONObject jSONObject, boolean z, d.b.k0.n nVar, t tVar) {
        G(jSONObject, null, z, nVar, tVar);
    }

    public void I(String str, boolean z) {
        this.f63885b.execute(new g(z, str));
    }

    public void J() {
        this.f63885b.execute(new a());
    }

    public synchronized Flow j(String str, String str2, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, str2);
            if (this.f63887d != null && this.f63887d.w(str)) {
                kVar.a(true);
            }
            this.f63885b.execute(kVar);
        }
        return m2;
    }

    public synchronized Flow k(String str, JSONObject jSONObject, int i2) {
        Flow m2;
        m2 = m(str, i2);
        if (m2 != null && m2.getValid()) {
            k kVar = new k(m2, jSONObject);
            if (this.f63887d != null && this.f63887d.w(str)) {
                kVar.a(true);
            }
            this.f63885b.execute(kVar);
        }
        return m2;
    }

    public void l(String str, int i2) {
        this.f63885b.execute(new j(str, i2));
    }

    public Flow m(String str, int i2) {
        Flow flow = new Flow(str, this.f63889f, i2);
        d.b.k0.g gVar = this.f63887d;
        if (gVar != null && !gVar.g(str, i2)) {
            flow.setValid(false);
            return flow;
        } else if ((i2 & 16) != 0 && !UBC.getUBCContext().a(str)) {
            flow.setValid(false);
            return flow;
        } else {
            d.b.k0.g gVar2 = this.f63887d;
            if (gVar2 != null && gVar2.h(str)) {
                flow.setValid(false);
                return flow;
            }
            d.b.k0.g gVar3 = this.f63887d;
            if (gVar3 != null && gVar3.v(str)) {
                flow.setValid(false);
                return flow;
            }
            d.b.k0.g gVar4 = this.f63887d;
            if (gVar4 != null && !gVar4.x(str)) {
                flow.setValid(false);
            }
            return flow;
        }
    }

    public void n(String str, int i2, JSONArray jSONArray) {
        this.f63885b.execute(new l(str, i2, jSONArray));
    }

    public void p() {
        this.f63885b.execute(new c());
    }

    public String r(String str) {
        d.b.k0.c cVar = this.f63888e;
        return cVar != null ? cVar.p(str) : "";
    }

    public final void s(Context context) {
        if (this.f63884a != null || context == null) {
            return;
        }
        if (context instanceof Application) {
            this.f63884a = context;
        } else {
            this.f63884a = context.getApplicationContext();
        }
        this.f63889f = QuickPersistConfig.getInstance().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        this.f63885b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.execute(new n(this, null));
        this.f63886c = Executors.newSingleThreadExecutor();
        this.f63891h = (v) ServiceManager.getService(v.f63988a);
    }

    public void t(String str, String str2, String str3, int i2) {
        i iVar = new i(str, str2, i2);
        if (!TextUtils.isEmpty(str3)) {
            iVar.d(str3);
        }
        this.f63885b.execute(iVar);
    }

    public void u(String str, String str2, int i2) {
        this.f63885b.execute(new i(str, str2, i2));
    }

    public void v(String str, JSONObject jSONObject, int i2) {
        this.f63885b.execute(new i(str, jSONObject, i2));
    }

    public void w() {
        this.f63885b.execute(new e());
    }

    public void x(String str, String str2, int i2, String str3, int i3) {
        this.f63885b.execute(new i(str, str2, i2, str3, i3));
    }

    public void y(String str, String str2, int i2, String str3, long j2, int i3) {
        this.f63885b.execute(new i(str, str2, i2, str3, j2, i3));
    }

    public void z(Runnable runnable, long j2) {
        this.f63885b.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public d.b.k0.n f63908e;

        /* renamed from: f  reason: collision with root package name */
        public String f63909f;

        public i(String str, String str2, int i) {
            this.f63908e = new d.b.k0.n(str, str2, i);
            this.f63909f = str;
        }

        public final boolean a(String str, int i) {
            if ((i & 16) == 0 || UBC.getUBCContext().a(str)) {
                if (d.this.f63887d == null || d.this.f63887d.g(str, i)) {
                    if (d.this.f63887d == null || !d.this.f63887d.v(str)) {
                        if (d.this.f63887d == null || !d.this.f63887d.h(str)) {
                            return d.this.f63887d == null || !d.this.f63887d.d(str);
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
            d.b.k0.n nVar = this.f63908e;
            if (nVar == null) {
                return;
            }
            String g2 = nVar.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            String b2 = this.f63908e.b();
            if (TextUtils.isEmpty(b2) && (h2 = this.f63908e.h()) != null) {
                try {
                    b2 = h2.toString();
                } catch (ConcurrentModificationException e2) {
                    d.this.f63891h.b(g2, e2.toString());
                    return;
                }
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d.this.f63891h.a(g2, b2);
        }

        public void c(boolean z) {
            d.b.k0.n nVar = this.f63908e;
            if (nVar != null) {
                nVar.n(z);
            }
        }

        public void d(String str) {
            d.b.k0.n nVar = this.f63908e;
            if (nVar != null) {
                nVar.p(str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "EventRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            if (d.this.f63891h != null && d.this.f63887d != null && d.this.f63887d.b(this.f63909f) == 1) {
                b();
            }
            if (this.f63908e.e() == -1) {
                if (!a(this.f63908e.g(), this.f63908e.i())) {
                    return;
                }
                if (d.this.f63887d != null && d.this.f63887d.w(this.f63908e.g())) {
                    c(true);
                }
            }
            this.f63908e.o();
            String g2 = this.f63908e.g();
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            if (d.this.f63887d != null) {
                String i = d.this.f63887d.i(g2);
                if (!TextUtils.isEmpty(i)) {
                    this.f63908e.m(i);
                }
            }
            if (d.this.f63891h != null && d.this.f63887d != null && d.this.f63887d.b(this.f63909f) == 2) {
                b();
            }
            if (this.f63908e.e() == -1 && TextUtils.equals(g2, "1876")) {
                d.this.f63888e.y(this.f63908e);
            } else if ((this.f63908e.i() & 8) != 0) {
                d.this.f63888e.x(this.f63908e);
            } else if (this.f63908e == null || d.this.f63887d == null || !d.this.f63887d.f(g2)) {
                d.this.f63888e.w(this.f63908e);
            } else {
                d.this.f63888e.Q(this.f63908e);
            }
        }

        public i(String str, JSONObject jSONObject, int i) {
            this.f63908e = new d.b.k0.n(str, jSONObject, i);
            this.f63909f = str;
        }

        public i(String str, String str2, int i, String str3, int i2) {
            this.f63908e = new d.b.k0.n(str, str2, i, str3, i2);
            this.f63909f = str;
        }

        public i(String str, String str2, int i, String str3, long j, int i2) {
            this.f63908e = new d.b.k0.n(str, str2, i, str3, j, i2);
            this.f63909f = str;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public p f63914e;

        public k(Flow flow, String str) {
            p pVar = new p(flow.getId(), flow.getHandle(), str, flow.getOption());
            this.f63914e = pVar;
            pVar.m(flow.getStartTime());
            this.f63914e.w("1");
            d.i(d.this);
        }

        public void a(boolean z) {
            p pVar = this.f63914e;
            if (pVar != null) {
                pVar.p(z);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f63888e == null) {
                if (d.i) {
                    Log.d("UBCBehaviorProcessor", "FlowCreateRunnable#ubc init not finish");
                    return;
                }
                return;
            }
            this.f63914e.r();
            if (!TextUtils.isEmpty(d.this.f63887d.i(this.f63914e.g()))) {
                this.f63914e.n(d.this.f63887d.i(this.f63914e.g()));
            }
            d.this.f63888e.D(this.f63914e);
            QuickPersistConfig.getInstance().putInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, d.this.f63889f);
        }

        public k(Flow flow, JSONObject jSONObject) {
            p pVar = new p(flow.getId(), flow.getHandle(), jSONObject, flow.getOption());
            this.f63914e = pVar;
            pVar.m(flow.getStartTime());
            this.f63914e.w("1");
            d.i(d.this);
        }
    }
}
