package d.a.n0.x.b;

import tbclient.ElectionInfo.Basic;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public long f63158a;

    /* renamed from: b  reason: collision with root package name */
    public long f63159b;

    /* renamed from: c  reason: collision with root package name */
    public long f63160c;

    /* renamed from: d  reason: collision with root package name */
    public int f63161d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f63162e;

    /* renamed from: f  reason: collision with root package name */
    public int f63163f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63164g;

    /* renamed from: h  reason: collision with root package name */
    public NoticeContent f63165h;

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
        return this.f63164g;
    }

    public int b() {
        return this.f63163f;
    }

    public long c() {
        return this.f63158a;
    }

    public long d() {
        return this.f63160c;
    }

    public NoticeContent e() {
        return this.f63165h;
    }

    public long f() {
        return this.f63162e;
    }

    public int g() {
        return this.f63161d;
    }

    public long h() {
        return this.f63159b;
    }

    public void k(boolean z) {
        this.f63164g = z;
    }

    public void l(int i2) {
        this.f63163f = i2;
    }

    public void m(long j) {
        this.f63158a = j;
    }

    public void n(long j) {
        this.f63160c = j;
    }

    public void o(NoticeContent noticeContent) {
        this.f63165h = noticeContent;
    }

    public void p(long j) {
        this.f63162e = j;
    }

    public void q(int i2) {
        this.f63161d = i2;
    }

    public void r(int i2) {
    }

    public void s(long j) {
        this.f63159b = j;
    }
}
