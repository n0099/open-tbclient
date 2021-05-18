package d.a.k0.v.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f62296a;

    /* renamed from: b  reason: collision with root package name */
    public long f62297b;

    /* renamed from: c  reason: collision with root package name */
    public long f62298c;

    /* renamed from: d  reason: collision with root package name */
    public int f62299d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f62300e;

    /* renamed from: f  reason: collision with root package name */
    public int f62301f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62302g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f62303h;

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
        return this.f62302g;
    }

    public int b() {
        return this.f62301f;
    }

    public long c() {
        return this.f62296a;
    }

    public long d() {
        return this.f62298c;
    }

    public NoticeContent e() {
        return this.f62303h;
    }

    public long f() {
        return this.f62300e;
    }

    public int g() {
        return this.f62299d;
    }

    public long h() {
        return this.f62297b;
    }

    public void k(boolean z) {
        this.f62302g = z;
    }

    public void l(int i2) {
        this.f62301f = i2;
    }

    public void m(long j) {
        this.f62296a = j;
    }

    public void n(long j) {
        this.f62298c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f62303h = noticeContent;
    }

    public void p(long j) {
        this.f62300e = j;
    }

    public void q(int i2) {
        this.f62299d = i2;
    }

    public void r(int i2) {
    }

    public void s(long j) {
        this.f62297b = j;
    }
}
