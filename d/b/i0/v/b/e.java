package d.b.i0.v.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f62922a;

    /* renamed from: b  reason: collision with root package name */
    public long f62923b;

    /* renamed from: c  reason: collision with root package name */
    public long f62924c;

    /* renamed from: d  reason: collision with root package name */
    public int f62925d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f62926e;

    /* renamed from: f  reason: collision with root package name */
    public int f62927f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62928g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f62929h;

    public static e i(Basic basic) {
        if (basic == null) {
            return null;
        }
        e eVar = new e();
        eVar.p(j(basic.remind_time));
        eVar.q(basic.status.intValue());
        eVar.l(basic.candidate_num.intValue());
        eVar.r(basic.total_vote_num.intValue());
        eVar.m(j(basic.begin_apply_time));
        eVar.s(j(basic.begin_vote_time));
        eVar.n(j(basic.begin_public_time));
        eVar.k(basic.is_voted.booleanValue());
        eVar.o(basic.notice);
        return eVar;
    }

    public static long j(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public boolean a() {
        return this.f62928g;
    }

    public int b() {
        return this.f62927f;
    }

    public long c() {
        return this.f62922a;
    }

    public long d() {
        return this.f62924c;
    }

    public NoticeContent e() {
        return this.f62929h;
    }

    public long f() {
        return this.f62926e;
    }

    public int g() {
        return this.f62925d;
    }

    public long h() {
        return this.f62923b;
    }

    public void k(boolean z) {
        this.f62928g = z;
    }

    public void l(int i) {
        this.f62927f = i;
    }

    public void m(long j) {
        this.f62922a = j;
    }

    public void n(long j) {
        this.f62924c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f62929h = noticeContent;
    }

    public void p(long j) {
        this.f62926e = j;
    }

    public void q(int i) {
        this.f62925d = i;
    }

    public void r(int i) {
    }

    public void s(long j) {
        this.f62923b = j;
    }
}
