package d.o.a.e.a;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.f;
import d.o.a.e.a.d;
import d.o.a.e.b.f.p;
import d.o.a.e.b.f.q;
import d.o.a.e.b.f.s;
import d.o.a.e.b.f.u;
import d.o.a.e.b.f.y;
import d.o.a.e.b.g.h;
import d.o.a.e.b.g.r;
import d.o.a.e.b.p.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i {
    public boolean A;
    public int C;
    public boolean D;
    public String E;
    public boolean G;
    public boolean H;
    public boolean I;
    public int L;
    public y N;
    public q O;
    public d.g P;
    public u Q;
    public s R;
    public boolean S;
    public d.o.a.e.b.f.i T;
    public boolean U;
    public JSONObject V;
    public String W;
    public int Y;
    public long Z;

    /* renamed from: a  reason: collision with root package name */
    public Activity f67075a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public Context f67076b;

    /* renamed from: c  reason: collision with root package name */
    public String f67077c;
    public String c0;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f67078d;
    public int[] d0;

    /* renamed from: e  reason: collision with root package name */
    public String f67079e;

    /* renamed from: f  reason: collision with root package name */
    public String f67080f;

    /* renamed from: g  reason: collision with root package name */
    public String f67081g;

    /* renamed from: h  reason: collision with root package name */
    public List<com.ss.android.socialbase.downloader.model.c> f67082h;
    public d.o.a.e.b.f.b m;
    public d.o.a.e.b.f.b n;
    public String o;
    public boolean q;
    public h r;
    public d.o.a.e.b.g.i s;
    public r t;
    public a u;
    public boolean v;
    public boolean w;
    public String x;
    public String y;
    public long z;

    /* renamed from: i  reason: collision with root package name */
    public boolean f67083i = true;
    public boolean j = false;
    public boolean k = true;
    public boolean l = false;
    public String p = "application/vnd.android.package-archive";
    public int B = 5;
    public boolean F = true;
    public f J = f.ENQUEUE_NONE;
    public int K = 150;
    public boolean M = true;
    public List<p> X = new ArrayList();
    public boolean b0 = true;

    public i(@NonNull Context context, @NonNull String str) {
        this.f67076b = context.getApplicationContext();
        this.f67077c = str;
    }

    public Activity A() {
        return this.f67075a;
    }

    public d.o.a.e.b.f.b A0() {
        return this.m;
    }

    public i B(long j) {
        this.z = j;
        return this;
    }

    public i B0(boolean z) {
        this.I = z;
        return this;
    }

    public i C(f fVar) {
        this.J = fVar;
        return this;
    }

    public d.o.a.e.b.f.b C0() {
        return this.n;
    }

    public i D(d.o.a.e.b.f.b bVar) {
        this.m = bVar;
        return this;
    }

    public i D0(boolean z) {
        this.M = z;
        return this;
    }

    public i E(p pVar) {
        synchronized (this.X) {
            if (pVar != null) {
                if (!this.X.contains(pVar)) {
                    this.X.add(pVar);
                    return this;
                }
            }
            return this;
        }
    }

    public String E0() {
        return this.o;
    }

    public i F(s sVar) {
        this.R = sVar;
        return this;
    }

    public i F0(boolean z) {
        this.A = z;
        return this;
    }

    public i G(u uVar) {
        this.Q = uVar;
        return this;
    }

    public String G0() {
        return this.p;
    }

    public i H(h hVar) {
        this.r = hVar;
        return this;
    }

    public boolean H0() {
        return this.q;
    }

    public i I(d.o.a.e.b.g.i iVar) {
        this.s = iVar;
        return this;
    }

    public a I0() {
        return this.u;
    }

    public i J(String str) {
        this.f67079e = str;
        return this;
    }

    public d.o.a.e.b.g.i J0() {
        return this.s;
    }

    public i K(List<com.ss.android.socialbase.downloader.model.c> list) {
        this.f67082h = list;
        return this;
    }

    public h K0() {
        return this.r;
    }

    public i L(JSONObject jSONObject) {
        this.V = jSONObject;
        return this;
    }

    public boolean L0() {
        return this.v;
    }

    public i M(boolean z) {
        this.f67083i = z;
        return this;
    }

    public boolean M0() {
        return this.w;
    }

    public void N(int i2) {
        this.a0 = i2;
    }

    public int N0() {
        return this.a0;
    }

    public String O() {
        return this.W;
    }

    public String O0() {
        return this.x;
    }

    public List<String> P() {
        return this.f67078d;
    }

    public String P0() {
        return this.y;
    }

    public s Q() {
        return this.R;
    }

    public long Q0() {
        return this.z;
    }

    public JSONObject R() {
        return this.V;
    }

    public int R0() {
        return this.B;
    }

    public Context S() {
        return this.f67076b;
    }

    public int S0() {
        return this.C;
    }

    public i T(int i2) {
        this.B = i2;
        return this;
    }

    public i U(String str) {
        this.f67080f = str;
        return this;
    }

    public i V(List<String> list) {
        this.f67078d = list;
        return this;
    }

    public i W(boolean z) {
        this.j = z;
        return this;
    }

    public i X(int i2) {
        this.C = i2;
        return this;
    }

    public i Y(@NonNull String str) {
        this.f67081g = str;
        return this;
    }

    public i Z(boolean z) {
        this.l = z;
        return this;
    }

    public boolean a() {
        return this.D;
    }

    public String a0() {
        return this.f67077c;
    }

    public String b() {
        return this.E;
    }

    public i b0(int i2) {
        this.K = i2;
        return this;
    }

    public boolean c() {
        return this.F;
    }

    public i c0(String str) {
        this.o = str;
        return this;
    }

    public boolean d() {
        return this.G;
    }

    public i d0(boolean z) {
        this.q = z;
        return this;
    }

    public r e() {
        return this.t;
    }

    public String e0() {
        return this.f67079e;
    }

    public int f() {
        return this.K;
    }

    public i f0(int i2) {
        this.L = i2;
        return this;
    }

    public int g() {
        return this.L;
    }

    public i g0(String str) {
        this.p = str;
        return this;
    }

    public boolean h() {
        return this.H;
    }

    public i h0(boolean z) {
        this.v = z;
        return this;
    }

    public boolean i() {
        return this.I;
    }

    public String i0() {
        return this.f67081g;
    }

    public boolean j() {
        return this.M;
    }

    public i j0(int i2) {
        this.Y = i2;
        return this;
    }

    public boolean k() {
        return this.S;
    }

    public i k0(String str) {
        this.x = str;
        return this;
    }

    public f l() {
        return this.J;
    }

    public i l0(boolean z) {
        this.w = z;
        return this;
    }

    public boolean m() {
        return this.A;
    }

    public List<com.ss.android.socialbase.downloader.model.c> m0() {
        return this.f67082h;
    }

    public String n() {
        return this.f67080f;
    }

    public i n0(String str) {
        this.y = str;
        return this;
    }

    public y o() {
        return this.N;
    }

    public i o0(boolean z) {
        this.D = z;
        return this;
    }

    public q p() {
        return this.O;
    }

    public boolean p0() {
        return this.f67083i;
    }

    public d.g q() {
        return this.P;
    }

    public i q0(String str) {
        this.E = str;
        return this;
    }

    public u r() {
        return this.Q;
    }

    public i r0(boolean z) {
        this.S = z;
        return this;
    }

    public d.o.a.e.b.f.i s() {
        return this.T;
    }

    public boolean s0() {
        return this.j;
    }

    public List<p> t() {
        return this.X;
    }

    public i t0(String str) {
        this.c0 = str;
        return this;
    }

    public boolean u() {
        return this.U;
    }

    public i u0(boolean z) {
        this.F = z;
        return this;
    }

    public int v() {
        return this.Y;
    }

    public boolean v0() {
        return this.k;
    }

    public long w() {
        return this.Z;
    }

    public i w0(String str) {
        this.W = str;
        return this;
    }

    public boolean x() {
        return this.b0;
    }

    public i x0(boolean z) {
        this.G = z;
        return this;
    }

    public String y() {
        return this.c0;
    }

    public boolean y0() {
        return this.l;
    }

    public int[] z() {
        return this.d0;
    }

    public i z0(boolean z) {
        this.H = z;
        return this;
    }
}
