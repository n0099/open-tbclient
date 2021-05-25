package d.a.n0.x.b;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f63149a;

    /* renamed from: b  reason: collision with root package name */
    public int f63150b;

    /* renamed from: c  reason: collision with root package name */
    public long f63151c;

    /* renamed from: d  reason: collision with root package name */
    public long f63152d;

    /* renamed from: e  reason: collision with root package name */
    public String f63153e;

    /* renamed from: f  reason: collision with root package name */
    public String f63154f;

    /* renamed from: g  reason: collision with root package name */
    public int f63155g;

    /* renamed from: h  reason: collision with root package name */
    public int f63156h;

    /* renamed from: i  reason: collision with root package name */
    public int f63157i;
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
        this.f63152d = j;
    }

    public void C(long j) {
        this.f63151c = j;
    }

    public void D(int i2) {
        this.f63156h = i2;
    }

    public int a() {
        return this.f63157i;
    }

    public String b() {
        return this.l;
    }

    public int c() {
        return this.f63149a;
    }

    public int d() {
        return this.f63155g;
    }

    public String e() {
        return this.f63154f;
    }

    public int f() {
        return this.n;
    }

    public String g() {
        return this.f63153e;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f63150b;
    }

    public int j() {
        return this.j;
    }

    public long k() {
        return this.f63152d;
    }

    public long l() {
        return this.f63151c;
    }

    public int m() {
        return this.f63156h;
    }

    public boolean n() {
        return this.m;
    }

    public void q(int i2) {
        this.f63157i = i2;
    }

    public void r(String str) {
        this.l = str;
    }

    public void s(int i2) {
        this.f63149a = i2;
    }

    public void t(boolean z) {
        this.m = z;
    }

    public void u(int i2) {
        this.f63155g = i2;
    }

    public void v(String str) {
        this.f63154f = str;
    }

    public void w(int i2) {
        this.n = i2;
    }

    public void x(String str) {
        this.f63153e = str;
    }

    public void y(int i2) {
        this.k = i2;
    }

    public void z(int i2) {
        this.f63150b = i2;
    }
}
