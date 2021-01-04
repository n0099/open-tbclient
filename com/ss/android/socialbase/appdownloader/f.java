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
/* loaded from: classes4.dex */
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
    private Activity f13339a;

    /* renamed from: b  reason: collision with root package name */
    private Context f13340b;
    private String c;
    private List<String> d;
    private String e;
    private String f;
    private String g;
    private List<com.ss.android.socialbase.downloader.g.e> h;
    private String o;
    private s pWA;
    private com.ss.android.socialbase.downloader.notification.a pWB;
    private com.ss.android.socialbase.downloader.d.c pWD;
    private ad pWE;
    private com.ss.android.socialbase.appdownloader.c.e pWF;
    private ah pWG;
    private af pWH;
    private r pWI;
    private JSONObject pWJ;
    private ab pWK;
    private com.ss.android.socialbase.downloader.d.b pWw;
    private com.ss.android.socialbase.downloader.d.b pWx;
    private com.ss.android.socialbase.downloader.downloader.h pWy;
    private com.ss.android.socialbase.downloader.downloader.i pWz;
    private boolean q;
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
    private com.ss.android.socialbase.downloader.b.g pWC = com.ss.android.socialbase.downloader.b.g.ENQUEUE_NONE;
    private int K = 150;
    private boolean M = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.f13340b = context.getApplicationContext();
        this.c = str;
    }

    public Activity eEx() {
        return this.f13339a;
    }

    public Context b() {
        return this.f13340b;
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

    public com.ss.android.socialbase.downloader.d.b eGr() {
        return this.pWw;
    }

    public com.ss.android.socialbase.downloader.d.b eGs() {
        return this.pWx;
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

    public com.ss.android.socialbase.downloader.notification.a eGt() {
        return this.pWB;
    }

    public com.ss.android.socialbase.downloader.downloader.i eGu() {
        return this.pWz;
    }

    public com.ss.android.socialbase.downloader.downloader.h eGv() {
        return this.pWy;
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

    public s eGw() {
        return this.pWA;
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

    public com.ss.android.socialbase.downloader.b.g eGx() {
        return this.pWC;
    }

    public boolean L() {
        return this.A;
    }

    public String M() {
        return this.f;
    }

    public com.ss.android.socialbase.downloader.d.c eGy() {
        return this.pWD;
    }

    public ad eGz() {
        return this.pWE;
    }

    public com.ss.android.socialbase.appdownloader.c.e eGA() {
        return this.pWF;
    }

    public ah eGB() {
        return this.pWG;
    }

    public r eGC() {
        return this.pWI;
    }

    public ab eGD() {
        return this.pWK;
    }

    public boolean T() {
        return this.U;
    }

    public int eGE() {
        return this.Y;
    }

    public long eGF() {
        return this.Z;
    }

    public f aaW(String str) {
        this.e = str;
        return this;
    }

    public f aaX(String str) {
        this.f = str;
        return this;
    }

    public f aaY(@NonNull String str) {
        this.g = str;
        return this;
    }

    public f gW(List<com.ss.android.socialbase.downloader.g.e> list) {
        this.h = list;
        return this;
    }

    public f BJ(boolean z) {
        this.i = z;
        return this;
    }

    public f BK(boolean z) {
        this.j = z;
        return this;
    }

    public f BL(boolean z) {
        this.l = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.d.b bVar) {
        this.pWw = bVar;
        return this;
    }

    public f aaZ(String str) {
        this.o = str;
        return this;
    }

    public f aba(String str) {
        this.p = str;
        return this;
    }

    public f BM(boolean z) {
        this.q = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.i iVar) {
        this.pWz = iVar;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.pWy = hVar;
        return this;
    }

    public f BN(boolean z) {
        this.v = z;
        return this;
    }

    public f BO(boolean z) {
        this.w = z;
        return this;
    }

    public f abb(String str) {
        this.x = str;
        return this;
    }

    public f abc(String str) {
        this.y = str;
        return this;
    }

    public f jb(long j) {
        this.z = j;
        return this;
    }

    public f Sc(int i) {
        this.B = i;
        return this;
    }

    public f Sd(int i) {
        this.C = i;
        return this;
    }

    public f BP(boolean z) {
        this.D = z;
        return this;
    }

    public f abd(String str) {
        this.E = str;
        return this;
    }

    public f BQ(boolean z) {
        this.S = z;
        return this;
    }

    public f BR(boolean z) {
        this.F = z;
        return this;
    }

    public f BS(boolean z) {
        this.G = z;
        return this;
    }

    public f BT(boolean z) {
        this.H = z;
        return this;
    }

    public f BU(boolean z) {
        this.I = z;
        return this;
    }

    public f Se(int i) {
        this.K = i;
        return this;
    }

    public f Sf(int i) {
        this.L = i;
        return this;
    }

    public f BV(boolean z) {
        this.M = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.b.g gVar) {
        this.pWC = gVar;
        return this;
    }

    public f BW(boolean z) {
        this.A = z;
        return this;
    }

    public f a(ah ahVar) {
        this.pWG = ahVar;
        return this;
    }

    public f abe(String str) {
        this.W = str;
        return this;
    }

    public String W() {
        return this.W;
    }

    public f Sg(int i) {
        this.Y = i;
        return this;
    }

    public List<String> eGG() {
        return this.d;
    }

    public f gX(List<String> list) {
        this.d = list;
        return this;
    }

    public af eGH() {
        return this.pWH;
    }

    public f a(af afVar) {
        this.pWH = afVar;
        return this;
    }

    public JSONObject eGI() {
        return this.pWJ;
    }

    public f fi(JSONObject jSONObject) {
        this.pWJ = jSONObject;
        return this;
    }

    public f a(ab abVar) {
        this.pWK = abVar;
        return this;
    }
}
