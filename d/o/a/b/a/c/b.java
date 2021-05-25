package d.o.a.b.a.c;

import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import d.o.a.a.a.c.d;
import d.o.a.b.a.a.a;
import d.o.a.b.a.a.b;
import d.o.a.b.a.a.c;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements a {
    public int A;
    public String B;
    public boolean C;
    public String D;
    public boolean E;
    public boolean F;
    public String G;
    public String H;
    public boolean I;
    public boolean J;
    public final AtomicBoolean K;
    public final AtomicBoolean L;
    public int M;
    public int N;
    public long O;
    public long P;
    public boolean Q;
    public boolean R;
    public String S;
    public boolean T;
    public boolean U;
    public long V;
    public transient boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public long f66650a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public long f66651b;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public String f66652c;

    /* renamed from: d  reason: collision with root package name */
    public int f66653d;

    /* renamed from: e  reason: collision with root package name */
    public String f66654e;

    /* renamed from: f  reason: collision with root package name */
    public String f66655f;

    /* renamed from: g  reason: collision with root package name */
    public String f66656g;

    /* renamed from: h  reason: collision with root package name */
    public String f66657h;

    /* renamed from: i  reason: collision with root package name */
    public int f66658i;
    public int j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public long q;
    public JSONObject r;
    public int s;
    public boolean t;
    public int u;
    public int v;
    public long w;
    public long x;
    public long y;
    public int z;

    public b() {
        this.f66653d = 1;
        this.p = true;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.C = false;
        this.E = false;
        this.F = true;
        this.K = new AtomicBoolean(false);
        this.L = new AtomicBoolean(false);
        this.N = 1;
        this.Q = true;
        this.V = -1L;
    }

    public static b i0(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            bVar.s0(d.o.a.a.a.e.a.a(jSONObject, "mId"));
            bVar.w0(d.o.a.a.a.e.a.a(jSONObject, "mExtValue"));
            bVar.p0(jSONObject.optString("mLogExtra"));
            bVar.v0(jSONObject.optInt("mDownloadStatus"));
            bVar.l0(jSONObject.optString("mPackageName"));
            bVar.a0(jSONObject.optBoolean("mIsAd"));
            bVar.A0(d.o.a.a.a.e.a.a(jSONObject, "mTimeStamp"));
            bVar.z0(jSONObject.optInt("mVersionCode"));
            bVar.t0(jSONObject.optString("mVersionName"));
            bVar.D0(jSONObject.optInt("mDownloadId"));
            bVar.m0(jSONObject.optBoolean("mIsV3Event"));
            bVar.H0(jSONObject.optInt("mScene"));
            bVar.B0(jSONObject.optString("mEventTag"));
            bVar.F0(jSONObject.optString("mEventRefer"));
            bVar.J0(jSONObject.optString("mDownloadUrl"));
            bVar.q0(jSONObject.optBoolean("mEnableBackDialog"));
            bVar.K.set(jSONObject.optBoolean("hasSendInstallFinish"));
            bVar.L.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            bVar.r0(jSONObject.optInt("mLastFailedErrCode"));
            bVar.Y(jSONObject.optString("mLastFailedErrMsg"));
            bVar.N0(jSONObject.optString("mOpenUrl"));
            bVar.P0(jSONObject.optInt("mLinkMode"));
            bVar.S0(jSONObject.optInt("mDownloadMode"));
            bVar.V0(jSONObject.optInt("mModelType"));
            bVar.Q0(jSONObject.optString("mAppName"));
            bVar.T0(jSONObject.optString("mAppIcon"));
            bVar.W(jSONObject.optInt("mDownloadFailedTimes", 0));
            bVar.X(d.o.a.a.a.e.a.a(jSONObject, "mRecentDownloadResumeTime"));
            bVar.j0(jSONObject.optInt("mClickPauseTimes"));
            bVar.k0(d.o.a.a.a.e.a.a(jSONObject, "mJumpInstallTime"));
            bVar.o0(d.o.a.a.a.e.a.a(jSONObject, "mCancelInstallTime"));
            bVar.n0(jSONObject.optInt("mLastFailedResumeCount"));
            bVar.W0(jSONObject.optString("downloadFinishReason"));
            bVar.M0(jSONObject.optLong("clickDownloadSize"));
            bVar.I0(jSONObject.optLong("clickDownloadTime"));
            bVar.K0(jSONObject.optBoolean("mIsUpdateDownload"));
            bVar.Y0(jSONObject.optString("mOriginMimeType"));
            bVar.O0(jSONObject.optBoolean("mIsPatchApplyHandled"));
            bVar.C0(jSONObject.optBoolean("installAfterCleanSpace"));
            bVar.L0(jSONObject.optInt("funnelType", 1));
            bVar.x0(jSONObject.optString(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL));
            bVar.c1(jSONObject.optBoolean("enableShowComplianceDialog", true));
            bVar.d1(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            bVar.e1(jSONObject.optInt("enable_new_activity") == 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            bVar.Z(jSONObject.optJSONObject("mExtras"));
        } catch (Exception unused) {
            bVar.Z(null);
        }
        return bVar;
    }

    public String A() {
        return this.B;
    }

    public void A0(long j) {
        if (j > 0) {
            this.q = j;
        }
    }

    public int B() {
        return this.f66653d;
    }

    public void B0(String str) {
        this.G = str;
    }

    public long C() {
        return this.q;
    }

    public void C0(boolean z) {
        this.J = z;
    }

    public int D() {
        return this.l;
    }

    public void D0(int i2) {
        this.s = i2;
    }

    public String E() {
        return this.m;
    }

    public void E0(long j) {
        this.V = j;
    }

    public int F() {
        return this.M;
    }

    public void F0(String str) {
        this.H = str;
    }

    public boolean G() {
        return this.t;
    }

    public void G0(boolean z) {
        this.U = z;
    }

    public long H() {
        return this.V;
    }

    public void H0(int i2) {
        this.M = i2;
    }

    public String I() {
        return this.n;
    }

    public void I0(long j) {
        this.O = j;
    }

    public int J() {
        return this.j;
    }

    public void J0(String str) {
        this.f66655f = str;
    }

    public String K() {
        return this.S;
    }

    public void K0(boolean z) {
        this.C = z;
    }

    public boolean L() {
        return this.T;
    }

    public void L0(int i2) {
        this.N = i2;
    }

    public boolean M() {
        return this.J;
    }

    public void M0(long j) {
        this.P = j;
    }

    public boolean N() {
        return this.U;
    }

    public void N0(String str) {
        this.f66656g = str;
    }

    public long O() {
        return this.O;
    }

    public void O0(boolean z) {
        this.E = z;
    }

    public long P() {
        return this.P;
    }

    public void P0(int i2) {
        this.j = i2;
    }

    public boolean Q() {
        return this.C;
    }

    public void Q0(String str) {
        this.n = str;
    }

    public String R() {
        return this.D;
    }

    public void R0(boolean z) {
        this.W = z;
    }

    public boolean S() {
        return this.E;
    }

    public void S0(int i2) {
        this.k = i2;
    }

    public boolean T() {
        return this.W;
    }

    public void T0(String str) {
        this.o = str;
    }

    public boolean U() {
        return this.X;
    }

    public void U0(boolean z) {
        this.X = z;
    }

    public boolean V() {
        return this.Z;
    }

    public void V0(int i2) {
        this.f66658i = i2;
    }

    public void W(int i2) {
        this.u = i2;
    }

    public void W0(String str) {
        this.S = str;
    }

    public void X(long j) {
        this.w = j;
    }

    public void X0(boolean z) {
        this.Z = z;
    }

    public void Y(String str) {
        this.B = str;
    }

    public void Y0(String str) {
        this.D = str;
    }

    public void Z(JSONObject jSONObject) {
        this.r = jSONObject;
    }

    public void Z0(boolean z) {
        this.Y = z;
    }

    @Override // d.o.a.b.a.c.a
    public String a() {
        return this.f66655f;
    }

    public void a0(boolean z) {
        this.p = z;
    }

    public void a1(boolean z) {
        this.a0 = z;
    }

    @Override // d.o.a.b.a.c.a
    public long b() {
        return this.f66650a;
    }

    public boolean b0() {
        return this.Y;
    }

    public void b1(boolean z) {
        this.b0 = z;
    }

    @Override // d.o.a.b.a.c.a
    public boolean c() {
        return this.p;
    }

    public boolean c0() {
        return this.a0;
    }

    public void c1(boolean z) {
        this.Q = z;
    }

    @Override // d.o.a.b.a.c.a
    public String d() {
        return this.f66652c;
    }

    public boolean d0() {
        return this.b0;
    }

    public void d1(boolean z) {
        this.R = z;
    }

    @Override // d.o.a.b.a.c.a
    public String e() {
        return this.f66654e;
    }

    public JSONObject e0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f66650a);
            jSONObject.put("mExtValue", this.f66651b);
            jSONObject.put("mLogExtra", this.f66652c);
            jSONObject.put("mDownloadStatus", this.f66653d);
            jSONObject.put("mPackageName", this.f66654e);
            jSONObject.put("mIsAd", this.p);
            jSONObject.put("mTimeStamp", this.q);
            jSONObject.put("mExtras", this.r);
            jSONObject.put("mVersionCode", this.l);
            jSONObject.put("mVersionName", this.m);
            jSONObject.put("mDownloadId", this.s);
            jSONObject.put("mIsV3Event", this.I);
            jSONObject.put("mScene", this.M);
            jSONObject.put("mEventTag", this.G);
            jSONObject.put("mEventRefer", this.H);
            jSONObject.put("mDownloadUrl", this.f66655f);
            jSONObject.put("mEnableBackDialog", this.t);
            jSONObject.put("hasSendInstallFinish", this.K.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.L.get());
            jSONObject.put("mLastFailedErrCode", this.A);
            jSONObject.put("mLastFailedErrMsg", this.B);
            jSONObject.put("mOpenUrl", this.f66656g);
            jSONObject.put("mLinkMode", this.j);
            jSONObject.put("mDownloadMode", this.k);
            jSONObject.put("mModelType", this.f66658i);
            jSONObject.put("mAppName", this.n);
            jSONObject.put("mAppIcon", this.o);
            jSONObject.put("mDownloadFailedTimes", this.u);
            jSONObject.put("mRecentDownloadResumeTime", this.w == 0 ? this.q : this.w);
            jSONObject.put("mClickPauseTimes", this.v);
            jSONObject.put("mJumpInstallTime", this.x);
            jSONObject.put("mCancelInstallTime", this.y);
            jSONObject.put("mLastFailedResumeCount", this.z);
            jSONObject.put("mIsUpdateDownload", this.C);
            jSONObject.put("mOriginMimeType", this.D);
            jSONObject.put("mIsPatchApplyHandled", this.E);
            jSONObject.put("downloadFinishReason", this.S);
            jSONObject.put("clickDownloadTime", this.O);
            jSONObject.put("clickDownloadSize", this.P);
            jSONObject.put("installAfterCleanSpace", this.J);
            jSONObject.put("funnelType", this.N);
            jSONObject.put(BaiduAppJsBridgeHandler.INPUT_PARAM_WEB_URL, this.f66657h);
            jSONObject.put("enableShowComplianceDialog", this.Q);
            jSONObject.put("isAutoDownloadOnCardShow", this.R);
            jSONObject.put("enable_new_activity", this.F ? 1 : 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void e1(boolean z) {
        this.F = z;
    }

    @Override // d.o.a.b.a.c.a
    public String f() {
        return this.f66656g;
    }

    public c f0() {
        c.b bVar = new c.b();
        bVar.k(this.f66650a);
        bVar.s(this.f66651b);
        bVar.m(this.f66652c);
        bVar.t(this.f66654e);
        bVar.n(this.r);
        bVar.o(this.p);
        bVar.r(this.l);
        bVar.F(this.m);
        bVar.z(this.f66655f);
        bVar.j(this.f66658i);
        bVar.D(this.D);
        bVar.B(this.n);
        bVar.v(this.o);
        bVar.l(new d.o.a.a.a.d.b(this.f66656g, this.f66657h, null));
        return bVar.p();
    }

    public int f1() {
        return this.u;
    }

    @Override // d.o.a.b.a.c.a
    public JSONObject g() {
        return this.r;
    }

    public d.o.a.b.a.a.b g0() {
        b.C1862b c1862b = new b.C1862b();
        c1862b.b(this.G);
        c1862b.v(this.H);
        c1862b.j(this.I);
        return c1862b.d();
    }

    public synchronized void g1() {
        this.u++;
    }

    @Override // d.o.a.b.a.c.a
    public int h() {
        return this.N;
    }

    public d.o.a.b.a.a.a h0() {
        a.b bVar = new a.b();
        bVar.d(this.t);
        bVar.b(this.j);
        bVar.g(this.k);
        bVar.m(this.Q);
        return bVar.e();
    }

    public int h1() {
        return this.v;
    }

    @Override // d.o.a.b.a.c.a
    public String i() {
        return this.H;
    }

    public synchronized void i1() {
        this.v++;
    }

    @Override // d.o.a.b.a.c.a
    public String j() {
        return this.G;
    }

    public void j0(int i2) {
        this.v = i2;
    }

    @Override // d.o.a.b.a.c.a
    public JSONObject k() {
        return null;
    }

    public void k0(long j) {
        this.x = j;
    }

    @Override // d.o.a.b.a.c.a
    public long l() {
        return this.f66651b;
    }

    public void l0(String str) {
        this.f66654e = str;
    }

    @Override // d.o.a.b.a.c.a
    public boolean m() {
        return this.I;
    }

    public void m0(boolean z) {
        this.I = z;
    }

    @Override // d.o.a.b.a.c.a
    public List<String> n() {
        return null;
    }

    public void n0(int i2) {
        this.z = i2;
    }

    @Override // d.o.a.b.a.c.a
    public Object o() {
        return null;
    }

    public void o0(long j) {
        this.y = j;
    }

    @Override // d.o.a.b.a.c.a
    public JSONObject p() {
        return null;
    }

    public void p0(String str) {
        this.f66652c = str;
    }

    @Override // d.o.a.b.a.c.a
    public boolean q() {
        return this.F;
    }

    public void q0(boolean z) {
        this.t = z;
    }

    @Override // d.o.a.b.a.c.a
    public JSONObject r() {
        return null;
    }

    public void r0(int i2) {
        this.A = i2;
    }

    @Override // d.o.a.b.a.c.a
    public int s() {
        return this.s;
    }

    public void s0(long j) {
        this.f66650a = j;
    }

    @Override // d.o.a.b.a.c.a
    public d t() {
        return f0();
    }

    public void t0(String str) {
        this.m = str;
    }

    @Override // d.o.a.b.a.c.a
    public d.o.a.a.a.c.c u() {
        return g0();
    }

    public void u0(boolean z) {
    }

    @Override // d.o.a.b.a.c.a
    public d.o.a.a.a.c.b v() {
        return h0();
    }

    public void v0(int i2) {
        this.f66653d = i2;
    }

    public long w() {
        long j = this.w;
        return j == 0 ? this.q : j;
    }

    public void w0(long j) {
        this.f66651b = j;
    }

    public long x() {
        return this.x;
    }

    public void x0(String str) {
        this.f66657h = str;
    }

    public int y() {
        return this.z;
    }

    public void y0(boolean z) {
        this.T = z;
    }

    public int z() {
        return this.A;
    }

    public void z0(int i2) {
        this.l = i2;
    }

    public b(d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar) {
        this(dVar, cVar, bVar, 0);
    }

    public b(d dVar, d.o.a.a.a.c.c cVar, d.o.a.a.a.c.b bVar, int i2) {
        this.f66653d = 1;
        this.p = true;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.C = false;
        this.E = false;
        this.F = true;
        this.K = new AtomicBoolean(false);
        this.L = new AtomicBoolean(false);
        this.N = 1;
        this.Q = true;
        this.V = -1L;
        this.f66650a = dVar.d();
        this.f66651b = dVar.g();
        this.f66652c = dVar.u();
        this.f66654e = dVar.v();
        this.r = dVar.z();
        this.p = dVar.t();
        this.l = dVar.r();
        this.m = dVar.s();
        this.f66655f = dVar.a();
        if (dVar.x() != null) {
            this.f66656g = dVar.x().d();
            this.f66657h = dVar.x().a();
        }
        this.f66658i = dVar.A();
        this.n = dVar.h();
        this.o = dVar.w();
        this.D = dVar.i();
        this.G = cVar.b();
        this.H = cVar.a();
        this.I = cVar.m();
        this.t = bVar.c();
        this.j = bVar.a();
        this.k = bVar.b();
        this.Q = bVar.e();
        this.R = bVar.f();
        this.F = bVar.g();
        this.s = i2;
        long currentTimeMillis = System.currentTimeMillis();
        this.q = currentTimeMillis;
        this.w = currentTimeMillis;
        this.E = dVar.E();
    }
}
