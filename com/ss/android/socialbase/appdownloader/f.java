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
    private Activity f7762a;
    private Context b;
    private String c;
    private List<String> d;
    private String e;
    private String f;
    private String g;
    private List<com.ss.android.socialbase.downloader.g.e> h;
    private String o;
    private boolean q;
    private com.ss.android.socialbase.downloader.d.b qeX;
    private com.ss.android.socialbase.downloader.d.b qeY;
    private com.ss.android.socialbase.downloader.downloader.h qeZ;
    private com.ss.android.socialbase.downloader.downloader.i qfa;
    private s qfb;
    private com.ss.android.socialbase.downloader.notification.a qfc;
    private com.ss.android.socialbase.downloader.d.c qfe;
    private ad qff;
    private com.ss.android.socialbase.appdownloader.c.e qfg;
    private ah qfh;
    private af qfi;
    private r qfj;
    private JSONObject qfk;
    private ab qfl;
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
    private com.ss.android.socialbase.downloader.b.g qfd = com.ss.android.socialbase.downloader.b.g.ENQUEUE_NONE;
    private int K = 150;
    private boolean M = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.b = context.getApplicationContext();
        this.c = str;
    }

    public Activity eDP() {
        return this.f7762a;
    }

    public Context b() {
        return this.b;
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

    public com.ss.android.socialbase.downloader.d.b eFI() {
        return this.qeX;
    }

    public com.ss.android.socialbase.downloader.d.b eFJ() {
        return this.qeY;
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

    public com.ss.android.socialbase.downloader.notification.a eFK() {
        return this.qfc;
    }

    public com.ss.android.socialbase.downloader.downloader.i eFL() {
        return this.qfa;
    }

    public com.ss.android.socialbase.downloader.downloader.h eFM() {
        return this.qeZ;
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

    public s eFN() {
        return this.qfb;
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

    public com.ss.android.socialbase.downloader.b.g eFO() {
        return this.qfd;
    }

    public boolean L() {
        return this.A;
    }

    public String M() {
        return this.f;
    }

    public com.ss.android.socialbase.downloader.d.c eFP() {
        return this.qfe;
    }

    public ad eFQ() {
        return this.qff;
    }

    public com.ss.android.socialbase.appdownloader.c.e eFR() {
        return this.qfg;
    }

    public ah eFS() {
        return this.qfh;
    }

    public r eFT() {
        return this.qfj;
    }

    public ab eFU() {
        return this.qfl;
    }

    public boolean T() {
        return this.U;
    }

    public int eFV() {
        return this.Y;
    }

    public long eFW() {
        return this.Z;
    }

    public f abi(String str) {
        this.e = str;
        return this;
    }

    public f abj(String str) {
        this.f = str;
        return this;
    }

    public f abk(@NonNull String str) {
        this.g = str;
        return this;
    }

    public f gV(List<com.ss.android.socialbase.downloader.g.e> list) {
        this.h = list;
        return this;
    }

    public f BX(boolean z) {
        this.i = z;
        return this;
    }

    public f BY(boolean z) {
        this.j = z;
        return this;
    }

    public f BZ(boolean z) {
        this.l = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.d.b bVar) {
        this.qeX = bVar;
        return this;
    }

    public f abl(String str) {
        this.o = str;
        return this;
    }

    public f abm(String str) {
        this.p = str;
        return this;
    }

    public f Ca(boolean z) {
        this.q = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.i iVar) {
        this.qfa = iVar;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.downloader.h hVar) {
        this.qeZ = hVar;
        return this;
    }

    public f Cb(boolean z) {
        this.v = z;
        return this;
    }

    public f Cc(boolean z) {
        this.w = z;
        return this;
    }

    public f abn(String str) {
        this.x = str;
        return this;
    }

    public f abo(String str) {
        this.y = str;
        return this;
    }

    public f jh(long j) {
        this.z = j;
        return this;
    }

    public f Rl(int i) {
        this.B = i;
        return this;
    }

    public f Rm(int i) {
        this.C = i;
        return this;
    }

    public f Cd(boolean z) {
        this.D = z;
        return this;
    }

    public f abp(String str) {
        this.E = str;
        return this;
    }

    public f Ce(boolean z) {
        this.S = z;
        return this;
    }

    public f Cf(boolean z) {
        this.F = z;
        return this;
    }

    public f Cg(boolean z) {
        this.G = z;
        return this;
    }

    public f Ch(boolean z) {
        this.H = z;
        return this;
    }

    public f Ci(boolean z) {
        this.I = z;
        return this;
    }

    public f Rn(int i) {
        this.K = i;
        return this;
    }

    public f Ro(int i) {
        this.L = i;
        return this;
    }

    public f Cj(boolean z) {
        this.M = z;
        return this;
    }

    public f a(com.ss.android.socialbase.downloader.b.g gVar) {
        this.qfd = gVar;
        return this;
    }

    public f Ck(boolean z) {
        this.A = z;
        return this;
    }

    public f a(ah ahVar) {
        this.qfh = ahVar;
        return this;
    }

    public f abq(String str) {
        this.W = str;
        return this;
    }

    public String W() {
        return this.W;
    }

    public f Rp(int i) {
        this.Y = i;
        return this;
    }

    public List<String> eFX() {
        return this.d;
    }

    public f gW(List<String> list) {
        this.d = list;
        return this;
    }

    public af eFY() {
        return this.qfi;
    }

    public f a(af afVar) {
        this.qfi = afVar;
        return this;
    }

    public JSONObject eFZ() {
        return this.qfk;
    }

    public f fm(JSONObject jSONObject) {
        this.qfk = jSONObject;
        return this;
    }

    public f a(ab abVar) {
        this.qfl = abVar;
        return this;
    }
}
