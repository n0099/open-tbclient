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
    private Activity f13040a;

    /* renamed from: b  reason: collision with root package name */
    private Context f13041b;
    private String c;
    private List<String> d;
    private String e;
    private String f;
    private String g;
    private List<com.ss.android.socialbase.downloader.g.e> h;
    private String o;
    private com.ss.android.socialbase.downloader.d.b pTD;
    private com.ss.android.socialbase.downloader.d.b pTE;
    private com.ss.android.socialbase.downloader.downloader.h pTF;
    private com.ss.android.socialbase.downloader.downloader.i pTG;
    private s pTH;
    private com.ss.android.socialbase.downloader.notification.a pTI;
    private com.ss.android.socialbase.downloader.d.c pTK;
    private ad pTL;
    private com.ss.android.socialbase.appdownloader.c.e pTM;
    private ah pTN;
    private af pTO;
    private r pTP;
    private JSONObject pTQ;
    private ab pTR;
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
    private com.ss.android.socialbase.downloader.b.g pTJ = com.ss.android.socialbase.downloader.b.g.ENQUEUE_NONE;
    private int K = 150;
    private boolean M = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.f13041b = context.getApplicationContext();
        this.c = str;
    }

    public Activity eBk() {
        return this.f13040a;
    }

    public Context b() {
        return this.f13041b;
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

    public com.ss.android.socialbase.downloader.d.b eDf() {
        return this.pTD;
    }

    public com.ss.android.socialbase.downloader.d.b eDg() {
        return this.pTE;
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

    public com.ss.android.socialbase.downloader.notification.a eDh() {
        return this.pTI;
    }

    public com.ss.android.socialbase.downloader.downloader.i eDi() {
        return this.pTG;
    }

    public com.ss.android.socialbase.downloader.downloader.h eDj() {
        return this.pTF;
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

    public s eDk() {
        return this.pTH;
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

    public com.ss.android.socialbase.downloader.b.g eDl() {
        return this.pTJ;
    }

    public boolean L() {
        return this.A;
    }

    public String M() {
        return this.f;
    }

    public com.ss.android.socialbase.downloader.d.c eDm() {
        return this.pTK;
    }

    public ad eDn() {
        return this.pTL;
    }

    public com.ss.android.socialbase.appdownloader.c.e eDo() {
        return this.pTM;
    }

    public ah eDp() {
        return this.pTN;
    }

    public r eDq() {
        return this.pTP;
    }

    public ab eDr() {
        return this.pTR;
    }

    public boolean T() {
        return this.U;
    }

    public int eDs() {
        return this.Y;
    }

    public long eDt() {
        return this.Z;
    }

    public f ZP(String str) {
        this.e = str;
        return this;
    }

    public f ZQ(String str) {
        this.f = str;
        return this;
    }

    public f ZR(@NonNull String str) {
        this.g = str;
        return this;
    }

    public f gX(List<com.ss.android.socialbase.downloader.g.e> list) {
        this.h = list;
        return this;
    }

    public f BF(boolean z) {
        this.i = z;
        return this;
    }

    public f BG(boolean z) {
        this.j = z;
        return this;
    }

    public f BH(boolean z) {
        this.l = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.d.b bVar) {
        this.pTD = bVar;
        return this;
    }

    public f ZS(String str) {
        this.o = str;
        return this;
    }

    public f ZT(String str) {
        this.p = str;
        return this;
    }

    public f BI(boolean z) {
        this.q = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.i iVar) {
        this.pTG = iVar;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.pTF = hVar;
        return this;
    }

    public f BJ(boolean z) {
        this.v = z;
        return this;
    }

    public f BK(boolean z) {
        this.w = z;
        return this;
    }

    public f ZU(String str) {
        this.x = str;
        return this;
    }

    public f ZV(String str) {
        this.y = str;
        return this;
    }

    public f je(long j) {
        this.z = j;
        return this;
    }

    public f QL(int i) {
        this.B = i;
        return this;
    }

    public f QM(int i) {
        this.C = i;
        return this;
    }

    public f BL(boolean z) {
        this.D = z;
        return this;
    }

    public f ZW(String str) {
        this.E = str;
        return this;
    }

    public f BM(boolean z) {
        this.S = z;
        return this;
    }

    public f BN(boolean z) {
        this.F = z;
        return this;
    }

    public f BO(boolean z) {
        this.G = z;
        return this;
    }

    public f BP(boolean z) {
        this.H = z;
        return this;
    }

    public f BQ(boolean z) {
        this.I = z;
        return this;
    }

    public f QN(int i) {
        this.K = i;
        return this;
    }

    public f QO(int i) {
        this.L = i;
        return this;
    }

    public f BR(boolean z) {
        this.M = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.b.g gVar) {
        this.pTJ = gVar;
        return this;
    }

    public f BS(boolean z) {
        this.A = z;
        return this;
    }

    public f a(ah ahVar) {
        this.pTN = ahVar;
        return this;
    }

    public f ZX(String str) {
        this.W = str;
        return this;
    }

    public String W() {
        return this.W;
    }

    public f QP(int i) {
        this.Y = i;
        return this;
    }

    public List<String> eDu() {
        return this.d;
    }

    public f gY(List<String> list) {
        this.d = list;
        return this;
    }

    public af eDv() {
        return this.pTO;
    }

    public f a(af afVar) {
        this.pTO = afVar;
        return this;
    }

    public JSONObject eDw() {
        return this.pTQ;
    }

    public f fi(JSONObject jSONObject) {
        this.pTQ = jSONObject;
        return this;
    }

    public f a(ab abVar) {
        this.pTR = abVar;
        return this;
    }
}
