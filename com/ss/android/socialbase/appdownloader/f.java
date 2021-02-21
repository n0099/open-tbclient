package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.d.ab;
import com.ss.android.socialbase.downloader.d.ad;
import com.ss.android.socialbase.downloader.d.af;
import com.ss.android.socialbase.downloader.d.ah;
import com.ss.android.socialbase.downloader.d.r;
import com.ss.android.socialbase.downloader.downloader.s;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    private boolean A;
    private int C;
    private boolean D;
    private String E;
    private boolean G;
    private boolean H;
    private boolean I;
    private int L;
    private boolean S;
    private boolean U;
    private String W;
    private int Y;
    private long Z;

    /* renamed from: a  reason: collision with root package name */
    private Activity f13042a;

    /* renamed from: b  reason: collision with root package name */
    private Context f13043b;
    private String c;
    private List<String> d;
    private String e;
    private String f;
    private String g;
    private List<com.ss.android.socialbase.downloader.g.e> h;
    private String o;
    private boolean q;
    private com.ss.android.socialbase.downloader.d.b qei;
    private com.ss.android.socialbase.downloader.d.b qej;
    private com.ss.android.socialbase.downloader.downloader.h qek;
    private com.ss.android.socialbase.downloader.downloader.i qel;
    private s qem;
    private com.ss.android.socialbase.downloader.notification.a qen;
    private com.ss.android.socialbase.downloader.d.c qep;
    private ad qeq;
    private com.ss.android.socialbase.appdownloader.c.e qer;
    private ah qes;
    private af qet;
    private r qeu;
    private JSONObject qev;
    private ab qew;
    private boolean v;
    private boolean w;
    private String x;
    private String y;
    private long z;
    private boolean i = true;
    private boolean j = false;
    private boolean k = true;
    private boolean l = false;
    private String p = "application/vnd.android.package-archive";
    private int B = 5;
    private boolean F = true;
    private com.ss.android.socialbase.downloader.b.g qeo = com.ss.android.socialbase.downloader.b.g.ENQUEUE_NONE;
    private int K = 150;
    private boolean M = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.f13043b = context.getApplicationContext();
        this.c = str;
    }

    public Activity eDJ() {
        return this.f13042a;
    }

    public Context b() {
        return this.f13043b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.g;
    }

    public List<com.ss.android.socialbase.downloader.g.e> f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.j;
    }

    public boolean i() {
        return this.k;
    }

    public boolean j() {
        return this.l;
    }

    public com.ss.android.socialbase.downloader.d.b eFE() {
        return this.qei;
    }

    public com.ss.android.socialbase.downloader.d.b eFF() {
        return this.qej;
    }

    public String m() {
        return this.o;
    }

    public String n() {
        return this.p;
    }

    public boolean o() {
        return this.q;
    }

    public com.ss.android.socialbase.downloader.notification.a eFG() {
        return this.qen;
    }

    public com.ss.android.socialbase.downloader.downloader.i eFH() {
        return this.qel;
    }

    public com.ss.android.socialbase.downloader.downloader.h eFI() {
        return this.qek;
    }

    public boolean s() {
        return this.v;
    }

    public boolean t() {
        return this.w;
    }

    public String u() {
        return this.x;
    }

    public String v() {
        return this.y;
    }

    public long w() {
        return this.z;
    }

    public int x() {
        return this.B;
    }

    public int y() {
        return this.C;
    }

    public boolean z() {
        return this.D;
    }

    public String A() {
        return this.E;
    }

    public boolean B() {
        return this.F;
    }

    public boolean C() {
        return this.G;
    }

    public s eFJ() {
        return this.qem;
    }

    public int E() {
        return this.K;
    }

    public int F() {
        return this.L;
    }

    public boolean G() {
        return this.H;
    }

    public boolean H() {
        return this.I;
    }

    public boolean I() {
        return this.M;
    }

    public boolean J() {
        return this.S;
    }

    public com.ss.android.socialbase.downloader.b.g eFK() {
        return this.qeo;
    }

    public boolean L() {
        return this.A;
    }

    public String M() {
        return this.f;
    }

    public com.ss.android.socialbase.downloader.d.c eFL() {
        return this.qep;
    }

    public ad eFM() {
        return this.qeq;
    }

    public com.ss.android.socialbase.appdownloader.c.e eFN() {
        return this.qer;
    }

    public ah eFO() {
        return this.qes;
    }

    public r eFP() {
        return this.qeu;
    }

    public ab eFQ() {
        return this.qew;
    }

    public boolean T() {
        return this.U;
    }

    public int eFR() {
        return this.Y;
    }

    public long eFS() {
        return this.Z;
    }

    public f abd(String str) {
        this.e = str;
        return this;
    }

    public f abe(String str) {
        this.f = str;
        return this;
    }

    public f abf(@NonNull String str) {
        this.g = str;
        return this;
    }

    public f gV(List<com.ss.android.socialbase.downloader.g.e> list) {
        this.h = list;
        return this;
    }

    public f BZ(boolean z) {
        this.i = z;
        return this;
    }

    public f Ca(boolean z) {
        this.j = z;
        return this;
    }

    public f Cb(boolean z) {
        this.l = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.d.b bVar) {
        this.qei = bVar;
        return this;
    }

    public f abg(String str) {
        this.o = str;
        return this;
    }

    public f abh(String str) {
        this.p = str;
        return this;
    }

    public f Cc(boolean z) {
        this.q = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.i iVar) {
        this.qel = iVar;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.qek = hVar;
        return this;
    }

    public f Cd(boolean z) {
        this.v = z;
        return this;
    }

    public f Ce(boolean z) {
        this.w = z;
        return this;
    }

    public f abi(String str) {
        this.x = str;
        return this;
    }

    public f abj(String str) {
        this.y = str;
        return this;
    }

    public f jh(long j) {
        this.z = j;
        return this;
    }

    public f Rh(int i) {
        this.B = i;
        return this;
    }

    public f Ri(int i) {
        this.C = i;
        return this;
    }

    public f Cf(boolean z) {
        this.D = z;
        return this;
    }

    public f abk(String str) {
        this.E = str;
        return this;
    }

    public f Cg(boolean z) {
        this.S = z;
        return this;
    }

    public f Ch(boolean z) {
        this.F = z;
        return this;
    }

    public f Ci(boolean z) {
        this.G = z;
        return this;
    }

    public f Cj(boolean z) {
        this.H = z;
        return this;
    }

    public f Ck(boolean z) {
        this.I = z;
        return this;
    }

    public f Rj(int i) {
        this.K = i;
        return this;
    }

    public f Rk(int i) {
        this.L = i;
        return this;
    }

    public f Cl(boolean z) {
        this.M = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.b.g gVar) {
        this.qeo = gVar;
        return this;
    }

    public f Cm(boolean z) {
        this.A = z;
        return this;
    }

    public f a(ah ahVar) {
        this.qes = ahVar;
        return this;
    }

    public f abl(String str) {
        this.W = str;
        return this;
    }

    public String W() {
        return this.W;
    }

    public f Rl(int i) {
        this.Y = i;
        return this;
    }

    public List<String> eFT() {
        return this.d;
    }

    public f gW(List<String> list) {
        this.d = list;
        return this;
    }

    public af eFU() {
        return this.qet;
    }

    public f a(af afVar) {
        this.qet = afVar;
        return this;
    }

    public JSONObject eFV() {
        return this.qev;
    }

    public f fj(JSONObject jSONObject) {
        this.qev = jSONObject;
        return this;
    }

    public f a(ab abVar) {
        this.qew = abVar;
        return this;
    }
}
