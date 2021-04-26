package d.a.j0.v.b;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f61563a;

    /* renamed from: b  reason: collision with root package name */
    public int f61564b;

    /* renamed from: c  reason: collision with root package name */
    public long f61565c;

    /* renamed from: d  reason: collision with root package name */
    public long f61566d;

    /* renamed from: e  reason: collision with root package name */
    public String f61567e;

    /* renamed from: f  reason: collision with root package name */
    public String f61568f;

    /* renamed from: g  reason: collision with root package name */
    public int f61569g;

    /* renamed from: h  reason: collision with root package name */
    public int f61570h;

    /* renamed from: i  reason: collision with root package name */
    public int f61571i;
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

    public void A(int i2) {
        this.j = i2;
    }

    public void B(long j) {
        this.f61566d = j;
    }

    public void C(long j) {
        this.f61565c = j;
    }

    public void D(int i2) {
        this.f61570h = i2;
    }

    public int a() {
        return this.f61571i;
    }

    public String b() {
        return this.l;
    }

    public int c() {
        return this.f61563a;
    }

    public int d() {
        return this.f61569g;
    }

    public String e() {
        return this.f61568f;
    }

    public int f() {
        return this.n;
    }

    public String g() {
        return this.f61567e;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f61564b;
    }

    public int j() {
        return this.j;
    }

    public long k() {
        return this.f61566d;
    }

    public long l() {
        return this.f61565c;
    }

    public int m() {
        return this.f61570h;
    }

    public boolean n() {
        return this.m;
    }

    public void q(int i2) {
        this.f61571i = i2;
    }

    public void r(String str) {
        this.l = str;
    }

    public void s(int i2) {
        this.f61563a = i2;
    }

    public void t(boolean z) {
        this.m = z;
    }

    public void u(int i2) {
        this.f61569g = i2;
    }

    public void v(String str) {
        this.f61568f = str;
    }

    public void w(int i2) {
        this.n = i2;
    }

    public void x(String str) {
        this.f61567e = str;
    }

    public void y(int i2) {
        this.k = i2;
    }

    public void z(int i2) {
        this.f61564b = i2;
    }
}
