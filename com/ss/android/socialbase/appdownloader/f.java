package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.s;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public boolean A;
    public int C;
    public boolean D;
    public String E;
    public boolean G;
    public boolean H;
    public boolean I;
    public int L;
    public x N;
    public n O;
    public com.ss.android.socialbase.appdownloader.c.e P;
    public IDownloadFileUriProvider Q;
    public r R;
    public boolean S;
    public af T;
    public boolean U;
    public JSONObject V;
    public String W;
    public int Y;
    public long Z;
    public Activity a;
    public int aa;
    public boolean ab;
    public String ae;
    public int[] af;

    /* renamed from: b  reason: collision with root package name */
    public Context f62112b;

    /* renamed from: c  reason: collision with root package name */
    public String f62113c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f62114d;

    /* renamed from: e  reason: collision with root package name */
    public String f62115e;

    /* renamed from: f  reason: collision with root package name */
    public String f62116f;

    /* renamed from: g  reason: collision with root package name */
    public String f62117g;

    /* renamed from: h  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f62118h;
    public IDownloadListener m;
    public IDownloadListener n;
    public String o;
    public boolean q;
    public com.ss.android.socialbase.downloader.downloader.g r;
    public com.ss.android.socialbase.downloader.downloader.h s;
    public s t;
    public com.ss.android.socialbase.downloader.notification.a u;
    public boolean v;
    public boolean w;
    public String x;
    public String y;
    public long z;

    /* renamed from: i  reason: collision with root package name */
    public boolean f62119i = true;

    /* renamed from: j  reason: collision with root package name */
    public boolean f62120j = false;

    /* renamed from: k  reason: collision with root package name */
    public boolean f62121k = true;
    public boolean l = false;
    public String p = "application/vnd.android.package-archive";
    public int B = 5;
    public boolean F = true;
    public EnqueueType J = EnqueueType.ENQUEUE_NONE;
    public int K = 150;
    public boolean M = true;
    public List<m> X = new ArrayList();
    public boolean ac = true;
    public boolean ad = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.f62112b = context.getApplicationContext();
        this.f62113c = str;
    }

    public boolean A() {
        return this.F;
    }

    public boolean B() {
        return this.G;
    }

    public s C() {
        return this.t;
    }

    public int D() {
        return this.K;
    }

    public int E() {
        return this.L;
    }

    public boolean F() {
        return this.H;
    }

    public boolean G() {
        return this.I;
    }

    public boolean H() {
        return this.M;
    }

    public boolean I() {
        return this.S;
    }

    public EnqueueType J() {
        return this.J;
    }

    public boolean K() {
        return this.A;
    }

    public String L() {
        return this.f62116f;
    }

    public x M() {
        return this.N;
    }

    public n N() {
        return this.O;
    }

    public com.ss.android.socialbase.appdownloader.c.e O() {
        return this.P;
    }

    public IDownloadFileUriProvider P() {
        return this.Q;
    }

    public af Q() {
        return this.T;
    }

    public List<m> R() {
        return this.X;
    }

    public boolean S() {
        return this.U;
    }

    public int T() {
        return this.Y;
    }

    public long U() {
        return this.Z;
    }

    public boolean V() {
        return this.ad;
    }

    public String W() {
        return this.ae;
    }

    public int[] X() {
        return this.af;
    }

    public boolean Y() {
        return this.ab;
    }

    public boolean Z() {
        return this.ac;
    }

    public String a() {
        return this.f62113c;
    }

    public String aa() {
        return this.W;
    }

    public List<String> ab() {
        return this.f62114d;
    }

    public r ac() {
        return this.R;
    }

    public JSONObject ad() {
        return this.V;
    }

    public String b() {
        return this.f62115e;
    }

    public String c() {
        return this.f62117g;
    }

    public List<com.ss.android.socialbase.downloader.model.c> d() {
        return this.f62118h;
    }

    public boolean e() {
        return this.f62119i;
    }

    public boolean f() {
        return this.f62120j;
    }

    public boolean g() {
        return this.f62121k;
    }

    public Activity getActivity() {
        return this.a;
    }

    public Context getContext() {
        return this.f62112b;
    }

    public boolean h() {
        return this.l;
    }

    public IDownloadListener i() {
        return this.m;
    }

    public IDownloadListener j() {
        return this.n;
    }

    public String k() {
        return this.o;
    }

    public String l() {
        return this.p;
    }

    public boolean m() {
        return this.q;
    }

    public com.ss.android.socialbase.downloader.notification.a n() {
        return this.u;
    }

    public com.ss.android.socialbase.downloader.downloader.h o() {
        return this.s;
    }

    public com.ss.android.socialbase.downloader.downloader.g p() {
        return this.r;
    }

    public boolean q() {
        return this.v;
    }

    public boolean r() {
        return this.w;
    }

    public int s() {
        return this.aa;
    }

    public String t() {
        return this.x;
    }

    public String u() {
        return this.y;
    }

    public long v() {
        return this.z;
    }

    public int w() {
        return this.B;
    }

    public int x() {
        return this.C;
    }

    public boolean y() {
        return this.D;
    }

    public String z() {
        return this.E;
    }

    public void a(int i2) {
        this.aa = i2;
    }

    public f b(String str) {
        this.f62116f = str;
        return this;
    }

    public f c(@NonNull String str) {
        this.f62117g = str;
        return this;
    }

    public f d(String str) {
        this.o = str;
        return this;
    }

    public f e(String str) {
        this.p = str;
        return this;
    }

    public f f(boolean z) {
        this.w = z;
        return this;
    }

    public f g(String str) {
        this.y = str;
        return this;
    }

    public f h(String str) {
        this.E = str;
        return this;
    }

    public f i(boolean z) {
        this.F = z;
        return this;
    }

    public f j(boolean z) {
        this.G = z;
        return this;
    }

    public f k(boolean z) {
        this.H = z;
        return this;
    }

    public f l(boolean z) {
        this.I = z;
        return this;
    }

    public f m(boolean z) {
        this.M = z;
        return this;
    }

    public f n(boolean z) {
        this.A = z;
        return this;
    }

    public f o(boolean z) {
        this.ab = z;
        return this;
    }

    public f p(boolean z) {
        this.ac = z;
        return this;
    }

    public f a(String str) {
        this.f62115e = str;
        return this;
    }

    public f b(boolean z) {
        this.f62120j = z;
        return this;
    }

    public f c(boolean z) {
        this.l = z;
        return this;
    }

    public f d(boolean z) {
        this.q = z;
        return this;
    }

    public f e(boolean z) {
        this.v = z;
        return this;
    }

    public f f(String str) {
        this.x = str;
        return this;
    }

    public f g(boolean z) {
        this.D = z;
        return this;
    }

    public f h(boolean z) {
        this.S = z;
        return this;
    }

    public f i(String str) {
        this.ae = str;
        return this;
    }

    public f j(String str) {
        this.W = str;
        return this;
    }

    public f a(List<com.ss.android.socialbase.downloader.model.c> list) {
        this.f62118h = list;
        return this;
    }

    public f b(int i2) {
        this.B = i2;
        return this;
    }

    public f c(int i2) {
        this.C = i2;
        return this;
    }

    public f d(int i2) {
        this.K = i2;
        return this;
    }

    public f e(int i2) {
        this.L = i2;
        return this;
    }

    public f f(int i2) {
        this.Y = i2;
        return this;
    }

    public f a(boolean z) {
        this.f62119i = z;
        return this;
    }

    public f b(List<String> list) {
        this.f62114d = list;
        return this;
    }

    public f a(IDownloadListener iDownloadListener) {
        this.m = iDownloadListener;
        return this;
    }

    public f a(long j2) {
        this.z = j2;
        return this;
    }

    public f a(EnqueueType enqueueType) {
        this.J = enqueueType;
        return this;
    }

    public f a(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.Q = iDownloadFileUriProvider;
        return this;
    }

    public f a(r rVar) {
        this.R = rVar;
        return this;
    }

    public f a(JSONObject jSONObject) {
        this.V = jSONObject;
        return this;
    }

    public f a(m mVar) {
        synchronized (this.X) {
            if (mVar != null) {
                if (!this.X.contains(mVar)) {
                    this.X.add(mVar);
                    return this;
                }
            }
            return this;
        }
    }
}
