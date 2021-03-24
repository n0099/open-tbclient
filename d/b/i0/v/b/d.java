package d.b.i0.v.b;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f61904a;

    /* renamed from: b  reason: collision with root package name */
    public int f61905b;

    /* renamed from: c  reason: collision with root package name */
    public long f61906c;

    /* renamed from: d  reason: collision with root package name */
    public long f61907d;

    /* renamed from: e  reason: collision with root package name */
    public String f61908e;

    /* renamed from: f  reason: collision with root package name */
    public String f61909f;

    /* renamed from: g  reason: collision with root package name */
    public int f61910g;

    /* renamed from: h  reason: collision with root package name */
    public int f61911h;
    public int i;
    public int j;
    public int k;
    public String l;
    public boolean m = false;
    public int n;

    public static d o(ElectionList electionList) {
        if (electionList == null) {
            return null;
        }
        d dVar = new d();
        dVar.D(electionList.vote_num.intValue());
        dVar.v(electionList.name_show);
        dVar.x(electionList.portrait);
        dVar.u(electionList.forum_level.intValue());
        dVar.r(electionList.apply_declaration);
        dVar.z(electionList.rank.intValue());
        dVar.s(electionList.apply_id.intValue());
        dVar.y(electionList.post_num.intValue());
        dVar.A(electionList.thread_num.intValue());
        dVar.q(electionList.agree_num.intValue());
        dVar.C(electionList.uid.longValue());
        dVar.B(electionList.tid.longValue());
        dVar.t(electionList.is_cheat.intValue() == 1);
        dVar.w(electionList.is_pass_audit.intValue());
        return dVar;
    }

    public static d p(Myrecord myrecord) {
        if (myrecord == null) {
            return null;
        }
        d dVar = new d();
        dVar.D(myrecord.vote_num.intValue());
        dVar.v(myrecord.name_show);
        dVar.x(myrecord.portrait);
        dVar.u(myrecord.forum_level.intValue());
        dVar.r(myrecord.apply_declaration);
        dVar.z(myrecord.rank.intValue());
        dVar.s(myrecord.apply_id.intValue());
        dVar.y(myrecord.post_num.intValue());
        dVar.A(myrecord.thread_num.intValue());
        dVar.q(myrecord.agree_num.intValue());
        dVar.C(myrecord.uid.longValue());
        dVar.B(myrecord.tid.longValue());
        return dVar;
    }

    public void A(int i) {
        this.j = i;
    }

    public void B(long j) {
        this.f61907d = j;
    }

    public void C(long j) {
        this.f61906c = j;
    }

    public void D(int i) {
        this.f61911h = i;
    }

    public int a() {
        return this.i;
    }

    public String b() {
        return this.l;
    }

    public int c() {
        return this.f61904a;
    }

    public int d() {
        return this.f61910g;
    }

    public String e() {
        return this.f61909f;
    }

    public int f() {
        return this.n;
    }

    public String g() {
        return this.f61908e;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f61905b;
    }

    public int j() {
        return this.j;
    }

    public long k() {
        return this.f61907d;
    }

    public long l() {
        return this.f61906c;
    }

    public int m() {
        return this.f61911h;
    }

    public boolean n() {
        return this.m;
    }

    public void q(int i) {
        this.i = i;
    }

    public void r(String str) {
        this.l = str;
    }

    public void s(int i) {
        this.f61904a = i;
    }

    public void t(boolean z) {
        this.m = z;
    }

    public void u(int i) {
        this.f61910g = i;
    }

    public void v(String str) {
        this.f61909f = str;
    }

    public void w(int i) {
        this.n = i;
    }

    public void x(String str) {
        this.f61908e = str;
    }

    public void y(int i) {
        this.k = i;
    }

    public void z(int i) {
        this.f61905b = i;
    }
}
