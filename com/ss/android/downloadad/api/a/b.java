package com.ss.android.downloadad.api.a;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements a {
    public long A;
    public long B;
    public long C;
    public int D;
    public int E;
    public String F;
    public boolean G;
    public String H;
    public boolean I;
    public boolean J;
    public boolean K;
    public String L;
    public String M;
    public boolean N;
    public boolean O;
    public int P;
    @AdBaseConstants.FunnelType
    public int Q;
    public long R;
    public long S;
    public boolean T;
    public boolean U;
    public String V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public long Z;
    public boolean a;
    public transient boolean aa;
    public boolean ab;
    public boolean ac;
    public boolean ad;
    public boolean ae;
    public boolean af;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42679b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f42680c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f42681d;

    /* renamed from: e  reason: collision with root package name */
    public long f42682e;

    /* renamed from: f  reason: collision with root package name */
    public long f42683f;

    /* renamed from: g  reason: collision with root package name */
    public String f42684g;

    /* renamed from: h  reason: collision with root package name */
    public int f42685h;
    public String i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public int o;
    public int p;
    public String q;
    public String r;
    public String s;
    public boolean t;
    public long u;
    public JSONObject v;
    public int w;
    public boolean x;
    public int y;
    public int z;

    public b() {
        this.f42685h = 1;
        this.t = true;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.G = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.a = true;
        this.f42679b = true;
        this.f42680c = new AtomicBoolean(false);
        this.f42681d = new AtomicBoolean(false);
        this.Q = 1;
        this.T = true;
        this.Z = -1L;
    }

    public synchronized void A() {
        this.z++;
    }

    public long B() {
        long j = this.A;
        return j == 0 ? this.u : j;
    }

    public long C() {
        return this.B;
    }

    public int D() {
        return this.D;
    }

    public int E() {
        return this.E;
    }

    public String F() {
        return this.F;
    }

    public int G() {
        return this.f42685h;
    }

    public long H() {
        return this.u;
    }

    public int I() {
        return this.p;
    }

    public String J() {
        return this.q;
    }

    public int K() {
        return this.P;
    }

    public boolean L() {
        return this.x;
    }

    public long M() {
        return this.Z;
    }

    public String N() {
        return this.r;
    }

    public int O() {
        return this.n;
    }

    public String P() {
        return this.V;
    }

    public boolean Q() {
        return this.X;
    }

    public boolean R() {
        return this.O;
    }

    public boolean S() {
        return this.Y;
    }

    public long T() {
        return this.R;
    }

    public long U() {
        return this.S;
    }

    public boolean V() {
        return this.G;
    }

    public String W() {
        return this.H;
    }

    public boolean X() {
        return this.I;
    }

    public boolean Y() {
        return this.aa;
    }

    public boolean Z() {
        return this.ab;
    }

    public void a(int i) {
        this.y = i;
    }

    public boolean aa() {
        return this.ad;
    }

    public boolean ab() {
        return this.ac;
    }

    public boolean ac() {
        return this.ae;
    }

    public boolean ad() {
        return this.af;
    }

    public JSONObject ae() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f42682e);
            jSONObject.put("mExtValue", this.f42683f);
            jSONObject.put("mLogExtra", this.f42684g);
            jSONObject.put("mDownloadStatus", this.f42685h);
            jSONObject.put("mPackageName", this.i);
            jSONObject.put("mIsAd", this.t);
            jSONObject.put("mTimeStamp", this.u);
            jSONObject.put("mExtras", this.v);
            jSONObject.put("mVersionCode", this.p);
            jSONObject.put("mVersionName", this.q);
            jSONObject.put("mDownloadId", this.w);
            jSONObject.put("mIsV3Event", this.N);
            jSONObject.put("mScene", this.P);
            jSONObject.put("mEventTag", this.L);
            jSONObject.put("mEventRefer", this.M);
            jSONObject.put("mDownloadUrl", this.j);
            jSONObject.put("mEnableBackDialog", this.x);
            jSONObject.put("hasSendInstallFinish", this.f42680c.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.f42681d.get());
            jSONObject.put("mLastFailedErrCode", this.E);
            jSONObject.put("mLastFailedErrMsg", this.F);
            jSONObject.put("mOpenUrl", this.k);
            jSONObject.put("mLinkMode", this.n);
            jSONObject.put("mDownloadMode", this.o);
            jSONObject.put("mModelType", this.m);
            jSONObject.put("mAppName", this.r);
            jSONObject.put("mAppIcon", this.s);
            jSONObject.put("mDownloadFailedTimes", this.y);
            jSONObject.put("mRecentDownloadResumeTime", this.A == 0 ? this.u : this.A);
            jSONObject.put("mClickPauseTimes", this.z);
            jSONObject.put("mJumpInstallTime", this.B);
            jSONObject.put("mCancelInstallTime", this.C);
            jSONObject.put("mLastFailedResumeCount", this.D);
            jSONObject.put("mIsUpdateDownload", this.G);
            jSONObject.put("mOriginMimeType", this.H);
            jSONObject.put("mIsPatchApplyHandled", this.I);
            jSONObject.put("downloadFinishReason", this.V);
            jSONObject.put("clickDownloadTime", this.R);
            jSONObject.put("clickDownloadSize", this.S);
            jSONObject.put("installAfterCleanSpace", this.O);
            jSONObject.put("funnelType", this.Q);
            jSONObject.put("webUrl", this.l);
            jSONObject.put("enableShowComplianceDialog", this.T);
            jSONObject.put("isAutoDownloadOnCardShow", this.U);
            int i = 1;
            jSONObject.put("enable_new_activity", this.J ? 1 : 0);
            jSONObject.put("enable_pause", this.K ? 1 : 0);
            jSONObject.put("enable_ah", this.a ? 1 : 0);
            if (!this.f42679b) {
                i = 0;
            }
            jSONObject.put("enable_am", i);
        } catch (Exception e2) {
            j.s().a(e2, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public AdDownloadModel af() {
        return new AdDownloadModel.Builder().setAdId(this.f42682e).setExtraValue(this.f42683f).setLogExtra(this.f42684g).setPackageName(this.i).setExtra(this.v).setIsAd(this.t).setVersionCode(this.p).setVersionName(this.q).setDownloadUrl(this.j).setModelType(this.m).setMimeType(this.H).setAppName(this.r).setAppIcon(this.s).setDeepLink(new DeepLink(this.k, this.l, null)).build();
    }

    public AdDownloadEventConfig ag() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.L).setRefer(this.M).setIsEnableV3Event(this.N).build();
    }

    public AdDownloadController ah() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.x).setLinkMode(this.n).setDownloadMode(this.o).setEnableShowComplianceDialog(this.T).setEnableAH(this.a).setEnableAM(this.f42679b).build();
    }

    public void b(int i) {
        this.z = i;
    }

    public void c(long j) {
        this.C = j;
    }

    public void d(int i) {
        this.E = i;
    }

    public void e(long j) {
        this.f42683f = j;
    }

    public void f(long j) {
        if (j > 0) {
            this.u = j;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        return this.v;
    }

    public void h(int i) {
        this.P = i;
    }

    public void i(int i) {
        this.Q = i;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        return this.L;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        return null;
    }

    public void k(String str) {
        this.s = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        return this.f42683f;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        return this.N;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        return null;
    }

    public void n(boolean z) {
        this.ae = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        return null;
    }

    public void o(boolean z) {
        this.af = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        return null;
    }

    public void p(boolean z) {
        this.T = z;
    }

    public void q(boolean z) {
        this.U = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        return null;
    }

    public void r(boolean z) {
        this.J = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        return this.w;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        return -1;
    }

    public void t(boolean z) {
        this.a = z;
    }

    public void u(boolean z) {
        this.f42679b = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        return ag();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        return ah();
    }

    public int x() {
        return this.y;
    }

    public synchronized void y() {
        this.y++;
    }

    public int z() {
        return this.z;
    }

    public void a(long j) {
        this.A = j;
    }

    public void b(long j) {
        this.B = j;
    }

    public void c(int i) {
        this.D = i;
    }

    public void d(long j) {
        this.f42682e = j;
    }

    public void e(int i) {
        this.f42685h = i;
    }

    public void f(int i) {
        this.p = i;
    }

    public void g(int i) {
        this.w = i;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        return this.Q;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        return this.M;
    }

    public void j(String str) {
        this.r = str;
    }

    public void k(int i) {
        this.o = i;
    }

    public void l(int i) {
        this.m = i;
    }

    public void m(String str) {
        this.H = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        return this.J;
    }

    public void s(boolean z) {
        this.K = z;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        return af();
    }

    public void a(String str) {
        this.F = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        return this.f42682e;
    }

    public void c(String str) {
        this.f42684g = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        return this.f42684g;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        return this.i;
    }

    public void f(String str) {
        this.L = str;
    }

    public void g(String str) {
        this.M = str;
    }

    public void h(String str) {
        this.j = str;
    }

    public void i(String str) {
        this.k = str;
    }

    public void j(int i) {
        this.n = i;
    }

    public void k(boolean z) {
        this.ab = z;
    }

    public void l(String str) {
        this.V = str;
    }

    public void m(boolean z) {
        this.ac = z;
    }

    public void a(boolean z) {
        this.t = z;
    }

    public void b(String str) {
        this.i = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        return this.t;
    }

    public void d(String str) {
        this.q = str;
    }

    public void e(String str) {
        this.l = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        return this.k;
    }

    public void g(long j) {
        this.Z = j;
    }

    public void h(long j) {
        this.R = j;
    }

    public void i(long j) {
        this.S = j;
    }

    public void j(boolean z) {
        this.aa = z;
    }

    public void l(boolean z) {
        this.ad = z;
    }

    public void a(JSONObject jSONObject) {
        this.v = jSONObject;
    }

    public void b(boolean z) {
        this.N = z;
    }

    public void c(boolean z) {
        this.x = z;
    }

    public void d(boolean z) {
        this.W = z;
    }

    public void e(boolean z) {
        this.X = z;
    }

    public void f(boolean z) {
        this.O = z;
    }

    public void g(boolean z) {
        this.Y = z;
    }

    public void h(boolean z) {
        this.G = z;
    }

    public void i(boolean z) {
        this.I = z;
    }

    public static b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            bVar.d(com.ss.android.download.api.c.b.a(jSONObject, "mId"));
            bVar.e(com.ss.android.download.api.c.b.a(jSONObject, "mExtValue"));
            bVar.c(jSONObject.optString("mLogExtra"));
            bVar.e(jSONObject.optInt("mDownloadStatus"));
            bVar.b(jSONObject.optString("mPackageName"));
            boolean z = true;
            bVar.a(jSONObject.optBoolean("mIsAd", true));
            bVar.f(com.ss.android.download.api.c.b.a(jSONObject, "mTimeStamp"));
            bVar.f(jSONObject.optInt("mVersionCode"));
            bVar.d(jSONObject.optString("mVersionName"));
            bVar.g(jSONObject.optInt("mDownloadId"));
            bVar.b(jSONObject.optBoolean("mIsV3Event"));
            bVar.h(jSONObject.optInt("mScene"));
            bVar.f(jSONObject.optString("mEventTag"));
            bVar.g(jSONObject.optString("mEventRefer"));
            bVar.h(jSONObject.optString("mDownloadUrl"));
            bVar.c(jSONObject.optBoolean("mEnableBackDialog"));
            bVar.f42680c.set(jSONObject.optBoolean("hasSendInstallFinish"));
            bVar.f42681d.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            bVar.d(jSONObject.optInt("mLastFailedErrCode"));
            bVar.a(jSONObject.optString("mLastFailedErrMsg"));
            bVar.i(jSONObject.optString("mOpenUrl"));
            bVar.j(jSONObject.optInt("mLinkMode"));
            bVar.k(jSONObject.optInt("mDownloadMode"));
            bVar.l(jSONObject.optInt("mModelType"));
            bVar.j(jSONObject.optString("mAppName"));
            bVar.k(jSONObject.optString("mAppIcon"));
            bVar.a(jSONObject.optInt("mDownloadFailedTimes", 0));
            bVar.a(com.ss.android.download.api.c.b.a(jSONObject, "mRecentDownloadResumeTime"));
            bVar.b(jSONObject.optInt("mClickPauseTimes"));
            bVar.b(com.ss.android.download.api.c.b.a(jSONObject, "mJumpInstallTime"));
            bVar.c(com.ss.android.download.api.c.b.a(jSONObject, "mCancelInstallTime"));
            bVar.c(jSONObject.optInt("mLastFailedResumeCount"));
            bVar.l(jSONObject.optString("downloadFinishReason"));
            bVar.i(jSONObject.optLong("clickDownloadSize"));
            bVar.h(jSONObject.optLong("clickDownloadTime"));
            bVar.h(jSONObject.optBoolean("mIsUpdateDownload"));
            bVar.m(jSONObject.optString("mOriginMimeType"));
            bVar.i(jSONObject.optBoolean("mIsPatchApplyHandled"));
            bVar.f(jSONObject.optBoolean("installAfterCleanSpace"));
            bVar.i(jSONObject.optInt("funnelType", 1));
            bVar.e(jSONObject.optString("webUrl"));
            bVar.p(jSONObject.optBoolean("enableShowComplianceDialog", true));
            bVar.q(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            bVar.r(jSONObject.optInt("enable_new_activity", 1) == 1);
            bVar.s(jSONObject.optInt("enable_pause", 1) == 1);
            bVar.t(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            bVar.u(z);
            bVar.a(jSONObject.optJSONObject("mExtras"));
        } catch (Exception e2) {
            j.s().a(e2, "NativeDownloadModel fromJson");
        }
        return bVar;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        return this.j;
    }

    public b(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public b(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i) {
        this.f42685h = 1;
        this.t = true;
        this.x = false;
        this.y = 0;
        this.z = 0;
        this.G = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.a = true;
        this.f42679b = true;
        this.f42680c = new AtomicBoolean(false);
        this.f42681d = new AtomicBoolean(false);
        this.Q = 1;
        this.T = true;
        this.Z = -1L;
        this.f42682e = downloadModel.getId();
        this.f42683f = downloadModel.getExtraValue();
        this.f42684g = downloadModel.getLogExtra();
        this.i = downloadModel.getPackageName();
        this.v = downloadModel.getExtra();
        this.t = downloadModel.isAd();
        this.p = downloadModel.getVersionCode();
        this.q = downloadModel.getVersionName();
        this.j = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.k = downloadModel.getDeepLink().getOpenUrl();
            this.l = downloadModel.getDeepLink().getWebUrl();
        }
        this.m = downloadModel.getModelType();
        this.r = downloadModel.getName();
        this.s = downloadModel.getAppIcon();
        this.H = downloadModel.getMimeType();
        this.L = downloadEventConfig.getClickButtonTag();
        this.M = downloadEventConfig.getRefer();
        this.N = downloadEventConfig.isEnableV3Event();
        this.x = downloadController.isEnableBackDialog();
        this.n = downloadController.getLinkMode();
        this.o = downloadController.getDownloadMode();
        this.T = downloadController.enableShowComplianceDialog();
        this.U = downloadController.isAutoDownloadOnCardShow();
        this.J = downloadController.enableNewActivity();
        this.a = downloadController.enableAH();
        this.f42679b = downloadController.enableAM();
        this.w = i;
        long currentTimeMillis = System.currentTimeMillis();
        this.u = currentTimeMillis;
        this.A = currentTimeMillis;
        this.I = downloadModel.shouldDownloadWithPatchApply();
    }
}
