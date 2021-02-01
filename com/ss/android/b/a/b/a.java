package com.ss.android.b.a.b;

import android.text.TextUtils;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.b.a.a.a;
import com.ss.android.b.a.a.b;
import com.ss.android.b.a.a.c;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private int A;
    private String B;
    private boolean C;
    private String D;
    private boolean E;
    private String F;
    private String G;
    private boolean H;
    private String I;
    private boolean J;
    private String K;
    private boolean L;
    private long M;
    private transient boolean N;
    private int O;
    private long P;
    private long Q;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f12922a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f12923b;
    private long c;
    private long d;
    private String e;
    private int f;
    private String g;
    private String h;
    private String i;
    private int j;
    private int k;
    private int l;
    private int m;
    private String n;
    private String o;
    private boolean p;
    private long q;
    private JSONObject r;
    private int s;
    private boolean t;
    private int u;
    private int v;
    private long w;
    private long x;
    private long y;
    private int z;

    private a() {
        this.f = 1;
        this.p = true;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.C = false;
        this.E = false;
        this.f12922a = new AtomicBoolean(false);
        this.f12923b = new AtomicBoolean(false);
        this.M = -1L;
    }

    public a(c cVar, b bVar, com.ss.android.a.a.b.a aVar) {
        this(cVar, bVar, aVar, 0);
    }

    public a(c cVar, b bVar, com.ss.android.a.a.b.a aVar, int i) {
        this.f = 1;
        this.p = true;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.C = false;
        this.E = false;
        this.f12922a = new AtomicBoolean(false);
        this.f12923b = new AtomicBoolean(false);
        this.M = -1L;
        this.c = cVar.d();
        this.d = cVar.g();
        this.e = cVar.u();
        this.g = cVar.v();
        this.r = cVar.eDX();
        this.p = cVar.t();
        this.m = cVar.r();
        this.n = cVar.s();
        this.h = cVar.a();
        if (cVar.eDV() != null) {
            this.i = cVar.eDV().a();
        }
        this.j = cVar.A();
        this.o = cVar.h();
        this.I = cVar.i();
        this.F = bVar.b();
        this.G = bVar.a();
        this.H = bVar.m();
        this.t = aVar.c();
        this.k = aVar.a();
        this.l = aVar.b();
        this.s = i;
        this.q = System.currentTimeMillis();
        this.w = this.q;
        this.D = cVar.i();
        this.E = cVar.E();
    }

    public int a() {
        return this.u;
    }

    public void a(int i) {
        this.u = i;
    }

    public synchronized void b() {
        this.u++;
    }

    public int c() {
        return this.v;
    }

    public void b(int i) {
        this.v = i;
    }

    public synchronized void d() {
        this.v++;
    }

    public long e() {
        return this.w == 0 ? this.q : this.w;
    }

    public void a(long j) {
        this.w = j;
    }

    public long f() {
        return this.x;
    }

    public void b(long j) {
        this.x = j;
    }

    public void c(long j) {
        this.y = j;
    }

    public int g() {
        return this.z;
    }

    public void c(int i) {
        this.z = i;
    }

    public int h() {
        return this.A;
    }

    public void d(int i) {
        this.A = i;
    }

    public String i() {
        return this.B;
    }

    public void a(String str) {
        this.B = str;
    }

    public long j() {
        return this.c;
    }

    public void d(long j) {
        this.c = j;
    }

    public long k() {
        return this.d;
    }

    public void e(long j) {
        this.d = j;
    }

    public int l() {
        return this.f;
    }

    public void e(int i) {
        this.f = i;
    }

    public String m() {
        return this.g;
    }

    public void b(String str) {
        this.g = str;
    }

    public long n() {
        return this.q;
    }

    public void f(long j) {
        if (j > 0) {
            this.q = j;
        }
    }

    public String o() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public boolean p() {
        return this.p;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public JSONObject q() {
        return this.r;
    }

    public void a(JSONObject jSONObject) {
        this.r = jSONObject;
    }

    public void f(int i) {
        this.m = i;
    }

    public void d(String str) {
        this.n = str;
    }

    public int r() {
        return this.m;
    }

    public String s() {
        return this.n;
    }

    public void g(int i) {
        this.s = i;
    }

    public int t() {
        return this.s;
    }

    public void b(boolean z) {
        this.H = z;
    }

    public boolean u() {
        return this.H;
    }

    public void h(int i) {
        this.O = i;
    }

    public int v() {
        return this.O;
    }

    public void c(boolean z) {
        this.t = z;
    }

    public boolean w() {
        return this.t;
    }

    public void e(String str) {
        this.F = str;
    }

    public String x() {
        return this.F;
    }

    public void f(String str) {
        this.G = str;
    }

    public String y() {
        return this.G;
    }

    public void g(String str) {
        this.h = str;
    }

    public String z() {
        return this.h;
    }

    public void h(String str) {
        this.i = str;
    }

    public String A() {
        return this.i;
    }

    public void g(long j) {
        this.M = j;
    }

    public long eEh() {
        return this.M;
    }

    public void i(String str) {
        this.o = str;
    }

    public String C() {
        return this.o;
    }

    public void i(int i) {
        this.k = i;
    }

    public int D() {
        return this.k;
    }

    public void j(int i) {
        this.l = i;
    }

    public void k(int i) {
        this.j = i;
    }

    public void d(boolean z) {
        this.J = z;
    }

    public String E() {
        return this.K;
    }

    public void j(String str) {
        this.K = str;
    }

    public boolean F() {
        return this.L;
    }

    public void e(boolean z) {
        this.L = z;
    }

    public long eEi() {
        return this.P;
    }

    public void h(long j) {
        this.P = j;
    }

    public long eEj() {
        return this.Q;
    }

    public void ja(long j) {
        this.Q = j;
    }

    public void k(String str) {
        this.I = str;
    }

    public boolean I() {
        return this.C;
    }

    public void f(boolean z) {
        this.C = z;
    }

    public String J() {
        return this.D;
    }

    public void l(String str) {
        this.D = str;
    }

    public boolean K() {
        return this.E;
    }

    public void g(boolean z) {
        this.E = z;
    }

    public boolean L() {
        return this.N;
    }

    public void h(boolean z) {
        this.N = z;
    }

    public JSONObject eEk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.c);
            jSONObject.put("mExtValue", this.d);
            jSONObject.put("mLogExtra", this.e);
            jSONObject.put("mDownloadStatus", this.f);
            jSONObject.put("mPackageName", this.g);
            jSONObject.put("mIsAd", this.p);
            jSONObject.put("mTimeStamp", this.q);
            jSONObject.put("mExtras", this.r);
            jSONObject.put("mVersionCode", this.m);
            jSONObject.put("mVersionName", this.n);
            jSONObject.put("mDownloadId", this.s);
            jSONObject.put("mIsV3Event", this.H);
            jSONObject.put("mScene", this.O);
            jSONObject.put("mEventTag", this.F);
            jSONObject.put("mEventRefer", this.G);
            jSONObject.put("mDownloadUrl", this.h);
            jSONObject.put("mEnableBackDialog", this.t);
            jSONObject.put("hasSendInstallFinish", this.f12922a.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.f12923b.get());
            jSONObject.put("mLastFailedErrCode", this.A);
            jSONObject.put("mLastFailedErrMsg", this.B);
            jSONObject.put("mOpenUrl", this.i);
            jSONObject.put("mLinkMode", this.k);
            jSONObject.put("mDownloadMode", this.l);
            jSONObject.put("mModelType", this.j);
            jSONObject.put("mAppName", this.o);
            jSONObject.put("mDownloadFailedTimes", this.u);
            jSONObject.put("mRecentDownloadResumeTime", this.w == 0 ? this.q : this.w);
            jSONObject.put("mClickPauseTimes", this.v);
            jSONObject.put("mJumpInstallTime", this.x);
            jSONObject.put("mCancelInstallTime", this.y);
            jSONObject.put("mLastFailedResumeCount", this.z);
            jSONObject.put("mIsUpdateDownload", this.C);
            jSONObject.put("mOriginMimeType", this.D);
            jSONObject.put("mIsPatchApplyHandled", this.E);
            jSONObject.put("downloadFinishReason", this.K);
            jSONObject.put("clickDownloadTime", this.P);
            jSONObject.put("clickDownloadSize", this.Q);
            jSONObject.put("mMimeType", this.I);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static a fc(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.d(com.ss.android.a.a.e.a.C(jSONObject, "mId"));
            aVar.e(com.ss.android.a.a.e.a.C(jSONObject, "mExtValue"));
            aVar.c(jSONObject.optString("mLogExtra"));
            aVar.e(jSONObject.optInt("mDownloadStatus"));
            aVar.b(jSONObject.optString("mPackageName"));
            aVar.a(jSONObject.optBoolean("mIsAd"));
            aVar.f(com.ss.android.a.a.e.a.C(jSONObject, "mTimeStamp"));
            aVar.f(jSONObject.optInt("mVersionCode"));
            aVar.d(jSONObject.optString("mVersionName"));
            aVar.g(jSONObject.optInt("mDownloadId"));
            aVar.b(jSONObject.optBoolean("mIsV3Event"));
            aVar.h(jSONObject.optInt("mScene"));
            aVar.e(jSONObject.optString("mEventTag"));
            aVar.f(jSONObject.optString("mEventRefer"));
            aVar.g(jSONObject.optString("mDownloadUrl"));
            aVar.c(jSONObject.optBoolean("mEnableBackDialog"));
            aVar.f12922a.set(jSONObject.optBoolean("hasSendInstallFinish"));
            aVar.f12923b.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            aVar.d(jSONObject.optInt("mLastFailedErrCode"));
            aVar.a(jSONObject.optString("mLastFailedErrMsg"));
            aVar.h(jSONObject.optString("mOpenUrl"));
            aVar.i(jSONObject.optInt("mLinkMode"));
            aVar.j(jSONObject.optInt("mDownloadMode"));
            aVar.k(jSONObject.optInt("mModelType"));
            aVar.i(jSONObject.optString("mAppName"));
            aVar.a(jSONObject.optInt("mDownloadFailedTimes", 0));
            aVar.a(com.ss.android.a.a.e.a.C(jSONObject, "mRecentDownloadResumeTime"));
            aVar.b(jSONObject.optInt("mClickPauseTimes"));
            aVar.b(com.ss.android.a.a.e.a.C(jSONObject, "mJumpInstallTime"));
            aVar.c(com.ss.android.a.a.e.a.C(jSONObject, "mCancelInstallTime"));
            aVar.c(jSONObject.optInt("mLastFailedResumeCount"));
            aVar.j(jSONObject.optString("downloadFinishReason"));
            aVar.ja(jSONObject.optLong("clickDownloadSize"));
            aVar.h(jSONObject.optLong("clickDownloadTime"));
            aVar.k(jSONObject.optString("mMimeType"));
            aVar.f(jSONObject.optBoolean("mIsUpdateDownload"));
            aVar.l(jSONObject.optString("mOriginMimeType"));
            aVar.g(jSONObject.optBoolean("mIsPatchApplyHandled"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            aVar.a(jSONObject.optJSONObject("mExtras"));
        } catch (Exception e2) {
            aVar.a((JSONObject) null);
        }
        return aVar;
    }

    public com.ss.android.b.a.a.c eEl() {
        c.a aaC = new c.a().iY(this.c).iZ(this.d).aay(this.e).aaz(this.g).fb(this.r).BT(this.p).QR(this.m).aaE(this.n).aaB(this.h).QQ(this.j).aaD(this.I).aaC(this.o);
        if (!TextUtils.isEmpty(this.i)) {
            aaC.a(new com.ss.android.a.a.d.b(this.i, null, null));
        }
        return aaC.eEg();
    }

    public com.ss.android.b.a.a.b eEm() {
        return new b.a().aan(this.F).aav(this.G).BS(this.H).eEf();
    }

    public com.ss.android.b.a.a.a eEn() {
        return new a.C1218a().BM(this.t).QN(this.k).QO(this.l).eEe();
    }
}
