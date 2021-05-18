package d.a.k0.v.b;

import tbclient.ElectionList;
import tbclient.Myrecord;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public int f62287a;

    /* renamed from: b  reason: collision with root package name */
    public int f62288b;

    /* renamed from: c  reason: collision with root package name */
    public long f62289c;

    /* renamed from: d  reason: collision with root package name */
    public long f62290d;

    /* renamed from: e  reason: collision with root package name */
    public String f62291e;

    /* renamed from: f  reason: collision with root package name */
    public String f62292f;

    /* renamed from: g  reason: collision with root package name */
    public int f62293g;

    /* renamed from: h  reason: collision with root package name */
    public int f62294h;

    /* renamed from: i  reason: collision with root package name */
    public int f62295i;
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
        this.f62290d = j;
    }

    public void C(long j) {
        this.f62289c = j;
    }

    public void D(int i2) {
        this.f62294h = i2;
    }

    public int a() {
        return this.f62295i;
    }

    public String b() {
        return this.l;
    }

    public int c() {
        return this.f62287a;
    }

    public int d() {
        return this.f62293g;
    }

    public String e() {
        return this.f62292f;
    }

    public int f() {
        return this.n;
    }

    public String g() {
        return this.f62291e;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f62288b;
    }

    public int j() {
        return this.j;
    }

    public long k() {
        return this.f62290d;
    }

    public long l() {
        return this.f62289c;
    }

    public int m() {
        return this.f62294h;
    }

    public boolean n() {
        return this.m;
    }

    public void q(int i2) {
        this.f62295i = i2;
    }

    public void r(String str) {
        this.l = str;
    }

    public void s(int i2) {
        this.f62287a = i2;
    }

    public void t(boolean z) {
        this.m = z;
    }

    public void u(int i2) {
        this.f62293g = i2;
    }

    public void v(String str) {
        this.f62292f = str;
    }

    public void w(int i2) {
        this.n = i2;
    }

    public void x(String str) {
        this.f62291e = str;
    }

    public void y(int i2) {
        this.k = i2;
    }

    public void z(int i2) {
        this.f62288b = i2;
    }
}
