package d.b.i0.v.b;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f62914a;

    /* renamed from: b  reason: collision with root package name */
    public int f62915b;

    /* renamed from: c  reason: collision with root package name */
    public long f62916c;

    /* renamed from: d  reason: collision with root package name */
    public long f62917d;

    /* renamed from: e  reason: collision with root package name */
    public String f62918e;

    /* renamed from: f  reason: collision with root package name */
    public String f62919f;

    /* renamed from: g  reason: collision with root package name */
    public int f62920g;

    /* renamed from: h  reason: collision with root package name */
    public int f62921h;
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
        this.f62917d = j;
    }

    public void C(long j) {
        this.f62916c = j;
    }

    public void D(int i) {
        this.f62921h = i;
    }

    public int a() {
        return this.i;
    }

    public String b() {
        return this.l;
    }

    public int c() {
        return this.f62914a;
    }

    public int d() {
        return this.f62920g;
    }

    public String e() {
        return this.f62919f;
    }

    public int f() {
        return this.n;
    }

    public String g() {
        return this.f62918e;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f62915b;
    }

    public int j() {
        return this.j;
    }

    public long k() {
        return this.f62917d;
    }

    public long l() {
        return this.f62916c;
    }

    public int m() {
        return this.f62921h;
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
        this.f62914a = i;
    }

    public void t(boolean z) {
        this.m = z;
    }

    public void u(int i) {
        this.f62920g = i;
    }

    public void v(String str) {
        this.f62919f = str;
    }

    public void w(int i) {
        this.n = i;
    }

    public void x(String str) {
        this.f62918e = str;
    }

    public void y(int i) {
        this.k = i;
    }

    public void z(int i) {
        this.f62915b = i;
    }
}
