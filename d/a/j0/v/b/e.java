package d.a.j0.v.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f61572a;

    /* renamed from: b  reason: collision with root package name */
    public long f61573b;

    /* renamed from: c  reason: collision with root package name */
    public long f61574c;

    /* renamed from: d  reason: collision with root package name */
    public int f61575d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f61576e;

    /* renamed from: f  reason: collision with root package name */
    public int f61577f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f61578g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f61579h;

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
        return this.f61578g;
    }

    public int b() {
        return this.f61577f;
    }

    public long c() {
        return this.f61572a;
    }

    public long d() {
        return this.f61574c;
    }

    public NoticeContent e() {
        return this.f61579h;
    }

    public long f() {
        return this.f61576e;
    }

    public int g() {
        return this.f61575d;
    }

    public long h() {
        return this.f61573b;
    }

    public void k(boolean z) {
        this.f61578g = z;
    }

    public void l(int i2) {
        this.f61577f = i2;
    }

    public void m(long j) {
        this.f61572a = j;
    }

    public void n(long j) {
        this.f61574c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f61579h = noticeContent;
    }

    public void p(long j) {
        this.f61576e = j;
    }

    public void q(int i2) {
        this.f61575d = i2;
    }

    public void r(int i2) {
    }

    public void s(long j) {
        this.f61573b = j;
    }
}
